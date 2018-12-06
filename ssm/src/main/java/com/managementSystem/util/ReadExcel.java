package com.managementSystem.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.managementSystem.pojo.Student_Course;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.managementSystem.pojo.User;
import com.managementSystem.service.UserService;

public class ReadExcel {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;}
    //获取总列数
    public int getTotalCells() {  return totalCells;}
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }

    @Autowired
    UserService userService;
    /**
     * 验证EXCEL文件
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath){
        if (filePath == null || !(filePath.matches("^.+\\.(?i)(xls)$") || filePath.matches("^.+\\.(?i)(xlsx)$"))){
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    /**
     * 读EXCEL文件，获取客户信息集合
     * @param fileName
     * @return
     */
    public List<User> getExcelInfo(String fileName,MultipartFile Mfile){

        //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
        CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //获取本地存储路径
        File file = new  File("D:\\ruangong");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!file.exists()) file.mkdirs();
        //新建一个文件
        File file1 = new File("D:\\ruangong" + new Date().getTime() + ".xlsx");
        //将上传的文件写入新建的文件中
        try {
            cf.getFileItem().write(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //初始化客户信息的集合
        List<User> UserList=new ArrayList<User>();
        //初始化输入流
        InputStream is = null;
        try{
            //验证文件名是否合格
            if(!validateExcel(fileName)){
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if(fileName.matches("^.+\\.(?i)(xlsx)$")){
                isExcel2003 = false;
            }
            //根据新建的文件实例化输入流
            is = new FileInputStream(file1);
            //根据excel里面的内容读取客户信息
            UserList = getExcelInfo(is, isExcel2003);
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return UserList;
    }
    /**
     * 根据excel里面的内容读取客户信息
     * @param is 输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public  List<User> getExcelInfo(InputStream is,boolean isExcel2003){
        List<User> UserList=null;
        try{
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if(isExcel2003){
                wb = new HSSFWorkbook(is);
            }
            else{//当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            UserList=readExcelValue(wb);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }
        return UserList;
    }
    /**
     * 读取Excel里面客户的信息
     * @param wb
     * @return
     */
    private List<User> readExcelValue(Workbook wb){
        //得到第一个shell
        Sheet sheet=wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows=sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if(totalRows>=1 && sheet.getRow(0) != null){
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
        }

//        List<User> existUsers = userService.getUsers("3");
//        List<String> existID = new ArrayList<>();
//        for(User user : existUsers)
//        {
//            existID.add(user.getUserId());
//        }
        List<User> UserList=new ArrayList<User>();
        User User;
        //循环Excel行数,从第二行开始。标题不入库
        for(int r=1;r<totalRows;r++){
            Row row = sheet.getRow(r);
            if (row == null) continue;
            User = new User();

            //循环Excel的列,添加用户信息
            for(int c = 0; c <this.totalCells; c++){
                Cell cell = row.getCell(c);
                cell.setCellType(CellType.STRING);
                if (null != cell){
                    if(c==0){
                        String id = cell.getStringCellValue();
//                        if(existID.contains(id)) continue;
                        User.setUserId(id);
                    }else if(c==1){
                        String name = cell.getStringCellValue();
                        User.setUserName(name);
                    }else if(c==2){
                        User.setDepartment(cell.getStringCellValue());//客户简称
                    }else if(c==3){
                        User.setMajor(cell.getStringCellValue());//行业
                    }else if(c==4){
                        User.setGender(cell.getStringCellValue());//客户来源
                    }else if(c==5){
                        User.setClasses(cell.getStringCellValue());//地址
                    }else if(c==6){
                        User.setEmail(cell.getStringCellValue());//备注信息
                    }
                }
            }
            User.setPassword(User.getUserId());
            User.setRoleId("3");
            User.setPwdDefault(0);
            //添加客户
            UserList.add(User);
        }
        return UserList;
    }

    /**
     * 读EXCEL文件，获取客户信息集合
     * @param fileName
     * @return
     */
    public List<Student_Course> getDailyScore(String fileName, MultipartFile Mfile){

        //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
        CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //获取本地存储路径
        File file = new  File("D:\\ruangong");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!file.exists()) file.mkdirs();
        //新建一个文件
        File file1 = new File("D:\\ruangong" + new Date().getTime() + ".xlsx");
        //将上传的文件写入新建的文件中
        try {
            cf.getFileItem().write(file1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //初始化客户信息的集合
        List<Student_Course> UserList=new ArrayList<>();
        //初始化输入流
        InputStream is = null;
        try{
            //验证文件名是否合格
            if(!validateExcel(fileName)){
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if(fileName.matches("^.+\\.(?i)(xlsx)$")){
                isExcel2003 = false;
            }
            //根据新建的文件实例化输入流
            is = new FileInputStream(file1);
            //根据excel里面的内容读取客户信息
            UserList = getDailyScore(is, isExcel2003);
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return UserList;
    }
    /**
     * 根据excel里面的内容读取客户信息
     * @param is 输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public  List<Student_Course> getDailyScore(InputStream is,boolean isExcel2003){
        List<Student_Course> UserList=null;
        try{
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if(isExcel2003){
                wb = new HSSFWorkbook(is);
            }
            else{//当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            UserList=readDailyScore(wb);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }
        return UserList;
    }
    /**
     * 读取Excel里面客户的信息
     * @param wb
     * @return
     */
    private List<Student_Course> readDailyScore(Workbook wb){
        //得到第一个shell
        Sheet sheet=wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows=sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if(totalRows>=1 && sheet.getRow(0) != null){
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<Student_Course> UserList=new ArrayList<>();
        Student_Course User;
        //循环Excel行数,从第二行开始。标题不入库
        for(int r=1;r<totalRows;r++){
            Row row = sheet.getRow(r);
            if (row == null) continue;
            User = new Student_Course();

            //循环Excel的列,添加用户信息
            for(int c = 0; c <this.totalCells; c++){
                Cell cell = row.getCell(c);
                cell.setCellType(CellType.STRING);
                if (null != cell){
                    if(c==0){
                        String id = cell.getStringCellValue();
                        User.setStudentId(id);
                    }else if(c==1){
                        String score = cell.getStringCellValue();
                        int grade = Integer.parseInt(score);
                        User.setDailyGrade(grade);
                    }
                }
            }
            //添加客户
            UserList.add(User);
        }
        return UserList;
    }
}
