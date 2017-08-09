package com.zjy.production.service;

import java.util.List;

import com.zjy.production.domain.Process;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;

public interface ProcessService {

	List<Process> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows, Process process) throws Exception;
	
	Process get(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;
	
	CustomResult insert(Process process) throws Exception;
	
	//更新全部字段，不判断非空，直接进行更新
	CustomResult updateAll(Process process) throws Exception;
	
	EUDataGridResult searchProcessByProcessId(Integer page, Integer rows, String processId) throws Exception;
	
	EUDataGridResult searchProcessByTechnologyPlanId(Integer page, Integer rows, String technologyPlanId) throws Exception;
}
