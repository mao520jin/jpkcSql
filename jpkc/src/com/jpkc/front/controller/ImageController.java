package com.jpkc.front.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 图片上传查看
 * 
 * @author zhangyi
 * @version 1.0 2016年2月27日
 */
@Controller
@RequestMapping("/image/")
public class ImageController {

	private static Log log = LogFactory.getLog(ImageController.class);

	/**
	 * 
	 * 文件查看
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/view")
	public void view(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getParameter("path");

		log.info("path:" + path);
		
		try {
			path = new String(path.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			log.error("获取读取图片response异常", e);
			return;
		}

		String suffix = path.substring(path.lastIndexOf(".") + 1);
		File file = new File(path);
		try {
			BufferedImage bi = ImageIO.read(file);
			ImageIO.write(bi, suffix, response.getOutputStream());
		} catch (Exception e) {
			log.error("返回图片异常", e);
			return;
		}
	}

}
