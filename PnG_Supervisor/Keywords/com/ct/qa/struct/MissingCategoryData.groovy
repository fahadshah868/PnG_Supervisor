package com.ct.qa.struct

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class MissingCategoryData {
	public String maincategory
	public ArrayList<MissingCategoryRemarkData> missingcategoryremarks

	public String subcategory
	public ArrayList<String> missingcategoryremarksdata
	public ArrayList<String> subcategories
	public ArrayList<String> products
	public String subcategories_errormessage
	public String products_errormessage
	public String missingcategoryremarksdata_errormessage
	public String getMaincategory() {
		return maincategory;
	}
	public void setMaincategory(String maincategory) {
		this.maincategory = maincategory;
	}
	public ArrayList<MissingCategoryRemarkData> getMissingcategoryremarks() {
		return missingcategoryremarks;
	}
	public void setMissingcategoryremarks(ArrayList<MissingCategoryRemarkData> missingcategoryremarks) {
		this.missingcategoryremarks = missingcategoryremarks;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public ArrayList<String> getMissingcategoryremarksdata() {
		return missingcategoryremarksdata;
	}
	public void setMissingcategoryremarksdata(ArrayList<String> missingcategoryremarksdata) {
		this.missingcategoryremarksdata = missingcategoryremarksdata;
	}
	public ArrayList<String> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(ArrayList<String> subcategories) {
		this.subcategories = subcategories;
	}
	public ArrayList<String> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}
	public String getSubcategories_errormessage() {
		return subcategories_errormessage;
	}
	public void setSubcategories_errormessage(String subcategories_errormessage) {
		this.subcategories_errormessage = subcategories_errormessage;
	}
	public String getProducts_errormessage() {
		return products_errormessage;
	}
	public void setProducts_errormessage(String products_errormessage) {
		this.products_errormessage = products_errormessage;
	}
	public String getMissingcategoryremarksdata_errormessage() {
		return missingcategoryremarksdata_errormessage;
	}
	public void setMissingcategoryremarksdata_errormessage(String missingcategoryremarksdata_errormessage) {
		this.missingcategoryremarksdata_errormessage = missingcategoryremarksdata_errormessage;
	}
}
