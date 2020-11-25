package com.jpkc.model;

import java.util.Date;

/**
 * 网站留言表Model
 * 
 * @author zhangyi
 * @version 1.0, 2015-11-6
 */
public class WebsiteMsg extends Model<Long, String> {

	private static final long serialVersionUID = -7259480308326774000L;

	private String ip; // 标题
	private String count; // 同ip当天留言次数
	private String content; // 留言内容
	private Integer type; // 留言类型：1=留言，2=回复

	public WebsiteMsg() {
		super();
	}

	public WebsiteMsg(Long id) {
		super(id);
	}

	public WebsiteMsg(Long id, String ip, String count, String content, Integer type, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.ip = ip;
		this.count = count;
		this.content = content;
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "WebsiteMsg [ip=" + ip + ", count=" + count + ", content=" + content + ", type=" + type + ", toString()=" + super.toString() + "]";
	}

}
