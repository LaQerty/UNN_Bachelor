package Game;

import java.util.ArrayList;


public class Game {
    public char[][] field = new char[10][10];
    public Game(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
            this.field[i][j] = ' ';
            }
        }
        this.field[0][0] = 'c';
        this.field[9][9] = 's';
    }
    
    public String getField(){
        String result = "   0 1 2 3 4 5 6 7 8 9 \n";
        result+= "   - - - - - - - - - - \n";
        for(int i = 0; i < 10; i++){
            result+=i + " ";
            for(int j = 0; j < 10; j++){
                result+="|"+this.field[i][j];
            }
            result+="|\n";
            result+= "   - - - - - - - - - - \n";
        }
        return result;
    }
    public boolean canMove(char s, int x, int y){
        ArrayList<Integer> q = new ArrayList();
        q.add(x);
        q.add(y);
        if(this.field[x][y]== 'S' && this.field[x][y]== 'C' && this.field[x][y]== s){
            return false;
        }
        if(x > 0 && x < 9 && y > 0 && y < 9) { 
            if(this.field[x-1][y]==s || this.field[x][y-1]==s || this.field[x+1][y]==s || this.field[x][y+1]==s
                    || this.field[x+1][y+1]==s || this.field[x-1][y-1]==s || this.field[x-1][y+1]==s || this.field[x+1][y-1]==s){
                return true;
            }
        }
        if(x == 0 && y > 0 && y < 9) { 
            if(this.field[x][y-1]==s || this.field[x+1][y]==s || this.field[x][y+1]==s
                    || this.field[x+1][y+1]==s  ||  this.field[x+1][y-1]==s){
                return true;
            }
        }
        if( x == 9 && y > 0 && y < 9) { 
            if(this.field[x-1][y]==s || this.field[x][y-1]==s || this.field[x][y+1]==s
                    || this.field[x-1][y-1]==s || this.field[x-1][y+1]==s){
                return true;
            }
        }
        if(x > 0 && x < 9 && y == 0) { 
            if(this.field[x-1][y]==s ||  this.field[x+1][y]==s || this.field[x][y+1]==s
                    || this.field[x+1][y+1]==s  || this.field[x-1][y+1]==s){
                return true;
            }
        }
        if(x > 0 && x < 9 && y == 9) { 
            if(this.field[x-1][y]==s || this.field[x][y-1]==s || this.field[x+1][y]==s 
                    || this.field[x-1][y-1]==s || this.field[x+1][y-1]==s){
                return true;
            }
        }
        if(x == 0 && y == 0 ) { 
            if(this.field[x+1][y]==s || this.field[x][y+1]==s
                    || this.field[x+1][y+1]==s){
                return true;
            }
        }
        if(x == 9 && y == 9) { 
            if(this.field[x-1][y]==s || this.field[x][y-1]==s 
                    || this.field[x-1][y-1]==s){
                return true;
            }
        }
        if(x == 0 && y == 9) { 
            if( this.field[x][y-1]==s || this.field[x+1][y]==s 
                    || this.field[x+1][y-1]==s){
                return true;
            }
        }
        if(x == 9 && y == 0 ) { 
            if(this.field[x-1][y]==s || this.field[x][y+1]==s
                    || this.field[x-1][y+1]==s){
                return true;
            }
        }
        if(s == 'c'){
            while(!q.isEmpty()){
                if(q.get(0) > 0 && q.get(0) < 9 && q.get(1) > 0 && q.get(1) < 9) {
                        if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)+1][q.get(1)+1]==s || this.field[q.get(0)-1][q.get(1)-1]==s || this.field[q.get(0)-1][q.get(1)+1]==s || this.field[q.get(0)+1][q.get(1)-1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)-1]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)+1]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)+1]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)-1]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)-1);
                        }
                        q.remove(0);
                        q.remove(0);
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 0 && q.get(1) > 0 && q.get(1) < 9) { 

                        if( this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)+1][q.get(1)+1]==s || this.field[q.get(0)+1][q.get(1)-1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)+1]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)-1]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)-1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 9 && q.get(1) > 0 && q.get(1) < 9) { 

                        if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)-1][q.get(1)-1]==s || this.field[q.get(0)-1][q.get(1)+1]==s ){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)-1]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)+1]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)+1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) > 0 && q.get(0) < 9 && q.get(1) == 0) { 

                        if(this.field[q.get(0)-1][q.get(1)]== s  || this.field[q.get(0)+1][q.get(1)]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)+1][q.get(1)+1]==s  || this.field[q.get(0)-1][q.get(1)+1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)+1]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)+1]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)+1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) > 0 && q.get(0) < 9 && q.get(1) == 9) { 

                        if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)]==s 
                        || this.field[q.get(0)-1][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)-1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)-1][q.get(1)-1]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)-1]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)-1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 0 && q.get(1) == 0) { 
                        if(this.field[q.get(0)+1][q.get(1)]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)+1][q.get(1)+1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)+1]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)+1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 9 && q.get(1) == 9) { 

                        if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)-1]==s
                        || this.field[q.get(0)-1][q.get(1)-1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)-1]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)-1);
                        }
                        q.remove(0);
                        q.remove(0);
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 0 && q.get(1) == 9) { 

                        if(this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)]==s
                        || this.field[q.get(0)+1][q.get(1)-1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)+1][q.get(1)-1]== 'C'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)-1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 9 && q.get(1) == 0) { {

                        if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)-1][q.get(1)+1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'C'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)+1]== 'C'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)+1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
            }
        }
        if(s == 's'){
            while(!q.isEmpty()){
                if(q.get(0) > 0 && q.get(0) < 9 && q.get(1) > 0 && q.get(1) < 9) { 

                        if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)+1][q.get(1)+1]==s || this.field[q.get(0)-1][q.get(1)-1]==s || this.field[q.get(0)-1][q.get(1)+1]==s || this.field[q.get(0)+1][q.get(1)-1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)-1]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)+1]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)+1]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)-1]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)-1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 0 && q.get(1) > 0 && q.get(1) < 9) { 

                        if( this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)+1][q.get(1)+1]==s || this.field[q.get(0)+1][q.get(1)-1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)+1]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)-1]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)-1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 9 && q.get(1) > 0 && q.get(1) < 9) { 

                        if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)-1][q.get(1)-1]==s || this.field[q.get(0)-1][q.get(1)+1]==s ){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)-1]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)+1]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)+1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) > 0 && q.get(0) < 9 && q.get(1) == 0) { 

                        if(this.field[q.get(0)-1][q.get(1)]== s  || this.field[q.get(0)+1][q.get(1)]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)+1][q.get(1)+1]==s  || this.field[q.get(0)-1][q.get(1)+1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)+1]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)-1][q.get(1)+1]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)+1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) > 0 && q.get(0) < 9 && q.get(1) == 9) { 

                        if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)]==s 
                        || this.field[q.get(0)-1][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)-1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)-1][q.get(1)]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)-1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)-1][q.get(1)-1]== 'S'){
                            q.add(q.get(0)-1);
                            q.add(q.get(1)-1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)-1]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)-1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 0 && q.get(1) == 0) { 

                        if(this.field[q.get(0)+1][q.get(1)]==s || this.field[q.get(0)][q.get(1)+1]==s
                        || this.field[q.get(0)+1][q.get(1)+1]==s){
                            return true;
                        }
                        if(this.field[q.get(0)+1][q.get(1)]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1));
                        }
                        if(this.field[q.get(0)][q.get(1)+1]== 'S'){
                            q.add(q.get(0));
                            q.add(q.get(1)+1);
                        }
                        if(this.field[q.get(0)+1][q.get(1)+1]== 'S'){
                            q.add(q.get(0)+1);
                            q.add(q.get(1)+1);
                        }
                        q.remove(0);
                        q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 9 && q.get(1) == 9) { 

                    if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)-1]==s
                    || this.field[q.get(0)-1][q.get(1)-1]==s){
                        return true;
                    }
                    if(this.field[q.get(0)-1][q.get(1)]== 'S'){
                        q.add(q.get(0)-1);
                        q.add(q.get(1));
                    }
                    if(this.field[q.get(0)][q.get(1)-1]== 'S'){
                        q.add(q.get(0));
                        q.add(q.get(1)-1);
                    }
                    if(this.field[q.get(0)-1][q.get(1)-1]== 'S'){
                        q.add(q.get(0)-1);
                        q.add(q.get(1)-1);
                    }
                    q.remove(0);
                    q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 0 && q.get(1) == 9) { 

                    if(this.field[q.get(0)][q.get(1)-1]==s || this.field[q.get(0)+1][q.get(1)]==s
                    || this.field[q.get(0)+1][q.get(1)-1]==s){
                        return true;
                    }
                    if(this.field[q.get(0)][q.get(1)-1]== 'S'){
                        q.add(q.get(0));
                        q.add(q.get(1)-1);
                    }
                    if(this.field[q.get(0)+1][q.get(1)]== 'S'){
                        q.add(q.get(0)+1);
                        q.add(q.get(1));
                    }
                    if(this.field[q.get(0)+1][q.get(1)-1]== 'S'){
                        q.add(q.get(0)+1);
                        q.add(q.get(1)-1);
                    }
                    q.remove(0);
                    q.remove(0);  
                }
                if(q.isEmpty()) break;
                if(q.get(0) == 9 && q.get(1) == 0) { 

                    if(this.field[q.get(0)-1][q.get(1)]== s || this.field[q.get(0)][q.get(1)+1]==s
                    || this.field[q.get(0)-1][q.get(1)+1]==s){
                        return true;
                    }
                    if(this.field[q.get(0)-1][q.get(1)]== 'S'){
                        q.add(q.get(0)-1);
                        q.add(q.get(1));
                    }
                    if(this.field[q.get(0)][q.get(1)+1]== 'S'){
                        q.add(q.get(0));
                        q.add(q.get(1)+1);
                    }
                    if(this.field[q.get(0)-1][q.get(1)+1]== 'S'){
                        q.add(q.get(0)-1);
                        q.add(q.get(1)+1);
                    }
                    q.remove(0);
                    q.remove(0);  
                }
                if(q.isEmpty()) break;
            }
            }
        }
        return false;
    }
    
    public String move(char s, int x, int y){
        if(!canMove(s,x,y)){
            return "";
        }
        if(s =='c'){
            if(this.field[x][y] == 's'){
                this.field[x][y] = 'C';
            } else this.field[x][y] = s;
        }
        if(s =='s'){
            if(this.field[x][y] == 'c'){
                this.field[x][y] = 'S';
            } else this.field[x][y] = s;
        }
        return getField();
    }
    
    public boolean end(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(this.field[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        Game f = new Game();
        System.out.println(f.getField());
    }
}   
