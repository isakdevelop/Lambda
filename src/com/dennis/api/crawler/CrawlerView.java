package com.dennis.api.crawler;

import com.dennis.api.enums.Messenger;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        while (CrawlerRouter.crawlerRout(sc).equals("SUCCESS")) {
        }
    }
}
