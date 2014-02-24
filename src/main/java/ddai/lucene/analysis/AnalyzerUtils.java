package ddai.lucene.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

/**
 * Created by divi on 2/24/14.
 */
public class AnalyzerUtils {
    public static void displayTokens(Analyzer analyzer, String text) throws IOException {
        displayTokens(analyzer.tokenStream(null, text));
    }
    public static void displayTokens(TokenStream stream) throws IOException {
        CharTermAttribute term = stream.addAttribute(CharTermAttribute.class);
        stream.reset();
        while(stream.incrementToken()) {
            System.out.print("[" + term.toString() + "] ");
        }
        stream.close();
    }
}
