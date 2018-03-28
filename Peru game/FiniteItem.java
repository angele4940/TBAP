
/**
 * Write a description of class FiniteItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiniteItem extends Item
{
    private int count;
    private String name;
    private String description;
    
    public FiniteItem(String name, String description, int count)
    {
        if(count < 0){
            throw new IllegalArgumentException(
                "FiniteItem does not accept negative count: " + count
            );
        }
        this.count = count;
        this.description = description;
        this.name = name;
    }
    
    /**
     * Gets the name of the item in the text adventure game.
     *
     * @return the name of the item
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Gets the description of the item in the text adventure game.
     *
     * @return the description of the item     
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Gets the count of how many instances of the item there are. 
     * For example, a pack of gum item might have 5 pieces of gum.
     *
     * @return the number of instances in this item
     */
    public int getCount()
    {
        return this.count;
    }

    /**
     * Uses a positive number of instances of the item. 
     *
     * @param positiveNum a positive number of items to use
     * @throws IllegalArgumentException if positive num is non-positive OR
     *         exceeds the count of instances of the item
     */
    public void use(int positiveNum) throws IllegalArgumentException
    {
        boolean isNotPositive = positiveNum <= 0;
        boolean isMoreThanCount = positiveNum > this.count;
        if(isNotPositive || isMoreThanCount)
        {
            throw new IllegalArgumentException(
                "FiniteItem cannot use: " + positiveNum
            );
        }
        this.count -= positiveNum;
        
    }
    
    @Override
    public void combine(Item sameKind) throws IllegalArgumentException{
        super.combine(sameKind);
        this.count += sameKind.getCount();
    }

}
