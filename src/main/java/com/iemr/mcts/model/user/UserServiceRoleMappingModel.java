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
package com.iemr.mcts.model.user;

import java.sql.Timestamp;

import com.iemr.mcts.model.userbeneficiary.Status;

import lombok.Data;

public @Data class UserServiceRoleMappingModel
{
	private Long usrMappingID;
	private Long userID;
	private UserModel user;
	private Integer roleID;
	private Role role;
	private Integer serviceID;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMapping;
	private String agentID;
	private String agentPassword;
	private Integer statusID;
	private Status status;
	private Integer workingLocationID;
	private ProviderServiceAddressMappingModel providerServiceAddressMapping;
	private String languageName;
}
