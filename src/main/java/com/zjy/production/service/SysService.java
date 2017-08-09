package com.zjy.production.service;

import java.util.List;

import com.zjy.production.domain.authority.SysPermission;
import com.zjy.production.domain.authority.SysUser;
import com.zjy.production.domain.customize.ActiveUser;

//认证授权服务接口
public interface SysService {

	/**
	 * 根据用户的身份和密码进行认证，如果认证通过，返回用户身份信息
	 * @param userCode
	 * @param password
	 * @return 用户身份信息ActiveUser
	 * @throws Exception
	 */
	public ActiveUser authenticat(String userCode, String password) throws Exception;
	
	/**
	 * 根据用户id查询用户信息
	 * @param userid
	 * @return 用户信息
	 * @throws Exception
	 */
	public SysUser getSysUserByUserId(String userid) throws Exception;
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return 用户信息
	 * @throws Exception
	 */
	public SysUser getSysUserByName(String username) throws Exception;

	/**
	 * 根据用户id查询权限范围的菜单
	 * @param userid
	 * @return 权限范围的菜单
	 * @throws Exception
	 */
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;

	/**
	 * 根据用户id查询权限范围的url
	 * @param userid
	 * @return 权限范围的url
	 * @throws Exception
	 */
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
