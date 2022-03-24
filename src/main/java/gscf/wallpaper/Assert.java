package gscf.wallpaper;

/**
 * Assertion functions
 */
class Assert {

  /**
   * Validates that provided integer is positive
   *
   * @throws IllegalArgumentException if validation fails
   */
  static void assertPositive(int i, String message) {
    if (i <= 0) {
      throw new IllegalArgumentException(message);
    }
  }
}
