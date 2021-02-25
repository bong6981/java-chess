package chess;

import pieces.Piece;
import pieces.Piece.*;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    Board() {
    }

    static final int FILE_COUNT = 8;
    static final int RANK_COUNT = 8;
    private List<Rank> ranks = new ArrayList<>(RANK_COUNT);

    private void addRank(Rank rank) {
        ranks.add(rank);
    }

//    void addWhitePawn(Piece piece) {
//        if (!piece.isWhite() || piece.getType() != Piece.Type.PAWN) {
//            throw new InvalidParameterException("흰색의 pawn만 추가할 수 있습니다.");
//        }
//        whitePawns.add(piece);
//    }
//
//    void addBlackPawn(Piece piece) {
//        if (!piece.isBlack() || piece.getType() != Piece.Type.PAWN) {
//            throw new InvalidParameterException("검은색의 pawn만 추가할 수 있습니다");
//        }
//        blackPawns.add(piece);
//    }
//
//    void addWhitePiece(Piece piece) {
//        if (!piece.isWhite()){
//            throw new InvalidParameterException("흰색의 piece만 추가할 수 있습니다");
//        }
//        whitePieces.add(piece);
//    }
//
//    void addBlackPiece(Piece piece) {
//        if (!piece.isBlack()){
//            throw new InvalidParameterException("검은색의 piece만 추가할수 있습니다");
//        }
//        blackPieces.add(piece);
//    }

    public int pieceCount() {
        int pieceCount = 0;
        for (Rank rank : ranks) {
            pieceCount += rank.pieceCountInRank();
        }
        return pieceCount;
    }

    public int pieceCount(Color color, Type type) {
        int pieceCount = 0;
        for (Rank rank : ranks) {
            pieceCount += rank.pieceCountInRank(color, type);
        }
        return pieceCount;
    }


    private String getRankResult(Rank rank) {
        return rank.getPiecesResult();

    }
//
//    private String getWhitePiecesResult() {
//        return getPiecesResult(whitePieces);
//    }
//
//    private String getBlackPiecesResult() {
//        return getPiecesResult(blackPieces);
//    }
//
//    private String getWhitePawnsResult() {
//        return getPiecesResult(whitePawns);
//    }
//
//    private String getBlackPawnsResult() {
//        return getPiecesResult(blackPawns);
//    }

//    private String getPiecesResult(List<Piece> pieces) {
//        StringBuilder sb = new StringBuilder();
//        for (char representation : getRepresentations(pieces)) {
//            sb.append(representation);
//        }
//        return sb.toString();
//    }

//    private char[] getRepresentations(List<Piece> pieces) {
//        char[] representations = new char[pieces.size()];
//        for (int i = 0; i < pieces.size(); i++) {
//            representations[i] = pieces.get(i).getRepresentation();
//        }
//        return representations;
//    }

    public void initialize() {
        addRank(Rank.initializeWhitePieces());
        addRank(Rank.initializeWhitePawns());
        addRank(Rank.initializeBlankPieces());
        addRank(Rank.initializeBlankPieces());
        addRank(Rank.initializeBlankPieces());
        addRank(Rank.initializeBlankPieces());
        addRank(Rank.initializeBlackPawns());
        addRank(Rank.initializeBlackPieces());
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        final int MAX_INDEX = ranks.size() - 1;
        for (int i = MAX_INDEX; i >= 0; i--) {
            result.append(appendNewLine(getRankResult(ranks.get(i))));
        }
        return result.toString();
    }


    public Piece findPiece(String inputPosition) {
        Position position = Position.createPosition(inputPosition);
        Piece piece = findPiece(position.getXPos(), position.getYPos());
        return piece;
    }

    public Piece findPiece(int x, int y) {
        Piece piece = ranks.get(y).getPiece(x);
        return piece;
    }
}
