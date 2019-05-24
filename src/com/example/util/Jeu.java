package com.example.util;

import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.example.util.ResourceUtility;

public class Jeu {
    private ImageIcon[][] figures = loadImages(); // initialise figure avec methodes images
    
    public Jeu() throws IOException {}
    
    public ImageIcon[][] loadImages() throws IOException {
        int rows = 4;
        int cols = 3;
        ImageIcon[][] images = ResourceUtility.splitImageIcon(
                ResourceUtility.loadBufferedImage("images/butterfly2.png")
                , rows, cols);
        
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                images[i][j].setDescription("c" + index++);
            }
        }

        return images;
    }
    public Deque<ImageIcon> creerPioche() {
        LinkedList<ImageIcon> cartes = new LinkedList<ImageIcon>();
      int rows=figures.length;
      int cols=figures[0].length;
      for (int i = 0; i < rows; i++) {
    	  for (int j = 0; j < cols; j++) {
    		  cartes.add(figures[i][j]);
    		  cartes.add(figures[i][j]);
    	  }
    	  }
      Collections.shuffle(cartes);
      return cartes;
      }
      
      // Autre solution pour remplir et mélanger les cartes
    /*public Deque<ImageIcon> creerPioche() {
        LinkedList<ImageIcon> list = new LinkedList<ImageIcon>();
        for (int i = 0; i < 2; i++) {
            for (int row = 0; row <= 3; row++) {
                for (int col = 0; col <= 2; col++) {
                    list.push(figures[row][col]);
                }
            }
        }
        Collections.shuffle(list);
        return list;
    }*/

}