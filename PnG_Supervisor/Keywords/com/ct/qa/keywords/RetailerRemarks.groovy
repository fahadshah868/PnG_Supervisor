package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
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
import io.appium.java_client.MobileElement

public class RetailerRemarks {

	@Keyword
	def visitRetailerRemarks(int flag){
		int totalcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalcategories; i++){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RetailerRemarks/Validate_RetailerRemarks_RemarksScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileElement remarkslist = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]")
			ArrayList<MobileElement> totalremarks = remarkslist.findElementsByClassName("android.widget.CheckBox")
			for(int j=0; j< totalremarks.size(); j++){
				MobileElement remark = totalremarks.get(j)
				String remark_text = remark.getText()
				if(flag == 1){
					if(remark_text.equalsIgnoreCase("SR not Visiting")){
						remark.click()
						break
					}
					else{}
				}
				else{
					if(remark_text.equalsIgnoreCase("Incentive not paid")){
						remark.click()
						break
					}
					else{}
				}
			}
			Mobile.pressBack()
			Mobile.verifyElementText(findTestObject('ShopOpen/RetailerRemarks/Validate_RetailerRemarks', [('package') : ProjectConstants.PACKAGENAME]), 'KPI: Retailer Remarks')
		}
	}
}
