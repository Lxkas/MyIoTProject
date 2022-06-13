import classes.LCD;
import classes.screens.Screens;
import utils.ConfigHandler;

public class MyIoTProject {
    public static void main(String[] args) {
        ConfigHandler.loadConfig("src/config.properties");

        LCD.showMainMenu();
        Screens.MainMenu.performAction();
    }
}
