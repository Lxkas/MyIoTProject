import classes.LCD;
import classes.screens.Screens;
import utils.ConfigHandler;

public class MyIoTProject {
    public static void main(String[] args) {
        ConfigHandler.loadConfig("src/config.properties");

        LCD.showMainMenu();
//        LCD.showLoginMenu();
//        LCD.showSystemMenu();
//        LCD.changeACSetP();
//        LCD.confirmRestart();
//        LCD.confirmShutdown();
//        LCD.showShutdown();

        Screens.MainMenu.performAction();
    }
}
