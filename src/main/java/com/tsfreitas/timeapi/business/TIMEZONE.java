package com.tsfreitas.timeapi.business;

public enum TIMEZONE {

	SAO_PAULO("America/Sao_Paulo"), AUCKLAND("Pacific/Auckland"), NEW_YORK("America/New_York");

	private String zone;

	private TIMEZONE(String zone) {
		this.zone = zone;
	}
	
	public String getZone() {
		return zone;
	}

}
