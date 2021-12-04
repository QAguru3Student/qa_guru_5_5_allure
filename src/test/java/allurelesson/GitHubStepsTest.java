package allurelesson;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubStepsTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "allure-framework/allure2";
    private final static String ISSUE_NAME = "Can not generate Allure Reports on Jenkins";

    @Test
    public void searchForIssue() {
        step("Открыть главную страницу", () -> {
            open(BASE_URL);
        });

        step("Перейти в репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            $(By.linkText(REPOSITORY)).click();
        });

        step("Перейти в Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверить название Issue", () -> {
            $(withText(ISSUE_NAME)).should(Condition.visible);
        });
    }
}
