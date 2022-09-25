package dev.akuniutka.skillfactory.chess;

import java.lang.Math;

public class King extends ChessPiece {

    public King(String color) {
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

        return Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        int skipLine = color.equals("White") ? 7 : 0;
        int lineStep = color.equals("White") ? 1 : -1;
        if (line != skipLine && column > 0) {
            if (isEnemyPiece(board.board[line + lineStep][column - 1], "P")) return true;
        }
        if (line != skipLine && column < 7) {
            if (isEnemyPiece(board.board[line + lineStep][column + 1], "P")) return true;
        }

        for (int i = -2; i < 3; i++) {
            for (int j = -2; i < 3; i++) {
                if (Math.abs(i) == Math.abs(j) || i * j == 0) continue;
                if (isOutsideOfBoard(line + i, column + j)) continue;
                if (isEnemyPiece(board.board[line + i][column + j], "H")) return true;
            }
        }

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                int currentLine = line;
                int currentColumn = column;
                ChessPiece chessPiece = null;
                do {
                    currentLine += i;
                    currentColumn += j;
                    if (!isOutsideOfBoard(currentLine, currentColumn)) {
                        chessPiece = board.board[currentLine][currentColumn];
                    }
                } while (!isOutsideOfBoard(currentLine, currentColumn) && chessPiece == null);
                if (Math.abs(currentLine - line) <= 1 && Math.abs(currentColumn - column) <= 1 ) {
                    if (isEnemyPiece(board.board[line + i][column + j], "K")) return true;
                }
                if (currentColumn == column || currentLine == line) {
                    if (isEnemyPiece(board.board[line + i][column + j], "R")) return true;
                } else {
                    if (isEnemyPiece(board.board[line + i][column + j], "B")) return true;
                }
                if (isEnemyPiece(board.board[line + i][column + j], "Q")) return true;
            }
        }
        return false;
    }

    private boolean isOutsideOfBoard(int line, int column) {
        return line < 0 || line > 7 || column < 0 || column > 7;
    }

    private boolean isOccupiedBySameColor(ChessBoard chessBoard, int line, int column) {
        ChessPiece chessPiece = chessBoard.board[line][column];
        if (chessPiece == null) return false;
        return color.equals(chessPiece.getColor());
    }

    private boolean isEnemyPiece(ChessPiece chessPiece, String symbol) {
        if (chessPiece == null) return false;
        return chessPiece.getSymbol().equals(symbol) && !chessPiece.getColor().equals(color);
    }
}