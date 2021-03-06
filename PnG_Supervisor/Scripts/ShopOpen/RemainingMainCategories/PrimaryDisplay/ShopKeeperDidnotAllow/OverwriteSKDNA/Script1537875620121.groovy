import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/Validate_PrimaryDisplayRemarksScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

CustomKeywords.'com.ct.qa.keywords.AdditionalInfoKeywords.selectPrimaryDisplayRemark'('Shopkeeper did not allow')

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/Validate_CategoryRemarksScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'CATEGORY REMARKS')

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/CategoryRemark_Others', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/CategoryRemark_BackButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/Validate_PrimaryDisplayRemarksScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/BackButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

CustomKeywords.'com.ct.qa.keywords.AdditionalInfoKeywords.validateCategoryDetailActionScreen'()

