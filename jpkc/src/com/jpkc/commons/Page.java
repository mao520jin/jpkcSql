package com.jpkc.commons;

import java.util.List;

/**
 * 
 * 分页
 * 
 * @author chenfan
 * @version 1.0, 2015/09/14
 * 
 * @param <T>
 * 
 */
public abstract class Page<T> {

	private int pageNumber = 1; // 页码
	private int pageSize = 20; // 页码大小（显示数量）
	private int totalPages; // 总页数
	private int totalElements; // 总记录数

	private List<T> content; // 数据

	/**
	 * 
	 * <ul>
	 * <li>args[0]: pageNumber
	 * <li>args[1]: pageSize
	 * <li>...
	 * </ul>
	 * 
	 */
	public Page(Object... args) {

		if (args == null || args.length == 0) {
			throw new IllegalArgumentException("Illegal Argument: 'args'");
		}

		int pageNumber = 1;
		try {
			pageNumber = (Integer) args[0];
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument: args[0]('pageNumber')");
		}

		int pageSize = 25;
		try {
			pageSize = (Integer) args[1];
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument: args[1]('pageSize')");
		}

		setPageSize(pageSize);
		init(args);
		setTotalElements();
		setTotalPages();
		setPageNumber(pageNumber);
		setContent();

	}

	public abstract void init(Object... args);

	public int getPageNumber() {
		return pageNumber;
	}

	private void setPageNumber(int pageNumber) {
		if (pageNumber > totalPages) {
			this.pageNumber = totalPages;
		} else if (pageNumber < 1) {
			this.pageNumber = 1;
		} else {
			this.pageNumber = pageNumber;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	private void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	public int getTotalPages() {
		return totalPages;
	}

	private void setTotalPages() {
		if (totalElements != 0 && (totalElements % pageSize == 0)) {
			totalPages = totalElements / pageSize;
		} else {
			totalPages = totalElements / pageSize + 1;
		}
	}

	public int getTotalElements() {
		return totalElements;
	}

	private void setTotalElements() {
		totalElements = totalElements();
	}

	public abstract int totalElements();

	public List<T> getContent() {
		return content;
	}

	private void setContent() {
		content = content();
	}

	public abstract List<T> content();

	/**
	 * 
	 * 
	 * 
	 * @return
	 * 
	 */
	public int getContentSize() {
		return content.size();
	}

	/**
	 * 
	 * 获取上一页页码
	 * 
	 * @return
	 * 
	 */
	public int getPrevious() {
		return hasPrevious() ? pageNumber - 1 : 1;
	}

	/**
	 * 
	 * 获取下一页页码
	 * 
	 * @return
	 * 
	 */
	public int getNext() {
		return hasNext() ? pageNumber + 1 : totalPages;
	}

	/**
	 * 
	 * 是否是第一页
	 * 
	 * @return
	 * 
	 */
	public boolean isFirst() {
		return !hasPrevious();
	}

	/**
	 * 
	 * 是否是最后一页
	 * 
	 * @return
	 * 
	 */
	public boolean isLast() {
		return !hasNext();
	}

	/**
	 * 
	 * 是否有上一页
	 * 
	 * @return
	 * 
	 */
	public boolean hasPrevious() {
		return pageNumber > 1;
	}

	/**
	 * 
	 * 是否有下一页
	 * 
	 * @return
	 * 
	 */
	public boolean hasNext() {
		return pageNumber + 1 <= totalPages;
	}

}
