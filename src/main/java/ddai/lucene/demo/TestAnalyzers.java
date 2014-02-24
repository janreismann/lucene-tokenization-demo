package ddai.lucene.demo;

import ddai.lucene.analysis.*;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

import java.io.IOException;

/**
 * Created by divi on 2/23/14.
 */
public class TestAnalyzers {
    private static final String[] examples = {
            "The quick brown fox jumped over a lazy dog",
            "‛XY&Z' Corpor’ation - xyz@example.com: $8,99'9.......",
            "1n g3t pHinD f1|3z, 7|24n5|473d, +o d3n @8ou+ f0|2m4771ng. TH4T qu3ry d4 w3b, U5Ed r33dz0r u5 ",
            "猪睥くぎゅロ 䄥谯飌ぴゃん 婃䧥た骧騟 ヴじぴゅ 觟リャ, ぢゅ亜が壃びょ 廨みー䩨妦 䄥谯飌ぴゃん 娦骤 䰯や",
            "蠛趯躎 蜬蝁蜠 溾 羬羭, 橀+黐曮禷/觾韄鷡 磃箹+糈(檓檌)觓倎 穊滈溔滆 趍跠跬 疿疶砳, 歾炂盵 蒰裧頖觢賧趡,彃",
            "Зыд но фырре модюж конжыквуюнтюр. Зыд вэниам омнэжквюы нэ. Факэр дикунт промпта зыд ут. ",
            "מתן אם לחיבור יוצרים אנגלית. מה למנוע וספציפיים מדע. עוד של כלים כניסה אווירונאוטיקה. מדע הארץ החברה בגרסה או.",
            "बहुत चिदंश वास्तव बिन्दुओमे वर्णन उसके वास्तव प्रव्रुति विश्वव्यापि नीचे हिंदी अनुकूल परस्पर कुशलता आशाआपस संपुर्ण नवंबर",
            "دون يونيو وقوعها، أن, والنرويج العالمية أم الا. ان للصين النمسا لها, مع نفس مارد ونستون. ما جديدة للمجهود جوي, برلين بالتوقيع حدة عن, "
    };

    private static final Analyzer[] analyzers = new Analyzer[] {
            new WhitespaceAnalyzer(Version.LUCENE_46),
            new SimpleAnalyzer(Version.LUCENE_46),
            new StopAnalyzer(Version.LUCENE_46),
            new StandardAnalyzer(Version.LUCENE_46),
            new StandardShingleAnalyzer(2),
            new CJKAnalyzer(Version.LUCENE_46),
            new CJKWhiteSpaceAnalyzer(),
            new ICUAnalyzer(),
            new ICUShingleAnalyzer(2)
    };

    public static void main(String[] args) throws IOException {
        String[] strings = examples;
        if (args.length > 0) {
            strings = args;
        }
        for (String text : strings) {
            analyze(text);
        }
    }

    private static void analyze(String text) throws IOException {
        System.out.println("Analyzing \"" + text + "\"");
        for (Analyzer analyzer : analyzers) {
            String name = analyzer.getClass().getSimpleName();
            System.out.println("  " + name + ":");
            System.out.print("    ");
            AnalyzerUtils.displayTokens(analyzer, text);
            System.out.println("\n");
        }
    }
}
