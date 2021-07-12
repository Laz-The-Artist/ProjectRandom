package multiteam.project_random.main.entity.clay.soldier;

import multiteam.project_random.ProjectRandom;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class ClaySoldierModel extends AnimatedGeoModel<ClaySoldierEntity> implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public ResourceLocation getModelLocation(ClaySoldierEntity claySoldierEntity) {
        return new ResourceLocation(ProjectRandom.MOD_ID, "geo/entity/clay/clayman.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ClaySoldierEntity claySoldierEntity) {
        return new ResourceLocation(ProjectRandom.MOD_ID, "textures/entity/clay/clayman.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ClaySoldierEntity claySoldierEntity) {
        return new ResourceLocation(ProjectRandom.MOD_ID, "animations/entity/clay/clayman.animation.json");
    }

    @Override
    public void setLivingAnimations(ClaySoldierEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        LivingEntity entityIn = (LivingEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
