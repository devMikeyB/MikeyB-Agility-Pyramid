package src;

import src.Tasks.*;
import simple.hooks.scripts.Category;
import simple.hooks.scripts.ScriptManifest;
import simple.hooks.scripts.task.Task;
import simple.hooks.scripts.task.TaskScript;
import simple.hooks.simplebot.ChatMessage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ScriptManifest(author = "MikeyB", name = "MikeyB | Agility Pyramid", category = Category.AGILITY, version = "1.0",
description = "Start anywhere that ::home can be utilized.", discord = "Mike #8528", servers = { "Novea" })

public class Pyramid extends TaskScript {
	private List tasks = new ArrayList();
	public int pyramidsAcquired = 0;
	public int runsComplete = 0;
	private String status;
	private long startTime;
	//public int
	
	@Override
	public boolean prioritizeTasks() {
		return true;
	}
	
	@Override
	public List<Task> tasks() {
		return tasks;
	}
	
	@Override
	public void onProcess() {
		super.onProcess();
		status = getScriptStatus();
	}
	
	@Override
	public void onExecute() {
		startTime = System.currentTimeMillis();
		tasks.addAll(Arrays.asList(
				new eat(ctx),
				new Start(ctx),
				new One(ctx),
				new Two(ctx),
				new Three(ctx),
				new Four(ctx),
				new Five(ctx),
				new Six(ctx),
				new Seven(ctx),
				new Eight(ctx),
				new Nine(ctx),
				new Ten(ctx),
				new Eleven(ctx),
				new Twelve(ctx),
				new Thirteen(ctx)
				));
	}
	
	@Override
	public void onTerminate() {
		
	}
	
	@Override
	public void onChatMessage(ChatMessage msg) {
		if (msg.getMessage().contains("have been rew")) {
			pyramidsAcquired ++;
		}
		if (msg.getMessage().contains("completed the") ) {
			runsComplete ++;
		}
	}
	
	@Override
	 public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(5, 2, 192, 85);

        g.setColor(Color.decode("#303030"));
        g.drawRect(5, 2, 192, 85);

        g.setColor(Color.decode("#4d4d4d"));
        g.drawLine(8, 24, 194, 24);

        g.setColor(Color.decode("#3150ad"));
        g.drawString("v. " + "1.0", 160, 20);

        g.setColor(Color.decode("#787878"));
        g.drawString("MikeyB | Agility Pyramid", 12, 20);
        g.drawString("Time: " + ctx.paint.formatTime(System.currentTimeMillis() - startTime), 14, 42);
        g.drawString("Status: " + status, 14, 56);
        g.drawString("Runs Complated: " + runsComplete, 14, 70);
        g.drawString("Pyramids Acquired: " + pyramidsAcquired, 14, 84);
	}
	
	
	
	
}
