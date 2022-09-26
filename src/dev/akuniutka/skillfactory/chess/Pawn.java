package dev.akuniutka.skillfactory.chess;

import java.lang.Math;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
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

        if (toColumn == column && chessBoard.board[toLine][toColumn] == null) {
            if (color.equals("White") && line == 1 && toLine == 3 && chessBoard.board[2][column] == null) {
                return true;
            } else if (color.equals("Black") && line == 6 && toLine == 4 && chessBoard.board[5][column] == null) {
                return true;
            } else if (color.equals("White") && toLine - line == 1) {
                return true;
            } else return color.equals("Black") && toLine - line == -1;
        } else if (Math.abs(toColumn - column) == 1 && chessBoard.board[toLine][toColumn] != null) {
            if (color.equals("White") && toLine - line == 1) {
                return true;
            } else return color.equals("Black") && toLine - line == -1;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
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