package com.TestNg.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonUtils {
	private WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    private By userName = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("login");
}
