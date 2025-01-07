package org.example.pages;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private final String usernamePath = "//input[@id='user-name']";
    private final String passwordPath = "//input[@id='password']";
    private final String loginButtonPath = "//input[@id='login-button']";

    @Override
    public String getEndpoint() {
        return "/";
    }

    public HomePage login() {
        $x(usernamePath).setValue("standard_user");
        $x(passwordPath).setValue("secret_sauce");
        $x(loginButtonPath).click();
        return new HomePage();
    }
}
