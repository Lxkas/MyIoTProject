package classes.screens;

import classes.BoxPrinter;
import classes.LCD;

import static java.lang.System.exit;

public class ShutdownScreen extends ScreenBase {
    public ShutdownScreen(String[] screenStrings) {
        super(screenStrings);
    }

    @Override
    void action() {
        if (askForConfirmation("shutdown")) {
            LCD.clearScreen();
            BoxPrinter.printBox(new String[]{
                    "Shutting Down...",
                    "{[div]}",
                    "",
                    "Please wait while the system is",
                    "preparing for a shutdown."
            });

            exit(0);
        } else {
            // TODO: Return to previous screen
            Screens.MainMenu.switchTo();
        }
        ;
    }
}
