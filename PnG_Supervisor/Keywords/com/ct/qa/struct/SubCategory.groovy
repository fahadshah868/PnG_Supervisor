package com.ct.qa.struct

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.ArrayList

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

public class SubCategory {
	public String subcategory
	public String firstvisit_remark
	public String overwrite_remark
	public ArrayList<ShopProductsData> shopproductsdata
	public ArrayList<Question> surveyquestions
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getFirstvisit_remark() {
		return firstvisit_remark;
	}
	public void setFirstvisit_remark(String firstvisit_remark) {
		this.firstvisit_remark = firstvisit_remark;
	}
	public String getOverwrite_remark() {
		return overwrite_remark;
	}
	public void setOverwrite_remark(String overwrite_remark) {
		this.overwrite_remark = overwrite_remark;
	}
	public ArrayList<ShopProductsData> getShopproductsdata() {
		return shopproductsdata;
	}
	public void setShopproductsdata(ArrayList<ShopProductsData> shopproductsdata) {
		this.shopproductsdata = shopproductsdata;
	}
	public ArrayList<Question> getSurveyquestions() {
		return surveyquestions;
	}
	public void setSurveyquestions(ArrayList<Question> surveyquestions) {
		this.surveyquestions = surveyquestions;
	}
}
