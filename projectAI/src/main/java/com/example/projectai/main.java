package com.example.projectai;

import java.util.Arrays;

public class main {
    static Node v;
    static   int f=0;
    public static void main(String[] args) throws CloneNotSupportedException {
        int[][] c={{1,1,1,2,2,1,0},{1,1,1,2,2,1,0},{1,1,1,2,2,1,0},{1,1,1,2,2,1,0},{1,1,2,2,2,2,0},{2,1,1,1,2,2,2}};
        int[][] s={{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,1,2,0,0,0}};
        int[][] t={{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,1,2,3,0,0}};
        v=new Node(s);
        Node q=Algorithm.minimax(v,4,true);
        System.out.println();
        System.out.println();


    }
    public static Node print(Node n){
        if (n.parent.equals(v) ){
            return n;
        } else {
            n.parent.toString();
            f++;
            return print(n.parent);
        }
    }
}
