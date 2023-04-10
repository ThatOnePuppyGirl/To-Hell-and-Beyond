package GameManagingFiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MapGeneratorTest {
    @Test
    public void TestMapGenerator() {
        MapGenerator map = new MapGenerator(10, 10);
        assertTrue(!(map.IsMapInvalid()));
    }

    @Test
    public void TestMapGeneratorMultiple() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            MapGenerator map = new MapGenerator(10, 10);
            if (map.IsMapInvalid())
                count++;
        }
        assertEquals(count, 0);
    }
}
