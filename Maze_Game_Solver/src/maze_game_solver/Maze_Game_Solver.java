/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maze_game_solver;
//import java.util.Scanner;
/**
 *
 * @author ruoxili
 */
public class Maze_Game_Solver {

    /**
     * @param args the command line arguments
     */
    final int n =  10;
    
    void printSolution(int sol[][]){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++)
                System.out.print(" "+sol[i][j]+" ");
            System.out.println();
        }
    }
    
    boolean isSafe(int maze [][], int x, int y){
        //ensures that the tracing stays within the maze area - returns false if not
        return (x>=0 && x<n && y>=0 && y<n && maze[x][y]==1);
    }
    
    boolean solveMaze(int maze[][]){
        int sol[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        if (solveMazeUtil(maze, 0, 0, sol) == false){
            System.out.print("Solution DNE");
            return false;
        }
        printSolution(sol);
        return true;
    }
    
    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]){
        if (x == n-1 && y == n-1){
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y) == true){
            sol[x][y] = 1;
            
            if (solveMazeUtil(maze, x+1, y, sol))
                return true;
            if (solveMazeUtil(maze, x, y+1, sol))
                return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Maze_Game_Solver tracer = new Maze_Game_Solver();
        int maze[][] = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 1, 0, 1, 0, 0},
                        {1, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {1, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1}};
        tracer.solveMaze(maze);
        
    }
    
}
