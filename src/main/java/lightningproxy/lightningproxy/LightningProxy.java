package lightningproxy.lightningproxy;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerConnectedEvent;
import com.velocitypowered.api.event.player.ServerPostConnectEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(
        id = "lightningproxy",
        name = "LightningProxy",
        version = "1.0-SNAPSHOT",
        description = "Provides commands for proxy",
        url = "http://web.lightning-mc.xyz/",
        authors = {"JTMcQuigg"}
)
public class LightningProxy {

    @Inject
    private ProxyServer proxyServer;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        System.out.println("Loaded Lightning");
    }

    @Subscribe
    public void chatsetter(ServerPostConnectEvent event){
        if (event.getPlayer().getCurrentServer().get().getServerInfo().getName().equalsIgnoreCase("minigames")  || (event.getPlayer().getCurrentServer().get().getServerInfo().getName().equalsIgnoreCase("bedwars"))){
            proxyServer.getCommandManager().executeImmediatelyAsync(event.getPlayer(), "local");
        }else {
            proxyServer.getCommandManager().executeImmediatelyAsync(event.getPlayer(), "global");
        }
    }
    public void firstjoin(ServerConnectedEvent event){
        if (event.getServer().getServerInfo().getName().equalsIgnoreCase("minigames")){
            proxyServer.getCommandManager().executeImmediatelyAsync(event.getPlayer(), "local");
        }else {
            proxyServer.getCommandManager().executeImmediatelyAsync(event.getPlayer(), "global");
        }
    }
}