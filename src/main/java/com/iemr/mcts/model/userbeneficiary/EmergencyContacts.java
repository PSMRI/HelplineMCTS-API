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
package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;

import com.iemr.mcts.model.user.NotificationType;
import com.iemr.mcts.model.user.ProviderServiceMappingModel;

import lombok.Data;

public @Data class EmergencyContacts
{
	private Integer emergContactID;
	private Integer designationID;
	private DesignationModel designationModel;
	private String emergContactName;
	private String emergContactNo;
	private String emergContactDesc;
	private String location;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Integer notificationTypeID;
	private NotificationType notificationType;
	private Boolean deleted;
	private String processed;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
