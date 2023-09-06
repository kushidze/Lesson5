package guru.qa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class FormFillTestWithFaker extends TestBase {
    private Faker faker = new Faker();
    private final String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            currentAddress = faker.address().streetAddress(),
            genderMale = "Male",
            genderFemale = "Female",
            userNumber = faker.number().digits(10),
            dateofBirth = "07 September,1992",
            subject = "Chemistry, Arts",
            uploadFile = "testFile1.jpg",
            hobbies1 = "Sports",
            hobbies2 = "Music",
            state = "Uttar Pradesh",
            city = "Agra";

    @Test
    void practiceForm() {
        //Open "PracticeForm"
        open("https://demoqa.com/automation-practice-form");
        //Form checking
        $(byText("Student Registration Form")).shouldBe(visible);
        //Test user data check
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        //Gender check
        $(byText(genderFemale)).click();
        $(byText(genderMale)).click();
        //Mob.number check
        $("#userNumber").val(userNumber);
        //Date of birth check
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1992");
        $$(".react-datepicker__day").find(text("7")).click();
        //Subject check
        $("#subjectsInput").val("ch");
        $(byText("Chemistry")).click();
        $("#subjectsInput").val("ar");
        $(byText("Arts")).click();
        //Hobbies check
        $(byText(hobbies1)).click();
        $(byText(hobbies2)).click();
        //File upload check
        $("#uploadPicture").uploadFromClasspath(uploadFile);
        //Current address check
        $("#currentAddress").val(currentAddress).sendKeys(Keys.TAB);
        //Select state
        $("#close-fixedban").click();
        $("#state").scrollTo();
        $("#state").click();
        $(byText(state)).click();
        //Select city
        $("#city").click();
        $(byText(city)).click();
        //Submit form
        $("#submit").click();
        //Submit validation
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //FormFill Check
        $$(byXpath("//td")).shouldHave(itemWithText(firstName + " " + lastName), itemWithText(email), itemWithText(genderMale), itemWithText(userNumber), itemWithText(dateofBirth), itemWithText(subject), itemWithText(hobbies1 + ", " + hobbies2), itemWithText(uploadFile), itemWithText(currentAddress), itemWithText(state + " " + city));
    }

}




