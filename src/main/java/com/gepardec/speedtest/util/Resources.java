package com.gepardec.speedtest.util;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {

	@Produces
	@PersistenceContext(unitName="normal")
	@Normal
	private EntityManager em;
	
	@Produces
	@PersistenceContext(unitName="batchsize")
	@WithBatchsize
	private EntityManager emNormal;

	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
