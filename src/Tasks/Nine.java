package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Nine extends Task {

    public Nine(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Nine_START = new WorldArea(
    			new WorldPoint(3085, 3476, 2), 
    			new WorldPoint(3091, 3479, 2));
        return OB_Nine_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");
    	ctx.mouse.click(560, 20, true);
        final SimpleObject stairs = (SimpleObject) ctx.objects.populate().filter(37970).nearest().next();
        stairs.turnTo();
        System.out.println("Trying to validate...");
        if(stairs.click(0)){
        		System.out.println("Validated");
        		//ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 9";
    }
}