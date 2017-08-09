package com.zjy.production.controller;

import com.zjy.production.domain.TechnologyPlan;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.TechnologyPlanService;
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
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {

    @Autowired
    private TechnologyPlanService technologyPlanService;

    @RequestMapping("/get/{technologyPlanId}")
    @ResponseBody
    public TechnologyPlan getItemById(@PathVariable String technologyPlanId) throws Exception{
        TechnologyPlan technologyPlan = technologyPlanService.get(technologyPlanId);
        return technologyPlan;
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find() throws Exception{
        return "technologyPlan_list";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add() throws Exception{
        return "technologyPlan_add";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit() throws Exception{
        return "technology_edit";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<TechnologyPlan> getData() throws Exception{
        List<TechnologyPlan> list = technologyPlanService.find();
        return list;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows,TechnologyPlan technologyPlan) throws Exception{
        EUDataGridResult result = technologyPlanService.getList(page,rows,technologyPlan);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid TechnologyPlan technologyPlan, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(technologyPlanService.get(technologyPlan.getTechnologyPlanId()) != null){
            result = new CustomResult(0,"该工艺计划编号已经存在，请更换工艺计划编号",null);
        }else{
            result = technologyPlanService.insert(technologyPlan);
        }
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid TechnologyPlan technologyPlan,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return technologyPlanService.updateAll(technologyPlan);
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = technologyPlanService.deleteBatch(ids);
        return result;
    }

    //根据工艺计划id查找
    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public EUDataGridResult searchTechnologyPlanByTechnologyPlanId(Integer page,Integer rows,String technologyPlanId) throws Exception{
        EUDataGridResult result = technologyPlanService.searchTechnologyPlanByTechnologyPlanId(page,rows,technologyPlanId);
        return result;
    }

    //根据工艺计划名称查找
    @RequestMapping("/search_technologyPlan_by_technologyPlanName")
    @ResponseBody
    public EUDataGridResult searchTechnologyPlanByTechnologyPlanName(Integer page,Integer rows,String technologyPlanName) throws Exception{
        EUDataGridResult result = technologyPlanService.searchTechnologyPlanByTechnologyPlanName(page,rows,technologyPlanName);
        return result;
    }
}
