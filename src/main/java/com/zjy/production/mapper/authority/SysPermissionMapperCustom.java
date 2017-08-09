package com.zjy.production.mapper.authority;

import java.util.List;

import com.zjy.production.domain.authority.SysPermission;

public interface SysPermissionMapperCustom {

	//根据用户id查询菜单
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	//根据用户id查询权限url
	public String findPermissionByUserId(String userid) throws Exception;
	
}
