package net.logan31.poppiecraft.handler;

import net.minecraft.util.IStringSerializable;

/**
 * Created by johanjulien on 27/07/2017.
 */
public class EnumHandler {
    public static enum UpgradeTypes implements IStringSerializable {
        BASIC("basic", 0),
        ADVANED("advanced", 0),
        ULTIMATE("ultimate", 0);

        private int ID;
        private String name;

        private UpgradeTypes(String name, int ID) {
            this.ID = ID;
            this.name = name;
        }


        @Override
        public String getName() {
            return this.name;
        }

        public int getID() {
            return ID;

        }

        @Override
        public String toString() {
            return getName();
        }
    }
}
