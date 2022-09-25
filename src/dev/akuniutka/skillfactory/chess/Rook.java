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
        if (isOutsideOfBoard(toLine, toColumn)) return false;
        if (isOccupiedBySameColor(chessBoard, toLine, toColumn)) return false;

        return isAccessibleByHorizontal(chessBoard, line, column, toLine, toColumn) ||
                isAccessibleByVertical(chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    private boolean isOutsideOfBoard(int line, int column) {
        return line < 0 || line > 7 || column < 0 || column > 7;
    }

    private boolean isOccupiedBySameColor(ChessBoard chessBoard, int line, int column) {
        ChessPiece chessPiece = chessBoard.board[line][column];
        if (chessPiece == null) return false;
        return color.equals(chessPiece.getColor());
    }

    private boolean isAccessibleByHorizontal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine != line) return false;

        int stepForColumns = toColumn > column ? 1 : -1;
        int currentColumn = column + stepForColumns;
        while (currentColumn != toColumn) {
            if (chessBoard.board[line][currentColumn] != null) return false;
            currentColumn += stepForColumns;
        }
        return true;
    }

    private boolean isAccessibleByVertical(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toColumn != column) return false;

        int stepForLines = toLine > line ? 1 : -1;
        int currentLine = line + stepForLines;
        while (currentLine != toLine) {
            if (chessBoard.board[currentLine][column] != null) return false;
            currentLine += stepForLines;
        }
        return true;
    }
}
