package com.web.automation.test.stepdef;

import com.web.automation.test.cucumbercontext.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ToDoMVCSteps extends BaseStep {

    public ToDoMVCSteps(TestContext testContext) {
        super(testContext);
    }


    /**
     * HOME PAGE
     */
    @Given("^Open the given URL in a Browser.$")
    public void openTheGivenURLInABrowser() {
        toDoMCV.openURL();
    }

    @When("^add the Item: \"([^\"]*)\" in To Do list.$")
    public void addItemInToDoList(String text) {
        toDoMCV.addItemInToDoList(text);
    }


    @When("^add the TODO \"([^\"]*)\" to the list.$")
    public void addTheTODOItemToTheList(String ItemName) {
        toDoMCV.addItemInToDoList(ItemName);
    }

    @Then("mark the added \"([^\"]*)\" complete.$")
    public void markTheAddedItemComplete(String ItemName) {
        toDoMCV.markActiveItemAsCompleted(ItemName);
    }

    @Then("^mark the completed \"([^\"]*)\" as active.$")
    public void markTheCompletedAsActive(String ItemName) {
        toDoMCV.markCompletedItemAsActive(ItemName);
    }

    @Then("^Delete \"([^\"]*)\" from to do list.$")
    public void deleteFromToDoList(String Item) {
        toDoMCV.deleteItemFromToDoList(Item);
    }

    @When("^add multiple items to the TODO \"([^\"]*)\" to the list.$")
    public void addMultipleItemsToTheTODOToTheList(String Item) {
        String[]  lstItems = Item.split("<>");
        for(String item : lstItems){
            toDoMCV.addItemInToDoList(item.trim());
        }
    }

    @Then("^Count added items in to do list.$")
    public void countAddedItemsInToDoList() {
        toDoMCV.verifyAllTODOListCount(6);
    }

    @Then("^Count Completed and Active in to do list.$")
    public void countCompletedAndActiveInToDoList() {
        toDoMCV.applyCompletedFilter();
        toDoMCV.verifyCompletedCount(1);
        toDoMCV.applyActiveFilter();
        toDoMCV.verifyActiveCount(5);
        toDoMCV.applyAllFilter();
    }

}
