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
package com.iemr.mcts.data.supervisor;

import java.util.Comparator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iemr.mcts.utils.mapper.OutputMapper;

public class DBExcelFieldName {

	@SerializedName("dbColumnName")
	@Expose
	private String dbColumnName;

	@SerializedName("excelColumnName")
	@Expose
	private String excelColumnName;
	
	public DBExcelFieldName() {
		
	}

	public DBExcelFieldName(String dbColumnName, String excelColumnName) {
		
		this.dbColumnName = dbColumnName;
		this.excelColumnName = excelColumnName;
	}

	/**
	 * @return the dbColumnName
	 */
	public String getDbColumnName() {
		return dbColumnName;
	}

	/**
	 * @param dbColumnName
	 *            the dbColumnName to set
	 */
	public void setDbColumnName(String dbColumnName) {
		this.dbColumnName = dbColumnName;
	}

	/**
	 * @return the excelColumnName
	 */
	public String getExcelColumnName() {
		return excelColumnName;
	}

	/**
	 * @param excelColumnName
	 *            the excelColumnName to set
	 */
	public void setExcelColumnName(String excelColumnName) {
		this.excelColumnName = excelColumnName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dbColumnName == null) ? 0 : dbColumnName.hashCode());
		result = prime * result + ((excelColumnName == null) ? 0 : excelColumnName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DBExcelFieldName other = (DBExcelFieldName) obj;
		if (dbColumnName == null) {
			if (other.dbColumnName != null)
				return false;
		} else if (!dbColumnName.equals(other.dbColumnName))
			return false;
		if (excelColumnName == null) {
			if (other.excelColumnName != null)
				return false;
		} else if (!excelColumnName.equals(other.excelColumnName))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return OutputMapper.gson().toJson(this);
	}

	/**
	 * Implements Comparator
	 * @return
	 */
	public static Comparator<DBExcelFieldName> getSortCompoByExcelFieldName() {

		Comparator<DBExcelFieldName> comp = new Comparator<DBExcelFieldName>() {

			@Override
			public int compare(DBExcelFieldName o1, DBExcelFieldName o2) {

				return o1.getExcelColumnName().compareTo(o2.excelColumnName);
			}

		};

		return comp;
	}
}