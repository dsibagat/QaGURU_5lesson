package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GitSteps;

public class IssueNumTestAnnotationSteps {
    public GitSteps steps = new GitSteps();

    String REPOSITORY = "eroshenkoam/allure-example";
    int ISSUE_NUMBER = 68;

    @Description("Проверка названия Issue в репозитории через Web-интерфейс.")
    @Test
    @DisplayName("Наш любимый тест с аннотациями")
    @Feature("Issues")
    @Story("User should see issues in existing repository")
    @Link(url = "https://github.com", name = "Тестинг")
    @Owner("dsibagat")
    @Severity(SeverityLevel.CRITICAL)
    public void issueNumCheckAnnotations() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage()
                .searchForRepository(REPOSITORY)
                .goToRepository()
                .goToIssues()
                .shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
