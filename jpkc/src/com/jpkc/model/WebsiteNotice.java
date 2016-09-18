package com.jpkc.model;

import java.util.Date;

/**
 * 网站公告表Model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class WebsiteNotice extends Model<Long, String> {

	private static final long serialVersionUID = -1307244121971732966L;

	private String title; // 标题
	private String content;
	private String desc;

	public WebsiteNotice() {
	}

	public WebsiteNotice(Long id) {
		super(id);
	}

	public WebsiteNotice(Long id, String title, String content, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.title = title;
		this.content = content;
		this.desc = desc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "websiteNotice [title=" + title + ", content=" + content + ", desc=" + desc + ", toString()=" + super.toString() + "]";
	}

}
