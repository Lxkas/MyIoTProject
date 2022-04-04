package classes.screens;

import static java.lang.System.exit;

public class MainMenuScreen extends ScreenBase {
    public MainMenuScreen(String[] screenStrings) {
        super(screenStrings);
    }

    @Override
    void action() {
        String userInput = askForInput("Please select a function: ");

        switch (userInput) {
            case "1":
                Screens.LoginPage.switchTo();
                return;
            case "2":
                Screens.RestartPage.switchTo();
                return;
            case "3":
                Screens.ShutdownPage.switchTo();
                return;
            default:
                System.out.println("Invalid option, please enter another number.");
                action();
                return;
        }
    }
}
