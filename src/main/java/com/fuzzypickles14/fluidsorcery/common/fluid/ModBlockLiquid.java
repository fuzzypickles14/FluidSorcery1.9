package com.fuzzypickles14.fluidsorcery.common.fluid;


import com.fuzzypickles14.fluidsorcery.common.core.FluidSorceryCreativeTab;
import com.fuzzypickles14.fluidsorcery.common.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Andrew Toomey on 2/15/2016.
 */
public abstract class ModBlockLiquid extends BlockFluidClassic {
    private Item inItem;
    private Item outItem;



    public ModBlockLiquid(Fluid fluid, Material material, Item inItem, Item outItem) {
        super(fluid, material);
        displacements.put(this, false);
        this.setRegistryName(fluid.getName());
        this.setUnlocalizedName(fluid.getName());
        this.setCreativeTab(FluidSorceryCreativeTab.instance);
        this.inItem = inItem;
        this.outItem = outItem;
    }



    private Item getInItem()
    {
        return this.inItem;
    }

    private Item getOutItem()
    {
        return this.outItem;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (entityIn instanceof EntityItem && this.isSourceBlock(worldIn, pos)) {
            ItemStack item = ((EntityItem)entityIn).getEntityItem();
            if (item.getItem() == this.getInItem() && entityIn.getPosition().getY() == pos.getY()) {
                item.setItem(this.getOutItem());
            }
        }
    }
}
