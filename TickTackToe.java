package learnjava;

import java.io.*;
import java.util.*;



interface Game {
	void move1(char[][] x , int y);
}
class Grid{
	int row;
	int column;
	char[][] board;

	Grid(int row , int column){

		this.row = row;
		this.column = column;
		board = new char[row][column];
		for(int i = 0 ; i < row ; i++ ){

			for(int j = 0 ; j < column ; j++){
				board[i][j] = '.';
			}
		}
	}

	public void display(){
		for(int i = 0 ; i < row ; i++){
			for(int j = 0 ; j < column ; j++ ){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
}

class Checker{

	public boolean checkRow(Grid obj){
		int n = obj.board.length;
		int countX = 0;
		int countO = 0;
		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++){
				if(obj.board[i][j] == 'X'){
					countX++;
				}
				if(obj.board[i][j] == 'O'){
					countO++;
				}
			}
			if(countX == 3 || countO == 3)
				return true;

		}
		return false;
	}
	public boolean checkColumn(Grid obj){
		int n = obj.board.length;
		int countX = 0;
		int countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++){
				if(obj.board[j][i] == 'X'){
					countX++;
				}
				if(obj.board[j][i] == 'O'){
					countO++;
				}
			}
			if(countX == 3 || countO == 3)
				return true;

		}
		return false;
	}
	public boolean checkDiagonal(Grid obj){
		int n = obj.board.length;
		int countX = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if (i == j && obj.board[i][j] == 'X')
					countX++;
			}
			if(countX == 3) return true;
		}

		countX = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if ((i+j+1) == n  && obj.board[i][j] == 'X')
					countX++;
			}
			if(countX == 3) return true;
		}

		int countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if (i == j && obj.board[i][j] == 'O')
					countO++;
			}
			if(countO == 3) return true;
		}

		countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if ((i+j+1) == n  && obj.board[i][j] == 'O')
					countO++;
			}
			if(countO == 3) return true;
		}
		return false;
	}

	public boolean check(Grid obj){

		int n = obj.board.length;
		int countX = 0;
		int countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++){
				if(obj.board[j][i] == 'X'){
					countX++;
				}
				if(obj.board[j][i] == 'O'){
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
				if(obj.board[i][j] == 'X'){
					countX++;
				}
				if(obj.board[i][j] == 'O'){
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
				if (i == j && obj.board[i][j] == 'X')
					countX++;
			}
			if(countX == 3) return true;
		}

		countX = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if ((i+j+1) == n  && obj.board[i][j] == 'X')
					countX++;
			}
			if(countX == 3) return true;
		}

		countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if (i == j && obj.board[i][j] == 'O')
					countO++;
			}
			if(countO == 3) return true;
		}

		countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if ((i+j+1) == n  && obj.board[i][j] == 'O')
					countO++;
			}
			if(countO == 3) return true;
		}
		return false;
	}
	public char check_return(Grid obj){

		int n = obj.board.length;
		int countX = 0;
		int countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++){
				if(obj.board[j][i] == 'X'){
					countX++;
				}
				if(obj.board[j][i] == 'O'){
					countO++;
				}
			}
			if(countX == n )
				return 'X';
			else if(countO == n)
				return 'O';
			else {
				countX = 0;
				countO = 0;
			}
		}
		countX = 0;
		countO = 0;
		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++){
				if(obj.board[i][j] == 'X'){
					countX++;
				}
				if(obj.board[i][j] == 'O'){
					countO++;
				}
			}
			if(countX == n )
				return 'X';
			else if(countO == n)
				return 'O';
			else {
				countX = 0;
				countO = 0;
			}
		}

		countX = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if (i == j && obj.board[i][j] == 'X')
					countX++;
			}
			if(countX == n) return 'X';
		}

		countX = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if ((i+j+1) == n  && obj.board[i][j] == 'X')
					countX++;
			}
			if(countX == n) return 'X';
		}

		countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if (i == j && obj.board[i][j] == 'O')
					countO++;
			}
			if(countO == n) return 'O';
		}

		countO = 0;

		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < n ; j++ ) {
				if ((i+j+1) == n  && obj.board[i][j] == 'O')
					countO++;
			}
			if(countO == n) return 'O';
		}
		return 'K';
	}

	public boolean checkchoice(int x , int y , char[][] board){

		if(x < 0 || x >= board.length || y < 0 || y >= board.length||board[x][y] != '.')  return true;
		else return false;

	}

	public boolean checkFilledGrid(Grid obj){
		for(int i = 0 ; i < obj.board.length ; i++){
			for(int j = 0 ; j < obj.board.length ; j++){
				if(obj.board[i][j] == '.')
					return false;
			}
		}
		return true;
	}


}
class Computer extends Checker implements Game{

