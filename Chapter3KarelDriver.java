
/**
 * Write a description of class NasaBotDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chapter3KarelDriver implements Directions
{
    public static void main(String args[])
    {
        BaseballBot karel = new BaseballBot(1,6,North, 0);
        karel.clearDiamond();
    }
    static
    {
        World.reset();    
        World.readWorld("ch3_4.kwld");
        World.setDelay(5);
        World.setVisible(true);        
    }
    
}
