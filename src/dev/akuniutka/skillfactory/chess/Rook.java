package dev.akuniutka.skillfactory.chess;

public class Rook extends ChessPiece {

    public Rook(String color) {
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

        if (toLine == line) {
            int stepForColumns = toColumn > column ? 1 : -1;
            int currentColumn = column + stepForColumns;
            while (currentColumn != toColumn) {
                if (chessBoard.board[line][currentColumn] != null) {
                    return false;
                }
                currentColumn += stepForColumns;
            }
            return true;
        } else if (toColumn == column) {
            int stepForLines = toLine > line ? 1 : -1;
            int currentLine = line + stepForLines;
            while (currentLine != toLine) {
                if (chessBoard.board[currentLine][column] != null) {
                    return false;
                }
                currentLine += stepForLines;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
