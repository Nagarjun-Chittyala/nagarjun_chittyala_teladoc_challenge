Feature: Web Table automation

  @WebTable
  Scenario: Add a user and validate the user has been added to the table
    Given User clicks on the Add User button
    When User enters the user details on Add User dialog
      | FirstName | LastName  | UserName           | Password   | Customer    | Role  | EMail                             | CellPhone  |
      | Nagarjun  | Chittyala | Nagarjun_Chittyala | N@g@rjun$1 | Company AAA | Admin | jobs.nagarjun.chittyala@gmail.com | 9176474711 |
    And User clicks on the Save button
    Then Validate new user entry should be added to the web table
      | FirstName | LastName  | UserName           | Password   | Customer    | Role  | EMail                             | CellPhone  |
      | Nagarjun  | Chittyala | Nagarjun_Chittyala | N@g@rjun$1 | Company AAA | Admin | jobs.nagarjun.chittyala@gmail.com | 9176474711 |

  Scenario: Delete the user "novak" from the table and validate the user has been deleted.
    Given User clicks on delete icon of "novak" user entry
    When User clicks on the OK button
    Then Validates the "novak" user entry is removed from table