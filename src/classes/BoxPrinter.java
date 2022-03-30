package classes;

import java.util.HashMap;

public class BoxPrinter {
    private static int windowWidth = 45;

    private static HashMap<String, String[]> lineOrientationMap = new HashMap<String, String[]>();

    static {
        lineOrientationMap.put("top", new String[]{"┌", "┐"});
        lineOrientationMap.put("bottom", new String[]{"└", "┘"});
    }

    private static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    private static StringBuilder lineBuilder(String orientation) {
        String[] cornerObjects = lineOrientationMap.get(orientation);

        if (cornerObjects == null) {
            System.out.println(String.format("Orientation \"%s\" does not exist.", orientation));
            return null;
        }

        StringBuilder newLine = new StringBuilder();
        newLine.append(cornerObjects[0]);
        newLine.append("─".repeat(windowWidth + 2));
        newLine.append(cornerObjects[1]);

        return newLine;
    }

    // Kinda a useless wrapper but.. ┐(︶▽︶)┌
    private static void printLine(String orientation) {
        System.out.println(lineBuilder(orientation));
    }

    private static void printDivider() {
        System.out.print("├");
        System.out.print("─".repeat(windowWidth + 2));
        System.out.println("┤");
    }

    private static void printRow(String input) {
        System.out.print("│ ");
        System.out.print(input);
        // Initially I wanted to put a length limit here, but... might be in parseLine instead
        System.out.print(" ".repeat(clamp(windowWidth - input.length(), 0, windowWidth)));
        System.out.println(" │");
    }

    public static void printBox(String input) {
        printLine("top");
        printRow(input);
        printLine("bottom");
    }

    public static void printBox(String[] inputs) {
        printLine("top");

        for (String input : inputs) {
            /*
                TODO: make parseLine method if the placeholders grow.
                 Make it check for placeholders, string length limits, return string to print.
                 Could also make it perform actions.
                 Also make sure that all placeholders can also be outputted to the console.
             */
            if (input.equalsIgnoreCase("{[div]}")) {
                printDivider();
            } else {
                // Truncate with dots at length of windowWidth - 3
                printRow(input.length() > windowWidth ? input.substring(0, windowWidth - 3) + "..." : input);
            }
        }

        printLine("bottom");
    }
}
