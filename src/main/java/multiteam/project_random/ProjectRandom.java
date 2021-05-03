package multiteam.project_random;

import multiteam.multicore_lib.setup.utilities.ItemGroupTool;
import multiteam.project_random.main.Registration;
import multiteam.project_random.main.block.ModBlocks;
import multiteam.project_random.main.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;


@Mod(ProjectRandom.MOD_ID)
public class ProjectRandom
{

    public static final String MOD_ID = "project_random";
    private static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroupTool PROJECTRANDOM_EAGLE = new ItemGroupTool("eagles_trashland", () -> new ItemStack(Blocks.CHEST.asItem()));
    public static final ItemGroupTool PROJECTRANDOM_LAZ = new ItemGroupTool("lazlos_forest", () -> new ItemStack(ModItems.CABBAGE.get()));
    public static final ItemGroupTool PROJECTRANDOM_GAMA = new ItemGroupTool("gamas_smithery", () -> new ItemStack(Blocks.CHEST.asItem()));


    public ProjectRandom() {

        GeckoLib.initialize();
        Registration.register();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.CABBAGE_BUSH.get(), RenderType.cutoutMipped());
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }


    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

        }
    }
}
