package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.StringUtils.appendNewLine;


class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("board를 initialize()하고 출력을 확인한다")
    void create() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(64);

        final String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("기물의 색과 종류를 인자로 받아 해당 기물의 개수를 반환해야 한다")
    void CountCertainPieceTest() {
        board.initialize();
        assertThat(board.pieceCount(Piece.Color.WHITE, Piece.Type.QUEEN)).isEqualTo(1);
    }
//
//    @Test
//    @DisplayName("잘못된 색의 pawn을 추가하거나 pawn아닌 다른 pawn을 추가할 수 없다")
//    void addWrongPawn() {
//        Piece blackPawn = Piece.createBlackPawn();
//        assertThatExceptionOfType(InvalidParameterException.class)
//                .isThrownBy(() -> board.addWhitePawn(blackPawn));
//        Piece whiteRook = Piece.createWhiteRook();
//        assertThatExceptionOfType(InvalidParameterException.class)
//                .isThrownBy(() -> board.addWhitePawn(whiteRook));
//        Piece whitePawn = Piece.createWhitePawn();
//        assertThatExceptionOfType(InvalidParameterException.class)
//                .isThrownBy(() -> board.addBlackPawn(whitePawn));
//        Piece blackRook = Piece.createBlackRook();
//        assertThatExceptionOfType(InvalidParameterException.class)
//                .isThrownBy(()->board.addBlackPawn(blackRook));
//    }
//
//    @Test
//    @DisplayName("잘못된 색의 piece를 추가할 수 없다")
//    void addWrongPiece() {
//        Piece blackPiece = Piece.createBlackRook();
//        assertThatExceptionOfType(InvalidParameterException.class)
//                .isThrownBy(() -> board.addWhitePiece(blackPiece));
//
//        Piece whitePiece = Piece.createWhiteRook();
//        assertThatExceptionOfType(InvalidParameterException.class)
//                .isThrownBy(() -> board.addBlackPiece(whitePiece));
//    }
}
