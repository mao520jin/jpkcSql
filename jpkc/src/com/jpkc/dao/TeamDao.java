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
import com.jpkc.model.Result;
import com.jpkc.model.Team;
import com.jpkc.util.VerifyUtil;

@Repository
public class TeamDao {
	private static Log log = LogFactory.getLog(TeamDao.class);

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
	private static final class TeamMapper implements RowMapper<Team> {

		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {

			Team team = new Team();
			team.setId(rs.getInt("id"));
			team.setMemberName(rs.getString("member_name"));
			team.setContent(rs.getString("content"));
			team.setType(rs.getInt("type"));
			team.setEmail(rs.getString("email"));
			team.setTel(rs.getString("tel"));
			team.setDeleteStatus(rs.getInt("delete_status"));
			team.setCreateTime(rs.getTimestamp("create_time"));
			team.setCreateBy(rs.getString("create_by"));

			return team;
		}

	}

	public int add(Team team) {
		String sql = "INSERT INTO `team`(`member_name`,`content`,`type`,`email`,`tel`,`create_time`,`create_by`) VALUES(?,?,?,?,?,?,?)";
		List<Object> args = new ArrayList<Object>();
		args.add(team.getMemberName());
		args.add(team.getContent());
		args.add(team.getType());
		args.add(team.getEmail());
		args.add(team.getTel());
		args.add(team.getCreateTime());
		args.add(team.getCreateBy());

		log.debug("sql:  " + sql);
		log.debug("args: " + JSONArray.fromObject(args));

		int row = jdbcTemplate.update(sql, args.toArray());
		return row;
	}

	public Page<Team> getNoticeByPage(Team team, Integer pageSize, Integer currentPage) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("`id`");
		sql.append(",").append("`member_name`");
		sql.append(",").append("`content`");
		sql.append(",").append("`type`");
		sql.append(",").append("`email`");
		sql.append(",").append("`tel`");
		sql.append(",").append("`delete_status`");
		sql.append(",").append("`create_time`");
		sql.append(",").append("`create_by`");
		sql.append(" FROM");
		sql.append(" ").append("`team`");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> args = new ArrayList<Object>();

		if (!VerifyUtil.isEmpty(team.getMemberName())) {
			sql.append(" AND");
			sql.append(" ").append("`member_name` = ?");
			args.add(team.getMemberName());
		}

		if (!VerifyUtil.isEmpty(team.getContent())) {
			sql.append(" AND");
			sql.append(" ").append("`content` = ?");
			args.add(team.getContent());
		}

		if (!VerifyUtil.isEmpty(team.getType())) {
			sql.append(" AND");
			sql.append(" ").append("`type` = ?");
			args.add(team.getType());
		}

		if (!VerifyUtil.isEmpty(team.getEmail())) {
			sql.append(" AND");
			sql.append(" ").append("`email` = ?");
			args.add(team.getEmail());
		}

		if (!VerifyUtil.isEmpty(team.getTel())) {
			sql.append(" AND");
			sql.append(" ").append("`tel` = ?");
			args.add(team.getTel());
		}

		if (!VerifyUtil.isEmpty(team.getDeleteStatus())) {
			sql.append(" AND");
			sql.append(" ").append("`delete_status` = ?");
			args.add(team.getDeleteStatus());
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("`create_time` desc");

		log.debug("sql : " + sql);
		log.debug("args : " + JSONArray.fromObject(args));

		return new MySQLPage<Team>(currentPage,pageSize,jdbcTemplate, sql.toString(),new TeamMapper(),args.toArray());
	}

	public List<Team> select(Team team) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append(" ").append("`id`");
		sql.append(",").append("`member_name`");
		sql.append(",").append("`content`");
		sql.append(",").append("`type`");
		sql.append(",").append("`email`");
		sql.append(",").append("`tel`");
		sql.append(",").append("`delete_status`");
		sql.append(",").append("`create_time`");
		sql.append(",").append("`create_by`");
		sql.append(" FROM");
		sql.append(" ").append("`team`");
		sql.append(" WHERE");
		sql.append(" ").append("1 = 1");

		List<Object> args = new ArrayList<Object>();

		if (!VerifyUtil.isEmpty(team.getMemberName())) {
			sql.append(" AND");
			sql.append(" ").append("`member_name` = ?");
			args.add(team.getMemberName());
		}

		if (!VerifyUtil.isEmpty(team.getContent())) {
			sql.append(" AND");
			sql.append(" ").append("`content` = ?");
			args.add(team.getContent());
		}

		if (!VerifyUtil.isEmpty(team.getType())) {
			sql.append(" AND");
			sql.append(" ").append("`type` = ?");
			args.add(team.getType());
		}

		if (!VerifyUtil.isEmpty(team.getEmail())) {
			sql.append(" AND");
			sql.append(" ").append("`email` = ?");
			args.add(team.getEmail());
		}

		if (!VerifyUtil.isEmpty(team.getTel())) {
			sql.append(" AND");
			sql.append(" ").append("`tel` = ?");
			args.add(team.getTel());
		}

		if (!VerifyUtil.isEmpty(team.getDeleteStatus())) {
			sql.append(" AND");
			sql.append(" ").append("`delete_status` = ?");
			args.add(team.getDeleteStatus());
		}

		sql.append(" ORDER BY");
		sql.append(" ").append("`create_time` desc");

		log.debug("sql : " + sql);
		log.debug("args : " + JSONArray.fromObject(args));

		return jdbcTemplate.query(sql.toString(), args.toArray(), new TeamMapper());
	}

	public int delete(Team team) {
		String sql = "update `team` set `delete_status` = 1 where  `id` = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", team.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}

	public int edit(Team team) {
		String sql = "update `team` set member_name = :member_name,content = :content,type = :type,email = :email,tel = :tel,create_time = :create_time,create_by = :create_by where delete_status = 0 and id = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("member_name", team.getMemberName());
		paramMap.put("content", team.getContent());
		paramMap.put("type", team.getType());
		paramMap.put("email", team.getEmail());
		paramMap.put("tel", team.getTel());
		paramMap.put("create_time", team.getCreateTime());
		paramMap.put("create_by", team.getCreateBy());
		paramMap.put("id", team.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}

	public List<Team> getTeam() {
		String sql = "select `id`,`member_name`,`content`,`type`,`email`,`tel`,`delete_status`,`create_time`,`create_by` from `team` where `delete_status` = 0";
		return jdbcTemplate.query(sql, new TeamMapper());
	}

	public int edit(Result result) {
		String sql = "update `result` set team_id = :team_id,content = :content,type = :type,create_time = :create_time,create_by = :create_by where delete_status = 0 and id = :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("team_id", result.getTeamId());
		paramMap.put("content", result.getContent());
		paramMap.put("type", result.getType());
		paramMap.put("create_time", result.getCreateTime());
		paramMap.put("create_by", result.getCreateBy());
		paramMap.put("id", result.getId());

		log.debug("sql: " + sql);
		log.debug("args: " + paramMap);

		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}
}
