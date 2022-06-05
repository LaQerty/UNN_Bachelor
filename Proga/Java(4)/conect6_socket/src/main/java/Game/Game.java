package Game;


public class Game {
    public class Cell{
        public boolean flag;
        public char[][] cell = new char[2][2];
        public Cell(){
            this.flag=false;
            this.cell[0][0] = ' ';
            this.cell[0][1] = '|';
            this.cell[1][0] = '-';
            this.cell[1][1] = '*';
        }
    }
    public Cell[][] field = new Cell[10][10];
    
    public Game(){
        for(int i = 0; i < 10; i ++){
            for(int j = 0; j < 10; j++){
                this.field[i][j] = new Cell();
            }
        }
    }
    public String fieldToString(){
        char[][] res = new char[20][20];
        int x = 0;
        int y = 0;
        int cx = 0;
        int cy = 0;
        String q = "  0 1 2 3 4 5 6 7 8 9z";
        for(int i = 0; i < 10; i++){
            cx = 2*i;
            x = cx;
            for(int j = 0; j < 10; j++){
                cy = 2*j;
                y = cy;
                for(int k = 0; k < 2; k++){
                    for(int l = 0; l < 2; l++){
                        res[x][y] = this.field[i][j].cell[k][l];
                        y++;
                    }
                    y = cy;
                    x++;
                }
                x = cx;
            }
            cy = 0;
            y = cy;
        }
        int c = 0;
        for(int i = 0; i < 20; i ++){
            if( i % 2 == 0){
                q += c + " ";
                c++;
            } else q +="  ";
            for(int j = 0; j < 20; j++){
                q+=res[i][j];
            }
            q+="z";
        }
        return q;
    }
    
    public String move(int x, int y, char c){
        if(!this.field[x][y].flag){
            this.field[x][y].cell[0][0] = c;
            this.field[x][y].flag = true;
            return fieldToString();
        }else return "You cant move!z";
    }
    
    public boolean end(int x, int y, char c){
        int count = 1;
        for(int i = 1; i < 6; i ++){
            if(x > 0+i){
                if(this.field[x-i][y].cell[0][0] == c){
                    count++;
                }
            }
            if(x < 9-i){
                if(this.field[x+i][y].cell[0][0] == c){
                    count++;
                }
            }
            if(count == 6) return true;
        }
        count = 1;
        for(int i = 1; i < 6; i ++){
            if(y > 0+i){
                if(this.field[x][y-i].cell[0][0] == c){
                    count++;
                }
            }
            if(y < 9-i){
                if(this.field[x][y+i].cell[0][0] == c){
                    count++;
                }
            }
            if(count == 6) return true;
        }
        count = 1;
        for(int i = 1; i < 6; i ++){
            if(y > 0+i && x > 0+i){
                if(this.field[x-i][y-i].cell[0][0] == c){
                    count++;
                }
            }
            if(y < 9-i && x < 9-i){
                if(this.field[x+i][y+i].cell[0][0] == c){
                    count++;
                }
            }
            if(count == 6) return true;
        }
        count = 1;
        for(int i = 1; i < 6; i ++){
            if(y > 0+i && x < 9-i){
                if(this.field[x+i][y-i].cell[0][0] == c){
                    count++;
                }
            }
            if(y < 9-i && x > 0+i){
                if(this.field[x-i][y+i].cell[0][0] == c){
                    count++;
                }
            }
            if(count == 6) return true;
        }
        count = 1;
        return false;
    }
}   
