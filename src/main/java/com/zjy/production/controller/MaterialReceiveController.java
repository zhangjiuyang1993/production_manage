package com.zjy.production.controller;

import com.zjy.production.domain.MaterialReceive;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.net.PortUnreachableException;
import java.util.List;

/**
 * Created by jiuyangzhang2 on 2017/8/3 0003.
 */
@Controller
@RequestMapping("/materialReceive")
public class MaterialReceiveController {

    @Autowired
    private MaterialReceiveService materialReceiveService;

    @RequestMapping("/get/{receiveId}")
    @ResponseBody
    public MaterialReceive getItemById(@PathVariable String receiveId) throws Exception{
        MaterialReceive materialReceive = materialReceiveService.get(receiveId);
        return materialReceive;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "materialReceive_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "materialReceive_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "materialReceive_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows) throws Exception{
        EUDataGridResult result = materialReceiveService.getList(page,rows);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid MaterialReceive materialReceive, BindingResult bindingResult) throws Exception{
        CustomResult result ;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(materialReceiveService.get(materialReceive.getMaterialId()) != null){
            result = new CustomResult(0,"该产品编号已经存在，请更换产品编号",null);
        }else{
            result = materialReceiveService.insert(materialReceive);
        }
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public CustomResult update(@Valid MaterialReceive materialReceive,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialReceiveService.update(materialReceive);
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid MaterialReceive materialReceive,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialReceiveService.updateAll(materialReceive);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid MaterialReceive materialReceive,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialReceiveService.updateNote(materialReceive);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public CustomResult delete(String id) throws Exception{
        CustomResult result = materialReceiveService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = materialReceiveService.deleteBatch(ids);
        return result;
    }

    //根据物料接收id查找
    @RequestMapping("/search_materialReceive_by_receiveId")
    @ResponseBody
    public EUDataGridResult searchMaterialReceiveByReceiveId(Integer page,Integer rows,String receiveId) throws Exception{
        EUDataGridResult result = materialReceiveService.searchMaterialReceiveByReceiveId(page,rows,receiveId);
        return result;
    }

    //根据物料id查找
    @RequestMapping("/search_materialReceive_by_materialId")
    @ResponseBody
    public EUDataGridResult searchMaterialReceiveByMaterialId(Integer page,Integer rows,String materialId) throws Exception{
        EUDataGridResult result = materialReceiveService.searchMaterialReceiveByMaterialId(page,rows,materialId);
        return result;
    }
}
