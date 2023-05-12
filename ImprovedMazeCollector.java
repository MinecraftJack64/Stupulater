
import java.awt.Color;

/**
 * Write a description of class MazeCollector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImprovedMazeCollector extends MazeWalker
{
    private int[][] visited;
    private String track, bt;
    public ImprovedMazeCollector(int st, int ave, Direction dir, int num)
    {
        super(st, ave, dir, num);
        visited = new int[27+1][29+1];
        track = "";
    }
    public void frack(String best){
        while(best.length()>0){
            switch(best.charAt(0)){
                case 'm':
                    move();
                break;
                case 'l':
                    turnLeft();
                break;
                case 'r':
                    turnRight();
                break;
            }
            best = best.substring(1);
        }
    }
    public void track(){
        bt = track;
    }
    public void backtrack(){
        if(track.length()==0){
            turnAround();
            sprawl();
            return;
        }
        switch(track.charAt(track.length()-1)){
            case 'm':
                move();
            break;
            case 'l':
                turnRight();
            break;
            case 'r':
                turnLeft();
            break;
        }
        track = track.substring(0, track.length()-1);
        if(visited[st][ave]==2){
            if('l'==track.charAt(track.length()-1)){
                turnRight();
                track = track.substring(0, track.length()-1);
            }else if('r'==track.charAt(track.length()-1)){
                turnLeft();
                track = track.substring(0, track.length()-1);
            }
            turnAround();
            boolean r = !wallOnRight(visited);
            boolean l = !wallOnLeft(visited);
            boolean f = frontIsClear(visited);
            turnAround();
            if(r||l||f){
                turnAround();
                return;
            }else{
                if(visited[st][ave]==2){
                    visited[st][ave]=1;
                }
                backtrack();
            }
        }else{
            backtrack();
        }
    }
    public void sprawl(){
        while(nextToABeeper()){
            pickBeeper();
        }
        if(visited[st][ave]==0){
            visited[st][ave] = 1;
        }
        boolean r = !wallOnRight(visited);
        boolean l = !wallOnLeft(visited);
        boolean f = frontIsClear(visited);
        while(r||l||f){
            r = !wallOnRight(visited);
            l = !wallOnLeft(visited);
            f = frontIsClear(visited);
            if(r&&!(l||f)){
                turnRight();
                track+="r";
            }else if(l&&!(r||f)){
                turnLeft();
                track+="l";
            }else if(f&&!(l||r)){
                move();
                track+="m";
            }else{
                if(visited[st][ave]==1){
                    visited[st][ave]=2;
                }
                
                if(r){
                    turnRight();
                    track+="r";
                }else if(f){
                    move();
                    track+="m";
                }else if(l){
                    turnLeft();
                    track+="l";
                }
            }
            sprawl();
        }
        if(visited[st][ave]==2){
            visited[st][ave]=1;
        }
        if(track.length()==0){
            return;
        }
        turnAround();
        backtrack();
    }
    public void task()
    {
        sprawl();
        World.setDelay(5);
        frack(bt);
        move();
        move();
        System.out.println("Shortest path: "+bt);
    }
}