import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WallTest {

    @Test
    public void shouldReturn0WhenThereIsNoBlocksInside(){
        Wall emptyWall = new Wall();

        Assert.assertEquals(0,emptyWall.count());
    }

    @Test
    public void shouldReturnBlockFoundByColor(){
        Block block1 = new BlockImpl("Green","Wood");
        Block block2 = new BlockImpl("Blue","Steel");
        Block block3 = new BlockImpl("Black","Wood");
        Block block4 = new BlockImpl("Red","Plastic");
        Wall wall = new Wall(block1,block2,block3,block4);

        Block fBlock = wall.findBlockByColor("Blue").get();

        Assert.assertEquals(block2,fBlock);
    }

    @Test
    public void shouldReturnTwoBlocksFoundByMaterial(){
        Block block1 = new BlockImpl("Green","Wood");
        Block block2 = new BlockImpl("Blue","Steel");
        Block block3 = new BlockImpl("Black","Wood");
        Block block4 = new BlockImpl("Red","Plastic");
        List<Block> blockList = Arrays.asList(block1,block3);
        Wall wall = new Wall(block1,block2,block3,block4);

        List<Block> fBlocks = wall.findBlocksByMaterial("Wood");

        Assert.assertEquals(blockList,fBlocks);
    }

    @Test
    public void shouldntAcceptNullAsColor() {
        Wall wall = new Wall();

        assertThrows(IllegalArgumentException.class, () -> wall.findBlockByColor(null));
    }

    @Test
    public void shouldntAcceptNullAsMaterial() {
        Wall wall = new Wall();

        assertThrows(IllegalArgumentException.class, () -> wall.findBlocksByMaterial(null));
    }

    @Test
    public void shouldntAcceptColorDuplicate() {
        Block block1 = new BlockImpl("Blue","Wood");
        Block block2 = new BlockImpl("Blue","Steel");
        Wall wall = new Wall(block1);

        assertThrows(IllegalArgumentException.class, () -> wall.addBlock(block2));
    }


    @Test
    public void shouldReturnCompositeBlockFoundByColor(){
        CompositeBlockImpl compositeBlock = new CompositeBlockImpl("Gold","Plastic");
        Wall wall = new Wall(compositeBlock);

        Block fBlock = wall.findBlockByColor("Gold").get();

        Assert.assertEquals(compositeBlock,fBlock);
    }

    @Test
    public void shouldReturnCompositeBlockFoundByMaterial(){
        CompositeBlockImpl compositeBlock1 = new CompositeBlockImpl("Gold","Plastic");
        CompositeBlockImpl compositeBlock2 = new CompositeBlockImpl("Green","Steel");
        List<Block> blocks = Arrays.asList(compositeBlock1);
        Wall wall = new Wall(compositeBlock1,compositeBlock2);

        List<Block> fBlocks = wall.findBlocksByMaterial("Plastic");

        Assert.assertEquals(blocks,fBlocks);
    }



}