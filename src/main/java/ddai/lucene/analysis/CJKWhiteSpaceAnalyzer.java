package ddai.lucene.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.cjk.CJKBigramFilter;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.icu.ICUFoldingFilter;
import org.apache.lucene.analysis.icu.ICUNormalizer2Filter;
import org.apache.lucene.util.Version;

import java.io.Reader;

/**
 * Created by divi on 2/24/14.
 */
public class CJKWhiteSpaceAnalyzer extends Analyzer {
   @Override
   protected Analyzer.TokenStreamComponents createComponents(String fieldName, Reader reader) {
        Tokenizer source = new WhitespaceTokenizer(Version.LUCENE_46, reader);
        TokenStream filter = new CJKBigramFilter(
                new StopFilter(Version.LUCENE_46,
                               new ICUNormalizer2Filter(new ICUFoldingFilter(source)),
                               StopAnalyzer.ENGLISH_STOP_WORDS_SET));
        return new Analyzer.TokenStreamComponents(source, filter);
    }
}
