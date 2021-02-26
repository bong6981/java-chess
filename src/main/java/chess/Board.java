package chess;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    Board() {
    }

    private static final int RANK_COUNT = 8;
    private static final int FILE_COUNT = 8;
    private List<Rank> ranks = new ArrayList<>(RANK_COUNT);

    public void initialize() {
        addRank(Rank.initializeWhitePieces(0));
        addRank(Rank.initializeWhitePawns(1));
        addRank(Rank.initializeBlankPieces(2));
        addRank(Rank.initializeBlankPieces(3));
        addRank(Rank.initializeBlankPieces(4));
        addRank(Rank.initializeBlankPieces(5));
        addRank(Rank.initializeBlackPawns(6));
        addRank(Rank.initializeBlackPieces(7));
    }

    public void initializeEmpty() {
        for (int i = 0; i < RANK_COUNT; i++) {
            addRank(Rank.initializeBlankPieces(i));
        }
    }

    private void addRank(Rank rank) {
        ranks.add(rank);
    }

    public void move(String stringPosition, Piece piece) {
        Position position = Position.createPosition(stringPosition);
        int yIndex = position.getYIndex();
        int xIndex = position.getXIndex();
        ranks.get(yIndex).setPiece(xIndex, piece);
    }

    public int countAllPieces() {
        int pieceCount = 0;
        for (Rank rank : ranks) {
            pieceCount += rank.countAllPieces();
        }
        return pieceCount;
    }

    public int countPiece(Color color, Type type) {
        int pieceCount = 0;
        for (Rank rank : ranks) {
            pieceCount += rank.countPiece(color, type);
        }
        return pieceCount;
    }

    public Piece findPiece(String stringPosition) {
        Position position = Position.createPosition(stringPosition);
        Piece piece = findPiece(position.getXIndex(), position.getYIndex());
        return piece;
    }

    private Piece findPiece(int xIndex, int yIndex) {
        Piece piece = ranks.get(yIndex).getPiece(xIndex);
        return piece;
    }

    public double calculatePoint(Color color) {
        double piecePoint = sumPiecePoint(color);
        int halfPawnCount = countHalfPawn(color);
        double point = piecePoint - halfPawnCount * 0.5;
        return point;
    }

    private double sumPiecePoint(Color color) {
        double piecePoint = 0;
        for (Rank rank : ranks) {
            piecePoint += rank.sumPiecePoint(color);
        }
        return piecePoint;
    }

    private int countHalfPawn(Color color) {
        List<Integer> pawnsFileIndex = getPawnsFileIndex(color);
        int halfPawnCount = 0;
        for (int i = 0; i < FILE_COUNT; i++) {
            int fileIndex = i;
            int pawnCountByFile = (int) pawnsFileIndex.stream().filter(index -> index == fileIndex)
                    .count();
            if (pawnCountByFile >= 2) {
                halfPawnCount += pawnCountByFile;
            }
        }
        return halfPawnCount;
    }

    private List<Integer> getPawnsFileIndex(Color color) {
        List<Integer> pawnsFileIndex = new ArrayList<>();
        for (Rank rank : ranks) {
            pawnsFileIndex.addAll(rank.getPawnsFileIndex(color));
        }
        return pawnsFileIndex;
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        final int MAX_INDEX = ranks.size() - 1;
        for (int i = MAX_INDEX; i >= 0; i--) {
            result.append(appendNewLine(getRankResult(ranks.get(i))));
        }
        return result.toString();
    }

    private String getRankResult(Rank rank) {
        return rank.getPiecesResult();
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
}



