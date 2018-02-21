package actions.voting;

import actions.ActionsBase;
import pageObjects.voting.WelcomePage;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on welcome page
 */
public class WelcomeActions extends ActionsBase<WelcomePage> {

	private static String url = "https://exonum.com/demo/voting/#/welcome";

	/**purpose of the constructor is to initialize page field*/
	public WelcomeActions()
	{
		super();
		page = new WelcomePage();
	}

	public WelcomeActions pressVote()
	{
		page.pressVote();
		return this;
	}

	public WelcomeActions pressMonitorElectionProcess()
	{
		page.pressMonitorElectionProcess();
		return this;
	}
}
