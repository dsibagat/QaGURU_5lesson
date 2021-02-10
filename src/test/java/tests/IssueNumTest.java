package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueNumTest {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    @Description("Проверка названия Issue в репозитории через Web-интерфейс чистый тест")
    @Test
    void issueNumCheck() {
        open("https://github.com/");
        $("[name=q]").val(REPOSITORY).pressEnter();
        $("ul.repo-list li").$("a").click();
        $(byText("Issues")).click();
        $(byText("#" + ISSUE_NUMBER + " opened")).shouldBe(visible);
    }
}
