package pieces;

public class Position {
    private int x = 0;
    private int y = 0;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position createPosition(String stringPosition) {
        if (stringPosition.length() != 2) {
            throw new IllegalArgumentException("위치값을 올바르게 입력해주세요");
        }
        char xChar = stringPosition.charAt(0);
        char yChar = stringPosition.charAt(1);
        if (!(('a' <= xChar && xChar <= 'h') &&
                ('1' <= yChar && yChar <= '8'))) {
            throw new IllegalArgumentException("범위에맞는 위치값을 입력해주세요");
        }
        int x  = xChar - 'a' + 1;
        int y = Character.getNumericValue(yChar);
        return new Position(x,y);
    }

    public static Position createPosition(int xIndex, int yIndex){
        int x = xIndex + 1;
        int y = yIndex + 1;
        return new Position(x,y);
    }

    public int getXIndex() {
        return this.x - 1;
    }

    public int getYIndex() {
        return this.y - 1;
    }
}
