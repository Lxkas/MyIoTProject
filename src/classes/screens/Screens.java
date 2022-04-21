package classes.screens;

public class Screens {
    public static final MainMenuScreen MainMenu = new MainMenuScreen(new String[] {
            "{[ac]}Welcome to the Stamford LCD Library Demo",
            "{[ac]}Please select a function (1-3)",
            "{[div]}",
            "",
            "1. Login",
            "2. Restart",
            "3. Shutdown",
    });

    public static final SystemMenuScreen SystemMenu = new SystemMenuScreen(new String[]{});

    public static final LoginScreen LoginPage = new LoginScreen(new String[]{
            "Login Menu. Press F1 for more information",
            "{[div]}",
            "",
            "Enter Credentials:"
    });

    public static final ShutdownScreen ShutdownPage = new ShutdownScreen(new String[]{
            "Shutdown Confirmation",
            "{[div]}",
            "",
            "Are you sure that you want to shutdown",
            "the system? (Y/N)"
    });

    public static final RestartScreen RestartPage = new RestartScreen(new String[]{
            "Restart Confirmation",
            "{[div]}",
            "",
            "Are you sure that you want to restart",
            "the system? (Y/N)"
    });
}
