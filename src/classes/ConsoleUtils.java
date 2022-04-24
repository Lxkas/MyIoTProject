package classes;

public class ConsoleUtils {
    private final static char escCode = 0x1B;

    public static void gotoXY(int x, int y) {
        System.out.printf("%c[%d;%df", escCode, x, y);
    }

    public static void hideCursor() {
        System.out.print(escCode + "[?25l");
    }

    public static void showCursor() {
        System.out.print(escCode + "[?25h");
    }

//    public static Position readCurrentPosition() {
//        try {
//            System.out.print(escCode + "[6n");
//
//            String result = "";
//            int character;
//
//            do {
//                character = System.in.read();
//                if (character == 27) {
//                    result += "^";
//                } else {
//                    result += (char) character;
//                }
//            } while (character != 82); // 'R'
//
//            Pattern pattern = Pattern.compile("\\^\\[(\\d+);(\\d+)R");
//            Matcher matcher = pattern.matcher(result);
//            if (matcher.matches()) {
//                return new Position(Integer.valueOf(matcher.group(2)),
//                        Integer.valueOf(matcher.group(1)));
//            } else {
//                return new Position(1, 1);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new Position(1, 1);
//        }
//    }
//
//    public static Position detectScreenSize() {
//        Position initialPosition = readCurrentPosition();
//        gotoXY(10000, 10000);
//        Position result = readCurrentPosition();
//        gotoXY(initialPosition.getX(), initialPosition.getY());
//
//        System.out.println(String.format("%s, %s", result.getX(), result.getY()));
//
//        return result;
//    }
}
