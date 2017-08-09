package com.zjy.production.controller;

import com.zjy.production.domain.Employee;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.EmployeeVO;
import com.zjy.production.service.EmployeeService;
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
 * Created by jiuyangzhang2 on 2017/8/1 0001.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/get/{empId}")
    @ResponseBody
    public EmployeeVO getItemById(@PathVariable String empId) throws Exception{
        EmployeeVO employeeVO = employeeService.get(empId);
        return employeeVO;
    }

    @RequestMapping("/find")
    public String find() throws Exception{
        return "employee_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Employee> getData() throws Exception{
        List<Employee> list = employeeService.find();
        return list;
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "employee_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "employee_edit";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows,EmployeeVO employee) throws Exception{
        EUDataGridResult result = employeeService.getList(page,rows,employee);
        return result;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public CustomResult insert(@Valid Employee employee, BindingResult bindingResult) throws Exception{
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        if(employeeService.get(employee.getEmpId()) != null){
            result = new CustomResult(0,"该员工编号已经存在，请更换员工编号",null);
        }else{
            result = employeeService.insert(employee);
        }
        return result;
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public CustomResult update(@Valid Employee employee,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return employeeService.update(employee);
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    public CustomResult updateAll(@Valid Employee employee,BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100,fieldError.getDefaultMessage());
        }
        return employeeService.updateAll(employee);
    }

    @RequestMapping(value="/delete")
    @ResponseBody
    public CustomResult delete(String id) throws Exception{
        CustomResult result = employeeService.delete(id);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    public CustomResult deleteBatch(String[] ids) throws Exception{
        CustomResult result = employeeService.deleteBatch(ids);
        return result;
    }

    //根据员工id查找
    @RequestMapping("/search_employee_by_employeeId")
    @ResponseBody
    public EUDataGridResult searchEmployeeByEmployeeId(Integer page,Integer rows,String employeeId) throws Exception{
        EUDataGridResult result = employeeService.searchEmployeeByEmployeeId(page,rows,employeeId);
        return result;
    }

    //根据员工姓名查找
    @RequestMapping("/search_employee_by_employeeName")
    @ResponseBody
    public EUDataGridResult searchEmployeeByEmployeeName(Integer page,Integer rows,String employeeName) throws Exception{
        EUDataGridResult result = employeeService.searchEmployeeByEmployeeName(page,rows,employeeName);
        return result;
    }

    //根据部门名称查找
    @RequestMapping("/search_employee_by_departmentName")
    @ResponseBody
    public EUDataGridResult searchEmployeeByDepartmentName(Integer page,Integer rows,String departmentName) throws Exception{
        EUDataGridResult result = employeeService.searchEmployeeByDepartmentName(page,rows,departmentName);
        return result;
    }
}
