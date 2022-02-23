package com.score4.score4.game;

import com.score4.score4.models.Message;

public class Connect4 {

    Integer[][] matrix;

    boolean turn1,turn2;

    final int maxPoints,p1=1,p2=2;

    public Connect4(int x,int y,int maxPoints){
        matrix=new Integer[x][y];
        turn1=true;
        turn2=false;
        this.maxPoints=maxPoints;
        System.out.println(matrix.length+"x"+matrix[0].length);
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    public Message setMark(int indexX,int player){

        System.out.println("setMark: index="+indexX+", player="+player);

        if(player==p1&&!turn1)
            return new Message(false,"It is not the turn of Player 1");
        else if(player==p2&&!turn2)
            return new Message(false,"It is not the turn of Player 2");
        else if(player!=p1&&player!=p2)
            return new Message(false,"Invalid Player");
        else if(indexX>matrix.length-1||indexX<0)
            return new Message(false,"Invalid Position");
        else if(matrix[indexX][matrix[0].length-1]!=null)
            return new Message(false,"Position is full");
        else{
            Integer y=getEmptyPosition(indexX);
            if(y==null) return new Message(false,"Error could not compute the Empty Position");
            matrix[indexX][y]=player;
            turn1=!turn1;
            turn2=!turn2;
            Integer won=checkIfSomeoneWon();
            if(won!=null ) return new Message(true,true,"Player "+won+" has won.");
            return new Message(true,"Move was executed successfully");
        }
    }

    public Integer checkIfSomeoneWon(){
        Integer out=checkIfSomeoneWinsVertically();
        if(out!=null) return out;
        out=checkIfSomeoneWinsHorizontally();
        return out;
    }

    public Integer checkIfSomeoneWinsVertically(){

        int counterP1,counterP2;
        for(int i=0;i<matrix.length;i++){
            counterP1=0;counterP2=0;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==null)
                    break;
                else if(matrix[i][j]==p1) {
                    counterP1++;
                    counterP2 = 0;
                }else if(matrix[i][j]==p2){
                    counterP2++;
                    counterP1=0;
                }
                if(counterP2==maxPoints) return p2;
                else if(counterP1==maxPoints) return p1;
            }
        }
        return null;
    }

    /*
    [0,5][1,5][2,5]
    [0,4][1,4][2,4]
    [0,3][1,3][2,3]
    [0,2][1,2][2,2]
    [0,1][1,1][2,1]
    [0,0][1,0][2,0]
     */

    public Integer checkIfSomeoneWinsHorizontally(){

        int counterP1,counterP2;
        for(int i=0;i<matrix[0].length;i++){
            counterP1=0;counterP2=0;
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][i]==null)
                    break;
                else if(matrix[j][i]==p1) {
                    counterP1++;
                    counterP2 = 0;
                }else if(matrix[j][i]==p2){
                    counterP2++;
                    counterP1=0;
                }
                if(counterP2==maxPoints) return p2;
                else if(counterP1==maxPoints) return p1;
            }
        }
        return null;
    }

    public Integer getEmptyPosition(int x){
        for(int i=0;i<matrix[0].length;i++)
            if(matrix[x][i]==null) return i;
        return null;
    }

    public String printMatrix(){
        StringBuilder out= new StringBuilder();
        for(Integer[] column:matrix){
            for(Integer cell:column){
                if(cell==null)   out.append(" [_]");
                else if(cell==1) out.append(" [X] ");
                else if(cell==2) out.append(" [O]");
                else out.append(" [$]");//error
            }
            out.append(System.lineSeparator());
        }
        System.out.println(out);
        return out.toString();

    }

}
