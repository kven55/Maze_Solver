/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class MazeSolver extends JFrame implements ActionListener{
    
    private static int[][] grid = {{1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,0,1,0,1,0,1,0,0,0,0,0,1},
    {1,0,1,0,0,0,1,0,1,1,1,0,1},
    {1,0,1,1,1,1,1,0,0,0,0,0,1},
    {1,0,0,1,0,0,0,0,1,1,1,0,1},
    {1,0,1,0,1,1,1,0,1,0,0,0,1},
    {1,0,1,0,1,0,0,0,1,1,1,0,1},
    {1,0,1,0,1,1,1,0,1,0,1,0,1},
    {1,0,0,0,0,0,0,0,0,0,1,9,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1}};
    
    public static ArrayList<Integer> path = new ArrayList<>();
    
    public static int[][] dir = {{-1 ,0} , {1 , 0} , {0 , -1} , {0 , 1}};
    
    private Button pathButton;
    
    private boolean buttonPressed = false;
    
    
    MazeSolver()
    {
        this.setTitle("MAZE SOLVER");
        this.getContentPane().setLayout(null);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        pathButton = new Button("Find Path");
        pathButton.setFont(new Font("Arial" , Font.BOLD , 18));
        pathButton.setForeground(Color.RED);
        pathButton.setBounds(30*grid[0].length/2, 30*grid.length + 100 , 100 , 50);
        pathButton.setBackground(Color.GRAY);
        this.getContentPane().add(pathButton);
        pathButton.setFocusable(false);
        pathButton.addActionListener(this);
        
    }
    
    public void paint(Graphics g)
    {
        super.paintComponents(g);
        g.translate(50,100);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                Color color;
                switch(grid[i][j])
                {
                    case 1 : color = Color.GRAY;
                             break;
                    case 9 : color = Color.RED;
                             break;
                    default : color = Color.WHITE;
                              break;
                }
                
                g.setColor(color);
                g.fillRect(30*j , 30*i , 30 , 30);
                g.setColor(Color.BLACK);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        
        if(buttonPressed)
        {
            for(int i=0;i<path.size();i+=2)
            {
                int xcord = path.get(i);
                int ycord = path.get(i+1);
                g.setColor(Color.GREEN);
                g.fillRect(30*ycord, 30*xcord, 30, 30);
            }
            
           
        }
    }
    
    
    
    
    public static void main(String[] args)
    {
        MazeSolver ms = new MazeSolver();
        ms.setVisible(true);
        
        Dfs.pathFinder(grid , 1 , 1 , path , dir);
//        System.out.print(path);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            buttonPressed = true;
            pathButton.setVisible(false);
            repaint();
            
            
    }
}
