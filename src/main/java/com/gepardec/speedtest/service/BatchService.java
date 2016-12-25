package com.gepardec.speedtest.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gepardec.speedtest.domain.GepardecSpeedTestTempTable;
import com.gepardec.speedtest.util.WithBatchsize;

@Stateless
public class BatchService {

	@Inject
	@WithBatchsize
	private EntityManager em;

	@Inject
	private Logger log;

	public void insert(Integer numRecords) {

		try {
			for (int i = 1; i <= numRecords; i++) {
				GepardecSpeedTestTempTable gepardecSpeedTestTempTable = new GepardecSpeedTestTempTable();
				gepardecSpeedTestTempTable.setId(i);
				gepardecSpeedTestTempTable.setName("Name" + i);
				em.persist(gepardecSpeedTestTempTable);
				log.info("gepardecSpeedTestTempTable inserted: " + gepardecSpeedTestTempTable.getName());
			}
		} catch (Exception e) {
			log.warning(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}

	}

	public void select(Integer numRecords) {
		for (int i = 1; i <= numRecords; i++) {
			GepardecSpeedTestTempTable gepardecSpeedTestTempTable = em.find(GepardecSpeedTestTempTable.class, i);
			log.info("gepardecSpeedTestTempTable selected: " + gepardecSpeedTestTempTable.getName());
		}
	}

	public void merge(Integer numRecords) {
		try {
			for (int i = 1; i <= numRecords; i++) {
				GepardecSpeedTestTempTable gepardecSpeedTestTempTable = new GepardecSpeedTestTempTable();
				gepardecSpeedTestTempTable.setId(i);
				gepardecSpeedTestTempTable.setName("Name merged:" + i);
				GepardecSpeedTestTempTable gepardecSpeedTestTempTableMerged = em.merge(gepardecSpeedTestTempTable);
				log.info("gepardecSpeedTestTempTable merged: " + gepardecSpeedTestTempTableMerged.getName());
			}
		} catch (Exception e) {
			log.warning(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void selectAndModify(Integer numRecords) {
		try {
			for (int i = 1; i <= numRecords; i++) {
				GepardecSpeedTestTempTable gepardecSpeedTestTempTable = em.find(GepardecSpeedTestTempTable.class, i);
				gepardecSpeedTestTempTable.setName("Name selectAndModify" + i);
				log.info("gepardecSpeedTestTempTable selectAndModified: " + gepardecSpeedTestTempTable.getName());
			}
		} catch (Exception e) {
			log.warning(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void delete(Integer numRecords) {
		try {
			for (int i = 1; i <= numRecords; i++) {
				GepardecSpeedTestTempTable gepardecSpeedTestTempTable = em.find(GepardecSpeedTestTempTable.class, i);
				em.remove(gepardecSpeedTestTempTable);
				log.info("gepardecSpeedTestTempTable deleted: " + gepardecSpeedTestTempTable.getName());
			}
		} catch (Exception e) {
			log.warning(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
}
