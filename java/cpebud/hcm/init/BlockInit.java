package cpebud.hcm.init;

import java.util.ArrayList;
import java.util.List;

import cpebud.hcm.objects.blocks.BlockBase;
import cpebud.hcm.objects.blocks.BlockEggGiantOverworld;
import cpebud.hcm.objects.blocks.BlockNestBase;
import cpebud.hcm.objects.blocks.BlockNestOverworld;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
    public static final Block BLOCK_EGGGIANTOVERWORLD = new BlockEggGiantOverworld("egg_giantoverworld");
    
    public static final Block BLOCK_NESTOVERWORLD = new BlockNestOverworld("nest_overworld"); 
}
