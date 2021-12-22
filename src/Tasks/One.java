package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleItem;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class One extends Task {

    public One(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_ONE_START = new WorldArea(
    			new WorldPoint(3094, 3472, 1), 
    			new WorldPoint(3093, 3479, 1));
        return OB_ONE_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        System.out.print("stage 1");
        final SimpleItem food = ctx.inventory.filter("Shark").next();
        final SimpleObject ledge = (SimpleObject) ctx.objects.populate().filter(37959).nearest().next();
        if (50 > ctx.players.getLocal().getHealth()) {
        	if (food != null) {
        		food.click(0);
        	}
        }
        
        ledge.turnTo();
        System.out.println("Trying to validate...");
        if(ledge.validateInteractable() && ledge.click("Cross")){
        		System.out.println("Validated");
        		ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 1";
    }
}