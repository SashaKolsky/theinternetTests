package com.dictality.theinternet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith({TextReportExtension.class})
public class DragAndDrop {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
    }

    @Test
    void dragAndDropValidation() {

        open("/drag_and_drop");

        SelenideElement columnAElement = $("#column-a");
        SelenideElement columnBElement = $("#column-b");

        String preDropAValue = columnAElement.$("header").text();
        String preDropBValue = columnBElement.$("header").text();

        columnAElement.dragAndDropTo(columnBElement);

        columnAElement.$("header").shouldHave(text(preDropBValue));
        columnBElement.$("header").shouldHave(text(preDropAValue));
    }
}
