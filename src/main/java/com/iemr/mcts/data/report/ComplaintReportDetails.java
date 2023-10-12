/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mcts.data.report;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class ComplaintReportDetails {

	private Long motherIDchildID;
	
	private String beneficiaryCallerName;

	private String beneficiaryPhoneNumber;
	
	private String anotherContactNumber;
	
	private String districtName = "";
	
	private String block="";
	
	private String village="";
	
	private String callType="";
	
	private String displayCallType="";
	
	private String typeOfComplain = "";

	private String natureOfComplaint;

	private String instituteName;

	private String designation = "";

	private String complaintAgainst = "";
	
	private Timestamp dateOfComplaint;

	private String briefofComplaint = "";
	
	private String detailsofComplaint = "";
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}




}
