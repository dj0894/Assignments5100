package ticktacktoeGame;

import java.util.*;

class TicTacToe {

   static List<Integer> playerPositions=new ArrayList<>();
   static List<Integer> cpuPositions= new ArrayList<>() ;
    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos = scan.nextInt();

            while(playerPositions.contains(playerPos)||cpuPositions.contains(playerPos)){
                System.out.println("Position is not available. Enter correct position");
                playerPos = scan.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");
            printGameBoard(gameBoard);

            String result=checkWinner();
            if(result.length()>0){
                System.out.print(result);
                break;
            }


            System.out.println("\n-------CPU turn--------");
            Random random = new Random();
            int cpuPos=random.nextInt(9)+1;
            while(playerPositions.contains(cpuPos)||cpuPositions.contains(cpuPos)){
                cpuPos=random.nextInt(9)+1;
            }
            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            result=checkWinner();
            if(result.length()>0){
                System.out.print(result);
                break;
            }

        }
    }

    public static void printGameBoard(char[][] gameBoard) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                System.out.print(gameBoard[i][j]);
            }

            System.out.println();

        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
              playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
             cpuPositions.add(pos);
        }

        switch(pos){
            case 1: gameBoard[0][0]=symbol;
                break;
            case 2: gameBoard[0][2]=symbol;
                break;
            case 3: gameBoard[0][4]=symbol;
                break;
            case 4: gameBoard[2][0]=symbol;
                break;
            case 5: gameBoard[2][2]=symbol;
                break;
            case 6: gameBoard[2][4]=symbol;
                break;
            case 7: gameBoard[4][0]=symbol;
                break;
            case 8: gameBoard[4][2]=symbol;
                break;
            case 9: gameBoard[4][4]=symbol;
                break;
            default:break;
        }




        }

        public static String checkWinner() {

            List topRow= Arrays.asList(1,2,3);
            List middleRow= Arrays.asList(4,5,6);
            List bottomRow= Arrays.asList(7,8,9);
            List firstCol= Arrays.asList(1,4,7);
            List secondCol= Arrays.asList(2,5,8);
            List thirdCol= Arrays.asList(3,6,9);
            List diagonal1= Arrays.asList(1,5,9);
            List diagonal2= Arrays.asList(7,5,3);

            List<List> winningConditions=new ArrayList<List>();
            winningConditions.add(topRow);
            winningConditions.add(middleRow);
            winningConditions.add(bottomRow);
            winningConditions.add(firstCol);
            winningConditions.add(secondCol);
            winningConditions.add(thirdCol);
            winningConditions.add(diagonal1);
            winningConditions.add(diagonal1);

            for(List l : winningConditions){
              if(playerPositions.containsAll(l)){
                  return "Congratulations you won!. ";
              }else if (cpuPositions.containsAll(l)){
                    return "CPU wins! Sorry:(";
                }else if(playerPositions.size()+cpuPositions.size()==9){
                  return "CAT!";
              }
            }
            return  "";

        }

}


