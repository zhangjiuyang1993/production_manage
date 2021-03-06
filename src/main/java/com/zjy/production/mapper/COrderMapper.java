package com.zjy.production.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjy.production.domain.COrder;
import com.zjy.production.domain.COrderExample;
import com.zjy.production.domain.vo.COrderVO;

public interface COrderMapper {

	//扩展的mapper接口方法
	List<COrderVO> find(COrderVO cOrder);
	
	//根据订单id查找订单信息
	List<COrderVO> searchOrderByOrderId(String orderId);
	
	List<COrderVO> searchOrderByCustomName(String customName);
	
	List<COrderVO> searchOrderByProductName(String productName);
	
	int deleteBatch(String[] ids);
	
	int changeStatus(String[] ids);
	
	int updateNote(COrder cOrder);
	
	//逆向工程生成的mapper接口
    int countByExample(COrderExample example);

    int deleteByExample(COrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    List<COrder> selectByExample(COrderExample example);

    COrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByExample(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder cOrder);
}
