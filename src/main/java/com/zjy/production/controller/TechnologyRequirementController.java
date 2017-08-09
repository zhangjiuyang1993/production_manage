package com.zjy.production.controller;

import com.zjy.production.domain.Technology;
import com.zjy.production.domain.TechnologyRequirement;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.TechnologyRequirementVO;
import com.zjy.production.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jiuyangzhang2 on 2017/8/6 0006.
 */
@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    private TechnologyRequirementService technologyRequirementService;

    @RequestMapping("/get/{technologyRequirementId}")
    @ResponseBody
    public TechnologyRequirement getItemById(@PathVariable String technologyRequirementId) throws Exception{
        TechnologyRequirement technologyRequirement = technologyRequirementService.get(technologyRequirementId);
        return technologyRequirement;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "technologyRequirement_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "technologyRequirement_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "technologyRequirement_edit";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getData() throws Exception{
        List<Technology> list = technologyRequirementService.find();
        return list;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows, TechnologyRequirementVO technologyRequirementVO) throws Exception{
        EUDataGridResult result = technologyRequirementService.getList(page,rows,technologyRequirementVO);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(technologyRequirementService.get(technologyRequirement.getTechnologyRequirementId()) != null){
            result = new CustomResult(0,"该工艺计划编号已经存在，请更换工艺计划编号",null);
        }else{
            result = technologyRequirementService.insert(technologyRequirement);
        }
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid TechnologyRequirement technologyRequirement,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return technologyRequirementService.updateAll(technologyRequirement);
    }

    @RequestMapping(value="/update_requirement")
    @ResponseBody
    public CustomResult updateNote(@Valid TechnologyRequirement technologyRequirement,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return technologyRequirementService.updateRequirement(technologyRequirement);
    }

    //根据工艺要求id查找
    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public EUDataGridResult searchTechnologyRequirementByTechnologyRequirementId(Integer page,Integer rows,String technologyRequirementId) throws Exception {
        EUDataGridResult result = technologyRequirementService.searchTechnologyRequirementByTechnologyRequirementId(page, rows, technologyRequirementId);
        return result;
    }

    //根据工艺名称查找
    @RequestMapping("/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public EUDataGridResult searchTechnologyRequirementByTechnologyName(Integer page,Integer rows,String technologyName) throws Exception{
        EUDataGridResult result = technologyRequirementService.searchTechnologyRequirementByTechnologyName(page,rows,technologyName);
        return result;
    }
}


