package com.ct.qa.struct

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class SDUnit {
	public String unit
	public String remark
	public String sub_remark
	public String overwrite_remark
	public String overwrite_subremark
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSub_remark() {
		return sub_remark;
	}
	public void setSub_remark(String sub_remark) {
		this.sub_remark = sub_remark;
	}
	public String getOverwrite_remark() {
		return overwrite_remark;
	}
	public void setOverwrite_remark(String overwrite_remark) {
		this.overwrite_remark = overwrite_remark;
	}
	public String getOverwrite_subremark() {
		return overwrite_subremark;
	}
	public void setOverwrite_subremark(String overwrite_subremark) {
		this.overwrite_subremark = overwrite_subremark;
	}
}

