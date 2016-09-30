package com.jpkc.web.controller.console;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.controller.BaseController;
import com.jpkc.model.TeamResource;
import com.jpkc.service.TeamResourceService;
import com.jpkc.util.DocConverter;
import com.jpkc.util.MD;
import com.jpkc.util.Toolkit;
import com.jpkc.util.VideoConverter;

/**
 * 
 * 资源Controller
 * 
 * @author zhangyi
 * @version 1.0 2015年12月28日
 */
@Controller
@RequestMapping("/console/resource")
public class TeamResourceController extends BaseController {

	private static Log log = LogFactory.getLog(TeamResourceController.class);

	@Resource
	private TeamResourceService teamResourceService;

	/**
	 * 
	 * 列表
	 * 
	 * @param model
	 * @param title
	 * @param resourcesType
	 * @return
	 */
	@RequestMapping("/list")
	public String resourcesList(Model model, HttpServletRequest request) {
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String isconvert = request.getParameter("isconvert");

		model.addAttribute("title", title);
		model.addAttribute("type", type);
		model.addAttribute("isconvert", isconvert);

		if (!Toolkit.length(title, 1, 64)) {
			title = null;
		}

		if (!Toolkit.contains(false, type, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")) {
			type = null;
		}

		if (!Toolkit.contains(false, isconvert, "1", "2")) {
			isconvert = null;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("type", type);
		map.put("isconvert", isconvert);
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));

		Page<TeamResource> pager = teamResourceService.search(map);
		model.addAttribute("pager", pager);

		return "console/team_resource_list";
	}

	/**
	 * 
	 * 保存资源
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, String title, String resourcesType) {
		// 资源类型: 1=电子教案,2=教学课件,3=教学视频,4=教学大纲
		// ,5=实验教学资料,6=学生反馈,7=校内综合评价,8=校外专家评价,9=模拟试题, 10=资料下载, 11=名校专家讲堂

		// 创建你要保存的文件的路径
//		String path = "D://upload//resource//" + Integer.parseInt(resourcesType) + "//" + Toolkit.time() + "//"; win
		String path = "//home//upload//resource//" + Integer.parseInt(resourcesType) + "//" + Toolkit.time() + "//"; // linux
		// 获取该文件的文件名
		String fileName = file.getOriginalFilename();

		String denseName = null;
		try {
			denseName = MD.md5(fileName);
		} catch (Exception e) {
		}

		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		TeamResource teamResource = new TeamResource();
		teamResource.setTitle(title);
		teamResource.setType(Integer.parseInt(resourcesType));
		teamResource.setPath(path + fileName);
		teamResource.setName(fileName);
		try {
			teamResource.setDenseName(denseName);
		} catch (Exception e) {
		}

		if ("9".equals(resourcesType) || "10".equals(resourcesType)) { // 直接下载
			teamResource.setIsconvert(2);
		} else {
			teamResource.setIsconvert(1);
		}
		prepare(teamResource, request.getSession());
		try {
			teamResourceService.save(teamResource);
		} catch (Exception e) {
		}

		return "redirect:/console/resource/list";

	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/del")
	public @ResponseBody Render<Object> delResources(HttpServletRequest request) {
		Render<Object> render = null;

		String ids = request.getParameter("ids"); // ids由逗号和数字组成

		if (Toolkit.isEmpty(ids)) {
			render = new Render<Object>("45001", "操作失败，参数不合法！");
			return render;
		}

		String[] idArr = ids.split(",");
		for (String id : idArr) {
			if (!Pattern.matches("[0-9]+", id)) {
				continue;
			}
			try {
				teamResourceService.delete(Long.parseLong(id));
			} catch (Exception e) {
				render = new Render<Object>("45002", "操作失败，参数不合法！");
				return render;
			}
		}
		render = new Render<Object>("25010", "删除成功");
		return render;
	}

	/**
	 * 转换文件
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/convert")
	public @ResponseBody Render<Object> convert(HttpServletRequest request) {
		Render<Object> render = new Render<Object>();

		String path = request.getParameter("path");
		String id = request.getParameter("id");
		String type = request.getParameter("type");

		if (!Toolkit.isId(id)) {
			log.error("参数不合法,id = " + id);
			render.setCode("45010");
			render.setData("参数不合法");
			return render;
		}

		if (!Toolkit.contains(false, type, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")) {
			log.error("参数不合法,type = " + type);
			render.setCode("45020");
			render.setData("参数不合法");
			return render;
		}

		// 当前是视频
		if ("3".equals(type) || "11".equals(type)) {
			String suffix = path.substring(path.lastIndexOf(".") + 1); // 后缀
			String flvPath = path.replace(suffix, "flv");
			String aviPath = path.replace(suffix, "avi");
			VideoConverter v = new VideoConverter(aviPath);
			try {
				boolean r = v.convert(path, flvPath);
				if (!r) {
					log.error("视频文件转换失败");
					render.setCode("45030");
					render.setData("视频文件转换失败");
					return render;
				}
			} catch (Exception e) {
				log.error("视频文件转换异常，请检查文件格式，联系技术支持！ ", e);
				render.setCode("55010");
				render.setData("文件转换异常，请检查文件格式，联系技术支持！");
				return render;
			}
		} else {
			try {
				DocConverter.convertTo(path);
			} catch (Exception e) {
				log.error("文件转换异常，请检查文件格式，联系技术支持！ ", e);
				render.setCode("55010");
				render.setData("文件转换异常，请检查文件格式，联系技术支持！");
				return render;
			}
		}

		TeamResource teamResource = new TeamResource(Long.parseLong(id));
		teamResource.setIsconvert(2);
		try {
			teamResourceService.save(teamResource);
		} catch (Exception e) {
			log.error("更新状态失败！ ", e);
			render.setCode("55020");
			render.setData("更新状态失败，联系技术支持！");
			return render;
		}

		render.setCode("25010");
		render.setData("文件已经转换成功");
		return render;
	}
}
