package n.Z3Z.m;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BossBarAPI implements Listener{
	
	private static a y;
	public BossBarAPI(a hub) {
		BossBarAPI.y = hub;
	}
	
	public static HashMap<Integer, BossBar> g = new HashMap<Integer, BossBar>();
	public static void createBar(String name, BarColor color, Integer ID){
		BossBar b = Bukkit.createBossBar(z.f(name), color, BarStyle.SOLID, BarFlag.CREATE_FOG);
		g.put(ID, b);
		for(Player p : Bukkit.getOnlinePlayers()){
			g.get(ID).addPlayer(p);
		}
	}
	
	public static void removeBossBar(Integer ID){
		g.get(ID).setVisible(false);
		g.remove(ID);
	}
	
	public void renameBossBar(String name, Integer ID){
		g.get(ID).setTitle(z.f(name));
	}
	
	public void recolorBossBar(BarColor color, Integer ID){
		g.get(ID).setColor(color);
	}
	
	public static void createTempBossBar(String name, BarColor color, final Integer ID, Integer timeInSecondsBeforeRemove){
		createBar(name, color, ID);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(y, new Runnable(){
    		public void run() {
    			removeBossBar(ID);
    		}
    	}, timeInSecondsBeforeRemove * 20);
	}
	
}
