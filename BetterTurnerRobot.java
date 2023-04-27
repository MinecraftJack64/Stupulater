
/**
 * Write a description of class BetterTurnerRobot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BetterTurnerRobot extends UrRobot
{
    public void turnRight(){
        turnLeft();
        turnLeft();
        turnLeft();
    }
    public void turnAround(){
        turnLeft();
        turnLeft();
    }
    public void stepBackwards(){
        turnAround();
        move();
        turnAround();
    }
    /**
     * Constructor for objects of class BTR
     */
    public BetterTurnerRobot(int st, int ave, Direction dir, int beeps)
    {
        super(st,ave, dir, beeps);
        System.out.println("COnstruct");
    }
}
