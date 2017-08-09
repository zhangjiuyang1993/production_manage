package com.zjy.production.controller;

import com.zjy.production.domain.FinalCountCheck;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.FCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jiuyangzhang2 on 2017/8/1 0001.
 */
@Controller
@RequestMapping("/f_count_check")
public class FCountCheckController {
    @Autowired
    private FCountCheckService fCountCheckService;

    @InitBinder
    public void InitBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,null,new CustomDateEditor(dateFormat,true));
    }

    @RequestMapping("/get/{finalCountCheckId}")
    @ResponseBody
    public FinalCountCheck getItemById(@PathVariable String finalCountCheckId) throws Exception{
        FinalCountCheck finalCountCheck = fCountCheckService.get(finalCountCheckId);
        return finalCountCheck;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "f_count_check_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "f_count_check_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "f_count_check_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows,FinalCountCheck finalCountCheck) throws Exception{
        EUDataGridResult result = fCountCheckService.getList(page,rows,finalCountCheck);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid FinalCountCheck finalCountCheck,BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(fCountCheckService.get(finalCountCheck.getfCountCheckId()) != null){
            result = new CustomResult(0,"该成品计数质检编号已经存在，请更换编号",null);
        }else{
            result = fCountCheckService.insert(finalCountCheck);
        }
        return result;
    }

    @RequestMapping(value="delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = fCountCheckService.deleteBatch(ids);
        return result;
    }

    //根据成品计数质检id查找
    @RequestMapping("/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public EUDataGridResult searchFCountCheckByFCountCheckId(Integer page,Integer rows,String fCountCheckId) throws Exception{
        EUDataGridResult result = fCountCheckService.searchFCountCheckByFCountCheckId(page,rows,fCountCheckId);
        return result;
    }

    //根据订单id查找
    @RequestMapping("/search_fCountCheck_by_orderId")
    @ResponseBody
    public EUDataGridResult searchFCountCheckByOrderId(Integer page,Integer rows,String orderId) throws Exception{
        EUDataGridResult result = fCountCheckService.searchFCountCheckByOrderId(page,rows,orderId);
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid FinalCountCheck finalCountCheck, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return fCountCheckService.updateAll(finalCountCheck);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid FinalCountCheck finalCountCheck,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return fCountCheckService.updateNote(finalCountCheck);
    }
}
