package com.zjy.production.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.production.domain.customize.ActiveUser;

/**
 * 权限判断controller
 * @author Administrator
 *
 */
@Controller
public class AuthorityJudgeController {

	@RequestMapping("*/*_judge")
	@ResponseBody
	public Map<String,Object> authorityJudge(HttpServletRequest request) throws Exception{
		//从shiro的session中获取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		
		//根据url，使用shiro判断相应权限
		String uri = request.getRequestURI();
		String[] names = uri.split("/");
		String featureName = names[2];
		String operateName = names[3].split("_")[0];
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted(featureName + ":" + operateName)){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
}
