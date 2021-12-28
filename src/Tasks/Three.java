package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Three extends Task {

    public Three(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_THREE_START = new WorldArea(
    			new WorldPoint(3083, 3474, 1), 
    			new WorldPoint(3080, 3481, 1));
    	
    	
        return OB_THREE_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");
    	ctx.mouse.click(560, 20, true);
        final SimpleObject ledge = (SimpleObject) ctx.objects.populate().filter(37961).nearest().next();
        ledge.turnTo();
        System.out.println("Trying to validate...");
        if(ledge.click("Cross")){
        		System.out.println("Validated");
        		//ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 3";
    }
}