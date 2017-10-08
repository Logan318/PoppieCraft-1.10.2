package net.logan31.poppiecraft.handler;


import net.logan31.poppiecraft.Utils.References;
import net.logan31.poppiecraft.init.ModArmor;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by johanjulien on 30/09/2017.
 */
public class AchievementHandler  {

    private static List<Achievement> achievements = new ArrayList<Achievement>();

    public static Achievement RedstoneArmor = createAchievement("RedstoneArmor", -1, -2, ModArmor.Redstone_helmet, AchievementList.BUILD_BETTER_PICKAXE);
    public static Achievement LapisArmor = createAchievement("LapisArmor", 2, 1, ModArmor.Lapis_helmet, AchievementList.BUILD_BETTER_PICKAXE);
    public static Achievement QuartzArmor = createAchievement("QuartzArmor", 1, 2, ModArmor.Quartz_helmet, AchievementList.BUILD_BETTER_PICKAXE);
    public static Achievement GlowstoneArmor = createAchievement("GlowstoneArmor", -2, 1, ModArmor.Glowstone_helmet, AchievementList.BUILD_BETTER_PICKAXE);
    public static Achievement ObsidianArmor = createAchievement("ObsidianArmor", -1, 2, ModArmor.Obsidian_helmet, AchievementList.BUILD_BETTER_PICKAXE);
    public static Achievement CoalArmor = createAchievement("CoalArmor", 2, -1, ModArmor.Coal_helmet, AchievementList.BUILD_BETTER_PICKAXE);
    public static Achievement LeafCloverArmor = createAchievement("LeafCloverArmor", 1, -2, ModArmor.Four_leaf_clover_helmet, AchievementList.BUILD_BETTER_PICKAXE);
    public static Achievement EmeraldArmor = createAchievement("EmeraldArmor", -2, -1, ModArmor.Emerald_helmet, AchievementList.BUILD_BETTER_PICKAXE);



    public static void registerAchievements() {

        Achievement[] achievementArray = new Achievement[achievements.size()];
        for(Achievement achievement : achievements) {
            achievement.registerStat();
            achievementArray[achievements.indexOf(achievement)] = achievement;
        }

        AchievementPage.registerAchievementPage(new AchievementPage(References.NAME, achievementArray));

    }


    private static Achievement createAchievement(String name, int column, int row, Item item, Achievement parent) {
        Achievement achievement = new Achievement("achievement." + name, name, column, row, item, parent);
        achievements.add(achievement);
        return achievement;

    }


    private static Achievement createAchievement(String name, int column, int row, Block block) {
        Achievement achievement = new Achievement("achievement." + name, name, column, row, block, (Achievement)null);
        achievements.add(achievement);
        return achievement;
    }


    private static Achievement createAchievement(String name, int column, int row, ItemStack stack) {
        Achievement achievement = new Achievement("achievement." + name, name, column, row, stack, (Achievement)null);
        achievements.add(achievement);
        return achievement;

    }
}
