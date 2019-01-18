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

public class Question {
	public String question
	public String value
	public String picture_status
	public String overwrite_value
	public String overwrite_picture_status

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPicture_status() {
		return picture_status;
	}
	public void setPicture_status(String picture_status) {
		this.picture_status = picture_status;
	}
	public String getOverwrite_value() {
		return overwrite_value;
	}
	public void setOverwrite_value(String overwrite_value) {
		this.overwrite_value = overwrite_value;
	}
	public String getOverwrite_picture_status() {
		return overwrite_picture_status;
	}
	public void setOverwrite_picture_status(String overwrite_picture_status) {
		this.overwrite_picture_status = overwrite_picture_status;
	}
}
