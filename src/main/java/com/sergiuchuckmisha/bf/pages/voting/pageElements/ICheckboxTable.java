package com.sergiuchuckmisha.bf.pages.voting.pageElements;

import com.sergiuchuckmisha.bf.selenium.utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.findElements;
import static com.sergiuchuckmisha.bf.selenium.utils.DriverHelper.wrapClassContainsForPath;

/**
 * idea of the class is to reflect tables with checkboxes (in the middle of the page like on page https://exonum.com/demo/voting/#/monitor)
 */
public interface ICheckboxTable {

    default List<Boolean> getCheckboxes() {
        return DriverHelper

                .findElements(By.cssSelector("table.app-list td>div.checker"))
                .stream()
                .map(webElement -> "checker active".equals(webElement.getAttribute("class")))   //.isSelected() does not work
                .collect(Collectors.toList());
    }

    default List<String> getCheckBoxTableValues() {
        return
                findElements(By.cssSelector("table.app-list td.ng-binding"))
                        .stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
    }

    default void selectCheckBoxTableValue(String value) {
        if (null == value || value.isEmpty()) {
            throw new IllegalArgumentException("empty value provided");
        }
        DriverHelper.click(
                By.xpath(String.format(".//table[%s]//td[text() = '%s']",
                        wrapClassContainsForPath("app-list"),
                        value)));
    }

    default long howManyOptionsChecked() {
        return getCheckboxes().stream().filter(checkbox -> checkbox).count();
    }

    default long howManyOptions() {
        return getCheckboxes().stream().count();
    }
}
