package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Eight extends Task {

    public Eight(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Eight_START = new WorldArea(
    			new WorldPoint(3082, 3476, 2), 
    			new WorldPoint(3085, 3479, 2));
        return OB_Eight_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");
    	ctx.mouse.click(560, 20, true);
        final SimpleObject Low_Wall = (SimpleObject) ctx.objects.populate().filter(37976).nearest().next();
        Low_Wall.turnTo();
        System.out.println("Trying to validate...");
        if(Low_Wall.click("Climb-over")){
        		System.out.println("Validated");
        		//ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 8";
    }
}