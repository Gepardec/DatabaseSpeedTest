package com.gepardec.speedtest.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.lang.time.StopWatch;

import com.gepardec.speedtest.service.SpeedService;

@Model
public class SpeedController {

	@Inject
	private Logger log;

	@Inject
	private SpeedService speedService;

	@Min(0)
	@Max(1000000)
	private Integer numRecords = 10;
	
	private StopWatch stopWatch = new StopWatch();
	private long time;

	private boolean insertFinished;
	private boolean selectFinished;
	private boolean mergeFinished;
	private boolean selectAndModifyFinished;
	private boolean deleteFinished;


	public String insert() {

		log.info("insert started");
		stopWatch.start();
		speedService.insert(numRecords);
		stopWatch.stop();
		setTime(stopWatch.getTime());
		log.info("insert finished after milliseconds: " + getTime());
		insertFinished = true;
		return "index.xhtml";
	}

	public String select() {

		log.info("select started");
		stopWatch.start();
		speedService.select(numRecords);
		stopWatch.stop();
		setTime(stopWatch.getTime());
		log.info("select finished after milliseconds: " + getTime());
		selectFinished = true;
		return "index.xhtml";
	}

	public String merge() {

		log.info("merge started");
		stopWatch.start();
		speedService.merge(numRecords);
		stopWatch.stop();
		setTime(stopWatch.getTime());
		log.info("merge finished after milliseconds: " + getTime());
		mergeFinished = true;
		return "index.xhtml";
	}

	public String selectAndModify() {

		log.info("selectAndModify started");
		stopWatch.start();
		speedService.selectAndModify(numRecords);
		stopWatch.stop();
		setTime(stopWatch.getTime());
		log.info("selectAndModify finished after milliseconds: " + getTime());
		selectAndModifyFinished = true;
		return "index.xhtml";
	}

	public String delete() {

		log.info("delete started");
		stopWatch.start();
		speedService.delete(numRecords);
		stopWatch.stop();
		setTime(stopWatch.getTime());
		log.info("delete finished after milliseconds: " + getTime());
		deleteFinished = true;
		return "index.xhtml";
	}

	public Integer getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(Integer numRecords) {
		this.numRecords = numRecords;
	}

	public boolean isInsertFinished() {
		return insertFinished;
	}

	public void setInsertFinished(boolean insertFinished) {
		this.insertFinished = insertFinished;
	}

	public boolean isSelectFinished() {
		return selectFinished;
	}

	public void setSelectFinished(boolean selectFinished) {
		this.selectFinished = selectFinished;
	}

	public boolean isMergeFinished() {
		return mergeFinished;
	}

	public void setMergeFinished(boolean mergeFinished) {
		this.mergeFinished = mergeFinished;
	}

	public boolean isSelectAndModifyFinished() {
		return selectAndModifyFinished;
	}

	public void setSelectAndModifyFinished(boolean selectAndModifyFinished) {
		this.selectAndModifyFinished = selectAndModifyFinished;
	}

	public boolean isDeleteFinished() {
		return deleteFinished;
	}

	public void setDeleteFinished(boolean deleteFinished) {
		this.deleteFinished = deleteFinished;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
}
