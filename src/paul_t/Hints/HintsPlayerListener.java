package paul_t.Hints;

import java.util.HashMap;

import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

public class HintsPlayerListener extends PlayerListener {
    private final Hints plugin;

    public HintsPlayerListener(Hints instance) {
        plugin = instance;
    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
    	try {
	    	HashMap<String, Boolean> Temp = new HashMap<String, Boolean>();
	    	Temp.put("Break", false);
	    	Temp.put("Chat", false);
	    	//Temp.put("Bed", false);//Need to figure out how to do this first
	    	//Temp.put("Die", false);//Entities? Sounds like another listener then a check if they're a player or an NPC/mob...
	    	Temp.put("Move", false);
	    	//Temp.put("Physics", false);
	    	//Temp.put("Build", false);
	    	Hints.PlayerList.put(event.getPlayer(), Temp);
	        System.out.println("[Hints] Loaded " + event.getPlayer().getName() + " to memory.");
    	} catch (Throwable e)
    	{
    		ErrorReporting.Report(e);
    	}
    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {
    	try {
	    	Hints.PlayerList.remove(event.getPlayer());
	        System.out.println("[Hints] Removed " + event.getPlayer().getName() + " from memory.");
    	} catch (Throwable e)
    	{
    		ErrorReporting.Report(e);
    	}
    }
    @Override
    public void onPlayerChat(PlayerChatEvent event)
    {
    	try {
	        if(!Hints.PlayerList.get(event.getPlayer()).get("Chat"))
	        {
	        	event.getPlayer().sendMessage(Hints.Chat); //Send them the first move message from hints settings.
	        	Hints.PlayerList.get(event.getPlayer()).remove("Chat");//Remove the previous boolean
	        	Hints.PlayerList.get(event.getPlayer()).put("Chat", true);//Add the new boolean showing they have moved once.
	        } 
    	} catch (Throwable e)
    	{
    		ErrorReporting.Report(e);
    	}
    }
    @Override
    public void onPlayerMove(PlayerMoveEvent event) {
    	try {
	        if(!Hints.PlayerList.get(event.getPlayer()).get("Move"))
	        {
	        	event.getPlayer().sendMessage(Hints.Move); //Send them the first move message from hints settings.
	        	Hints.PlayerList.get(event.getPlayer()).remove("Move");//Remove the previous boolean
	        	Hints.PlayerList.get(event.getPlayer()).put("Move", true);//Add the new boolean showing they have moved once.
	        }
    	} catch (Throwable e)
    	{
    		ErrorReporting.Report(e);
    	}
    }
}
