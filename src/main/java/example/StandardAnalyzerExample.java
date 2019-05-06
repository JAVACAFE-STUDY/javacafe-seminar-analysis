package example;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import service.AnalyzerService;
import util.CsvLoader;
import vo.TweetPost;

import java.util.List;

public class StandardAnalyzerExample {

    public static void main(String args[]) throws Exception{
        List<TweetPost> reviewList = CsvLoader.readEnglishReview();
        AnalyzerService.analyzeText(reviewList, new StandardAnalyzer());
    }

}
