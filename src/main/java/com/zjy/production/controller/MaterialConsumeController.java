package com.zjy.production.controller;

import com.zjy.production.domain.MaterialConsume;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.MaterialConsumeVO;
import com.zjy.production.service.MaterialConsumeService;
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
@RequestMapping("/materialConsume")
public class MaterialConsumeController {
    @Autowired
    private MaterialConsumeService materialConsumeService;

    @RequestMapping("/get/{consumeId}")
    @ResponseBody
    public MaterialConsume getItemById(@PathVariable String orderId) throws Exception{
        MaterialConsume materialConsume = materialConsumeService.get(orderId);
        return materialConsume;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<MaterialConsume> getData() throws Exception{
        List<MaterialConsume> list = materialConsumeService.find();
        return list;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "materialConsume_list";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "materialConsume_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "materialConsume_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getList(Integer page, Integer rows, MaterialConsumeVO materialConsume) throws Exception{
        EUDataGridResult result = materialConsumeService.getList(page,rows,materialConsume);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid MaterialConsume materialConsume, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(materialConsumeService.get(materialConsume.getMaterialId()) != null){
            result = new CustomResult(0,"该订单编号已经存在，请更换订单编号",null);
        }else{
            result = materialConsumeService.insert(materialConsume);
        }
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public CustomResult update(@Valid MaterialConsume materialConsume,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialConsumeService.update(materialConsume);
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid MaterialConsume materialConsume,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialConsumeService.updateAll(materialConsume);
    }

    @RequestMapping(value="/update_note")
    @ResponseBody
    public CustomResult updateNote(@Valid MaterialConsume materialConsume,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return materialConsumeService.updateNote(materialConsume);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public CustomResult delete(String id) throws Exception{
        CustomResult result = materialConsumeService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = materialConsumeService.deleteBatch(ids);
        return result;
    }

    //根据客户id查找
    @RequestMapping("/search_materialConsume_by_consumeId")
    @ResponseBody
    public EUDataGridResult searchMaterialConsumeByConsumeId(Integer page,Integer rows,String consumeId) throws Exception{
        EUDataGridResult result = materialConsumeService.searchMaterialConsumeByConsumeId(page,rows,consumeId);
        return result;
    }

    //根据物料id查找
    @RequestMapping("/search_materialConsume_by_materialId")
    @ResponseBody
    public EUDataGridResult searchMaterialConsumeByMaterialId(Integer page,Integer rows,String materialId) throws Exception{
        EUDataGridResult result = materialConsumeService.searchMaterialConsumeByMaterialId(page,rows,materialId);
        return result;
    }

    //根据作业id进行查找
    @RequestMapping("/search_materialConsume_by_workId")
    @ResponseBody
    public EUDataGridResult searchMaterialConsumeByWorkId(Integer page,Integer rows,String workId) throws Exception{
        EUDataGridResult result = materialConsumeService.searchMaterialConsumeByWorkId(page,rows,workId);
        return result;
    }
}
