package fileIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

  public static final String[] HEADER = new String[] { "番号", "名前", "ふりがな", "性別", "誕生日" };

  /**
   * ファイル読み込み
   * @param path
   * @return
   * @throws IOException
   */
  public static List<String[]> readCsv(Path path) throws IOException {
    List<String[]> list = new ArrayList<>();
    try {
      List<String> line = Files.readAllLines(path, StandardCharsets.UTF_8);
      for (int i = 1; i < line.size(); i++) {
        list.add(line.get(i).split(","));
      }
    } catch (IOException e) {
      throw new IOException();
    }
    return list;
  }

  /**
   * pathで指定したファイルにCsv出力
   * @param lines
   * @param path
   * @throws IOException
   */
  public static void writeCsv(List<String[]> lines, Path path) throws IOException {
    try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
      for (String[] line : lines) {
        for (int i = 0; i < line.length; i++) {
          if (i != 0) {
            bw.write(",");
          }
          bw.write(line[i]);
        }
      }
    } catch (IOException e) {
      throw new IOException();
    }
  }

  /**
   * 日時付きcsvデータ出力
   * @param lines
   * @throws IOException
   */
  public static void writeData(List<String[]> lines) throws IOException {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyymmdd-HHmmss");
    String now_str = now.format(dtf) + ".csv";
    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(now_str), StandardCharsets.UTF_8)) {
      for (String[] line : lines) {
        for (int i = 0; i < line.length; i++) {
          if (i != 0) {
            bw.write(",");
          }
          bw.write(line[i]);
        }
      }
    } catch (IOException e) {
      throw new IOException();
    }
  }
}