	public void move1(char board[][] , int choice){
		Grid g = new Grid(board.length , board.length);

		int x = new Random().nextInt(g.getRow());
		int y = new Random().nextInt(g.getColumn());
		while( checkchoice(x,y,board) )
		{
			x = new Random().nextInt(g.getRow());
			y = new Random().nextInt(g.getColumn());

		}

		if(choice == 1){
			board[x][y] = 'X';
		}
		else{
			board[x][y] = 'O';
		}
	}
}

class Human extends Checker implements Game{
	Scanner sc = new Scanner(System.in);

	public void move1(char board[][], int human){
		int x = sc.nextInt();
		int y = sc.nextInt();

		while(checkchoice(x,y ,board)){
			System.out.println("Position Already Filled :  Enter Again your choice");
			x = sc.nextInt();
			y = sc.nextInt();
		}
		if(human == 1){
			board[x][y] = 'X';
		}
		else{
			board[x][y] = 'O';
		}

	}
}
class Play extends Checker
{
	Scanner sc = new Scanner(System.in);
	public char play(Grid obj , int choice) {

		Human human = new Human();
		Computer computer = new Computer();
		if (choice == 1) {
			boolean Human1 = true;
			int count = 0;
			while (true) {

				System.out.println();
				obj.display();
				if (check(obj)) {
					if(Human1){
						return 'O';
					}
					else{
						return 'X';
					}
				}
				if(checkFilledGrid(obj)){
					obj.display();
					return '_';
				}
				if (Human1) {
					System.out.println("Human1 Choice");
					human.move1(obj.board,1);

					Human1 = false;
				} else {
					System.out.println("Human2 Choice");
					human.move1(obj.board,0);
					Human1 = true;
				}

			}
		}
		else if (choice == 2) {
			boolean Human1 = true;
			int count = 0;
			while (true) {
				obj.display();
				if (check(obj)) {


					if(Human1){
						return 'O';
					}
					else{
						return 'X';

					}

				}
				if(checkFilledGrid(obj)){

					return '_';
				}
				if (Human1) {
					System.out.println("Human Choice");
					human.move1(obj.board,1);

					Human1 = false;
				} else {

					System.out.println("Computer Choice ");
					computer.move1(obj.board , 0);

					Human1 = true;
				}

			}
		}
		else if (choice == 3) {
			boolean Comp = true;
			int count = 0;
			while (true) {

				System.out.println();
				obj.display();
				if (check(obj)) {

					if(Comp){
						return 'O';
					}
					else{
						return 'X';
					}
				}
				if(checkFilledGrid(obj)){
					return '_';


				}
				if (Comp) {
					System.out.println("Computer1 Choice");
					computer.move1(obj.board,1);
					Comp = false;
				} else {
					System.out.println("Computer2 Choice");
					computer.move1(obj.board,0);
					Comp= true;
				}


			}
		}
		else{
			System.out.println("Wrong Choice");
			return '/';
		}

	}
	public void PlayExtension(Grid obj , int choice){

		while(true){
			int dimension = obj.board.length;
			System.out.println(dimension);

			Grid new_grid = new Grid(dimension/3 , dimension/3);
			int block_number1 = 0;
			for(int i = 0 ; i < dimension ; i+=3 ){
				for(int j = 0 ; j < dimension ; j += 3){
					System.out.println("Play BLock number" + ++block_number1);
					Grid small = new Grid(dimension/3 , dimension/3);
					int k = 0, l = 0;

					new_grid.board[i/3][j/3] = play(small , choice);

					for(int row = i ; row < i+3 && k < small.board.length ; row++,k++ ){
						l = 0;
						for(int col = j ; col < j+3 && l < small.board.length; col++,l++){
							obj.board[row][col] = small.board[k][l];
						}
					}
					System.out.println(".......................");
					obj.display();
					char check_the_grid = check_return(new_grid);
					if(check_the_grid == 'X'){

						System.out.println("Player1 wins");
						return;

					}
					else if(check_the_grid=='O'){
						System.out.println("Player2 wins");
						return;
					}

				}
			}

			break;
		}
	}
}
class TickTackToe{

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the size: rows and columns");
		int row = sc1.nextInt();
		int column = sc1.nextInt();

		Grid obj = new Grid(row,column);
		Play tt = new Play();

		System.out.println("Enter the mode\n 1. Human v/s Human \n 2. Human v/s Computer \n 3. Computer v/s Computer");
		int ch = sc1.nextInt();

		tt.PlayExtension(obj , ch);
	}
}