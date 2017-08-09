package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.FinalCountCheck;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.FinalCountCheckVO;
import com.zjy.production.mapper.FinalCountCheckMapper;
import com.zjy.production.service.FCountCheckService;
@Service
public class FCountCheckServiceImpl implements FCountCheckService {

	@Autowired
	private FinalCountCheckMapper finalCountCheckMapper;
	@Override
	public EUDataGridResult getList(Integer page, Integer rows, FinalCountCheck finalCountCheck) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalCountCheckVO> list = finalCountCheckMapper.find(finalCountCheck);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public FinalCountCheck get(String string) throws Exception {
		return finalCountCheckMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = finalCountCheckMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(FinalCountCheck finalCountCheck) throws Exception {
		int i = finalCountCheckMapper.insert(finalCountCheck);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增成品技术质检信息失败");
		}
	}

	@Override
	public CustomResult updateAll(FinalCountCheck finalCountCheck) throws Exception {
		int i = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改成品计数质检信息失败");
		}
	}

	@Override
	public CustomResult updateNote(FinalCountCheck finalCountCheck) throws Exception {
		int i = finalCountCheckMapper.updateNote(finalCountCheck);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改成品计数质检备注失败");
		}
	}

	@Override
	public EUDataGridResult searchFCountCheckByOrderId(Integer page, Integer rows, String orderId) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalCountCheckVO> list = finalCountCheckMapper.searchFCountCheckByFCountCheckId(orderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
		
	}

	@Override
	public EUDataGridResult searchFCountCheckByFCountCheckId(int page, int rows, String fCountCheckId)
			throws Exception {
		//分页管理
		PageHelper.startPage(page, rows);
		List<FinalCountCheckVO> list = finalCountCheckMapper.searchFCountCheckByFCountCheckId(fCountCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
