package actions;

import pageObjects.GooglePage;
import selenium.utils.DriverHelper;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed on Calender page
 */
public class GoogleActions extends ActionsBase<GooglePage> {

	/**purpose of the constructor is to initialize page field*/
	public GoogleActions()
	{
		super();
		page = new GooglePage();
	}



	public GoogleActions searchString(String searchString)
	{
		page.fillSearchField(searchString);
		page.pressEnter();
		DriverHelper.waitUntilPageIsLoaded();
		return this;
	}

	public GoogleActions assertStringIsPresentAmongSearchResults(String str)
	{
		page.assertStringIsPresentAmongSearchResults(str);
		return this;
	}
}
