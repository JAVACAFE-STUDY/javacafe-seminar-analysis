package util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import vo.TweetPost;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvLoader {

    public static List<TweetPost> readEnglishReview(){
        String fileName = "src/main/resources/tweet_en.csv";
        return getReview(fileName);
    }

    private static List<TweetPost> getReview(String fileName){

        List<TweetPost> reviewList = null;
        try(Reader reader = Files.newBufferedReader(Paths.get(fileName))){
            CsvToBean<TweetPost> csvToBean = new CsvToBeanBuilder<TweetPost>(reader)
                    .withType(TweetPost.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            reviewList = csvToBean.parse();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(reviewList != null && !reviewList.isEmpty() && reviewList.size() > 1){
            reviewList.remove(0);
        }
        return reviewList;
    }

}
