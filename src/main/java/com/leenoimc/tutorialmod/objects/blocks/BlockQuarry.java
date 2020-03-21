package com.leenoimc.tutorialmod.objects.blocks;

import com.leenoimc.tutorialmod.init.ModTileEntityTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockQuarry extends Block
{

	public BlockQuarry(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity()
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world)
	{
		return ModTileEntityTypes.QUARRY.get().create();
	}
}
