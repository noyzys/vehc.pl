package pl.kodicrew.developers.vehctools.builders;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemStackBuilder {

    private Material mat;
    private int amount;
    private short data;
    private String title;
    private List<String> lore;
    private ItemMeta imb;
    private HashMap<Enchantment, Integer> enchants;

    public ItemStackBuilder(Material mat) {
        this(mat, 1);
    }

    public ItemStackBuilder(Material mat, int amount) {
        this(mat, amount, (short) 0);
    }

    public ItemStackBuilder(Material mat, short data) {
        this(mat, 1, data);
    }

    public ItemStackBuilder(Material mat, int amount, short data) {
        this.title = null;
        this.lore = new ArrayList<>();
        this.enchants = new HashMap<>();
        this.mat = mat;
        this.amount = amount;
        this.data = data;
    }

    public ItemStackBuilder withTitle(String title) {
        if (title == null) return this;
        this.title = title;
        return this;
    }

    public ItemStackBuilder withLore(String lore) {
        if (lore == null) return this;
        this.lore.add(lore);
        return this;
    }

    public ItemStackBuilder withLore(List<String> lore) {
        if (lore == null) return this;
        this.lore.addAll(lore);
        return this;
    }

    public ItemStackBuilder withSkullOwner(String owner) {
        ((SkullMeta) this.imb).setOwner(owner);
        return this;
    }

    public ItemStackBuilder withItemFlag(ItemFlag flag) {
        this.imb.addItemFlags(flag);
        return this;
    }

    public ItemStackBuilder withLeatherColor(Color color) {
        ((LeatherArmorMeta) this.imb).setColor(color);
        return this;
    }

    public ItemStackBuilder withBannerColor(DyeColor c) {
        ((BannerMeta) this.imb).setBaseColor(c);
        return this;
    }

    public ItemStackBuilder withBannerPattern(Pattern patter) {
        ((BannerMeta) this.imb).addPattern(patter);
        return this;
    }

    public ItemStackBuilder withEnchantment(Enchantment enchant, int level) {
        if (enchant == null) return this;
        enchants.remove(enchant);
        enchants.put(enchant, level);
        return this;
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(mat, amount, data);
        ItemMeta meta = item.getItemMeta();
        if (title != null) meta.setDisplayName(title);
        if (!this.lore.isEmpty()) meta.setLore(lore);
        item.setItemMeta(meta);
        item.addUnsafeEnchantments(enchants);
        return item;
    }
}
