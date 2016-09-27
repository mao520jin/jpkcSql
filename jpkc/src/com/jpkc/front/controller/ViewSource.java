package com.jpkc.front.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpkc.model.TeamResource;
import com.jpkc.service.TeamResourceService;

/**
 * 预览资源controller
 * 
 * @author zhangyi
 * @version 1.0 2016/2/28
 */
@Controller
@RequestMapping("/view")
public class ViewSource {

	private static Log log = LogFactory.getLog(ViewSource.class);

	@Resource
	private TeamResourceService teamResourceService;

	/**
	 * 
	 * 浏览office
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/office")
	public String viewOffice(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		TeamResource resource = null;
		try {
			resource = teamResourceService.select(Long.parseLong(id));
		} catch (Exception e) {
		}
		model.addAttribute("resource", resource);
		String url = "/front/index";
		if (resource == null) {
			return url;
		}

		int type = resource.getType();
		String sType = "";

		if (type == 1) {
			sType = "dzja";
		}

		if (type == 2) {
			sType = "jxkj";
		}

		if (type == 4) {
			sType = "jxdg";
		}

		if (type == 5) {
			sType = "syjx";
		}

		if (type == 6) {
			sType = "xsfk";
		}

		if (type == 7) {
			sType = "xnzhpj";
		}

		if (type == 8) {
			sType = "xwzjpj";
		}
		model.addAttribute("type", sType);

		String path = resource.getPath();

		if (path == null) {
			log.info("转换的path：" + path);
			return url;
		}

		String suffix = path.substring(path.lastIndexOf(".") + 1); // 后缀
		String swfPath = path.replace(suffix, "swf");
		swfPath = swfPath.replaceAll("\\\\", "//");
		model.addAttribute("fileName", swfPath);
		log.info("swfPath:" + swfPath);

		// 1=电子教案,2=教学课件,3=教学视频,4=教学大纲 ,5=实验教学资料,6=学生反馈,7=校内综合评价,8=校外专家评价
		url = "/front/team_resource_office_detail";
		return url;
	}

	/**
	 * 读取本地swf文件
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/convert")
	public void convert(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getParameter("path");
		InputStream is = null;
		OutputStream os = null;

		response.setContentType("application/x-shockwave-flash");

		File file = new File(path);
		try {
			os = response.getOutputStream();
			is = new FileInputStream(file);
			response.addHeader("Content-Length", new Long(file.length()).toString());
			int i = 0;
			byte[] buffer = new byte[1024];
			while ((i = is.read(buffer)) != -1) {
				os.write(buffer, 0, i);
			}
			is.close();
			os.flush();
			os.close();
		} catch (IOException e) {
			log.error("读取异常！", e);
		}
	}

	/**
	 * 读取本地flv文件
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/converMedia/{id}")
	public void converMedia(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		TeamResource resource = null;
		try {
			resource = teamResourceService.select(Long.parseLong(id));
		} catch (Exception e) {

		}

		if (resource == null) {
			return;
		}

		String path = resource.getPath();
		log.info("path: " + path);
		InputStream is = null;
		OutputStream os = null;

		// response.setContentType("application/x-shockwave-flash");

		File file = new File(path);
		try {
			os = response.getOutputStream();
			is = new FileInputStream(file);
			response.addHeader("Content-Length", new Long(file.length()).toString());
			int i = 0;
			byte[] buffer = new byte[1024];
			while ((i = is.read(buffer)) != -1) {
				os.write(buffer, 0, i);
			}
			is.close();
			os.flush();
			os.close();
		} catch (IOException e) {
			log.error("读取异常！", e);
		}
	}
}
