package com.zjy.production.controller;

import com.zjy.production.domain.DeviceMaintain;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by jiuyangzhang2 on 2017/8/1 0001.
 */
@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {
    @Autowired
    private DeviceMaintainService deviceMaintainService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getListType(Integer page,Integer rows,DeviceMaintain deviceMaintain) throws Exception{
        EUDataGridResult result = deviceMaintainService.getList(page,rows,deviceMaintain);
        return result;
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "deviceMaintain_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "deviceMaintain_edit";
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(deviceMaintainService.get(deviceMaintain.getDeviceMaintainId()) != null){
            result = new CustomResult(0,"该设备维修编号已经存在，请更换设备维修编号",null);
        }else{
            result = deviceMaintainService.insert(deviceMaintain);
        }
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public CustomResult update(@Valid DeviceMaintain deviceMaintain,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return deviceMaintainService.update(deviceMaintain);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = deviceMaintainService.deleteBatch(ids);
        return result;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid DeviceMaintain deviceMaintain,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return deviceMaintainService.updateNote(deviceMaintain);
    }

    //根据设备维修编号查找
    @RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public EUDataGridResult searchDeviceMaintainByDeviceMaintainId(Integer page,Integer rows,String deviceMaintainId) throws Exception{
        EUDataGridResult result = deviceMaintainService.searchDeviceMaintainByDeviceMaintainId(page,rows,deviceMaintainId);
        return result;
    }

    //根据设备故障编号查找
    @RequestMapping("/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page,Integer rows,String deviceFaultId) throws Exception{
        EUDataGridResult result = deviceMaintainService.searchDeviceMaintainByDeviceFaultId(page,rows,deviceFaultId);
        return result;
    }
}
