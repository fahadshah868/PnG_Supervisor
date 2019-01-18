package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.ProductWithValue
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
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class LoadDataKeywords {
	//load channel wise products sheet
	def static loadChannelProductsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.CHANNEL_PRODUCTSSHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load distribution point sheet
	def static loadDistributionPointSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.DISTRIBUTION_SHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}

	//load shop action sheet
	def static loadShopActionsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.SHOPACTIONSSHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load shop actions
	def static loadShopActionsList(){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<String> expectedshopactionslist = new ArrayList<String>()
		XSSFSheet sheet = loadShopActionsSheet()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<= totalrows; i++){
			Row row = sheet.getRow(i)
			String shopaction = dataformatter.formatCellValue(row.getCell(ProjectConstants.SHOPACTIONS))
			expectedshopactionslist.add(shopaction)
		}
		return expectedshopactionslist
	}
	//load HotSopt sheet
	def static loadHotSpotProductsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.HOTSPOT_PRODUCTSSHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load Slider Options sheet
	def static loadSliderOptionsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.SLIDEROPTIONSSHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load Survey Questions sheet
	def static loadSurveyQuestionsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.SURVEYQUESTIONS_SHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load Additional Info Questions sheet
	def static loadAdditionalInfoQuestionsSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.ADDITIONALINFOQUESTIONS_SHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load score card sheet
	def static loadScoreCardSheet(){
		try{
			FileInputStream inputStream = new FileInputStream(new File(ProjectConstants.EXCEL_FILEPATH))
			XSSFWorkbook wb = new XSSFWorkbook(inputStream)
			XSSFSheet sheet = wb.getSheet(ProjectConstants.SCORECARDSHEET)
			return sheet
		}
		catch(Exception ex){
		}
	}
	//load score card remarks list
	def static loadScoreCardRemarksList(){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<String> expectedscorecardremarkslist = new ArrayList<String>()
		XSSFSheet sheet = loadScoreCardSheet()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<= totalrows; i++){
			Row row = sheet.getRow(i)
			String scorecardremark = dataformatter.formatCellValue(row.getCell(ProjectConstants.SCORE_CARD))
			expectedscorecardremarkslist.add(scorecardremark)
		}
		return expectedscorecardremarkslist
	}
	//load shop categories
	def static loadShopCategories(){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<String> expectedshopcategories = new ArrayList<String>()
		XSSFSheet sheet = loadChannelProductsSheet()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.CHANNEL))
			String channelname = "Channel: "+channel
			if(ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname)){
				String category = dataformatter.formatCellValue(row.getCell(ProjectConstants.MAINCATEGORY))
				expectedshopcategories.add(category)
			}
		}
		return expectedshopcategories
	}
	//load channel wise survey question categories
	def static loadSurveyQuestionCategories(){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<String> expectedsurveyquestioncategories = new ArrayList<String>()
		XSSFSheet sheet = loadSurveyQuestionsSheet()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.SURVEYQUESTIONS_CHANNEL))
			String channelname = "Channel: "+channel
			if(ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname)){
				String questioncategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.SURVEYQUESTIONCATEGORY))
				expectedsurveyquestioncategories.add(questioncategory)
			}
		}
		return expectedsurveyquestioncategories
	}
	//load channel wise survey questions
	def static loadSurveyQuestionsList(XSSFSheet sheet, int columnindexforvalue){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<ProductWithValue> expectedsurveyquestions = new ArrayList<ProductWithValue>()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.SURVEYQUESTIONS_CHANNEL))
			String questioncategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.SURVEYQUESTIONCATEGORY))
			String channelname = "Channel: "+channel
			if(ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname) && ProjectConstants.CURRENTVISITING_SUBCATEGORY.equalsIgnoreCase(questioncategory)){
				ProductWithValue questionwithvalue = new ProductWithValue()
				String question = dataformatter.formatCellValue(row.getCell(ProjectConstants.SURVEYQUESTION))
				String value = dataformatter.formatCellValue(row.getCell(columnindexforvalue))
				String status = dataformatter.formatCellValue(row.getCell(ProjectConstants.SURVEYQUESTION_TAKEPICTURE))
				String options = dataformatter.formatCellValue(row.getCell(ProjectConstants.SURVEYQUESTION_OPTIONS))
				questionwithvalue.setProduct(question)
				questionwithvalue.setProduct_value(value)
				questionwithvalue.setStatus(status)
				questionwithvalue.setOptions(options)
				expectedsurveyquestions.add(questionwithvalue)
			}
		}
		return expectedsurveyquestions
	}
	//load channel wise additional questions
	def static loadAdditionalInfoQuestionsList(XSSFSheet sheet, int columnindexforvalue){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<ProductWithValue> expectedadditionalinfoquestions = new ArrayList<ProductWithValue>()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.ADDITIONALINFOQUESTIONS_CHANNEL))
			String maincategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.ADDITIONALINFOQUESTIONS_MAINCATEGORY))
			String channelname = "Channel: "+channel
			if(ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname) && ProjectConstants.CURRENTVISITING_MAINCATEGORY.equalsIgnoreCase(maincategory)){
				ProductWithValue questionwithvalue = new ProductWithValue()
				String question = dataformatter.formatCellValue(row.getCell(ProjectConstants.ADDITIONALINFOQUESTION))
				String value = dataformatter.formatCellValue(row.getCell(columnindexforvalue))
				String status = dataformatter.formatCellValue(row.getCell(ProjectConstants.ADDITIONALINFOQUESTION_TAKEPICTURE))
				String options = dataformatter.formatCellValue(row.getCell(ProjectConstants.ADDITIONALINFOQUESTION_OPTIONS))
				questionwithvalue.setProduct(question)
				questionwithvalue.setProduct_value(value)
				questionwithvalue.setStatus(status)
				questionwithvalue.setOptions(options)
				expectedadditionalinfoquestions.add(questionwithvalue)
			}
		}
		return expectedadditionalinfoquestions
	}
	//load channel wise product categories
	def static loadChannelWiseProductCategories(){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<String> productcategories = new ArrayList<String>()
		XSSFSheet sheet = loadChannelProductsSheet()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.CHANNEL))
			String channelname = "Channel: "+channel
			String maincategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.MAINCATEGORY))
			if(ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname) && ProjectConstants.CURRENTVISITING_MAINCATEGORY.equalsIgnoreCase(maincategory)){
				String product = dataformatter.formatCellValue(row.getCell(ProjectConstants.PRODUCTCATEGORY))
				productcategories.add(product)
			}
			else{
			}
		}
		return productcategories
	}
	//load channel wise products and quantity
	def static loadChannelWiseProductsList(XSSFSheet sheet, int column){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<ProductWithValue> productswithvalue = new ArrayList<ProductWithValue>()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.CHANNEL))
			String channelname = "Channel: "+channel
			String maincategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.MAINCATEGORY))
			String productcategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.PRODUCTCATEGORY))
			if((ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname) && ProjectConstants.CURRENTVISITING_MAINCATEGORY.equalsIgnoreCase(maincategory)) && ProjectConstants.CURRENTVISITING_SUBCATEGORY.equalsIgnoreCase(productcategory)){
				ProductWithValue productwithvalue = new ProductWithValue()
				String product = dataformatter.formatCellValue(row.getCell(ProjectConstants.CHANNELPRODUCT))
				String columndata = dataformatter.formatCellValue(row.getCell(column))
				productwithvalue.setProduct(product)
				productwithvalue.setProduct_value(columndata)
				productswithvalue.add(productwithvalue)
			}
			else{
			}
		}
		return productswithvalue
	}
	//load hotspot type
	def static loadHotSpotTypeList(){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<String> hotspottypes = new ArrayList<ProductWithValue>()
		XSSFSheet sheet = loadHotSpotProductsSheet()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String hotspottype = dataformatter.formatCellValue(row.getCell(ProjectConstants.HOTSPOTTYPE))
			hotspottypes.add(hotspottype)
		}
		return hotspottypes
	}
	//load hotspot products and quantity
	def static loadHotSpotProductsList(XSSFSheet sheet, int column){
		DataFormatter dataformatter = new DataFormatter()
		ArrayList<ProductWithValue> productswithvalue = new ArrayList<ProductWithValue>()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String hotspottype = dataformatter.formatCellValue(row.getCell(ProjectConstants.HOTSPOTTYPE))

			String a = ProjectConstants.CURRENTVISITING_HOTSPOTTYPE

			if(ProjectConstants.CURRENTVISITING_HOTSPOTTYPE.equalsIgnoreCase(hotspottype)){
				ProductWithValue productwithvalue = new ProductWithValue()
				String product = dataformatter.formatCellValue(row.getCell(ProjectConstants.HOTSPOTPRODUCT))
				String columndata = dataformatter.formatCellValue(row.getCell(column))
				productwithvalue.setProduct(product)
				productwithvalue.setProduct_value(columndata)
				productswithvalue.add(productwithvalue)
			}
			else{
			}
		}
		return productswithvalue
	}
	def static loadSliderOptions(){
		DataFormatter dataformatter = new DataFormatter()
		XSSFSheet sheet = loadSliderOptionsSheet()
		int totalrows = sheet.getLastRowNum()
		ArrayList<String> slideroptions = new ArrayList<String>()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			slideroptions.add(dataformatter.formatCellValue(row.getCell(ProjectConstants.SLIDEROPTIONS)))
		}
		return slideroptions
	}
}
