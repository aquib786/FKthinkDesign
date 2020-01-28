package learnjava;

import java.io.*;
import java.util.*;


class Grid{
	char board[][];
	int rows, columns;


	Grid(int rows , int columns){
		this.rows = rows;
		this.columns =columns;
		board = new char[rows][columns];

		for(int i = 0 ; i < rows ; i++){
			for(int j = 0 ; j < columns ; j++){
				board[i][j] = '.';
			}
		}
	}

	public void display(){
		for(int i = 0 ; i < rows  ; i++){
			for(int j = 0 ; j < columns ; j++ ){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void Fill_Board(int choice  , int x , int y){
		if(choice == 1){
			board[x][y] = 'X';
		}
		else{
			board[x][y] = 'O';
		}
	}
}
class Checker{
	public boolean checkchoice(int x, int y , Grid obj){
		if(x < 0 || x >= obj.rows || y < 0 || y >= obj.columns) return false;
		if(obj.board[x][y] == '.') return true;
		return false;
	}

	public boolean check1(char box[][], int rows  , int columns){


		char board[][] = new char[3][3];
		int n = 3;
		int k = 0 , m = 0;
		for(int i = rows ; i < rows+3 ; i++ , k++ ){
			m = 0;
			for(int j = columns ; j < columns + 3 ; j++ , m++){
				board[k][m] = box[i][j];
			}
		}
		int countX = 0;
		int countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++){
				if(board[j][i] == 'X'){
					countX++;
				}
				if(board[j][i] == 'O'){
					countO++;
				}
			}
			if(countX == 3 || countO == 3)
				return true;
			else {
				countX = 0;
				countO = 0;
			}
		}
		countX = 0;
		countO = 0;
		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++){
				if(board[i][j] == 'X'){
					countX++;
				}
				if(board[i][j] == 'O'){
					countO++;
				}
			}
			if(countX == 3 || countO == 3)
				return true;
			else {
				countX = 0;
				countO = 0;
			}
		}

		countX = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if (i == j && board[i][j] == 'X')
					countX++;
			}
			if(countX == 3) return true;
		}

		countX = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if ((i+j+1) == n  && board[i][j] == 'X')
					countX++;
			}
			if(countX == 3) return true;
		}

		countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if (i == j && board[i][j] == 'O')
					countO++;
			}
			if(countO == 3) return true;
		}

		countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if ((i+j+1) == n  && board[i][j] == 'O')
					countO++;
			}
			if(countO == 3) return true;
		}
		return false;
	}




	public boolean check(Grid obj,int choice){

		int rows = obj.rows;
		int columns = obj.columns;
		int dimension = rows;


		char[][] current = obj.board;
		int p = 0;
		while(dimension != 1){

			char[][] temp = new char[dimension/3][dimension/3];
			int limit = dimension/3;
			int k = 0 , m = 0;
			for(int i = 0 ; i < dimension && k < limit ; i+=3 , k++){
				m = 0;
				for(int j = 0 ; j < dimension && m < limit; j += 3 , m++)
				{
					if(check1(current , i , j)) {
						temp[k][m] = (choice == 1) ? 'X' : 'O';
					}
					else {
						temp[k][m] = '.';
					}
				}
			}

			current = temp;
			dimension /= 3;

		}
		if(current[0][0] == 'X' || current[0][0] == 'O') return true;
		return false;
	}


}
class Human extends Checker {
	Scanner sc = new Scanner(System.in);

	public void move1(Grid obj, int human){
		System.out.println("Enter your pos: x & y");
		int x = sc.nextInt();
		int y = sc.nextInt();
		while(!checkchoice(x,y , obj)){
			System.out.println("Not a position to fill:  Enter Again your choice");
			x = sc.nextInt();
			y = sc.nextInt();
		}
		obj.Fill_Board(human,x,y);
	}
}
class Computer extends Checker {
	public void move1(Grid obj, int choice){                              // moves of computer

		for(int i = 0 ; i < obj.rows ; i++) {
			for (int j = 0; j < obj.columns; j++) {
				if (checkchoice(i, j, obj)) {
					obj.Fill_Board(choice, i, j);
					return;
				}
			}
		}
	}
}



class Play {

	public void Play3_3(int choice, Grid obj) {

		Human human = new Human();
		Computer computer = new Computer();
		Checker ch_obj = new Checker();

		if (choice == 1) {
			boolean Human1 = true;
			int count = 0;
			while (true) {
				count++;
				System.out.println();
				obj.display();

				if (Human1) {
					System.out.println("Human1 Choice");
					human.move1(obj, 1);

					Human1 = false;
				} else {
					System.out.println("Human2 Choice");
					human.move1(obj, 0);
					Human1 = true;
				}
				if (ch_obj.check(obj,choice)) {
					obj.display();
					System.out.println("Game Ended");
					if (Human1) {
						System.out.println("Human2 wins");
					} else {
						System.out.println("Human1 wins");
					}
					break;
				}
				if (count == obj.rows*obj.columns) {
					System.out.println();
					System.out.println("Draw");
					break;
				}
			}
		}
		else if (choice == 2) {
			boolean Human1 = true;
			int count = 0;
			while (true) {
				count++;
				System.out.println();
				obj.display();


				if (Human1) {
					System.out.println("Human Choice");
					human.move1(obj,1);

					Human1 = false;
				} else {

					System.out.println("Computer Choice ");
					computer.move1(obj, 0);

					Human1 = true;
				}
				if (ch_obj.check(obj,choice)) {
					obj.display();
					System.out.println("Game Ended");
					if(Human1){
						System.out.println("Computer wins");
					}
					else{
						System.out.println("Human wins");
					}
					break;
				}
				if(count == obj.rows*obj.columns){
					System.out.println("Draw");
					break;
				}
			}
		}
		else if (choice == 3) {
			boolean Comp = true;
			int count = 0;
			while (true) {
				count++;
				System.out.println();
				obj.display();

				if (Comp) {
					System.out.println("Computer1 Choice");
					computer.move1(obj,1);

					Comp = false;
				} else {
					System.out.println("Computer2 Choice");
					computer.move1(obj,0);
					Comp= true;
				}
				boolean result = ch_obj.check(obj,choice);

				if (result) {
					obj.display();
					System.out.println("Game Ended");
					if(Comp){
						System.out.println("Computer2 wins");
					}
					else{
						System.out.println("Computer1 wins");
					}
					break;
				}
//				System.out.println(count);
				if(count == obj.rows*obj.columns){
					System.out.println("Draw");
					break;
				}
			}
		}
		else{
				System.out.println("Wrong Choice");
				return;
		}


	}
}
class TickTackToe{

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Play p = new Play();

		System.out.println("Enter the size of the grid: rows and columns");
		int rows = sc1.nextInt();
		int columns = sc1.nextInt();

		Grid box = new Grid(rows,columns);


		System.out.println("Enter the mode\n 1. Human v/s Human \n 2. Human v/s Computer \n 3. Computer v/s Computer");
		int ch = sc1.nextInt();

		p.Play3_3(ch , box);
	}
}