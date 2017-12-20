package org.example.xdiamond.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 分页对象
 * 
 * @author zongying.zhao
 * @version $Id: PaginationResult.java, v 0.1 2017年9月1日 下午3:59:20 zongying.zhao Exp $
 */
public class PaginationResult<T> {

	/**
	 * 页码
	 */
    private int pageNumber;

    /**
     * 列表大小
     */
    private int pageSize;

    /**
     * 总页数
     */
    private long pageCount;

    /**
     * 总记录数
     */
    private long totalCount;
    
    private List<T> itemList;

    public PaginationResult(int pageNumber, int pageSize, long totalCount, List<T> itemList) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.itemList = itemList;
        if (pageSize != 0) {
            if (totalCount % pageSize == 0) {
                pageCount = totalCount / pageSize;
            } else {
                pageCount = totalCount / pageSize + 1;
            }
        }
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    @JsonProperty("has_prev_page")
    public boolean hasPrevPage() {
        return pageNumber > 1 && pageNumber <= pageCount;
    }

    @JsonProperty("has_next_page")
    public boolean hasNextPage() {
        return pageNumber < pageCount;
    }

    @JsonProperty("is_first_page")
    public boolean isFirstPage() {
        return pageNumber == 1;
    }

    @JsonProperty("is_last_page")
    public boolean isLastPage() {
        return pageNumber == pageCount;
    }

    public List<T> getItemList() {
        return itemList;
    }
    
    public void setItemList(List<T> itemList) {
    	this.itemList = itemList;
    }
}

