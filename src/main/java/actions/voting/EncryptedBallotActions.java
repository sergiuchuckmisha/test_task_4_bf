package actions.voting;

import actions.ActionsBase;
import pageObjects.voting.EncryptedBallotPage;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on 'Your Decrypted Ballot' page
 */
public class EncryptedBallotActions extends ActionsBase<EncryptedBallotPage> implements iBottomMenuActions, iTopMenuActions {

	/**purpose of the constructor is to initialize page field*/
	public EncryptedBallotActions()
	{
		super();
		page = new EncryptedBallotPage();
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}

	public void pressReturnButton(){
		page.pressReturnButton();
	}
}
