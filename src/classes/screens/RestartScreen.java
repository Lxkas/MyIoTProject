package classes.screens;

import classes.BoxPrinter;
import classes.ConsoleUtils;
import classes.LCD;
import utils.AnimationHelper;

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

            AnimationHelper animationHelper = new AnimationHelper();

            String[] steps = {
                    "Restarting...",
                    "Restarting",
                    "Restarting.",
                    "Restarting..",
                    "Restarting...",
            };

            for (int i = 0; i < 20; i++) {
                try {
                    animationHelper.animate(steps, i);
                    Thread.sleep(200);
                } catch (Exception e) {

                }
            }

            ConsoleUtils.showCursor();

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Screens.MainMenu.switchTo();
                        }
                    },
                    200
            );
        } else {
            // TODO: Return to previous screen
            Screens.MainMenu.switchTo();
        }
    }
}
