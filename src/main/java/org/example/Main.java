package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();  // no need for setProperty or jars or path

        System.out.println("Hello world!");
        WebDriver driver = new ChromeDriver();  // now we can use the webdriver without importing jars to this project
        driver.get("http://www.google.com");
    }
}