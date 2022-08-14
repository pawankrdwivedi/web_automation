package com.web.automation.test.cucumbercontext;

public class TestContext {
        private ScenarioContext scenarioContext;

        public TestContext() {
        scenarioContext = new ScenarioContext();
        }

        public ScenarioContext getScenarioContext() {
        return scenarioContext;
        }
}
