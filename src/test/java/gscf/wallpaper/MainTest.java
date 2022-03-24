package gscf.wallpaper;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  @Test
  void test_parseInput() {
    try {
      Main.parseInput(Stream.of("1x2x3", "4x5"));
      fail();
    } catch (Exception e) {
      assertEquals("Provided input doesn't match the dimension input format: 4x5", e.getMessage());
    }

    final List<Room> rooms = Main.parseInput(Stream.of("1x2x3", "4x5x6"));
    assertEquals(2, rooms.size());
    assertEquals(new Room(1, 2, 3), rooms.get(0));
    assertEquals(new Room(4, 5, 6), rooms.get(1));
  }

  @Test
  void test_parse() {
    assertEquals(new Room(1, 2, 3), Main.parse("1x2x3"));

    try {
      Main.parse("1x2");
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Provided input doesn't match the dimension input format: 1x2", e.getMessage());
    }

    try {
      Main.parse("1x2x");
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Provided input doesn't match the dimension input format: 1x2x", e.getMessage());
    }
  }

  @Test
  void test_format() {
    assertEquals("1x2x3", Main.format(new Room(1, 2, 3)));
  }
}
