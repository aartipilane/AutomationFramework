package inventoryTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

public class S2_AddLowestPriceProductToCartTest extends BaseClass {

	@Test
	public void tc_02_AddLowestPriceProductToCartTest() throws IOException {

		// Read Data from excel file
		String productname = fUtil.readDataFromExcel("Sheet1", 4, 3); // Run time data
		String sortOption = fUtil.readDataFromExcel("Sheet1", 4, 2);

		// Click on a product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnLowestPriceProduct(driver, sortOption, productname);

		// Click on add to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Navigate to Cart
		ip.clickOnCartContainer();

		// Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String ProductIncart = cp.captureName();
		if (ProductIncart.equals(productname)) {
			System.out.println("PASS");
			System.out.println(ProductIncart);
		} else {
			System.out.println("FAIL");
		}

		// Logout of Application
		ip.logoutApp();
	}
}
