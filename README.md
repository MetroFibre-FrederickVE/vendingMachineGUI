# vendingMachineGUI
Example of a Java vending machine applet with a GUI created using the Swing toolkit.

### Welcome Message
On launch, the user is greated via dialog popup : 

![GitHub Logo](/ReadMe_Images/welcome.png)

### Main Window
The main GUI of the app presents the user with multiple options, consisting of items to select from (Buttons representing the items in the
machine), a text field for their monetary input, and three control buttons at the bottom of the window (Checkout button, Reset button and 
Close button) : 

![GitHub Logo](/ReadMe_Images/main-GUI.png)

### Selections made
As the user selects items by clicking on the items they want, the items and their respective prices :

![GitHub Logo](/ReadMe_Images/selected.png)

### Checkout & Payment
After the user enters their money and selected their items, they can click on the checkout button to check wether they entered the correct 
amount of money. The checkout button will be disabled and a "Pay" button will be displayed. When the pay button is clicked, the user will 
thanked for their purchase : 

![GitHub Logo](/ReadMe_Images/thank-you.png)

### Warning and Error messages
If the checkout button is pressed before the user has entered any money, an warning message will be displayed : 

![GitHub Logo](/ReadMe_Images/no-money.png)

Or, if the money entered wasn't enough to cover the total amount of the items selected, a error message will be displayed : 

![GitHub Logo](/ReadMe_Images/error.png)

## Future plans / WIP
The next phase would be to add stock level management. This will track the amount of stock available for each individual item for sale.
This can pull from the CSV and read / write the new amounts to the data file.
