package com.myBoard.dto;

public class NoticeForPrevNextVO extends NoticeVO {
	
	private int nextNo;
	private String nextTitle;
	private int prevNo;
	private String privTitle;
	
	public int getNextNo() {
		return nextNo;
	}
	public void setNextNo(int nextNo) {
		this.nextNo = nextNo;
	}
	public String getNextTitle() {
		return nextTitle;
	}
	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}
	public int getPrevNo() {
		return prevNo;
	}
	public void setPrevNo(int prevNo) {
		this.prevNo = prevNo;
	}
	public String getPrivTitle() {
		return privTitle;
	}
	public void setPrivTitle(String privTitle) {
		this.privTitle = privTitle;
	}
	
	

}
