package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Two extends Task {

    public Two(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_TWO_START = new WorldArea(
    			new WorldPoint(3094, 3467, 1), 
    			new WorldPoint(3081, 3469, 1));
    	final WorldArea OB_TWO_SECOND = new WorldArea(
    			new WorldPoint(3084, 3466, 1), 
    			new WorldPoint(3081, 3473, 1));

        return (OB_TWO_START.containsPoint(ctx.players.getLocal().getLocation()) || OB_TWO_SECOND.containsPoint(ctx.players.getLocal().getLocation()));
    	
    }

    @Override
    public void run() {
        final SimpleObject ledge = (SimpleObject) ctx.objects.populate().filter(37960).nearest().next();
        ledge.turnTo();
        //System.out.println("Trying to validate...");
        if(ledge.click("Cross")){
        		System.out.println("Validated");
        		ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 2";
    }
}