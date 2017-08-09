package com.zjy.production.controller;

import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.RoleVO;
import com.zjy.production.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jiuyangzhang2 on 2017/8/4 0004.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/get/{roleId}")
    @ResponseBody
    public RoleVO getItemById(@PathVariable String roleId) throws Exception{
        RoleVO sysRole = roleService.get(roleId);
        return sysRole;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "role_list";
    }

    @RequestMapping("/permission")
    public String permission() throws Exception{
        return "role_permission";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<RoleVO> getData() throws Exception{
        return roleService.find();
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "role_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "role_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows,RoleVO role) throws Exception{
        EUDataGridResult result = roleService.getList(page,rows,role);
        return result;
    }


}
