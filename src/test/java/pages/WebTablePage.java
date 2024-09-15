package pages;

import constants.SelectStrategy;
import framework.Page;

public class WebTablePage extends Page {

    private static final String pageName = "Web Table";

    public void clickAddUserButton() {
        actions.click(pageName, "add_user_button");
    }

    public void enterUserDetails(String firstName, String lastName, String userName, String password,
                                 String customer, String role, String email, String cellPhone) {
        actions.enterText(pageName, "first_name_text_field", firstName);
        actions.enterText(pageName, "last_name_text_field", lastName);
        actions.enterText(pageName, "user_name_text_field", userName);
        actions.enterText(pageName, "password_text_field", password);
        actions.click(pageName, "customer_name_radio", customer);
        actions.select(pageName, "role_dropdown", role, SelectStrategy.visual_text);
        actions.enterText(pageName, "email_text_field", email);
        actions.enterText(pageName, "cell_phone_text_field", cellPhone);
    }

    public void clickSaveButton() {
        actions.click(pageName, "save_button");
    }

    public void validateUserEntry(String firstName, String lastName, String userName, String customer,
                                  String role, String email, String cellPhone) {
        assertionHelper.assertEquals(firstName, actions.getText(pageName, "first_name_entry_in_table", userName));
        assertionHelper.assertEquals(lastName, actions.getText(pageName, "last_name_entry_in_table", userName));
        assertionHelper.assertEquals(userName, actions.getText(pageName, "user_name_entry_in_table", userName));
        assertionHelper.assertEquals(role, actions.getText(pageName, "role_entry_in_table", userName));
        assertionHelper.assertEquals(email, actions.getText(pageName, "email_entry_in_table", userName));
        assertionHelper.assertEquals(cellPhone, actions.getText(pageName, "cell_phone_entry_in_table", userName));
        assertionHelper.assertEquals(customer, actions.getText(pageName, "customer_entry_in_table", userName));
    }

    public void clickDeleteUser(String userName){
        actions.click(pageName, "delete_user_button", userName);
    }

    public void clickOkButton(){
        actions.click(pageName, "ok_button");
    }

    public void checkAbsenceOfUser(String userName){
        assertionHelper.assertFalse(actions.isPresent(pageName, "user_name_entry_in_table", userName),
                "%s user is still available in the table".formatted(userName));
    }
}
