package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Six extends Task {

    public Six(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Six_START = new WorldArea(
    			new WorldPoint(3089, 3473, 2), 
    			new WorldPoint(3093, 3468, 2));
        return OB_Six_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");

        final SimpleObject Low_Wall = (SimpleObject) ctx.objects.populate().filter(10865).nearest().next();
        Low_Wall.turnTo();
        System.out.println("Trying to validate...");
        if(Low_Wall.click("Climb-over")){
        		System.out.println("Validated");
        		ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 6";
    }
}