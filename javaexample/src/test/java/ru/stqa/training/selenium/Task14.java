/**
 * Created by Anton on 22 Окт., 2017.
 */
package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * лекция: 8. Окна и диалоги
 * задание: Задание 14. Проверьте, что ссылки открываются в новом окне
 */
public class Task14 extends LiteCartLoginTest {

  @Test
  public void linkTest() {
    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    clickOnElement("//*[text()=' Add New Country']");
    List<WebElement> links = driver.findElements(By.xpath("//*[@class='fa fa-external-link']/ancestor::a"));
    for (WebElement element : links) {
      backAndForth(element);
    }
  }

  private void backAndForth(WebElement element) {
    String originalWindow = driver.getWindowHandle();
    Set<String> existingWindows = driver.getWindowHandles();
    element.click();
    String newWindow = wait.until(anyWindowOtherThan(existingWindows));
    driver.switchTo().window(newWindow);
    driver.close();
    driver.switchTo().window(originalWindow);
  }
}
