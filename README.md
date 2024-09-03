#CrytoExchangeSystem

Cryptocurrencies are a modern and popular option for trading that is why this efficient and user-friendly program has been developed to allow the buying and selling of both bitcoin and ethereum, using fiat money.

**UML Diagram ----->**  ![Bootcamp Project](https://github.com/user-attachments/assets/b553a0ea-6682-4b87-a5e3-64843486ab2d)


Explaining the design pattern, we use a **MVC (Model-View-Controller)** Architecture pattern, where each of these are separated into a package, and each element of them serves together to make the program work.

**Model:** contains only system data, it does not contain any logic describing how to present the data to the user.

**View:** Presents the model data to the user.

**Controller:** Exists between the view and the model. It listens for events triggered by the view and executes the appropriate procedure for these events.


**An extra point we have added files to simulate DataBase**

From **the main** has been implemented the respective mechanisms for registration and login, with their respective verifications in case the person does not enter what is needed, for example: if you ask for an integer and the person enters letters, the program will ask you to re-enter the option until you type what is required.
Additionally, when executing the exit button, the application will die.

When **registering**, the individual's information will be stored in a “database”, so that when **logging in**, the database will be checked to see if there is an account registered with the credentials the user provided when attempting to log in.

Once logged in, we will be able to **deposit real money**, where a mechanism was created where the user is asked to deposit an amount, which will be displayed on the screen after doing so and will be added to our wallet showing a successful message. 

In **checkWallet**, it simply displays the amounts of crypto and real money, obtained through trading, direct purchase and deposits.

In **Direct Exchange**, a mechanism was made where you can buy directly without the need of a third person, funds are removed from the real money and the obtained cryptos are added.

In the **purchase section**, a mechanism was made where with the help of external files simulating a database a match is generated, where the system will freeze for 5 seconds while looking for a suitable seller.

In the **sale section**, by means of the same mechanism used with the purchases, the system is frozen for 5 seconds while looking for a suitable buyer.

In the **history section**, when successful purchases and sales (with third parties) are executed, they are saved in a list, where with the help of this, the content of the transaction will be shown with the amount and total price of the exchange.

As a last option we will be able to **log out** where the system will end.

Thank you very much.



