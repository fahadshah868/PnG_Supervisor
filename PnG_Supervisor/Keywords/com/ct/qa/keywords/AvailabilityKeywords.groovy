package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.MissingCategoryRemarkData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.SubCategory
import com.ct.qa.struct.UnmatchedItems
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

public class AvailabilityKeywords {

	AppiumDriver<MobileElement> driver = ProjectConstants.DRIVER;

	@Keyword
	def visitAvailabilitySubCategories(int status){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopRemainingCategoryAvailabilitySubCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else{
		}
		int index = 0
		int totalsubcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
			MobileElement category = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String categoryname = category.getText()
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(status == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitSubCategories_WithYesRemarks"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/Availability/VisitSubCategories_WithNoRemarks"), null)
			}
		}
	}
	@Keyword
	def visitProductsAvailabilityWithYesRemarks(){
		ArrayList<String> displayedproducts = new ArrayList<String>()
		ArrayList<ProductWithValue> productswithvalue = LoadDataKeywords.loadChannelWiseProductsList(LoadDataKeywords.loadChannelProductsSheet(), ProjectConstants.DISPLAYSPACEAVAILABLE)
		ArrayList<String> expectedproducts = new ArrayList<String>()
		for(int i=0; i< productswithvalue.size(); i++){
			expectedproducts.add(productswithvalue.get(i).getProduct())
		}
		MobileElement productlistcontainer = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]");
		int totalproducts = productlistcontainer.findElementsByClassName("android.widget.RadioGroup").size()
		int index = totalproducts
		for(int i=1; i<= totalproducts; i++){
			MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productname = product.getText()
			displayedproducts.add(productname)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		}
		while(true){
			boolean flag = true
			MobileElement productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productnamebeforeswipe = productbeforeswipe.getText()
			Mobile.swipe(0, 275, 0, 200)
			MobileElement productslistcontainerafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]");
			index = productslistcontainerafterswipe.findElementsByClassName("android.widget.RadioGroup").size()
			MobileElement productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productnameafterswipe = productafterswipe.getText()
			if(productnamebeforeswipe.equals(productnameafterswipe)){
				flag = false
				break
			}
			else{
				MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				String productname = product.getText()
				displayedproducts.add(productname)
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
			}
			if(flag == true){
				productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				productnamebeforeswipe = productbeforeswipe.getText()
				Mobile.swipe(0, 274, 0, 200)
				MobileElement _productslistcontainerafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]");
				index = _productslistcontainerafterswipe.findElementsByClassName("android.widget.RadioGroup").size()
				productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				productnameafterswipe = productafterswipe.getText()
				if(productnamebeforeswipe.equals(productnameafterswipe)){
					break
				}
				else{
					MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
					String productname = product.getText()
					displayedproducts.add(productname)
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
				}
			}
			else{
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else{
		}
		SubCategory subcategory = new SubCategory()
		VisitedCategoryRemarkData visitedcategoryremark = new VisitedCategoryRemarkData()
		visitedcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		subcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
			subcategory.setFirstvisit_remark("Yes")
		}
		else{
			subcategory.setOverwrite_remark("No")
		}
		visitedcategoryremark.setSubcategories(subcategory)
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
									if(visitedcategoryremarkdata != null && (visitedcategoryremarkdata.getCategoryremark().equalsIgnoreCase(visitedcategoryremark.getCategoryremark()))){
										categoryremark_flag = true
										ArrayList<SubCategory> subcategoriesdata = visitedcategoryremarkdata.getSubcategories()
										if(subcategoriesdata != null){
											boolean subcategoryremark_flag = false
											for(int o=0; o< subcategoriesdata.size(); o++){
												SubCategory subcategorydata = subcategoriesdata.get(o)
												if(subcategorydata.getSubcategory().equals(subcategory.getSubcategory())){
													subcategoryremark_flag = true
													if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
														subcategorydata.setFirstvisit_remark("Yes")
													}
													else{
														subcategorydata.setOverwrite_remark("No")
													}
												}
											}
											if(subcategoryremark_flag == false){
												visitedcategoryremarkdata.setSubcategories(subcategory)
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
	@Keyword
	def visitProductsAvailabilityWithNoRemarks(){
		ArrayList<String> displayedproducts = new ArrayList<String>()
		ArrayList<ProductWithValue> productswithvalue = LoadDataKeywords.loadChannelWiseProductsList(LoadDataKeywords.loadChannelProductsSheet(), ProjectConstants.DISPLAYSPACEAVAILABLE)
		ArrayList<String> expectedproducts = new ArrayList<String>()
		for(int i=0; i< productswithvalue.size(); i++){
			expectedproducts.add(productswithvalue.get(i).getProduct())
		}
		MobileElement productlistcontainer = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]");
		int totalproducts = productlistcontainer.findElementsByClassName("android.widget.RadioGroup").size()
		int index = totalproducts
		for(int i=1; i<= totalproducts; i++){
			MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productname = product.getText()
			displayedproducts.add(productname)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
		}
		while(true){
			boolean flag = true
			MobileElement productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productnamebeforeswipe = productbeforeswipe.getText()
			Mobile.swipe(0, 275, 0, 200)
			MobileElement productslistcontainerafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]");
			index = productslistcontainerafterswipe.findElementsByClassName("android.widget.RadioGroup").size()
			MobileElement productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
			String productnameafterswipe = productafterswipe.getText()
			if(productnamebeforeswipe.equals(productnameafterswipe)){
				flag = false
				break
			}
			else{
				MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				String productname = product.getText()
				displayedproducts.add(productname)
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
			}
			if(flag == true){
				productbeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				productnamebeforeswipe = productbeforeswipe.getText()
				Mobile.swipe(0, 274, 0, 200)
				MobileElement _productslistcontainerafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]");
				index = _productslistcontainerafterswipe.findElementsByClassName("android.widget.RadioGroup").size()
				productafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
				productnameafterswipe = productafterswipe.getText()
				if(productnamebeforeswipe.equals(productnameafterswipe)){
					break
				}
				else{
					MobileElement product = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
					String productname = product.getText()
					displayedproducts.add(productname)
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
				}
			}
			else{
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else{
		}
		SubCategory subcategory = new SubCategory()
		VisitedCategoryRemarkData visitedcategoryremark = new VisitedCategoryRemarkData()
		visitedcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		subcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
			subcategory.setFirstvisit_remark("Yes")
		}
		else{
			subcategory.setOverwrite_remark("No")
		}
		visitedcategoryremark.setSubcategories(subcategory)
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
									if(visitedcategoryremarkdata != null && (visitedcategoryremarkdata.getCategoryremark().equalsIgnoreCase(visitedcategoryremark.getCategoryremark()))){
										categoryremark_flag = true
										ArrayList<SubCategory> subcategoriesdata = visitedcategoryremarkdata.getSubcategories()
										if(subcategoriesdata != null){
											boolean subcategoryremark_flag = false
											for(int o=0; o< subcategoriesdata.size(); o++){
												SubCategory subcategorydata = subcategoriesdata.get(o)
												if(subcategorydata.getSubcategory().equals(subcategory.getSubcategory())){
													subcategoryremark_flag = true
													if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
														subcategorydata.setFirstvisit_remark("Yes")
													}
													else{
														subcategorydata.setOverwrite_remark("No")
													}
												}
											}
											if(subcategoryremark_flag == false){
												visitedcategoryremarkdata.setSubcategories(subcategory)
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
