package com.zjy.production.controller;

import com.zjy.production.domain.UnqualifyApply;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by jiuyangzhang2 on 2017/8/6 0006.
 */
@Controller
@RequestMapping("/unqualify")
public class UnqualifyApplyController {
    @Autowired
    private UnqualifyService unqualifyService;

    @RequestMapping("/find")
    public String find() throws Exception{
        return "unqualify_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "unqualify_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "unqualify_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows, UnqualifyApply unqualifyApply) throws Exception{
        EUDataGridResult result = unqualifyService.getList(page, rows, unqualifyApply);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid UnqualifyApply unqualifyApply, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(unqualifyService.get(unqualifyApply.getUnqualifyApplyId()) != null){
            result = new CustomResult(0,"该不合格品申请编号已经存在，请更换",null);
        }else{
            result = unqualifyService.insert(unqualifyApply);
        }
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid UnqualifyApply unqualifyApply,BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return unqualifyService.updateAll(unqualifyApply);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid UnqualifyApply unqualifyApply,BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return unqualifyService.updateNote(unqualifyApply);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public CustomResult delete(String id) throws Exception{
        CustomResult result = unqualifyService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = unqualifyService.deleteBatch(ids);
        return result;
    }

    //根据不合格品id查找
    @RequestMapping("/search_unqualify_by_unqualifyId")
    @ResponseBody
    public EUDataGridResult searchUnqualifyByUnqualifyId(Integer page,Integer rows,String unqualifyId) throws Exception{
        EUDataGridResult result = unqualifyService.searchUnqualifyByUnqualifyId(page,rows,unqualifyId);
        return result;
    }

    //根据产品名称查找
    @RequestMapping("/search_unqualify_by_productName")
    @ResponseBody
    public EUDataGridResult searchUnqualifyByProductName(Integer page,Integer rows,String productName) throws Exception{
        EUDataGridResult result = unqualifyService.searchUnqualifyByProductName(page,rows,productName);
        return result;
    }
}
