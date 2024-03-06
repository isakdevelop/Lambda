package crawler;

import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        CrawlerController crawlerController = new CrawlerController();
        while (true) {
            System.out.print("[메뉴]\n" +
                    "0. 종료\n" +
                    "1. 벅스 뮤직\n" +
                    "2. 멜론 뮤직\n" +
                    "3. ID 검색\n" +
                    "4. 비번 변경\n" +
                    "5. 회원 탈퇴\n" +
                    "6. 회원 목록\n" +
                    "7. 이름 검색\n" +
                    "8. 직업 검색\n" +
                    "9. 회원 수\n" +
                    "입력 : ");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;

                case "1":
                    System.out.println("=== 벅스 뮤직 ===");
                    Map<String, ?> map = crawlerController.findBugsMusic(sc);
                    System.out.println("벅스 뮤직 결과 : ");

                    Iterator<Element> rank = (Iterator<Element>) map.get("rank");
                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");
                    Iterator<Element> title = (Iterator<Element>) map.get("title");


                    while(rank.hasNext()){
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;

                case "2":
                    System.out.println("=== 멜론 뮤직 ===");
                    Map<String, ?> map2 = crawlerController.findMelonMusic(sc);
                    System.out.println("멜론 뮤직 결과 : ");

                    Iterator<Element> rank2 = (Iterator<Element>) map2.get("rank");
                    Iterator<Element> artist2 = (Iterator<Element>) map2.get("artist");
                    Iterator<Element> title2 = (Iterator<Element>) map2.get("title");


                    while(rank2.hasNext()){
                        System.out.println(rank2.next().text() + "위 " + artist2.next().text() + " - " + title2.next().text());
                    }

                    break;

                case "3":
                    System.out.println("=== ID 검색 ===");
                    break;

                case "4":
                    System.out.println("=== 비번 변경 ===");
                    break;

                case "5":
                    System.out.println("=== 회원 탈퇴 ===");
                    break;

                case "6":
                    System.out.println("=== 회원 목록 ===");
                    break;

                case "7":
                    System.out.println("=== 이름 검색 ===");
                    break;

                case "8":
                    System.out.println("=== 직업 검색 ===");
                    break;

                case "9":
                    System.out.println("=== 회원 수 ===");
                    break;
            }
        }
    }
}
