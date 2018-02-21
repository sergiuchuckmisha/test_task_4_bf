package actions.voting;

import actions.ActionsBase;
import pageObjects.voting.CandidatesOfElectionPage;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on monitor page
 */
public class CandidatesOfElectionActions extends ActionsBase<CandidatesOfElectionPage> implements iBottomMenuActions, iTopMenuActions, iCheckboxTableActions, iVoteInElectionButtonActions {

	/**purpose of the constructor is to initialize page field*/
	public CandidatesOfElectionActions()
	{
		super();
		page = new CandidatesOfElectionPage();
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}
}
