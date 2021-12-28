package src.Tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Twelve extends Task {

    public Twelve(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Twelve_START = new WorldArea(
    			new WorldPoint(3085, 3471, 3), 
    			new WorldPoint(3089, 3473, 3));
        return OB_Twelve_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {	
        //System.out.print("stage 1");
    	ctx.mouse.click(560, 20, true);
        final SimpleObject Ledge = (SimpleObject) ctx.objects.populate().filter(37965).nearest().next();
        Ledge.turnTo();
        System.out.println("Trying to validate...");
        if(Ledge.click("Cross")){
        		System.out.println("Validated");
        		//ctx.sleep(2000);
        }
        	
    }

    @Override
    public String status() {
        return "Leaving Pyramid";
    }
}