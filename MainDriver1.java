/**
   @Author:
      Date:
   Teacher:
    Period:
  */
import java.awt.Color;

public class MainDriver1 extends Driver
{
    public static void main(String args[])  {
        ImprovedMazeCollector karel = new ImprovedMazeCollector(1, 1, East, 0);
        //CopyImprovedMazeCollector karel2 = new CopyImprovedMazeCollector(1, 1, East, 0);
        karel.task();
        World.setDelay(0);
        //karel2.task();
    } 

    static {
        World.reset(); 
        World.readWorld("maze.kwld"); 
        World.setBeeperColor(Color.magenta);
        World.setStreetColor(Color.blue);
        World.setNeutroniumColor(Color.green.darker().darker());
        World.setDelay(0);  
    }
}