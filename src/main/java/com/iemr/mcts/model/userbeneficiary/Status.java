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
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;
import com.iemr.mcts.model.user.ProviderServiceMappingModel;
import com.iemr.mcts.model.user.ServiceProvider;
import com.iemr.mcts.model.user.UserModel;
import com.iemr.mcts.model.user.UserServiceRoleMappingModel;

import lombok.Data;

public @Data class Status
{
	private Integer statusID;
	private List<UserModel> m_Users;
	private List<BeneficiaryModel> beneficiaryModels;
	private List<ServiceProvider> serviceProviders;
	private List<ProviderServiceMappingModel> providerServiceMappingModels;
	private List<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	private String status;
	private String statusDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
