package scripts.utils.player;

import org.tribot.api2007.Player;


public class MyPlayer{
    private static long lastAnimation;

    public static void checkAnimation(){
        if(Player.getAnimation() != -1){
            lastAnimation = System.currentTimeMillis();
        }
    }

    public static long getTimeSinceLastAnimation(){
        return (System.currentTimeMillis() - lastAnimation);
    }

}
