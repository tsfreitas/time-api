package com.tsfreitas.timeapi.model;

import java.util.Date;

public class Timezone {

	private String zoneName;
	private String countryCode;
	private String offset;
	private String timeDate;

	public Timezone(String zoneName, String countryCode, Long gmtOffset, Long timestamp) {
		this.zoneName = zoneName;
		this.countryCode = countryCode;
		formatOffset(gmtOffset);
		formatDate(timestamp);
	}

	private void formatOffset(Long gmtOffset) {
		long hours = gmtOffset / 3600;
		String sign = hours >= 0 ? "+" : "-";

		offset = String.format("GMT%s%d", sign, hours);
	}

	private void formatDate(Long timestamp) {
		// Necessário conveter tempo em miliisegundo
		timestamp *= 1000;
		this.timeDate = new Date(timestamp).toString();
	}

	public String getZoneName() {
		return zoneName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getOffset() {
		return offset;
	}

	public String getTimeDate() {
		return timeDate;
	}

}
