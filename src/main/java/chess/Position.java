package chess;

public class Position {
    private int x = 0;
    private int y = 0;

    Position() {
    }

    public static Position createPosition(String inputPosition) {
        Position position = new Position();
        if (inputPosition.length() != 2) {
            throw new IllegalArgumentException("위치값을 올바르게 입력해주세요");
        }
        char x = inputPosition.charAt(0);
        char y = inputPosition.charAt(1);
        if (!('a' <= x && x <= 'h') &&
                ('1' <= y && y <= '8')) {
            throw new IllegalArgumentException("범위에맞는 위치값을 입력해주세요");
        }
        position.x = x - 'a';
        position.y = Character.getNumericValue(y) - 1;
        return position;
    }

    public int getXPos() {
        return this.x;
    }

    public int getYPos() {
        return this.y;
    }
}
