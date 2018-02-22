package actions.voting;

import actions.ActionsBase;
import dataModels.CryptoDetails;
import pageObjects.voting.SubmittedBallotPage;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on 'Ballot has been signed' page
 */
public class SubmittedBallotActions extends ActionsBase<SubmittedBallotPage> implements iBottomMenuActions, iTopMenuActions {

	/**purpose of the constructor is to initialize page field*/
	public SubmittedBallotActions()
	{
		super();
		page = new SubmittedBallotPage();
	}

	@Override
	@Deprecated
	public void pressTopMenuBackArrow(){
		//method should not be used because TopMenuBackArrow is absent on SubmittedBallotPage
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}

	public CryptoDetails getCryptoDetails(){
		return new CryptoDetails(page.getBallotReceiptHash(), page.getBallotReceipt3WordMemo());
	}

}
