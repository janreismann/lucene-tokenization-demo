package ddai.lucene.analysis;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.icu.segmentation.ICUTokenizer;
import org.apache.lucene.util.Version;

import java.io.Reader;

/**
 * Created by ddai on 2/21/14.
 */

public class ICUAnalyzer extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
        Tokenizer source = new ICUTokenizer(reader);
        TokenStream filter = new StopFilter(Version.LUCENE_46, source, StopAnalyzer.ENGLISH_STOP_WORDS_SET);
        return new TokenStreamComponents(source, filter);
    }
}
