package sudoku_solver;

import java.util.*;
public class Main {
	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		int row, col, number=1;
		int[][] board= {{7,0,2,0,5,0,6,0,0},
				{0,0,0,0,0,3,0,0,0},
				{1,0,0,0,0,9,5,0,0},
				{8,0,0,0,0,0,0,9,0},
				{0,4,3,0,0,0,7,5,0},
				{0,9,0,0,0,0,0,0,8},
				{0,0,9,7,0,0,0,0,5},
				{0,0,0,2,0,0,0,0,0},
				{0,0,7,0,4,0,2,0,3}};
		printBoard(board);
		System.out.println("---------------------");
		//solveBoard(board);
		/*while(number!=0) {
			System.out.println("Enter row and column: ");
			row= sc.nextInt();
			col= sc.nextInt();
			System.out.println("Enter the number(to exit enter 0): ");
			number= sc.nextInt();
			
			if(board[row][col]!=0) {
				System.out.println("Invalid Move and Already filled");
			}
			
			else if(isValidMove(board, number, row, col)) {
				board[row][col]= number;
			}
			else {
				System.out.println("Invalid Move");
			}
			printBoard(board);
		}
		if(number== 0) {
			System.out.println("Successfully Exit!!!");
			printBoard(board);
			
		}*/
		if(solveBoard(board)) {
			System.out.println("Successfully Solved");
			printBoard(board);
		}
		else {
			System.out.println("Can't Solved");
			printBoard(board);
		}
			
	}

	private static void printBoard(int[][] board) {
		// TODO Auto-generated method stub
		for(int i=0; i<9; i++) {
			
			for(int j=0; j<9; j++) {
				
				
				System.out.print(board[i][j]+" ");
				if((j+1)%3==0) {
					System.out.print("|");
				}
				
			}
			System.out.println();
			if((i+1)%3==0){
				System.out.println("_____________________");
			}
			
		}
		
	}

	private static boolean isValidMove(int[][] board, int number, int row, int col) {
		// TODO Auto-generated method stub
		if(isValidRow(board, number, row)&&
		isValidColumn(board, number, col)&&
		isValidInBox(board, number, row, col)) 
		{
			return true;
		}
		return false;
		
	}

	private static boolean isValidInBox(int[][] board, int number, int row, int col) {
	    int boxStartRow = row - row % 3;
	    int boxStartCol = col - col % 3;
	    
	    for (int i = boxStartRow; i < boxStartRow + 3; i++) {
	        for (int j = boxStartCol; j < boxStartCol + 3; j++) {
	            if (board[i][j] == number) {
	                return false;
	            }
	        }
	    }
	    return true;
	}


	private static boolean isValidColumn(int[][] board, int number, int col) {
		for(int i=0; i<9; i++) {
			if(board[i][col]== number) {
				return false;
			}
		}
		// TODO Auto-generated method stub
		return true;
		
	}

	private static boolean isValidRow(int[][] board, int number, int row) {
		// TODO Auto-generated method stub
		for(int i=0; i<9; i++) {
			if(board[row][i]== number) {
				return false;
			}
		}
		return true;
		
	}
	private static boolean solveBoard(int[][] board) {
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(board[i][j]==0) {
					for(int trynumber= 1; trynumber<=9; trynumber++) {
						if(isValidMove(board, trynumber, i, j)) {
							board[i][j]= trynumber;
							if(solveBoard(board)) {
								return true;
							}
							else {
								board[i][j]= 0;
							}
						}
					}
					return false;
				}
			}
		}
		
		
		return true;
	}
}
