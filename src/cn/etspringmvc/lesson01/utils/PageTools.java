package cn.etspringmvc.lesson01.utils;


import java.util.List;

public class PageTools {
	/**
	 * ���췽��
	 * @param curPage ҳ�洫���ĵ�ǰҳ��
	 * @param pageCount ÿҳ��ʾ������
	 * @param totalCount �ܼ�¼��
	 */
	public PageTools(Integer curPage,Integer pageCount,Integer totalCount){
		this.curPage=curPage;
		this.pageCount=pageCount==null?5:pageCount;
		this.totalCount=totalCount;
		this.prePage=(curPage==1?1:curPage-1);
		this.totalPage=(totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1);
		this.nextPage=(curPage==totalPage)?totalPage:(curPage+1);
		this.startIndex=(curPage-1)*this.pageCount+1;
		this.endIndex=curPage*this.pageCount;
	}
	/*
	 * ��ǰҳ
	 */
	private Integer curPage;
	/*
	 * ÿҳ��ʾ������
	 */
	private Integer pageCount=10;
	/*
	 * ��һҳ
	 * prePage= (curPage==1?1:curPage-1)
	 */
	private Integer prePage;
	/*
	 * ��һҳ
	 * nextPage= (curPage==totalPage?totalPage:curPage+1)
	 */
	private Integer nextPage;
	/*
	 * ��ҳ��
	 * totalPage= (totalCount%pageCount==0?totalCount/pageCount:totalCount/pageCount+1)
	 */
	private Integer totalPage;
	/*
	 * �ܼ�¼��(�����ݿ��ѯ)
	 */
	private Integer totalCount;
	
	private List data;
	/*
	 * ��ʼ����
	 * startIndex=(curPage-1)*pageCount+1
	 */
	private Integer startIndex;
	/*
	 * ��������
	 * endIndex=curPage*pageCount
	 */
	private Integer endIndex;
	
	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
}