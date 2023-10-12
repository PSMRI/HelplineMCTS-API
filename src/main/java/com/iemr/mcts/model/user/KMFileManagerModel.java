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

import lombok.Data;

public @Data class KMFileManagerModel
{
	private Integer kmFileManagerID;
	private NotificationModel notificationModel;
	private String fileUID;
	private String fileName;
	private String fileExtension;
	private String versionNo;
	private String fileCheckSum;
	private Integer providerServiceMapID;
	private Integer userID;
	private String kmUploadStatus;
	private Timestamp validFrom;
	private Timestamp validUpto;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer categoryID;
	private Integer subCategoryID;
	private String fileContent;
}
