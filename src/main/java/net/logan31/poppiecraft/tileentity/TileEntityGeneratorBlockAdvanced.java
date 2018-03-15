package net.logan31.poppiecraft.tileentity;

import net.logan31.poppiecraft.Utils.Utils;
import net.logan31.poppiecraft.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Created by johanjulien on 17/10/2017.
 */
public class TileEntityGeneratorBlockAdvanced extends TileEntity  implements ITickable, ICapabilityProvider, ISidedInventory{

    private ItemStackHandler handler2;


    public TileEntityGeneratorBlockAdvanced () {
        this.handler2 = new ItemStackHandler(23);


    }


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);



    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return super.writeToNBT( compound );
    }

    public void generate(Item itemGenerate, int metaItem, Item itemGenerateBurn, int metaItemBurn) {

        Item bookEnch = Items.ENCHANTED_BOOK;
        ItemStack stack;
        ItemStack stackBurn;
        stack = new ItemStack( itemGenerate, 1, metaItem );
        stackBurn = new ItemStack( itemGenerateBurn, 1, metaItemBurn );

        for (int slot = 0, stop = 0; (slot < 18 && stop == 0); slot++) {


            if (this.handler2.getStackInSlot( 18 ) != null && this.handler2.getStackInSlot( 18 ).getItem() == bookEnch) {


                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments( this.handler2.getStackInSlot( 18 ) );
                if (enchantments.containsKey( Enchantments.FIRE_ASPECT )) {
                    if (this.handler2.getStackInSlot( slot ) == null || this.handler2.getStackInSlot( slot ).getItem() == itemGenerateBurn && this.handler2.getStackInSlot( slot ).stackSize < 64 && this.handler2.getStackInSlot( slot ).getMetadata() == metaItemBurn) {
                        this.handler2   .insertItem( slot, stackBurn, false );
                        stop = 1;

                    } else {
                        stop = 0;
                    }

                } else {
                    if (this.handler2.getStackInSlot( slot ) == null || this.handler2.getStackInSlot( slot ).getItem() == itemGenerate && this.handler2.getStackInSlot( slot ).stackSize < 64 && this.handler2.getStackInSlot( slot ).getMetadata() == metaItem) {
                        this.handler2.insertItem( slot, stack, false );
                        stop = 1;
                    } else {
                        stop = 0;
                    }
                }

            } else {
                if (this.handler2.getStackInSlot( slot ) == null || this.handler2.getStackInSlot( slot ).getItem() == itemGenerate && this.handler2.getStackInSlot( slot ).stackSize < 64 && this.handler2.getStackInSlot( slot ).getMetadata() == metaItem) {
                    this.handler2.insertItem( slot, stack, false );

                    stop = 1;
                } else {
                    stop = 0;

                }
            }
        }
    }



    public void generateItem(Item item, int metaSoul, int valueRandomMin, int valueRandomMax, Item itemGenerate, int metaItem, Item itemGenerateBurn, int metaItemBurn) {

        int slot;
        int stop;
        int min = 0;
        int max = 0;
        Item bookEnch = Items.ENCHANTED_BOOK;
        ItemStack stack;
        ItemStack stackBurn;
        stack = new ItemStack( itemGenerate, 1, metaItem );
        stackBurn = new ItemStack( itemGenerateBurn, 1, metaItemBurn );


        if (this.worldObj.isBlockPowered( pos )) {
            if (this.handler2.getStackInSlot( 22 ) != null) {
                if (this.handler2.getStackInSlot( 22 ).getMetadata() == 0) {
                    max = 14000;


                    int random = (int) (Math.random() * (max - min)) + min;

                    if (this.handler2.getStackInSlot( 19 ) != null || this.handler2.getStackInSlot( 20 ) != null || this.handler2.getStackInSlot( 21 ) != null) {


                        if (this.handler2.getStackInSlot( 19 ) != null && this.handler2.getStackInSlot( 19 ).getItem() == item) {
                            if (this.handler2.getStackInSlot( 19 ).getMetadata() == metaSoul) {
                                if (random >= valueRandomMin && random <= valueRandomMax) {
                                    generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );

                                }

                            }
                        }

                        if (this.handler2.getStackInSlot( 20 ) != null && this.handler2.getStackInSlot( 20 ).getItem() == item) {
                            if (this.handler2.getStackInSlot( 20 ).getMetadata() == metaSoul) {
                                if (random >= valueRandomMin && random <= valueRandomMax) {
                                    generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );

                                }

                            }
                        }

                        if (this.handler2.getStackInSlot( 21 ) != null && this.handler2.getStackInSlot( 21 ).getItem() == item) {
                            if (this.handler2.getStackInSlot( 21 ).getMetadata() == metaSoul) {
                                if (random >= valueRandomMin && random <= valueRandomMax) {
                                    generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );

                                }

                            }
                        }

                    }

                }

                else if (this.handler2.getStackInSlot( 22 ).getMetadata() == 1) {
                    max = 13500;


                    int random = (int) (Math.random() * (max - min)) + min;

                    if (this.handler2.getStackInSlot( 19 ) != null || this.handler2.getStackInSlot( 20 ) != null || this.handler2.getStackInSlot( 21 ) != null) {

                        if(this.handler2.getStackInSlot( 19) != null) {
                            if (this.handler2.getStackInSlot( 19 ).getItem() == item) {
                                if (this.handler2.getStackInSlot( 19 ).getMetadata() == metaSoul) {
                                    if (random >= valueRandomMin && random <= valueRandomMax) {
                                        generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );

                                    }

                                }
                            }
                        }

                        if(this.handler2.getStackInSlot( 20 ) != null) {
                            if (this.handler2.getStackInSlot( 20 ).getItem() == item) {
                                if (this.handler2.getStackInSlot( 20 ).getMetadata() == metaSoul) {
                                    if (random >= valueRandomMin && random <= valueRandomMax) {
                                        generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );
                                    }
                                }

                            }
                        }

                        if(this.handler2.getStackInSlot( 21 ) != null) {
                            if (this.handler2.getStackInSlot( 21 ).getItem() == item) {
                                if (this.handler2.getStackInSlot( 21 ).getMetadata() == metaSoul) {
                                    if (random >= valueRandomMin && random <= valueRandomMax) {
                                        generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );

                                    }
                                }
                            }
                        }
                    }

                }
            } else {
                max = 14500;


                int random = (int) (Math.random() * (max - min)) + min;

                if (this.handler2.getStackInSlot( 19 ) != null || this.handler2.getStackInSlot( 20 ) != null || this.handler2.getStackInSlot( 21 ) != null) {

                    if(this.handler2.getStackInSlot( 19 ) != null) {
                        if (this.handler2.getStackInSlot( 19 ).getItem() == item) {
                            if (this.handler2.getStackInSlot( 19 ).getMetadata() == metaSoul) {
                                if (random >= valueRandomMin && random <= valueRandomMax) {
                                    generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );

                                }

                            }
                        }
                    }

                    if(this.handler2.getStackInSlot( 20 ) != null) {
                        if (this.handler2.getStackInSlot( 20 ).getItem() == item) {
                            if (this.handler2.getStackInSlot( 20 ).getMetadata() == metaSoul) {
                                if (random >= valueRandomMin && random <= valueRandomMax) {
                                    generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );
                                }
                            }

                        }
                    }

                    if(this.handler2.getStackInSlot( 21 ) != null) {
                        if (this.handler2.getStackInSlot( 21 ).getItem() == item) {
                            if (this.handler2.getStackInSlot( 21 ).getMetadata() == metaSoul) {
                                if (random >= valueRandomMin && random <= valueRandomMax) {
                                    generate( itemGenerate, metaItem, itemGenerateBurn, metaItemBurn );
                                }
                            }

                        }
                    }

                }


            }


        }
    }

    public void generateEgg(Item item, int meta, int valueRandom, ItemStack stack) {

        int slot;
        int stop;


        int max = 14500, min = 0;
        int random = (int) (Math.random() * (max - min)) + min;

        if (this.worldObj.isBlockPowered( pos )) {
            if (this.handler2.getStackInSlot( 19 ) != null || this.handler2.getStackInSlot( 20 ) != null || this.handler2.getStackInSlot( 21 ) != null) {

                if (this.handler2.getStackInSlot( 19 ) != null) {
                    if (this.handler2.getStackInSlot( 19 ).getItem() == item)
                        if (this.handler2.getStackInSlot( 19 ).getMetadata() == meta) {
                            if (random <= valueRandom) {

                                for (slot = 0, stop = 0; (slot < 18 && stop == 0); slot++)
                                    if (this.handler2.getStackInSlot( slot ) == null || this.handler2.getStackInSlot( slot ).hasTagCompound() && this.handler2.getStackInSlot( slot ).getTagCompound().hasKey( "EntityTag" ) && this.handler2.getStackInSlot( slot ).stackSize < 64) {
                                        this.handler2.insertItem( slot, stack, false );
                                        stop = 1;
                                    } else {
                                        stop = 0;

                                    }
                            }
                        }
                }

                if (this.handler2.getStackInSlot( 20 ) != null) {
                    if (this.handler2.getStackInSlot( 20 ).getItem() == item)
                        if (this.handler2.getStackInSlot( 20 ).getMetadata() == meta) {
                            if (random <= valueRandom) {

                                for (slot = 0, stop = 0; (slot < 18 && stop == 0); slot++)
                                    if (this.handler2.getStackInSlot( slot ) == null || this.handler2.getStackInSlot( slot ).hasTagCompound() && this.handler2.getStackInSlot( slot ).getTagCompound().hasKey( "EntityTag" ) && this.handler2.getStackInSlot( slot ).stackSize < 64) {
                                        this.handler2.insertItem( slot, stack, false );
                                        stop = 1;
                                    } else {
                                        stop = 0;

                                    }
                            }
                        }
                }

                if (this.handler2.getStackInSlot( 21 ) != null) {
                    if (this.handler2.getStackInSlot( 21 ).getItem() == item)
                        if (this.handler2.getStackInSlot( 21 ).getMetadata() == meta) {
                            if (random <= valueRandom) {

                                for (slot = 0, stop = 0; (slot < 18 && stop == 0); slot++)
                                    if (this.handler2.getStackInSlot( slot ) == null || this.handler2.getStackInSlot( slot ).hasTagCompound() && this.handler2.getStackInSlot( slot ).getTagCompound().hasKey( "EntityTag" ) && this.handler2.getStackInSlot( slot ).stackSize < 64) {
                                        this.handler2.insertItem( slot, stack, false );
                                        stop = 1;
                                    } else {
                                        stop = 0;

                                    }
                            }
                        }
                }

            }
        }
    }



    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return oldState.getBlock() != newSate.getBlock();
    }

    @Override
    public void update() {

        generateBasic();

    }

    public void generateBasic() {




        ItemStack villagerEgg = new ItemStack(Items.SPAWN_EGG, 1);
        NBTTagCompound stackNbtVillager = new NBTTagCompound();
        NBTTagCompound entityNbtVillager = new NBTTagCompound();
        entityNbtVillager.setString("id", "Villager");
        stackNbtVillager.setTag("EntityTag", entityNbtVillager);
        villagerEgg.setTagCompound(stackNbtVillager);


        //bat
        generateItem(ModItems.Basic_spirit, 0, 0, 0, ModItems.Bat_Spawn, 0, ModItems.Bat_Spawn, 0);

        //Chicken
        generateItem(ModItems.Basic_spirit, 1, 0, 20, Items.CHICKEN, 0, Items.COOKED_CHICKEN, 0);
        generateItem(ModItems.Basic_spirit, 1, 21, 36, Items.FEATHER, 0, Items.FEATHER, 0);
        generateItem(ModItems.Basic_spirit, 1, 37, 40, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 1, 41, 41, ModItems.Chicken_Spawn, 0, ModItems.Chicken_Spawn, 0);

        //Cow
        generateItem(ModItems.Basic_spirit, 2, 0, 20, Items.BEEF, 0, Items.COOKED_BEEF, 0);
        generateItem(ModItems.Basic_spirit, 2, 21, 36, Items.LEATHER, 0, Items.LEATHER, 0);
        generateItem(ModItems.Basic_spirit, 2, 37, 40, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 2, 41, 41, ModItems.Cow_Spawn, 0, ModItems.Cow_Spawn, 0);

        //Endermite
        generateItem(ModItems.Basic_spirit, 3, 0, 6, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 3, 7, 7, ModItems.Endermite_Spawn, 0, ModItems.Endermite_Spawn, 0);

        //Mooshroom
        generateItem(ModItems.Basic_spirit, 4, 0, 20, Items.BEEF, 0, Items.COOKED_BEEF, 0);
        generateItem(ModItems.Basic_spirit, 4, 21, 36, Items.LEATHER, 0, Items.LEATHER, 0);
        generateItem(ModItems.Basic_spirit, 4, 37, 40, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 4, 41, 41, ModItems.Mooshroom_Spawn, 0, ModItems.Mooshroom_Spawn, 0);

        //Ocelot
        generateItem(ModItems.Basic_spirit, 5, 0, 3, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 5, 4, 4, ModItems.Ocelot_Spawn, 0, ModItems.Ocelot_Spawn, 0);

        //Pig
        generateItem(ModItems.Basic_spirit, 6, 0, 20, Items.PORKCHOP, 0, Items.COOKED_PORKCHOP, 0);
        generateItem(ModItems.Basic_spirit, 6, 21, 24, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 6, 25, 25, ModItems.Pig_Spawn, 0, ModItems.Pig_Spawn, 0);

        //Polar_Bear
        generateItem(ModItems.Basic_spirit, 7, 0, 20, Items.FISH, 0, Items.COOKED_FISH, 0);
        generateItem(ModItems.Basic_spirit, 7, 21, 41, Items.FISH, 1, Items.COOKED_FISH, 1);
        generateItem(ModItems.Basic_spirit, 7, 42, 45, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 7, 46, 46, ModItems.Polar_Bear_Spawn, 0, ModItems.Polar_Bear_Spawn, 0);

        //Rabbit
        generateItem(ModItems.Basic_spirit, 8, 0, 20, Items.RABBIT, 0, Items.COOKED_RABBIT, 0);
        generateItem(ModItems.Basic_spirit, 8, 21, 36, Items.RABBIT_HIDE, 0, Items.RABBIT_HIDE, 0);
        generateItem(ModItems.Basic_spirit, 8, 37, 37, Items.RABBIT_FOOT, 0, Items.RABBIT_FOOT, 0);
        generateItem(ModItems.Basic_spirit, 8, 38, 41, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 8, 42, 42, ModItems.Rabbit_Spawn, 0, ModItems.Rabbit_Spawn, 0);

        //Sheep
        generateItem(ModItems.Basic_spirit, 9, 0, 20, Items.MUTTON, 0, Items.COOKED_MUTTON, 0);
        generateItem(ModItems.Basic_spirit, 9, 21, 36, ItemBlock.getItemFromBlock(Blocks.WOOL), 0, ItemBlock.getItemFromBlock(Blocks.WOOL), 0);
        generateItem(ModItems.Basic_spirit, 9, 37, 44, ItemBlock.getItemFromBlock(Blocks.WOOL), 7, ItemBlock.getItemFromBlock(Blocks.WOOL), 7);
        generateItem(ModItems.Basic_spirit, 9, 45, 52, ItemBlock.getItemFromBlock(Blocks.WOOL), 8, ItemBlock.getItemFromBlock(Blocks.WOOL), 8);
        generateItem(ModItems.Basic_spirit, 9, 53, 60, ItemBlock.getItemFromBlock(Blocks.WOOL), 15, ItemBlock.getItemFromBlock(Blocks.WOOL), 15);
        generateItem(ModItems.Basic_spirit, 9, 61, 64, ItemBlock.getItemFromBlock(Blocks.WOOL), 12, ItemBlock.getItemFromBlock(Blocks.WOOL), 12);
        generateItem(ModItems.Basic_spirit, 9, 65, 68, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 9, 69, 69, ModItems.Sheep_Spawn, 0, ModItems.Sheep_Spawn, 0);

        int max = 100, min = 0;
        int random = (int)(Math.random()*(max-min))+min;

        if(random <= 1)
            generateItem( ModItems.Basic_spirit, 9, 70, 70, ItemBlock.getItemFromBlock(Blocks.WOOL), 6, ItemBlock.getItemFromBlock(Blocks.WOOL), 6);

        //Shulker
        generateItem(ModItems.Basic_spirit, 10, 0, 10, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 10, 11, 11, ModItems.Shulker_Spawn, 0, ModItems.Shulker_Spawn, 0);

        //Silverfish
        generateItem(ModItems.Basic_spirit, 11, 0, 10, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 11, 11, 11, ModItems.Silverfish_Spawn, 0, ModItems.Silverfish_Spawn, 0);

        //Squid

        generateItem(ModItems.Basic_spirit, 12, 0, 3, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 12, 4, 4, ModItems.Squid_Spawn, 0, ModItems.Squid_Spawn, 0);

        //Wolf
        generateItem(ModItems.Basic_spirit, 13, 0, 3, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem(ModItems.Basic_spirit, 13, 4, 4, ModItems.Wolf_Spawn, 0, ModItems.Wolf_Spawn, 0);


        //CaveSpider
        generateItem(ModItems.Advanced_spirit, 0, 0, 20, Items.STRING, 0, Items.STRING, 0);
        generateItem(ModItems.Advanced_spirit, 0, 21, 36, Items.SPIDER_EYE, 0, Items.SPIDER_EYE, 0);
        generateItem(ModItems.Advanced_spirit, 0, 37, 47, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 0, 48, 48, ModItems.Cave_Spider_Spawn, 0, ModItems.Cave_Spider_Spawn, 0 );

        //Creeper
        generateItem(ModItems.Advanced_spirit, 1, 0, 20, Items.GUNPOWDER, 0, Items.GUNPOWDER, 0);
        generateItem(ModItems.Advanced_spirit, 1, 21, 31, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 1, 32, 32, ModItems.Creeper_Spawn, 0, ModItems.Creeper_Spawn, 0 );

        //EntityDonkey
        generateItem(ModItems.Advanced_spirit, 2, 0, 15, Items.LEATHER, 0, Items.LEATHER, 0);
        generateItem(ModItems.Advanced_spirit, 2, 16, 19, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 2, 20, 20, ModItems.Donkey_Spawn, 0, ModItems.Donkey_Spawn, 0 );
        //Guardian
        generateItem(ModItems.Advanced_spirit, 3, 0, 20, Items.FISH, 0, Items.COOKED_FISH, 0);
        generateItem(ModItems.Advanced_spirit, 3, 21, 39, Items.PRISMARINE_CRYSTALS, 0, Items.PRISMARINE_CRYSTALS, 0);
        generateItem(ModItems.Advanced_spirit, 3, 40, 62, Items.PRISMARINE_SHARD, 0, Items.PRISMARINE_SHARD, 0);
        generateItem(ModItems.Advanced_spirit, 3, 63, 68, Items.FISH, 1, Items.COOKED_FISH, 1);
        generateItem(ModItems.Advanced_spirit, 3, 69, 74, Items.FISH, 2, Items.FISH, 2);
        generateItem(ModItems.Advanced_spirit, 3, 75, 80, Items.FISH, 3, Items.FISH, 3);
        generateItem(ModItems.Advanced_spirit, 3, 81, 96, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 3, 97, 97, ModItems.Guardian_Spawn, 0, ModItems.Guardian_Spawn, 0 );

        //Horse
        generateItem(ModItems.Advanced_spirit, 4, 0, 15, Items.LEATHER, 0, Items.LEATHER, 0);
        generateItem(ModItems.Advanced_spirit, 4, 16, 19, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 4, 20, 20, ModItems.Horse_Spawn, 0, ModItems.Horse_Spawn, 0 );

        //Husk
        generateItem(ModItems.Advanced_spirit, 5, 0, 20, Items.ROTTEN_FLESH, 0, Items.ROTTEN_FLESH, 0);
        generateItem(ModItems.Advanced_spirit, 5, 21, 23, Items.IRON_INGOT, 0, Items.IRON_INGOT, 0);
        generateItem(ModItems.Advanced_spirit, 5, 24, 26, Items.POTATO, 0, Items.BAKED_POTATO, 0);
        generateItem(ModItems.Advanced_spirit, 5, 27, 29, Items.CARROT, 0, Items.CARROT, 0);
        generateItem(ModItems.Advanced_spirit, 5, 30, 40, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 5, 41, 41, ModItems.Husk_Spawn, 0, ModItems.Husk_Spawn, 0 );

        //Mule
        generateItem(ModItems.Advanced_spirit, 6, 0, 15, Items.LEATHER, 0, Items.LEATHER, 0);
        generateItem(ModItems.Advanced_spirit, 6, 16, 19, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 6, 20, 20, ModItems.Mule_Spawn, 0, ModItems.Mule_Spawn, 0 );

        //Skeleton
        generateItem(ModItems.Advanced_spirit, 7, 0, 20, Items.BONE, 0, Items.BONE, 0);
        generateItem(ModItems.Advanced_spirit, 7, 21, 36, Items.ARROW, 0, Items.ARROW, 0);
        generateItem(ModItems.Advanced_spirit, 7, 37, 40, Items.BOW, 0, Items.BOW, 0);
        generateItem(ModItems.Advanced_spirit, 7, 41, 51, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 7, 52, 52, ModItems.Skeleton_Spawn, 0, ModItems.Skeleton_Spawn, 0 );

        //Skeleton Horse
        generateItem(ModItems.Advanced_spirit, 8, 0, 10, Items.BONE, 0, Items.BONE, 0);
        generateItem(ModItems.Advanced_spirit, 8, 11, 14, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 8, 15, 15, ModItems.Skeleton_Horse_Spawn, 0, ModItems.Skeleton_Horse_Spawn, 0);

        //SnowMan
        generateItem(ModItems.Advanced_spirit, 9, 0, 25, Items.SNOWBALL, 0, Items.SNOWBALL, 0);
        generateItem( ModItems.Advanced_spirit, 9, 26, 26, ModItems.Snow_Man_Spawn, 0, ModItems.Snow_Man_Spawn, 0 );

        //Spider
        generateItem(ModItems.Advanced_spirit, 10, 0, 20, Items.STRING, 0, Items.STRING, 0);
        generateItem(ModItems.Advanced_spirit, 10, 21, 23, Items.SPIDER_EYE, 0, Items.SPIDER_EYE, 0);
        generateItem(ModItems.Advanced_spirit, 10, 24, 34, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 10, 35, 35, ModItems.Spider_Spawn, 0, ModItems.Spider_Spawn, 0 );

        //Villager
        generateEgg( ModItems.Advanced_spirit, 11, 1, villagerEgg );

        //Zombie
        generateItem(ModItems.Advanced_spirit, 12, 0, 20, Items.ROTTEN_FLESH, 0, Items.ROTTEN_FLESH, 0);
        generateItem(ModItems.Advanced_spirit, 12, 21, 23, Items.IRON_INGOT, 0, Items.IRON_INGOT, 0);
        generateItem(ModItems.Advanced_spirit, 12, 24, 26, Items.POTATO, 0, Items.BAKED_POTATO, 0);
        generateItem(ModItems.Advanced_spirit, 12, 27, 29, Items.CARROT, 0, Items.CARROT, 0);
        generateItem(ModItems.Advanced_spirit, 12, 30, 40, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 12, 41, 41, ModItems.Zombie_Spawn, 0, ModItems.Zombie_Spawn, 0 );

        //Zombie Horse
        generateItem(ModItems.Advanced_spirit, 13, 0, 10, Items.ROTTEN_FLESH, 0, Items.ROTTEN_FLESH, 0);
        generateItem(ModItems.Advanced_spirit, 13, 11, 14, Items.EXPERIENCE_BOTTLE, 0, Items.EXPERIENCE_BOTTLE, 0);
        generateItem( ModItems.Advanced_spirit, 13, 15, 15, ModItems.Zombie_Horse_Spawn, 0, ModItems.Zombie_Horse_Spawn, 0);


    }




    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (T) this.handler2;
        return super.getCapability(capability, facing);

    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return true;
        return super.hasCapability(capability, facing);
    }


    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index) {
        return null;
    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {

    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }


    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {

        if (index <= 17)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
            return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        int metadata = getBlockMetadata();
        return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
    }

    /**
     * Reads the nbt when it receives a packet
     */
    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    /**
     * Gets the nbt for a new packet
     */


    /**
     * Handles when you get an update
     */
    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    /**
     * Gets the tile entities nbt with all of the data stored in it
     */
    @Override
    public NBTTagCompound getTileData() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

}

