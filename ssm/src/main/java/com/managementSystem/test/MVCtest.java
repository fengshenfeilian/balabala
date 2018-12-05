package com.managementSystem.test;

import com.github.pagehelper.PageInfo;
import com.managementSystem.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/*
 * 使用spring测试模块提供的测试请求功能，测试crud请求的正确性
 * spring4测试需要servlet3.0的支持
 *
 * */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springMVC.xml"})
public class MVCtest {
    //传入springMVC的ioc
    @Autowired
    WebApplicationContext webApplicationContext;
    //虚拟mv，获取到处理结果
    MockMvc mockMvc;

    @Before
    public void initMockMvc(){
       mockMvc =  MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    //mvc接口测试
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/selectUsers").param("pn","1"))
                .andReturn();
        //请求成功以后，请求域中会有pageInfo,取出pageInfo进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
        System.out.println("当前页码"+ pageInfo.getPageNum());
        System.out.println("总页码"+ pageInfo.getPages());
        System.out.println("总记录数"+ pageInfo.getTotal());
        System.out.println("连续显示的页码");
        int[] nums = pageInfo.getNavigatepageNums();
        for(int i:nums){
            System.out.println(" " + i);
        }
        System.out.println("员工数据");
        List<User> list = pageInfo.getList();
        for(User user:list){
            System.out.println("ID,"+ user.getUserId() + "==>Name,"+ user.getUserName() + "==>Password," + user.getPassword() );
        }

    }



    public void testLogin() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/login").param("userId","5")
                .param("password","555"))
                .andReturn();
        MockHttpServletRequest request = result.getRequest();
        String msg = (String)request.getAttribute("message");
        System.out.println(msg);
    }


    public void testAdd() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/selectUsers").param("userId","4")
                .param("roleId","3").param("password","444").param("userName","test")
                .param("email","aaa").param("firstLogin","1"))
                .andReturn();
        MockHttpServletRequest request = result.getRequest();
        String msg = (String)request.getAttribute("addResult");
        System.out.println(msg);
    }

    public void testUpdate() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/user/updateUsers/4")
                .param("email","bbb"))
                .andReturn();
        MockHttpServletRequest request = result.getRequest();
        String msg = (String)request.getAttribute("updateResult");
        System.out.println(msg);
    }



    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/user/deleteUsers/4-5"))
                .andReturn();
        MockHttpServletRequest request = result.getRequest();
        String msg = (String)request.getAttribute("deleteResult");
        System.out.println(msg);
    }

    public void testAddWithJson() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/user/addUsersWithJson").param("userId","4")
                .param("roleId","3").param("password","444").param("userName","test")
                .param("email","aaa").param("firstLogin","1").param("gender","男"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


    public void testUpdateWithJson() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/updateUsersWithJson/3")
                .param("email","bbb"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }




    public void testDeleteWithJson() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/deleteUsersWithJson/4-5"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


}
