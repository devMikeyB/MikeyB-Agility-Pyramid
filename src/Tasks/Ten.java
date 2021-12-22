package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Ten extends Task {

    public Ten(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Ten_START = new WorldArea(
    			new WorldPoint(3088, 3475, 3), 
    			new WorldPoint(3091, 3473, 3));
        return OB_Ten_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");

        final SimpleObject Low_Wall = (SimpleObject) ctx.objects.populate().filter(37977).nearest().next();
        Low_Wall.turnTo();
        System.out.println("Trying to validate...");
        if(Low_Wall.click("Climb-over")){
        		System.out.println("Validated");
        		ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 10";
    }
}