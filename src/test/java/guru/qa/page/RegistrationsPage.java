package guru.qa.page;

import com.codeborne.selenide.SelenideElement;
import guru.qa.page.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {

    private final String Form_Title = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstnameInput = $("#firstName"),
            lastnameInput = $("#lastName"),
            resultsTable = $(".table-responsive");

    public CalendarComponents calendar = new CalendarComponents();

    public RegistrationsPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(Form_Title));
        return this;
    }

    public RegistrationsPage typeFirstName(String value) {
        firstnameInput.val(value);
        return this;
    }

    public RegistrationsPage typeLastName(String value) {
        lastnameInput.val(value);
        return this;
    }

    public RegistrationsPage checkResults(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

}
