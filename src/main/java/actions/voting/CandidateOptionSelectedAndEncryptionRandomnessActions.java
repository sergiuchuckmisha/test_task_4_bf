package actions.voting;

import actions.ActionsBase;
import actions.voting.interfaces.iBottomMenuActions;
import actions.voting.interfaces.iTopMenuActions;
import pageObjects.voting.CandidateOptionSelectedAndEncryptionRandomnessPage;
import pageObjects.voting.TallyingAuthoritiesAggregatePublicKeyPage;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on CandidateOptionSelectedAndEncryptionRandomnessPage
 */
public class CandidateOptionSelectedAndEncryptionRandomnessActions extends ActionsBase<CandidateOptionSelectedAndEncryptionRandomnessPage> implements iBottomMenuActions, iTopMenuActions {

	/**purpose of the constructor is to initialize page field*/
	public CandidateOptionSelectedAndEncryptionRandomnessActions()
	{
		super();
		page = new CandidateOptionSelectedAndEncryptionRandomnessPage();
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}
}
