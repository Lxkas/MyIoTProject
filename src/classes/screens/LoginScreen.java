package classes.screens;

import classes.LCD;
import utils.UserHandler;

public class LoginScreen extends ScreenBase {
    public LoginScreen(String[] screenStrings) {
        super(screenStrings);
    }

    @Override
    void action() {
        String username = askForInput("Username: ");
        String password = askForInput("Password: ");

        if (UserHandler.login(username, password)) {
            LCD.clearScreen();
            System.out.println(String.format("Welcome, %s", username));
            Screens.SystemMenu.printScreenString();
            Screens.SystemMenu.performAction();
        } else {
            LCD.clearScreen();
            System.out.println("Invalid credentials.");
            this.printScreenString();
            action();
        }
    }
}
