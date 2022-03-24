package gscf.wallpaper;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Integration test for the whole application
 */
public class MainIT {

  @SuppressWarnings("ConstantConditions")
  @Test
  void test_full_integration_test() throws Exception {
    final PrintStream current = System.out;

    final ByteArrayOutputStream tmp = new ByteArrayOutputStream();

    try {
      System.setOut(new PrintStream(tmp));

      final File input = new File(MainIT.class.getResource("/sample-input.txt").toURI());
      Main.main(new String[]{input.getCanonicalPath()});
    } finally {
      System.setOut(current);
    }

    final String expected = Files.readString(new File(MainIT.class.getResource("/sample-output.txt").toURI()).toPath());
    assertEquals(expected, tmp.toString().replaceAll("\r", ""));
  }
}
