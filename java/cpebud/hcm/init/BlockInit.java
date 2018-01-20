package cpebud.hcm.init;

import java.util.ArrayList;
import java.util.List;

import cpebud.hcm.objects.blocks.BlockEggGiant;
import net.minecraft.block.Block;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
    public static final Block BLOCK_EGGGIANT = new BlockEggGiant("egg_giant");
}
