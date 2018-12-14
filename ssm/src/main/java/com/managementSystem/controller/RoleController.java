package com.managementSystem.controller;

import com.managementSystem.pojo.Msg;
import com.managementSystem.pojo.Role;
import com.managementSystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/rolesWithJson")
    @ResponseBody
    public Msg getRoles(){
        List<Role> list = roleService.getRoles();
        return Msg.success("").add("roles",list);
    }

}
