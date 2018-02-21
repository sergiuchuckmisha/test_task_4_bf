package actions.voting;

import actions.ActionsBase;
import pageObjects.voting.MonitorPage;
import pageObjects.voting.pageElements.iTopMenu;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on monitor page
 */
public class MonitorActions extends ActionsBase<MonitorPage> implements iBottomMenuActions, iTopMenuActions {

	private static String url = "https://exonum.com/demo/voting/#/monitor";

	/**purpose of the constructor is to initialize page field*/
	public MonitorActions()
	{
		super();
		page = new MonitorPage();
	}

	@Override
	public void navigateTo() {
		if(!page.isOnPage())
		DriverHelper.navigateToCertainUrl(url);
	}

	@Override
	public iTopMenu getTopMenu() {
		return page;
	}
}
