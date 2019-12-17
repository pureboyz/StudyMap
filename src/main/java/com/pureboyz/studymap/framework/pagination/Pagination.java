package com.pureboyz.studymap.framework.pagination;

/**
 * <pre>
 * Date 		: 2019. 12. 17.
 * Author 		: pureboyz
 *
 * 페이징 정보를 담는 클래스.
 * 
 * </pre>
 */
public class Pagination
{
	private int currentPage;		// 현재 페이지
	private int totalCount;			// 총 게시글 수
	private int countPerPage;		// 한 페이지당 게시글 수
	private int start;				// 보여지는 게시글 중 시작글의 번호
	private int end;				// 보여지는 게시글 중 마지막글의 번호
	private int displayPageCount;	// 보여지는 페이지 수
	private int startPage;			// 보여지는 페이지 중 시작페이지
	private int endPage;			// 보여지는 페이지 중 마지막페이지
	
	private boolean prev;			// 이전페이지의 존재 여부
	private boolean next;			// 다음페이지의 존재 여부
	
	public boolean isPrev() {
		return (this.currentPage == 1) ? false : true;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return (this.currentPage < (((this.totalCount - 1) / this.countPerPage) + 1)) ? true : false;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	public int getStart() {
		return ((this.currentPage * this.countPerPage) - (this.countPerPage - 1));
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return (this.currentPage * this.countPerPage);
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getDisplayPageCount() {
		return displayPageCount;
	}
	public void setDisplayPageCount(int displayPageCount) {
		this.displayPageCount = displayPageCount;
	}
	public int getStartPage() {
		return (int)( (this.currentPage - 0.1) / this.displayPageCount ) + 1;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		int EPage 		= (int)( (this.currentPage - 0.1) / this.displayPageCount ) + this.displayPageCount;	// 보여지는 마지막 페이지
		int totalEPage 	= (((this.totalCount - 1) / this.countPerPage) + 1);											// 총 페이지의 마지막 페이지
		System.out.println("EPage 		: " + EPage);
		System.out.println("totalEPage 	: " + totalEPage);
		return (EPage < totalEPage) ? EPage : totalEPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", totalCount=" + totalCount + ", countPerPage="
				+ countPerPage + ", start=" + start + ", end=" + end + ", displayPageCount=" + displayPageCount
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
}
