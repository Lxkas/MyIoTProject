package classes;

import classes.screens.Screens;

public class LCD {
    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();

        System.out.println("\n".repeat(25));

//        for (int i = 0; i < 25; i++) {
//            System.out.println();
//        }
    }

    public static void showMainMenu() {
        clearScreen();

        Screens.MainMenu.printScreenString();

//        BoxPrinter.printBox(new String[]{
//                "Welcome to the Stamford LCD Library Demo",
//                "Please select a function (1-3)",
//                "{[div]}",
//                "",
//                "1. Login",
//                "2. Restart",
//                "3. Shutdown",
//        });

//        // 80 characters wide.
//        System.out.println(" ------------------------------------------ ");
//        System.out.println("| Welcome to Stamford LCD Library Demo     |");
//        System.out.println("|                                          |");
//        System.out.println("| Select a Function (1-3)                  |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("|                                          |");
//        System.out.println("| 1. Login                                 |");
//        System.out.println("| 2. Restart                               |");
//        System.out.println("| 3. Shutdown                              |");
//        System.out.println(" ------------------------------------------ ");
    }

    public static void showLoginMenu() {
        BoxPrinter.printBox(new String[]{
                "Login Menu. Press F1 for more information",
                "{[div]}",
                "",
                "Enter Username:"
        });

//        // 80 characters wide.
//        System.out.println(" -------------------------------------------- ");
//        System.out.println("| Login Menu. Press F1 for more information. |");
//        System.out.println("|------------------------------------------  |");
//        System.out.println("|                                            |");
//        System.out.println("| Enter Username:                            |");
//        System.out.println(" -------------------------------------------- ");
    }


    public static void showSystemMenu() {
        BoxPrinter.printBox(new String[]{
                "Select a Function (1-4)",
                "{[div]}",
                "",
                "1. Change AC Temperature set point",
                "2. Enable/Disable IP Camera",
                "3. Turn anti-theft system on/off",
                "4. Exit"
        });

//        // 80 characters wide.
//        System.out.println(" ------------------------------------------ ");
//        System.out.println("| Select a Function (1-4).                 |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("|                                          |");
//        System.out.println("| 1. Change AC Temperature set point       |");
//        System.out.println("| 2. Enable/Disable IP Camera              |");
//        System.out.println("| 3. Turn anti-theft system on/off.        |");
//        System.out.println("| 4. Exit                                  |");
//        System.out.println(" ------------------------------------------ ");
    }

    public static void showRestart() {
        BoxPrinter.printBox(new String[]{
                "Restarting...",
                "{[div]}",
                "",
                "Please wait while the system is",
                "preparing for a restart."
        });

//        // 80 characters wide.
//        System.out.println(" ------------------------------------------ ");
//        System.out.println("| Restarting ....                          |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("|                                          |");
//        System.out.println("| Please wait while the system is          |");
//        System.out.println("| preparing for a restart.                 |");
//        System.out.println(" ------------------------------------------ ");
    }

    public static void showShutdown() {
        BoxPrinter.printBox(new String[]{
                "Shutting Down...",
                "{[div]}",
                "",
                "Please wait while the system is",
                "preparing for a shutdown."
        });

//        // 80 characters wide.
//        System.out.println(" ------------------------------------------ ");
//        System.out.println("| Shutting down ....                       |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("|                                          |");
//        System.out.println("| Please wait while the system is          |");
//        System.out.println("| preparing for a shutdown.                |");
//        System.out.println(" ------------------------------------------ ");
    }

    public static void changeACSetP() {
        BoxPrinter.printBox(new String[]{
                "Applying new temperature set point...",
                "{[div]}",
                "",
                "New temperature set point will be in",
                "effect soon."
        });

//        // 80 characters wide.
//        System.out.println(" ------------------------------------------ ");
//        System.out.println("| Applying New Temperature Set Point.      |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("|                                          |");
//        System.out.println("| New temperature set point will be in     |");
//        System.out.println("| effect soon...                           |");
//        System.out.println(" ------------------------------------------ ");

        showRestart();
    }

    public static void confirmRestart() {
        BoxPrinter.printBox(new String[]{
                "Restart Confirmation",
                "{[div]}",
                "",
                "Are you sure that you want to restart",
                "the system? (Y/N)"
        });

//        // 80 characters wide.
//        System.out.println(" ------------------------------------------ ");
//        System.out.println("| Restart Confirmation                     |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("|                                          |");
//        System.out.println("| Are you sure that you want to restart    |");
//        System.out.println("| the system? (Y/N)                        |");
//        System.out.println(" ------------------------------------------ ");
    }

    public static void confirmShutdown() {
        BoxPrinter.printBox(new String[]{
                "Shutdown Confirmation",
                "{[div]}",
                "",
                "Are you sure that you want to shutdown",
                "the system? (Y/N)"
        });

//        // 80 characters wide.
//        System.out.println(" ------------------------------------------ ");
//        System.out.println("| Shutdown Confirmation                    |");
//        System.out.println("|------------------------------------------|");
//        System.out.println("|                                          |");
//        System.out.println("| Are you sure that you want to shutdown   |");
//        System.out.println("| the system? (Y/N)                        |");
//        System.out.println(" ------------------------------------------ ");
    }
}
