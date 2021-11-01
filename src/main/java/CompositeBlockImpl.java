import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeBlockImpl extends BlockImpl implements CompositeBlock{

    List<Block> blocks = new ArrayList<>();

    public CompositeBlockImpl(String color, String material) {
        super(color, material);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getMaterial() {
        return super.getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block){
        blocks.add(block);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompositeBlockImpl that = (CompositeBlockImpl) o;
        return Objects.equals(blocks, that.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), blocks);
    }
}
