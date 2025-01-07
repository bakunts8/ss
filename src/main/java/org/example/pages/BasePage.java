package org.example.pages;

import com.codeborne.selenide.Selenide;

public class BasePage {

    public String getEndpoint() {
        return "";
    }

    public <P extends BasePage> P open() {
        Selenide.open(this.getEndpoint());
        return (P) this;
    }
}
