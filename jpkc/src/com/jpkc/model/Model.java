package com.jpkc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 公共模型
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 *
 * @param <ID>
 * @param <U>
 * 
 */
public class Model<ID extends Serializable, U> implements Serializable {

	private static final long serialVersionUID = 964315523863957285L;

	private ID id; // 主键ID
	private U createdBy; // 创建人
	private Date createdDate; // 创建时间
	private U lastModifiedBy; // 最后更新人
	private Date lastModifiedDate; // 最后更新时间

	public Model() {
	}

	public Model(ID id) {
		this.id = id;
	}

	public Model(ID id, U createdBy, Date createdDate, U lastModifiedBy, Date lastModifiedDate) {
		this.id = id;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}

	public boolean isNew() {
		return getId() == null;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	// 获取字符串类型 ID
	public String getIdString() {
		String idString = String.valueOf(getId());
		return "null".equalsIgnoreCase(idString) ? null : idString;
	}

	public U getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(U createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	// 获取字符串类型创建时间
	public String getCreatedDateString() {
		return dateString(getCreatedDate());
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public U getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(U lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	// 获取字符串类型最后更新时间
	public String getLastModifiedDateString() {
		return dateString(getLastModifiedDate());
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	// 字符串类型日期
	private String dateString(Date date) {
		return date == null ? null : ((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date));
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
