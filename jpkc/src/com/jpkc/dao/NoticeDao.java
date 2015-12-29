package com.jpkc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpkc.commons.MySQLPage;
import com.jpkc.commons.Page;
import com.jpkc.model.Notice;
import com.jpkc.util.VerifyUtil;

@Repository
public class NoticeDao {
	private static Log log = LogFactory.getLog(NoticeDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * notice 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class NoticeMapper implements RowMapper<Notice> {

		public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {

			Notice notice = new Notice();
			notice.setId(rs.getInt("id"));
			notice.setTitle(rs.getString("title"));
			notice.setContent(rs.getString("content"));
			notice.setDeleteStatus(rs.getInt("delete_status"));
			notice.setCreateTime(rs.getTimestamp("create_time"));
			notice.setCreateBy(rs.getString("create_by"));

			return notice;

		}

	}

	public Page<Notice> getNoticeByPage(Notice notice, Integer pageSize, Integer currentPage) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("`id`");
		sql.append(",").append("`title`");
		sql.append(",").append("`content`");
		sql.append(",").append("`delete_status`");
		sql.append(",").append("`create_time`");
		sql.append(",").append("`create_by`");
		sql.append(" FROM");
		sql.append(" ").append("`notice`");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> args = new ArrayList<Object>();

		if (!VerifyUtil.isEmpty(notice.getTitle())) {
			sql.append(" AND");
			sql.append(" ").append("`title` like ?");
			args.add("%" + notice.getTitle() + "%");
		}

		if (!VerifyUtil.isEmpty(notice.getContent())) {
			sql.append(" AND");
			sql.append(" ").append("`content` = ?");
			args.add(notice.getContent());
		}

		if (!VerifyUtil.isEmpty(notice.getDeleteStatus())) {
			sql.append(" AND");
			sql.append(" ").append("`delete_status` = ?");
			args.add(notice.getDeleteStatus());
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("`create_time` desc");

		log.debug("sql : " + sql);
		log.debug("args : " + JSONArray.fromObject(args));

		return new MySQLPage<Notice>(currentPage, pageSize, jdbcTemplate, sql.toString(), new NoticeMapper(), args.toArray());
	}

	public int add(Notice notice) {
		String sql = "INSERT INTO `notice`(`title`,`content`,`create_time`,`create_by`) VALUES(?,?,?,?)";
		List<Object> args = new ArrayList<Object>();
		args.add(notice.getTitle());
		args.add(notice.getContent());
		args.add(notice.getCreateTime());
		args.add(notice.getCreateBy());

		log.debug("sql:  " + sql);
		log.debug("args: " + JSONArray.fromObject(args));

		int row = jdbcTemplate.update(sql, args.toArray());
		return row;
	}

	public List<Notice> select(Notice notice) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("`id`");
		sql.append(",").append("`title`");
		sql.append(",").append("`content`");
		sql.append(",").append("`delete_status`");
		sql.append(",").append("`create_time`");
		sql.append(",").append("`create_by`");
		sql.append(" FROM");
		sql.append(" ").append("`notice`");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> args = new ArrayList<Object>();

		if (!VerifyUtil.isEmpty(notice.getId())) {
			sql.append(" AND");
			sql.append(" ").append("`id` = ?");
			args.add(notice.getId());
		}

		if (!VerifyUtil.isEmpty(notice.getTitle())) {
			sql.append(" AND");
			sql.append(" ").append("`title` = ?");
			args.add(notice.getTitle());
		}

		if (!VerifyUtil.isEmpty(notice.getContent())) {
			sql.append(" AND");
			sql.append(" ").append("`content` = ?");
			args.add(notice.getContent());
		}

		if (!VerifyUtil.isEmpty(notice.getDeleteStatus())) {
			sql.append(" AND");
			sql.append(" ").append("`delete_status` = ?");
			args.add(notice.getDeleteStatus());
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("`create_time` desc");

		log.debug("sql : " + sql);
		log.debug("args : " + JSONArray.fromObject(args));

		return jdbcTemplate.query(sql.toString(), args.toArray(), new NoticeMapper());
	}

	public int edit(Notice notice) {
		String sql = "update `notice` set title = :title,content = :content,create_time = :create_time,create_by = :create_by where delete_status = 0 and id = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", notice.getTitle());
		paramMap.put("content", notice.getContent());
		paramMap.put("create_time", notice.getCreateTime());
		paramMap.put("create_by", notice.getCreateBy());
		paramMap.put("id", notice.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}

	public int delete(Notice notice) {
		String sql = "update `notice` set `delete_status` = 1 where  `id` = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", notice.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}
}
