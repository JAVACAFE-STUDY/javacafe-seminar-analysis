package analyzer;

import org.apache.lucene.analysis.FilteringTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class CustomLengthFilter extends FilteringTokenFilter {

    private final int min;
    private final int max;

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);


    CustomLengthFilter(TokenStream in, int min, int max) {
        super(in);
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean accept() {
        final int len = termAtt.length();
        return (len >= min && len <= max);
    }

}
