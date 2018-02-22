package actions.voting;

import actions.ActionsBase;
import actions.voting.interfaces.iBottomMenuActions;
import actions.voting.interfaces.iCheckboxTableActions;
import actions.voting.interfaces.iTopMenuActions;
import actions.voting.interfaces.iVoteInElectionButtonActions;
import pageObjects.voting.ElectionsPage;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on monitor page
 */
public class ElectionsActions extends ActionsBase<ElectionsPage> implements iBottomMenuActions, iTopMenuActions, iCheckboxTableActions, iVoteInElectionButtonActions {

	/**purpose of the constructor is to initialize page field*/
	public ElectionsActions()
	{
		super();
		page = new ElectionsPage();
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}
}
