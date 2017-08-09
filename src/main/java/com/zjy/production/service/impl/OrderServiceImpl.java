package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.COrder;
import com.zjy.production.domain.COrderExample;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.COrderVO;
import com.zjy.production.mapper.COrderMapper;
import com.zjy.production.service.CustomService;
import com.zjy.production.service.OrderService;
import com.zjy.production.service.ProductService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private COrderMapper cOrderMapper;
	@Autowired
	private CustomService customService;
	@Autowired
	private ProductService productService;
	@Override
	public List<COrder> find() throws Exception {
		COrderExample example = new COrderExample();
		return cOrderMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, COrderVO cOrder) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<COrderVO> list = cOrderMapper.find(cOrder);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<COrderVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public COrder get(String string) throws Exception {
		return cOrderMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception {
		int i = cOrderMapper.deleteByPrimaryKey(string);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = cOrderMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(COrder cOrder) throws Exception {
		int i = cOrderMapper.insert(cOrder);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增订单失败");
		}
	}

	@Override
	public CustomResult update(COrder cOrder) throws Exception {
		int i = cOrderMapper.updateByPrimaryKeySelective(cOrder);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改订单失败");
		}
	}

	@Override
	public CustomResult updateAll(COrder cOrder) throws Exception {
		int i = cOrderMapper.updateByPrimaryKey(cOrder);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改订单失败");
		}
	}

	@Override
	public CustomResult updateNote(COrder cOrder) throws Exception {
		int i = cOrderMapper.updateNote(cOrder);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改订单要求失败");
		}
	}

	@Override
	public CustomResult changeStatus(String[] ids) throws Exception {
		int i = cOrderMapper.changeStatus(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public EUDataGridResult searchOrderByOrderId(int page, int rows, String orderId) throws Exception {
		//分页管理
		PageHelper.startPage(page, rows);
		List<COrderVO> list = cOrderMapper.searchOrderByOrderId(orderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<COrderVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchOrderByCustomName(int page, int rows, String customName) throws Exception {
		//分页管理
		PageHelper.startPage(page, rows);
		List<COrderVO> list = cOrderMapper.searchOrderByCustomName(customName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<COrderVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchOrderByProductName(int page, int rows, String productName) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<COrderVO> list = cOrderMapper.searchOrderByProductName(productName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<COrderVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
