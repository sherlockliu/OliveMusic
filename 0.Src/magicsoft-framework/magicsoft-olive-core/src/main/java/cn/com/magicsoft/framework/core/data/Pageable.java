package cn.com.magicsoft.framework.core.data;

public abstract interface Pageable {
	public abstract int getTotalCount();

	public abstract int getTotalPage();

	public abstract int getPageSize();

	public abstract int getPageNo();

	public abstract boolean isFirstPage();

	public abstract boolean isLastPage();

	public abstract int getNextPage();

	public abstract int getPrePage();
}