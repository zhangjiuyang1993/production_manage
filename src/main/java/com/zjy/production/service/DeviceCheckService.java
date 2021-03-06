package com.zjy.production.service;

import com.zjy.production.domain.DeviceCheck;
import com.zjy.production.domain.customize.CustomResult;
import com.zjy.production.domain.customize.EUDataGridResult;

public interface DeviceCheckService {

	EUDataGridResult getList(int page, int rows, DeviceCheck deviceCheck) throws Exception;
	
	DeviceCheck get(String string) throws Exception;
	
	CustomResult insert(DeviceCheck deviceCheck) throws Exception;
	
	CustomResult delete(String deviceCheckId) throws Exception;
	
	CustomResult deleteBatch(String[] deviceCheckIds) throws Exception;
	
	CustomResult update(DeviceCheck deviceCheck) throws Exception;
	
	CustomResult updateNote(DeviceCheck deviceCheck) throws Exception;
	
	EUDataGridResult searchDeviceCheckByDeviceCheckId(Integer page, Integer rows, String deviceCheckId) throws Exception;
	
	EUDataGridResult searchDeviceCheckByDeviceName(Integer page, Integer rows, String deviceName) throws Exception;
}
