package dev.akuniutka.skillfactory.chess;

import java.lang.Math;

public class Horse extends ChessPiece {

    public Horse(String color) {
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

        return Math.abs(toLine - line) * Math.abs(toColumn - column) == 2;
    }

    @Override
    public String getSymbol() {
        return "H";
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