package net.swofty.types.generic.block.placement.rules;

import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.block.rule.BlockPlacementRule;
import net.swofty.types.generic.block.placement.PlacementRule;
import net.swofty.types.generic.block.placement.states.BlockState;
import net.swofty.types.generic.block.placement.states.state.BooleanState;

public class DisableWaterLogPlacement extends PlacementRule {
    public DisableWaterLogPlacement(Block block) {
        super(block);
    }

    @Override
    public boolean canPlace(BlockState blockState, BlockPlacementRule.PlacementState placementState) {
        return true;
    }

    @Override
    public boolean canUpdate(BlockState blockState, BlockPlacementRule.UpdateState updateState) {
        return false;
    }

    @Override
    public void update(BlockState blockState, BlockPlacementRule.UpdateState updateState) {
        blockState.set(BooleanState.Of("waterlogged", false));
    }

    @Override
    public void place(BlockState blockState, BlockPlacementRule.PlacementState placementState) {

    }
}
