package com.jpkc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jpkc.commons.Page;
import com.jpkc.dao.UserDao;
import com.jpkc.model.User;

@Service
public class UserService {
	private static Log log = LogFactory.getLog(UserService.class);

	@Resource
	private UserDao userDao;

	public Page<User> getUserByPage(User user, int pageSize, int currentPage) {
		user.setDeleteStatus(0);
		return userDao.getUserByPage(user, pageSize, currentPage);
	}

	public Boolean login(User user) {
		user.setDeleteStatus(0);
		List<User> userList = userDao.select(user);
		if (userList.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 添加用户</br> 20000:成功</br> 40000:添加失败</br>
	 * 
	 * @author zhangyi
	 * @2015-11-7
	 */
	public String addUser(User user) {
		user.setDeleteStatus(0);
		user.setCreateTime(new Date());
		int row = userDao.save(user);

		log.debug("添加记录条数 ： " + row);
		if (row == 1) {
			return "20000";
		} else {
			return "40000";
		}
	}

	public void delete(User user) {
		int row = userDao.delete(user);
		log.info("删除用户条数: " + row);
	}

	public List<User> select(User user) {
		user.setDeleteStatus(0);
		return userDao.select(user);
	}
}
