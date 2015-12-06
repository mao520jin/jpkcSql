package com.jpkc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jpkc.commons.Page;
import com.jpkc.dao.ResourcesDao;
import com.jpkc.model.Resources;
import com.jpkc.util.VerifyUtil;

@Service
public class ResourcesService {
	private static Log log = LogFactory.getLog(ResourcesService.class);

	@Resource
	private ResourcesDao resourcesDao;

	public void add(Resources resources) {
		int row = 0;
		resources.setCreateTime(new Date());
		resources.setDeleteStatus(0);
		if (!VerifyUtil.isEmpty(resources.getId())) {
			// 修改内容
			row = resourcesDao.edit(resources);
			log.debug("修改公告条数： " + row);
		} else {
			// 添加内容
			row = resourcesDao.add(resources);
			log.debug("添加公告条数： " + row);
		}
	}

	public Page<Resources> getResourcesByPage(Resources resources, Integer pageSize, Integer currentPage) {
		resources.setDeleteStatus(0);
		return resourcesDao.getResourcesByPage(resources, pageSize, currentPage);
	}

	public List<Resources> select(Resources resources) {
		resources.setDeleteStatus(0);
		return resourcesDao.select(resources);
	}

	public void delete(Resources resources) {
		int row = resourcesDao.delete(resources);
		log.debug("删除公告条数： " + row);
	}
}
