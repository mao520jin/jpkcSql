package com.jpkc.model;

import java.util.Date;

/**
 * 
 * 教学荣誉表Model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class TeamHonor extends Model<Long, String> {

	private static final long serialVersionUID = -2729764290112306534L;

	private String title; // 标题
	private Long teamGroupId; // 成员ID
	private String about; // 简介
	private Integer type; // 荣誉类型: 1=科研项目，2=学术著作，3=奖励资助，4=学生成果展示
	private String desc; // 备注

	// sql
	private String name; // 成员名称

	public TeamHonor() {
	}

	public TeamHonor(Long id) {
		super(id);
	}

	public TeamHonor(Long id, String title, Long teamGroupId, String about, Integer type, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.title = title;
		this.teamGroupId = teamGroupId;
		this.about = about;
		this.type = type;
		this.desc = desc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getTeamGroupId() {
		return teamGroupId;
	}

	public void setTeamGroupId(Long teamGroupId) {
		this.teamGroupId = teamGroupId;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TeamHonor [title=" + title + ", teamGroupId=" + teamGroupId + ", about=" + about + ", type=" + type + ", desc=" + desc + ", name=" + name + ", toString()=" + super.toString() + "]";
	}

}
