package si.unimb.lisa.shop.test.junitOld;

import junit.framework.Test;

//JUnit 3.x

public class TestSuite {

	public static Test suite() {
		junit.framework.TestSuite ts=new junit.framework.TestSuite();
		ts.addTestSuite(ItemIncreasePriceTest.class);
		ts.addTestSuite(ItemTest.class);
		ts.addTestSuite(BuyerTest.class);
		ts.addTestSuite(ShopTest.class);
		ts.addTestSuite(ReceiptTest.class);
		return ts;
	}
}
