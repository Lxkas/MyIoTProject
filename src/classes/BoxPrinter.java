package classes;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoxPrinter {
    private static int windowWidth = 60;

    public static enum Alignment {
        LEFT,
        CENTER,
        RIGHT
    }

    private static HashMap<String, String[]> lineOrientationMap = new HashMap<String, String[]>();

    static {
        lineOrientationMap.put("top", new String[]{"┌", "┐"});
        lineOrientationMap.put("bottom", new String[]{"└", "┘"});
    }

    private static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    private static String[] getPadding(String input, Alignment alignment) {
        int inputLength = input.length();

        switch (alignment) {
            case LEFT:
                return new String[]{
                        "",
                        // Initially I wanted to put a length limit here, but... might be in parseLine instead
                        " ".repeat(clamp(windowWidth - inputLength, 0, windowWidth))
                };
            case CENTER:
                int spaceLeft = windowWidth - inputLength;
                String spacePadding = " ".repeat(Math.round(spaceLeft / 2));

                return new String[]{
                        spacePadding,
                        // Check if spaceLeft is an even number, if it is, add another space to compensate.
                        spacePadding + (spaceLeft % 2 == 0 ? "" : " ")
                };
            case RIGHT:
                return new String[]{
                        " ".repeat(clamp(windowWidth - inputLength, 0, windowWidth)),
                        ""
                };
            default:
                System.out.println("Invalid alignment passed to getPadding!");
                break;
        }


        return new String[]{
                "",
                ""
        };
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

    private static void parseLine(String input) {
        Pattern pattern = Pattern.compile("(?<=\\{\\[)(.*)?(?=\\]\\})", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        String cleanedInput = input.replaceAll("\\{\\[.+\\]\\}", "");
        String toPrint = cleanedInput.length() > windowWidth ? cleanedInput.substring(0, windowWidth - 3) + "..." : cleanedInput;

        if (matcher.find()) {
            String foundPlaceholder = matcher.group(0);

            switch (foundPlaceholder) {
                case "div":
                    printDivider();
                    break;
                case "al":
                    printRow(toPrint, Alignment.LEFT);
                    break;
                case "ac":
                    printRow(toPrint, Alignment.CENTER);
                    break;
                case "ar":
                    printRow(toPrint, Alignment.RIGHT);
                    break;
                default:
                    System.out.println(String.format("Invalid placeholder \"%s\" passed to parseLine.", foundPlaceholder));
                    break;
            }
        } else {
            printRow(toPrint, Alignment.LEFT);
        }
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

    private static void printRow(String input, Alignment alignment) {
        String[] spacePadding = getPadding(input, alignment);

        String paddingLeft = spacePadding[0];
        String paddingRight = spacePadding[1];

        System.out.print("│ ");
        System.out.print(paddingLeft);
        System.out.print(input);
        System.out.print(paddingRight);
        System.out.println(" │");
    }

    public static void printBox(String input) {
        printLine("top");
        printRow(input, Alignment.LEFT);
        printLine("bottom");
    }

    public static void printBoxWithAlignment(String input, Alignment alignment) {
        printLine("top");
        printRow(input, alignment);
        printLine("bottom");
    }

    public static void printBox(String[] inputs) {
        printLine("top");

        for (String input : inputs) {
            parseLine(input);
        }

        printLine("bottom");
    }
}
