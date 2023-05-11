import java.util.Random;
import java.util.HashSet;
import java.util.Scanner;
public class BingoGame
{
    static int[][] board = new int[5][5];
    static int updatenum=0;

    //Create Board
    static void CreateBoard()
    {
        //store the element and check so that there is no duplication of random number 
        HashSet<Integer> set = new HashSet<>();

        Random random = new Random();
        for (int i=0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++) 
            {
                // Generate a random number between 1 and 99 
                int number = random.nextInt(98) + 1;
                if(set.contains(number))
                {
                    j--;
                }
                else
                {
                board[i][j] = number;
                }
                set.add(number);
            }
        }
    }
    
    //Display Board
    static void DisplayBoard()
    {
        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++) 
            {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Replace user enter number by 0
    static int UpdateBoard(int num)
    {
        boolean found = false;
            for (int i = 0; i < 5; i++) 
            {
                for (int j = 0; j < 5; j++) 
                {
                    if (board[i][j] == num) 
                    {
                        board[i][j]=00;
                        found = true;
                        updatenum++;
                    }
                }
            }
            if (!found) 
            {
                System.out.println("That number is not on the board. Please enter another number");
            }
            return updatenum; 
    }

    //  COUNT completed Line by 0
    static int CompleteLine()
    {      
        int completeline=0;
         // Check rows
        for (int i = 0; i < 5; i++) 
        {
            if (board[i][0]==0 && board[i][1]==0 && board[i][2]==0 && board[i][3]==0 && board[i][4]==0) 
            {
                completeline++; 
            }
        }
                
        // Check columns
        for (int j = 0; j < 5; j++) 
        {
            if (board[0][j]==0 && board[1][j]==0 && board[2][j]==0 && board[3][j]==0 && board[4][j]==0) 
            {
                completeline++;
            }
        }
                
        // Check diagonals
        if (board[0][0]==0 && board[1][1]==0 && board[2][2]==0 && board[3][3]==0 && board[4][4]==0) 
        {
            completeline++;
        }

        if (board[0][4]==0 && board[1][3]==0 && board[2][2]==0 && board[3][1]==0 && board[4][0]==0) 
        {
            completeline++;
        }
        return completeline;
    }
   
    public static void main(String args[])
    {
        CreateBoard();
        DisplayBoard();
        System.out.println();
        
        // Play the game
        Scanner scanner = new Scanner(System.in);
        String result="";
        while (!result.equals("bingo")) 
        {
            // Ask the player to enter the next number
            System.out.println("Enter the number (or 0 to quit): ");
            int number = scanner.nextInt();
            if (number == 0) 
            {
                break;
                
            }

            // Number replace by 0 on the board
            int update_num=UpdateBoard(number);

            DisplayBoard();
            System.out.println();

            // Check complete Line 
            if (update_num >= 5) {
            int c_line=CompleteLine(); 

            //Print Result 
            switch(c_line)
            {
              
            case 1:
            System.out.println("-------------------------------------- B -----------------------------------------------\n");
            break;

            case 2:
            System.out.println("-------------------------------------- B I ---------------------------------------------\n");
            break;

            case 3:
            System.out.println("-------------------------------------- B I N -------------------------------------------\n");
            break;

            case 4:
            System.out.println("-------------------------------------- B I N G -----------------------------------------\n");
            break;

            case 5:
            result="bingo";
            System.out.println("-------------------------------------- B I N G O ! --------------------------------------\n");
            System.out.println("************************************  Y O U  W O N ****************************************");
            break;
            }
        }
        }
        System.out.println();
        System.out.println("................................... Thanks for playing!.....................................");
    }
}









































































