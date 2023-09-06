package guru.qa.page;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import guru.qa.page.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationsPage {
    private Faker faker = new Faker();
    private final String Form_Title = "Student Registration Form",
            email = String.valueOf(faker.internet().emailAddress()),
            firstname = String.valueOf(faker.harryPotter().character()),
            lastname = String.valueOf(faker.gameOfThrones().character()),
            adress = String.valueOf(faker.address().streetAddress()),
            userMobNumber = String.valueOf(faker.number().digits(10));


    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstnameInput = $("#firstName"),
            lastnameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            adressInput = $("#currentAddress"),
            mobNumberInput = $("#userNumber"),
            resultsTable = $(".table-responsive");


    public CalendarComponents calendar = new CalendarComponents();

    public RegistrationsPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(Form_Title));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationsPage typeFirstName() {
        firstnameInput.val(firstname);
        return this;
    }

    public RegistrationsPage typeLastName() {
        lastnameInput.val(lastname);
        return this;
    }
    public RegistrationsPage typeEmail() {
        emailInput.val(email);
        return this;
    }
    public RegistrationsPage typeAdress() {
        adressInput.val(adress);
        return this;
    }
    public RegistrationsPage typeMobNumber() {
        mobNumberInput.val(userMobNumber);
        return this;
    }

    public RegistrationsPage checkResults(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

}
