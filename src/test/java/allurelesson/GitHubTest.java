package allurelesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubTest {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "allure-framework/allure2";
    private final static String ISSUE_NAME = "Allure Report Customization";

    @Test
    public void searchForIssue() {
        //Открыть страницу
        open(BASE_URL);

        //Перейти в репозиторий
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();

        //Перейти в Issues
        $(withText("Issues")).click();

        //Проверить название Issue
        $(withText(ISSUE_NAME)).should(Condition.exist);
    }
}
