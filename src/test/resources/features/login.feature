 @smoke
 Feature: Test
 @smoke
 Scenario Outline: Login to the application with multiple users.
    
        Given get data from datasheet with "<row_number>" and "<sheetName>"
        Then login to the application
    
        Examples: 
          | row_number | sheetName   |
          |       1 | Login       |
          |       2 | Login       |
          |       3 | Login       |