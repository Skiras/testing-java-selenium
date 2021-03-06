package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * лекция: 4. Поиск элементов
 * задание: Задание 8. Сделайте сценарий, проверяющий наличие стикеров у товаров
 * используем {@link LiteCartAdminLoginTest} в качестве предэтапа
 */
public class Task8 extends BaseHelper {

    @Test
    public void stickerTest() {
        driver.get("http://localhost:8000/litecart/en/");
        List<WebElement> goods = driver.findElements(
                By.xpath("//*[@class='Product column shadow hover-light']"));
        // для каждого элемента-товара проверяем наличие одного! стикера
        for(WebElement element : goods) {
            Assert.assertTrue(element.findElements(
                    By.xpath(".//div[contains(@class, 'sticker')]")).size() == 1);
        }
    }
}
