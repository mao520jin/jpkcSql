package com.jpkc.web.controller.console;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jpkc.util.Toolkit;

import net.sf.json.JSONObject;

/**
 * 
 * 文件上传查看
 * 
 * @author zhangyi
 * @version 1.0 2016年2月27日
 */
@Controller
@RequestMapping("/file")
public class FileController {

	// 允许上传文件后缀MAP数组
	private static final HashMap<String, String> extMap = new HashMap<String, String>();

	// 允许上传文件大小MAP数组
	private static final HashMap<String, Long> sizeMap = new HashMap<String, Long>();

	// 文件目录名称
	private String fileDir;

	// 文件后缀名称
	private String fileExt;

	static {
		// 初始后缀名称MAP数组
		extMap.put("image", "gif,jpg,jpeg,png,bmp,GIF,JPG,JPEG,PNG,BMP");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,txt,zip,rar");
		// 初始文件大小MAP数组
		sizeMap.put("image", 10 * 1024 * 1024l);
		sizeMap.put("flash", 30 * 1024 * 1024 * 1024l);
		sizeMap.put("media", 30 * 1024 * 1024 * 1024l);
		sizeMap.put("file", 10 * 1024 * 1024 * 1024l);
	}

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

		String suffix = path.substring(path.lastIndexOf(".") + 1);
		File file = new File(path);
		try {
			BufferedImage bi = ImageIO.read(file);
			ImageIO.write(bi, suffix, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 文件上传
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/upload")
	public void upload(String dir, MultipartFile imgFile, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (Exception e) {
		}

		JSONObject obj = new JSONObject();
		obj.put("error", 0); // 成功

		fileDir = dir;
		if (null == dir || dir.isEmpty()) {
			fileDir = "file";
		}

		// 检查是否有上传文件
		if (null == imgFile) {
			obj.put("error", 1);
			obj.put("message", "请选择上传文件.");
			out.println(obj.toString());
			return;
		}

		// 检查目录名称是否正确
		if (!extMap.containsKey(fileDir)) {
			obj.put("error", 1);
			obj.put("message", "目录名不正确,请检查.");
			out.println(obj.toString());
			return;
		}

		fileExt = FilenameUtils.getExtension(imgFile.getOriginalFilename());
		// 检查上传文件类型
		if (!Arrays.<String>asList(extMap.get(fileDir).split(",")).contains(fileExt)) {
			obj.put("error", 1);
			obj.put("message", "上传文件的格式被拒绝,\n只允许" + extMap.get(fileDir) + "格式的文件.");
			out.println(obj.toString());
			return;
		}

		// 检查上传文件的大小
		long maxSize = sizeMap.get(fileDir);
		if (imgFile.getSize() > maxSize) {
			obj.put("error", 1);
			String size = null;
			if (maxSize < 1024) {
				size = maxSize + "B";
			}
			if (maxSize > 1024 && maxSize < 1024 * 1024) {
				size = maxSize / 1024 + "KB";
			}
			if (maxSize > 1024 * 1024) {
				size = maxSize / (1024 * 1024) + "MB";
			}
			obj.put("message", "上传文件大小超过限制,只允\n许上传小于 " + size + " 的文件.");
			out.println(obj.toString());
			return;
		}

		// 创建你要保存的文件的路径
		String path = "D://" + fileDir + "//" + Toolkit.time() + "//";

		// 获取该文件的文件名
		String fileName = imgFile.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			imgFile.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		obj.put("url", basePath + "/file/view?path=" + path + fileName);
		out.println(obj.toString());

	}

	/**
	 * 封住返回参数
	 * 
	 * @param message
	 * @return
	 */
	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toString();
	}
}
