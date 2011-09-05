package paul_t.Hints;


import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;


public class HintsBlockListener extends BlockListener {
    private final Hints plugin;

    public HintsBlockListener(final Hints plugin) {
        this.plugin = plugin;
    }
/*
    @Override
    public void onBlockPhysics(BlockPhysicsEvent event) {
    	try {
    		
	        Block block = event.getBlock();
	
	        if ((block.getType() == Material.SAND) || (block.getType() == Material.GRAVEL)) {
		        if(!Hints.PlayerList.get(event.getPlayer()).get("Physics"))
		        {
		        	event.getPlayer().sendMessage(Hints.Physics); //Send them the first move message from hints settings.
		        	Hints.PlayerList.get(event.getPlayer()).remove("Physics");//Remove the previous boolean
		        	Hints.PlayerList.get(event.getPlayer()).put("Physics", true);//Add the new boolean showing they have moved once.
		        }
	        }
    	} catch (Throwable e)
    	{
    		ErrorReporting.Report(e);
    	}
    }
*/
    @Override
    public void onBlockBreak(BlockBreakEvent event)
    {
    	try {
	        if(!Hints.PlayerList.get(event.getPlayer()).get("Break"))
	        {
	        	event.getPlayer().sendMessage(Hints.Break); //Send them the first move message from hints settings.
	        	Hints.PlayerList.get(event.getPlayer()).remove("Break");//Remove the previous boolean
	        	Hints.PlayerList.get(event.getPlayer()).put("Break", true);//Add the new boolean showing they have moved once.
	        }
    	} catch (Throwable e)
    	{
    		ErrorReporting.Report(e);
    	}
    }
    /*
    @Override
    public void onBlockCanBuild(BlockCanBuildEvent event) {
    	try {
    		 Not the right event methinks...
	        if(!Hints.PlayerList.get(event.getPlayer()).get("Build"))
	        {
	        	event.getPlayer().sendMessage(Hints.Build); //Send them the first move message from hints settings.
	        	Hints.PlayerList.get(event.getPlayer()).remove("Build");//Remove the previous boolean
	        	Hints.PlayerList.get(event.getPlayer()).put("Build", true);//Add the new boolean showing they have moved once.
	        }
	        
    	} catch (Throwable e)
    	{
    		ErrorReporting.Report(e);
    	}
    }
    */
}
