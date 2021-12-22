package src.Tasks;

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
    	final SimpleItem food = ctx.inventory.filter("Shark").next();
    	
    	System.out.println("Eating Food....");
    	if(food != null) {
    		food.click(0);
    	}
    }

    @Override
    public String status() {
        return "Munching on some Grub.";
    }
}