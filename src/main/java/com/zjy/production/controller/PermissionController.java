package com.zjy.production.controller;

import com.zjy.production.domain.authority.SysRolePermission;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.PermissionService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jiuyangzhang2 on 2017/8/3 0003.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/get/{permissionId}")
    @ResponseBody
    public SysRolePermission getItemById(@PathVariable String permissionId) throws Exception{
        SysRolePermission sysRolePermission = permissionService.get(permissionId);
        return sysRolePermission;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "permission_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<SysRolePermission> getData() throws Exception{
        return permissionService.find();
    }

    @RequestMapping("/get_permission")
    @ResponseBody
    public SysRolePermission getPermission(String roleId) throws Exception{
        return permissionService.getByRoleId(roleId);
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "permission_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "permission_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows,SysRolePermission sysRolePermission) throws Exception{
        EUDataGridResult result = permissionService.getList(page,rows,sysRolePermission);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(SysRolePermission sysRolePermission) throws Exception{
        CustomResult result = permissionService.insert(sysRolePermission);
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public CustomResult update(SysRolePermission sysRolePermission) throws Exception{
        CustomResult result = permissionService.update(sysRolePermission);
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(SysRolePermission sysRolePermission) throws Exception{
        CustomResult result = permissionService.updateAll(sysRolePermission);
        return result;
    }

    @RequestMapping(value="/update_by_roleid")
    @ResponseBody
    public CustomResult updateByRoleId(String roleId,String permission) throws Exception{
        CustomResult result = permissionService.updateByRoleId(roleId,permission);
        return result;
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public CustomResult delete(String id) throws Exception{
        CustomResult result = permissionService.delete(id);
        return result;
    }
}
