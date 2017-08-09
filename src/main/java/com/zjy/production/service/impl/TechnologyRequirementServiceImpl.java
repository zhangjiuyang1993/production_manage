package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.Technology;
import com.zjy.production.domain.TechnologyExample;
import com.zjy.production.domain.TechnologyRequirement;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.TechnologyRequirementVO;
import com.zjy.production.mapper.TechnologyMapper;
import com.zjy.production.mapper.TechnologyRequirementMapper;
import com.zjy.production.service.TechnologyRequirementService;
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

	@Autowired
	private TechnologyMapper technologyMapper;
	@Autowired
	private TechnologyRequirementMapper technologyRequirementMapper;
	@Override
	public List<Technology> find() throws Exception {
		TechnologyExample example = new TechnologyExample();
		return technologyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, TechnologyRequirement technologyRequirement) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyRequirementVO> list = technologyRequirementMapper.find(technologyRequirement);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TechnologyRequirement get(String string) throws Exception {
		return technologyRequirementMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = technologyRequirementMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(TechnologyRequirement technologyRequirement) throws Exception {
		int i = technologyRequirementMapper.insert(technologyRequirement);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增工艺要求信息失败");
		}
	}

	@Override
	public CustomResult updateAll(TechnologyRequirement technologyRequirement) throws Exception {
		int i = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工艺要求信息失败");
		}
	}

	@Override
	public CustomResult updateRequirement(TechnologyRequirement technologyRequirement) throws Exception {
		int i = technologyRequirementMapper.updateRequirement(technologyRequirement);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工艺要求失败");
		}
	}

	@Override
	public EUDataGridResult searchTechnologyRequirementByTechnologyRequirementId(Integer page, Integer rows,
			String technologyRequirementId) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyRequirementVO> list = technologyRequirementMapper
				.searchTechnologyRequirementByTechnologyRequirementId(technologyRequirementId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTechnologyRequirementByTechnologyName(Integer page, Integer rows,
			String technologyName) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyRequirementVO> list = technologyRequirementMapper
				.searchTechnologyRequirementByTechnologyName(technologyName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
