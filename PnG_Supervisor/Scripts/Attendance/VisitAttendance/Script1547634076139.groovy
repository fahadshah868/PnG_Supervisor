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

'validate the dashboard screen appearance'
Mobile.verifyElementText(findTestObject('DashboardScreenElements/Validate_DashboardScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Dashboard')

Mobile.tap(findTestObject('DashboardScreenElements/AttendenceButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('Attendance/Validate_SupervisorAttendanceScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Attendance')

Mobile.tap(findTestObject('Attendance/Supervisor_SelfieCamera_Imageiew', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.verifyElementExist(findTestObject('CommonScreenElements/Validate_CameraScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('CommonScreenElements/TakePictureButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('CommonScreenElements/DoneButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('Attendance/Validate_SupervisorAttendanceScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'Attendance')

CustomKeywords.'com.ct.qa.keywords.AttendanceKeywords.visitSupervisorAttendanceRemark'()

Mobile.tap(findTestObject('Attendance/SubmitButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.delay(15)

Mobile.verifyElementExist(findTestObject('CommonScreenElements/Validate_MapScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('CommonScreenElements/Location_CheckIn', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementExist(findTestObject('CommonScreenElements/Validate_InfoPopUP', [('package') : ProjectConstants.PACKAGENAME]), 
    0)

Mobile.tap(findTestObject('CommonScreenElements/InfoPopUp_YesButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

Mobile.verifyElementText(findTestObject('Attendance/Validate_MerchandisersListScreen', [('package') : ProjectConstants.PACKAGENAME]), 
    'List of Team Members')

CustomKeywords.'com.ct.qa.keywords.AttendanceKeywords.visitMerchandisersAttendance'()

Mobile.tap(findTestObject('Attendance/StartYourDayButton', [('package') : ProjectConstants.PACKAGENAME]), 0)

