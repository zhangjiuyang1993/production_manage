package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.UnqualifyApply;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.UnqualifyApplyVO;
import com.zjy.production.mapper.UnqualifyApplyMapper;
import com.zjy.production.service.UnqualifyService;
@Service
public class UnqualifyServiceImpl implements UnqualifyService {

	@Autowired
	private UnqualifyApplyMapper unqualifyApplyMapper;
	@Override
	public EUDataGridResult getList(Integer page, Integer rows, UnqualifyApply unqualifyApply) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<UnqualifyApplyVO> list = unqualifyApplyMapper.find(unqualifyApply);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UnqualifyApplyVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchUnqualifyByUnqualifyId(int page, int rows, String unqualifyId) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<UnqualifyApplyVO> list = unqualifyApplyMapper.searchUnqualifyByUnqualifyId(unqualifyId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UnqualifyApplyVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public UnqualifyApply get(String string) throws Exception {
		return unqualifyApplyMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception {
		int i = unqualifyApplyMapper.deleteByPrimaryKey(string);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = unqualifyApplyMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(UnqualifyApply unqualify) throws Exception {
		int i = unqualifyApplyMapper.insert(unqualify);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增不合格品申请信息失败");
		}
	}

	@Override
	public CustomResult update(UnqualifyApply unqualify) throws Exception {
		int i = unqualifyApplyMapper.updateByPrimaryKeySelective(unqualify);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改不合格品申请信息失败");
		}
	}

	@Override
	public CustomResult updateAll(UnqualifyApply unqualify) throws Exception {
		int i = unqualifyApplyMapper.updateByPrimaryKey(unqualify);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改不合格品申请信息失败");
		}
	}

	@Override
	public CustomResult updateNote(UnqualifyApply unqualify) throws Exception {
		int i = unqualifyApplyMapper.updateNote(unqualify);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改不合格品申请备注失败");
		}
	}

	@Override
	public EUDataGridResult searchUnqualifyByProductName(Integer page, Integer rows, String productName)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<UnqualifyApplyVO> list = unqualifyApplyMapper.searchUnqualifyByProductName(productName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UnqualifyApplyVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
