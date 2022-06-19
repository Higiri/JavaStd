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

import member.Member;

public class FileIO {

  /**
   * ファイル読み込み
   * @param path ファイルの場所
   * @return 文字列配列のリスト
   * @throws IOException 入出力例外
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
   * pathで指定したファイルにcsv形式で出力
   * @param lists 1列ごとのデータ
   * @param path  出力先ファイルの指定
   * @throws IOException 入出力例外
   */
  public static void writeCsv(List<Member> members, Path path) throws IOException {
    try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
      for (Member member : members) {
        bw.write(member.toString());
        bw.newLine();
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
