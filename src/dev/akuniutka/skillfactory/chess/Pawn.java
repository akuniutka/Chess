package dev.akuniutka.skillfactory.chess;

import java.lang.Math;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
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

        if (toColumn == column && chessBoard.board[toLine][toColumn] == null) {
            if (color.equals("White") && line == 1 && toLine == 3 && chessBoard.board[2][column] == null) {
                return true;
            } else if (color.equals("Black") && line == 6 && toLine == 4 && chessBoard.board[5][column] == null) {
                return true;
            } else if (color.equals("White") && toLine - line == 1) {
                return true;
            } else if (color.equals("Black") && toLine - line == -1) {
                return true;
            }
            return false;
        } else if (Math.abs(toColumn - column) == 1 && chessBoard.board[toLine][toColumn] != null) {
            if (color.equals("White") && toLine - line == 1) {
                return true;
            } else if (color.equals("Black") && toLine - line == -1) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}