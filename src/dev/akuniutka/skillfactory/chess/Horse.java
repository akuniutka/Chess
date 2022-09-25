package dev.akuniutka.skillfactory.chess;

import java.lang.Math;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isOutsideOfBoard(toLine, toColumn)) return false;
        if (isOccupiedBySameColor(chessBoard, toLine, toColumn)) return false;

        if (Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) {
            return true;
        } else if (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    private boolean isOutsideOfBoard(int line, int column) {
        return line < 0 || line > 7 || column < 0 || column > 7;
    }

    private boolean isOccupiedBySameColor(ChessBoard chessBoard, int line, int column) {
        ChessPiece chessPiece = chessBoard.board[line][column];
        if (chessPiece == null) return false;
        return color.equals(chessPiece.getColor());
    }
}