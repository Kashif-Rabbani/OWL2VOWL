package org.visualdataweb.vowl.owl2vowl;

import org.visualdataweb.vowl.owl2vowl.parser.helper.ComparisonHelperTest;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		ComparisonHelperTest.class,
		ConsoleMainTest.class,
		OntobenchTest.class,
		PropertyTest.class
})
public class CompleteTestSuite extends TestSuite {

}
