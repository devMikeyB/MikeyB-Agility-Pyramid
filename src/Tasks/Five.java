package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Five extends Task {

    public Five(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Five_START = new WorldArea(
    			new WorldPoint(3093, 3474, 2), 
    			new WorldPoint(3090, 3477, 2));
        return OB_Five_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");
    	ctx.mouse.click(560, 20, true);
        final SimpleObject gap = (SimpleObject) ctx.objects.populate().filter(37974).nearest().next();
        gap.turnTo();
        System.out.println("Trying to validate...");
        if(gap.click("Jump")){
        		System.out.println("Validated");
        		//ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 5";
    }
}