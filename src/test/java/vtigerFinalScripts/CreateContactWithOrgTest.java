package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() {
		SoftAssert soft = new SoftAssert();
		home.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contacts.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		Map<String,String> map = excel.readFromExcel("ContactsTestData", "Create Contact With Organization");
		String lastName = map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.selectExistingOrg(web, map.get("Organization Name"));
		createContact.clickSaveButton();
		soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));
		if(newContactInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
	}
}
