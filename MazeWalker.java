
/**
 * Write a description of class MazeWalker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MazeWalker extends SmartBot
{
    protected int st, ave;
    public MazeWalker(int st, int ave, Direction dir, int beeps)
    {
        super (st,ave, dir, beeps);
        this.st = st;
        this.ave = ave;
    }
    public void move(){
        if(facingNorth()){
            st++;
        }
        if(facingSouth()){
            st--;
        }
        if(facingEast()){
            ave++;
        }
        if(facingWest()){
            ave--;
        }
        super.move();
    }
    
    public boolean wallOnLeft(int[][] visited)
    {
       turnLeft();
       boolean r = frontIsClear();
       if(r){
           move();
           r=r&&visited[st][ave]==0;
           stepBackwards();
       }
       turnRight();
       return !r;
    }
    public boolean wallOnRight(int[][] visited)
    {
       turnRight();
       boolean r = frontIsClear();
       if(r){
           move();
           r=r&&visited[st][ave]==0;
           stepBackwards();
       }
       turnLeft();
       return !r;
    }
    public boolean frontIsClear(int[][] visited){
        if(super.frontIsClear()){
            move();
            boolean a = visited[st][ave]==0&&countBeepers()!=9;
            if(countBeepers()==9){
                track();
            }
            stepBackwards();
            return a;
        }else{
            return false;
        }
    }

    public void followWallRight(boolean beepersarewalls)
    {
        if(countBeepers()==9){
            turnAround();
            return;
        }
        if(frontIsClear()){
            move();
            if(!wallOnRight()){
                turnRight();
            }
        }else{
            turnLeft();
        }
    }
    
    public void track(){}
}

