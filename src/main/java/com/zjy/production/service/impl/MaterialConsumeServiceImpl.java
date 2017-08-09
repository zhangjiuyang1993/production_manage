package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.MaterialConsume;
import com.zjy.production.domain.MaterialConsumeExample;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.MaterialConsumeVO;
import com.zjy.production.mapper.MaterialConsumeMapper;
import com.zjy.production.service.MaterialConsumeService;
@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

	@Autowired
	private MaterialConsumeMapper materialConsumeMapper; 
	@Override
	public List<MaterialConsume> find() throws Exception {
		MaterialConsumeExample example = new MaterialConsumeExample();
		return materialConsumeMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, MaterialConsumeVO materialConsume) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.find(materialConsume);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public MaterialConsume get(String string) throws Exception {
		return materialConsumeMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception {
		int i = materialConsumeMapper.deleteByPrimaryKey(string);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = materialConsumeMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(MaterialConsume materialConsume) throws Exception {
		int i = materialConsumeMapper.insert(materialConsume);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增物料消耗信息失败");
		}
	}

	@Override
	public CustomResult update(MaterialConsume materialConsume) throws Exception {
		int i = materialConsumeMapper.updateByPrimaryKeySelective(materialConsume);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料消耗信息失败");
		}
	}

	@Override
	public CustomResult updateAll(MaterialConsume materialConsume) throws Exception {
		int i = materialConsumeMapper.updateByPrimaryKey(materialConsume);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料消耗信息失败");
		}
	}

	@Override
	public CustomResult updateNote(MaterialConsume materialConsume) throws Exception {
		int i = materialConsumeMapper.updateNote(materialConsume);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料消耗备注失败");
		}
	}

	@Override
	public EUDataGridResult searchMaterialConsumeByConsumeId(int page, int rows, String consumeId) throws Exception {
		//分页管理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByConsumeId(consumeId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchMaterialConsumeByMaterialId(int page, int rows, String materialId) throws Exception {
		//分页管理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByMaterialId(materialId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchMaterialConsumeByWorkId(int page, int rows, String workId) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsumeVO> list = materialConsumeMapper.searchMaterialConsumeByWorkId(workId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsumeVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
