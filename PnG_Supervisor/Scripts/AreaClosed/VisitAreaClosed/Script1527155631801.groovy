import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.ct.qa.constants.ProjectConstants
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'validate shop actions list screen appearance'
MobileBuiltInKeywords.verifyElementExist(findTestObject('ShopActions_List', [('package') : ProjectConstants.PACKAGENAME]), 0)

'tap on "Area Closed" option from shop actions list'
MobileBuiltInKeywords.tap(findTestObject('AreaClosed/AreaClosed', [('package') : ProjectConstants.PACKAGENAME]), 0)

'validate camera screen appearance'
MobileBuiltInKeywords.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen', [('package') : ProjectConstants.PACKAGENAME]), 0)

'tap on take picture button'
MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/TakePictureButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

'delay of 5 seconds while taking shop picture'
MobileBuiltInKeywords.delay(5)

'tap on done button after taking shop picture'
MobileBuiltInKeywords.tap(findTestObject('CommonScreenElements/DoneButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

