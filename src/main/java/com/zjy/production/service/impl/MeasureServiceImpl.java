package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.FinalMeasuretCheck;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.domain.vo.FinalMeasuretCheckVO;
import com.zjy.production.mapper.FinalMeasuretCheckMapper;
import com.zjy.production.service.MeasureService;
@Service
public class MeasureServiceImpl implements MeasureService {

	@Autowired
	private FinalMeasuretCheckMapper finalMeasuretCheckMapper;
	@Override
	public EUDataGridResult getList(Integer page, Integer rows, FinalMeasuretCheck finalMeasureCheck) throws Exception {
		//分页管理
		PageHelper.startPage(page, rows);
		List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.find(finalMeasureCheck);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public FinalMeasuretCheck get(String string) throws Exception {
		return finalMeasuretCheckMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception {
		int i = finalMeasuretCheckMapper.deleteBatch(ids);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(FinalMeasuretCheck finalMeasuretCheck) throws Exception {
		int i = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增成品计量质检信息失败");
		}
	}

	@Override
	public CustomResult updateAll(FinalMeasuretCheck finalMeasuretCheck) throws Exception {
		int i = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改成品计量质检信息失败");
		}
	}

	@Override
	public CustomResult updateNote(FinalMeasuretCheck finalMeasuretCheck) throws Exception {
		int i = finalMeasuretCheckMapper.updateNote(finalMeasuretCheck);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改成品计量质检备注失败");
		}
	}

	@Override
	public EUDataGridResult searchFMeasureCheckByFMeasureCheckId(int page, int rows, String FMeasureCheckId)
			throws Exception {
		//分页管理
		PageHelper.startPage(page, rows);
		List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.searchFMeasureCheckByFMeasureCheckId(FMeasureCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchFMeasureCheckByOrderId(Integer page, Integer rows, String orderId) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.searchFMeasureCheckByOrderId(orderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
