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
	private String name; // 文件真实名称
	private String denseName; // 加密名称
	/**
	 * 1=电子教案,2=教学课件,3=教学视频,4=教学大纲</br>
	 * 5=实验教学资料,6=学生反馈,7=校内综合评价,8=校外专家评价</br>
	 * 9=模拟试题, 10=资料下载, 11=名校专家讲堂</br>
	 */
	private Integer type;
	private Integer isconvert; // 是否已转换格式: 0=未转换 1=已转换
	private Integer count; // 下载次数
	private String desc; // 备注

	public TeamResource() {

	}

	public TeamResource(Long id) {
		super(id);
	}

	public TeamResource(Long id, String title, String path, String name, String denseName, Integer type, Integer isconvert, Integer count, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.title = title;
		this.path = path;
		this.name = name;
		this.denseName = denseName;
		this.type = type;
		this.isconvert = isconvert;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDenseName() {
		return denseName;
	}

	public void setDenseName(String denseName) {
		this.denseName = denseName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsconvert() {
		return isconvert;
	}

	public void setIsconvert(Integer isconvert) {
		this.isconvert = isconvert;
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
		return "TeamResource [title=" + title + ", path=" + path + ", name=" + name + ", denseName=" + denseName + ", type=" + type + ", isconvert=" + isconvert + ", count=" + count + ", desc=" + desc + ", toString()=" + super.toString() + "]";
	}

}
