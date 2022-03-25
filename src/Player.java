public class Player {
    boolean turn;
    char symbol;

    public Player(boolean turn, char symbol) {
        this.turn = turn;
        this.symbol = symbol;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int whose_turn(boolean turn){
        if(turn){
            System.out.println("It is the computers turn");
            return 0;
        }
        System.out.println("It is the players turn, your turn.");
        return 1;
    }
}
