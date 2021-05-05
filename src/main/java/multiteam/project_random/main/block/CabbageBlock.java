package multiteam.project_random.main.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CabbageBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(4.75D, 0.0D, 4.75D, 11.25D, 6.25D, 11.25D);

    public CabbageBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader iBlockReader, BlockPos pos, ISelectionContext iSelectionContext) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader iBlockReader, BlockPos pos, ISelectionContext iSelectionContext) {
        return SHAPE;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, IBlockReader iBlockReader, BlockPos pos, ISelectionContext iSelectionContext) {
        return SHAPE;
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos pos_, boolean p_220069_6_) {
        if(!canSurvive(state, world, pos)){
            world.destroyBlock(pos,true);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
        if(world.getBlockState(pos.below()) != Blocks.AIR.defaultBlockState()){
            return true;
        }
        return false;
    }
}
