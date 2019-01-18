import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.ct.qa.constants.ProjectConstants as ProjectConstants
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

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_HangerAvailabilityScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Category:Hanger')

Mobile.tap(findTestObject('ShopOpen/Hanger/HangerAvailable/Availability', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementExist(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_ProductsAvailabilityScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

CustomKeywords.'com.ct.qa.keywords.HangerKeywords.visitHangerProducts'(ProjectConstants.HANGERNOTAVAILABLE)

Mobile.tap(findTestObject('ShopOpen/Hanger/HangerAvailable/SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_HangerAvailabilityScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Category:Hanger')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findPlanogramImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_HangerAvailabilityScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Category:Hanger')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findPictureImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/HangerAvailable/Validate_HangerAvailabilityScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Category:Hanger')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findBackButtonImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/Validate_HangerRemarksScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'KPI: Hanger')

Mobile.tap(findTestObject('ShopOpen/Hanger/Backbutton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/Hanger/Validate_HangerListScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Hanger List')

