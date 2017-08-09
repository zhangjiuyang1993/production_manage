package com.zjy.production.controller;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.zjy.production.domain.ProcessMeasureCheck;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.COrderVO;
import com.zjy.production.service.PMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by jiuyangzhang2 on 2017/8/3 0003.
 */
@Controller
@RequestMapping("/p_measure_check")
public class PMeasureCheckController {
    @Autowired
    private PMeasureCheckService pMeasureCheckService;

    @RequestMapping("/get/{orderId}")
    @ResponseBody
    public COrderVO getItemById(@PathVariable String orderId) throws Exception{
        return null;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "p_measure_check_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "p_measure_check_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "p_measure_check_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getList(Integer page,Integer rows,ProcessMeasureCheck processMeasureCheck) throws Exception{
        EUDataGridResult result = pMeasureCheckService.getList(page,rows,processMeasureCheck);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid ProcessMeasureCheck processMeasureCheck, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        result = pMeasureCheckService.insert(processMeasureCheck);
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid ProcessMeasureCheck processMeasureCheck,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return pMeasureCheckService.updateAll(processMeasureCheck);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid ProcessMeasureCheck processMeasureCheck, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return pMeasureCheckService.updateNote(processMeasureCheck);
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = pMeasureCheckService.deleteBatch(ids);
        return result;
    }

    //根据工序计量质检id查找
    @RequestMapping("/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public EUDataGridResult searchOrderByOrderId(Integer page,Integer rows,String searchValue) throws Exception{
        EUDataGridResult result = pMeasureCheckService.searchPMeasureCheckByPMeasureCheckId(page,rows,searchValue);
        return result;
    }
}
