package pieces;

import pieces.Piece.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {
    @Test
    @DisplayName("piece의 type별로 흰/검 말이 생성되어야 한다")
    void createPiece() {
        Position position = Position.createPosition(0,0);
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(position), Piece.createBlackPawn(position), Type.PAWN),
                () -> verifyPiece(Piece.createWhiteKnight(position), Piece.createBlackKnight(position), Type.KNIGHT),
                () -> verifyPiece(Piece.createWhiteRook(position), Piece.createBlackRook(position), Type.ROOK),
                () -> verifyPiece(Piece.createWhiteBishop(position), Piece.createBlackBishop(position), Type.BISHOP),
                () -> verifyPiece(Piece.createWhiteQueen(position), Piece.createBlackQueen(position), Type.QUEEN),
                () -> verifyPiece(Piece.createWhiteKing(position), Piece.createBlackKing(position), Type.KING)
        );

        Piece blank = Piece.createBlankPiece(position);
        assertAll(
                () -> assertThat(blank.isWhite()).isFalse(),
                () -> assertThat(blank.isBlack()).isFalse(),
                () -> assertThat(blank.getType()).isEqualTo(Type.NO_PIECE)
        );
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertAll(
                () -> assertThat(whitePiece.isWhite()).isTrue(),
                () -> assertThat(whitePiece.getType()).isEqualTo(type),

                () -> assertThat(blackPiece.isBlack()).isTrue(),
                () -> assertThat(whitePiece.getType()).isEqualTo(type)
        );
    }

    @Test
    @DisplayName("체스 말의 색을 isWhite(), isBlack()로 확인할 수 있어야한다")
    void checkColor() {
        Position position = Position.createPosition(0,0);
        Piece blackPiece = Piece.createBlackPawn(position);
        Piece whitePiece = Piece.createWhitePawn(position);
        assertAll(
                () -> assertThat(blackPiece.isBlack()).isTrue(),
                () -> assertThat(whitePiece.isWhite()).isTrue()
        );
    }

    @Test
    @DisplayName("piece의 representation이 getWhite/BlackRepresentation()을 통해 확인되어야 한다")
    void getRepresentationPerPiece() {
        assertAll(
                () -> assertThat(Type.PAWN.getWhiteRepresentation()).isEqualTo('p'),
                () -> assertThat(Type.PAWN.getBlackRepresentation()).isEqualTo('P')
        );
    }
}
