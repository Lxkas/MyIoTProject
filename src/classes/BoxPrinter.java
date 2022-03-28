package classes;

public class BoxPrinter {
    private static int windowWidth = 40;

    private static StringBuilder topLine;
    private static StringBuilder bottomLine;

    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    public static void printLine(String orientation) {
        // Overkill but.. ¯\_(ツ)_/¯ I was also planning on supporting width-changing in real-time so.. re-calculating.
        // Also also, could also declare / set lastCall = 0 or 1 and check it, print topLine / bottomLine respectively.
        // i.e. orientation = lastCall ? "top" : "bottom";
        switch (orientation) {
            case "top":
                if (topLine != null) {
                    System.out.println(topLine);
                    return;
                }

                topLine = new StringBuilder();
                topLine.append("┌");
                topLine.append("-".repeat(windowWidth + 2));
                topLine.append("┐");

                System.out.println(topLine);
                break;
            case "bottom":
                if (bottomLine != null) {
                    System.out.println(bottomLine);
                    return;
                }

                bottomLine = new StringBuilder();
                bottomLine.append("└");
                bottomLine.append("-".repeat(windowWidth + 2));
                bottomLine.append("┘");

                System.out.println(bottomLine);
                break;
            default:
                System.out.println("Invalid orientation!");
                break;
        }
    }

    public static void printDivider() {
        System.out.print("|");
        System.out.print("-".repeat(windowWidth + 2));
        System.out.println("|");
    }

    public static void printRow(String input) {
        System.out.print("| ");
        System.out.print(input);
        // Initially I wanted to put a length limit here, but... might be in parseLine instead
        System.out.print(" ".repeat(clamp(windowWidth - input.length(), 0, windowWidth)));
        System.out.println(" |");
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
                printRow(input.length() > windowWidth ? input.substring(0, windowWidth - 3) + "..." : input);
            }
        }

        printLine("bottom");
    }
}
