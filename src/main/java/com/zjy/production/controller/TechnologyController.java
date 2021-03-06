package com.zjy.production.controller;

import com.zjy.production.domain.Technology;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.TechnologyService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.INACTIVE;
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
@RequestMapping("/technology")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @RequestMapping("/get/{technologyId}")
    @ResponseBody
    public Technology getItemById(@PathVariable String technologyId) throws Exception{
        Technology technology = technologyService.get(technologyId);
        return technology;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "technology_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "technology_add";
    }

    @RequestMapping("edit")
    public String edit() throws Exception{
        return "technology_edit";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> getData() throws Exception{
        List<Technology> list = technologyService.find();
        return list;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows,Technology technology) throws Exception{
        EUDataGridResult result = technologyService.getList(page,rows,technology);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid Technology technology, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(technologyService.get(technology.getTechnologyId()) != null){
            result = new CustomResult(0,"该工艺编号已经存在，请更换工艺编号",null);
        }else{
            result = technologyService.insert(technology);
        }
        return result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid Technology technology,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return technologyService.updateAll(technology);
    }

    @RequestMapping(value="/delete_all")
    @ResponseBody
    public CustomResult deleteAll(String[] ids) throws Exception{
        CustomResult result = technologyService.deleteBatch(ids);
        return result;
    }

    //根据工艺id查找
    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public EUDataGridResult searchTechnologyByTechnologyId(Integer page,Integer rows,String technologyId) throws Exception{
        EUDataGridResult result = technologyService.searchTechnologyByTechnologyId(page,rows,technologyId);
        return result;
    }

    //根据工艺名称查找
    @RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public EUDataGridResult searchTechnologyByTechnologyName(Integer page,Integer rows,String technologyName) throws Exception{
        EUDataGridResult result = technologyService.searchTechnologyByTechnologyName(page,rows,technologyName);
        return result;
    }

}
