package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.Task;
import com.zjy.production.domain.TaskExample;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.mapper.TaskMapper;
import com.zjy.production.service.TaskService;
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskMapper taskMapper;
	@Override
	public List<Task> find() throws Exception {
		TaskExample example = new TaskExample();
		return taskMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, Task task) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Task> list = taskMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Task get(String string) throws Exception {
		return taskMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception {
		int i = taskMapper.deleteByPrimaryKey(string);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = taskMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Task task) throws Exception {
		int i = taskMapper.insert(task);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增生产派工信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Task task) throws Exception {
		int i = taskMapper.updateByPrimaryKey(task);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改生产派工信息失败");
		}
	}

	@Override
	public CustomResult update(Task task) throws Exception {
		int i = taskMapper.updateByPrimaryKeySelective(task);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改生产派工信息失败");
		}
	}

	@Override
	public EUDataGridResult searchTaskByTaskId(Integer page, Integer rows, String taskId) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Task> list = taskMapper.searchTaskByTaskId(taskId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTaskByTaskWorkId(Integer page, Integer rows, String taskWorkId) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Task> list = taskMapper.searchTaskByTaskWorkId(taskWorkId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTaskByTaskManufactureSn(Integer page, Integer rows, String taskManufactureSn)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Task> list = taskMapper.searchTaskByTaskManufactureSn(taskManufactureSn);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
