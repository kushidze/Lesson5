package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.page.RegistrationsPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationsPage  registrationsPage = new RegistrationsPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
}
