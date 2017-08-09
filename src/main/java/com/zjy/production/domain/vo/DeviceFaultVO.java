package com.zjy.production.domain.vo;

import com.zjy.production.domain.DeviceFault;

public class DeviceFaultVO extends DeviceFault {
	private String deviceName;
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}
