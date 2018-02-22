package actions.voting;

import actions.ActionsBase;
import actions.voting.interfaces.iBottomMenuActions;
import actions.voting.interfaces.iTopMenuActions;
import pageObjects.voting.DecryptedBallotPage;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on 'Your Decrypted Ballot' page
 */
public class DecryptedBallotActions extends ActionsBase<DecryptedBallotPage> implements iBottomMenuActions, iTopMenuActions {

	/**purpose of the constructor is to initialize page field*/
	public DecryptedBallotActions()
	{
		super();
		page = new DecryptedBallotPage();
	}

	@Override
	@Deprecated
	public void pressTopMenuBackArrow(){
		//method should not be used because TopMenuBackArrow is absent on DecryptedBallotPage
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}

	public void pressTallyingAuthoritiesAggregatePublicKey(){
		page.pressTallyingAuthoritiesAggregatePublicKey();
	}

	public void pressCandidateOptionSelectedAndEncryptionRandomness(){
		page.pressCandidateOptionSelectedAndEncryptionRandomness();
	}

	public void pressEncryptedBallot(){
		page.pressEncryptedBallot();
	}

	public void pressBallotSHA256Hash(){
		page.pressBallotSHA256Hash();
	}

	public void press3WordMemoByBIPMnemonicCodeAlgorithm(){
		page.press3WordMemoByBIPMnemonicCodeAlgorithm();
	}

	public void pressReturnButton(){
		page.pressReturnButton();
	}
}
