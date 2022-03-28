import classes.LCD;

public class MyIoTProject {
    public static void main(String[] args) {
        LCD.showMainMenu();
        LCD.showLoginMenu();
        LCD.showSystemMenu();
        LCD.changeACSetP();
        LCD.confirmRestart();
        LCD.confirmShutdown();
        LCD.showShutdown();
    }
}
