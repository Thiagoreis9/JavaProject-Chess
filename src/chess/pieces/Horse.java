package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Horse extends ChessPiece{

	public Horse(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "H";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
}
