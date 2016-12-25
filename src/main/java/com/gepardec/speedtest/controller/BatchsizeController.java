package com.gepardec.speedtest.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang.time.StopWatch;

import com.gepardec.speedtest.model.BatchsizeData;
import com.gepardec.speedtest.service.SpeedTestService;
import com.gepardec.speedtest.util.WithBatchsize;

@Model
public class BatchsizeController {

	@Inject
	private Logger log;

	@Inject
	private SpeedTestController speedTestController;

	@Inject
	private SpeedTestService normalService;

	@Inject
	@WithBatchsize
	private EntityManager em;

	private StopWatch stopWatch = new StopWatch();

	@Inject
	private BatchsizeData batchsizeData;

	public String all(){
		insert();
		select();
		merge();
		selectAndModify();
		delete();
		return "index.xhtml";
	}
	
	public String insert() {

		log.info("insert started");
		stopWatch.start();
		normalService.insert(em, speedTestController.getNumRecords());
		stopWatch.stop();
		batchsizeData.setInsertTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("insert finished after milliseconds: " + batchsizeData.getInsertTime());
		return "index.xhtml";
	}

	public String select() {

		log.info("select started");
		stopWatch.start();
		normalService.select(em, speedTestController.getNumRecords());
		stopWatch.stop();
		batchsizeData.setSelectTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("select finished after milliseconds: " + batchsizeData.getSelectTime());
		return "index.xhtml";
	}

	public String merge() {

		log.info("merge started");
		stopWatch.start();
		normalService.merge(em, speedTestController.getNumRecords());
		stopWatch.stop();
		batchsizeData.setMergeTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("merge finished after milliseconds: " + batchsizeData.getMergeTime());
		return "index.xhtml";
	}

	public String selectAndModify() {

		log.info("selectAndModify started");
		stopWatch.start();
		normalService.selectAndModify(em, speedTestController.getNumRecords());
		stopWatch.stop();
		batchsizeData.setSelectAndModifyTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("selectAndModify finished after milliseconds: " + batchsizeData.getSelectAndModifyTime());
		return "index.xhtml";
	}

	public String delete() {

		log.info("delete started");
		stopWatch.start();
		normalService.delete(em, speedTestController.getNumRecords());
		stopWatch.stop();
		batchsizeData.setDeleteTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("delete finished after milliseconds: " + batchsizeData.getDeleteTime());
		return "index.xhtml";
	}
}
