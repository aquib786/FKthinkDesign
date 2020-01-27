package learnjava;

import java.io.*;
import java.util.*;



interface Game {
	void move();
}

class Computer implements Game{

	public boolean checkchoice(int ch , char board[][]){                        // checking for empty spaces
		if(ch == 1 && board[0][0] == '.') return true;
		if(ch == 2 && board[0][1] == '.') return true;
		if(ch == 3 && board[0][2] == '.') return true;
		if(ch == 4 && board[1][0] == '.') return true;
		if(ch == 5 && board[1][1] == '.') return true;
		if(ch == 6 && board[1][2] == '.') return true;
		if(ch == 7 && board[2][0] == '.') return true;
		if(ch == 8 && board[2][1] == '.') return true;
		if(ch == 9 && board[2][2] == '.') return true;
		else return false;

	}
	public void move(){

	}

	public void move1(char board[][] , int choice){                              // moves of computer
		Random r = new Random();
		int min = 1;
		int max = 9;
		int ch =  r.nextInt((max - min) + 1) + min;
		while(!checkchoice(ch , board)){

			ch = r.nextInt((max - min) + 1) + min;
		}

		switch(ch){
			case 1:                                  

				if(choice == 1){
					board[0][0] = 'X';
				}
				else{
					board[0][0] = 'O';
				}
				break;
			case 2:
				if(choice == 1){
					board[0][1] = 'X';
				}
				else{
					board[0][1] = 'O';
				}
				break;
			case 3:
				if(choice == 1){
					board[0][2] = 'X';
				}
				else{
					board[0][2] = 'O';
				}
				break;
			case 4:
				if(choice == 1){
					board[1][0] = 'X';
				}
				else{
					board[1][0] = 'O';
				}
				break;
			case 5:
				if(choice == 1){
					board[1][1] = 'X';
				}
				else{
					board[1][1] = 'O';
				}
				break;
			case 6:
				if(choice == 1){
					board[1][2] = 'X';
				}
				else{
					board[1][2] = 'O';
				}
				break;
			case 7:
				if(choice == 1){
					board[2][0] = 'X';
				}
				else{
					board[2][0] = 'O';
				}
				break;
			case 8:
				if(choice == 1){
					board[2][1] = 'X';
				}
				else{
					board[2][1] = 'O';
				}
				break;
			case 9:
				if(choice == 1){
					board[2][2] = 'X';
				}
				else{
					board[2][2] = 'O';
				}
				break;
			default:
				System.out.println("Wrong Choice");

		}


	}
}

class Human implements Game{
	Scanner sc = new Scanner(System.in);


	public void move(){

	}

	public boolean checkchoice(int ch , char board[][]){                            //checking for empty spaces
		if(ch == 1 && board[0][0] == '.') return true;
		if(ch == 2 && board[0][1] == '.') return true;
		if(ch == 3 && board[0][2] == '.') return true;
		if(ch == 4 && board[1][0] == '.') return true;
		if(ch == 5 && board[1][1] == '.') return true;
		if(ch == 6 && board[1][2] == '.') return true;
		if(ch == 7 && board[2][0] == '.') return true;
		if(ch == 8 && board[2][1] == '.') return true;
		if(ch == 9 && board[2][2] == '.') return true;
		else return false;

	}
	public void move1(char board[][] , int human){
		int ch = sc.nextInt();
		while(!checkchoice(ch , board)){
			System.out.println("Position Already Filled :  Enter Again your choice");
			ch = sc.nextInt();
		}
		switch(ch){
			case 1:

				if(human == 1){
					board[0][0] = 'X';
				}
				else{
					board[0][0] = 'O';
				}
				break;
			case 2:
				if(human == 1){
					board[0][1] = 'X';
				}
				else{
					board[0][1] = 'O';
				}
				break;
			case 3:
				if(human == 1){
					board[0][2] = 'X';
				}
				else{
					board[0][2] = 'O';
				}
				break;
			case 4:
				if(human == 1){
					board[1][0] = 'X';
				}
				else{
					board[1][0] = 'O';
				}
				break;
			case 5:
				if(human == 1){
					board[1][1] = 'X';
				}
				else{
					board[1][1] = 'O';
				}
				break;
			case 6:
				if(human == 1){
					board[1][2] = 'X';
				}
				else{
					board[1][2] = 'O';
				}
				break;
			case 7:
				if(human == 1){
					board[2][0] = 'X';
				}
				else{
					board[2][0] = 'O';
				}
				break;
			case 8:
				if(human == 1){
					board[2][1] = 'X';
				}
				else{
					board[2][1] = 'O';
				}
				break;
			case 9:
				if(human == 1){
					board[2][2] = 'X';
				}
				else{
					board[2][2] = 'O';
				}
				break;
			default:
				System.out.println("Wrong Choice");

		}
	}
}


class TickTackToe{

	Scanner sc = new Scanner(System.in);
	int n = 3;
	char[][] board = new char[n][n];



	public boolean check(){

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

	public void display(){
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++ ){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void displayChoice(){
		int k = 0;
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++ ){
				System.out.print(++k + " ");
			}
			System.out.println();
		}
	}



	public void Play(int choice) {

		Human human = new Human();
		Computer computer = new Computer();
		if (choice == 1) {
			boolean Human1 = true;
			int count = 0;
			while (true) {
				count++;
				System.out.println();
				display();
				displayChoice();
				if (Human1) {
					System.out.println("Human1 Choice");
					human.move1(board,1);

					Human1 = false;
				} else {
					System.out.println("Human2 Choice");
					human.move1(board,0);
					Human1 = true;
				}
				if (check()) {
					display();
					System.out.println("Game Ended");
					if(Human1){
						System.out.println("Human2 wins");
					}
					else{
						System.out.println("Human1 wins");
					}
					break;
				}
				if(count == 9){
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
				display();
				displayChoice();

				if (Human1) {
					System.out.println("Human Choice");
					human.move1(board,1);

					Human1 = false;
				} else {

					System.out.println("Computer Choice ");
					computer.move1(board , 0);

					Human1 = true;
				}
				if (check()) {
					display();
					System.out.println("Game Ended");
					if(Human1){
						System.out.println("Computer wins");
					}
					else{
						System.out.println("Human wins");
					}
					break;
				}
				if(count == 9){
					System.out.println("Draw");
					break;
				}
			}
		} else if (choice == 3) {
			boolean Comp = true;
			int count = 0;
			while (true) {
				count++;
				System.out.println();
				display();
				displayChoice();
				if (Comp) {
					System.out.println("Human1 Choice");
					computer.move1(board,1);

					Comp = false;
				} else {
					System.out.println("Human2 Choice");
					computer.move1(board,0);
					Comp= true;
				}
				if (check()) {
					display();
					System.out.println("Game Ended");
					if(Comp){
						System.out.println("Computer2 wins");
					}
					else{
						System.out.println("Computer1 wins");
					}
					break;
				}
				if(count == 9){
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
	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		TickTackToe ttt = new TickTackToe();

		for(int i = 0 ; i < ttt.n ;i++){
			for(int j = 0 ; j < ttt.n ; j++){
				ttt.board[i][j] = '.';
			}
		}
		System.out.println("Enter the mode\n 1. Human v/s Human \n 2. Human v/s Computer \n 3. Computer v/s Computer");
		int ch = sc1.nextInt();

		ttt.Play(ch);
	}
}