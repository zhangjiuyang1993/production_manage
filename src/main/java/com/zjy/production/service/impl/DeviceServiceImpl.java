package com.zjy.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.production.domain.Device;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;
import com.zjy.production.mapper.DeviceMapper;
import com.zjy.production.service.DeviceService;
import com.zjy.production.util.JsonUtils;
@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceMapper deviceMapper;
	@Override
	public EUDataGridResult getList(int page, int rows, Device device) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.find(device);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public List<Device> find() throws Exception {
		List<Device> deviceList = deviceMapper.getData();
		return deviceList;
	}

	@Override
	public Device get(String string) throws Exception {
		return deviceMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult insert(Device device) throws Exception {
		int i = deviceMapper.insert(device);
		if(i >= 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增设备信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceIds) throws Exception {
		int i = deviceMapper.deleteBatch(deviceIds);
		if(i >= 0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(Device device) throws Exception {
		System.out.println("device update service");
		System.out.println(device.getNote());
		System.out.println(JsonUtils.objectToJson(device));
		int i = deviceMapper.updateByPrimaryKeySelective(device);
		if(i >= 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备信息失败");
		}
	}

	@Override
	public CustomResult updateNote(Device device) throws Exception {
		int i = deviceMapper.updateNote(device);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备备注失败");
		}
	}

	@Override
	public CustomResult updateAll(Device device) throws Exception {
		int i = deviceMapper.updateByPrimaryKey(device);
		if(i > 0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备信息失败");
		}
	}

	@Override
	public EUDataGridResult searchDeviceByDeviceId(Integer page, Integer rows, String deviceId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.searchDeviceByDeviceId(deviceId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchDeviceByDeviceName(Integer page, Integer rows, String deviceName) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.searchDeviceByDeviceName(deviceName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchDeviceByDeviceTypeName(Integer page, Integer rows, String deviceTypeName)
			throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.searchDeviceByDeviceTypeName(deviceTypeName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
