package net.gegy1000.bedwars.game;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.WeightedList;

import java.util.Random;

public final class GeneratorPool {
    public static final GeneratorPool TEAM_LVL_1 = new GeneratorPool()
            .add(new ItemStack(Items.IRON_INGOT, 1), 10)
            .add(new ItemStack(Items.GOLD_INGOT, 1), 2)
            .spawnInterval(30);

    public static final GeneratorPool TEAM_LVL_2 = new GeneratorPool()
            .add(new ItemStack(Items.IRON_INGOT, 1), 10)
            .add(new ItemStack(Items.IRON_INGOT, 2), 8)
            .add(new ItemStack(Items.GOLD_INGOT, 1), 2)
            .add(new ItemStack(Items.GOLD_INGOT, 2), 1)
            .spawnInterval(20);

    public static final GeneratorPool TEAM_LVL_3 = new GeneratorPool()
            .add(new ItemStack(Items.IRON_INGOT, 2), 10)
            .add(new ItemStack(Items.GOLD_INGOT, 1), 4)
            .add(new ItemStack(Items.EMERALD, 1), 1)
            .spawnInterval(18);

    public static final GeneratorPool DIAMOND = new GeneratorPool()
            .add(new ItemStack(Items.DIAMOND, 1), 1)
            .spawnInterval(20 * 40);

    public static final GeneratorPool EMERALD = new GeneratorPool()
            .add(new ItemStack(Items.EMERALD, 1), 1)
            .spawnInterval(20 * 80);

    private final WeightedList<ItemStack> pool = new WeightedList<>();
    private long spawnInterval = 10;

    public GeneratorPool add(ItemStack stack, int weight) {
        this.pool.add(stack, weight);
        return this;
    }

    public GeneratorPool spawnInterval(long spawnInterval) {
        this.spawnInterval = spawnInterval;
        return this;
    }

    public ItemStack sample(Random random) {
        return this.pool.pickRandom(random).copy();
    }

    public long getSpawnInterval() {
        return this.spawnInterval;
    }
}