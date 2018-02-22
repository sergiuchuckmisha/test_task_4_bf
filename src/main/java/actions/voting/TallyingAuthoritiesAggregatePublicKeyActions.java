package actions.voting;

import actions.ActionsBase;
import actions.voting.interfaces.iBottomMenuActions;
import actions.voting.interfaces.iTopMenuActions;
import pageObjects.voting.MonitorPage;
import pageObjects.voting.TallyingAuthoritiesAggregatePublicKeyPage;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on TallyingAuthoritiesAggregatePublicKeyPage
 */
public class TallyingAuthoritiesAggregatePublicKeyActions extends ActionsBase<TallyingAuthoritiesAggregatePublicKeyPage> implements iBottomMenuActions, iTopMenuActions {

	/**purpose of the constructor is to initialize page field*/
	public TallyingAuthoritiesAggregatePublicKeyActions()
	{
		super();
		page = new TallyingAuthoritiesAggregatePublicKeyPage();
	}

	@Override
	public String getTopMenuName() {
		return page.getTopMenuName();
	}

	public String getModulusHexadecimal(){
		return page.getModulusHexadecimal();
	}

	public String getPublicExponent(){
		return page.getPublicExponent();
	}
}
