package actions.voting;

import actions.ActionsBase;
import pageObjects.voting.SignConfirmationPopUpPage;
import pageObjects.voting.pageElements.iSignConfirmationPopUp;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on DecryptConfirmationPopUp page
 */
public class SignConfirmationPopUpActions extends ActionsBase<SignConfirmationPopUpPage> implements iSignConfirmationPopUp {

	/**purpose of the constructor is to initialize page field*/
	public SignConfirmationPopUpActions()
	{
		super();
		page = new SignConfirmationPopUpPage();
	}

	public void pressNumber(int i){
		page.pressNumber(i);
	}

	public void enterSomePINCode(){
		pressNumber(1);
		pressNumber(2);
		pressNumber(3);
		pressNumber(4);
	}
}
