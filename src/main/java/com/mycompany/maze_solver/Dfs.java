/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Dfs {
    
    public static boolean pathFinder(int[][] grid , int row , int col , List<Integer> path , int[][] dir)
    {
        if(grid[row][col] == 9)
        {
            path.add(row);
            path.add(col);
            return true;
        }
        
        if(grid[row][col] == 0)
        {
            grid[row][col] = 2; //mark visited
            
            for(int i=0;i<4;i++)
            {
                int newrow = row + dir[i][0];
                int newcol = col + dir[i][1];
                
                if(pathFinder(grid , newrow , newcol , path , dir))
                {
                    path.add(row);
                    path.add(col);
                    return true;
                }
            }
        }
        
        return false;
    }
    
   
}
