package com.zjy.production.controller;

import com.zjy.production.service.SysService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录和退出
 * Created by jiuyangzhang2 on 2017/8/1 0001.
 */
@Controller
public class LoginController {
    @Autowired
    private SysService sysService;
    /**
     * shiro ajax登录
     */
    @RequestMapping(value="/ajaxLogin")
    public @ResponseBody Map<String,Object> ajaxLogin(@RequestParam String username, @RequestParam String password,
                                                      @RequestParam(required = false) String randomcode, HttpSession session) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        if(randomcode != null && !randomcode.equals("")){
            //取出session中的验证码（正确的验证码）
            String validateCode = (String) session.getAttribute("validateCode");
            //在页面中输入的验证和session中的验证进行比较
            if(validateCode != null && !randomcode.equals(validateCode)){
                //如果校验失败，将验证码错误失败信息放入到map中
                map.put("msg","randomcode_error");
                //直接返回，不用验证账号和密码
                return map;
            }
        }
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                currentUser.login(token);
            }catch (UnknownAccountException e){
                map.put("msg","account_error");
            }catch (IncorrectCredentialsException e){
                map.put("msg","password_error");
            }catch (AuthenticationException e){
                map.put("msg","authentication_error");
            }
        }
        //返回json数据
        return map;
    }
}
