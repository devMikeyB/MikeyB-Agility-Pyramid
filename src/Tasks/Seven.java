package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Seven extends Task {

    public Seven(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Seven_START = new WorldArea(
    			new WorldPoint(3089, 3474, 2), 
    			new WorldPoint(3082, 3468, 2));
        return OB_Seven_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");

        final SimpleObject gap = (SimpleObject) ctx.objects.populate().filter(10859).nearest().next();
        gap.turnTo();
        System.out.println("Trying to validate...");
        if(gap.click("Jump")){
        		System.out.println("Validated");
        		ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 7";
    }
}