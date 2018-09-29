package MyThesis.utils;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class CrawUtil {

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    private final static int RANK_COUNT = 10;
    private static Map<Integer, String> rankMap = new HashMap<Integer, String>();


    public String getContent(){
        try {
            log.info("start !");
            Document document = Jsoup.connect("https://www.iqiyi.com/dianying/").get();
            String[] movieNameArr = document.body().getElementsByClass("main score").text().split(" ");
            for (int i = 0; i < RANK_COUNT; i++){
                String movieName = movieNameArr[i * 2 + 1];
                rankMap.put(i, movieName);
                redisCacheUtil.put(String.valueOf(i), "movieName", movieName);
                System.out.println(redisCacheUtil.getHashKey(String.valueOf(i), "movieName"));
            }

            System.out.println(rankMap.toString());

        } catch (IOException e){
            log.error("connect error!", e);
        }
        return null;
    }
}
