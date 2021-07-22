package com.dictality.theinternet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
    }

    @BeforeEach
    public void setUp() {
        open("https://the-internet.herokuapp.com");
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
