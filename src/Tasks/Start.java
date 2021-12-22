package src.Tasks;

import simple.hooks.scripts.task.Task;
import simple.hooks.simplebot.Game;
//import simple.hooks.simplebot.teleporter.Teleporter;
import simple.hooks.wrappers.SimpleLocalPlayer;
import simple.hooks.wrappers.SimpleObject;
import simple.robot.api.ClientContext;

public class Start extends Task {
	//This start point is residual from a copy/paste and should not be referenced.
	//private static WorldPoint startPoint = new WorldPoint(3093, 3481, 0);
	
	public Start(ClientContext ctx) {
		super(ctx);
	}
	
	@Override
	public boolean condition() {
		final SimpleLocalPlayer player = (SimpleLocalPlayer) ctx.players.getLocal();
		return (
				player.getLocation().getPlane() == 0);
	}
	
	@Override
	public void run() {
		ctx.viewport.pitch(40);
		ctx.viewport.angle(-40);
		ctx.game.tab(Game.Tab.INVENTORY);
		
		final SimpleObject stairs = (SimpleObject) ctx.objects.populate().filter(10857).nearest().next();
		
		if (!ctx.players.getLocal().isAnimating()){
			if(stairs.validateInteractable() && stairs.click(0)) {
				ctx.sleep(3000);
			}
		}
		
	}
	
	@Override
	public String status() {
		return "Getting Started.";
	}
}