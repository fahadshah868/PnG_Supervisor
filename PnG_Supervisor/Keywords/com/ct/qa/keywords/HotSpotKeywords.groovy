package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.ShopProductsData
import com.ct.qa.struct.UnmatchedItems
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedShopDataInfo
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.apache.poi.xssf.usermodel.XSSFSheet

public class HotSpotKeywords {

	public static AppiumDriver<MobileElement> driver = ProjectConstants.DRIVER

	// for hotspot available
	@Keyword
	def selectHotSpotRemark(String _remark){
		int totalremarks = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String remarkname = remark.getText()
			ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarkname
			if(remarkname.equalsIgnoreCase(_remark)){
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				break
			}
			else{}
		}
	}
	@Keyword
	def visitHotSpotTypeForDataVerification(){
		int index = 0
		ArrayList<String> expectedhotspottypes = LoadDataKeywords.loadHotSpotTypeList()
		ArrayList<String> displayedhotspottype = new ArrayList<String>()
		int totalhotspottypes = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalhotspottypes; i++){
			if(i == totalhotspottypes){
				Mobile.swipe(0, 240, 0, 200)
				MobileElement hotspottype = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
				displayedhotspottype.add(hotspottype.getText())
			}
			else{
				MobileElement hotspottype = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
				displayedhotspottype.add(hotspottype.getText())
			}
		}
		while(true){
			index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement itembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String itemnamebeforeswipe = itembeforeswipe.getText()
			Mobile.swipe(0, 293, 0, 200)
			index = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement itemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String itemnameafterswipe = itemafterswipe.getText()
			if(itemnamebeforeswipe.equals(itemnameafterswipe)){
				break
			}
			else{
				displayedhotspottype.add(itemnameafterswipe)
			}
		}
		ArrayList<String> expectedhotspottypelist = new HashSet<String>(expectedhotspottypes)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedhotspottypelist, displayedhotspottype)
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategories(UnmatchedItems_status.getItems())
			missingcategory.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategories(UnmatchedItems_status.getItems())
			missingcategory.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategories(UnmatchedItems_status.getItems())
			missingcategory.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
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
		Mobile.swipe(0, 200, 0, 750)
		Mobile.swipe(0, 200, 0, 750)
		if(ProjectConstants.HOTSPOTINDEX <= 7){
			ProjectConstants.HOTSPOTINDEX = ProjectConstants.HOTSPOTINDEX + 1
			MobileElement hotspot = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+ProjectConstants.HOTSPOTINDEX+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_HOTSPOTTYPE = hotspot.getText()
			ProjectConstants.CURRENTVISITING_CATEGORYREMARK = ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with "+hotspot.getText()+" hotspot type"
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+ProjectConstants.HOTSPOTINDEX+"]").click()
			CommonKeywords.takePicture()
		}
		else{
			ProjectConstants.HOTSPOTINDEX = ProjectConstants.HOTSPOTINDEX + 1
			Mobile.swipe(0, 240, 0, 200)
			totalhotspottypes = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			index = ProjectConstants.HOTSPOTINDEX - totalhotspottypes
			for(int i=1; i<= index; i++){
				Mobile.swipe(0, 293, 0, 200)
			}
			MobileElement hotspot = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+totalhotspottypes+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_CATEGORYREMARK = ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with "+hotspot.getText()+" hotspot type"
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+totalhotspottypes+"]").click()
			CommonKeywords.takePicture()
		}
	}
	@Keyword
	def visitHotSpotType(int flag){
		int totalhotspottypes = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		if(ProjectConstants.SHOP_ATTEMPT == 1){
			if(flag == 1){
				for(int i=1; i<= totalhotspottypes; i++){
					MobileElement hotspot = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
					String hotspottext = hotspot.getText()
					if(hotspottext.equalsIgnoreCase("2 Shelfs")){
						ProjectConstants.CURRENTVISITING_CATEGORYREMARK = ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with "+hotspot.getText()+" hotspot type"
						ProjectConstants.CURRENTVISITING_HOTSPOTTYPE = hotspottext
						driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
						CommonKeywords.takePicture()
						break
					}
					else{}
				}
			}
			else{
				for(int i=1; i<= totalhotspottypes; i++){
					MobileElement hotspot = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
					String hotspottext = hotspot.getText()
					if(hotspottext.equalsIgnoreCase("3 Shelfs")){
						ProjectConstants.CURRENTVISITING_CATEGORYREMARK = ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with "+hotspot.getText()+" hotspot type"
						ProjectConstants.CURRENTVISITING_HOTSPOTTYPE = hotspottext
						driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
						CommonKeywords.takePicture()
						break
					}
					else{}
				}
			}
		}
		else{
			for(int i=1; i<= totalhotspottypes; i++){
				MobileElement hotspot = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
				String hotspottext = hotspot.getText()
				if(hotspottext.equalsIgnoreCase("2 Shelfs")){
					ProjectConstants.CURRENTVISITING_CATEGORYREMARK = ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with "+hotspot.getText()+" hotspot type"
					ProjectConstants.CURRENTVISITING_HOTSPOTTYPE = hotspottext
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
					CommonKeywords.takePicture()
					break
				}
				else{}
			}
		}
	}
	@Keyword
	def visitHotSpotAvailableFacingProducts(int columnindex){
		ArrayList<ShopProductsData> visitedshopproductsdata = new ArrayList<ShopProductsData>()
		ArrayList<String> expectedproducts = new ArrayList<String>()
		ArrayList<String> displayedproducts = new ArrayList<String>()
		int index = 0
		XSSFSheet sheet = LoadDataKeywords.loadHotSpotProductsSheet()
		ArrayList<ProductWithValue> expectedhotspotproducts = LoadDataKeywords.loadHotSpotProductsList(sheet, columnindex)
		for(int i=0; i< expectedhotspotproducts.size(); i++){
			expectedproducts.add(expectedhotspotproducts.get(i).getProduct())
		}
		int totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalproducts; i=i+3){
			ShopProductsData shopproductdata = new ShopProductsData()
			boolean flag = false
			index = index + 1
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productname = product.getText()
			shopproductdata.setProduct(productname)
			for(int j=0; j< expectedhotspotproducts.size(); j++){
				ProductWithValue expectedhotspotproduct = expectedhotspotproducts.get(j)
				if(expectedhotspotproduct.getProduct().equalsIgnoreCase(productname)){
					flag = true
					MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
					edittext.setValue(expectedhotspotproduct.getProduct_value())
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						shopproductdata.setHs_facing(expectedhotspotproduct.getProduct_value())
					}
					else{
						shopproductdata.setOverwrite_hs_facing(expectedhotspotproduct.getProduct_value())
					}
					Mobile.hideKeyboard()
					break
				}
				else{}
			}
			if(flag == false){
				MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
				edittext.setValue("0000")
				if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
					shopproductdata.setHs_facing("0000")
				}
				else{
					shopproductdata.setOverwrite_hs_facing("0000")
				}
				Mobile.hideKeyboard()
			}
			else{}
			visitedshopproductsdata.add(shopproductdata)
		}
		totalproducts = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*").size()
		if(totalproducts >= 16){
			while(true){
				ShopProductsData shopproductdata = new ShopProductsData()
				boolean flag = false
				int xlocation = CommonKeywords.getXPoint()
				MobileElement productbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
				String productnamebeforeswipe = productbeforeswipe.getText()
				Mobile.swipe(xlocation, 359, xlocation, 250)
				MobileElement productafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[5]")
				String productnameafterswipe = productafterswipe.getText()
				if(productnamebeforeswipe.equals(productnameafterswipe)){
					break
				}
				else{
					shopproductdata.setProduct(productnameafterswipe)
					for(int j=0; j< expectedhotspotproducts.size(); j++){
						ProductWithValue expectedchannelproduct = expectedhotspotproducts.get(j)
						if(expectedchannelproduct.getProduct().equalsIgnoreCase(productnameafterswipe)){
							flag = true
							MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
							edittext.setValue(expectedchannelproduct.getProduct_value())
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								shopproductdata.setHs_facing(expectedchannelproduct.getProduct_value())
							}
							else{
								shopproductdata.setOverwrite_hs_facing(expectedchannelproduct.getProduct_value())
							}
							Mobile.hideKeyboard()
							break
						}
						else{}
					}
					if(flag == false){
						MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.EditText[1]")
						edittext.setValue("0000")
						if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
							shopproductdata.setHs_facing("0000")
						}
						else{
							shopproductdata.setOverwrite_hs_facing("0000")
						}
						Mobile.hideKeyboard()
					}
					else{}
				}
				visitedshopproductsdata.add(shopproductdata)
			}
		}
		else{}
		for(int i=0; i< visitedshopproductsdata.size(); i++){
			displayedproducts.add((visitedshopproductsdata.get(i).getProduct()))
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
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
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
			visitedcategory.setFirstvisit_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		}
		else{
			visitedcategory.setOverwrite_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		}
		visitedcategory.setShopproductsdata(visitedshopproductsdata)
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
							if(visitedcategorydata.getFirstvisit_categoryremark().equals(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)){
								ArrayList<ShopProductsData> shopproductsdata = visitedcategorydata.getShopproductsdata()
								for(int n=0; n< shopproductsdata.size(); n++){
									ShopProductsData existingshopproductsdata = shopproductsdata.get(n)
									for(int b=0; b< visitedshopproductsdata.size(); b++){
										ShopProductsData displayedshopproductsdata = visitedshopproductsdata.get(b)
										if(existingshopproductsdata.getProduct().equalsIgnoreCase(displayedshopproductsdata.getProduct())){
											if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
												visitedcategorydata.setFirstvisit_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
												existingshopproductsdata.setHs_facing(displayedshopproductsdata.getHs_facing())
											}
											else{
												visitedcategorydata.setOverwrite_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
												existingshopproductsdata.setOverwrite_hs_facing(displayedshopproductsdata.getOverwrite_hs_facing())
											}
										}
									}
								}
							}
							else{
								visitedcategorydata.setOverwrite_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
								ArrayList<ShopProductsData> shopproductsdata = visitedcategorydata.getShopproductsdata()
								ShopProductsData shopproductdata = new ShopProductsData()
								shopproductdata.setProduct("")
								shopproductdata.setHs_facing("")
								shopproductdata.setOverwrite_hs_facing("")
								shopproductsdata.add(shopproductdata)
								for(int m=0; m< visitedshopproductsdata.size(); m++){
									shopproductsdata.add(visitedshopproductsdata.get(m))
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
	def visitSKDNA(){
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		String remark_text = ""
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			remark_text = remark.getText()
			if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
				if(remark_text.equalsIgnoreCase("Expiry Issue")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
					break
				}
				else{}
			}
			else{
				if(remark_text.equalsIgnoreCase("Others")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
					break
				}
				else{}
			}
		}
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
			visitedcategory.setFirstvisit_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with '"+remark_text+"' remark")
		}
		else{
			visitedcategory.setOverwrite_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with '"+remark_text+"' remark")
		}
		for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
			if(ProjectConstants.visitedshopdatainfo.get(i).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
				VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
				ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
				if(visitedcategoriesdata != null){
					boolean flag = false
					for(int k=0; k<visitedcategoriesdata.size(); k++){
						VisitedCategoryData visitedcategorydata = visitedcategoriesdata.get(k)
						if(visitedcategorydata.getMaincategory().equals(visitedcategory.getMaincategory())){
							flag = true
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								visitedcategorydata.setFirstvisit_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with '"+remark_text+"' remark")
							}
							else{
								visitedcategorydata.setOverwrite_categoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK+" with '"+remark_text+"' remark")
							}
						}
					}
					if(flag == false){
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
	def findPOSMImageView(){
		int totalimageviews = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/*").size()
		for(int i=1; i<= totalimageviews; i++){
			MobileElement targetimageview = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String targetimageviewtext = targetimageview.getText()
			if(targetimageviewtext.equalsIgnoreCase("POSM")){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.ImageButton[1]").click()
				int totalposm = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
				for(int j=1; j<= totalposm; j++){
					driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+j+"]").click()
					Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/HotSpot/HotSpotAvailable/Validate_POSMRemarksScreen", [('package') : ProjectConstants.PACKAGENAME]), "Remarks")
					int totalremarks = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
					for(int k=1; k<= totalremarks; k++){
						MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+k+"]/android.widget.TextView[1]")
						String remarktext = remark.getText()
						if(remarktext.equalsIgnoreCase("Fresh Deployment")){
							driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+k+"]").click()
							break
						}
					}
					Mobile.verifyElementText(findTestObject("Object Repository/ShopOpen/HotSpot/HotSpotAvailable/Validate_POSMScreen", [('package') : ProjectConstants.PACKAGENAME]), "POSM Deployment")
				}
				break
			}
			else{}
		}
	}
	@Keyword
	def enterUtilization(int status){
		MobileElement editfield = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
		if(status == 1){
			editfield.setValue("50")
		}
		else{
			editfield.setValue("100")
		}
	}
}
