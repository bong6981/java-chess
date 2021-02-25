package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;


public class Rank {

    private List<Piece> pieces = new ArrayList<>(Board.FILE_COUNT);
    int pieceCount = 0;

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
    
    int pieceCountInRank(){
        return pieceCount;
    }


    int pieceCountInRank(Piece.Color color, Piece.Type type){
        int pieceCount = 0;
        for( Piece piece : pieces) {
            if (color == piece.getColor() &&
                    type == piece.getType()){
                pieceCount++;
            }
        }
        return pieceCount;
    }

    private void addPiece(Piece piece){
        pieces.add(piece);
        pieceCount++;
    }

    String getPiecesResult(){
        StringBuilder sb = new StringBuilder();
        for( Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

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

    static Rank initializeWhitePawns() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.FILE_COUNT; i++) {
            rank.addPiece(Piece.createWhitePawn());
        }
        return rank;
    }

    public static Rank initializeBlankPieces() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.FILE_COUNT; i++) {
            rank.addPiece(Piece.createBlankPiece());
        }
        return rank;
    }

    public static Rank initializeBlackPawns() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.FILE_COUNT; i++) {
             rank.addPiece(Piece.createBlackPawn());
        }
        return rank;
    }
}
