package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

import java.util.ArrayList;
import java.util.List;

class Rank {
    private static final int FILE_COUNT = 8;
    private int pieceCount = 0;
    private List<Piece> pieces = new ArrayList<>(FILE_COUNT);

    static Rank initializeWhitePieces(int yIndex) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook(Position.createPosition(0, yIndex)));
        rank.addPiece(Piece.createWhiteKnight(Position.createPosition(1,yIndex)));
        rank.addPiece(Piece.createWhiteBishop(Position.createPosition(2, yIndex)));
        rank.addPiece(Piece.createWhiteQueen(Position.createPosition(3, yIndex)));
        rank.addPiece(Piece.createWhiteKing(Position.createPosition(4, yIndex)));
        rank.addPiece(Piece.createWhiteBishop(Position.createPosition(5,yIndex)));
        rank.addPiece(Piece.createWhiteKnight(Position.createPosition(6, yIndex)));
        rank.addPiece(Piece.createWhiteRook(Position.createPosition(7,yIndex)));
        return rank;
    }

    static Rank initializeBlackPieces(int yIndex) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook(Position.createPosition(0, yIndex)));
        rank.addPiece(Piece.createBlackKnight(Position.createPosition(1, yIndex)));
        rank.addPiece(Piece.createBlackBishop(Position.createPosition(2, yIndex)));
        rank.addPiece(Piece.createBlackQueen(Position.createPosition(3, yIndex)));
        rank.addPiece(Piece.createBlackKing(Position.createPosition(4, yIndex)));
        rank.addPiece(Piece.createBlackBishop(Position.createPosition(5, yIndex)));
        rank.addPiece(Piece.createBlackKnight(Position.createPosition(6, yIndex)));
        rank.addPiece(Piece.createBlackRook(Position.createPosition(7, yIndex)));
        return rank;
    }

    static Rank initializeWhitePawns(int yIndex) {
        Rank rank = new Rank();
        for (int i = 0; i < FILE_COUNT; i++) {
            rank.addPiece(Piece.createWhitePawn(Position.createPosition(i, yIndex)));
        }
        return rank;
    }

    static Rank initializeBlackPawns(int yIndex) {
        Rank rank = new Rank();
        for (int i = 0; i < FILE_COUNT; i++) {
            rank.addPiece(Piece.createBlackPawn(Position.createPosition(i, yIndex)));
        }
        return rank;
    }

    static Rank initializeBlankPieces(int yIndex) {
        Rank rank = new Rank();
        for (int i = 0; i < FILE_COUNT; i++) {
            rank.addPiece(Piece.createBlankPiece(Position.createPosition(i, yIndex)));
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

    Piece getPiece(int index) {
        Piece piece = pieces.get(index);
        return piece;
    }

    void setPiece(int index, Piece piece) {
        pieces.set(index, piece);
    }

    double sumPiecePoint(Color color) {
        return pieces.stream().filter(piece -> piece.getColor() == color)
                .map(Piece::getType)
                .map(Type::getDefaultPoint)
                .reduce(0.0, Double::sum);
    }

    List<Integer> getPawnsFileIndex(Color color) {
        List pawnsFileIndex = new ArrayList();
        for( Piece piece : pieces){
            if ((piece.getColor() == color) && (piece.getType() == Type.PAWN)) {
                pawnsFileIndex.add(piece.getPosition().getXIndex());
            }
        }

        return pawnsFileIndex;
    }
}
