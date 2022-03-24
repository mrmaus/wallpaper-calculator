package gscf.wallpaper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

  @Test
  void test_constructor_arguments_validation() {
    try {
      new Room(0, 5, 6);
      fail();
    } catch (Exception e) {
      assertEquals("Length must have positive value: 0", e.getMessage());
    }

    try {
      new Room(4, -1, 6);
      fail();
    } catch (Exception e) {
      assertEquals("Width must have positive value: -1", e.getMessage());
    }

    try {
      new Room(23, 29, 0);
      fail();
    } catch (Exception e) {
      assertEquals("Height must have positive value: 0", e.getMessage());
    }
  }

  @Test
  void test_calculateSurfaceArea() {
    assertEquals(22, new Room(1, 2, 3).calculateSurfaceArea());
    assertEquals(22, new Room(1, 1, 5).calculateSurfaceArea());
    assertEquals(150, new Room(5, 5, 5).calculateSurfaceArea());
  }

  @Test
  void test_isCube() {
    assertTrue(new Room(4, 4, 4).isCube());
    assertFalse(new Room(4, 9, 4).isCube());
  }
}
