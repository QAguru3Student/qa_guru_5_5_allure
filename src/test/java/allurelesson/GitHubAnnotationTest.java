package allurelesson;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubAnnotationTest {
    private final static String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "allure-framework/allure2";
    private final static String ISSUE_NAME = "Can not generate Allure Reports on Jenkins";


    @Test
    @DisplayName("Наш любимый тест с аннотацией")
    @Feature("Issues")
    @Story("User should see issues in existing repository")
    public void searchForIssue(){
        final BaseSteps steps = new BaseSteps();

        steps.openMainPage(BASE_URL);
        steps.goToRepository(REPOSITORY);
        steps.goToIssue();
        steps.checkTitleIssue(ISSUE_NAME);
    }

    public static class  BaseSteps{
        @Step("Открыть главную страницу")
        public void openMainPage(final String name) {
            open(BASE_URL);
        }

        @Step("Перейти в репозиторий {name}")
        public void goToRepository(final String name) {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            $(By.linkText(REPOSITORY)).click();
        }

        @Step("Перейти в Issues")
        public void goToIssue() {
            $("#issues-tab").click();
        }

        @Step("Проверить название Issue {name}")
        public void checkTitleIssue(final String name) {
            $(withText(ISSUE_NAME)).should(Condition.visible);
        }
    }
}
