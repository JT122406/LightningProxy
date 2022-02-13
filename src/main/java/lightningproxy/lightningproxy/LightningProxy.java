package lightningproxy.lightningproxy;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.Player;
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
    private Logger logger;



    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {

        System.out.println("Loaded Lightning");
    }


    @Inject
    private ProxyServer proxyServer;


    @Subscribe
    public void PostLoginEvent(Player player){
        if (player.getCurrentServer().equals("Minigames")){
            proxyServer.getCommandManager().executeAsync(player, "local");
        }

    }
}
