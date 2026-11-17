# SauceDemo Automation (Selenium + Java + TestNG, POM)

Prerequisites: JDK 17+, Maven 3.9+, Chrome (Firefox/Edge optional). No manual driver download needed.

    mvn clean test                                  # run everything
    mvn clean test -Dbrowser=firefox                # other browser
    mvn clean test -Dheadless=true                  # headless
    mvn clean test -Dapp.username=problem_user      # override a config value

Results: `target/surefire-reports/` (HTML reports). Failure screenshots: `target/screenshots/`.
Test plan and manual test cases: `docs/TEST_PLAN.md`.

Design: pages in `pages/` hold locators + actions and return the next page object; assertions live only in `tests/`;
`BasePage` wraps explicit waits; `DriverFactory` is ThreadLocal (parallel-ready); config in `config.properties`.