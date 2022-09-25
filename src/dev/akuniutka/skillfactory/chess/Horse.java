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
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        } else if (chessBoard.board[toLine][toColumn] != null) {
            if (color.equals(chessBoard.board[toLine][toColumn].getColor())) {
                return false;
            }
        }

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
}