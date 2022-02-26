package multiteam.project_random.data;

import multiteam.project_random.ProjectRandom;
import multiteam.project_random.data.client.ModBlockStateProvider;
import multiteam.project_random.data.client.ModBlockTagProvider;
import multiteam.project_random.data.client.ModItemModelProvider;
import multiteam.project_random.data.client.ModLootTableProvider;
import multiteam.project_random.main.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ProjectRandom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(new ModBlockStateProvider(gen, ProjectRandom.MOD_ID, existingFileHelper));
        gen.addProvider(new ModItemModelProvider(gen,ProjectRandom.MOD_ID, existingFileHelper));
        gen.addProvider(new ModLootTableProvider(gen, Registration.BLOCKS));
        gen.addProvider(new ModBlockTagProvider(gen, ProjectRandom.MOD_ID, existingFileHelper));
    }
}
