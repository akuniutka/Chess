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
        if (isOutsideOfBoard(toLine, toColumn)) return false;
        if (isOccupiedBySameColor(chessBoard, toLine, toColumn)) return false;

        return isAccessibleByDiagonal(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    private boolean isOutsideOfBoard(int line, int column) {
        return line < 0 || line > 7 || column < 0 || column > 7;
    }

    private boolean isOccupiedBySameColor(ChessBoard chessBoard, int line, int column) {
        ChessPiece chessPiece = chessBoard.board[line][column];
        if (chessPiece == null) return false;
        return color.equals(chessPiece.getColor());
    }

    private boolean isAccessibleByDiagonal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) return false;

        int stepForLines = toLine > line ? 1 : -1;
        int stepForColumns = toColumn > column ? 1 : -1;
        int currentLine = line + stepForLines;
        int currentColumn = column + stepForColumns;
        while (currentLine != toLine) {
            if (chessBoard.board[currentLine][currentColumn] != null) return false;
            currentLine += stepForLines;
            currentColumn += stepForColumns;
        }
        return true;
    }
}