package gscf.wallpaper;

import lombok.Data;

import static gscf.wallpaper.Assert.assertPositive;

/**
 * Represents rectangular room
 */
@Data
class Room {

  // Assignment doesn't specify the range of dimension values, assuming they fit into positive part of the int
  private final int length;
  private final int width;
  private final int height;

  Room(int length, int width, int height) {
    assertPositive(length, "Length must have positive value: " + length);
    assertPositive(width, "Width must have positive value: " + width);
    assertPositive(height, "Height must have positive value: " + height);

    this.length = length;
    this.width = width;
    this.height = height;
  }

  /**
   * Calculates the total surface area of the room (rectangular prism) in square feet
   */
  int calculateSurfaceArea() {
    // as possible optimization the area could be pre-calculated on object creation
    return 2 * length * width
        + 2 * width * height
        + 2 * height * length;
  }

  /**
   * @return true if room is of a 'cubic' shape (length==width==height); false otherwise
   */
  boolean isCube() {
    return (length == width) && (width == height);
  }
  
}
