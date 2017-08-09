package com.zjy.production.service;

import java.util.List;

import com.zjy.production.domain.TechnologyPlan;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;

public interface TechnologyPlanService {

	List<TechnologyPlan> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows, TechnologyPlan technologyPlan) throws Exception;
	
	TechnologyPlan get(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;
	
	CustomResult insert(TechnologyPlan technologyPlan) throws Exception;
	
	//更新全部字段，不判断非空，直接进行更新
	CustomResult updateAll(TechnologyPlan technologyPlan) throws Exception;
	
	EUDataGridResult searchTechnologyPlanByTechnologyPlanId(Integer page, Integer rows, String technologyPlanId) throws Exception;
	
	EUDataGridResult searchTechnologyPlanByTechnologyPlanName(Integer page, Integer rows, String technologyName) throws Exception;
}
