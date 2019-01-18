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

public class VisitedCategoryRemarkData {
	public String categoryremark
	public String firstvisit_categoryremark_subremark
	public String overwrite_categoryremark_subremark
	public ArrayList<SDUnit> sdunits
	public ArrayList<SubCategory> subcategories
	public ArrayList<Question> kbd_questions

	public VisitedCategoryRemarkData(){
		subcategories = new ArrayList<SubCategory>()
		sdunits = new ArrayList<SDUnit>()
	}

	public ArrayList<Question> getKbd_questions() {
		return kbd_questions;
	}
	public void setKbd_questions(ArrayList<Question> kbd_questions) {
		this.kbd_questions = kbd_questions;
	}
	public String getFirstvisit_categoryremark_subremark() {
		return firstvisit_categoryremark_subremark;
	}
	public void setFirstvisit_categoryremark_subremark(String firstvisit_categoryremark_subremark) {
		this.firstvisit_categoryremark_subremark = firstvisit_categoryremark_subremark;
	}
	public String getOverwrite_categoryremark_subremark() {
		return overwrite_categoryremark_subremark;
	}
	public void setOverwrite_categoryremark_subremark(String overwrite_categoryremark_subremark) {
		this.overwrite_categoryremark_subremark = overwrite_categoryremark_subremark;
	}
	public String getCategoryremark() {
		return categoryremark;
	}
	public void setCategoryremark(String categoryremark) {
		this.categoryremark = categoryremark;
	}
	public ArrayList<SDUnit> getSdunits() {
		return sdunits;
	}
	public void setSdunits(SDUnit sdunits) {
		this.sdunits.add(sdunits);
	}
	public ArrayList<SubCategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(SubCategory subcategories) {
		this.subcategories.add(subcategories);
	}
}
