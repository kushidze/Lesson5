package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.page.components.CalendarComponents;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FormFillTestWithPageObjects extends TestBase {
    private Faker faker = new Faker();
    private final String
            email = faker.internet().emailAddress(),
            currentAddress = faker.address().streetAddress(),
            genderMale = "Male",
            genderFemale = "Female",
            userNumber = faker.number().digits(10),
            subject = "Chemistry, Arts",
            uploadFile = "testFile1.jpg",
            hobbies1 = "Sports",
            hobbies2 = "Music",
            state = "Uttar Pradesh",
            city = "Agra";

    @Test
    void practiceForm() {
        //Open "PracticeForm"
        registrationsPage.openPage()
                .typeFirstName("Amirkhan")
                .typeLastName("Omarkhanov");
        $("#userEmail").val(email);
        //Gender check
        $(byText(genderFemale)).click();
        $(byText(genderMale)).click();
        //Mob.number check
        $("#userNumber").val(userNumber);
        //Date of birth check
        registrationsPage.calendar.setDate("30", "July", "1998");
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
        $("#currentAddress").scrollTo().val(currentAddress);
        //Select state
        $("#state").scrollTo();
        $("#state").click();
        $(byText(state)).click();
        //Select city
        $("#city").click();
        $(byText(city)).scrollTo().click();
        //Submit form
        $("#submit").click();
        //Submit validation
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationsPage
                .checkResults("Student Name", "Amirkhan Omarkhanov");
        sleep(5000);
    }
}




