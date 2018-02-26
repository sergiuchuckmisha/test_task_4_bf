package com.sergiuchuckmisha.bf.e2e;

import com.sergiuchuckmisha.bf.base.SeleniumBaseTest;
import org.testng.annotations.Test;
import com.sergiuchuckmisha.bf.pages.voting.CandidatesOfElectionPage;
import com.sergiuchuckmisha.bf.pages.voting.ElectionsPage;
import com.sergiuchuckmisha.bf.pages.voting.VoteConfirmationPopUpPage;
import com.sergiuchuckmisha.bf.pages.voting.WelcomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:01 PM
 * purpose of the class is to contain relatively "long" scenarios like navigation
 */
public class VoteTest extends SeleniumBaseTest {

	private static final WelcomePage welcomePage = new WelcomePage();
	private static final ElectionsPage electionsPage = new ElectionsPage();
	private static final CandidatesOfElectionPage candidatesOfElectionPage = new CandidatesOfElectionPage();
	private static final VoteConfirmationPopUpPage voteConfirmationPopUpPage = new VoteConfirmationPopUpPage();

	/**
	 *  * purpose of the method is to check following scenario:
	 * 1. Opens https://exonum.com/demo/voting/#/welcome in browser
	 * 2. navigate to page e-Voting (https://exonum.com/demo/voting/#/elections)
	 * 2.1 and then to 'Candidates of Election' com.sergiuchuckmisha.bf.pages
	 * 3. verify that only one option can be selected and that one option is selected
	 * */
	@Test
	public void voteForSmbTest() {
		welcomePage.navigateTo();

		//welcome page check 'VOTE IN ELECTION'
		welcomePage.pressVoteInElectionButton();
		assertTrue(electionsPage.isOnPage());

		//only one option can be selected
		assertEquals(1, electionsPage.howManyOptionsChecked());

		//select voting
		electionsPage.pressVoteInElectionButton();
		assertTrue(candidatesOfElectionPage.isOnPage());

		//vote for smb
		assertEquals(1, candidatesOfElectionPage.howManyOptionsChecked());
		candidatesOfElectionPage.pressVoteInElectionButton();

		assertTrue(voteConfirmationPopUpPage.isOnPage());

		voteConfirmationPopUpPage.pressVoteConfirmationPopUpCancelButton();
		assertTrue(candidatesOfElectionPage.isOnPage());

		//vote for smb
		assertEquals(1, candidatesOfElectionPage.howManyOptionsChecked());
		candidatesOfElectionPage.pressVoteInElectionButton();

		assertTrue(voteConfirmationPopUpPage.isOnPage());
		voteConfirmationPopUpPage.pressVoteConfirmationPopUpYesButton();
	}

}