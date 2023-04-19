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
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
            MapGenerator map = new MapGenerator(10, 10);
            if (map.IsMapInvalid())
                count++;
        }
        assertEquals(count, 0);
    }

    @Test
    public void TestMapGeneratorLongestPath() {
        MapGenerator map = new MapGenerator(10, 10);
        int[] w = map.FindLongestConnections();
        System.out.println(w[0] + " x: " + w[1] + " y: " + w[2]);
        assertTrue((w[0] <= 100));
        assertTrue(((w[1] >= 0) && (w[1] <= 10)));
        assertTrue(((w[2] >= 0) && (w[2] <= 10)));
    }
}
