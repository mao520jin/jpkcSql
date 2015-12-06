package com.jpkc.commons;

/**
 * 
 * 消息响应类
 * 
 * @author chenfan
 * @version 1.0, 2015/09/17
 * 
 * @param <T>
 * 
 */
public class Render<T> {

	/**
	 * 
	 * The response code.
	 * 
	 * <ul>
	 * <li>1xxxx: Informational
	 * <li>2xxxx: Success
	 * <li>3xxxx: Redirection
	 * <li>4xxxx: Client Error
	 * <li>5xxxx: Server Error
	 * <li>6xxxx: Other
	 * </ul>
	 * 
	 */
	private String code;

	/**
	 * 
	 * The response data.
	 * 
	 * <ul>
	 * <li>String
	 * <li>List
	 * <li>Map
	 * <li>Set
	 * <li>Object
	 * <li>...
	 * </ul>
	 * 
	 */
	private T data;

	/**
	 * 
	 * @see #setCode(String)
	 * @see #setData(Object)
	 * 
	 */
	public Render() {
	}

	/**
	 * 
	 * @param code
	 *            The response code.
	 * @param data
	 *            The response data.
	 * 
	 * @see #setCode(String)
	 * @see #setData(Object)
	 * 
	 */
	public Render(String code, T data) {
		this.code = code;
		this.data = data;
	}

	/**
	 * 
	 * The response code.
	 * 
	 * @return The response code.
	 * 
	 * @see #setCode(String)
	 * 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * The response code.
	 * 
	 * <ul>
	 * <li>1xxxx: Informational
	 * <li>2xxxx: Success
	 * <li>3xxxx: Redirection
	 * <li>4xxxx: Client Error
	 * <li>5xxxx: Server Error
	 * <li>6xxxx: Other
	 * </ul>
	 * 
	 * @param code
	 *            The response code.
	 * 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 
	 * The response data.
	 * 
	 * @return The response data.
	 * 
	 * @see #setData(Object)
	 * 
	 */
	public T getData() {
		return data;
	}

	/**
	 * 
	 * The response data.
	 * 
	 * <ul>
	 * <li>String
	 * <li>List
	 * <li>Map
	 * <li>Set
	 * <li>Object
	 * <li>...
	 * </ul>
	 * 
	 * @param data
	 *            The response data.
	 * 
	 */
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Render [code=" + code + ", data=" + data + "]";
	}

}
