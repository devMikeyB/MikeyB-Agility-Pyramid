package src.Tasks;

//import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;
//import net.runelite.api.GameObject;
import simple.hooks.scripts.task.Task;
//import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;
import simple.robot.utils.WorldArea;

public class Thirteen extends Task {
	/* These 4 integers are part of an idea I have to properly solve the 
	 * hard-to-click object issue. Using the Runlite client I will draw a boundary
	 * around the clickable space of an object, then click inside those 
	 * coordinates in a random location. This is still a hacky solution,
	 * but as least it would be more reliable than the camera pan / click-through
	 * solution currently in place. Doors be damned.
	private int clipX1;
	private int clipX2;
	private int clipY1;
	private int clipY2;
*/
    public Thirteen(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	final WorldArea OB_Thirteen_START = new WorldArea(
    			new WorldPoint(3085, 3474, 3), 
    			new WorldPoint(3089, 3476, 3));
        return OB_Thirteen_START.containsPoint(ctx.players.getLocal().getLocation());
    }

    @Override
    public void run() {
        //System.out.print("stage 1");
    	//final WorldPoint tile = WorldPoint(3087, 3475, 3);
        //final SimpleObject Doorway = (SimpleObject) ctx.objects.populate().filter(10855).nearest().next();
        //System.out.println(ctx.getViewport());
        //Doorway.turnTo();
        //Doorway.validateInteractable();
        
        ctx.viewport.pitch(30);
        ctx.viewport.angle(50);
        ctx.mouse.click(273, 171, true);
        ctx.sleep(3000);
        //if(Doorway.click(0)){
        		//System.out.println("Validated");
        		//ctx.sleep(2000);
       // }
        	
    }

    @Override
    public String status() {
        return "Exiting Pyramid";
    }
}