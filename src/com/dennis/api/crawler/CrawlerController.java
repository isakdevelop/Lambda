package com.dennis.api.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {
    private static CrawlerController instance = new CrawlerController();
    public static CrawlerController getInstance() {
        return instance;
    }
    private CrawlerServiceImpl service = CrawlerServiceImpl.getInstance();

    public Map<String, ?> findBugsMusic() throws IOException {
        Map<String, String> paramMap = new HashMap<>();
        return service.findNamesFromWeb(paramMap);
    }

    public Map<String, ?> findMelonMusic() throws IOException {
        Map<String, String> paramMap = new HashMap<>();
        return service.findNamesFromWenInMelon(paramMap);
    }
}