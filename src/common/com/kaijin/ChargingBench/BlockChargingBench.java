package com.kaijin.ChargingBench;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.*;


public class BlockChargingBench extends Block
{
	public BlockChargingBench(int i, int j, Material material)
	{
		super(i, j, material);
	}
    
    public void addCreativeItems(ArrayList itemList)
    {
    	if (Utils.isDebug()) System.out.println("BlockChargingBench.addCreativeItems");
    	itemList.add(new ItemStack(this, 1, 0));
    	itemList.add(new ItemStack(this, 1, 1));
    	itemList.add(new ItemStack(this, 1, 2));
    }

    private boolean launchGUI(World world, int x, int y, int z, EntityPlayer entityplayer)
    {
    	if (Utils.isDebug()) System.out.println("BlockChargingBench.launchGUI");
    	entityplayer.openGui(ChargingBench.instance, 1, world, x, y, z);
    	return true;
    }
    
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer entityplayer)
    {
    	if (Utils.isDebug()) System.out.println("BlockChargingBench.BlockActivated");
    	return Platform.isSimulating()?launchGUI(world, x, y, z, entityplayer):true;
//        entityplayer.openGui(mod_IC2_ChargingBench.instance, 1, world, x, y, z);
    }

    public TileEntityChargingBench getBlockEntity(int var1)
    {
    	if (Utils.isDebug()) System.out.println("BlockChargingBench.getBlockEntity.var1: "+var1);
        switch (var1)
        {
            case 0:
                return new TileEntityChargingBench1();

            case 1:
                return new TileEntityChargingBench2();

            case 2:
                return new TileEntityChargingBench3();

            default:
                return null;
        }
    }

    public String getTextureFile()
    {
    	if (Utils.isDebug()) System.out.println("BlockChargingBench.getTextureFile");
        return "/com/kaijin/ChargingBench/sprites/ChargingBench.png";
    }

    public int idDropped(int var1, Random var2, int var3)
    {
    	if (Utils.isDebug()) System.out.println("BlockChargingBench.idDropped");
        return this.blockID;
    }

    protected int damageDropped(int var1)
    {
    	if (Utils.isDebug()) System.out.println("BlockChargingBench.damageDropped");
        return var1;
    }

    public TileEntity getTileEntity(int var1)
    {
    	if (Utils.isDebug()) System.out.println("BlockChargingBench.getTileEntity.var1: "+var1);
        return this.getBlockEntity(var1);
    }
}
