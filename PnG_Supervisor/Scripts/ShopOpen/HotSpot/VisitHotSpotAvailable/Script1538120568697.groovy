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

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Hotspot_SelectType', [('package') : ProjectConstants.PACKAGENAME]), 
    'Select appropriate type')

CustomKeywords.'com.ct.qa.keywords.HotSpotKeywords.visitHotSpotType'(1)

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_AssetsScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Facing')

Mobile.tap(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Facing', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_FacingScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Facing')

CustomKeywords.'com.ct.qa.keywords.HotSpotKeywords.visitHotSpotAvailableFacingProducts'(ProjectConstants.HOTSPOTFACING)

Mobile.tap(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementExist(findTestObject('CommonScreenElements/Validate_InfoPopUP', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('CommonScreenElements/InfoPopUp_OKButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_AssetsScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Facing')

Mobile.tap(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/POSM_ImageView', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_POSMScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'POSM Deployment')

CustomKeywords.'com.ct.qa.keywords.HotSpotKeywords.findPOSMImageView'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_AssetsScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Facing')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findPlanogramImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_AssetsScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Facing')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findPictureImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Validate_AssetsScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Facing')

CustomKeywords.'com.ct.qa.keywords.CommonKeywords.findBackButtonImageView'()

Mobile.verifyElementText(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/ValidateUtilization_Popup', [('package') : ProjectConstants.PACKAGENAME]), 
    'Utilization')

Mobile.tap(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/HotSpotIsAvailableOnTheRightLocation_Yes', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

CustomKeywords.'com.ct.qa.keywords.HotSpotKeywords.enterUtilization'(1)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('ShopOpen/HotSpot/HotSpotAvailable/Utilization_popupSubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementExist(findTestObject('ShopOpen/HotSpot/Validate_HotSpotRemarksScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('ShopOpen/HotSpot/BackButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('ShopOpen/Validate_ShopCategoriesListScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

