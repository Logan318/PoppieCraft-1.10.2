package net.logan31.poppiecraft.handler;

import net.logan31.poppiecraft.event.BaneOfWildlingsEvent;
import net.logan31.poppiecraft.event.SoulStealerEvent;
import net.logan31.poppiecraft.event.WildlingsProtectionEvent;
import net.logan31.poppiecraft.event.onTouchEntityEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by johanjulien on 03/12/2017.
 */
public class EventHandler {


    public void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new onTouchEntityEvent());
        MinecraftForge.EVENT_BUS.register(new SoulStealerEvent());
        MinecraftForge.EVENT_BUS.register(new BaneOfWildlingsEvent());
        MinecraftForge.EVENT_BUS.register( new WildlingsProtectionEvent() );
    }
}
