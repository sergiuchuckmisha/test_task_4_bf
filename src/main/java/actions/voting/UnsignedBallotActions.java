package actions.voting;

import actions.ActionsBase;
import actions.voting.interfaces.iBottomMenuActions;
import actions.voting.interfaces.iTopMenuActions;
import dataModels.CryptoDetails;
import pageObjects.voting.UnsignedBallotPage;
import pageObjects.voting.pageElements.iUnsignedBallotPageDiscardDecryptSignButtons;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on Your Unsigned Ballot page
 */
//todo do smth with iUnsignedBallotPageDiscardDecryptSignButtons
public class UnsignedBallotActions extends ActionsBase<UnsignedBallotPage> implements iBottomMenuActions, iTopMenuActions, iUnsignedBallotPageDiscardDecryptSignButtons {

	/**purpose of the constructor is to initialize page field*/
	public UnsignedBallotActions()
	{
		super();
		page = new UnsignedBallotPage();
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}

	public CryptoDetails getCryptoDetails(){
		return new CryptoDetails(page.getBallotSHA256Hash(), page.getBallotReceipt3WordMemo());
	}
}
