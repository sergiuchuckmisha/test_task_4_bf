package pageObjects.voting.pageElements.checkboxTableElements;

import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.utils.DriverHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * idea of the class is to reflect tables with checkboxes (in the middle of the page like on page https://exonum.com/demo/voting/#/monitor)
 * */
public interface iCheckboxTable {
    By checkboxesLocator = By.xpath("//table[@class = 'app-list']//td/div[contains(@class, 'checker')]");
    By valuesLocator = By.xpath("//table[@class = 'app-list']//td[@class = 'ng-binding']");

    default List<Boolean> getCheckboxes(){
        return DriverHelper.findElements(checkboxesLocator).stream().map(webElement -> "checker active".equals(webElement.getAttribute("class"))).collect(Collectors.toList());
    }

    default List<String> getCheckBoxTableValues(){
        return DriverHelper.findElements(valuesLocator).stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
    }

    default void selectCheckBoxTableValue(String value){
        if (null == value || value.isEmpty()) {
            throw new IllegalArgumentException("empty value provided");
        }
        DriverHelper.click(By.xpath(String.format("//table[@class = 'app-list']//td[text() = '%s']", value)));
    }

    default long howManyOptionsChecked(){
        return getCheckboxes().stream().filter(checkbox -> checkbox).count();
    }

    default long howManyOptions(){
        return getCheckboxes().stream().count();
    }
}
