package com.ct.qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.ArrayList

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.logging.KeywordLogger
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
import com.ct.qa.struct.UnmatchedItems

import internal.GlobalVariable
import io.appium.java_client.MobileElement
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import com.ct.qa.constants.ProjectConstants
import com.ct.qa.struct.VisitedShopDataInfo
import com.ct.qa.struct.MissingCategoryData
import com.ct.qa.struct.MissingCategoryRemarkData
import com.ct.qa.struct.MissingShopDataInfo
import com.ct.qa.struct.Question
import com.ct.qa.struct.SDUnit
import com.ct.qa.struct.ShopProductsData
import com.ct.qa.struct.SubCategory
import com.ct.qa.struct.VisitedCategoryData
import com.ct.qa.struct.VisitedCategoryRemarkData

public class ShopVisitingScenariosKeywords{
	def displayDataInReport(){
		String message = "\n\n---------------------------------------------Missing Shop Data-----------------------------------------------------------------------------------------------------\n\n"+
				"<-------------------------------------------------------------------------------------------------------------------------------------->"
		for(int i=0; i<ProjectConstants.missingshopdatainfo.size(); i++){
			boolean flag = false
			MissingShopDataInfo missingshopdatainfo = ProjectConstants.missingshopdatainfo.get(i)
			//shop categories
			if(missingshopdatainfo != null){
				if(missingshopdatainfo.getMissingshopcategories() != null){
					if(flag == false){
						message = message+"\n\n"+
								String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
								String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
								String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
								String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
								"\n\n" + String.format("%-30s", "Shop Categories:")
						for(int j=0; j<missingshopdatainfo.getMissingshopcategories().size(); j++){
							message = message+missingshopdatainfo.getMissingshopcategories().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopcategories_errormessage() + "\n\n"
						flag = true
					}
					else{
					}
				}
				//missing shop actions
				if(missingshopdatainfo.getMissingshopactions() != null){
					if(flag == false){
						message = message+"\n\n"+
								String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
								String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
								String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
								String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
								"\n\n" + String.format("%-30s", "Shop Actions:")
						for(int j=0; j<missingshopdatainfo.getMissingshopactions().size(); j++){
							message = message+missingshopdatainfo.getMissingshopactions().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopactions_errormessage() + "\n\n"
						flag = true
					}
					else{
						message = message+"\n\n"+
								String.format("%-30s", "Shop Actions:")
						for(int j=0; j<missingshopdatainfo.getMissingshopactions().size(); j++){
							message = message+missingshopdatainfo.getMissingshopactions().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopactions_errormessage() + "\n\n"
					}
				}
				//missing categories
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							ArrayList<String> categoryremarks = missingcategorydata.getMissingcategoryremarksdata()
							if(categoryremarks != null){
								if(flag == false){
									message = message+"\n\n"+
											String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
											String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
											String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
											String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
											"\n\nCategory Remarks:\n\n" +
											String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
											String.format("%-30s","Category Remarks:")
									for(int n=0; n< categoryremarks.size() ; n++){
										message = message + categoryremarks.get(n) + ",   "
									}
									message = message + "\n" + missingcategorydata.getMissingcategoryremarksdata_errormessage() + "\n\n"
									flag = true
								}
								else{
									message = message +
											"\n\nCategory Remarks:\n\n" +
											String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
											String.format("%-30s","Category Remarks:")
									for(int n=0; n< categoryremarks.size() ; n++){
										message = message + categoryremarks.get(n) + ",   "
									}
									message = message + "\n" + missingcategorydata.getMissingcategoryremarksdata_errormessage() + "\n\n"
								}
							}
						}
					}
				}
				//sub categories
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							if(missingcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
												String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","HotSpot Type:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","HotSpot Type:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
												String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Sub Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Sub Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Survey")){
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
												String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Question Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Question Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else{
								ArrayList<MissingCategoryRemarkData> missingcategoryremarks = missingcategorydata.getMissingcategoryremarks()
								if(missingcategoryremarks != null){
									for(int n=0; n< missingcategoryremarks.size(); n++){
										MissingCategoryRemarkData missingcategoryremark = missingcategoryremarks.get(n)
										ArrayList<String> missingsubcategories = missingcategoryremark.getSubcategories()
										if(missingsubcategories != null)
										{
											if(flag == false){
												message = message+"\n\n"+
														String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
														String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
														String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
														String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
														"\n\nSub Categories:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s","Sub Categories:")
												for(int b=0; b< missingsubcategories.size() ; b++){
													message = message + missingsubcategories.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getSubcategories_errormessage() + "\n\n"
												flag = true
											}
											else{
												message = message +
														"\n\nSub Categories:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s","Sub Categories:")
												for(int b=0; b< missingsubcategories.size() ; b++){
													message = message + missingsubcategories.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getSubcategories_errormessage() + "\n\n"
											}
										}
									}
								}
							}
						}
					}
				}
				//products
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							if(missingcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
												String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","HotSpot Type:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","HotSpot Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","HotSpot Type:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","HotSpot Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
												String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Sub Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Sub Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Survey")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
												String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Question Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Questions:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Question Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Questions:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else{
								ArrayList<MissingCategoryRemarkData> missingcategoryremarks = missingcategorydata.getMissingcategoryremarks()
								if(missingcategoryremarks != null){
									for(int n=0; n< missingcategoryremarks.size(); n++){
										MissingCategoryRemarkData missingcategoryremark = missingcategoryremarks.get(n)
										ArrayList<String> products = missingcategoryremark.getProducts()
										if(products != null){
											if(flag == false){
												message = message+"\n\n"+
														String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
														String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())+"\n\n"+
														String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
														String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
														"\n\nProducts:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n"
												if(missingcategoryremark.getSubcategory() != null){
													message = message + String.format("%-30s%-60s","Sub Category:",missingcategoryremark.getSubcategory()) + "\n"
												}
												else{
												}
												message = message + String.format("%-30s","Products:")
												for(int b=0; b< products.size() ; b++){
													message = message + products.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getProducts_errormessage() + "\n\n"
												flag = true
											}
											else{
												message = message +
														"\n\nProducts:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s%-60s","Sub Category:",missingcategoryremark.getSubcategory()) + "\n" +
														String.format("%-30s","Products:")
												for(int b=0; b< products.size() ; b++){
													message = message + products.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getProducts_errormessage() + "\n\n"
											}
										}
									}
								}
							}
						}
					}
				}
				if(flag != false){
					message = message+"\n\n<-------------------------------------------------------------------------------------------------------------------------------------->\n\n"
					KeywordUtil.logInfo(message)
					message = ""
				}
				else{
				}
			}
		}
		message = "\n\n\n---------------------------------------------Visited Shop Data-----------------------------------------------------------------------------------------------------\n\n"+
				"<-------------------------------------------------------------------------------------------------------------------------------------->"
		for(int i=0; i<ProjectConstants.visitedshopdatainfo.size(); i++){
			VisitedShopDataInfo visitedshopdatainfo = ProjectConstants.visitedshopdatainfo.get(i)
			if(visitedshopdatainfo != null){
				message = message+"\n\n"+
						String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",visitedshopdatainfo.getSupervisorname(),"Merchandiser Name",visitedshopdatainfo.getMerchandisername())+"\n"+
						String.format("%-20s%-30s%-20s%-30s","Working Action:",visitedshopdatainfo.getWorkingaction(),"Route",visitedshopdatainfo.getRoute())+"\n\n"+
						String.format("%-11s%-60s%-60s","Shop Name:",visitedshopdatainfo.getShopname(),visitedshopdatainfo.getShopchannel())+"\n\n"+
						String.format("%-44s%-100s","Shop Visiting Scenarios:",visitedshopdatainfo.getShop_scenario())+"\n\n"+
						String.format("%-44s%-100s", "Other Categories Visiting Scenarios:",visitedshopdatainfo.getOthercategories_scenarios())
				if(visitedshopdatainfo.getVisitedcategoriesdata() != null){
					for(int j=0; j< visitedshopdatainfo.getVisitedcategoriesdata().size(); j++){
						VisitedCategoryData visitedcategorydata = visitedshopdatainfo.getVisitedcategoriesdata().get(j)
						if(visitedcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
							message = message + "\n\n" +
									String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory()) + "\n\n" +
									String.format("%-8s%-30s%s", "","HotSpot Remark With Type:",visitedcategorydata.getFirstvisit_categoryremark())
							if(visitedcategorydata.getOverwrite_categoryremark() != null){
								message = message + "  ==>  "+visitedcategorydata.getOverwrite_categoryremark() + "\n"
							}
							else{
								message = message + "\n"
							}
							ArrayList<ShopProductsData> shopproductsdata = visitedcategorydata.getShopproductsdata()
							if(shopproductsdata != null){
								message = message +	String.format("%-8s%-50s%-30s%-30s", "","Products","Facing","Overwrite Facing")+"\n"
								for(int n=0; n< shopproductsdata.size() ; n++){
									ShopProductsData _shopproductsdata = shopproductsdata.get(n)
									message = message + String.format("%-8s%-50s%-30s%-30s", "",_shopproductsdata.getProduct(),_shopproductsdata.getHs_facing(), _shopproductsdata.getOverwrite_hs_facing())+"\n"
								}
								message = message + "\n"
							}
						}
						else if(visitedcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
							ArrayList<SubCategory> subcategories = visitedcategorydata.getSubcategories()
							if(subcategories != null){
								message = message + "\n\n" +
										String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory()) + "\n\n"
								for(int n=0; n< subcategories.size(); n++){
									SubCategory subcategory = subcategories.get(n)
									message = message +
											String.format("%-8s%-30s%-60s", "","Sub Category:",subcategory.getSubcategory()) + "\n" +
											String.format("%-8s%-30s%s", "","Remark:",subcategory.getFirstvisit_remark())
									if(subcategory.getOverwrite_remark() != null){
										message = message + "  ==>  " + subcategory.getOverwrite_remark() + "\n"
									}
									else{
										message = message + "\n"
									}
									ArrayList<ShopProductsData> shopproductsdata = subcategory.getShopproductsdata()
									if(shopproductsdata != null){
										message = message +	String.format("%-8s%-50s%-30s%-30s", "","Products","Availability","Overwrite Availability")+"\n"
										for(int v=0; v< shopproductsdata.size() ; v++){
											ShopProductsData _shopproductsdata = shopproductsdata.get(v)
											message = message + String.format("%-8s%-50s%-30s%-30s", "",_shopproductsdata.getProduct(),_shopproductsdata.getHanger_availability(), _shopproductsdata.getOverwrite_hanger_availability())+"\n"
										}
										message = message + "\n"
									}
								}
							}
						}
						else if(visitedcategorydata.getMaincategory().equalsIgnoreCase("Survey")){
							ArrayList<SubCategory> subcategories = visitedcategorydata.getSubcategories()
							if(subcategories != null){
								message = message + "\n\n" +
										String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory())
								for(int b=0; b< subcategories.size(); b++){
									SubCategory subcategorydata = subcategories.get(b)
									message = message + "\n\n" +
											String.format("%-8s%-30s%-60s", "","Sub Category:",subcategorydata.getSubcategory())+"\n"+
											String.format("%-8s%-50s%-15s%-25s%-30s%-30s", "","Questions","Value","Picture Status","Overwrite Value","Overwrite Picture Status")+"\n"
									ArrayList<Question> surveyquestions = subcategorydata.getSurveyquestions()
									for(int v=0; v< surveyquestions.size(); v++){
										Question surveyquestion = surveyquestions.get(v)
										message = message +
												String.format("%-8s%-50s%-15s%-25s%-30s%-30s", "",surveyquestion.getQuestion(),surveyquestion.getValue(),surveyquestion.getPicture_status(),surveyquestion.getOverwrite_value(),surveyquestion.getOverwrite_picture_status()) + "\n"
									}
								}
							}
						}
						else{
							ArrayList<VisitedCategoryRemarkData> visitedcatgoryremarks = visitedcategorydata.getVisitedcategoryremarks()
							if(visitedcatgoryremarks != null){
								message = message + "\n\n" +
										String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory())
								for(int b=0; b< visitedcatgoryremarks.size(); b++){
									VisitedCategoryRemarkData visitedcategoryremark = visitedcatgoryremarks.get(b)
									if(visitedcategoryremark.getCategoryremark().equalsIgnoreCase("Availability")){
										ArrayList<SubCategory> subcategories = visitedcategoryremark.getSubcategories()
										if(subcategories != null){
											message = message + "\n\n" +
													String.format("%-8s%-30s%-60s", "","Category Remark:",visitedcategoryremark.getCategoryremark())+"\n"
											for(int c=0; c<subcategories.size(); c++){
												SubCategory subcategory = subcategories.get(c)
												message = message +
														String.format("%-8s%-30s%-60s", "","Sub Category:",subcategory.getSubcategory()) + "\n" +
														String.format("%-8s%-30s%s", "","Remark:",subcategory.getFirstvisit_remark())
												if(subcategory.getOverwrite_remark() != null){
													message = message + "  ==>  " + subcategory.getOverwrite_remark() + "\n"
												}
												else{
													message = message + "\n"
												}
											}
										}
									}
									else if(visitedcategoryremark.getCategoryremark().equalsIgnoreCase("Primary Display")){
										message = message + "\n\n" +
												String.format("%-8s%-30s%-60s", "","Category Remark",visitedcategoryremark.getCategoryremark()) + "\n" +
												String.format("%-8s%-30s%s", "","Sub Remark",visitedcategoryremark.getFirstvisit_categoryremark_subremark())
										if(visitedcategoryremark.getOverwrite_categoryremark_subremark() != null){
											message = message + "  ==>  " + visitedcategoryremark.getOverwrite_categoryremark_subremark() + "\n"
										}
										else{
											message = message + "\n"
										}
										ArrayList<SubCategory> subcategories = visitedcategoryremark.getSubcategories()
										if(subcategories != null){
											for(int c=0; c<subcategories.size(); c++){
												SubCategory subcategory = subcategories.get(c)
												message = message +
														String.format("%-8s%-30s%-60s", "","Sub Category:",subcategory.getSubcategory())
												ArrayList<ShopProductsData> shopproductsdata = subcategory.getShopproductsdata()
												if(shopproductsdata != null){
													message = message + "\n" +
															String.format("%-8s%-50s%-40s%-40s", "","Products","Display Space Available","Overwrite Display Space Available")+"\n"
													for(int n=0; n< shopproductsdata.size() ; n++){
														ShopProductsData _shopproductsdata = shopproductsdata.get(n)
														message = message + String.format("%-8s%-50s%-40s%-40s", "",_shopproductsdata.getProduct(),_shopproductsdata.getPd_displayspaceavailable(), _shopproductsdata.getPd_overwrite_displayspaceavailable())+"\n"
													}
												}
											}
										}
									}
									else if(visitedcategoryremark.getCategoryremark().equalsIgnoreCase("Secondary Display")){
										message = message + "\n\n" +
												String.format("%-8s%-30s%-60s", "","Category Remark",visitedcategoryremark.getCategoryremark()) + "\n" +
												String.format("%-8s%-30s%s", "","Sub Remark",visitedcategoryremark.getFirstvisit_categoryremark_subremark())
										if(visitedcategoryremark.getOverwrite_categoryremark_subremark() != null){
											message = message +"  ==>  " + visitedcategoryremark.getOverwrite_categoryremark_subremark() + "\n"
										}
										else{
											message = message + "\n"
										}
										ArrayList<SDUnit> sdunits = visitedcategoryremark.getSdunits()
										if(sdunits != null){
											for(int c=0; c<sdunits.size(); c++){
												SDUnit sdunit = sdunits.get(c)
												message = message +
														String.format("%-8s%-60s", "",sdunit.getUnit()) + "\n"+
														String.format("%-8s%s", "",sdunit.getRemark()+" with "+sdunit.getSub_remark())
												if(sdunit.getOverwrite_remark() != null){
													message = message + "  ==>  " +sdunit.getOverwrite_remark()+" with "+sdunit.getOverwrite_subremark() + "\n"
												}
												else{
													message = message + "\n"
												}
											}
										}
									}
									else if(visitedcategoryremark.getCategoryremark().equalsIgnoreCase("Additional Info")){
										message = message + "\n\n" +
												String.format("%-8s%-30s%-60s", "","Category Remark",visitedcategoryremark.getCategoryremark()) + "\n"
										ArrayList<Question> kbd_questions = visitedcategoryremark.getKbd_questions()
										if(kbd_questions != null){
											message = message +
													String.format("%-8s%-50s%-15s%-25s%-30s%-30s", "","Questions","Value","Picture Status","Overwrite Value","Overwrite Picture Status")+"\n"
											for(int c=0; c< kbd_questions.size(); c++){
												Question kbd_question = kbd_questions.get(c)
												message = message +
														String.format("%-8s%-50s%-15s%-25s%-30s%-30s", "",kbd_question.getQuestion(),kbd_question.getValue(),kbd_question.getPicture_status(),kbd_question.getOverwrite_value(),kbd_question.getOverwrite_picture_status()) + "\n"
											}
										}
									}
									else{}
								}
							}
						}
						message = message + "\n" +
								String.format("%-32s%-100s%-32s", "","----------------------------------------------------------------------------------------------------","")+"\n"
					}
				}
				message = message + "\n\n<-------------------------------------------------------------------------------------------------------------------------------------->\n\n"
				KeywordUtil.logInfo(message)
				message = ""
			}
		}
	}
	def findShop(String _shopname){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=totalshops; i++){
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String shopname = shop.getText()
			if(shopname.equalsIgnoreCase(_shopname)){
				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
				CommonKeywords.visitPopUpForOverwriting()
				Mobile.delay(15)
				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
				break
			}
			else{
			}
		}
	}

	def missingShopActionsList(){
		UnmatchedItems unmatcheditems = CompareDataKeywords.compareShopActionsList()
		if(unmatcheditems.getStatus() == 2){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == 1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == -1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
					break
				}
				else{
				}
			}
		}
		else{
		}
	}
	@Keyword
	def visitShopWith_HappyFlow(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		int i = ProjectConstants.SHOP_ATTEMPT
		for(i; i<= ProjectConstants.SHOP_ATTEMPT; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(Mobile.verifyElementExist(findTestObject("Object Repository/Validate_VisitDetail_Popup", [('package') : ProjectConstants.PACKAGENAME]), 0, FailureHandling.OPTIONAL)){
				Mobile.tap(findTestObject("Object Repository/VisitDetailsPopup_ProceedButton", [('package') : ProjectConstants.PACKAGENAME]), 0, FailureHandling.STOP_ON_FAILURE)
			}
			else{}
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
			//validate missing shop actions list e.g. start working / get routes etc...
			missingShopActionsList()
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "first visit"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
	}
	@Keyword
	def visitShopWithDataVerification(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=1; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "first visit"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		//		while(true){
		//			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		//			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitembeforeswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//			Mobile.swipe(0, 292, 0, 200)
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnameafterswipe = lastitemafterswipe.getText()
		//			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//				break
		//			}
		//			else{
		//				MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//				ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
		//				missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		//				missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		//				missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		//				missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		//				missingshopdatainfo.setShopname(shop.getText())
		//				visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		//				visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		//				visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		//				visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		//				visitedshopdatainfo.setShopname(shop.getText())
		//				ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		//				ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.delay(15)
		//				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		//				ProjectConstants.SCENARIO = "first visit"
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		//				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//						ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
		//						break
		//					}
		//				}
		//				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
		//					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
		//						String message = "'Retailer Remarks' with 'SM not visiting' remark"
		//						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
		//						break
		//					}
		//				}
		//				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		//			}
		//		}
		displayDataInReport()
	}

	/************************************************************
	 SHOP LEVEL OVERWRITE SCENARIOS
	 ***********************************************************/
	@Keyword
	def visitShopsWithShopLevel_OverwritingScenario(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=6; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			// shop closed to shop open
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop closed
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA to SKDNA
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/OverwriteShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("SKDNA with 'Expiry Issue' remark  ==>  SKDNA with 'Others' remark")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop permanently closed to shop not found
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopNotFound/VisitShopNotFound"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Permanently Closed ==> Shop Not Found")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop closed to shop permanently closed
			else if(i == 5){
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Permanently Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop open
			else if(i == 6){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				ProjectConstants.SHOP_ATTEMPT = 1
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwritingScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		displayDataInReport()
	}
	@Keyword
	def visitShopsWithShopLevel_OverwriteScenarios(){
		int index = 0
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=6; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			// shop closed to shop open
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop closed
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA to SKDNA
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/VisitShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/OverwriteShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("SKDNA with 'Expiry Issue' remark  ==>  SKDNA with 'Others' remark")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop permanently closed to shop not found
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopNotFound/VisitShopNotFound"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Permanently Closed ==> Shop Not Found")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop closed to shop permanently closed
			else if(i == 5){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Permanently Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop open
			else if(i == 6){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SHOP_ATTEMPT = 1
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwriteScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWithOverwritingScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
								String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		displayDataInReport()
	}

	/*************************************************
	 CATEGORY LEVEL OVERWRITE SCENARIOS
	 ************************************************/

	@Keyword
	def visitShopsWith_CategoryLevel_OverwritingScenarios(){
		int index = 0
		int _shop = 1
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(_shop; _shop<= 1; _shop++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+_shop+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.SHOP_ATTEMPT = _shop;
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+_shop+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
			//validate missing shop actions list e.g. start working / get routes etc...
			missingShopActionsList()
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "Overwrite"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwritingScenarios"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
							String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		//		while(true){
		//			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		//			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitembeforeswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//			Mobile.swipe(0, 292, 0, 200)
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnameafterswipe = lastitemafterswipe.getText()
		//			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//				break
		//			}
		//			else{
		//				_shop = _shop + 1
		//				ProjectConstants.CURRENTVISITING_SHOPNAME = lastitemnameafterswipe
		//				missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		//				missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		//				missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		//				missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		//				missingshopdatainfo.setShopname(lastitemnameafterswipe)
		//				visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		//				visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		//				visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		//				visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		//				visitedshopdatainfo.setShopname(lastitemnameafterswipe)
		//				ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		//				ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		//				ProjectConstants.SHOP_ATTEMPT = _shop
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//				//validate missing shop actions list e.g. start working / get routes etc...
		//				missingShopActionsList()
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.delay(15)
		//				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		//				ProjectConstants.SCENARIO = "Overwrite"
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwritingScenarios"), null)
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		//				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//						ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
		//						break
		//					}
		//				}
		//				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
		//					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
		//						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
		//						String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
		//						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
		//						break
		//					}
		//				}
		//				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//			}
		//		}
		displayDataInReport()
	}
	@Keyword
	def visitShopsWith_CategoryLevel_OverwriteScenarios(){
		int index = 0
		int _shop = 1
		int totalshops = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(_shop; _shop<= 1; _shop++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+_shop+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.SHOP_ATTEMPT = _shop;
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+_shop+"]").click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
			//validate missing shop actions list e.g. start working / get routes etc...
			missingShopActionsList()
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "first visit"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwriteScenarios"), null)
			ProjectConstants.SCENARIO = "Overwrite"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWithOverwritingScenarios"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
							String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		//		while(true){
		//			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		//			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitembeforeswipe  = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//			Mobile.swipe(0, 292, 0, 200)
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnameafterswipe = lastitemafterswipe.getText()
		//			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//				break
		//			}
		//			else{
		//				_shop = _shop + 1
		//				ProjectConstants.CURRENTVISITING_SHOPNAME = lastitemnameafterswipe
		//				missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		//				missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		//				missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		//				missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		//				missingshopdatainfo.setShopname(lastitemnameafterswipe)
		//				visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		//				visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		//				visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		//				visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		//				visitedshopdatainfo.setShopname(lastitemnameafterswipe)
		//				ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		//				ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		//				ProjectConstants.SHOP_ATTEMPT = _shop
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//				//validate missing shop actions list e.g. start working / get routes etc...
		//				missingShopActionsList()
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.delay(15)
		//				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		//				ProjectConstants.SCENARIO = "first visit"
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwriteScenarios"), null)
		//				ProjectConstants.SCENARIO = "Overwrite"
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWithOverwritingScenarios"), null)
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		//				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
		//					if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//						ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
		//						break
		//					}
		//				}
		//				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
		//					if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
		//						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
		//						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
		//						String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
		//						String.format("%-40s%-100s", "","(2) 'Retailer Remarks' with 'Incentive not paid' remark")
		//						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
		//						break
		//					}
		//				}
		//				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//			}
		//		}
		displayDataInReport()
	}
}
