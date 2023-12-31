package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		List<ChessPiece> captured = new ArrayList<>();
		
		while(!c1.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(c1, captured);
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.redChessPosition(sc);
				
				boolean[][] possibleMoves = c1.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(c1.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.redChessPosition(sc);
				
				ChessPiece capturedPiece = c1.performChessMove(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
			} catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
		UI.clearScreen();
		UI.printMatch(c1, captured);
		
	}

}
