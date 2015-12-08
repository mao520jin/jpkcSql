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
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpkc.commons.MySQLPage;
import com.jpkc.commons.Page;
import com.jpkc.model.Result;
import com.jpkc.model.Team;
import com.jpkc.util.VerifyUtil;

@Repository
public class ResultDao {
	private static Log log = LogFactory.getLog(ResultDao.class);

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * result 映射类
	 * 
	 * @author zhangyi
	 * @version 1.0, 2015-11-6
	 */
	private static final class ResultMapper implements RowMapper<Result> {

		public Result mapRow(ResultSet rs, int rowNum) throws SQLException {

			Result result = new Result();
			result.setId(rs.getInt("id"));
			result.setTeamId(rs.getInt("team_id"));
			result.setContent(rs.getString("content"));
			result.setType(rs.getInt("type"));
			result.setDeleteStatus(rs.getInt("delete_status"));
			result.setCreateTime(rs.getTimestamp("create_time"));
			result.setCreateBy(rs.getString("create_by"));

			return result;
		}

	}

	public int add(Result result) {
		String sql = "INSERT INTO `result`(`team_id`,`content`,`type`,`create_time`,`create_by`) VALUES(?,?,?,?,?)";
		List<Object> args = new ArrayList<Object>();
		args.add(result.getTeamId());
		args.add(result.getContent());
		args.add(result.getType());
		args.add(result.getCreateTime());
		args.add(result.getCreateBy());

		log.debug("sql:  " + sql);
		log.debug("args: " + JSONArray.fromObject(args));

		int row = jdbcTemplate.update(sql, args.toArray());
		return row;
	}

	public Page<Map<String, Object>> getNoticeByPage(Result result, Team team, Integer pageSize, Integer currentPage) {
		StringBuffer sql = new StringBuffer();
		sql.append("select t.`member_name`,r.`id`,r.`team_id`,r.`content`,r.`type`,r.`delete_status`,r.`create_time`,r.`create_by` from `result` r,`team` t where r.`team_id` = t.`id` and r.`delete_status` = 0 and t.`delete_status` = 0");

		List<Object> args = new ArrayList<Object>();
		if (!VerifyUtil.isEmpty(result.getTeamId())) {
			sql.append(" ").append(" and r.`team_id` = ?");
			args.add(result.getTeamId());
		}

		if (!VerifyUtil.isEmpty(team.getMemberName())) {
			sql.append(" ").append("and t.`member_name` = ?");
			args.add(team.getMemberName());
		}

		return new MySQLPage<Map<String, Object>>(currentPage,pageSize, jdbcTemplate, sql.toString(), new ColumnMapRowMapper(), args.toArray());
	}

	public List<Map<String, Object>> select(Result result) {
		StringBuffer sql = new StringBuffer();
		sql.append("select t.`member_name`,r.`id`,r.`team_id`,r.`content`,r.`type`,r.`delete_status`,r.`create_time`,r.`create_by` from `result` r,`team` t where r.`team_id` = t.`id` and r.`delete_status` = 0 and t.`delete_status` = 0");

		List<Object> args = new ArrayList<Object>();
		if (!VerifyUtil.isEmpty(result.getTeamId())) {
			sql.append(" ").append("r.`id` = ?");
			args.add(result.getId());
		}
		return jdbcTemplate.query(sql.toString(), new ColumnMapRowMapper(), args.toArray());
	}

	public int delete(Result result) {
		String sql = "update `result` set `delete_status` = 1 where  `id` = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", result.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}
}
