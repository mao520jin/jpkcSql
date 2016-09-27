package com.jpkc.front.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpkc.commons.Page;
import com.jpkc.controller.BaseController;
import com.jpkc.model.TeamResource;
import com.jpkc.service.TeamResourceService;
import com.jpkc.util.Toolkit;

/**
 * 
 * 前端Resources
 * 
 * @author zhangyi
 * @version 1.0 2016年3月3日
 */
@Controller
@RequestMapping("/front/resource")
public class ResourcesController extends BaseController {

	@Resource
	private TeamResourceService teamResourceService;

	/**
	 * 资源首页
	 *
	 * @return
	 */
	@RequestMapping("/list")
	public String resourcesList(HttpServletRequest request, String type, Model model) {

		/**
		 * 1=电子教案,2=教学课件,3=教学视频,4=教学大纲</br>
		 * 5=实验教学资料,6=学生反馈,7=校内综合评价,8=校外专家评价</br>
		 * 9=模拟试题, 10=资料下载, 11=名校专家讲堂</br>
		 */

		if (!Toolkit.contains(false, type, "dzja", "jxkj", "jxsp", "jxdg", "syjx", "xsfk", "xnzhpj", "xwzjpj", "mnst", "zlxz", "mxzjjt")) {
			return "/front/index";
		}

		int t = 0;
		String url = "/front/index";

		if ("dzja".equalsIgnoreCase(type)) {
			t = 1;
			url = "/front/team_resource_dzja_list";
		}

		// 教学课件
		if ("jxkj".equalsIgnoreCase(type)) {
			t = 2;
			url = "/front/team_resource_jxkj_list";
		}

		// 教学视频
		if ("jxsp".equalsIgnoreCase(type)) {
			t = 3;
			url = "/front/team_resource_jxsp_list";
		}

		// 教学大纲
		if ("jxdg".equalsIgnoreCase(type)) {
			t = 4;
			url = "/front/team_resource_jxdg_list";
		}

		// 实验教学资料
		if ("syjx".equalsIgnoreCase(type)) {
			t = 5;
			url = "/front/team_resource_syjx_list";
		}

		// 学生反馈
		if ("xsfk".equalsIgnoreCase(type)) {
			t = 6;
			url = "/front/team_resource_xsfk_list";
		}

		// 校内综合评价
		if ("xnzhpj".equalsIgnoreCase(type)) {
			t = 7;
			url = "/front/team_resource_xnzhpj_list";
		}

		// 校外专家评价
		if ("xwzjpj".equalsIgnoreCase(type)) {
			t = 8;
			url = "/front/team_resource_xwzjpj_list";
		}

		// 模拟试题
		if ("mnst".equalsIgnoreCase(type)) {
			t = 9;
			url = "/front/team_resource_mnst_list";
		}

		// 资料下载
		if ("zlxz".equalsIgnoreCase(type)) {
			t = 10;
			url = "/front/team_resource_zlxz_list";
		}

		// 名校专家讲堂
		if ("mxzjjt".equalsIgnoreCase(type)) {
			t = 11;
			url = "/front/team_resource_mxzjjt_list";
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));
		map.put("isconvert", 2); // 已转换
		map.put("type", t); // 已转换

		Page<TeamResource> pager = teamResourceService.search(map);
		model.addAttribute("pager", pager);

		return url;
	}

	/**
	 * 详细
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/detail/{id}")
	public String noticeDetail(@PathVariable String id, Model model) {
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

		/**
		 * 1=电子教案,2=教学课件,3=教学视频,4=教学大纲</br>
		 * 5=实验教学资料,6=学生反馈,7=校内综合评价,8=校外专家评价</br>
		 * 9=模拟试题, 10=资料下载, 11=名校专家讲堂</br>
		 */
		if (type == 3 || type == 11) {
			url = "/front/team_resource_flv_detail";
		} else {
			url = "/front/team_resource_office_detail";
		}

		return url;
	}

	@RequestMapping("/download/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		TeamResource resource = null;
		try {
			resource = teamResourceService.select(Long.parseLong(id));
		} catch (Exception e) {

		}
		if (resource == null) {
			return;
		}

		String name = resource.getName();
		try {
			name = new String(name.getBytes("gb2312"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String path = resource.getPath();

		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		response.setContentType("multipart/form-data");
		// 2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
		response.setHeader("Content-Disposition", "attachment;fileName=" + name);
		OutputStream out;
		try {
			FileInputStream is = new FileInputStream(path);

			// 3.通过response获取ServletOutputStream对象(out)
			out = response.getOutputStream();

			int b = 0;
			byte[] buffer = new byte[1024];
			while (b != -1) {
				b = is.read(buffer);
				// 4.写到输出流(out)中
				out.write(buffer, 0, b);
			}
			is.close();
			out.close();
			out.flush();
		} catch (Exception e) {
		}
	}

}
