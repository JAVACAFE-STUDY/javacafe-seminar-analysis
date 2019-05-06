package service;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import vo.TweetPost;

import java.util.List;

public class AnalyzerService {
    public static void analyzeText(List<TweetPost> reviewList, Analyzer analyzer) throws Exception{

        System.out.println("\n\n\n###################" + analyzer.getClass().getName() + " Test Result #############################################################");
        for(TweetPost post : reviewList){
            System.out.println("\n==================Origin Text=====================");
            System.out.println(post.getText());
            System.out.println("\n==================Analysis Result=====================");
            if( post.getText() != null ){
                // create TokenStream
                TokenStream tokenStream = analyzer.tokenStream("twitterText", post.getText());
                // To get the Token's String value
                CharTermAttribute cta = tokenStream.addAttribute(CharTermAttribute.class);
                try {
                    // reset the token stream(mandatory)
                    tokenStream.reset();
                    System.out.println();
                    // read token
                    while (tokenStream.incrementToken()) {
                        // print token value as a string
                        System.out.print(cta);
                        System.out.print(" | ");
                    }
                    tokenStream.end();
                } finally {
                    tokenStream.close();
                }
            }


        }
    }
}
