package com.zjy.production.controller;

import com.zjy.production.domain.Material;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.MaterialService;
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
 * Created by jiuyangzhang2 on 2017/8/2 0002.
 */
@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @RequestMapping("/get/{materialId}")
    @ResponseBody
    public Material getItemById(@PathVariable String materialId) throws Exception{
        Material material = materialService.get(materialId);
        return material;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "material_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "material_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "material_edit";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Material> getData() throws Exception{
        return materialService.find();
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows,Material material) throws Exception{
        EUDataGridResult result = materialService.getList(page,rows,material);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid Material material, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(materialService.get(material.getMaterialId()) != null){
            result = new CustomResult(0,"该物料编号已经存在，请更换物料编号",null);
        }else{
            result = materialService.insert(material);
        }
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public CustomResult update(@Valid Material material,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialService.update(material);
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid Material material,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialService.updateAll(material);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid Material material,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialService.updateNote(material);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public CustomResult delete(String id) throws Exception{
        CustomResult result = materialService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = materialService.deleteBatch(ids);
        return result;
    }

    //根据物料id查找
    @RequestMapping("/search_material_by_materialId")
    @ResponseBody
    public EUDataGridResult searchMaterialByMaterialId(Integer page,Integer rows,String materialId) throws Exception{
        EUDataGridResult result = materialService.searchMaterialByMaterialId(page,rows,materialId);
        return result;
    }

    //根据物料类型查找
    @RequestMapping("/search_material_by_materialType")
    @ResponseBody
    public EUDataGridResult searchMaterialByMaterialType(Integer page,Integer rows,String materialType) throws Exception{
        EUDataGridResult result = materialService.searchMaterialByMaterialType(page,rows,materialType);
        return result;
    }


}
