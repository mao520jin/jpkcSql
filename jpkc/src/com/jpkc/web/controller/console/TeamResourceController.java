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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.controller.BaseController;
import com.jpkc.model.TeamResource;
import com.jpkc.service.TeamResourceService;
import com.jpkc.util.DocConverter;
import com.jpkc.util.Toolkit;

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

		model.addAttribute("title", title);
		model.addAttribute("type", type);

		if (!Toolkit.length(title, 1, 64)) {
			title = null;
		}

		if (!Toolkit.contains(false, type, "1", "2", "3", "4")) {
			type = null;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("type", type);
		map.put("pageNumber", getPageNumber(request));
		map.put("pageSize", getPageSize(request));

		Page<TeamResource> pager = teamResourceService.search(map);
		model.addAttribute("pager", pager);

		return "console/team_resource_list";
	}

	/**
	 * 分页查询
	 * 
	 * @param model
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	// @RequestMapping("/list/{pageNumber}/{pageSize}")
	// public String resourcesList(Model model, @PathVariable int pageNumber,
	// @PathVariable int pageSize) {
	// TeamResource resources = new TeamResource();
	// Page<TeamResource> page = resourcesService.getResourcesByPage(resources,
	// pageSize, pageNumber);
	// model.addAttribute("page", page);
	// return "console/resources/resourceslist";
	// }

	/**
	 * 
	 * 保存资源
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	public String save(MultipartFile file, Model model, HttpServletRequest request) {
		String type = file.getContentType();
		Long size = file.getSize();
        String path = request.getSession().getServletContext().getRealPath("file");  
        String fileName = file.getOriginalFilename();
        String p = "d://upload//resource//" + fileName;
        
        File f = new File(p);
        
        System.out.println(fileName);  

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
		String path = request.getParameter("path");
		try {
			DocConverter.convertTo(path);
		} catch (Exception e) {
			log.error("文件转换异常，请检查文件格式，联系技术支持！");
			Render<Object> render = new Render<Object>();
			render.setCode("55010");
			render.setData("文件转换异常，请检查文件格式，联系技术支持！");
			return render;
		}
		Render<Object> render = new Render<Object>();
		render.setCode("25010");
		render.setData("文件已经转换成功");
		return render;
	}
}
