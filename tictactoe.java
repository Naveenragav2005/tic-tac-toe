import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe{
    static ArrayList playerpositions = new ArrayList<>();
    static ArrayList cpupositions = new ArrayList<>();
    public static void main(String[] args){
        char[][] gameboard = {{' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '}};

        printgameboard(gameboard);
        
        while(true){
                Scanner scan = new Scanner(System.in);
                System.out.println("enter number from 1 to 9");
                int playerpos = scan.nextInt();
                while(playerpositions.contains(playerpos)||cpupositions.contains(playerpos)){
                System.out.println("position is taken!!! choose a correct position player");
                playerpos = scan.nextInt();
                }
                placepiece(gameboard,playerpos,"player");
                String result = checkwinner(); //this is to check the winner after the player plays the piece because the cpu cant find any empty positon after the palyer moves
                if(result.length()>0){
                    System.out.println(result);
                    break;
                }
                Random rand = new Random();
                int cpupos = rand.nextInt(9) + 1;
                while(playerpositions.contains(cpupos)||cpupositions.contains(cpupos)){
                System.out.println("position is taken!!! choose a correct position");
                cpupos = rand.nextInt(9) + 1;
                }
                placepiece(gameboard,cpupos,"cpu");
                printgameboard(gameboard);
                
                
                result = checkwinner();
                if(result.length()>0){
                    System.out.println(result);
                    break;
                }
                
            

        }

    }


    public static void printgameboard(char[][] gameboard){
        for (char[] row : gameboard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }

    }


    public static void placepiece(char[][] gameboard , int pos, String user){

        char symbol = 'X';

        if(user.equals("player")){
            symbol='X';
            playerpositions.add(pos);
        }
        else if(user.equals("cpu")){
            symbol='O';
            cpupositions.add(pos);
        }


        switch (pos) {
            case 1:
                gameboard[0][0] = symbol;
                break;
            case 2:
                gameboard[0][2] = symbol;
                break;
            case 3:
                gameboard[0][4] = symbol;
                break;
            case 4:
                gameboard[2][0] = symbol;
                break;
            case 5:
                gameboard[2][2] = symbol;
                break;
            case 6:
                gameboard[2][4] = symbol;
                break;
            case 7:
                gameboard[4][0] = symbol;
                break;
            case 8:
                gameboard[4][2] = symbol;
                break;
            case 9:
                gameboard[4][4] = symbol;
                break;
            default:
                break;
        }
        

        

    }

    @SuppressWarnings("unchecked")
    public static String checkwinner(){
        List toprow= Arrays.asList(1,2,3);
        List midrow= Arrays.asList(4,5,6);
        List botrow= Arrays.asList(7,8,9);
        List fcol= Arrays.asList(1,4,7);
        List mcol= Arrays.asList(2,5,8);
        List lcol= Arrays.asList(3,6,9);
        List cross1= Arrays.asList(1,5,9);
        List cross2= Arrays.asList(3,5,7);

        List<List> winning= new ArrayList<>(); 
        winning.add(toprow);
        winning.add(midrow);
        winning.add(botrow);
        winning.add(fcol);
        winning.add(mcol);
        winning.add(lcol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l: winning){
            if(playerpositions.containsAll(l)){
                System.out.println("congratulation player");
            }
            else if(cpupositions.containsAll(l)){
                System.out.println("sorry cpu won");
            }
            else if(playerpositions.size()+cpupositions.size()==9){
                if(playerpositions.containsAll(l)){
                    return "player won the match";
                }
                else{
                    return "draw";
                }
                
            }
        }

        return "";
        
    }

    
}