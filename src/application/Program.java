package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ChessMatch c1 = new ChessMatch();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printBoard(c1.getPieces());
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.redChessPosition(sc);
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.redChessPosition(sc);
				
				ChessPiece capturedPiece = c1.performChessMove(source, target);
			} catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
		
	}

}
