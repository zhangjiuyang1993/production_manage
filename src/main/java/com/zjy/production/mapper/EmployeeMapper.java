package com.zjy.production.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjy.production.domain.Employee;
import com.zjy.production.domain.EmployeeExample;
import com.zjy.production.domain.vo.EmployeeVO;

public interface EmployeeMapper {

	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	List<EmployeeVO> find();
	
	List<EmployeeVO> searchEmployeeByEmployeeId(String employeeId);
	
	List<EmployeeVO> searchEmployeeByEmployeeName(String employeeName);
	
	List<EmployeeVO> searchEmployeeByDepartmentName(String departmentName);
	
	//逆向工程生成的mapper接口
		EmployeeVO selectSingleEmployee(String empId);
			
	    int countByExample(EmployeeExample example);

	    int deleteByExample(EmployeeExample example);

	    int deleteByPrimaryKey(String empId);

	    int insert(Employee record);

	    int insertSelective(Employee record);

	    List<Employee> selectByExample(EmployeeExample example);

	    Employee selectByPrimaryKey(String empId);

	    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

	    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

	    int updateByPrimaryKeySelective(Employee record);

	    int updateByPrimaryKey(Employee record);
}
