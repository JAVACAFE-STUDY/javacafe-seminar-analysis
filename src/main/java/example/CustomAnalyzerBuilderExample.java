package example;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import service.AnalyzerService;
import util.CsvLoader;
import vo.TweetPost;

import java.util.List;

/**
 * Custom 분석기 사용 예제
 */
public class CustomAnalyzerBuilderExample {
    public static void main(String args[]) throws Exception{

        List<TweetPost> tweetPostList =  CsvLoader.readEnglishReview();

        Analyzer yoloAnalyzer = CustomAnalyzer.builder()
                .withTokenizer("whitespace")
                .addTokenFilter(LowerCaseFilterFactory.class)
                .addTokenFilter(ASCIIFoldingFilterFactory.class)
                .addTokenFilter(StopFilterFactory.class, "ignoreCase", "false")
                .build();

        AnalyzerService.analyzeText(tweetPostList, yoloAnalyzer);

    }

}
