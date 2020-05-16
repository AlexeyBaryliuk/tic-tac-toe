public class GameFild {

    public static char[][] playGameInit(){
        char play = 'x';
        char comp = 'o';
        char[][] fild = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                fild[i][j] = '-';
            }
        }
        return fild;
    }

    public static char[][] playGame(int x, int y, char ch, char[][] fild){

        if (x < 3 && x >= 0 && y < 3 && y >= 0 ){
            fild[x][y] = ch;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                System.out.print("| " + fild[i][j] + " ");
            }

            System.out.print("|");
            System.out.println();
            System.out.print("---------------");
            System.out.println();

    }
        return fild;
}
}