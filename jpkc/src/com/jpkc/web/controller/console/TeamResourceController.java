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
	@RequestMapping("/editSave")
	public @ResponseBody Render<Object> editSave(HttpServletRequest request) {
		Render<Object> render = new Render<Object>();

		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String type = request.getParameter("type");

		if (!Toolkit.isId(id)) {
			log.error("参数不合法,id = " + id);
			render.setCode("45010");
			render.setData("参数不合法");
			return render;
		}

		TeamResource teamResource = new TeamResource(Long.parseLong(id));
		teamResource.setTitle(title);
		teamResource.setType(Integer.parseInt(type));
		try {
			teamResourceService.save(teamResource);
		} catch (Exception e) {
			log.error("更新失败！ ", e);
			render.setCode("55020");
			render.setData("更新，联系技术支持！");
			return render;
		}

		render.setCode("25010");
		render.setData("更新成功");
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

		String id = request.getParameter("id");
		String type = request.getParameter("type");

		if (!Toolkit.isId(id)) {
			log.error("参数不合法,id = " + id);
			render.setCode("45010");
			render.setData("参数不合法");
			return render;
		}

		// 其余的不用转换，@see save
		if (!Toolkit.contains(false, type, "1", "2", "4", "5", "6", "7", "8")) {
			log.error("参数不合法,type = " + type);
			render.setCode("45020");
			render.setData("参数不合法");
			return render;
		}

		// try {
		// DocConverter.convertTo(path);
		// } catch (Exception e) {
		// log.error("文件转换异常，请检查文件格式，联系技术支持！ ", e);
		// render.setCode("55010");
		// render.setData("文件转换异常，请检查文件格式，联系技术支持！");
		// return render;
		// }

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
