package com.jpkc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jpkc.commons.Page;
import com.jpkc.dao.NoticeDao;
import com.jpkc.model.Notice;
import com.jpkc.util.VerifyUtil;

@Service
public class NoticeService {
	private static Log log = LogFactory.getLog(NoticeService.class);

	@Resource
	private NoticeDao noticeDao;

	public Page<Notice> getNoticeByPage(Notice notice, Integer pageSize, Integer currentPage) {
		notice.setDeleteStatus(0);
		return noticeDao.getNoticeByPage(notice, pageSize, currentPage);
	}

	public void add(Notice notice) {
		int row = 0;
		notice.setCreateTime(new Date());
		notice.setDeleteStatus(0);
		if (!VerifyUtil.isEmpty(notice.getId())) {
			// 修改内容
			row = noticeDao.edit(notice);
			log.debug("修改公告条数： " + row);
		} else {
			// 添加内容
			row = noticeDao.add(notice);
			log.debug("添加公告条数： " + row);
		}
	}

	public List<Notice> select(Notice notice) {
		notice.setDeleteStatus(0);
		return noticeDao.select(notice);
	}

	public void delete(Notice notice) {
		int row = noticeDao.delete(notice);
		log.debug("删除公告条数： " + row);
	}

}
