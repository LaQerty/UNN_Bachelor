package Game;


public class Game {
    public char[][] field = new char[7][7];
    public Game(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if( i%2 == 0 && j%2 == 0)
                    this.field[i][j]='*';
                else this.field[i][j] = ' ';
            }
        }
    }
    
    public String fieldToString(){
    String res = "";
    for(int i = 0; i < 7; i++){
        for(int j = 0; j < 7; j++){
            res+=this.field[i][j];
        }
        res+="\n";
    }
    return res;
    }
    public String move(int x, int y, String str){
        if(x < 0 || y < 0 || x > 2 || y > 2 )
            return "Uncorrectly";
        if( x == 2 ) x+=3;
        if( x == 1 ) x+=2;
        if( x == 0 ) x++;
        if( y == 2 ) y+=3;
        if( y == 1 ) y+=2;
        if( y == 0 ) y++;
        if( "up".equals(str)){ 
            x--;
            if(this.field[x][y] != '-')
                this.field[x][y] = '-';
            else return "Ypu cant move";
        }
        if( "down".equals(str)) {
            x++;
            if(this.field[x][y] != '-')
                this.field[x][y] = '-';
            else return "Ypu cant move";
        }
        if( "left".equals(str)) {
            y--;
            if(this.field[x][y] != '|')
                this.field[x][y] = '|';
            else return "Ypu cant move";
        }
        if( "right".equals(str)) {
            y++;
            if(this.field[x][y] != '|')
                this.field[x][y] = '|';
            else return "Ypu cant move";
        }
        return fieldToString();
    }
    public boolean isDone(int x, int y){
        if( x == 2 ) x+=3;
        if( x == 1 ) x+=2;
        if( x == 0 ) x++;
        if( y == 2 ) y+=3;
        if( y == 1 ) y+=2;
        if( y == 0 ) y++;
        return this.field[x-1][y] == '-' && this.field[x+1][y] == '-' && this.field[x][y-1] == '|' && this.field[x][y+1] == '|';
    }
    public String setWinCell(int x, int y, char str){
        if( x == 2 ) x+=3;
        if( x == 1 ) x+=2;
        if( x == 0 ) x++;
        if( y == 2 ) y+=3;
        if( y == 1 ) y+=2;
        if( y == 0 ) y++;
        this.field[x][y]=str;
        return fieldToString();
    }
    public boolean isGameEnd(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if( this.field[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
