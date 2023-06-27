import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//TestData data = TestDataFactory.('Data Files/userData');

TestData data = findTestData('userData')
String username = data.getValue('username', 1)
String password = data.getValue('password', 1)



//Opening the browser
WebUI.openBrowser(GlobalVariable.testPage, FailureHandling.STOP_ON_FAILURE)
WebUI.maximizeWindow(); 

//log into the products page
if(WebUI.waitForElementPresent(findTestObject('Object Repository/loginPage/logo'), 10)){
// set username
WebUI.setText(findTestObject('Object Repository/loginPage/usernameField'), username)

// set password
WebUI.setText(findTestObject('Object Repository/loginPage/passwordField'), password)

// clicking on loginbtn
WebUI.click(findTestObject('Object Repository/loginPage/loginBtn'))


} else {
	WebUI.closeBrowser();
}