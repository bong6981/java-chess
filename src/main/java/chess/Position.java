package chess;

public class Position {
    private int x = 0;
    private int y = 0;

    Position() {
    }

    public static Position createPosition(String stringPosition) {
        Position position = new Position();
        if (stringPosition.length() != 2) {
            throw new IllegalArgumentException("위치값을 올바르게 입력해주세요");
        }
        char x = stringPosition.charAt(0);
        char y = stringPosition.charAt(1);
        if (!(('a' <= x && x <= 'h') &&
                ('1' <= y && y <= '8'))) {
            throw new IllegalArgumentException("범위에맞는 위치값을 입력해주세요");
        }
        position.x = x - 'a' + 1;
        position.y = Character.getNumericValue(y);
        return position;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getXIndex() {
        return this.x - 1;
    }

    public int getYIndex() {
        return this.y - 1;
    }
}
