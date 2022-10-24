package com.example.projectai;

import java.util.Arrays;

public class Node  implements Cloneable{
    int[][] state =new int[6][7];
    int AiWin = 0;
    int PlayerWin=0;
    String AiWinS ="0" ;
    String PlayerWinS ="0" ;
    double win;
    double heuristic;
    int move;
    Node parent;
    int depth;
    public Node(){}
    public Node(int[][] state) throws CloneNotSupportedException {
        this.state = state;
        win();
        setHeuristic();
    }
    public Node( double heuristic) {
        this.heuristic=heuristic;
    }
    public Node(int[][] state,int move) throws CloneNotSupportedException {
        this.state = state;
        this.move=move;
        win();
        setHeuristic();
    }
    public static Node Max(Node n,Node m){
        if(n.heuristic>=m.heuristic)
            return n;
        else return m;
    }
    public static Node Min(Node n,Node m){
        if(n.heuristic<=m.heuristic)
            return n;
        else return m;
    }
    // Create child
    public static  Node BuildChild(Node n,int place,boolean MaximizingPlayer,int depth) throws CloneNotSupportedException {
        Node newState =(Node) n.clone();
        newState.parent=(Node) n.clone();
        for (int i = newState.state.length - 1; i >= 0; i--) {
            if (newState.state[i][place] == 0) {
                if (MaximizingPlayer) {
                    newState.depth=100*depth;
                    newState.state[i][place] = 2;
                }else {
                    newState.depth=-(100*depth);
                    newState.state[i][place] = 1;
                }
                newState.move=place;
                newState.win();
                newState.setHeuristic();
                return newState;
            }
        }
        return null;
    }
    // determine the deminstion 0f position
    private int[] place(int i,int j)
    {
        int[] postion=new int[8];
        //North_0
        if(i<3) postion[0] = i;
        else postion[0] = 3;
        //North_East_1
        if(i<3){
            if(j>4){
                if (i==0){
                    postion[1]=0;
                }
                else  postion[1]= 6-j;
            }
            else postion[1]=i;
        }
        else{
            if(j>3) postion[1]= 6-j;
            else postion[1]=3;
        }
        //East_2
        if(j>3) postion[2] = 6-j;
        else postion[2] = 3;
        //south_East_3
        if(i>2){
            if(j>4){
                if (i==5){
                    postion[3]=0;
                }
                else  postion[3]= 6-j;
            }
            else postion[3]=5-i;
        }
        else{
            if(j>3) postion[3]= 6-j;
            else postion[3]=3;
        }
        //south_4
        if(i>2) postion[4] = 5-i;
        else postion[4] = 3;
        //south_west_5
        if(i>2){
            if(j<2){
                if (i==5){
                    postion[5]=0;
                }
                else  postion[5]= j;
            }
            else postion[5]=5-i;
        }
        else{
            if(j<3) postion[5]= j;
            else postion[5]=3;
        }
        //west_6
        if(j<3) postion[6] = j;
        else postion[6] = 3;
        //North_west_7
        if(i<3){
            if(j<2){
                if (i==0){
                    postion[7]=0;
                }
                else  postion[7]= j;
            }
            else postion[7]=i;
        }
        else{
            if(j<3) postion[7]= j;
            else postion[7]=3;
        }
        return postion;
    }
    // determine the win state
    private int setTemp(int[] position,Node b,int num,int i,int j){
        int opponent;
        int winState;
        if (num==1) {
            opponent=2;
            winState=-1;
        }
        else{
            opponent=1;
            winState=1;
        }
        //Vertical
        //North
        int Vertical_t = 0;
        for (int g = 1;g <= position[0]; g++) {
            if (b.state[i - g][j] == opponent || b.state[i - g][j] == 0 )
            {
                break;
            } else if (b.state[i - g][j] == num) {
                Vertical_t += 1;
            }
        }
        //South
        for (int g = 1;g <= position[4]; g++){
            if (b.state[i + g][j] == opponent || b.state[i + g][j] == 0) {
                break;
            }else if(b.state[i + g][j] == num){
                Vertical_t += 1;
            }
        }
        if (Vertical_t >=3) {
            if (winState == 1) AiWin++;
            else PlayerWin++;
        }

        //horizontal
        //Right
        int horizontal_t = 0;
        for (int g = 1;g <= position[2]; g++) {
            if (b.state[i ][j + g] == opponent || b.state[i ][j + g] == 0) {
                break;
            } else if (b.state[i ][j+ g] == num) {
                horizontal_t += 1;
            }
        }
        //Left
        for (int g = 1;g <= position[6]; g++){
            if (b.state[i ][j - g] == opponent || b.state[i ][j - g] == 0 ) {
                break;
            }else if(b.state[i ][j- g] == num){
                horizontal_t += 1;
            }
        }
        if (horizontal_t >=3){
            if (winState == 1) AiWin++;
            else PlayerWin++;
        }

        //Diagonal1
        //NorthEast
        int d_t = 0;
        for (int g = 1;g <= position[1]; g++) {
            if (b.state[i - g][j + g] == opponent ||b.state[i - g][j + g] == 0) {
                break;
            } else if (b.state[i - g][j + g] == num) {
                d_t  += 1;
            }
        }
        //SouthWest
        for (int g = 1;g <= position[5]; g++){
            if (b.state[i + g ][j - g] == opponent || b.state[i + g ][j - g] == 0) {
                break;
            }else if(b.state[i + g][j - g] == num){
                d_t  += 1;
            }
        }
        if (d_t  >=3) {
            if (winState == 1) AiWin++;
            else PlayerWin++;
        }

        //Diagonal2
        //NorthWest
        int d2_t = 0;
        for (int g = 1;g <= position[7]; g++) {
            if (b.state[i - g][j - g] == opponent || b.state[i - g][j - g] == 0) {
                break;
            } else if (b.state[i - g][j - g] == num) {
                d2_t += 1;
            }
        }
        //SouthEast
        for (int g = 1;g <= position[3]; g++){
            if (b.state[i + g ][j + g] == opponent || b.state[i + g ][j + g] == 0) {
                break;
            }else if(b.state[i + g][j + g] == num){
                d2_t += 1;
            }
        }
        if (d2_t >=3) {
            if (winState == 1) AiWin++;
            else PlayerWin++;
        }
        return 0;
    }
    //determine the win
    public void win() throws CloneNotSupportedException {
        Node newstate=(Node) this.clone();
        for (int i =  newstate.state.length-1; i >= 0; i--) {
            for (int j =   newstate.state[i].length-1; j >=0 ; j--) {
                if(newstate.state[i][j] != 0){
                  int[] position = place(i,j);
                  setTemp(position,newstate,newstate.state[i][j],i,j);
                  newstate.state[i][j]=0;
                }
            }
        }

    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public Object clone() throws CloneNotSupportedException
    {
        Node t = new Node();
        this.equal(t);
        t.parent=this.parent;
        t.heuristic=this.heuristic;
        t.AiWin=this.AiWin;
        t.PlayerWin=this.PlayerWin;
        t.depth=this.depth;
        t.move=this.move;
        return t;
    }
    //print current state
    public void printcurrnt() {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                System.out.print(state[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        System.out.println( "Node{" +
                ", heuristic=" + heuristic +
                ", win=" + win +
                ", depth=" + depth +
                ", move=" + move +
                ", Player score=" + PlayerWinS +
                ", AI Score=" + AiWinS +
                '}');
        System.out.println("state:");
        this.printcurrnt();
        return null;
    }
    //calculate the Heuristic
    public void setHeuristic() {
        heuristic=0;
        m(state[0][0],3);m(state[0][1],4);m(state[0][2],5);m(state[0][3],7);m(state[0][4],5);m(state[0][5],4);m(state[0][6],3);m(state[1][0],4);m(state[1][1],6);m(state[1][2],8);m(state[1][3],10);m(state[1][4],8);m(state[1][5],6);m(state[1][6],4);m(state[2][0],5);m(state[2][1],8);m(state[2][2],11);m(state[2][3],13);m(state[2][4],11);m(state[2][5],8);m(state[2][6],5);m(state[3][0],5);m(state[3][1],8);m(state[3][2],11);m(state[3][3],13);m(state[3][4],11);m(state[3][5],8);m(state[3][6],5);m(state[4][0],4);m(state[4][1],6);m(state[4][2],8);m(state[4][3],10);m(state[4][4],8);m(state[4][5],6);m(state[4][6],4);m(state[5][0],3);m(state[5][1],4);m(state[5][2],5);m(state[5][3],7);m(state[5][4],5);m(state[5][5],4);m(state[5][6],3);
        heuristic+=depth;
        AiWinS=Integer.toString(AiWin);
        PlayerWinS=Integer.toString(PlayerWin);
        heuristic += 100000* Integer.parseInt(AiWinS) ;
        heuristic -= 100000*Integer.parseInt(PlayerWinS);
        AiWin=0;
        PlayerWin=0;

    }
    public void equal(Node n){
        for (int i = 0; i < n.state.length; i++) {
            for (int j = 0; j < n.state[i].length; j++) {
                n.state[i][j]=this.state[i][j];
            }
        }
    }
    //calculate if the value is 1 or 2
    public void m(int d,int s){
        if (d == 2) heuristic+=s;
        else if (d == 1) heuristic-=s;
    }
    public boolean equals(Node n){
        for (int i = 0; i < n.state.length; i++) {
            for (int j = 0; j < n.state[i].length; j++) {
                if(n.state[i][j] !=this.state[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    // determine the board is full
    public boolean isFull()
    {
        for (int i = 0; i < state[0].length; i++)
        {
            if(state[0][i] == 0)
            {
                return false;
            }

        }
        return true;
    }
}
