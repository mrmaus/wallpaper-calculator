package gscf.wallpaper;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WallpaperCalculatorTest {

  @Test
  void test_calculations() {
    final WallpaperCalculator calculator = new WallpaperCalculator(List.of(
        new Room(1, 2, 3), // 24
        new Room(7, 7, 7), // 343
        new Room(4, 3, 23), // 358
        new Room(4, 7, 3), // 134
        new Room(15, 15, 15), // 1575
        new Room(4, 3, 23) // 358
    ));
    assertEquals(2792, calculator.totalWallpaperRequired());

    final List<Room> duplicates = calculator.duplicates();
    assertEquals(1, duplicates.size());
    assertEquals(new Room(4, 3, 23), duplicates.get(0));

    final List<Room> cubic = calculator.cubic();
    assertEquals(2, cubic.size());
    assertEquals(new Room(7, 7, 7), cubic.get(0));
    assertEquals(new Room(15, 15, 15), cubic.get(1));
  }

  @Test
  void test_smallestArea() {
    assertEquals(2, WallpaperCalculator.smallestArea(new Room(1, 2, 3)));
    assertEquals(1, WallpaperCalculator.smallestArea(new Room(1, 1, 5)));
    assertEquals(25, WallpaperCalculator.smallestArea(new Room(5, 5, 5)));
  }

  @Test
  void test_wallpaperRequired() {
    assertEquals(24, WallpaperCalculator.wallpaperRequired(new Room(1, 2, 3)));
    assertEquals(23, WallpaperCalculator.wallpaperRequired(new Room(1, 1, 5)));
  }
}
