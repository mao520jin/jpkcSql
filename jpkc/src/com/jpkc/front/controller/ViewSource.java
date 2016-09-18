package com.jpkc.front.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		String path = request.getParameter("path");
		String type = request.getParameter("type");

		if (path == null) {
			log.info("转换的path：" + path);
			return null;
		}

		String suffix = path.substring(path.lastIndexOf(".") + 1); // 后缀
		String swfPath = path.replace(suffix, "swf");
		swfPath = swfPath.replaceAll("\\\\", "//");
		model.addAttribute("fileName", swfPath);
		log.info("swfPath:" + swfPath);

		String url = "";
		if ("1".equals(type)) {
			url = "/front/jiaoAn";
		}
		if ("2".equals(type)) {
			url = "/front/resourcesDetail";
		}
		if ("4".equals(type)) {
			url = "/front/daGang";
		}
		if ("5".equals(type)) {
			url = "/front/shiYanZiLiao";
		}
		return url;
	}

	/**
	 * 
	 * 浏览media
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/media")
	public String viewMedia(HttpServletRequest request, Model model) {
		String path = request.getParameter("path");
		model.addAttribute("path", path);
		return "/front/mediaDetail";
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
	@RequestMapping("/converMedia")
	public void converMedia(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getParameter("path");
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
