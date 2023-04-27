
/**
 * Write a description of class Pinsetter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseballBot extends BetterTurnerRobot
{
    public void mp(){
        pickBeeper();
        turnLeft();
        move();
        turnRight();
        move();
    }
    public void redundMove(){
        mp();mp();mp();mp();
    }
    public void twice(boolean home){
        redundMove();
        turnRight();
        move();move();
        turnRight();
        redundMove();
        if(home)
            return;
        turnAround();
        move();
        move();
    }
    public void home(int f, int s){
        for(int x = 0; x < f; x++){
            move();
        }
        turnRight();
        for(int x = 0; x < s; x++){
            move();
        }
    }
    /**
     * Constructor for objects of class Pinsetter
     */
    public void clearDiamond(){
        move();
        twice(false);twice(true);home(3, 4);turnRight();
    }
    public BaseballBot(int st, int ave, Direction dir, int beeps)
    {
        super(st,ave, dir, beeps);
    }
}
