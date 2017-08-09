package com.zjy.production.service;

import java.util.List;

import com.zjy.production.domain.Work;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.WorkVO;

public interface WorkService {

	List<Work> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows, WorkVO work) throws Exception;
	
	Work get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;
	
	CustomResult insert(Work work) throws Exception;
	
	//更新全部字段，不判断非空，直接进行更新
	CustomResult updateAll(Work work) throws Exception;
	
	CustomResult update(Work work) throws Exception;
	
	EUDataGridResult searchWorkByWorkId(Integer page, Integer rows,
                                        String workId) throws Exception;

	EUDataGridResult searchWorkByWorkProduct(Integer page, Integer rows,
                                             String workProduct) throws Exception;

	EUDataGridResult searchWorkByWorkDevice(Integer page, Integer rows,
                                            String workDevice) throws Exception;

	EUDataGridResult searchWorkByWorkProcess(Integer page, Integer rows,
                                             String workProcess) throws Exception;
}
