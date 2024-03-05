package crawler;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {

    CrawlerService crawlerService;

    public CrawlerController()  {
        this.crawlerService = CrawlerServiceImpl.getInstance();
    }

    public Map<String,?> findBugsMusic(Scanner sc) throws IOException {
        return crawlerService.findNamesFromWeb();
    }
}
