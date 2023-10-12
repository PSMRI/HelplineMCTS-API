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
package com.iemr.mcts.utils.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class OutputMapper {
	static GsonBuilder builder;
	static GsonBuilder builderWithoutExposeRestriction;

	public OutputMapper() {
		if (builder == null) {
			builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
			builder.excludeFieldsWithoutExposeAnnotation();
			builder.serializeNulls();
		}
		if (builderWithoutExposeRestriction == null) {
			builderWithoutExposeRestriction = new GsonBuilder();
			builderWithoutExposeRestriction.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builderWithoutExposeRestriction.setLongSerializationPolicy(LongSerializationPolicy.STRING);
		}
	}

	public static Gson gson() {
		return builder.create();
	}

	public static Gson gsonWithoutExposeRestriction() {
		return builderWithoutExposeRestriction.create();
	}
}