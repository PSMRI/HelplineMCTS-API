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
package com.iemr.mcts.config.quartz;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.iemr.mcts.utils.config.ConfigProperties;

@Configuration
public class QuartzConfig {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
		log.debug("QuartzConfig initialized.");
	}

	@Bean
	public SchedulerFactoryBean quartzScheduler() {
		SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();

		quartzScheduler.setTransactionManager(transactionManager);
		quartzScheduler.setOverwriteExistingJobs(true);
		quartzScheduler.setSchedulerName("jelies-quartz-scheduler");

		// custom job factory of spring with DI support for @Autowired!
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		quartzScheduler.setJobFactory(jobFactory);

		quartzScheduler.setQuartzProperties(quartzProperties());

		Trigger[] triggers = { processMQTriggerForSMS().getObject() };

		quartzScheduler.setTriggers(triggers);

		return quartzScheduler;
	}

	@Bean
	public JobDetailFactoryBean processMQJobForSMS() {
		JobDetailFactoryBean jobDetailFactory;
		jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(ScheduleJobServiceForSMS.class);
		jobDetailFactory.setGroup("spring-quartz");
		return jobDetailFactory;
	}

	@Bean
	public CronTriggerFactoryBean processMQTriggerForSMS() {
		log.debug("SMS Scheduler Start");

		Boolean startJob = ConfigProperties.getBoolean("start-sms-scheduler");
		CronTriggerFactoryBean cronTriggerFactoryBean = null;
		String scheduleConfig = "1 0 0 * * ?";
		if (startJob) {
			scheduleConfig = ConfigProperties.getPropertyByName("cron-scheduler-sms");
		}
		cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(processMQJobForSMS().getObject());

		cronTriggerFactoryBean.setCronExpression(scheduleConfig);
		cronTriggerFactoryBean.setGroup("spring-quartz");

		log.debug("SMS Scheduler End");

		return cronTriggerFactoryBean;
	}

	@Bean
	public Properties quartzProperties() {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/application.properties"));
		Properties properties = null;
		try {
			propertiesFactoryBean.afterPropertiesSet();
			properties = propertiesFactoryBean.getObject();

		} catch (IOException e) {
			log.warn("Cannot load application.properties.");
		}

		return properties;
	}
}
