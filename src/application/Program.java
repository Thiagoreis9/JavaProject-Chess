package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch c1 = new ChessMatch();
		UI.printBoard(c1.getPieces());
		
	}

}
