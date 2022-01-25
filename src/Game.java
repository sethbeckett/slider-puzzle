import java.util.Scanner;
public class Game {

    /**
     *
     * @param b : The input board to solve
     */
    public void playGiven(  Board b){
        Solver s = new Solver();
        s.solveBoard(b); //solves the input board and prints each move out
    }

    /**
     *
     * @param jumbleCount: number of random moves on initial board to create a solvable board.d
     */
    public void playRandom( int jumbleCount){
        Board b = new Board();
        b.makeBoard(jumbleCount, "Random Board " + jumbleCount);
        System.out.println("\n" + b);

    }


    public static void main(String[] args) {
       Game g = new Game();
        Scanner in = new Scanner(System.in);
        //testing
        int[] game0 = {1,2,3,4,5,6,0,7,8};
//        int [] game0 = { 1, 2, 3, 7, 4, 0, 6, 5, 8 };
        Board b = new Board();
        b.makeBoard(game0, "game0");
        g.playGiven(b);
        System.out.println("Click any key to continue\n");
        String resp;
        resp= in.nextLine();

        int []game1 = { 1, 3, 2, 4, 5, 6, 8, 7, 0 };
        b.makeBoard(game1,"game 1");
        g.playGiven( b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        int []game2 = { 1, 3, 8, 6, 2, 0, 5, 4, 7 };
        b.makeBoard(game2, "game 2");
        g.playGiven(b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        int []game3 = { 4, 0, 1, 3, 5, 2, 6, 8, 7 };
        b.makeBoard(game3, "game 3");
        g.playGiven( b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        int []game4 = { 7, 6, 4, 0, 8, 1, 2, 3, 5 };  // Warning slow to solve
        b.makeBoard(game4, "game 4");
        g.playGiven( b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

        int []game5 = { 1, 2, 3, 4, 5, 6, 8, 7, 0 };   // Warning unsolvable
        b.makeBoard(game5, "game 5");
        g.playGiven(b);
        System.out.println("Click any key to continue\n");
        resp= in.nextLine();

       boolean playAgain = true;

	   int JUMBLECT = 4;  // how much jumbling to to in random board
        while (playAgain)
        {
            g.playRandom( JUMBLECT);

            System.out.println("Play Again?  Answer Y for yes\n");
            resp= in.nextLine().toUpperCase();
            playAgain = (resp.charAt(0) == 'Y');
        }


    }


}
