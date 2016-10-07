package com.jpkc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jpkc.commons.Render;
import com.jpkc.model.Model;
import com.jpkc.model.SysAdmin;

/**
 * 
 * 异常处理
 * 
 * @author zhangyi
 * @version 1.0 2016/3/13
 */
@Controller
public class BaseController {

	private static Log log = LogFactory.getLog(BaseController.class);

	/**
	 * 
	 * 获取页码
	 * 
	 * @return
	 * 
	 */
	public int getPageNumber(HttpServletRequest request) {

		// 从 request 参数中取 pageNumber
		String pageNumber = request.getParameter("pageNumber");

		if (pageNumber == null) {
			return 0;
		}

		try {
			return Integer.parseInt(pageNumber);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 
	 * 每页大小（显示记录数）
	 * 
	 * @return
	 * 
	 */
	public int getPageSize(HttpServletRequest request) {

		String pageSize = request.getParameter("pageSize");

		if (pageSize == null) {
			return 0;
		}

		try {
			return Integer.parseInt(pageSize);
		} catch (Exception e) {
			return 0;
		}

	}

	public void prepare(Model<Long, String> model, HttpSession session) {

		if (model == null) {
			return;
		}

		// 从Session中获取当前用户
		SysAdmin user = (SysAdmin) session.getAttribute("sysAdmin");
		String name = user == null ? "" : user.getUsername();
		Date date = new Date();

		if (model.getId() == null) {
			model.setCreatedBy(name); // 创建人
			model.setCreatedDate(date); // 创建时间
		}

		model.setLastModifiedBy(name); // 最后更新人
		model.setLastModifiedDate(date); // 最后更新时间

	}

	@ExceptionHandler
	public String exp(HttpServletRequest request, Exception e) {
		log.debug("Service Exception...");
		log.error("Exception：" + e);

		StringBuffer sb = new StringBuffer();
		sb.append("很抱歉，您要访问的资源不存在！").append("<br /><br />");
		sb.append("温馨提示：").append("<br />");
		sb.append("1、请检查您访问的网址是否正确。").append("<br />");
		sb.append("2、如有任何意见或建议，请及时反馈给我们。").append("<br />");

		Render<String> render = new Render<String>();
		render.setCode("45004");
		render.setData(sb.toString());
		request.setAttribute("render", render);

		return "console/render";
	}
}
