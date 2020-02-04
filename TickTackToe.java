package learnjava;

import java.io.*;
import java.util.*;



interface Game {
	void move1(Grid x , int y);
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
class Printer{
	ArrayList<Grid> state = new ArrayList<>();
	int player1;
	int player2;
	int block;
	Printer(){
		player1 = 0;
		player2 = 0;
		block = 0;

	}
	void count_increment_palyer1(){
		this.player1++;
	}
	void count_increment_palyer2(){
		this.player2++;
	}
	void statics(){
		System.out.println("Player1 won games of 3*3 " + this.player1);
		System.out.println("Player2 won games of 3*3 " + this.player2);
	}
	void print_block(){
		this.block++;
		System.out.println("Currently Playing block no. " + this.block);
	}
	public void print(){
		for(Grid iter : state){
			iter.display();
			System.out.println();
		}
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
		return '_';
	}

	public boolean checkchoice(int x , int y , Grid obj){

		if(x < 0 || x >= obj.board.length || y < 0 || y >= obj.board.length || obj.board[x][y] != '.')  return true;
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

	public void move1(Grid obj , int choice){
		Grid g = new Grid(obj.board.length , obj.board.length);

		int x = new Random().nextInt(g.getRow());
		int y = new Random().nextInt(g.getColumn());
		while( checkchoice(x,y,obj) )
		{
			x = new Random().nextInt(g.getRow());
			y = new Random().nextInt(g.getColumn());

		}

		if(choice == 1){
			obj.board[x][y] = 'X';
		}
		else{
			obj.board[x][y] = 'O';
		}
	}
}

class Human extends Checker implements Game{
	Scanner sc = new Scanner(System.in);

	public void move1(Grid obj, int human){
		int x = sc.nextInt();
		int y = sc.nextInt();
		while(true){
			System.out.println("Do you want to change your choice: 1.Renter  2. Continue");
			int choice = sc.nextInt();
			if(choice == 1){
				x = sc.nextInt();
				y = sc.nextInt();
			}
			else if(choice == 2){
				break;
			}
			else{
				System.out.println("Wrong Choice");
			}
		}
		while(checkchoice(x,y ,obj)){
			System.out.println("Position Already Filled :  Enter Again your choice");
			x = sc.nextInt();
			y = sc.nextInt();
		}
		if(human == 1){
			obj.board[x][y] = 'X';
		}
		else{
			obj.board[x][y] = 'O';
		}

	}
}
class Play extends Checker {
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
						return 'X';
					}
					else{
						return 'O';
					}
				}
				if(checkFilledGrid(obj)){
					return '_';
				}
				if (Human1) {
					System.out.println("Human1 Choice");
					human.move1(obj,1);

					Human1 = false;
				} else {
					System.out.println("Human2 Choice");
					human.move1(obj,0);
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
						return 'X';
					}
					else{
						return 'O';

					}

				}
				if(checkFilledGrid(obj)){

					return '_';
				}
				if (Human1) {
					System.out.println("Human Choice");
					human.move1(obj,1);

					Human1 = false;
				} else {

					System.out.println("Computer Choice ");
					computer.move1(obj , 0);

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
						return 'X';
					}
					else{
						return 'O';
					}
				}
				if(checkFilledGrid(obj)){
					return '_';


				}
				if (Comp) {
					System.out.println("Computer1 Choice");
					computer.move1(obj,1);
					Comp = false;
				} else {
					System.out.println("Computer2 Choice");
					computer.move1(obj,0);
					Comp= true;
				}


			}
		}
		else{
			System.out.println("Wrong Choice");
			return '/';
		}

	}
	char PlayExtension(Grid obj , int choice , Printer game){

		int dimension = obj.board.length;
		int size = dimension/3;

		Grid new_grid = new Grid(3,3);

		if(dimension > 3){

			Grid small_grid = new Grid(dimension/3 , dimension/3);
			int count = 0 ;
			for(int i = 0 ; i < dimension ; i+=dimension/3 ){
				for(int j = 0 ; j < dimension ; j += dimension/3){

					new_grid.board[i/size][j/size] = PlayExtension(small_grid , choice,game);
					char ch = check_return(new_grid);
					if(ch == 'X'){

						return ch;
					}
					else if(ch == 'O'){

						return ch;
					}
				}
			}


		}
		else {
			game.print_block();
			char ch = play(new_grid , choice);
			if(ch == 'X'){
				game.count_increment_palyer2();
				return ch;
			}
			else if(ch == 'O'){
				game.count_increment_palyer1();
				return ch;
			}
			game.state.add(new_grid);
			return ch;
		}

		return ';';
	}
	public void start_game(Grid obj , int choice){
		Printer game = new Printer();
		char ch = PlayExtension(obj , choice , game);
		game.statics();
		if(ch == 'X'){
			System.out.println("Player2 wins");
		}
		else if(ch == 'O'){
			System.out.println("Player1 wins");
		}
		else{
			System.out.println("Draw");
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

		tt.start_game(obj , ch);
	}
}