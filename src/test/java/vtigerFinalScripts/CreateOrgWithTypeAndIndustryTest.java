package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateOrgWithTypeAndIndustryTest extends BaseClass {

	@Test
	public void createOrgWithIndustryAndTypeTest() {
		SoftAssert soft = new SoftAssert();
		home.clickOrganizations();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createOrg.getPageHeader().equals("Creating New Organization"));
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization With Industry And Type");
		String orgName = map.get("Organization Name") + jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.selectIndustry(web, map.get("Industry"));
		createOrg.selectType(web, map.get("Type"));
		createOrg.clickSaveButton();

		soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
		if (newOrgInfo.getPageHeader().contains(orgName))
			excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "Fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
	}
}
