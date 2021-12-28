package src.Tasks;

import java.util.Arrays;

import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleItem;
import simple.robot.api.ClientContext;

public class eat extends Task {

    public eat(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
    	return 50 > ctx.players.getLocal().getHealth();
    	
    }

    @Override
    public void run() {
    //Eat Food
    	
    	
    	
    	while (50 > ctx.players.getLocal().getHealth()) {
    		for (SimpleItem i : ctx.inventory.populate().filterHasAction("Eat")) {
                if (i != null && ctx.players.getLocal().getHealth() < 50)  {
                    i.click(1);
                    System.out.println("Clicked: " + i);
                }
            }
    		
    	}
    	
    }

    @Override
    public String status() {
        return "Munching on some Grub.";
    }
}