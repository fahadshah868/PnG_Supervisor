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

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Validate_ShareOfShelfScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 'Share of shelf')

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/ShareOfShelf', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Validate_ShareOfShelfProductsScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 'Share of shelf')

CustomKeywords.'com.ct.qa.keywords.PrimaryDisplayKeywords.visitDSA_Products'(ProjectConstants.OVERWRITEDISPLAYSPACEAVAILABLE)

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Validate_AlertScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 'Alert')

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Alert_SaveButton', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementText(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Validate_ShareOfShelfScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 'Share of shelf')

Mobile.tap(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/ShareofShelf_BackButton', 
        [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/Validate_SubCategoriesScreen', 
        [('package') : ProjectConstants.PACKAGENAME]), 0)

