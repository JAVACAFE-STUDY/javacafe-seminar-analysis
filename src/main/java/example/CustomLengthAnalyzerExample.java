package example;

import analyzer.CustomLengthAnalyzer;
import service.AnalyzerService;
import util.CsvLoader;
import vo.TweetPost;

import java.util.List;

public class CustomLengthAnalyzerExample {
    public static void main(String args[]) throws Exception{
        List<TweetPost> tweetPostList =  CsvLoader.readEnglishReview();
        CustomLengthAnalyzer myAnalyzer = new CustomLengthAnalyzer();
        AnalyzerService.analyzeText(tweetPostList, myAnalyzer);
    }
}
