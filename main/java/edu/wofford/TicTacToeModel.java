package edu.wofford;


public class TicTacToeModel {
    private boolean xPlayer = true;

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };

    private Mark[][] board;

    public TicTacToeModel() {
        board = new Mark[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = Mark.EMPTY;
            }
        }
    }

    
    public boolean setMarkAt(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == Mark.EMPTY && getResult() == Result.NONE) {
            if (xPlayer) {
                board[row][col] = Mark.XMARK;
                xPlayer = false;
            } else {
                board[row][col] = Mark.OMARK;
                xPlayer = true;
            }
            return true;

        } else {
            return false;
        }

    }

    public Mark getMarkAt(int row, int col) {
        return board[row][col];
    }

    public Result getResult() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == Mark.XMARK) {
                    return Result.XWIN;
                } else if (board[i][0] == Mark.OMARK){
                    return Result.OWIN;
                }
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == Mark.XMARK) {
                    return Result.XWIN;
                } else if (board[0][i] == Mark.OMARK){
                    return Result.OWIN;
                }
            }
        }
        if (board[0][0] != Mark.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == Mark.XMARK) {
                return Result.XWIN;
            } else {
                return Result.OWIN;
            }
        } else if (board[0][2] != Mark.EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == Mark.XMARK) {
                return Result.XWIN;
            } else {
                return Result.OWIN;
            }
        } else {
            for (Mark[] marks : board) {
                for (int col = 0; col < board.length; col++) {
                    if (marks[col] == Mark.EMPTY) {
                        return Result.NONE;
                    }
                }
            }
            return Result.TIE;
        }
    }
    
    public String toString() {
        //if board[][] is x add "x" or "o" or " " + "|" etc
        StringBuilder boardString = new StringBuilder();

        for (int row = 0; row < 3; row++) {
            switch (board[row][0]) {

                case EMPTY:
                    boardString.append(" |");
                    break;
                case XMARK:
                    boardString.append("X|");
                    break;
                case OMARK:
                    boardString.append("O|");
                    break;
            }
            switch (board[row][1]) {

                case EMPTY:
                    boardString.append(" |");
                    break;
                case XMARK:
                    boardString.append("X|");
                    break;
                case OMARK:
                    boardString.append("O|");
                    break;
            }
            switch (board[row][2]) {

                case EMPTY:
                    boardString.append(" ");
                    break;
                case XMARK:
                    boardString.append("X");
                    break;
                case OMARK:
                    boardString.append("O");
                    break;
            }
            if (row < 2) {
                boardString.append("\n-----\n");
            }
        }
        return boardString.toString();
    }    

}