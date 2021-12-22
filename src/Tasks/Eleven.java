package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Eleven extends Task {

    public Eleven(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Eleven_START = new WorldArea(
    			new WorldPoint(3090, 3470, 3), 
    			new WorldPoint(3089, 3473, 3));
        return OB_Eleven_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");

        final SimpleObject Climbing_Rocks = (SimpleObject) ctx.objects.populate().filter(10851).nearest().next();
        Climbing_Rocks.turnTo();
        System.out.println("Trying to validate...");
        if(Climbing_Rocks.click("Climb")){
        		System.out.println("Validated");
        		ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Robbing Pyramid";
    }
}