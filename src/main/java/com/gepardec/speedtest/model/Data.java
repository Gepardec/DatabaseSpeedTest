package com.gepardec.speedtest.model;

import java.io.Serializable;

public class Data implements Serializable{

	private long insertTime;
	private long selectTime;
	private long mergeTime;
	private long selectAndModifyTime;
	private long deleteTime;

	public void setInsertTime(long insertTime) {
		this.insertTime = insertTime;

	}

	public long getInsertTime() {
		return insertTime;
	}

	public long getSelectTime() {
		return selectTime;
	}

	public void setSelectTime(long selectTime) {
		this.selectTime = selectTime;
	}

	public long getMergeTime() {
		return mergeTime;
	}

	public void setMergeTime(long mergeTime) {
		this.mergeTime = mergeTime;
	}

	public long getSelectAndModifyTime() {
		return selectAndModifyTime;
	}

	public void setSelectAndModifyTime(long selectAndModifyTime) {
		this.selectAndModifyTime = selectAndModifyTime;
	}

	public long getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(long deleteTime) {
		this.deleteTime = deleteTime;
	}

}