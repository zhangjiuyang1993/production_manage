package com.zjy.production.controller;

import com.zjy.production.domain.Task;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.service.TaskService;
import org.omg.CORBA.PUBLIC_MEMBER;
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
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/get/{empId}")
    @ResponseBody
    public Task getItemById(@PathVariable String empId) throws Exception{
        Task task = taskService.get(empId);
        return task;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "task_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Task> getData() throws Exception{
        List<Task> list = taskService.find();
        return list;
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "task_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "task_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows,Task task) throws Exception{
        EUDataGridResult result = taskService.getList(page,rows,task);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid Task task, BindingResult bindingResult) throws Exception{
        CustomResult result ;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(taskService.get(task.getTaskId()) != null){
            result = new CustomResult(0,"该生产派工编号已经存在，请更换生产派工编号",null);
        }else{
            result = taskService.insert(task);
        }
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public CustomResult update(@Valid Task task,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return taskService.update(task);
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid Task task,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return taskService.updateAll(task);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public CustomResult delete(String id) throws Exception{
        CustomResult result = taskService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = taskService.deleteBatch(ids);
        return result;
    }

    //根据生产派工id查找
    @RequestMapping("/search_task_by_taskId")
    @ResponseBody
    public EUDataGridResult searchTaskByTaskId(Integer page,Integer rows,String taskId) throws Exception{
        EUDataGridResult result = taskService.searchTaskByTaskId(page,rows,taskId);
        return result;
    }

    //根据作业id查找
    @RequestMapping("/search_task_by_taskWorkId")
    @ResponseBody
    public EUDataGridResult searchTaskByTaskWorkId(Integer page,Integer rows,String taskWorkId) throws Exception{
        EUDataGridResult result = taskService.searchTaskByTaskWorkId(page,rows,taskWorkId);
        return result;
    }

    //根据生产计划id查找
    @RequestMapping("/search_task_by_taskManufactureSn")
    @ResponseBody
    public EUDataGridResult searchTaskByTaskManufactureSn(Integer page,Integer rows,String taskManufactureSn) throws Exception{
        EUDataGridResult result = taskService.searchTaskByTaskManufactureSn(page,rows,taskManufactureSn);
        return result;
    }
}
