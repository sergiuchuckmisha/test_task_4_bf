package com.sergiuchuckmisha.bf.e2e;

import com.google.inject.Inject;
import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import com.sergiuchuckmisha.bf.pages.voting.CandidatesOfElectionPage;
import com.sergiuchuckmisha.bf.pages.voting.ElectionsPage;
import com.sergiuchuckmisha.bf.pages.voting.WelcomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain relatively "long" scenarios like navigation
 */
public class CheckboxTableTest extends SeleniumBaseTest {

	@Inject private WelcomePage welcomePage;
//	@Inject private static final MonitorPage monitorPage;//is not used because monitor page is unfinished
	@Inject private ElectionsPage electionsPage;
	@Inject private CandidatesOfElectionPage candidatesOfElectionPage;

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. navigate to page e-Voting (https://exonum.com/demo/voting/#/elections)
	 * 2.1 and then to 'Candidates of Election' com.sergiuchuckmisha.bf.pages
	 * 3. verify that only one option can be selected and that one option is selected
	 * */
	@Test
	public void checkboxTablesTest() {
		welcomePage.navigateToUrl();

		//welcome page check 'VOTE IN ELECTION'
		welcomePage.pressVoteInElectionButton();
		assertTrue(electionsPage.isOnPage());

		//only one option can be selected
		assertEquals(1, electionsPage.howManyOptionsChecked());

		for(String value: electionsPage.getCheckBoxTableValues()){
			electionsPage.selectCheckBoxTableValue(value);

			assertEquals(1, electionsPage.howManyOptionsChecked());

			//same check for 'Candidates of Election' com.sergiuchuckmisha.bf.pages
			electionsPage.pressVoteInElectionButton();
			assertTrue(candidatesOfElectionPage.isOnPage());
			for(String value2: candidatesOfElectionPage.getCheckBoxTableValues()) {
				candidatesOfElectionPage.selectCheckBoxTableValue(value2);

				assertEquals(1, candidatesOfElectionPage.howManyOptionsChecked());
			}
			candidatesOfElectionPage.pressTopMenuBackArrow();
			assertTrue(electionsPage.isOnPage());
		}

	}

}
