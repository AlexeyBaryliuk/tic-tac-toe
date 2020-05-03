import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Player {

    private char play = 'x';
    private char comp = 'o';

    private boolean isPlayer = false;
    private int fullCount;

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Random rand = new Random();


    public void move() {

        char[][] fild = GameFild.playGameInit();
        int x, y;
        char tempName;
        boolean check = true;
        System.out.println("Enter coordinates");
        while (true) {
            if (!isPlayer) {

                System.out.println("Computer is working");
                tempName = comp;

                while (check) {
                    x = rand.nextInt(3);
                    y = rand.nextInt(3);
                    if (fild[x][y] == '-' ) {
                        fild = GameFild.playGame(x, y, tempName, fild);
                        if (checkWin(fild, comp)){
                            fullCount = 9;
                            System.out.println("The comp is winner");
                            break;
                        }
                        isPlayer = true;
                        check = false;
                        fullCount++;
                    }
                    System.out.println("One more time");
                    }

            } else {
                x = 0;
                y = 0;
                System.out.println("Player is running");
                tempName = play;

                while (!check) {
                    try {
                        System.out.println("Enter x");
                        x = Integer.parseInt(bf.readLine());
                        System.out.println("Enter y");
                        y = Integer.parseInt(bf.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (fild[x][y] == '-' ) {
                        fild = GameFild.playGame(x, y, tempName, fild);

                        if (checkWin(fild, play)){
                            fullCount = 9;
                            System.out.println("The player is winner");
                            break;
                        }
                        isPlayer = false;

                        check = true;
                        fullCount++;
                    }
                    System.out.println("One more time");
                }
            }
            if (checkEnd(fullCount)){
                System.out.println("The game is over");
                break;
            }
        }
    }

    private static boolean checkEnd(int fullCount){
        boolean checkEnd = false;
        if (fullCount == 9){
            checkEnd = true;
        }
        return checkEnd;
    }

    private static boolean checkWin(char[][] fild, char ch){

        boolean check = false;
        int count2 = 0;
        for (int i = 0; i < 3 ; i++) {
            int count = 0;
            int count1 = 0;
            for (int j = 0; j < 3 ; j++) {

                if (fild[i][j] == ch){
                    count++;
                    if (count == 3){
                        check = true;
                        break;
                    }
                }
                if (fild[j][i] == ch){
                    count1++;
                    if (count1 == 3){
                        check = true;
                        break;
                    }
                }
            }
            if (fild[i][i] == ch){
                count2++;
                if (count2 == 3){
                    check = true;
                    break;
                }
            }
        }
       if (fild[0][2] == ch && fild[1][1] == ch && fild[2][0] == ch){
           check = true;
       }
        return check;
    }

}
