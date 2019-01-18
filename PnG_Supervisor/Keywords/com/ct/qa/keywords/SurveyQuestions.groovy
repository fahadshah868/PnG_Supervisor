package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.By.ByTagName

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.ProductWithValue
import com.ct.qa.struct.Question
import com.ct.qa.struct.SubCategory
import com.ct.qa.struct.UnmatchedItems
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedShopDataInfo
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.MobileElement

public class SurveyQuestions {
	@Keyword
	def visitSurveyQuestionCategories(int flag){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareSurveyQuestionCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
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
		int totalsurveyquestioncategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsurveyquestioncategories; i++){
			MobileElement questioncategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = questioncategory.getText()
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(flag == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithYesRemark"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithNoRemark"), null)
			}
			Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionCategoryScreen', [('package') : ProjectConstants.PACKAGENAME]),
			'Question Category')
		}
		while(true){
			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement itembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String itemnamebeforeswipe = itembeforeswipe.getText()
			Mobile.swipe(0, 293, 0, 200)
			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement itemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String itemnameafterswipe = itembeforeswipe.getText()
			if(itemnamebeforeswipe.equals(itemnameafterswipe)){
				break
			}
			else{
				ProjectConstants.CURRENTVISITING_SUBCATEGORY = itemnameafterswipe
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
				if(flag == 1){
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithYesRemark"), null)
				}
				else{
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithNoRemark"), null)
				}
				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionCategoryScreen', [('package') : ProjectConstants.PACKAGENAME]),
				'Question Category')
			}
		}
	}
	@Keyword
	def visitSurveyQuestionsWithYesRemark(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<Question> _surveyquestions = new ArrayList<Question>()
		ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadSurveyQuestionsList(LoadDataKeywords.loadSurveyQuestionsSheet() , ProjectConstants.SURVEYQUESTIONVALUE)
		for(int i=0; i< expectedsurveyquestions.size(); i++){
			expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			Question _surveyquestion = new Question()
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				boolean flag = false
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				_surveyquestion.setQuestion(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("Yes")){
						flag = true
						_surveyquestion.setValue("Yes")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						String status = expectedsurveyquestions.get(j).getStatus()
						if(status.equalsIgnoreCase("Y")){
							_surveyquestion.setPicture_status("Y")
							validateCameraScreenAndTakePicture()
							break
						}
						else{
							_surveyquestion.setPicture_status("N")
						}
					}
					else{}
				}
				if(flag == false){
					_surveyquestion.setValue("Yes")
					_surveyquestion.setPicture_status("Not Mention")
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
					validateCameraScreenAndTakePicture()
				}
				else{}
				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				boolean flag = false
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				_surveyquestion.setQuestion(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						flag = true
						String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
						surveyquestion.setValue(questionvalue)
						_surveyquestion.setValue(questionvalue)
						_surveyquestion.setPicture_status("N")
						Mobile.hideKeyboard()
					}
					else{
					}
				}
				if(flag == false){
					surveyquestion.setValue("0000")
					_surveyquestion.setValue("0000")
					_surveyquestion.setPicture_status("N")
					Mobile.hideKeyboard()
				}
			}
			_surveyquestions.add(_surveyquestion)
		}
		while(true){
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 315, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				Question _surveyquestion = new Question()
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					_surveyquestion.setQuestion(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("Yes")){
							flag = true
							_surveyquestion.setValue("Yes")
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							String status = expectedsurveyquestions.get(j).getStatus()
							if(status.equalsIgnoreCase("Y")){
								_surveyquestion.setPicture_status("Y")
								validateCameraScreenAndTakePicture()
								break
							}
							else{
								_surveyquestion.setPicture_status("N")
							}
						}
						else{}
					}
					if(flag == false){
						_surveyquestion.setValue("Yes")
						_surveyquestion.setPicture_status("Not Mention")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					_surveyquestion.setQuestion(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							_surveyquestion.setValue(questionvalue)
							_surveyquestion.setPicture_status("N")
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						_surveyquestion.setValue("0000")
						_surveyquestion.setPicture_status("N")
						Mobile.hideKeyboard()
					}
				}
				_surveyquestions.add(_surveyquestion)
			}
			// swipe with different values
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 314, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				Question _surveyquestion = new Question()
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					_surveyquestion.setQuestion(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("Yes")){
							flag = true
							_surveyquestion.setValue("Yes")
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							String status = expectedsurveyquestions.get(j).getStatus()
							if(status.equalsIgnoreCase("Y")){
								_surveyquestion.setPicture_status("Y")
								validateCameraScreenAndTakePicture()
								break
							}
							else{
								_surveyquestion.setPicture_status("N")
							}
						}
						else{}
					}
					if(flag == false){
						_surveyquestion.setValue("Yes")
						_surveyquestion.setPicture_status("Not Mention")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					_surveyquestion.setQuestion(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							_surveyquestion.setValue(questionvalue)
							_surveyquestion.setPicture_status("N")
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						_surveyquestion.setValue("0000")
						_surveyquestion.setPicture_status("N")
						Mobile.hideKeyboard()
					}
				}
				_surveyquestions.add(_surveyquestion)
			}
		}
		ArrayList<String> _expectedsurveyquestionslist = new HashSet<String>(expectedsurveyquestionslist)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(_expectedsurveyquestionslist, visitedsurveyquestions)
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
		SubCategory subcategory = new SubCategory()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		subcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		subcategory.setSurveyquestions(_surveyquestions)
		visitedcategory.setSubcategories(subcategory)
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
							ArrayList<SubCategory> subcategoriesdata = visitedcategorydata.getSubcategories()
							if(subcategoriesdata != null){
								boolean subcategory_flag = false
								for(int b=0; b< subcategoriesdata.size(); b++){
									SubCategory subcategorydata = subcategoriesdata.get(b)
									if(subcategorydata.getSubcategory().equals(subcategory.getSubcategory())){
										subcategoriesdata = true
										ArrayList<Question> surveyquestions = subcategorydata.getSurveyquestions()
										for(int ex=0; ex< surveyquestions.size(); ex++){
											Question existingsurveyquestions = surveyquestions.get(ex)
											for(int ds=0; ds< _surveyquestions.size(); ds++){
												Question displayedsurveyquestions = _surveyquestions.get(ds)
												if(existingsurveyquestions.getQuestion().equals(displayedsurveyquestions.getQuestion())){
													if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
														existingsurveyquestions.setValue(displayedsurveyquestions.getValue())
														existingsurveyquestions.setPicture_status(displayedsurveyquestions.getPicture_status())
													}
													else{
														existingsurveyquestions.setOverwrite_value(displayedsurveyquestions.getOverwrite_value())
														existingsurveyquestions.setOverwrite_picture_status(displayedsurveyquestions.getOverwrite_picture_status())
													}
												}
											}
										}
									}
								}
								if(subcategoriesdata == false){
									visitedcategorydata.setSubcategories(subcategory)
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
	def visitSurveyQuestionsWithNoRemark(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<Question> _surveyquestions = new ArrayList<Question>()
		ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadSurveyQuestionsList(LoadDataKeywords.loadSurveyQuestionsSheet() , ProjectConstants.OVERWRITE_SURVEYQUESTIONVALUE)
		for(int i=0; i< expectedsurveyquestions.size(); i++){
			expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			Question _surveyquestion = new Question()
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				boolean flag = false
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				_surveyquestion.setQuestion(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
						flag = true
						_surveyquestion.setOverwrite_value("No")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						String status = expectedsurveyquestions.get(j).getStatus()
						if(status.equalsIgnoreCase("Y")){
							_surveyquestion.setOverwrite_picture_status("Y")
							validateCameraScreenAndTakePicture()
							break
						}
						else{
							_surveyquestion.setOverwrite_picture_status("N")
						}
					}
					else{}
				}
				if(flag == false){
					_surveyquestion.setOverwrite_value("Yes")
					_surveyquestion.setOverwrite_picture_status("Not Mention")
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
					validateCameraScreenAndTakePicture()
				}
				else{}
				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				boolean flag = false
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				_surveyquestion.setQuestion(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						flag = true
						String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
						surveyquestion.setValue(questionvalue)
						_surveyquestion.setOverwrite_value(questionvalue)
						_surveyquestion.setOverwrite_value("N")
						Mobile.hideKeyboard()
					}
					else{
					}
				}
				if(flag == false){
					surveyquestion.setValue("0000")
					_surveyquestion.setOverwrite_value("0000")
					_surveyquestion.setOverwrite_value("N")
					Mobile.hideKeyboard()
				}
			}
			_surveyquestions.add(_surveyquestion)
		}
		while(true){
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 315, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				Question _surveyquestion = new Question()
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					_surveyquestion.setQuestion(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
							flag = true
							_surveyquestion.setOverwrite_value("No")
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							String status = expectedsurveyquestions.get(j).getStatus()
							if(status.equalsIgnoreCase("Y")){
								_surveyquestion.setOverwrite_picture_status("Y")
								validateCameraScreenAndTakePicture()
								break
							}
							else{
								_surveyquestion.setOverwrite_picture_status("N")
							}
						}
						else{}
					}
					if(flag == false){
						_surveyquestion.setOverwrite_value("Yes")
						_surveyquestion.setOverwrite_picture_status("Not Mention")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					_surveyquestion.setQuestion(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							_surveyquestion.setOverwrite_value(questionvalue)
							_surveyquestion.setOverwrite_picture_status("N")
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						_surveyquestion.setOverwrite_value("0000")
						_surveyquestion.setOverwrite_picture_status("N")
						Mobile.hideKeyboard()
					}
				}
				_surveyquestions.add(_surveyquestion)
			}
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 314, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				Question _surveyquestion = new Question()
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					_surveyquestion.setQuestion(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
							flag = true
							_surveyquestion.setOverwrite_value("No")
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							String status = expectedsurveyquestions.get(j).getStatus()
							if(status.equalsIgnoreCase("Y")){
								_surveyquestion.setOverwrite_picture_status("Y")
								validateCameraScreenAndTakePicture()
								break
							}
							else{
								_surveyquestion.setOverwrite_picture_status("N")
							}
						}
						else{}
					}
					if(flag == false){
						_surveyquestion.setOverwrite_value("Yes")
						_surveyquestion.setOverwrite_picture_status("Not Mention")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					_surveyquestion.setQuestion(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							_surveyquestion.setOverwrite_value(questionvalue)
							_surveyquestion.setOverwrite_picture_status("N")
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						_surveyquestion.setOverwrite_value("0000")
						_surveyquestion.setOverwrite_picture_status("N")
						Mobile.hideKeyboard()
					}
				}
				_surveyquestions.add(_surveyquestion)
			}
		}
		ArrayList<String> _expectedsurveyquestionslist = new HashSet<String>(expectedsurveyquestionslist)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(_expectedsurveyquestionslist, visitedsurveyquestions)
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
		SubCategory subcategory = new SubCategory()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		subcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		subcategory.setSurveyquestions(_surveyquestions)
		visitedcategory.setSubcategories(subcategory)
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
							ArrayList<SubCategory> subcategoriesdata = visitedcategorydata.getSubcategories()
							if(subcategoriesdata != null){
								boolean subcategory_flag = false
								for(int b=0; b< subcategoriesdata.size(); b++){
									SubCategory subcategorydata = subcategoriesdata.get(b)
									if(subcategorydata.getSubcategory().equals(subcategory.getSubcategory())){
										subcategoriesdata = true
										ArrayList<Question> surveyquestions = subcategorydata.getSurveyquestions()
										for(int ex=0; ex< surveyquestions.size(); ex++){
											Question existingsurveyquestions = surveyquestions.get(ex)
											for(int ds=0; ds< _surveyquestions.size(); ds++){
												Question displayedsurveyquestions = _surveyquestions.get(ds)
												if(existingsurveyquestions.getQuestion().equals(displayedsurveyquestions.getQuestion())){
													if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
														existingsurveyquestions.setValue(displayedsurveyquestions.getValue())
														existingsurveyquestions.setPicture_status(displayedsurveyquestions.getPicture_status())
													}
													else{
														existingsurveyquestions.setOverwrite_value(displayedsurveyquestions.getOverwrite_value())
														existingsurveyquestions.setOverwrite_picture_status(displayedsurveyquestions.getOverwrite_picture_status())
													}
												}
											}
										}
									}
								}
								if(subcategoriesdata == false){
									visitedcategorydata.setSubcategories(subcategory)
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
	def validateCameraScreenAndTakePicture(){
		try{
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_CameraScreen", [('package') : ProjectConstants.PACKAGENAME]), 0, FailureHandling.OPTIONAL)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/TakePictureButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(5)
			Mobile.tap(findTestObject("Object Repository/CommonScreenElements/DoneButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		catch(Exception ex){
		}
	}
}
