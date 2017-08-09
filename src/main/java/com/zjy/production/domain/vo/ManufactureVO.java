package com.zjy.production.domain.vo;

import java.util.Date;

import com.zjy.production.domain.COrder;
import com.zjy.production.domain.Technology;

public class ManufactureVO {

	private String manufactureSn;
	
	private Integer launchQuantity;
	
	private Date beginDate;
	
	private Date endDate;
	
	private COrder cOrder;
	
	private Technology technology;
	
	public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn == null ? null : manufactureSn.trim();
    }

    public Integer getLaunchQuantity() {
        return launchQuantity;
    }

    public void setLaunchQuantity(Integer launchQuantity) {
        this.launchQuantity = launchQuantity;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

	public COrder getcOrder() {
		return cOrder;
	}

	public void setcOrder(COrder cOrder) {
		this.cOrder = cOrder;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
}