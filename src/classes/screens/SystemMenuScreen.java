package classes.screens;

import static java.lang.Integer.parseInt;

public class SystemMenuScreen extends ScreenBase {
    private int currentAcTemperature = 0;

    private boolean cameraEnabled = false;
    private boolean antiTheftEnabled = false;

    public SystemMenuScreen(String[] screenStrings) {
        super(screenStrings);
    }

    private int askForTemperature() {
        String inputtedString = askForInput("Enter temperature: ");

        try {
            return parseInt(inputtedString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, please try again.");
            return askForTemperature();
        }
    }

    @Override
    String[] getScreenStrings() {
        // I could make it only re-generate the strings when properties are changed but.. why bother? ¯\_(ツ)_/¯
        return new String[]{
                "Select a Function (1-4)",
                "{[div]}",
                "",
                String.format("1. Change AC Temperature set point (%s)", currentAcTemperature),
                String.format("2. %s IP Camera", cameraEnabled ? "Disable" : "Enable"),
                String.format("3. Turn anti-theft system %s", antiTheftEnabled ? "off" : "on"),
                "4. Exit"
        };
    }

    @Override
    void action() {
        String userInput = askForInput("Please select a function: ");

        switch (userInput) {
            case "1":
                currentAcTemperature = askForTemperature();
                System.out.println(String.format("Temperature has been set to %s", currentAcTemperature));
                break;
            case "2":
                cameraEnabled = !cameraEnabled;
                System.out.println(String.format("Camera is now %s", cameraEnabled ? "on" : "off"));
                break;
            case "3":
                antiTheftEnabled = !antiTheftEnabled;
                System.out.println(String.format("Anti-theft system is now %s", antiTheftEnabled ? "on" : "off"));
                break;
            case "4":
                Screens.MainMenu.switchTo();
                return;
            default:
                System.out.println("Invalid option, please enter another number.");
                action();
                return;
        }

        switchTo();
    }
}
