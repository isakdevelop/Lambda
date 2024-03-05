package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class CrawlerServiceImpl implements CrawlerService {
    private static CrawlerService instance = new CrawlerServiceImpl();
    public static CrawlerService getInstance()  {
        return instance;
    }
    Map<String, String[]> crawlerMap;

    public CrawlerServiceImpl() {
        this.crawlerMap = new HashMap<>();
    }

    @Override
    public void findNamesFromWeb() throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10*1000).get();
        Elements element = doc.select("table.byChart");
        Iterator<Element> title = element.select("p.title").iterator();
        Iterator<Element> artist = element.select("p.artist").iterator();
        Iterator<Element> rank = element.select("strong").iterator();

        while (rank.hasNext())  {
            String[] data = {rank.next().text(), title.next().text(), artist.next().text()};
            crawlerMap.put(rank.next().text(),data);
            System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
        }

    }

}