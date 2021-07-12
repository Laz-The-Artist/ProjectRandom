package multiteam.project_random.main.entity;

import multiteam.multicore_lib.MultiCoreLib;
import multiteam.multicore_lib.setup.utilities.MathF;
import multiteam.project_random.main.Registration;
import multiteam.project_random.main.entity.clay.soldier.ClaySoldierEntity;
import multiteam.project_random.main.entity.clay.soldier.ClaySoldierRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModEntities {

    //Clay Soldiers
    public static final RegistryObject<EntityType<ClaySoldierEntity>> CLAY_SOLDIER = buildEntity(ClaySoldierEntity::new, ClaySoldierEntity.class, MathF.BlockToFloatScale(4), MathF.BlockToFloatScale(8), EntityClassification.CREATURE, 8, 3); //8, 3 is default


    public static void clientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(CLAY_SOLDIER.get(), ClaySoldierRenderer::new);
    }

    public static void applyAttributes(){
        GlobalEntityTypeAttributes.put(CLAY_SOLDIER.get(), ClaySoldierEntity.createAttributes().build());
    }


    public static void register() { }

    public static <T extends Entity> RegistryObject<EntityType<T>> buildEntity(EntityType.IFactory<T> entity, Class<T> entityClass, float width, float height, EntityClassification classification, int trackingRange, int updateinterval) {
        String name = entityClass.getSimpleName().toLowerCase();
        return Registration.ENTITY_TYPES.register(name, () -> EntityType.Builder.of(entity, classification).sized(width, height).clientTrackingRange(trackingRange).updateInterval(updateinterval).build(name));
    }
}
