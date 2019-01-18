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

Mobile.verifyElementVisible(findTestObject('WorkActions/validate_WorkActionsScreen'), 100)

Mobile.verifyElementText(findTestObject('WorkActions/validate_WorkActionsScreen'), 'Select')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectAction'('WW')

Mobile.verifyElementText(findTestObject('WorkActions/Validate_SubWorkActionsScreen'), 'Select')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectSubAction'('Route')

Mobile.verifyElementVisible(findTestObject('WorkActions/Validate_RouteListScreen'), 100)

Mobile.verifyElementText(findTestObject('WorkActions/Validate_RouteListScreen'), 'Route LIST')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectRoute'()

'Validate shops list screen appearance'
Mobile.verifyElementVisible(findTestObject('Validate_ShopListScreen', [('package') : ProjectConstants.PACKAGENAME]), 100)

'Validate shops list screen appearance'
Mobile.verifyElementText(findTestObject('Validate_ShopListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Shops on Route')

'select shops from shops list for data verification'
CustomKeywords.'com.ct.qa.keywords.ShopVisitingScenariosKeywords.visitShopWith_HappyFlow'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('WorkActions/Validate_RouteListScreen'), 'Route LIST')

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('WorkActions/Validate_SubWorkActionsScreen'), 'Select')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectSubAction'('Un-Captured')

Mobile.verifyElementExist(findTestObject('WorkActions/Validate_UncapturedVisit_Popup'), 0)

Mobile.tap(findTestObject('WorkActions/Uncapturedvisit_OkButton'), 0)

CustomKeywords.'com.ct.qa.keywords.WorkActions.validateShopListScreenForUnCapturedShops'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('WorkActions/validate_WorkActionsScreen'), 'Select')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectAction'('WR')

Mobile.verifyElementText(findTestObject('WorkActions/Validate_SubWorkActionsScreen'), 'Select')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectSubAction'('Route')

Mobile.verifyElementVisible(findTestObject('WorkActions/Validate_RouteListScreen'), 100)

Mobile.verifyElementText(findTestObject('WorkActions/Validate_RouteListScreen'), 'Route LIST')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectSameRouteForDifferentWorkActions'(ProjectConstants.CURRENTVISITING_ROUTE)

'Validate shops list screen appearance'
Mobile.verifyElementVisible(findTestObject('Validate_ShopListScreen', [('package') : ProjectConstants.PACKAGENAME]), 100)

'Validate shops list screen appearance'
Mobile.verifyElementText(findTestObject('Validate_ShopListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Shops on Route')

'select shops from shops list for data verification'
CustomKeywords.'com.ct.qa.keywords.ShopVisitingScenariosKeywords.visitShopWith_HappyFlow'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('WorkActions/Validate_RouteListScreen'), 'Route LIST')

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('WorkActions/Validate_SubWorkActionsScreen'), 'Select')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectSubAction'('Un-Captured')

Mobile.verifyElementExist(findTestObject('WorkActions/Validate_UncapturedVisit_Popup'), 0)

Mobile.tap(findTestObject('WorkActions/Uncapturedvisit_OkButton'), 0)

CustomKeywords.'com.ct.qa.keywords.WorkActions.validateShopListScreenForUnCapturedShops'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('WorkActions/validate_WorkActionsScreen'), 'Select')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectAction'('Merchandising')

Mobile.verifyElementVisible(findTestObject('WorkActions/Validate_RouteListScreen'), 100)

Mobile.verifyElementText(findTestObject('WorkActions/Validate_RouteListScreen'), 'Route List')

CustomKeywords.'com.ct.qa.keywords.WorkActions.selectSameRouteForDifferentWorkActions'(ProjectConstants.CURRENTVISITING_ROUTE)

'Validate shops list screen appearance'
Mobile.verifyElementVisible(findTestObject('Validate_ShopListScreen', [('package') : ProjectConstants.PACKAGENAME]), 100)

'Validate shops list screen appearance'
Mobile.verifyElementText(findTestObject('Validate_ShopListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Shops on Route')

'select shops from shops list for data verification'
CustomKeywords.'com.ct.qa.keywords.ShopVisitingScenariosKeywords.visitShopWith_HappyFlow'()

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('WorkActions/Validate_RouteListScreen'), 'Route LIST')

Mobile.pressBack()

Mobile.verifyElementText(findTestObject('WorkActions/validate_WorkActionsScreen'), 'Select')

