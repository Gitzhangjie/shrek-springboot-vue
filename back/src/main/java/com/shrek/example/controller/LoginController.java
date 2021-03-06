package com.shrek.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.shrek.example.service.LoginService;
import com.shrek.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hxy
 * @description: 登录相关Controller
 * @date: 2017/10/24 10:33
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param requestJson
     * @return
     */
    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "username,password");
        if("code".equals(requestJson.getString("password"))) {
        	//return null;
        	JSONObject returnJson=loginService.getUserWeb(requestJson.getString("username"));
        	requestJson.put("username", returnJson.getString("username"));
        	requestJson.put("password", returnJson.getString("password"));
        	return loginService.authLogin(requestJson);
        }else if("loginByWorkNo".equals(requestJson.getString("password"))) {
        	JSONObject returnJson=loginService.getUserWeb2(requestJson.getString("username"));
        	requestJson.put("username", returnJson.getString("username"));
        	requestJson.put("password", returnJson.getString("password"));
        	return loginService.authLogin(requestJson);
        }
        else {
        	return loginService.authLogin(requestJson);
        }
    }
    

    /**
     * 查询当前登录用户的信息
     *
     * @return
     */
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        return loginService.getInfo();
    }

    /**
     * 登出
     *
     * @return
     */
    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }
}
