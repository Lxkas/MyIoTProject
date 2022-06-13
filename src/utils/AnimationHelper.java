package utils;

import classes.BoxPrinter;
import classes.ConsoleUtils;

public class AnimationHelper {
    private String lastLine = "";
    private byte anim;

    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    public void animate(String[] steps, int lineNumber) {
        ConsoleUtils.hideCursor();
        ConsoleUtils.gotoXY(2, 0);
        BoxPrinter.printRow(steps[lineNumber % steps.length], BoxPrinter.Alignment.LEFT);
    }
}
