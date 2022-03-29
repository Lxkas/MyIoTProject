package classes.screens;

import classes.LCD;

import java.util.Scanner;

import static classes.BoxPrinter.printBox;

public abstract class ScreenBase {

    // Protected because I want to be able to "overwrite" this in subclasses.
    protected String[] screenStrings;

    public ScreenBase(String[] screenStrings) {
        this.screenStrings = screenStrings;
    }

    String[] getScreenStrings() {
        return screenStrings;
    }

    String askForInput(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);

        return scanner.nextLine();
    }

    boolean askForConfirmation(String action) {
        return askForInput(String.format("Are you sure you want to %s? (Y/N): ", action)).equalsIgnoreCase("y");
    }

    void action() {

    }

    void switchTo() {
        // TODO: add a boolean param to this method, if false, don't clear screen.
        LCD.clearScreen();
        printScreenString();
        action();
    }

    public void printScreenString() {
        printBox(getScreenStrings());
    }

    // Uh.. I'll figure out this wrapper later.
    public void performAction() {
        action();
    }
}
