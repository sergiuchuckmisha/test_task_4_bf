package actions.voting;

import pageObjects.voting.pageElements.iTopMenu;

/**
 * Created with IntelliJ IDEA.
 * User: sergiuchuckmisha
 * Date: 9/16/15
 * Time: 3:11 PM
 * purpose of this class is to describe business logic actions that can be performed with top menu elements
 */
public interface iTopMenuActions {

//	iTopMenu topMenu = null;

	iTopMenu getTopMenu();

	static void pressBackArrow() {
		iTopMenu.pressBackArrow();
	}

	static void pressHelp() {
		iTopMenu.pressHelp();
	}

	default boolean isNamePresent() {
		return getTopMenu().isNamePresent();
	}
}
