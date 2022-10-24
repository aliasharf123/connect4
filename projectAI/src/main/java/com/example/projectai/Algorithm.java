package com.example.projectai;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Algorithm {
    static int count =0;


    public static Node minimax(Node n,int depth,boolean maximizingPlayer) throws CloneNotSupportedException {
        if ((depth == 0) || n.isFull()) {
            return n;
        }
        if (maximizingPlayer){
            Node maxEval=new Node(Double.NEGATIVE_INFINITY);
            for (int i = 0; i < 7; i++) {
                Node child =  Node.BuildChild(n,i, true,depth);
                if (child != null) {
                    child.depth=depth;
                   child.toString();
                    count++;
                    Node temp =(Node) minimax(child, depth - 1, false).clone();
                    maxEval = Node.Max(temp, maxEval);
                }
            }
            return maxEval;
        }else {
            Node minEval=new Node(Double.POSITIVE_INFINITY);
            for (int i = 0; i < 7; i++) {
                Node child = Node.BuildChild(n,i,false,depth);
                if (child != null) {
                    child.toString();
                    count++;
                    child.depth=depth;
                    Node temp =(Node) minimax(child, depth - 1, true).clone();
                    minEval = Node.Min(temp, minEval);
                }
            }
            return minEval;
        }
    }
    public static Node alphabeta(Node n,int depth,Node Alpha,Node beta,boolean maximizingPlayer) throws CloneNotSupportedException {
        if ((depth == 0) || n.isFull()) {
            return n;
        }
        if (maximizingPlayer){
            Node maxEval=new Node(Double.NEGATIVE_INFINITY);
            for (int i = 0; i < 7; i++) {
                Node child =  Node.BuildChild(n,i, true,depth);
                if (child != null) {
                   //child.toString();
                    count++;
                    child.depth=depth;
                    Node temp =(Node) alphabeta(child, depth - 1,Alpha,beta, false).clone();
                    maxEval = Node.Max(temp, maxEval);
                    Alpha =Node.Max(Alpha, maxEval);
                   if (beta.heuristic <Alpha.heuristic) {
                      break;
                   }
                }
            }
            return maxEval;
        }else {
            Node minEval=new Node(Double.POSITIVE_INFINITY);
            for (int i = 0; i < 7; i++) {
                Node child = Node.BuildChild(n,i,false,depth);
                if (child != null) {
                  //  child.toString();
                    count++;
                    child.depth=depth;
                    Node temp =(Node) alphabeta(child, depth - 1,Alpha,beta, true).clone();
                    minEval = Node.Min(temp, minEval);
                    beta =Node.Min(beta,minEval);
                   if (beta.heuristic<Alpha.heuristic) {
                       break;
                   }
                }
            }
            return minEval;
        }
    }
}
