import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestBackpack.
 */
public class TestAFSEBackpack
{
    @Test
    public void testConstructor()
    {
        Inventory inv = new AFSEBackpack();
    }
    
    @Test
    public void testGetItemNoCombine()
    {
        Inventory inv = new AFSEBackpack();
        
        Item apple = new FiniteItem("Apple", "Red-Delicious", 1);
        
        inv.addItem(apple);
        
        // Should work when only one item added
        Item retrApple = inv.getItem("Apple");
        assertEquals("Apple", retrApple.getName());
        assertEquals("Red-Delicious", retrApple.getDescription()); 
        assertEquals(1, retrApple.getCount());
        
        Item o = new FiniteItem("Orange", "Ripe and tart", 15);
        Item l = new FiniteItem("Lime", "Green and sour", 4);
        
        inv.addItem(o);
        inv.addItem(l);
        
        
        // Should still work when multiple items added
        Item retrOr = inv.getItem("Orange");
        assertEquals("Orange", retrOr.getName());
        assertEquals("Ripe and tart", retrOr.getDescription()); 
        assertEquals(15, retrOr.getCount());
        
        Item retrLi = inv.getItem("Lime");
        assertEquals("Lime", retrLi.getName());
        assertEquals("Green and sour", retrLi.getDescription()); 
        assertEquals(4, retrLi.getCount());
        
        retrApple = inv.getItem("Apple");
        assertEquals("Apple", retrApple.getName());
        assertEquals("Red-Delicious", retrApple.getDescription()); 
        assertEquals(1, retrApple.getCount());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testGetItemThatIsAbsentInEmptyBackpack()
    {
        Inventory inv = new AFSEBackpack();
        //Exception should be thrown here
        inv.getItem("Candy");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testGetItemThatIsAbsentInFilledBackpack()
    {
        Inventory inv = new AFSEBackpack();
        Item o = new FiniteItem("Orange", "Ripe and tart", 15);
        Item l = new FiniteItem("Lime", "Green and sour", 4);
        inv.addItem(o);
        inv.addItem(l);
        //Exception should be thrown here
        inv.getItem("Candy");
    }
    
    @Test
    public void testHasItem()
    {
        Inventory inv = new AFSEBackpack();
        Item m = new FiniteItem("Money", "U.S. Currency", 5);
        Item cA = new FiniteItem("Cookies", "Delicious chocolate chip", 3);
        Item cB = new FiniteItem("Cookies", "Delicious chocolate chip", 4);
        
        // Before addition to bpack, these items shoudln't be present
        assertEquals(false, inv.hasItem("Money"));
        assertEquals(false, inv.hasItem("Cookies"));
        
        inv.addItem(m);
        
        // Only ONE added item should be present
        assertEquals(true, inv.hasItem("Money"));
        assertEquals(false, inv.hasItem("Cookies"));
        
        inv.addItem(cA);
        
        // Both added items should be present
        assertEquals(true, inv.hasItem("Money"));
        assertEquals(true, inv.hasItem("Cookies"));
        
        inv.addItem(cB);
        // Both added items should STILL be present
        assertEquals(true, inv.hasItem("Money"));
        assertEquals(true, inv.hasItem("Cookies"));
    }
    
    @Test
    public void testGetItemCombo()
    {
        Inventory inv = new AFSEBackpack();
        
        Item appA = new FiniteItem("Apple", "Red-Delicious", 5);
        Item appB = new FiniteItem("Apple", "Red-Delicious", 3);
        Item oraA = new FiniteItem("Orange", "Ripe and tart", 15);
        Item oraB = new FiniteItem("Orange", "Ripe and tart", 25);
        Item limA = new FiniteItem("Lime", "Green and sour", 4);
        Item limB = new FiniteItem("Lime", "Green and sour", 5);
        Item limC = new FiniteItem("Lime", "Green and sour", 5);
        
        inv.addItem(appA);
        inv.addItem(oraA);
        inv.addItem(limA);
        
        // Orange should not combine with other different items
        Item retrOrange = inv.getItem("Orange");
        assertEquals("Orange", retrOrange.getName());
        assertEquals("Ripe and tart", retrOrange.getDescription()); 
        assertEquals(15, retrOrange.getCount());
        
        // Orange should not combine when different items combine
        inv.addItem(appB);
        inv.addItem(limB);
        inv.addItem(limC);
        
        retrOrange = inv.getItem("Orange");
        assertEquals("Orange", retrOrange.getName());
        assertEquals("Ripe and tart", retrOrange.getDescription()); 
        assertEquals(15, retrOrange.getCount());
        
        //Orange should combine when another orange is added
        inv.addItem(oraB);
        
        retrOrange = inv.getItem("Orange");
        assertEquals("Orange", retrOrange.getName());
        assertEquals("Ripe and tart", retrOrange.getDescription()); 
        assertEquals(40, retrOrange.getCount());
        
        //Other items should have combined properly
        Item retrApple = inv.getItem("Apple");
        assertEquals("Apple", retrApple.getName());
        assertEquals("Red-Delicious", retrApple.getDescription()); 
        assertEquals(8, retrApple.getCount());
        
        Item retrLime = inv.getItem("Lime");
        assertEquals("Lime", retrLime.getName());
        assertEquals("Green and sour", retrLime.getDescription()); 
        assertEquals(14, retrLime.getCount());
    }
    
    @Test
    public void testHasItemUsedUp()
    {
        Inventory inv = new AFSEBackpack();
        Item m = new FiniteItem("Money", "U.S. Currency", 5);
        Item c = new FiniteItem("Cookies", "Delicious chocolate chip", 3);
        
        inv.addItem(m);
        inv.addItem(c);
        
        c.use(2);
        
        // Items should exist after used if they aren't used completely
        assertEquals(true, inv.hasItem("Cookies"));
        assertEquals(true, inv.hasItem("Money"));
        
        c.use(1);
        
        // Cookies disappear because all 3 units have been used
        assertEquals(false, inv.hasItem("Cookies"));
        assertEquals(true, inv.hasItem("Money"));
        
        m.use(5);
        
        // Money disappears because all 5 units have been used
        assertEquals(false, inv.hasItem("Money"));
    }
}















