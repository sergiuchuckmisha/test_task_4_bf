package pageObjects.voting.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import selenium.utils.DriverHelper;

import java.util.List;
import java.util.stream.Collectors;

import static selenium.utils.DriverHelper.findElements;

/**
 * idea of the class is to reflect tables with checkboxes (in the middle of the page like on page https://exonum.com/demo/voting/#/monitor)
 * */
public interface ICheckboxTable {

    default List<Boolean> getCheckboxes(){
        return DriverHelper

                .findElements(By.cssSelector("table.app-list td>div.checker"))
                .stream()
                .map(webElement -> "checker active".equals(webElement.getAttribute("class")))   //.isSelected() does not work
                .collect(Collectors.toList());
    }
    default List<String> getCheckBoxTableValues(){
        return
                findElements(By.cssSelector("table.app-list td.ng-binding"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    default void selectCheckBoxTableValue(String value){
        if (null == value || value.isEmpty()) {
            throw new IllegalArgumentException("empty value provided");
        }
        DriverHelper.click(new ByChained(By.cssSelector("table.app-list"),
                By.xpath(String.format(".//td[text() = '%s']", value))));
    }

    default long howManyOptionsChecked(){
        return getCheckboxes().stream().filter(checkbox -> checkbox).count();
    }

    default long howManyOptions(){
        return getCheckboxes().stream().count();
    }
}
