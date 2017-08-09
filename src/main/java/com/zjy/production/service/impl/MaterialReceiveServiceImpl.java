package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.MaterialReceive;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.MaterialReceiveVO;
import com.zjy.production.mapper.MaterialReceiveMapper;
import com.zjy.production.service.MaterialReceiveService;
@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

	@Autowired
	private MaterialReceiveMapper materialReceiveMapper;
	@Override
	public EUDataGridResult getList(int page, int rows) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceiveVO> list = materialReceiveMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceiveVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public MaterialReceive get(String string) throws Exception {
		return materialReceiveMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception {
		int i = materialReceiveMapper.deleteByPrimaryKey(string);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = materialReceiveMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(MaterialReceive materialReceive) throws Exception {
		int i = materialReceiveMapper.insert(materialReceive);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增物料收入信息失败");
		}
	}

	@Override
	public CustomResult update(MaterialReceive materialReceive) throws Exception {
		int i = materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料收入信息失败");
		}
	}

	@Override
	public CustomResult updateAll(MaterialReceive materialReceive) throws Exception {
		int i = materialReceiveMapper.updateByPrimaryKey(materialReceive);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料收入信息失败");
		}
	}

	@Override
	public CustomResult updateNote(MaterialReceive materialReceive) throws Exception {
		int i = materialReceiveMapper.updateNote(materialReceive);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料收入备注失败");
		}
	}

	@Override
	public EUDataGridResult searchMaterialReceiveByReceiveId(int page, int rows, String receiveId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceiveVO> list = materialReceiveMapper.searchMaterialReceiveByReceiveId(receiveId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceiveVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchMaterialReceiveByMaterialId(int page, int rows, String materialId) throws Exception {
		//分页管理
		PageHelper.startPage(page, rows);
		List<MaterialReceiveVO> list = materialReceiveMapper.searchMaterialReceiveByMaterialId(materialId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceiveVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
