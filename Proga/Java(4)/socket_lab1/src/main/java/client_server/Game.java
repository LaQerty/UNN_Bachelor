
package client_server;

public class Game {
    public class Cell {
    public boolean left = false;
    public boolean right = false; 
    public boolean up = false; 
    public boolean down = false; 
    
    public Cell(boolean left, boolean right, boolean up, boolean down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }
    }
    
    public int complete = 0;
    public Cell[][] field = new Cell[5][5];
    
    public Game(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                this.field[i][j] = new Cell(false,false,false,false);
                if(i == 0 ){
                    this.field[i][j].up = true;
                }
                if(j == 0){
                    this.field[i][j].left = true;
                }
                if(i == 4){
                    this.field[i][j].down = true;
                }
                if(j == 4){
                    this.field[i][j].right = true;
                }
            }
        }
    }
    
    public String move(String word){
        String [] let = word.split(",");
        int first = -1 , second = -1 , i,j;
        try{
            first = Integer.parseInt(let[0]);
            second = Integer.parseInt(let[1]);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        if(first == -1 || second == -1){
            return "uncorrectly";
        }
        i = first;
        j = second;
        switch (let[2]) {
            case "d":
               if(field[i][j].down == false){
                   field[i][j].down=true;
                   field[++i][j].up=true;
               } else {
                   return "busy";
               }
               break;
            case "u":
               if(field[i][j].up == false){
                   field[i][j].up=true;
                   field[--i][j].down=true;
               } else {
                   return "busy";
               }
               break;
            case "l":
               if(field[i][j].left == false){
                   field[i][j].left=true;
                   field[i][--j].right=true;
               } else {
                   return "busy";
               }
               break;
            case "r":
               if(field[i][j].right == false){
                   field[i][j].right=true;
                   field[i][++j].left=true;
               } else {
                   return "busy";
               }
               break;
            default:
               return "uncorrectly";
        }
        if(field[first][second].down == true && field[first][second].up == true && 
                field[first][second].right == true && field[first][second].left == true){
            complete++;
            return "win";
        } else return "nice move";
    }
    
}