package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        TicTacToeModel model = new TicTacToeModel();


        while (model.getResult() == TicTacToeModel.Result.NONE) {
            System.out.println(model.toString());
            String currentLine = keyboard.nextLine();

            int row = 0, col = 0;
            if (currentLine.length() == 3) {
                row = Character.getNumericValue(currentLine.charAt(0));
                col = Character.getNumericValue(currentLine.charAt(2));
            }

            model.setMarkAt(row, col);
        }

        switch (model.getResult()) {
            case XWIN:
                System.out.println("X wins");
                break;
            case OWIN:
                System.out.println("O wins");
                break;
            case TIE:
                System.out.println("Tie");
                break;
        }
    }
}