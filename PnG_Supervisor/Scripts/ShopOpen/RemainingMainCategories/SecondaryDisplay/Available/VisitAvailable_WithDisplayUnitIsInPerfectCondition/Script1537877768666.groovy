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

Mobile.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('CommonScreenElements/TakePictureButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CommonScreenElements/DoneButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_AvailableRemarksScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 0)

CustomKeywords.'com.ct.qa.keywords.SecondaryDisplayKeywords.selectSecondaryDisplay_AvailableRemark'('Display Unit is in perfect condition', 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_UtilizationPopUpScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 'Utilization')

CustomKeywords.'com.ct.qa.keywords.SecondaryDisplayKeywords.enterUtilizationForSecondaryDisplay'(1)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Utilization_SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/SecondaryDisplay/Available/Validate_UnitsListScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 0)

