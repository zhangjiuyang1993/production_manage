package com.zjy.production.service;

import java.util.List;

import com.zjy.production.domain.MaterialConsume;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.MaterialConsumeVO;

public interface MaterialConsumeService {

	List<MaterialConsume> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows, MaterialConsumeVO materialConsume) throws Exception;
	
	MaterialConsume get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;
	
	CustomResult insert(MaterialConsume materialConsume) throws Exception;
	
	//更新部分字段，用的是updateSelective判断非空的字段进行更新
	CustomResult update(MaterialConsume materialConsume) throws Exception;
	
	//更新全部字段，不判断非空，直接进行更新
	CustomResult updateAll(MaterialConsume materialConsume) throws Exception;
	
	CustomResult updateNote(MaterialConsume materialConsume) throws Exception;
	
	EUDataGridResult searchMaterialConsumeByConsumeId(int page, int rows, String consumeId) throws Exception;
	
	EUDataGridResult searchMaterialConsumeByMaterialId(int page, int rows, String materialId) throws Exception;
	
	EUDataGridResult searchMaterialConsumeByWorkId(int page, int rows, String workId) throws Exception;
	
	
}
