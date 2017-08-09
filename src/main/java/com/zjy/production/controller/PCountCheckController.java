package com.zjy.production.controller;

import com.zjy.production.domain.ProcessCountCheck;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.COrderVO;
import com.zjy.production.service.PCountCheckService;
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
@RequestMapping("/p_count_check")
public class PCountCheckController {
    @Autowired
    private PCountCheckService pCountCheckService;

    @RequestMapping("/get/{orderId}")
    @ResponseBody
    public COrderVO getItemById(@PathVariable String orderId) throws Exception{
        return null;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "p_count_check_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "p_count_check_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "p_count_check_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getList(Integer page, Integer rows, ProcessCountCheck processCountCheck) throws Exception{
        EUDataGridResult result = pCountCheckService.getList(page,rows,processCountCheck);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid ProcessCountCheck processCountCheck, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        result = pCountCheckService.insert(processCountCheck);
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public CustomResult update(@Valid ProcessCountCheck processCountCheck,BindingResult bindingResult) throws Exception{
        return null;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid ProcessCountCheck processCountCheck,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return pCountCheckService.updateAll(processCountCheck);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid ProcessCountCheck processCountCheck,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return pCountCheckService.updateNote(processCountCheck);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public CustomResult delete(String id) throws Exception{
        return null;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = pCountCheckService.deleteBatch(ids);
        return result;
    }

    @RequestMapping(value="/change_status")
    @ResponseBody
    public CustomResult changeStatus(String[] ids) throws Exception{
        return null;
    }

    //根据工序计数质检id查找
    @RequestMapping("/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public EUDataGridResult searchPCountCheckByPCountCheckId(Integer page,Integer rows,String pCountCheckId) throws Exception{
        EUDataGridResult result = pCountCheckService.searchPCountCheckByPCountCheckId(page,rows,pCountCheckId);
        return result;
    }
}
