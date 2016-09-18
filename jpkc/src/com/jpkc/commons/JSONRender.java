package com.jpkc.commons;

import net.sf.json.JSONObject;

/**
 * 
 * 请求响应公共类(JSON)
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 *
 * @param <T>
 * 
 * @see Render
 * 
 */
public class JSONRender<T> extends Render<T> {

	/**
	 * 
	 * 
	 * 
	 * @see Render#Render()
	 * 
	 */
	public JSONRender() {
		super();
	}

	/**
	 * 
	 * 
	 * 
	 * @param code
	 *            The response code.
	 * @param data
	 *            The response data.
	 * 
	 * @see Render#Render(String, Object)
	 * 
	 */
	public JSONRender(String code, T data) {
		super(code, data);
	}

	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}

}
