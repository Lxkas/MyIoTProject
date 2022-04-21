package classes.screens;

import classes.BoxPrinter;
import classes.LCD;
import utils.ConsoleColors;

public class RestartScreen extends ScreenBase {
    public RestartScreen(String[] screenStrings) {
        super(screenStrings);
    }

    @Override
    void action() {
        if (askForConfirmation("restart")) {
            LCD.clearScreen();
            BoxPrinter.printBox(new String[]{
                    "Restarting...",
                    "{[div]}",
                    "",
                    "Please wait while the system is",
                    "preparing for a restart."
            });

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Screens.MainMenu.switchTo();
                        }
                    },
                    2000
            );
        } else {
            // TODO: Return to previous screen
            Screens.MainMenu.switchTo();
        }
    }
}
