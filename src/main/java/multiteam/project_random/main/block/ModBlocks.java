package multiteam.project_random.main.block;

import multiteam.project_random.ProjectRandom;
import multiteam.project_random.main.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> CABBAGE_BUSH = registerWithItem("cabbage_bush", () -> new CabbageBush(AbstractBlock.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(2.0f, 6.0f).noCollission().harvestTool(ToolType.HOE).dynamicShape()), new Item.Properties().tab(ProjectRandom.PROJECTRANDOM_LAZ).rarity(Rarity.UNCOMMON));


    public static void register(){}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block){
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerWithItem(String name, Supplier<T> block, Item.Properties itemProperties){
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), itemProperties));
        return ret;
    }
}
