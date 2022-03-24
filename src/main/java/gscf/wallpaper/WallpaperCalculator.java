package gscf.wallpaper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Offers various functions for wallpaper calculation
 */
class WallpaperCalculator {

  private final List<Room> rooms;

  WallpaperCalculator(List<Room> rooms) {
    this.rooms = rooms;
  }

  /**
   * Calculates number of total square feet of wallpaper the company should order for all rooms from input
   */
  int totalWallpaperRequired() {
    return
        rooms.stream()
            .mapToInt(WallpaperCalculator::wallpaperRequired)
            .sum();
  }

  /**
   * list all rooms from input that have a cubic shape (order by total needed wallpaper descending)
   */
  List<Room> cubic() {
    return
        rooms.stream()
            .filter(Room::isCube)

            /* sorting cubes by surface area yields same result as sorting them by wallpaper required,
               but it requires performing less operations */
            .sorted(Comparator.comparingInt(Room::calculateSurfaceArea))
            .collect(Collectors.toList());
  }

  /**
   * List all rooms from input that are appearing more than once
   */
  List<Room> duplicates() {
    final Set<Room> duplicateCheck = new HashSet<>();

    final List<Room> result = new LinkedList<>();

    rooms.forEach(room -> {
      if (duplicateCheck.contains(room)) {
        result.add(room);
      } else {
        duplicateCheck.add(room);
      }
    });

    return result;
  }

  /**
   * Calculates total wallpaper required for the provided root (in square feet)
   * <p>
   * wallpaper needed = room surface area + the smallest area
   */
  static int wallpaperRequired(Room room) {
    return room.calculateSurfaceArea() + smallestArea(room);
  }

  /**
   * Identifies the smallest surface area (wall, ceiling or floor) for the provided room
   */
  static int smallestArea(Room room) {
    final int[] dimensions = {room.getLength(), room.getWidth(), room.getHeight()};
    Arrays.sort(dimensions);
    return dimensions[0] * dimensions[1];
  }

}
