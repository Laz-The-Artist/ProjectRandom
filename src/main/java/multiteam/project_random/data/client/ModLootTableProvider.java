package multiteam.project_random.data.client;


import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import multiteam.project_random.main.Registration;
import multiteam.project_random.main.block.ModBlocks;
import multiteam.project_random.main.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((resourceLocation, lootTable) -> LootTableManager.validate(validationtracker, resourceLocation, lootTable));
    }

    public static class ModBlockLootTables extends BlockLootTables{
        @Override
        protected void addTables() {
            dropSelf(ModBlocks.CARDBOARD_BOX.get());
            dropSelf(ModBlocks.WITHER_CABBAGE.get());
            dropSelf(ModBlocks.ICEY_CABBAGE.get());
            dropSelf(ModBlocks.SUPER_CABBAGE.get());
            dropOther(ModBlocks.CABBAGE_BUSH.get(), ModItems.CABBAGE.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }
    }
}
