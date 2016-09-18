package com.jpkc.web.controller.console;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@SuppressWarnings("deprecation")
	@RequestMapping("/upload")
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			// 定义允许上传的文件扩展名
			HashMap<String, String> extMap = new HashMap<String, String>();
			extMap.put("image", "gif,jpg,jpeg,png,bmp");
			extMap.put("flash", "swf,flv");
			extMap.put("media", "swf");// 部分格式在播放时提示需要安装插件，所以暂时注释了。
			extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,mp4,rmvb");
			extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

			// 最大文件大小
			long maxSize = 1000000000;

			response.setContentType("text/html; charset=UTF-8");
			if (!ServletFileUpload.isMultipartContent(request)) {
				out.println(getError("请选择文件。"));
				return;
			}
			String dirName = request.getParameter("dir");
			if (dirName == null) {
				dirName = "image";
			}
			if (!extMap.containsKey(dirName)) {
				out.println(getError("目录名不正确。"));
				return;
			}
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
			@SuppressWarnings("rawtypes")
			Iterator itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				String fileName = item.getName();
				if (!item.isFormField()) {
					// 检查文件大小
					if (item.getSize() > maxSize) {
						out.println(getError("上传文件大小超过限制。"));
						return;
					}
					// 检查扩展名
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					if (!Arrays.<String> asList(extMap.get(dirName).split(",")).contains(fileExt)) {
						out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
						return;
					}

					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
					String path = "d://" + dirName + "//" + df.format(new Date()) + "//";
					File f = new File(path);
					if (!f.isDirectory()) {
						f.mkdirs();
					}
					try {
						File uploadedFile = new File(path, newFileName);
						item.write(uploadedFile);
					} catch (Exception e) {
						out.println(getError("上传文件失败。"));
						return;
					}
					String path1 = request.getContextPath();
					String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path1;

					JSONObject obj = new JSONObject();
					obj.put("error", 0);
					if (fileExt.endsWith("gif") || fileExt.endsWith("jpg") || fileExt.endsWith("jpeg") || fileExt.endsWith("png") || fileExt.endsWith("bmp")) {
						obj.put("url", basePath + "/file/view?path=" + path + newFileName);
					} else {
						obj.put("url", path + newFileName);
					}
					out.println(obj.toString());
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

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
