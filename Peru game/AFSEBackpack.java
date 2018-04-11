import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class AFSEBackpack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AFSEBackpack implements Inventory
{
    private List<Item> pockets = new ArrayList<>();
    public AFSEBackpack()
    {
        List<Item> Backpack = pockets;
    }
    
    /**
     * Adds an {@link Item} to the inventory
     *
     * @param i the {@link Item} to be added to the inventory
     */
    public void addItem(Item i)
    {
        for(int interval = 0; interval < pockets.size(); interval++){
            if(pockets.get(interval).getName().equals(i.getName()) && pockets.get(interval).getDescription().equals(i.getDescription()))
            {
                pockets.get(interval).combine(i);
            }
        }
        pockets.add(i);
    }

    /**
     * Determines whether or not an {@link Item} with the itemName is in the
     * inventory
     *
     * @param itemName the name of the item
     * @return true if an item with itemName is in the inventory, false
     *         otherwise
     */
    public boolean hasItem(String itemName)
    {
        for(int i = 0; i < pockets.size(); i++)
        {
            if(pockets.get(i).getName().equals(itemName) && pockets.get(i).getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets an {@link Item} with itemName from the inventory, provided it
     * exists in the inventory.
     *
     * @param itemName the name of the item
     * @return an {@link Item} that has the corresponding itemName, null if
     *         no such {@link Item} exists
     */
    public Item getItem(String itemName)
    {
        for(int i = 0; i < pockets.size(); i++)
        {
            if(pockets.get(i).getName().equals(itemName))
            {
                return pockets.get(i);
            }
        }
        throw new IllegalArgumentException("String");
    }
}
