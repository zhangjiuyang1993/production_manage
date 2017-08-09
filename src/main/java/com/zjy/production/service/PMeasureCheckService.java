package com.zjy.production.service;

import com.zjy.production.domain.ProcessMeasureCheck;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;

public interface PMeasureCheckService {

	EUDataGridResult searchPMeasureCheckByPMeasureCheckId(int page, int rows, String pMeasureCheckId) throws Exception;
	
	EUDataGridResult getList(int page, int rows, ProcessMeasureCheck processMeasureCheck) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;
	
	CustomResult insert(ProcessMeasureCheck processMeasureCheck) throws Exception;
	
	CustomResult updateAll(ProcessMeasureCheck processMeasureCheck) throws Exception;
	
	CustomResult updateNote(ProcessMeasureCheck processMeasureCheck) throws Exception;
}
