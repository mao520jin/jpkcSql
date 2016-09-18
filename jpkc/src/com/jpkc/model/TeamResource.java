package com.jpkc.model;

import java.util.Date;

/**
 * 
 * 教学资源表Model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class TeamResource extends Model<Long, String> {

	private static final long serialVersionUID = 1552946311212437441L;

	private String title; // 标题
	private String path; // 资源路径
	private Integer type; // 资源类型: 1=电子教案,2=教学课件,3=教学视频,4=教学大纲 ,5=实验教学资料
	private Integer count; // 下载次数
	private String desc; // 备注

	public TeamResource() {
	}

	public TeamResource(Long id) {
		super(id);
	}

	public TeamResource(Long id, String title, String path, Integer type, Integer count, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.title = title;
		this.path = path;
		this.type = type;
		this.count = count;
		this.desc = desc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "TeamResource [title=" + title + ", path=" + path + ", type=" + type + ", count=" + count + ", desc=" + desc + ", toString()=" + super.toString() + "]";
	}

}
