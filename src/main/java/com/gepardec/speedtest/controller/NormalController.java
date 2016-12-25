package com.gepardec.speedtest.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang.time.StopWatch;

import com.gepardec.speedtest.model.NormalData;
import com.gepardec.speedtest.service.SpeedTestService;
import com.gepardec.speedtest.util.Normal;

@Model
public class NormalController {

	@Inject
	private Logger log;

	@Inject
	private SpeedTestController speedTestController;

	@Inject
	private SpeedTestService normalService;

	@Inject
	@Normal
	private EntityManager em;

	private StopWatch stopWatch = new StopWatch();

	@Inject
	private NormalData normalData;

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
		normalData.setInsertTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("insert finished after milliseconds: " + normalData.getInsertTime());
		return "index.xhtml";
	}

	public String select() {

		log.info("select started");
		stopWatch.start();
		normalService.select(em, speedTestController.getNumRecords());
		stopWatch.stop();
		normalData.setSelectTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("select finished after milliseconds: " + normalData.getSelectTime());
		return "index.xhtml";
	}

	public String merge() {

		log.info("merge started");
		stopWatch.start();
		normalService.merge(em, speedTestController.getNumRecords());
		stopWatch.stop();
		normalData.setMergeTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("merge finished after milliseconds: " + normalData.getMergeTime());
		return "index.xhtml";
	}

	public String selectAndModify() {

		log.info("selectAndModify started");
		stopWatch.start();
		normalService.selectAndModify(em, speedTestController.getNumRecords());
		stopWatch.stop();
		normalData.setSelectAndModifyTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("selectAndModify finished after milliseconds: " + normalData.getSelectAndModifyTime());
		return "index.xhtml";
	}

	public String delete() {

		log.info("delete started");
		stopWatch.start();
		normalService.delete(em, speedTestController.getNumRecords());
		stopWatch.stop();
		normalData.setDeleteTime(stopWatch.getTime());
		stopWatch.reset();
		log.info("delete finished after milliseconds: " + normalData.getDeleteTime());
		return "index.xhtml";
	}
}
