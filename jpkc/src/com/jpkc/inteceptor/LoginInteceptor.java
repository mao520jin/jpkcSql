package com.jpkc.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jpkc.model.User;
import com.jpkc.util.VerifyUtil;

public class LoginInteceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		User user = (User)request.getSession().getAttribute("user");
		if(!VerifyUtil.isEmpty(user)) {
			if(VerifyUtil.isEmpty(user.getUsername()) && VerifyUtil.isEmpty(user.getPassword())) {
				request.setAttribute("errorMsg", "用户已经超时，请重新登录！");
				request.getRequestDispatcher("/views/console/login.jsp").forward(request, response);
				return false;
			}
		}else{
			request.setAttribute("errorMsg", "用户已经超时，请重新登录！");
			request.getRequestDispatcher("/views/console/login.jsp").forward(request, response);
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
}
