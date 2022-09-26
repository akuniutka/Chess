package dev.akuniutka.skillfactory.chess;

import java.lang.Math;

public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }


    // TODO move implementation to ChessPiece
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isOutsideOfBoard(toLine, toColumn)) return false;
        if (isOccupiedBySameColor(chessBoard, toLine, toColumn)) return false;

        return Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        ChessPiece chessPiece;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessPiece = board.board[i][j];
                if (chessPiece == null) continue;
                if (chessPiece.getColor().equals(color)) continue;
                if (chessPiece.getSymbol().equals("P") && j == column) continue;
                if (chessPiece.canMoveToPosition(board, i, j, line, column)) return true;
            }
        }
        return false;
    }


    // TODO move method to ChessPiece
    private boolean isOutsideOfBoard(int line, int column) {
        return line < 0 || line > 7 || column < 0 || column > 7;
    }

    // TODO move method to ChessPiece
    private boolean isOccupiedBySameColor(ChessBoard chessBoard, int line, int column) {
        ChessPiece chessPiece = chessBoard.board[line][column];
        if (chessPiece == null) return false;
        return color.equals(chessPiece.getColor());
    }
}