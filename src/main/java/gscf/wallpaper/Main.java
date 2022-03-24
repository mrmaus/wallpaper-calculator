package gscf.wallpaper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Main {

  /**
   * Pattern to validate formatted dimension string
   */
  private static final Pattern DIMENSION_INPUT_FORMAT = Pattern.compile("\\d+x\\d+x\\d+");

  /**
   * Separator for formatted dimension string
   */
  private static final String DIMENSION_SEPARATOR = "x";

  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      printUsage();
      exit(1);
    }

    final Path source = Paths.get(args[0]);
    if (!source.toFile().exists()) {
      log("Provided path doesn't reference an existing file: " + source);
      exit(2);
    }

    final List<Room> rooms = parseInput(Files.lines(source));

    final WallpaperCalculator calculator = new WallpaperCalculator(rooms);

    // 1. calculate number of total square feet of wallpaper the company should order for all rooms from input
    log("Total square feet of wallpaper needed: " + calculator.totalWallpaperRequired());


    // 2. list all rooms from input that have a cubic shape (order by total needed wallpaper descending)
    log("\nAll rooms with cubic shape (sorted by needed wallpaper):");
    calculator.cubic().forEach(room -> log(format(room)));


    // 3. list all rooms from input that are appearing more than once (order is irrelevant)
    log("\nDuplicate rooms:");
    calculator.duplicates().forEach(room -> log(format(room)));
  }

  /**
   * Parses list of dimension strings into list of {@link Room} instances
   */
  static List<Room> parseInput(Stream<String> lines) {
    return
        lines
            .map(Main::parse)
            .collect(Collectors.toList());
  }

  /**
   * Parses provided dimensions string into {@link Room} object according to convention LxWxH
   */
  static Room parse(String s) {
    if (DIMENSION_INPUT_FORMAT.matcher(s).matches()) {
      final String[] split = s.split(DIMENSION_SEPARATOR);
      return new Room(parseInt(split[0]), parseInt(split[1]), parseInt(split[2]));
    }
    throw new IllegalArgumentException("Provided input doesn't match the dimension input format: " + s);
  }

  /**
   * Returns the provided room dimensions as string according to convention LxWxH
   */
  static String format(Room room) {
    return room.getLength() + DIMENSION_SEPARATOR + room.getWidth() + DIMENSION_SEPARATOR + room.getHeight();
  }

  /**
   * Prints the program usage instruction
   */
  private static void printUsage() {
    log("Please provide path to the input file as program argument " +
        "(path can be absolute or relevant to the working directory)");
  }

  /**
   * Hide direct system out call
   */
  private static void log(String s) {
    System.out.println(s);
  }

}



