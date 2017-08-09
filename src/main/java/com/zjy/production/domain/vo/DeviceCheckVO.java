package com.zjy.production.domain.vo;

import com.zjy.production.domain.DeviceCheck;

public class DeviceCheckVO extends DeviceCheck {
	
	private String deviceName;
	
	private String deviceCheckEmp;
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceCheckEmp() {
		return deviceCheckEmp;
	}

	public void setDeviceCheckEmp(String deviceCheckEmp) {
		this.deviceCheckEmp = deviceCheckEmp;
	}
}
