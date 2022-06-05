package Gomoku;

public class Gomoku {
    public class Cell{
        public boolean canTake;
        public char[][] cell = new char[2][2];
        public Cell(){
            this.canTake = true;
            this.cell[0][0] = '*';
            this.cell[0][1] = '-';
            this.cell[1][0] = '|';
            this.cell[1][1] = ' ';
        }
        public void setCell(char c){
            this.canTake = false;
            this.cell[1][1] = c;
        }
    }
    public Cell[][] field = new Cell[10][10];
    public Gomoku(){
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++){
                this.field[i][j] = new Cell();
            }
        }
    }
    public String fieldToString(){
        String res = "";
        res+="  0 1 2 3 4 5 6 7 8 9q";
        for(int i = 0; i < 10; i++) {
            res+=" ";
            for(int j = 0; j < 10; j++){
                res+= this.field[i][j].cell[0][0];
                res+= this.field[i][j].cell[0][1];
            }
            res+="*q";
            res+=i;
            for(int j = 0; j < 10; j++){
                res+= this.field[i][j].cell[1][0];
                res+= this.field[i][j].cell[1][1];
            }
            res+="|q";
        }
        res+=" *-*-*-*-*-*-*-*-*-*-*q";
        return res;
    }
    public String takeMove(int x, int y, char c){
        if( x > 9 || x < 0 || y > 9 || y < 0 ) 
            return "You cant do it!";
        if(this.field[x][y].canTake){
            this.field[x][y].setCell(c);
            return fieldToString();
        }
        return "You cant do it!";
    }
    public boolean isGameEnd(int x, int y, char c){
        int count = 0;
        for(int i = 1; i < 6; i++){
            if(x+i < 10){
                if(this.field[x+i][y].cell[1][1] == c)
                    count++;
                else break;
            } else break;
        }
        for(int i = 1; i < 6; i++){
            if(x-i > -1){
                if(this.field[x-i][y].cell[1][1] == c)
                    count++;
                else break;
            } else break;
        }
        if(count == 4) return true;
        count = 0;
        for(int i = 1; i < 6; i++){
            if(y+i < 10){
                if(this.field[x][y+i].cell[1][1] == c)
                    count++;
                else break;
            } else break;
        }
        for(int i = 1; i < 6; i++){
            if(y-i > -1){
                if(this.field[x][y-i].cell[1][1] == c)
                    count++;
                else break;
            } else break;
        }
        if(count == 4) return true;
        count = 0;
        for(int i = 1; i < 6; i++){
            if(y+i < 10 && x+i < 10){
                if(this.field[x+i][y+i].cell[1][1] == c)
                    count++;
                else break;
            } else break;
        }
        for(int i = 1; i < 6; i++){
            if(y-i > -1 && x-i > -1){
                if(this.field[x-i][y-i].cell[1][1] == c)
                    count++;
                else break;
            } else break;
        }
        if(count == 4) return true;
        count = 0;
        for(int i = 1; i < 6; i++){
            if(y+i < 10 && x-i > -1){
                if(this.field[x-i][y+i].cell[1][1] == c)
                    count++;
                else break;
            } else break;
        }
        for(int i = 1; i < 6; i++){
            if(x+i < 10 && y-i > -1){
                if(this.field[x+i][y-i].cell[1][1] == c)
                    count++;
                else break;
            } else break;
        }
        if(count == 4) return true;
        return false;
    }
}
