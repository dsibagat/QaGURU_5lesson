package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IssueNumTestLambdaSteps {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    @Description("Проверка названия Issue в репозитории через Web-интерфейс.")
    @Test
    @DisplayName("Наш любимый тест с лямбда аннотациями")
    @Feature("Issues")
    @Story("User should see issues in existing repository")
    @Link(url = "https://github.com", name = "Тестинг")
    @Owner("dsibagat")
    @Severity(SeverityLevel.CRITICAL)
    void issueNumCheckLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Allure.feature("Issues");
        Allure.story("Моя любимая история");
        Allure.parameter("Repository", REPOSITORY);

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
            Allure.link("Тестинг", "https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, (step) -> {
            step.parameter("value", REPOSITORY);

            $("[name=q]").val(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, (step) -> {
            $("ul.repo-list li").$("a").click();
        });
        step("Переходим в раздел Issues", () -> {
            $(byText("Issues")).click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE_NUMBER, (step) -> {
            step.parameter("number", ISSUE_NUMBER);

            $(byText("#" + ISSUE_NUMBER + " opened")).shouldBe(visible);
        });
    }
}
