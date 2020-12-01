package com.jpkc.model;

import java.util.Date;

/**
 * 
 * 系统管理员Model
 * 
 * @author zhangyi
 * @version 1.0, 2015/10/07
 *
 */
public class SysAdmin extends Model<Long, String> {

	private static final long serialVersionUID = -5755072927694388077L;

	private String username; // 用户名
	private String password; // 密码
	private Integer status; // 状态：1=启用，0=禁用
	private String desc; // 备注

	public SysAdmin() {
	}

	public SysAdmin(Long id) {
		super(id);
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public SysAdmin(Long id, String username, String password, Integer status, String desc, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
		super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
		this.username = username;
		this.password = password;
		this.status = status;
		this.desc = desc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "SysAdmin [username=" + username + ", password=" + password + ", status=" + status + ", desc=" + desc + ", toString()=" + super.toString() + "]";
	}

}
