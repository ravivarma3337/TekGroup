package com.tek;


public class VehicleDetails {

	int detailNo;
	String description;

	public int getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VehicleDetails(int detailNo, String description) {
		super();
		this.detailNo = detailNo;
		this.description = description;
	}

	public VehicleDetails() {
	}

}
