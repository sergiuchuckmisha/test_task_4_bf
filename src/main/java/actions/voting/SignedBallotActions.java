package actions.voting;

import actions.ActionsBase;
import pageObjects.voting.SignedBallotPage;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on 'Ballot has been signed' page
 */
public class SignedBallotActions extends ActionsBase<SignedBallotPage> implements iBottomMenuActions, iTopMenuActions {

	/**purpose of the constructor is to initialize page field*/
	public SignedBallotActions()
	{
		super();
		page = new SignedBallotPage();
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}

	public void pressDiscardButton(){
		page.pressDiscardButton();
	}

	public void pressSubmitButton(){
		page.pressSubmitButton();
	}

	public void typeEmail(String email){
		page.typeEmail(email);
	}
}
