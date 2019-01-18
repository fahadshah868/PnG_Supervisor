package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.googlecode.javacv.CanvasFrame.Exception
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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.UnmatchedItems
import com.ct.qa.struct.ScenariosCombination

import internal.GlobalVariable
import io.appium.java_client.MobileElement
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class CategoryVisitingScenariosKeywords{
	@Keyword
	def visitShopCategoriesWithDataVerification(){
		MobileElement channel = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
		ProjectConstants.CURRENTVISITING_SHOPCHANNEL = channel.getText()
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
					break
				}
				else{
				}
			}
		}
		else{
		}
		Mobile.swipe(0, 200, 0, 750)
		Mobile.swipe(0, 200, 0, 750)
		int index = 0
		String lastvisitedcategory = ""
		int totalcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= 1; i++){
			MobileElement category = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String categoryname = category.getText()
			if(categoryname.equalsIgnoreCase("Additional Picture")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/AdditionalPicture/VisitAdditionalPicture"), null)
			}
			else if(categoryname.equalsIgnoreCase("Retailer Remarks")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RetailerRemarks/VisitRetailerRemarks"), null)
			}
			else if(categoryname.equalsIgnoreCase("Market Intelligence")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/MarketIntelligence/VisitMarketIntelligence"), null)
				Mobile.swipe(0, 200, 0, 750)
				Mobile.swipe(0, 200, 0, 750)
			}
			else if(categoryname.equalsIgnoreCase("Hanger")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerVisitingScenarios/VisitHangerWithDataVerification"), null)
			}
			else if(categoryname.equalsIgnoreCase("HotSpot")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotSpotAvailableForDataVerification"), null)
			}
			else if(categoryname.equalsIgnoreCase("Survey")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitSurveyQuestionsWithYesRemark"), null)
			}
			else{
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/MainCategoryRemarksVisitingScenarios/VisitRemarksWith_DataVerification"), null)
			}
		}
		//		while(true){
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//			Mobile.swipe(0, 293, 0, 200)
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnameafterswipe = lastitemafterswipe.getText()
		//			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//				break
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Additional Picture")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/AdditionalPicture/VisitAdditionalPicture"), null)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Retailer Remarks")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RetailerRemarks/VisitRetailerRemarks"), null)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Market Intelligence")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/MarketIntelligence/VisitMarketIntelligence"), null)
		//				Mobile.swipe(0, 200, 0, 750)
		//				Mobile.swipe(0, 200, 0, 750)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("HotSpot")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotSpotAvailableForDataVerification"), null)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Hanger")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerVisitingScenarios/VisitHangerWithDataVerification"), null)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Survey")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitSurveyQuestionsWithYesRemark"), null)
		//			}
		//			else{
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/MainCategoryRemarksVisitingScenarios/VisitRemarksWith_DataVerification"), null)
		//			}
		//			while(true){
		//				Mobile.swipe(0, 293, 0, 200)
		//				index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		//				MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//				String productname = product.getText()
		//				if(productname.equalsIgnoreCase(lastvisitedcategory)){
		//					break
		//				}
		//			}
		//		}
	}

	/********************************************************************
	 VISIT SHOP MAIN CATEGORIES WITH OVERWRITE SCENARIOS
	 *******************************************************************/

	@Keyword
	def visitShopCategoriesWithOverwriteScenarios(){
		ArrayList<ScenariosCombination> scenarioscombination = new ArrayList<ScenariosCombination>()
		MobileElement channel = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
		ProjectConstants.CURRENTVISITING_SHOPCHANNEL = channel.getText()
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
					break
				}
				else{
				}
			}
		}
		else{
		}
		Mobile.swipe(0, 200, 0, 750)
		Mobile.swipe(0, 200, 0, 750)
		int index = 0
		String lastvisitedcategory = ""
		int totalcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= 1; i++){
			MobileElement category = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String categoryname = category.getText()
			if(categoryname.equalsIgnoreCase("Additional Picture")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/AdditionalPicture/VisitAdditionalPicture"), null)
			}
			else if(categoryname.equalsIgnoreCase("Retailer Remarks")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RetailerRemarks/VisitRetailerRemarks"), null)
			}
			else if(categoryname.equalsIgnoreCase("Market Intelligence")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/MarketIntelligence/VisitMarketIntelligence"), null)
				Mobile.swipe(0, 200, 0, 750)
				Mobile.swipe(0, 200, 0, 750)
			}
			else if(categoryname.equalsIgnoreCase("Hanger")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerVisitingScenarios/VisitHangerWithOverwriteScenarios"), null)
			}
			else if(categoryname.equalsIgnoreCase("HotSpot")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
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
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
					if(remarktext.equalsIgnoreCase("Hotspot Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotSpotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotspotNotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitShopKeeperDidnotAllow"), null)
					}
					else{}
				}
				else{
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
					if(remarktext.equalsIgnoreCase("Hotspot Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotSpotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotspotNotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitShopKeeperDidnotAllow"), null)
					}
					else{}
				}
			}
			else if(categoryname.equalsIgnoreCase("Survey")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitSurveyQuestionsWithYesRemark"), null)
			}
			else{
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/MainCategoryRemarksVisitingScenarios/VisitRemarksWith_OverwriteScenarios"), null)
			}
		}
		//		while(true){
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//			Mobile.swipe(0, 293, 0, 200)
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnameafterswipe = lastitemafterswipe.getText()
		//			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//				break
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Additional Picture")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/AdditionalPicture/VisitAdditionalPicture"), null)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Retailer Remarks")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RetailerRemarks/VisitRetailerRemarks"), null)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Market Intelligence")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/MarketIntelligence/VisitMarketIntelligence"), null)
		//				Mobile.swipe(0, 200, 0, 750)
		//				Mobile.swipe(0, 200, 0, 750)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("HotSpot")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
		//				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
		//				int remarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size();
		//				for(int j=1; j<= remarks; j++){
		//					for(int k=1; k<= remarks; k++){
		//						ScenariosCombination _scenarioscombination = new ScenariosCombination()
		//						_scenarioscombination.setFirstvisit_scenario(j)
		//						_scenarioscombination.setOverwrite_scenario(k)
		//						scenarioscombination.add(_scenarioscombination)
		//					}
		//				}
		//				if(scenarioscombination.size() >= ProjectConstants.SHOP_ATTEMPT){
		//					ScenariosCombination scenario = scenarioscombination.get((ProjectConstants.SHOP_ATTEMPT-1))
		//					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]/android.widget.TextView[1]")
		//					String remarktext = remark.getText()
		//					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
		//					if(remarktext.equalsIgnoreCase("Hotspot Available")){
		//						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotSpotAvailable"), null)
		//					}
		//					else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
		//						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotspotNotAvailable"), null)
		//					}
		//					else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
		//						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitShopKeeperDidnotAllow"), null)
		//					}
		//					else{}
		//				}
		//				else{
		//					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
		//					String remarktext = remark.getText()
		//					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
		//					if(remarktext.equalsIgnoreCase("Hotspot Available")){
		//						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotSpotAvailable"), null)
		//					}
		//					else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
		//						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitHotspotNotAvailable"), null)
		//					}
		//					else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
		//						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
		//						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/VisitShopKeeperDidnotAllow"), null)
		//					}
		//					else{}
		//				}
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Hanger")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerVisitingScenarios/VisitHangerWithOverwriteScenarios"), null)
		//			}
		//			else if(lastitemnameafterswipe.equalsIgnoreCase("Survey")){
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitSurveyQuestionsWithYesRemark"), null)
		//			}
		//			else{
		//				lastvisitedcategory = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/MainCategoryRemarksVisitingScenarios/VisitRemarksWith_OverwriteScenarios"), null)
		//			}
		//			while(true){
		//				Mobile.swipe(0, 293, 0, 200)
		//				index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		//				MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//				String productname = product.getText()
		//				if(productname.equalsIgnoreCase(lastvisitedcategory)){
		//					break
		//				}
		//			}
		//		}
	}
	@Keyword
	def visitShopCategoriesWithOverwritingScenarios(){
		ArrayList<ScenariosCombination> scenarioscombination = new ArrayList<ScenariosCombination>()
		MobileElement channel = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
		ProjectConstants.CURRENTVISITING_SHOPCHANNEL = channel.getText()
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories(UnmatchedItems_status.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
					break
				}
				else{
				}
			}
		}
		else{
		}
		Mobile.swipe(0, 200, 0, 750)
		Mobile.swipe(0, 200, 0, 750)
		int index = 0
		String lastvisitedcategory = ""
		int totalcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalcategories; i++){
			MobileElement category = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String categoryname = category.getText()
			if(categoryname.equalsIgnoreCase("Additional Picture")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/AdditionalPicture/OverwriteAdditionalPicture"), null)
			}
			else if(categoryname.equalsIgnoreCase("Retailer Remarks")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RetailerRemarks/OverwriteRetailerRemarks"), null)
			}
			else if(categoryname.equalsIgnoreCase("Market Intelligence")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/MarketIntelligence/OverwriteMarketIntelligence"), null)
			}
			else if(categoryname.equalsIgnoreCase("Hanger")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerVisitingScenarios/VisitHangerWithOverwritingScenarios"), null)
			}
			else if(categoryname.equalsIgnoreCase("HotSpot")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
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
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
					if(remarktext.equalsIgnoreCase("Hotspot Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteHotSpotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteHotspotNotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteShopKeeperDidnotAllow"), null)
					}
					else{}
				}
				else{
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
					if(remarktext.equalsIgnoreCase("Hotspot Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteHotSpotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteHotspotNotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteShopKeeperDidnotAllow"), null)
					}
					else{}
				}
			}
			else if(categoryname.equalsIgnoreCase("Survey")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitSurveyQuestionsWithNoRemark"), null)
			}
			else{
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/MainCategoryRemarksVisitingScenarios/VisitRemarksWith_OverwritingScenarios"), null)
			}
		}
		while(true){
			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement lastitembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
			Mobile.swipe(0, 293, 0, 200)
			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String lastitemnameafterswipe = lastitemafterswipe.getText()
			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
				break
			}
			else if(lastitemnameafterswipe.equalsIgnoreCase("Additional Picture")){
				lastvisitedcategory = lastitemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/AdditionalPicture/OverwriteAdditionalPicture"), null)
			}
			else if(lastitemnameafterswipe.equalsIgnoreCase("Retailer Remarks")){
				lastvisitedcategory = lastitemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RetailerRemarks/OverwriteRetailerRemarks"), null)
			}
			else if(lastitemnameafterswipe.equalsIgnoreCase("Market Intelligence")){
				lastvisitedcategory = lastitemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/MarketIntelligence/OverwriteMarketIntelligence"), null)
			}
			else if(lastitemnameafterswipe.equalsIgnoreCase("HotSpot")){
				lastvisitedcategory = lastitemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
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
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
					if(remarktext.equalsIgnoreCase("Hotspot Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteHotSpotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteHotspotNotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteShopKeeperDidnotAllow"), null)
					}
					else{}
				}
				else{
					MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
					String remarktext = remark.getText()
					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
					if(remarktext.equalsIgnoreCase("Hotspot Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteHotSpotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteHotspotNotAvailable"), null)
					}
					else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
						Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/HotSpot/OverwriteShopKeeperDidnotAllow"), null)
					}
					else{}
				}
			}
			else if(lastitemnameafterswipe.equalsIgnoreCase("Hanger")){
				lastvisitedcategory = lastitemnameafterswipe
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerVisitingScenarios/VisitHangerWithOverwritingScenarios"), null)
			}
			else if(lastitemnameafterswipe.equalsIgnoreCase("Survey")){
				lastvisitedcategory = lastitemnameafterswipe
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitSurveyQuestionsWithNoRemark"), null)
			}
			else{
				lastvisitedcategory = lastitemnameafterswipe
				ProjectConstants.CURRENTVISITING_MAINCATEGORY = lastitemnameafterswipe
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = lastitemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/MainCategoryRemarksVisitingScenarios/VisitRemarksWith_OverwritingScenarios"), null)
			}
			while(true){
				Mobile.swipe(0, 293, 0, 200)
				index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
				MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
				String productname = product.getText()
				if(productname.equalsIgnoreCase(lastvisitedcategory)){
					break
				}
			}
		}
	}
}
