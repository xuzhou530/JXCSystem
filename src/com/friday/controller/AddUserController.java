package com.friday.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.friday.model.User;
import com.friday.service.UserService;
import com.friday.service.impl.UserServiceImpl;

public class AddUserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		try {
			UserService userService = new UserServiceImpl();
			
			String uid = request.getParameter("account");
			String upwd = request.getParameter("password");
			String uname = request.getParameter("name");
			
			User user = new User();
			
			user.setuId(uid);
			user.setuPwd(upwd);
			user.setuName(uname);
			user.setuBz("");
			
			userService.addUser(user);
			
			model.put("result", "success");
			return new ModelAndView("success", model);
		} catch (Exception e) {
			
			model.put("result", "fail");
			e.printStackTrace();
			return new ModelAndView("success", model);
		}
	}

}
