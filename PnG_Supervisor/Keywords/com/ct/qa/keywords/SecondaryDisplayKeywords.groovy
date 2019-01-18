package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.SDUnit
import com.ct.qa.struct.ScenariosCombination
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedCategoryRemarkData
import com.ct.qa.struct.VisitedShopDataInfo
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
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

public class SecondaryDisplayKeywords {

	AppiumDriver<MobileElement> driver = ProjectConstants.DRIVER;

	@Keyword
	def enterUnitsForSecondaryDisplay(){
		MobileElement editfield1 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
		MobileElement editfield2 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
		editfield1.setValue("4")
		Mobile.hideKeyboard()
		editfield2.setValue("4")
		Mobile.hideKeyboard()
	}
	@Keyword
	def enterUtilizationForSecondaryDisplay(int status){
		MobileElement editfield = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
		if(status == 1){
			editfield.setValue("50")
		}
		else{
			editfield.setValue("100")
		}
	}
	@Keyword
	def selectSecondaryDisplayRemark_WithDataVerification(){
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String remarkname = remark.getText()
			if(remarkname.equalsIgnoreCase("Available")){
				ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK = remarkname
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitSecondaryDisplayAvailable"), null)
				break
			}
		}
	}
	@Keyword
	def selectSecondaryDisplayRemark_WithOverwriteScenarios(){
		ArrayList<ScenariosCombination> scenarioscombination = new ArrayList<ScenariosCombination>()
		int remarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size();
		for(int j=1; j<= remarks; j++){
			for(int k=1; k<= remarks; k++){
				ScenariosCombination _scenarioscombination = new ScenariosCombination()
				_scenarioscombination.setFirstvisit_scenario(j)
				_scenarioscombination.setOverwrite_scenario(k)
				scenarioscombination.add(_scenarioscombination)
			}
		}
		if(scenarioscombination.size() >= ProjectConstants.SHOP_ATTEMPT){
			ScenariosCombination scenario = scenarioscombination.get((ProjectConstants.SHOP_ATTEMPT-1))
			if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
				MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]/android.widget.TextView[1]")
				String remarktext = remark.getText()
				ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK = remarktext
				if(remarktext.equalsIgnoreCase("Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitSecondaryDisplayAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotAvailable/VisitNotAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Recommended For This Channel")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotRecommended/VisitNotRecommended"), null)
				}
				else{}
			}
			else{
				MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]/android.widget.TextView[1]")
				String remarktext = remark.getText()
				ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK = remarktext
				if(remarktext.equalsIgnoreCase("Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteSecondaryDisplayAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotAvailable/VisitNotAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Recommended For This Channel")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotRecommended/VisitNotRecommended"), null)
				}
				else{}
			}
		}
		else{
			MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
			String remarktext = remark.getText()
			ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK = remarktext
			if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
				if(remarktext.equalsIgnoreCase("Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitSecondaryDisplayAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotAvailable/VisitNotAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Recommended For This Channel")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotRecommended/VisitNotRecommended"), null)
				}
				else{}
			}
			else{
				if(remarktext.equalsIgnoreCase("Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteSecondaryDisplayAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotAvailable/VisitNotAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Recommended For This Channel")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/NotRecommended/VisitNotRecommended"), null)
				}
				else{}
			}
		}
	}
	@Keyword
	def visitSecondaryDisplayUnitsList(){
		int totalunits = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalunits; i++){
			ProjectConstants.CURRENTVISITING_UNIT = "Unit"+i
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_SKDNA"), null)
			}
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailableWith_SKDNA"), null)
			}
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailable_WithDisplayUnitIsInPerfectCondition"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/VisitAvailable_WithDisplayUnitIsInPerfectCondition"), null)
			}
		}
	}
	@Keyword
	def overwriteSecondaryDisplayUnitsList(){
		int totalunits = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalunits; i++){
			ProjectConstants.CURRENTVISITING_UNIT = "Unit"+i
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteAvailableWith_SKDNA"), null)
			}
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/OverwriteAvailableWith_DisplayUnitNeedMaintenance"), null)
			}
		}
	}
	@Keyword
	def selectSecondaryDisplay_AvailableRemark(String _remark, int index){
		String remarkname = ""
		String subremark_text = ""
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			remarkname = remark.getText()
			if(remarkname.equalsIgnoreCase(_remark)){
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				if(index == 1 || index == 2){
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_SecondaryDisplay_available_remarksScreen",[('package') : ProjectConstants.PACKAGENAME]), 0)
					MobileElement subremark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
					subremark_text = subremark.getText()
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				}
				else{
					subremark_text = ""
				}
				break
			}
		}
		SDUnit sdunit = new SDUnit()
		VisitedCategoryRemarkData visitedcategoryremark = new VisitedCategoryRemarkData()
		visitedcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
			visitedcategoryremark.setFirstvisit_categoryremark_subremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK)
			sdunit.setUnit(ProjectConstants.CURRENTVISITING_UNIT)
			sdunit.setRemark(remarkname)
			sdunit.setSub_remark(subremark_text)
		}
		else{
			visitedcategoryremark.setFirstvisit_categoryremark_subremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK)
			sdunit.setUnit(ProjectConstants.CURRENTVISITING_UNIT)
			sdunit.setOverwrite_remark(remarkname)
			sdunit.setOverwrite_subremark(subremark_text)
		}
		visitedcategoryremark.setSdunits(sdunit)
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		visitedcategory.setVisitedcategoryremarks(visitedcategoryremark)

		for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
			if(ProjectConstants.visitedshopdatainfo.get(i).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
				VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
				ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
				if(visitedcategoriesdata != null){
					boolean maincategory_flag = false
					for(int k=0; k<visitedcategoriesdata.size(); k++){
						VisitedCategoryData visitedcategorydata = visitedcategoriesdata.get(k)
						if(visitedcategorydata.getMaincategory().equals(visitedcategory.getMaincategory())){
							maincategory_flag = true
							ArrayList<VisitedCategoryRemarkData> visitedcategoryremarksdata = visitedcategorydata.getVisitedcategoryremarks()
							if(visitedcategoryremarksdata != null){
								boolean categoryremark_flag = false
								for(int m=0; m< visitedcategoryremarksdata.size(); m++){
									VisitedCategoryRemarkData visitedcategoryremarkdata = visitedcategoryremarksdata.get(m)
									if(visitedcategoryremarkdata != null && (visitedcategoryremarkdata.getCategoryremark().equalsIgnoreCase(visitedcategoryremark.getCategoryremark()) && (visitedcategoryremarkdata.getFirstvisit_categoryremark_subremark().equalsIgnoreCase(visitedcategoryremark.getFirstvisit_categoryremark_subremark()) || (visitedcategoryremarkdata.getFirstvisit_categoryremark_subremark().equalsIgnoreCase(visitedcategoryremark.getOverwrite_categoryremark_subremark()))))){
										categoryremark_flag = true
										ArrayList<SDUnit> sdunitsdata = visitedcategoryremarkdata.getSdunits()
										if(sdunitsdata != null){
											boolean unitsflag = false
											for(int c=0; c< sdunitsdata.size(); c++){
												SDUnit sdunitdata = sdunitsdata.get(c)
												if(sdunitdata.getUnit().equals(sdunit.getUnit())){
													unitsflag = true
													if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
														sdunitdata.setRemark(sdunit.getRemark())
														sdunitdata.setSub_remark(sdunit.getSub_remark())
													}
													else{
														sdunitdata.setOverwrite_remark(sdunit.getOverwrite_remark())
														sdunitdata.setOverwrite_subremark(sdunit.getOverwrite_subremark())
													}
												}
											}
											if(unitsflag == false){
												visitedcategoryremarkdata.setSdunits(sdunit)
												break
											}
										}
									}
								}
								if(categoryremark_flag == false){
									visitedcategorydata.setVisitedcategoryremarks(visitedcategoryremark)
									break
								}
							}
						}
					}
					if(maincategory_flag == false){
						ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategory)
						break
					}
				}
				else{
					ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategory)
					break
				}
			}
		}
	}
}
