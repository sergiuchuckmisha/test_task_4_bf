package actions.voting;

import actions.ActionsBase;
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

	public String getBallotReceipt3WordMemo(){
		return page.getBallotReceipt3WordMemo();
	}
	public String getBallotSHA256Hash(){
		return page.getBallotSHA256Hash();
	}
}
