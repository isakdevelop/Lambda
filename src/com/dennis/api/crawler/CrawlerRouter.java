package com.dennis.api.crawler;

import com.dennis.api.enums.Messenger;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum CrawlerRouter {
    EXIT("0", sc -> String.valueOf(Messenger.FAIL)),
    BUGS("1", sc ->
    {
        try {
            System.out.println("=== 벅스 뮤직 ===");
            Map<String, ?> map = CrawlerController.getInstance().findBugsMusic();
            System.out.println("벅스 뮤직 결과 : ");

            Iterator<Element> rank = (Iterator<Element>) map.get("rank");
            Iterator<Element> artist = (Iterator<Element>) map.get("artist");
            Iterator<Element> title = (Iterator<Element>) map.get("title");


            while(rank.hasNext()){
                System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
            }

            return String.valueOf(Messenger.SUCCESS);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    MELON("2", sc ->
    {
        try {
            System.out.println("=== 멜론 뮤직 ===");
            Map<String, ?> map = CrawlerController.getInstance().findMelonMusic();
            System.out.println("멜론 뮤직 결과 : ");

            Iterator<Element> rank2 = (Iterator<Element>) map.get("rank");
            Iterator<Element> artist2 = (Iterator<Element>) map.get("artist");
            Iterator<Element> title2 = (Iterator<Element>) map.get("title");


            while(rank2.hasNext()){
                System.out.println(rank2.next().text() + "위 " + artist2.next().text() + " - " + title2.next().text());
            }
            return String.valueOf(Messenger.SUCCESS);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    WRONG("?", i -> String.valueOf(Messenger.SUCCESS))
    ;
    private final String command;
    private final Function<Scanner, String> function;

    CrawlerRouter(String command, Function<Scanner, String> function) {
        this.command = command;
        this.function = function;
    }

    public static String crawlerRout(Scanner sc) {
        System.out.print("[ MENU ]\n" +
                "0. EXIT\n" +
                "1. Bugs_Music\n" +
                "2. Melon_Music\n" +
                "input command : ");
        String input = sc.next();
        return Stream.of(values())
                .filter(i -> i.command.equals(input))
                .findAny().orElse(WRONG)
                .function.apply(sc);
    }
}
