package ClientServer;

public class Game {
    private char playerCount = 0;
    private char [][] field;
    private boolean [][] checkedfield;
    int fieldsize_x = 12;
    int fieldsize_y = 12;
    int currentTurn;
    boolean gameEnded = false;

    public Game() {
        currentTurn = 0;
        field = new char[fieldsize_x][fieldsize_y];
        checkedfield = new boolean[fieldsize_x][fieldsize_y];
        for(int x = 0; x < fieldsize_x; ++x)
            for(int y = 0; y < fieldsize_y; ++y) {
                if (x == 1 && y == 1){
                    field[x][y] = 'X';
                    checkedfield[x][y] = false;
                } else 
                if (x == fieldsize_x - 2 && y == fieldsize_y - 2) {
                    field[x][y] = 'O';
                    checkedfield[x][y] = false;
                } else {
                    field[x][y] = '_';
                    checkedfield[x][y] = false;
                }

            }
    }
    public String getField(){
        String res = "";
        char[] horizonatal = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char[] vertical = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 1; i < 11; ++i) {
            res+=vertical[i - 1] + " ";
            for(int j = 1; j < 11; ++j) {
                res+=field[j][i] + " ";
            }
            res+="\n";
        }
        res+="  ";
        for (int i = 0; i < 10; ++i) {
            res+=horizonatal[i] + " ";
        }
        res+="\n";
        return res;
    }

    public int addNewPlayer() {
        playerCount++;
        System.out.println("New player connected");
        return playerCount - 1;
    }

    public String setCell(int x, int y, int id){
        if(id == 0){
            if(field[x + 1][y + 1] == '_')
                field[x + 1][y + 1] = 'x';
            if(field[x + 1][y + 1] == 'o')
                field[x + 1][y + 1] = '@';
            if(field[x + 1][y + 1] == 'O')
                field[x + 1][y + 1] = 'X';
        }
        if(id == 1){
            if(field[x + 1][y + 1] == '_')
                field[x + 1][y + 1] = 'o';
            if(field[x + 1][y + 1] == 'x')
                field[x + 1][y + 1] = '*';
            if(field[x + 1][y + 1] == 'X')
                field[x + 1][y + 1] = 'O';
        }
        return getField();
    }

    public boolean isMyTurn(int myid){
        if(myid == currentTurn)
            return true;
        return false;
    }

    public void endTurn(){
        currentTurn  = (currentTurn + 1) % 2;
    }

    public boolean isGameEnded(){
        if(!gameEnded) {
            if (field[1][1] != 'X' || field[fieldsize_x - 2][fieldsize_y - 2] != 'O') {
                gameEnded = true;
                return true;
            }
            
            for(int i = 0; i < fieldsize_y - 2; ++i)
                for(int j = 0; j < fieldsize_x - 2; ++j) {
                    if(canSetCell(j, i, currentTurn))
                        return false;
                }
                gameEnded = true;
        }
        return true;
    }

    public boolean canSetCell(int x, int y, int id) {
        switch (id) {
            case(0):
                return  canSetXCell(x, y);
            case (1):
                return  canSetOCell(x, y);
        }
        return false;
    }

    public boolean canSetXCell(int x, int y)  {
        int dx = x + 1;
        int dy = y + 1;

        if((field[dx][dy] == '_' || field[dx][dy] == 'o' || field[dx][dy] == 'O') 
        && (dx > -1) && (dx < 11) && (dy > -1) && (dy < 11)) {
            for(int i = -1; i < 2; ++i)
                for(int j = -1; j < 2; j++) {
                    if(field[dx + i][dy + j] == 'X') {
                        return true;
                    }
                    if(field[dx + i][dy + j] == 'x') {
                        return true;
                    }
                    if(field[dx + i][dy + j] == '@') {
                        return true;
                    }
                }
        }
        return false;
    }

    public boolean canSetOCell(int x, int y)  {
        int dx = x + 1;
        int dy = y + 1;

        if((field[dx][dy] == '_' || field[dx][dy] == 'x' || field[dx][dy] == 'X') 
        && (dx > -1) && (dx < 11) && (dy > -1) && (dy < 11)) {
            for(int i = -1; i < 2; ++i)
                for(int j = -1; j < 2; j++) {
                    if(field[dx + i][dy + j] == 'O') {
                        return true;
                    }
                    if(field[dx + i][dy + j] == 'o') {
                        return true;
                    }
                    if(field[dx + i][dy + j] == '*') {
                        return true;
                    }
                }
        }
        return false;
    }
}
