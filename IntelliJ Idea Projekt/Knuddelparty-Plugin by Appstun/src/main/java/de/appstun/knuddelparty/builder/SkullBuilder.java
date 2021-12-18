package de.appstun.knuddelparty.builder;

import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;

public class SkullBuilder
{
    private ItemStack itemStack;
    private SkullMeta skullMeta;

    public SkullBuilder(final Material material, final int subID) {
        this.itemStack = new ItemStack(material, 1, (short)subID);
        this.skullMeta = (SkullMeta)this.itemStack.getItemMeta();
    }

    public SkullBuilder(final Material material) {
        this(material, 0);
    }

    public SkullBuilder setDisplayName(final String displayName) {
        this.skullMeta.setDisplayName(displayName);
        return this;
    }

    public SkullBuilder setLore(final String... lore) {
        this.skullMeta.setLore((List)Arrays.asList(lore));
        return this;
    }

    public SkullBuilder setAmount(final int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public SkullBuilder setOwner(final String owner) {
        this.skullMeta.setOwner(owner);
        return this;
    }

    public void addEnchantment(final Enchantment enchantment, final int lvl) {
        this.itemStack.addEnchantment(enchantment, lvl);
    }

    public ItemStack build() {
        this.itemStack.setItemMeta((ItemMeta)this.skullMeta);
        return this.itemStack;
    }
}