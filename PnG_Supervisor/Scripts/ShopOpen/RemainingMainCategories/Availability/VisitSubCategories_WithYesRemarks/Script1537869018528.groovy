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

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Validate_SubCategoryDetailScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 'Availability')

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Availability', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Validate_ProductAvailabilityScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 'Availability')

CustomKeywords.'com.ct.qa.keywords.AvailabilityKeywords.visitProductsAvailabilityWithYesRemarks'()

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/_Availability/ProductAvailability_SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Validate_SubCategoryDetailScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 'Availability')

Mobile.pressBack()

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/_Availability/Validate_SubCategoriesScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 0)

