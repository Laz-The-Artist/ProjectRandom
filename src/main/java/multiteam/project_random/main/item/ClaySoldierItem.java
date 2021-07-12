package multiteam.project_random.main.item;

import multiteam.project_random.main.entity.ModEntities;
import multiteam.project_random.main.entity.clay.soldier.ClaySoldierEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ClaySoldierItem extends Item {

    public ClaySoldierItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World worldin = context.getLevel();
        BlockPos soldierSummonPos = context.getClickedPos().offset(context.getClickedFace().getNormal());
        PlayerEntity playerEntity = context.getPlayer();
        if(worldin.getBlockState(soldierSummonPos) == Blocks.AIR.defaultBlockState()){
            ClaySoldierEntity soldierEntity = new ClaySoldierEntity(ModEntities.CLAY_SOLDIER.get(), worldin);
            worldin.addFreshEntity(soldierEntity);
            soldierEntity.setPos(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z);
            if(!playerEntity.isCreative()){
                context.getItemInHand().shrink(1);
            }
            return ActionResultType.SUCCESS;
        }
        return super.useOn(context);
    }
}
