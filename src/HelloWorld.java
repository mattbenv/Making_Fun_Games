
//This is going to be a class that defines the p[arameters for the gane
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.io.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class HelloWorld {

    public static Player[] start_game(int rolled_dice, int comp_dice){
        Scanner myObj = new Scanner(System.in);
        char symbol;
        Player[] array_player = new Player[2];
        //This is just defing whose turn it is and what the players turn and character is.
        if (rolled_dice > comp_dice){
            System.out.println("That malware just said you won that gambling dice toss!");
            System.out.println("looks like you lost again likke the chess match last night!! MATTS UP");
            System.out.println("Enter X or O for your choice of symbol: ");
            symbol = myObj.next().charAt(0);
            Player player1 = new Player(true,symbol);
            if(symbol == 'o'){
                Player computer = new Player(false,'x');
                array_player[1] = computer;
            }else{
                Player computer = new Player(false,'o');
                array_player[1] = computer;
            }
            array_player[0]= player1;
        }else{
            System.out.println("it is clearly Stephanies TURN!!!");
            System.out.println("Steph just chose the dominate piece X RULES X X X ");
            Player player1 = new Player(false,'o');
            Player computer = new Player(true,'x');
            array_player[0]= player1;
            array_player[1] = computer;
        }
        return array_player;
    }
    public static void dictionarytest(){
        Dictionary<String, String> riddles = new Hashtable<String, String>();
        /*Scanner riddles1 = new Scanner(new File("C:\\users\\riddles.csv"));
        riddles1.useDelimiter(",");   //sets the delimiter pattern
        while (riddles1.hasNext())  //returns a boolean value
        {
            System.out.print(riddles1.next());  //find and returns the next complete token from this scanner
        }
        riddles1.close();  //closes the scanner*/
        System.out.println("---------------------------------------------------------------!?!?!?!?!?!?!?!Riddle me this vengeance?!?!?!?!?!?---------------------------------------------------------------");
        //I am goin gto try playing around with the buffer reader
        String line = "";
        String splitBy = ",";
        int counter = 0;
        try
        {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("C:\\users\\riddles.csv"));
            String[] string_riddles = new String[200];
            String[] riddle_answer = new String[200];
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] linefromcsv = line.split(splitBy);    // use comma as separator
                System.out.println("answer= " + linefromcsv[1] +"  riddle: " + linefromcsv[0]);
                string_riddles[counter] = linefromcsv[1];
                riddles.put(linefromcsv[0],linefromcsv[1]);
                counter++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(counter);
        System.out.println("---------------------------------------------------------------TESTING DICTIONARY-------------------------------------------------------------------------------");
        System.out.println(riddles.get("nose"));
        Enumeration enu = riddles.keys();
        Enumeration elements = riddles.elements();
        while (enu.hasMoreElements()) {
            System.out.print("KEY_VALUE: ");
            System.out.print(enu.nextElement());
            System.out.print("  ,RIDDLE: ");
            System.out.println(elements.nextElement());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }
    public static void printboard(char[][] board){
        for (int i=0; i<board.length; i++){
            System.out.print("| ");
            for(int j=0; j<board[0].length;j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
    public static boolean isboardfull(char[][] board){
        for (int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length;j++) {
                if(board[i][j]== '\u0000'){
                    return false;
                }
            }
        }
        return true;
    }

    //returns true if there is winnner in a row
    public static boolean checkrows(char[][] board){
        for (int i=0; i<board.length; i++){
            if(board[i][0]== board[i][1] && board[i][0]==board[i][2]){
                System.out.println("There is a row winner");
                return true;
            }
        }
        return false;
    }

    //returns true if there is winner in the columns
    public static boolean checkcolumns(char[][] board){
        for (int i=0; i<board.length; i++){
            if(board[0][i]== board[1][i] && board[0][i]==board[2][i]){
                System.out.println("There is a column winner");
                return true;
            }
        }
        return false;
    }

    //checks a diagnol winner true if there is a diagnol winner
    public static boolean checkdiagnols(char[][] board){
        for (int i=0; i<board.length; i++){
            if((board[0][0]== board[1][1] && board[0][0]==board[2][2])||(board[0][2]== board[1][1] && board[0][2]==board[2][0])) {
                System.out.println("There is a diagnol winner");
                return true;
            }
        }
        return false;
    }
    public static boolean checkwinner(char[][] board){
        if(checkrows(board)|| checkcolumns(board)|| checkdiagnols(board)){
            return true;
        }
        return false;

    }
    public static void gamelogic(char[][] board,Player player1, Player computer){
        boolean player_turn = player1.isTurn();
        char player_piece = player1.getSymbol();

        boolean computer_turn = computer.isTurn();
        char computer_piece = computer.getSymbol();

        while(checkwinner(board)== false || isboardfull(board) == false ){
            //Logic for the user
            if(player_turn == true){
                printboard(board);
                System.out.println("Matt please enter a position on the board: ");
                Scanner position = new Scanner(System.in);
                int num;
                int row;
                int col;
                num = position.nextInt();
                col = num %3;
                row = num/3;
                while(board[row][col]=='x' || board[row][col]=='o'){
                    System.out.println("That position is taken, try again! ");
                    num = position.nextInt();
                    col = num %3;
                    row = num/3;
                }
                board[row][col]= player_piece;
                player_turn = false;
                printboard(board);
                System.out.println("---------------------------------------------------------------");
                //The else below is the logic for player 2 or the user.
            }else{
                printboard(board);
                System.out.println("steph please enter your position on board:");
                Scanner computer_scanner = new Scanner(System.in);
                int num;
                int row;
                int col;
                num = computer_scanner.nextInt();
                col =num %3;
                row = num/3;
                while(board[row][col]=='x' || board[row][col]=='o'){
                    System.out.println("That position is taken, tr a new spot");
                    num = computer_scanner.nextInt();
                    col = num %3;
                    row = num/3;
                }
                board[row][col]= computer_piece;
                player_turn = true;
                printboard(board);
                System.out.println("---------------------------------------------------------------");
            }
        }
    }

    //This function iterates through the 9 boards and prints each one down!
    public static void print3dboard(char[][][] board1, char[] numbers){
        int counter = 0;
        for(int i=0; i<board1.length;i++){
            for(int j=0; j<board1.length;j++){
                counter = 0;
                for( int k=0;k<board1[0][0].length;k++){
                    board1[i][j][k] = numbers[counter];
                    counter ++;
                }
            }
        }
        for(int i=0; i<board1.length;i++){
            for(int j=0; j<board1.length;j++){
                for( int k=0;k<board1[0][0].length;k++){
                    System.out.print(board1[i][j][k]);
                    if( k %3 ==2){
                        System.out.println("");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println("-----------------");
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        char[][] board = new char[3][3];
        char[] numbers = new char[]{ '0','1','2','3','4','5','6','7','8'};
        char[][][] board1 = new char[3][3][9];

        print3dboard(board1, numbers);
        System.out.println(board1[0][0][8]);
        //The last component is the index, the other components are the board number boards 1-9--> (0,0), (0,1), (0,2), (1,0), (1,1), (1,2), (2,0), (2,1), (2,2)
        int counter = 0;
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board.length;j++){
                board[i][j]= numbers[counter];
                counter= counter+1;
            }
        }
        int rolled_dice;
        int comp_dice;
        Player[] data_players;
        Random rand = new Random();
        dictionarytest(); //Grabs the local riddles on my local machine in a comma seperated csv file.
        System.out.println("Roll the motherfucking dice to see if you go first or second: ");
        rolled_dice = rand.nextInt(6) + rand.nextInt(6);
        comp_dice = rand.nextInt(6) + rand.nextInt(6);
        System.out.println("matts dice: " + String.valueOf(rolled_dice));
        System.out.println("stephanies dice: " + String.valueOf(comp_dice));
        System.out.println(String.valueOf(comp_dice));
        data_players = start_game(rolled_dice,comp_dice);
        gamelogic(board,data_players[0],data_players[1]);
        System.out.println("Ladys and Gentleman the fat lad has started singing HALALALALALALALALALLALALALALA");


    }
}
