package si.unimb.lisa.prodajalna.test.junitOld.napredno;

import junit.framework.Test;
import junit.framework.TestSuite;

//JUnit 3.x

public class GarnituraTestov {

	public static Test suite() {
		TestSuite ts=new TestSuite();
		ts.addTestSuite(ArtikelTest.class);
		ts.addTestSuite(KupecTest.class);
		ts.addTestSuite(ProdajalnaTest.class);
		ts.addTestSuite(RacunTest.class);
		return ts;
	}
}
