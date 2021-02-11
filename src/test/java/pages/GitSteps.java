package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitSteps {
    @Step("Открываем главную страницу")
    public GitSteps openMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Ищем репозиторий {name}")
    public GitSteps searchForRepository(String value) {
        $("[name=q]").val(value).pressEnter();
        return this;
    }

    @Step("Переходим в репозиторий")
    public GitSteps goToRepository() {
        $("ul.repo-list li").$("a").click();
        return this;
    }

    @Step("Переходим в раздел Issues")
    public GitSteps goToIssues() {
        $(byText("Issues")).click();
        return this;
    }

    @Step("Проверяем наличие Issue с номером {number}")
    public GitSteps shouldSeeIssueWithNumber(int number) {
        $(byText("#" + number + " opened")).shouldBe(visible);
        return this;
    }
}
