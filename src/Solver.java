          /**
 * @author Seth Beckett
 */
public class Solver{
    public static Board SOLUTION_BOARD = new Board();
    public static final String MOVE_STRING = "UDLR";

    /**instantiates a solver object and instantiates KEY_BOARD correctly
     *
     */
    Solver(){
        SOLUTION_BOARD.makeBoard(0, "Key Board");
    }

    /**solves input board originalBoard
     *
     * @param originalBoard:
     */
    public void solveBoard(Board originalBoard) {
        SimpleQueue<Board> q = new SimpleQueue<>();
        boolean isSolved = originalBoard.equals(SOLUTION_BOARD);
        q.enqueue(originalBoard);

        while (!q.isEmpty() && !isSolved) {
            Board currentState = q.dequeue();
//            System.out.println("Dequeued " + currentState);

            //test
            //System.out.println(KEY_BOARD);

            //uncomment to add move length limiter
//            if (currentState.moveHistory.length() > 25){ //check that queue size isn't too large
//                System.out.println("Too many moves bro");
//                break;
//            }

            //run through each possible move
            for (int k = 0; k < MOVE_STRING.length(); k++) {
                Board successor = new Board(currentState); //creates parent board to make moves on
                char move = MOVE_STRING.charAt(k);
                //See if successor board can make a move in direction k and add the move data if successful
                if (successor.makeMove(MOVE_STRING.charAt(k), currentState.lastMove) == move) {
                    successor.lastMove = move;
                    successor.moveHistory += move; //adds to history if move successful

                    if (successor.equals(SOLUTION_BOARD)) {
                        isSolved = true;
                        System.out.println(successor);
                        originalBoard.showMe(successor.moveHistory); //print the winning board succession
                        System.out.printf("Moves Required: %d\n", successor.moveHistory.length());
                        q.printQueueInfo();
                        break;
                    }
                    else {
                        q.enqueue(successor);
                    }

                }
            }
        }

    }
}
