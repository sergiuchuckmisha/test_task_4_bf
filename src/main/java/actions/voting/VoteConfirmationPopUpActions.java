package actions.voting;

import actions.ActionsBase;
import pageObjects.voting.CandidatesOfElectionPage;
import pageObjects.voting.VoteConfirmationPopUpPage;
import pageObjects.voting.pageElements.iVoteConfirmationPopUp;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on monitor page
 */
public class VoteConfirmationPopUpActions extends ActionsBase<VoteConfirmationPopUpPage> implements iVoteConfirmationPopUp {

	/**purpose of the constructor is to initialize page field*/
	public VoteConfirmationPopUpActions()
	{
		super();
		page = new VoteConfirmationPopUpPage();
	}

	//this method should not be called
	@Override
	public String getUrl() {
		return "null";
	}
}
