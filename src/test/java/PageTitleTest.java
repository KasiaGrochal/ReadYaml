import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PageTitleTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(PageTitleTest.class);

    @Test
    @DisplayName("Validate Page title")
    @Tag("pageTitle")
    @Tag("regression")
    public void validatePageTitle() {

        String displayedTitle = driver.getTitle();
        String expectedTitle = System.getProperty("title");
        assertThat(displayedTitle, equalTo(expectedTitle));
        logger.info("Displayed name: '{}' is the same as expected: '{}'. Test completed successfully.", displayedTitle, expectedTitle);


    }

}
