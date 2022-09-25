package dev.akuniutka.skillfactory.chess;

import java.lang.Math;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
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

        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) {
            return false;
        }

        int stepForLines = toLine > line ? 1 : -1;
        int stepForColumns = toColumn > column ? 1 : -1;
        int currentLine = line + stepForLines;
        int currentColumn = column + stepForColumns;
        while (currentLine < toLine) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += stepForLines;
            currentColumn += stepForColumns;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}