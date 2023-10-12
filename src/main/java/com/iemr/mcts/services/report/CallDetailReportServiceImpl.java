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
package com.iemr.mcts.services.report;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.report.BenCallDetail;
import com.iemr.mcts.data.report.CallDetailsReport;
import com.iemr.mcts.data.report.UniqueCallReport;
import com.iemr.mcts.mapper.report.MctsReportmapper;
import com.iemr.mcts.repository.report.CallDetailReportRepository;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class CallDetailReportServiceImpl implements CallDetailReportService{

	Logger logger = LoggerFactory.getLogger(ComplaintReportServiceImpl.class);
	
	private InputMapper inputMapper = new InputMapper();
	
	private CallDetailReportRepository callDetailReportRepository;

	/**
	 * @param callDetailReportRepository the callDetailReportRepository to set
	 */
	@Autowired
	public void setCallDetailReportRepository(CallDetailReportRepository callDetailReportRepository) {
		this.callDetailReportRepository = callDetailReportRepository;
	}

	@Autowired
	MctsReportmapper mapper;
	
	@Override
	public String getCallDetailReport(String request) throws Exception
	{
		logger.info("MctsReportService.getCallDetailReport - start");
		
		BenCallDetail benCallDetail = inputMapper.gson().fromJson(request,BenCallDetail.class);
		
		List<BenCallDetail> benMotherCallList=new ArrayList<BenCallDetail>();
		
		List<BenCallDetail> benChildCallList=new ArrayList<BenCallDetail>();
		
		List<CallDetailsReport> CallDetailsReportList=new ArrayList<CallDetailsReport>();
		if(benCallDetail.getUserID()!=null && benCallDetail.getUserID() >0) {
		
			benMotherCallList=callDetailReportRepository.getMotherCallReportByAgent(benCallDetail.getStartDate(),benCallDetail.getEndDate()
				, benCallDetail.getProviderServiceMapID(), benCallDetail.getUserID());
			
			benChildCallList= callDetailReportRepository.getChildCallReportByAgent(benCallDetail.getStartDate(),benCallDetail.getEndDate()
					, benCallDetail.getProviderServiceMapID(), benCallDetail.getUserID());
		}
		else
		{
			benMotherCallList=callDetailReportRepository.getMotherCallReport(benCallDetail.getStartDate(),benCallDetail.getEndDate()
					, benCallDetail.getProviderServiceMapID());
			
			benChildCallList= callDetailReportRepository.getChildCallReport(benCallDetail.getStartDate(),benCallDetail.getEndDate()
					, benCallDetail.getProviderServiceMapID()) ;
		}
		
		Integer countVerified=0;
		
		for(BenCallDetail bencall : benMotherCallList)
		{
			CallDetailsReport report= mapper.mapMotherCallReport(bencall);
			
			countVerified= callDetailReportRepository.getCountVerified(bencall.getObCallID());
			
			report.setCountVerified(countVerified);
			CallDetailsReportList.add(report);
		}
		
		for(BenCallDetail bencall : benChildCallList)
		{
			CallDetailsReport report= mapper.mapChildCallReport(bencall);
			
			countVerified= callDetailReportRepository.getCountVerified(bencall.getObCallID());

			report.setCountVerified(countVerified);
			CallDetailsReportList.add(report);
		}
		
		logger.info("MctsReportService.getCallDetailReport - end");
		return CallDetailsReportList.toString();
	}

	@Override
	public String getCallDetailReportUnique(String request) throws Exception
	{
		logger.info("MctsReportService.getCallDetailReportUnique - start");
		
		BenCallDetail benCallDetail = inputMapper.gson().fromJson(request,BenCallDetail.class);
		List<UniqueCallReport> uniqueList=new ArrayList<UniqueCallReport>();
		List<BenCallDetail> benCallList=new ArrayList<BenCallDetail>();
		
		if(benCallDetail.getUserID()!=null && benCallDetail.getUserID() >0) {
		
			benCallList=callDetailReportRepository.getMotherCallReportByAgent(benCallDetail.getStartDate(),benCallDetail.getEndDate()
				, benCallDetail.getProviderServiceMapID(), benCallDetail.getUserID());
		}
		else
		{
			benCallList=callDetailReportRepository.getMotherCallReport(benCallDetail.getStartDate(),benCallDetail.getEndDate()
					, benCallDetail.getProviderServiceMapID());
		}
		for(BenCallDetail bencall : benCallList)
		{
			UniqueCallReport report= mapper.mapUniqueCallReport(bencall);
			uniqueList.add(report);
		}
		
		logger.info("MctsReportService.getCallDetailReportUnique - end");
		return uniqueList.toString();
	}
}