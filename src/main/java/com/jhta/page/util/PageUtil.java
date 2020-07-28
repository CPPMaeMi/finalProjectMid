package com.jhta.page.util;

<<<<<<< HEAD
//ï¿½ï¿½ï¿½ï¿½Â¡ Ã³ï¿½ï¿½ï¿½Ï´ï¿½ Å¬ï¿½ï¿½ï¿½ï¿½
public class PageUtil {
	private int pageNum; //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½È£
	private int startRow; //ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½
	private int endRow; //ï¿½ï¿½ ï¿½ï¿½
	private int totalPageCount; //ï¿½ï¿½Ã¼ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	private int startPageNum; //ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	private int endPageNum; //ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	private int rowBlockCount; //ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	private int pageBlockCount; //ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	private int totalRowCount; //ï¿½ï¿½Ã¼ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
	
	public PageUtil() {}
	public PageUtil(int pageNum, int totalRowCount,
			int rowBlockCount, int pageBlockCount) {
		this.pageNum=pageNum;
		this.totalRowCount=totalRowCount;
		this.rowBlockCount=rowBlockCount;
		this.pageBlockCount=pageBlockCount;
		startRow=(pageNum-1)*rowBlockCount+1;
		endRow=startRow+rowBlockCount-1;
		totalPageCount=(int)Math.ceil(totalRowCount/(double)rowBlockCount);
		startPageNum=(pageNum-1)/pageBlockCount*pageBlockCount+1;
		endPageNum=startPageNum+pageBlockCount-1;
		if(totalPageCount<endPageNum) {
			endPageNum=totalPageCount;
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getRowBlockCount() {
		return rowBlockCount;
	}
	public void setRowBlockCount(int rowBlockCount) {
		this.rowBlockCount = rowBlockCount;
	}
	public int getPageBlockCount() {
		return pageBlockCount;
	}
	public void setPageBlockCount(int pageBlockCount) {
		this.pageBlockCount = pageBlockCount;
	}
	public int getTotalRowCount() {
		return totalRowCount;
	}
	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
	

=======
public class PageUtil {
	private int pageNum; // ÆäÀÌÁö¹øÈ£
	private int startRow; // ½ÃÀÛÇà
	private int endRow; // ³¡Çà
	private int startPageNum; // ½ÃÀÛÆäÀÌÁö
	private int endPageNum; // ³¡ÆäÀÌÁö
	private int rowBlockCount; // ÇÑÆäÀÌÁö¿¡ º¸¿©Áú ±ÛÀÇ °¹¼ö
	private int pageBlockCount; // ÇÑÆäÀÌÁö¿¡ º¸¿©Áú ÆäÀÌÁöÀÇ °¹¼ö
	private int totalPageCount; // ÀüÃ¼ÆäÀÌÁö °¹¼ö
	private int totalRowCount; // ÀüÃ¼ ±ÛÀÇ °¹¼ö
	public PageUtil(){}
	public PageUtil(int pageNum,int totalRowCount,int rowBlockCount,int pageBlockCount) {
		this.pageNum=pageNum;
		this.totalRowCount=totalRowCount;
		this.rowBlockCount=rowBlockCount;
		this.pageBlockCount=pageBlockCount;
		startRow=(pageNum-1)*rowBlockCount+1;
		endRow=startRow+rowBlockCount-1;
		totalPageCount=(int)Math.ceil(totalRowCount/(double)rowBlockCount);
		startPageNum=(pageNum-1)/pageBlockCount*pageBlockCount+1;
		endPageNum=startPageNum+pageBlockCount-1;
		if(totalPageCount<endPageNum) {
			endPageNum=totalPageCount;
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getRowBlockCount() {
		return rowBlockCount;
	}
	public void setRowBlockCount(int rowBlockCount) {
		this.rowBlockCount = rowBlockCount;
	}
	public int getPageBlockCount() {
		return pageBlockCount;
	}
	public void setPageBlockCount(int pageBlockCount) {
		this.pageBlockCount = pageBlockCount;
	}
	public int getTotalRowCount() {
		return totalRowCount;
	}
	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
	
>>>>>>> refs/heads/heo
}
