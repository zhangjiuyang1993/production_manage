package com.zjy.production.service;

import java.util.List;

import com.zjy.production.domain.Device;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;

public interface DeviceService {

	EUDataGridResult getList(int page, int rows, Device device) throws Exception;
	
	List<Device> find() throws Exception;
	
	Device get(String string) throws Exception;
	
	CustomResult insert(Device device) throws Exception;
	
	CustomResult deleteBatch(String[] deviceIds) throws Exception;
	
	CustomResult update(Device device) throws Exception;
	
	CustomResult updateNote(Device device) throws Exception;
	
	//
	CustomResult updateAll(Device device) throws Exception;
	
	EUDataGridResult searchDeviceByDeviceId(Integer page, Integer rows, String deviceId);
	
	EUDataGridResult searchDeviceByDeviceName(Integer page, Integer rows, String deviceName) throws Exception;
	
	EUDataGridResult searchDeviceByDeviceTypeName(Integer page, Integer rows, String deviceTypeName) throws Exception;
	
	
}
