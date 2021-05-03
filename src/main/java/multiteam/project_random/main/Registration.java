package multiteam.project_random.main;

import multiteam.project_random.ProjectRandom;
import multiteam.project_random.main.block.ModBlocks;
import multiteam.project_random.main.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectRandom.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectRandom.MOD_ID);


    public static void register(){
        IEventBus modeEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modeEventBus);
        ITEMS.register(modeEventBus);

        ModItems.register();
        ModBlocks.register();
    }
}
