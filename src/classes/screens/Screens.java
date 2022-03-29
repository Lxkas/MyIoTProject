package classes.screens;

public class Screens {
    public static MainMenuScreen MainMenu = new MainMenuScreen(new String[]{
            "Welcome to the Stamford LCD Library Demo",
            "Please select a function (1-3)",
            "{[div]}",
            "",
            "1. Login",
            "2. Restart",
            "3. Shutdown",
    });

    public static SystemMenuScreen SystemMenu = new SystemMenuScreen(new String[]{});

    public static LoginScreen LoginPage = new LoginScreen(new String[]{
            "Login Menu. Press F1 for more information",
            "{[div]}",
            "",
            "Enter Credentials:"
    });

    public static ShutdownScreen ShutdownPage = new ShutdownScreen(new String[]{
            "Shutdown Confirmation",
            "{[div]}",
            "",
            "Are you sure that you want to shutdown",
            "the system? (Y/N)"
    });

    public static RestartScreen RestartPage = new RestartScreen(new String[]{
            "Restart Confirmation",
            "{[div]}",
            "",
            "Are you sure that you want to restart",
            "the system? (Y/N)"
    });
}
