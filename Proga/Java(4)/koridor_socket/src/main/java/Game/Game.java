package Game;


public class Game {
    public char[][] field = new char[7][7];
    public Game(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                this.field[i][j] = '*';
                if( i%2 == 0 || j%2 == 0)
                    this.field[i][j] = ' ';
                if(( i == 0 && j%2 !=0)||(i == 6 && j%2 !=0))
                    this.field[i][j] = '-';
                if(( j == 0 && i%2 !=0)||(j == 6 && i%2 !=0))
                    this.field[i][j] = '|';
            }
        }
    }
    public String fieldToString(){
        String res ="";
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                res+=this.field[i][j];
            }
            res+=",";
        }
        return res;
    }
    
    public String move(String str){
        char[] strToArray = str.toCharArray();
        if(strToArray.length != 3 && strToArray[2] != 'l' && strToArray[2] != 'r' && strToArray[2] != 'u' && strToArray[2] != 'd')
            return "Uncorrectly!";
        int x = (int)strToArray[0] - '0';
        int y = (int)strToArray[1] - '0';
        if( x < 1 || x > 3 || y < 1 || y > 3)
            return "Uncorrectly!";
        if( x == 3)
            x+=2;
        if( x == 2)
            x++;
        if( y == 3)
            y+=2;
        if( y == 2)
            y++;
        if( strToArray[2] == 'l')
            y--;
        if( strToArray[2] == 'r')
            y++;
        if( strToArray[2] == 'u')
            x--;
        if( strToArray[2] == 'd')
            x++;
        if( x%2 == 0){
            if(this.field[x][y] != '-'){
                this.field[x][y] = '-';
            }else return "You cant move";
        } else{
            if(this.field[x][y] != '|'){
                this.field[x][y] = '|';
            }else return "You cant move";
        }
        return "Good!";
    }
    public boolean getPoint(String str){
        char[] strToArray = str.toCharArray();
        int x = (int)strToArray[0] - '0';
        int y = (int)strToArray[1] - '0';
        int x1 = x-1,y1 = y,x2 = x+1,y2 = y,x3 = x,y3 = y-1,x4 = x,y4 = y+1;
        if( x1 < 1) x1 = 1;
        if( x2 > 3) x2 = 3;
        if( y3 < 1) y3 = 1;
        if( y4 > 3) y4 = 3;
        if( x == 3) x+=2;
        if( x1 == 3) x1+=2;
        if( x2 == 3) x2+=2;
        if( x3 == 3) x3+=2;
        if( x4 == 3) x4+=2;
        if( x == 2) x++;
        if( x1 == 3) x1++;
        if( x2 == 3) x2++;
        if( x3 == 3) x3++;
        if( x4 == 3) x4++;
        if( y == 3) y+=2;
        if( y1 == 3) y1+=2;
        if( y2 == 3) y2+=2;
        if( y3 == 3) y3+=2;
        if( y4 == 3) y4+=2;
        if( y == 2) y++;
        if( y1 == 2) y1++;
        if( y2 == 2) y2++;
        if( y3 == 2) y3++;
        if( y4 == 2) y4++;
        if((this.field[x-1][y] == '-' && this.field[x+1][y] == '-' && this.field[x][y-1] == '|' && this.field[x][y+1] == '|')||
                (this.field[x1-1][y1] == '-' && this.field[x1+1][y1] == '-' && this.field[x1][y1-1] == '|' && this.field[x1][y1+1] == '|')||
                (this.field[x2-1][y2] == '-' && this.field[x2+1][y2] == '-' && this.field[x2][y2-1] == '|' && this.field[x2][y2+1] == '|')||
                (this.field[x3-1][y3] == '-' && this.field[x3+1][y3] == '-' && this.field[x3][y3-1] == '|' && this.field[x3][y3+1] == '|')||
                (this.field[x4-1][y4] == '-' && this.field[x4+1][y4] == '-' && this.field[x4][y4-1] == '|' && this.field[x4][y4+1] == '|'))
            return true;
        return false;
    }   
}
