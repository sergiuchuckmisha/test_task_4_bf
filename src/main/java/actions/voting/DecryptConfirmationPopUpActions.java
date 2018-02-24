package actions.voting;

import actions.ActionsBase;
import pageObjects.voting.DecryptConfirmationPopUpPage;
import pageObjects.voting.pageElements.iDecryptConfirmationPopUp;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on DecryptConfirmationPopUp page
 */
public class DecryptConfirmationPopUpActions extends ActionsBase<DecryptConfirmationPopUpPage> implements iDecryptConfirmationPopUp {

	/**purpose of the constructor is to initialize page field*/
	public DecryptConfirmationPopUpActions()
	{
		super();
		page = new DecryptConfirmationPopUpPage();
	}
}
