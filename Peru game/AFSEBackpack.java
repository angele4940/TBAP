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
    private List<Item> slots;
    
    public AFSEBackpack()
    {
        slots = new ArrayList<Item>();
    }
    
    /**
     * Adds an {@link Item} to the inventory
     *
     * @param i the {@link Item} to be added to the inventory
     */
    public void addItem(Item i)
    {
        cleanUp();
        for(int idx = 0; idx < slots.size(); idx++)
        {
            Item itemInSlot = slots.get(idx);
            if(itemInSlot.getName().equals(i.getName()))
            {
                itemInSlot.combine(i);
                return;
            }
        }
        slots.add(i);
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
        cleanUp();
        for(int i = 0; i < slots.size(); i++)
        {
            if(slots.get(i).getName().equals(itemName))
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
     * @return an {@link Item} that has the corresponding itemNam
     * 
     * @throws IllegalArgumentException if no item that matches itemName
     */
    public Item getItem(String itemName) throws IllegalArgumentException
    {
        cleanUp();
        for(int i = 0; i < slots.size(); i++)
        {
            if(slots.get(i).getName().equals(itemName))
            {
                return slots.get(i);
            }
        }
        throw new IllegalArgumentException(itemName + " does not exist.");
    }
    
    private void cleanUp()
    {
        
        for(int i = 0; i < slots.size(); i++)
        {
            if(slots.get(i).getCount() <= 0)
            {
                slots.remove(i);
                i--;
            }
        }
        
    }
}
