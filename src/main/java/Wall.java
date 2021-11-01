import java.util.*;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks = new ArrayList<>();

    public Wall(Block... blocks) {
        Arrays.stream(blocks).forEach(this::addBlock);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if(color == null){
            throw new IllegalArgumentException("Color is null!");
        }
        return blocks.stream().filter(block -> color.equals(block.getColor())).findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if(material == null) {
            throw new IllegalArgumentException("Material is null !");
        }
        return blocks.stream().filter(block -> material.equals(block.getMaterial())).collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    public void addBlock(Block block){
        if(containsColor(block.getColor())){
            throw new IllegalArgumentException("Block with given color already exists");
        }
        blocks.add(block);
    }

    private boolean containsColor(String color) {
        return blocks.stream().anyMatch(o -> o.getColor().equals(color));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(blocks, wall.blocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blocks);
    }
}