package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebTablePage;

import java.util.Map;

public class WebTableStepDefinition {
    private final WebTablePage webTablePage = new WebTablePage();

    @Given("User clicks on the Add User button")
    public void userClicksOnTheAddUserButton() throws InterruptedException {
//        Thread.sleep(10000);
        webTablePage.clickAddUserButton();
    }

    @When("User enters the user details on Add User dialog")
    public void userEntersTheUserDetailsOnAddUserDialog(DataTable dataTable) {
        Map<String, String> table = dataTable.asMaps().get(0);
        webTablePage.enterUserDetails(table.get("FirstName"), table.get("LastName"),
                table.get("UserName"), table.get("Password"), table.get("Customer"),
                table.get("Role"), table.get("EMail"), table.get("CellPhone"));
    }

    @And("User clicks on the Save button")
    public void userClicksOnTheSaveButton() {
        webTablePage.clickSaveButton();
    }

    @Then("Validate new user entry should be added to the web table")
    public void newUserEntryShouldBeAddedToTheWebTable(DataTable dataTable) {
        Map<String, String> table = dataTable.asMaps().get(0);
        webTablePage.validateUserEntry(table.get("FirstName"), table.get("LastName"), table.get("UserName"),
                table.get("Customer"), table.get("Role"), table.get("EMail"), table.get("CellPhone"));
    }

    @Given("User clicks on delete icon of {string} user entry")
    public void user_clicks_delete_icon(String userName) {
        webTablePage.clickDeleteUser(userName);
    }

    @When("User clicks on the OK button")
    public void user_clicks_on_ok_button() {
        webTablePage.clickOkButton();
    }

    @Then("Validates the {string} user entry is removed from table")
    public void user_checks_absence_of_user_entry(String userName) throws InterruptedException {
        webTablePage.checkAbsenceOfUser(userName);
//        Thread.sleep(10000);
    }
}
