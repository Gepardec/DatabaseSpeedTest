package com.gepardec.speedtest.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gepardec.speedtest.model.GepardecSpeedTestTempTable;

@Stateless
public class SpeedService {

	@Inject
	private EntityManager em;

	@Inject
	private Logger log;

	public void insert(Integer numRecords) {
		for (int i = 1; i <= numRecords; i++) {
			GepardecSpeedTestTempTable gepardecSpeedTestTempTable = new GepardecSpeedTestTempTable();
			gepardecSpeedTestTempTable.setId(i);
			gepardecSpeedTestTempTable.setName("Name" + i);
			em.persist(gepardecSpeedTestTempTable);
			log.info("gepardecSpeedTestTempTable inserted: " + gepardecSpeedTestTempTable.getName());
		}

	}

	public void select(Integer numRecords) {
		for (int i = 1; i <= numRecords; i++) {
			GepardecSpeedTestTempTable gepardecSpeedTestTempTable = em.find(GepardecSpeedTestTempTable.class, i);
			log.info("gepardecSpeedTestTempTable selected: " + gepardecSpeedTestTempTable.getName());
		}
	}

	public void merge(Integer numRecords) {
		for (int i = 1; i <= numRecords; i++) {
			GepardecSpeedTestTempTable gepardecSpeedTestTempTable = new GepardecSpeedTestTempTable();
			gepardecSpeedTestTempTable.setId(i);
			gepardecSpeedTestTempTable.setName("Name merged:" + i);
			GepardecSpeedTestTempTable gepardecSpeedTestTempTableMerged = em.merge(gepardecSpeedTestTempTable);
			log.info("gepardecSpeedTestTempTable merged: " + gepardecSpeedTestTempTableMerged.getName());
		}
	}

	public void selectAndModify(Integer numRecords) {
		for (int i = 1; i <= numRecords; i++) {
			GepardecSpeedTestTempTable gepardecSpeedTestTempTable = em.find(GepardecSpeedTestTempTable.class, i);
			gepardecSpeedTestTempTable.setName("Name selectAndModify" + i);
			log.info("gepardecSpeedTestTempTable selectAndModified: " + gepardecSpeedTestTempTable.getName());
		}
	}

	public void delete(Integer numRecords) {
		for (int i = 1; i <= numRecords; i++) {
			GepardecSpeedTestTempTable gepardecSpeedTestTempTable = em.find(GepardecSpeedTestTempTable.class, i);
			em.remove(gepardecSpeedTestTempTable);
			log.info("gepardecSpeedTestTempTable deleted: " + gepardecSpeedTestTempTable.getName());
		}
	}
}
