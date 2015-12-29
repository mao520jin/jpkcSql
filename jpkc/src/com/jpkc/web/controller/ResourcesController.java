package com.jpkc.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpkc.commons.Page;
import com.jpkc.commons.Render;
import com.jpkc.model.Resources;
import com.jpkc.model.User;
import com.jpkc.service.ResourcesService;
import com.jpkc.util.VerifyUtil;

/**
 * 
 * 资源Controller
 * 
 * @author zhangyi
 * @version 1.0 2015年12月28日
 */
@Controller
@RequestMapping("/resources")
public class ResourcesController {

	private static Log log = LogFactory.getLog(ResourcesController.class);

	@Resource
	private ResourcesService resourcesService;

	/**
	 * 添加页面
	 * 
	 * @author zhangyi
	 * @2015-11-8
	 */
	@RequestMapping("/add")
	public String addResourcesIndex() {

		return "console/resources/add";
	}

	/**
	 * 
	 * 添加信息
	 * 
	 * @param model
	 * @param resources
	 * @return
	 */
	@RequestMapping("/addResources")
	public String addResources(Model model, Resources resources) {
		User user = new User();
		user.setUsername("123");
		resources.setCreateBy(user.getUsername());
		resourcesService.add(resources);
		return "redirect:/resources/list";
	}

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
	public String resourcesList(Model model, String title, Integer resourcesType) {
		Resources resources = new Resources();
		if (!VerifyUtil.isEmpty(title)) {
			resources.setTitle(title);
		}
		if (!VerifyUtil.isEmpty(resourcesType) && resourcesType != 0) {
			resources.setType(resourcesType);
		}
		int pageNumber = 0;
		int pageSize = 0;
		Page<Resources> page = resourcesService.getResourcesByPage(resources, pageSize, pageNumber);
		model.addAttribute("page", page);
		model.addAttribute("title", title);
		model.addAttribute("resourcesType", resourcesType);

		return "console/resources/resourceslist";
	}

	/**
	 * 分页查询
	 * 
	 * @param model
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/list/{pageNumber}/{pageSize}")
	public String resourcesList(Model model, @PathVariable int pageNumber, @PathVariable int pageSize) {
		Resources resources = new Resources();
		Page<Resources> page = resourcesService.getResourcesByPage(resources, pageSize, pageNumber);
		model.addAttribute("page", page);
		return "console/resources/resourceslist";
	}

	/***
	 * API
	 * 
	 * @param model
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/resourcesList")
	public Render<Object> resourcesList(Model model, int pageNumber, int pageSize, int type) {
		Render<Object> render = new Render<Object>();
		Resources resources = new Resources();
		resources.setType(type);
		Page<Resources> page = resourcesService.getResourcesByPage(resources, pageSize, pageNumber);
		model.addAttribute("page", page);
		render.setData(page);
		render.setCode("20000");
		return render;
	}

	@RequestMapping("/edit/{id}")
	public String editResources(@PathVariable int id, Model model) {
		Resources resources = new Resources();
		resources.setId(id);
		List<Resources> resourcesList = resourcesService.select(resources);
		model.addAttribute("resourcesList", resourcesList);
		return "console/resources/add";
	}

	/**
	 * 
	 * 批量删除资源信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/del/{ids}")
	public String delResources(@PathVariable int[] ids, RedirectAttributes ra) {
		Render<Object> render = new Render<Object>();
		if (VerifyUtil.isEmpty(ids)) {
			log.info("删除资源信息的id是空!");
			render.setCode("20000");
			render.setData("删除资源id是空!");
			ra.addFlashAttribute("render", render);
			return "redirect:/resources/list";
		}

		for (int i = 0; i < ids.length; i++) {
			Resources resources = new Resources(ids[i]);
			resourcesService.delete(resources);
		}

		return "redirect:/resources/list";
	}
}
