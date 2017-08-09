package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.Department;
import com.zjy.production.domain.DepartmentExample;
import com.zjy.production.domain.DepartmentExample.Criteria;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.mapper.DepartmentMapper;
import com.zjy.production.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public List<Department> find() throws Exception {
		DepartmentExample example = new DepartmentExample();
		return departmentMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, Department department) throws Exception {
		//查询部门列表
		DepartmentExample example = new DepartmentExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());;
				return result;
	}

	@Override
	public Department get(String string) throws Exception {
		return departmentMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception {
		int i = departmentMapper.deleteByPrimaryKey(string);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = departmentMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Department department) throws Exception {
		int i = departmentMapper.insert(department);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增部门失败");
		}
	}

	@Override
	public CustomResult update(Department department) throws Exception {
		int i = departmentMapper.updateByPrimaryKeySelective(department);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改部门信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Department department) throws Exception {
		int i = departmentMapper.updateByPrimaryKey(department);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改部门信息失败");
		}
	}

	@Override
	public CustomResult updateNote(Department department) throws Exception {
		int i = departmentMapper.updateNote(department);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改部门职责失败");
		}
	}

	@Override
	public List<Department> searchDepartmentByDepartmentId(String departmentId) throws Exception {
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andDepartmentIdLike(departmentId);
		return departmentMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchDepartmentByDepartmentId(Integer page, Integer rows, String departmentId)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.searchDepartmentByDepartmentId(departmentId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());;
		return result;
	}

	@Override
	public EUDataGridResult searchDepartmentByDepartmentName(Integer page, Integer rows, String departmentName)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.searchDepartmentByDepartmentName(departmentName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
