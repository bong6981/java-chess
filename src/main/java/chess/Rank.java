package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

import java.util.ArrayList;
import java.util.List;

class Rank {
    private static final int FILE_COUNT = 8;
    private int pieceCount = 0;
    private List<Piece> pieces = new ArrayList<>(FILE_COUNT);

    static Rank initializeWhitePieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteQueen());
        rank.addPiece(Piece.createWhiteKing());
        rank.addPiece(Piece.createWhiteBishop());
        rank.addPiece(Piece.createWhiteKnight());
        rank.addPiece(Piece.createWhiteRook());
        return rank;
    }

    public static Rank initializeBlackPieces() {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackQueen());
        rank.addPiece(Piece.createBlackKing());
        rank.addPiece(Piece.createBlackBishop());
        rank.addPiece(Piece.createBlackKnight());
        rank.addPiece(Piece.createBlackRook());
        return rank;
    }

    static Rank initializeWhitePawns() {
        Rank rank = new Rank();
        for (int i = 0; i < FILE_COUNT; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }
        return rank;
    }

    public static Rank initializeBlackPawns() {
        Rank rank = new Rank();
        for (int i = 0; i < FILE_COUNT; i++) {
            rank.addPiece(Piece.createBlackPawn());
        }
        return rank;
    }

    public static Rank initializeBlankPieces() {
        Rank rank = new Rank();
        for (int i = 0; i < FILE_COUNT; i++) {
            rank.addPiece(Piece.createBlankPiece());
        }
        return rank;
    }

    private void addPiece(Piece piece) {
        pieces.add(piece);
        pieceCount++;
    }

    int countAllPieces() {
        return pieceCount;
    }

    int countPiece(Piece.Color color, Piece.Type type) {
        int pieceCount = 0;
        for (Piece piece : pieces) {
            if (color == piece.getColor() &&
                    type == piece.getType()) {
                pieceCount++;
            }
        }
        return pieceCount;
    }

    String getPiecesResult() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public Piece getPiece(int index) {
        Piece piece = pieces.get(index);
        return piece;
    }

    public void setPiece(int index, Piece piece) {
        pieces.set(index, piece);
    }

    public double sumPiecePoint(Color color) {
        return pieces.stream().filter(piece -> piece.getColor() == color)
                .map(Piece::getType)
                .map(Type::getDefaultPoint)
                .reduce(0D, Double::sum);
    }

    public List<Integer> getPawnsFileIndex(Color color) {
        List<Integer> pawnsFileIndex = new ArrayList<>();
        for (int i = 0; i < FILE_COUNT; i++) {
            Piece piece = pieces.get(i);
            if ((piece.getColor() == color) && (piece.getType() == Type.PAWN)) {
                pawnsFileIndex.add(i);
            }
        }
        return pawnsFileIndex;
    }
}
