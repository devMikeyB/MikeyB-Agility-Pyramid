package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Four extends Task {

    public Four(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Four_START = new WorldArea(
    			new WorldPoint(3086, 3478, 1), 
    			new WorldPoint(3093, 3481, 1));
        return OB_Four_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");

        final SimpleObject stairs = (SimpleObject) ctx.objects.populate().filter(37969).nearest().next();
        stairs.turnTo();
        System.out.println("Trying to validate...");
        if(stairs.click(0)){
        		System.out.println("Validated");
        		ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Completing Obstacle: 4";
    }
}