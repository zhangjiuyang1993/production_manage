package com.zjy.production.controller;

import com.zjy.production.domain.DeviceType;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jiuyangzhang2 on 2017/8/1 0001.
 */
@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
    @Autowired
    private DeviceTypeService deviceTypeService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getListType(Integer page,Integer rows,DeviceType deviceType) throws Exception{
        EUDataGridResult result = deviceTypeService.getList(page,rows,deviceType);
        return result;
    }

    @RequestMapping("/get/{orderId}")
    @ResponseBody
    public DeviceType getItemById(@PathVariable String orderId) throws Exception{
        DeviceType deviceType = deviceTypeService.get(orderId);
        return deviceType;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceType> getData() throws Exception{
        List<DeviceType> list = deviceTypeService.find();
        return list;
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "deviceType_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "deviceType_edit";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public CustomResult insert(@Valid DeviceType deviceType, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(deviceTypeService.get(deviceType.getDeviceTypeId()) != null){
            result = new CustomResult(0,"该设备种类编号已经存在，请更换设备种类编号",null);
        }else{
            result = deviceTypeService.insert(deviceType);
        }
        return result;
    }
}
