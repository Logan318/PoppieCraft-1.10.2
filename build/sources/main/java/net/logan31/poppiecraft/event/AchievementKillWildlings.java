package net.logan31.poppiecraft.event;

import com.google.common.eventbus.DeadEvent;
import net.logan31.poppiecraft.entity.Darker;
import net.logan31.poppiecraft.entity.GoldenChicken;
import net.logan31.poppiecraft.entity.Jumper;
import net.logan31.poppiecraft.entity.Speedster;
import net.logan31.poppiecraft.handler.AchievementHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by johanjulien on 07/10/2017.
 */
public class AchievementKillWildlings {



    @SubscribeEvent
    public void wildlingsKiller(DeadEvent e) {
EntityPlayer player = null;
        Speedster speedster = null;
        Jumper jumper = null;
        Darker darker = null;
      if(e.getSource() != null && e.getSource() == speedster) {

              if(!player.hasAchievement( AchievementHandler.KillWildlings)) {
                  player.addStat(AchievementHandler.KillWildlings);
          }

      }


    }
}
