package pageObjects.voting.pageElements.checkboxTableElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.utils.DriverHelper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * idea of the class is to reflect tables with checkboxes (in the middle of the page like on page https://exonum.com/demo/voting/#/monitor)
 * */
public interface iCheckboxTable {

    default List<Boolean> getCheckboxes(){
        return DriverHelper
                .findElements(By.xpath("//table[@class = 'app-list']//td/div[contains(@class, 'checker')]"))
                .stream()
                .map(webElement -> "checker active".equals(webElement.getAttribute("class")))
                .collect(Collectors.toList());
    }

    default List<String> getCheckBoxTableValues(){
        return DriverHelper
                .findElements(By.xpath("//table[@class = 'app-list']//td[@class = 'ng-binding']"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
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
