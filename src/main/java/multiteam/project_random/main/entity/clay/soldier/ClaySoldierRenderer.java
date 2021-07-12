package multiteam.project_random.main.entity.clay.soldier;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class ClaySoldierRenderer extends GeoEntityRenderer<ClaySoldierEntity> {

    public ClaySoldierRenderer(EntityRendererManager renderManager) {
        super(renderManager, new ClaySoldierModel());
    }

    @Override
    public RenderType getRenderType(ClaySoldierEntity animatable, float partialTicks, MatrixStack stack, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
