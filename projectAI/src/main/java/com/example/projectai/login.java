package com.example.projectai;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class login implements Initializable {
    int[][] b = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
    Node root = new Node(b);
    @FXML
    private Circle circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle11, circle21, circle31, circle41, circle51, circle61, circle71, circle12, circle13, circle14, circle15, circle22, circle23, circle24, circle25, circle32, circle33, circle34, circle35, circle42, circle43, circle44, circle45, circle52, circle53, circle54, circle55, circle62, circle63, circle64, circle65, circle72, circle73, circle74, circle75;
    @FXML
    private Label turn,Player_Score,Ai_Score;
    @FXML
    private ChoiceBox<String> mode,Depth_box;
    private int depth=0;
    private String[] mode1 = {"MiniMax", "Alpha-Beta"};
    private String[] Depth ={"1","2","3","4","5","6","7","8"};
    @FXML
    Label label2;

    public login() throws CloneNotSupportedException {
    }
    // play in column one
    public void changeColor1(ActionEvent event) throws CloneNotSupportedException {
        Circle[] c = Circles()[0];
        for (int i = 5; i >= 0; i--) {
            if (Cheak(c[i], 0)) {
                break;
            }
        }
        long start1 = System.nanoTime();
        AiPlaying();
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1 - start1));
    }
    // play in column two
    public void changeColor2(ActionEvent event) throws CloneNotSupportedException {
        Circle[] c = Circles()[1];
        for (int i = 5; i >= 0; i--) {
            if (Cheak(c[i], 1)) {
                break;
            }
        }
        long start1 = System.nanoTime();
        AiPlaying();
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
    // play in column three
    public void changeColor3(ActionEvent event) throws CloneNotSupportedException {
        Circle[] c = Circles()[2];
        for (int i = 5; i >= 0; i--) {
            if (Cheak(c[i], 2)) {
                break;
            }
        }
        long start1 = System.nanoTime();
        AiPlaying();
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
    // play in column four
    public void changeColor4(ActionEvent event) throws CloneNotSupportedException {
        Circle[] c = Circles()[3];
        for (int i = 5; i >= 0; i--) {
            if (Cheak(c[i], 3)) {
                break;
            }
        }
        long start1 = System.nanoTime();
        AiPlaying();
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
    // play in column fifth
    public void changeColor5(ActionEvent event) throws CloneNotSupportedException {
        Circle[] c = Circles()[4];
        for (int i = 5; i >= 0; i--) {
            if (Cheak(c[i], 4)) {
                break;
            }
        }
        long start1 = System.nanoTime();
        AiPlaying();
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
    // play in column six
    public void changeColor6(ActionEvent event) throws CloneNotSupportedException {
        Circle[] c = Circles()[5];
        for (int i = 5; i >= 0; i--) {
            if (Cheak(c[i], 5)) {
                break;
            }
        }
        long start1 = System.nanoTime();
        AiPlaying();
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
    // play in column seven
    public void changeColor7(ActionEvent event) throws CloneNotSupportedException {
        Circle[] c = Circles()[6];
        for (int i = 5; i >= 0; i--) {
            if (Cheak(c[i], 6)) {
                break;
            }
        }
        long start1 = System.nanoTime();
        AiPlaying();
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
    //Cheak if the circle is white or not
    public boolean Cheak(Circle c, int position) throws CloneNotSupportedException {
        Color c2 = (Color) c.getFill();
        String hex = String.format("#%02X%02X%02X",
                (int) (c2.getRed() * 255),
                (int) (c2.getGreen() * 255),
                (int) (c2.getBlue() * 255));
        if (hex.equals("#F7FBFF")) {
            c.setFill(Color.RED);
            root = Node.BuildChild(root, position, false,0);
            return true;
        }
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mode.getItems().addAll(mode1);
        mode.setOnAction(this::setmode);
        Depth_box.getItems().addAll(Depth);
        Depth_box.setOnAction(this::setDepth);
    }
    // Set the Algorithm
    public void setmode(ActionEvent event){
        String m=mode.getValue();
        if(m.equals("MiniMax")){
            label2.setText("Minimax Algorithm");
        }else{
            label2.setText("Alpha-Beta Algorithm");
        }
    }
    //set the Depth
    public void setDepth(ActionEvent event){
        depth=Integer.parseInt(Depth_box.getValue());
    }
    //restart the game
   public void restart(ActionEvent event){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Restart");
        alert.setHeaderText("You're about to restart!");
        alert.setContentText("Do you want to restart?: ");

        if(alert.showAndWait().get()==ButtonType.OK) {
            int[][] a={{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
            Circle[][] c = Circles();
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    c[i][j].setFill(Color.valueOf("F7FBFF"));
                    turn.setText("1");
                    root.state=a;
                    root.win=0;
                    root.heuristic=0;
                    root.PlayerWin=0;
                    root.AiWin=0;
                    Player_Score.setText("0");
                    Ai_Score.setText("0");
                }
            }
        }
   }
   // Ai think
   public void Ai () throws CloneNotSupportedException {
        Node temp =(Node) root.clone();
       int move=0;
        if(label2.getText().equals("Minimax Algorithm")) {
            temp = Algorithm.minimax(temp, depth, true);

        }else if(label2.getText().equals("Alpha-Beta Algorithm")) {
           temp =Algorithm.alphabeta(temp,depth,new Node(Double.NEGATIVE_INFINITY),new Node(Double.POSITIVE_INFINITY),true);
        }
       move = print(temp).move;
       for (int i = 5; i >=0 ; i--) {
           if(CheakAI(move) ){
               break;
           }
       }
   }
   // win cheak
   public boolean win() {
       int[][] a = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
       Circle[][] c = Circles();
       if (root.isFull() && Integer.parseInt(root.PlayerWinS)  <Integer.parseInt(root.AiWinS) ) {
           WinMessage("GameOver","Ai win",c,a);
           return false;
       } else if (root.isFull() && Integer.parseInt(root.PlayerWinS) >Integer.parseInt(root.AiWinS)) {
           WinMessage("Victory","player win",c,a);
           return false;
       }else if (root.isFull() && Integer.parseInt(root.PlayerWinS) ==Integer.parseInt(root.AiWinS)) {
           WinMessage("Draw"," Draw ",c,a);
           return false;
       }
       return true;
   }
   //return the print of Algorithm
    public  Node print(Node n){
        if (n.parent.equals(root)) {
            return n;
        } else {
           // n.parent.toString();
            return print(n.parent);
        }
    }
    // play the ai move
    public boolean CheakAI(int position) throws CloneNotSupportedException {
        Circle[][] c = Circles();
        Circle[] c2 = c[position];
        for (int i =  c2.length-1; i >= 0; i--) {
            Color c3 = (Color) c2[i].getFill();
            String hex = String.format("#%02X%02X%02X",
                    (int) (c3.getRed() * 255),
                    (int) (c3.getGreen() * 255),
                    (int) (c3.getBlue() * 255));
            if (hex.equals("#F7FBFF")) {
                c2[i].setFill(Color.BLACK);
                root = Node.BuildChild( root,position, true,0);
                return true;
            }
        }
        return false;
    }
    public void WinMessage(String s,String s2,Circle[][] c,int[][] a){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(s);
        alert.setContentText(s);
        System.out.println(s2);
        System.out.println(root);
        if (alert.showAndWait().get() == ButtonType.OK) {
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    c[i][j].setFill(Color.valueOf("F7FBFF"));

                }

            }
        }
        root.state = a;
        root.win = 0;
        root.heuristic=0;
        root.AiWinS="0";
        root.PlayerWinS="0";
    }
    public Circle[][] Circles(){
        Circle[][] c = {{circle1, circle11, circle12, circle13, circle14, circle15}, {circle2, circle21, circle22, circle23, circle24, circle25},
                {circle3, circle31, circle32, circle33, circle34, circle35}, {circle4, circle41, circle42, circle43, circle44, circle45},
                {circle5, circle51, circle52, circle53, circle54, circle55}, {circle6, circle61, circle62, circle63, circle64, circle65},
                {circle7, circle71, circle72, circle73, circle74, circle75}};
        return c;
    }
    public void AiPlaying() throws CloneNotSupportedException {
        System.out.println();
        if (win()){
            Ai();
            Player_Score.setText(root.PlayerWinS);
            Ai_Score.setText(root.AiWinS);
            win();
        }
        System.out.println("the Number of Nodes = "+Algorithm.count);
        Algorithm.count=0;
    }

}

