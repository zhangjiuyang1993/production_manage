package com.zjy.production.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjy.production.domain.MaterialConsume;
import com.zjy.production.domain.MaterialConsumeExample;
import com.zjy.production.domain.vo.MaterialConsumeVO;

public interface MaterialConsumeMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	int updateNote(MaterialConsume materialConsume);
	
	List<MaterialConsumeVO> find(MaterialConsumeVO materialConsume);
	
	List<MaterialConsumeVO> searchMaterialConsumeByConsumeId(String consumeId);
	
	List<MaterialConsumeVO> searchMaterialConsumeByMaterialId(String materialId);
	
	List<MaterialConsumeVO> searchMaterialConsumeByWorkId(String workId);
	
	//逆向工程生成的mapper接口
    int countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);
}
