package com.jpkc.model;

import java.util.Date;

/**
 * 
 * team 表对应model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class TeamGroup extends Model<Long, String> {

	private static final long serialVersionUID = 1153653380958521926L;

	private String name; // 名称
	private Integer type; // 成员类型：1=导师，2=学生
	private String about; // 简介
	private String photo; // 成员照片
	private String email; // 邮箱
	private String mobile; // 电话
	private String desc; // 备注

	public TeamGroup() {
	}

	public TeamGroup(Long id) {
		super(id);
	}

	public TeamGroup(Long id, String name, Integer type, String about, String photo, String email, String mobile,
			String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.name = name;
		this.type = type;
		this.about = about;
		this.photo = photo;
		this.email = email;
		this.mobile = mobile;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAbout() {
		return about;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "TeamGroup [name=" + name + ", type=" + type + ", about=" + about + ", photo=" + photo + ", email="
				+ email + ", mobile=" + mobile + ", desc=" + desc + ", toString()=" + super.toString() + "]";
	}

}
