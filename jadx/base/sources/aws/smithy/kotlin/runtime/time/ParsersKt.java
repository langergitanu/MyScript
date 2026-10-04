package aws.smithy.kotlin.runtime.time;

import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: Parsers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\t\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\t\u0010\n\u001aO\u0010\u000b\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u000b\u0010\n\u001aY\u0010\r\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\b2\b\b\u0002\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001aO\u0010\u0010\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0000j\b\u0012\u0004\u0012\u00020\u000f`\bH\u0002¢\u0006\u0004\b\u0010\u0010\n\u001aO\u0010\u0011\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0000j\b\u0012\u0004\u0012\u00020\u000f`\bH\u0002¢\u0006\u0004\b\u0011\u0010\n\u001aO\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u0012\u0010\n\u001aO\u0010\u0013\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u0013\u0010\n\u001aO\u0010\u0014\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u0014\u0010\n\u001aO\u0010\u0015\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u0015\u0010\n\u001aO\u0010\u0016\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u0016\u0010\n\u001aO\u0010\u0017\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u0017\u0010\n\u001aO\u0010\u0018\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u0018\u0010\n\u001aO\u0010\u0019\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b\u0019\u0010\n\u001aO\u0010\u001b\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00070\u0000j\b\u0012\u0004\u0012\u00020\u001a`\bH\u0002¢\u0006\u0004\b\u001b\u0010\n\u001a\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010 \u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010!\u001a1\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010%*\u00020\u00012\u0006\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b&\u0010'\u001a'\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050%*\u00020\u00012\u0006\u0010(\u001a\u00020#H\u0002¢\u0006\u0004\b)\u0010*\u001a\u0017\u0010,\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\u0001H\u0000¢\u0006\u0004\b,\u0010-\u001aO\u0010.\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0001`\bH\u0002¢\u0006\u0004\b.\u0010\n\u001a%\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\u00072\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u00100\u001aO\u00101\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b1\u0010\n\u001aO\u00102\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0000j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0004\b2\u0010\n\u001aO\u00103\u001aB\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00070\u0000j\b\u0012\u0004\u0012\u00020\u001a`\bH\u0002¢\u0006\u0004\b3\u0010\n\u001a\u0017\u00104\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0001H\u0000¢\u0006\u0004\b4\u0010\u001f\"\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00068"}, m1599d2 = {"Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "str", "", "pos", "Laws/smithy/kotlin/runtime/time/ParseResult;", "Laws/smithy/kotlin/runtime/time/Parser;", "dateYear", "()Lkotlin/jvm/functions/Function2;", "dateMonth", "minDigits", "dateDay", "(I)Lkotlin/jvm/functions/Function2;", "Laws/smithy/kotlin/runtime/time/ParsedDate;", "dateYmd", QuestionSurveyAnswerType.DATE, "timeHour", "timeMin", "timeSec", "timeNanos", "signValue", "tzOffsetHoursMins", "tzUtc", "tzOffsetSecIso8601", "Laws/smithy/kotlin/runtime/time/ParsedTime;", "iso8601Time", "input", "Laws/smithy/kotlin/runtime/time/ParsedDatetime;", "parseIso8601", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/time/ParsedDatetime;", "expandExponent", "(Ljava/lang/String;)Ljava/lang/String;", "position", "", "padChar", "Lkotlin/Pair;", "splitAt", "(Ljava/lang/String;IC)Lkotlin/Pair;", "char", "removeChar", "(Ljava/lang/String;C)Lkotlin/Pair;", "Laws/smithy/kotlin/runtime/time/Instant;", "parseEpoch", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/time/Instant;", "dayName", "sp", "(Ljava/lang/String;I)Laws/smithy/kotlin/runtime/time/ParseResult;", "dateMonthName", "tzOffsetSecRfc5322", "rfc5322Time", "parseRfc5322", "Lkotlin/text/Regex;", "exponentialNotationNumber", "Lkotlin/text/Regex;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ParsersKt {
    private static final Regex exponentialNotationNumber = new Regex("(-)?(\\d+(.(\\d+))?)E(-?\\d+)", RegexOption.IGNORE_CASE);

    private static final Function2<String, Integer, ParseResult<Integer>> dateMonthName() {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParsersKt.dateMonthName$lambda$0((String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    private static final Function2<String, Integer, ParseResult<ParsedDate>> dateYmd() {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParsersKt.dateYmd$lambda$0((String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    private static final Function2<String, Integer, ParseResult<ParsedTime>> iso8601Time() {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParsersKt.iso8601Time$lambda$0((String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    private static final Function2<String, Integer, ParseResult<ParsedTime>> rfc5322Time() {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParsersKt.rfc5322Time$lambda$0((String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    private static final Function2<String, Integer, ParseResult<Integer>> signValue() {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParsersKt.signValue$lambda$0((String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int signValue$lambda$0$0(char c) {
        return c == '-' ? -1 : 1;
    }

    private static final Function2<String, Integer, ParseResult<Integer>> tzOffsetHoursMins() {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParsersKt.tzOffsetHoursMins$lambda$0((String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    private static final Function2<String, Integer, ParseResult<Integer>> tzOffsetSecIso8601() {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParsersKt.tzOffsetSecIso8601$lambda$0((String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    private static final Function2<String, Integer, ParseResult<Integer>> tzOffsetSecRfc5322() {
        return new Function2() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ParsersKt.tzOffsetSecRfc5322$lambda$0((String) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int tzOffsetSecRfc5322$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int tzUtc$lambda$0(char c) {
        return 0;
    }

    private static final Function2<String, Integer, ParseResult<Integer>> dateYear() {
        return ParserCombinatorsKt.takeNDigits(4);
    }

    private static final Function2<String, Integer, ParseResult<Integer>> dateMonth() {
        return ParserCombinatorsKt.nDigitsInRange(2, new IntRange(1, 12));
    }

    private static final Function2<String, Integer, ParseResult<Integer>> dateDay(int i) {
        return ParserCombinatorsKt.mnDigitsInRange(i, 2, new IntRange(1, 31));
    }

    static /* synthetic */ Function2 dateDay$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return dateDay(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult dateYmd$lambda$0(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        ParseResult<Integer> parseResultInvoke = dateYear().invoke(str, Integer.valueOf(i));
        int pos = parseResultInvoke.getPos();
        int iIntValue = parseResultInvoke.component2().intValue();
        ParseResult<Integer> parseResultInvoke2 = dateMonth().invoke(str, Integer.valueOf(((ParseResult) ParserCombinatorsKt.optional(ParserCombinatorsKt.m12299char(Soundex.SILENT_MARKER)).invoke(str, Integer.valueOf(pos))).getPos()));
        int pos2 = parseResultInvoke2.getPos();
        int iIntValue2 = parseResultInvoke2.component2().intValue();
        ParseResult parseResult = (ParseResult) dateDay$default(0, 1, null).invoke(str, Integer.valueOf(((ParseResult) ParserCombinatorsKt.optional(ParserCombinatorsKt.m12299char(Soundex.SILENT_MARKER)).invoke(str, Integer.valueOf(pos2))).getPos()));
        return new ParseResult(parseResult.getPos(), new ParsedDate(iIntValue, iIntValue2, ((Number) parseResult.component2()).intValue()));
    }

    private static final Function2<String, Integer, ParseResult<ParsedDate>> date() {
        return dateYmd();
    }

    private static final Function2<String, Integer, ParseResult<Integer>> timeHour() {
        return ParserCombinatorsKt.nDigitsInRange(2, new IntRange(0, 24));
    }

    private static final Function2<String, Integer, ParseResult<Integer>> timeMin() {
        return ParserCombinatorsKt.nDigitsInRange(2, new IntRange(0, 59));
    }

    private static final Function2<String, Integer, ParseResult<Integer>> timeSec() {
        return ParserCombinatorsKt.nDigitsInRange(2, new IntRange(0, 60));
    }

    private static final Function2<String, Integer, ParseResult<Integer>> timeNanos() {
        return ParserCombinatorsKt.fraction(1, 9, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult signValue$lambda$0(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        ParseResult parseResult = (ParseResult) ParserCombinatorsKt.map(ParserCombinatorsKt.alt(ParserCombinatorsKt.m12299char('+'), ParserCombinatorsKt.m12299char(Soundex.SILENT_MARKER)), new Function1() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ParsersKt.signValue$lambda$0$0(((Character) obj).charValue()));
            }
        }).invoke(str, Integer.valueOf(i));
        return new ParseResult(parseResult.getPos(), Integer.valueOf(((Number) parseResult.component2()).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult tzOffsetHoursMins$lambda$0(String str, int i) {
        ParseResult<Integer> parseResult;
        Intrinsics.checkNotNullParameter(str, "str");
        ParseResult<Integer> parseResultInvoke = signValue().invoke(str, Integer.valueOf(i));
        int pos = parseResultInvoke.getPos();
        int iIntValue = parseResultInvoke.component2().intValue();
        ParseResult<Integer> parseResultInvoke2 = timeHour().invoke(str, Integer.valueOf(pos));
        int pos2 = parseResultInvoke2.getPos();
        int iIntValue2 = parseResultInvoke2.component2().intValue();
        int pos3 = ((ParseResult) ParserCombinatorsKt.optional(ParserCombinatorsKt.m12299char(AbstractJsonLexerKt.COLON)).invoke(str, Integer.valueOf(pos2))).getPos();
        if (pos3 < str.length()) {
            parseResult = timeMin().invoke(str, Integer.valueOf(pos3));
        } else {
            parseResult = new ParseResult<>(pos3, 0);
        }
        return new ParseResult(parseResult.getPos(), Integer.valueOf(iIntValue * ((iIntValue2 * 3600) + (parseResult.component2().intValue() * 60))));
    }

    private static final Function2<String, Integer, ParseResult<Integer>> tzUtc() {
        return ParserCombinatorsKt.map(ParserCombinatorsKt.oneOf("Zz"), new Function1() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ParsersKt.tzUtc$lambda$0(((Character) obj).charValue()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult tzOffsetSecIso8601$lambda$0(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        try {
            return (ParseResult) ParserCombinatorsKt.alt(tzUtc(), tzOffsetHoursMins()).invoke(str, Integer.valueOf(i));
        } catch (ParseException unused) {
            throw new ParseException(str, "invalid timezone offset; expected `Z|z` or `(+-)HH:MM`", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult iso8601Time$lambda$0(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        ParseResult<Integer> parseResultInvoke = timeHour().invoke(str, Integer.valueOf(i));
        int pos = parseResultInvoke.getPos();
        int iIntValue = parseResultInvoke.component2().intValue();
        ParseResult<Integer> parseResultInvoke2 = timeMin().invoke(str, Integer.valueOf(((ParseResult) ParserCombinatorsKt.optional(ParserCombinatorsKt.m12299char(AbstractJsonLexerKt.COLON)).invoke(str, Integer.valueOf(pos))).getPos()));
        int pos2 = parseResultInvoke2.getPos();
        int iIntValue2 = parseResultInvoke2.component2().intValue();
        ParseResult<Integer> parseResultInvoke3 = timeSec().invoke(str, Integer.valueOf(((ParseResult) ParserCombinatorsKt.optional(ParserCombinatorsKt.m12299char(AbstractJsonLexerKt.COLON)).invoke(str, Integer.valueOf(pos2))).getPos()));
        int pos3 = parseResultInvoke3.getPos();
        int iIntValue3 = parseResultInvoke3.component2().intValue();
        ParseResult parseResult = (ParseResult) ParserCombinatorsKt.optionalOr(ParserCombinatorsKt.preceded(ParserCombinatorsKt.oneOf(".,"), timeNanos()), 0).invoke(str, Integer.valueOf(pos3));
        int pos4 = parseResult.getPos();
        int iIntValue4 = ((Number) parseResult.component2()).intValue();
        ParseResult<Integer> parseResultInvoke4 = tzOffsetSecIso8601().invoke(str, Integer.valueOf(pos4));
        return new ParseResult(parseResultInvoke4.getPos(), new ParsedTime(iIntValue, iIntValue2, iIntValue3, iIntValue4, parseResultInvoke4.component2().intValue()));
    }

    public static final ParsedDatetime parseIso8601(String input) {
        ParsedTime parsedTime;
        Intrinsics.checkNotNullParameter(input, "input");
        ParseResult<ParsedDate> parseResultInvoke = date().invoke(input, 0);
        int pos = parseResultInvoke.getPos();
        ParsedDate parsedDateComponent2 = parseResultInvoke.component2();
        if (pos == input.length()) {
            parsedTime = new ParsedTime(0, 0, 0, 0, 0);
        } else {
            parsedTime = (ParsedTime) ((ParseResult) ParserCombinatorsKt.preceded(ParserCombinatorsKt.oneOf("Tt"), iso8601Time()).invoke(input, Integer.valueOf(pos))).component2();
        }
        return new ParsedDatetime(parsedDateComponent2.getYear(), parsedDateComponent2.getMonth(), parsedDateComponent2.getDay(), parsedTime.getHour(), parsedTime.getMin(), parsedTime.getSec(), parsedTime.getNs(), parsedTime.getOffsetSec());
    }

    private static final String expandExponent(String str) {
        MatchResult matchResultMatchEntire = exponentialNotationNumber.matchEntire(str);
        if (matchResultMatchEntire != null) {
            MatchResult.Destructured destructured = matchResultMatchEntire.getDestructured();
            String str2 = destructured.getMatch().getGroupValues().get(1);
            String str3 = destructured.getMatch().getGroupValues().get(2);
            String str4 = destructured.getMatch().getGroupValues().get(5);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            Pair<String, Integer> pairRemoveChar = removeChar(str3, '.');
            String strComponent1 = pairRemoveChar.component1();
            int iIntValue = pairRemoveChar.component2().intValue();
            Integer intOrNull = StringsKt.toIntOrNull(str4);
            if (intOrNull == null) {
                throw new ParseException(str, "Failed to read exponent", 0);
            }
            Pair pairSplitAt$default = splitAt$default(strComponent1, iIntValue + intOrNull.intValue(), (char) 0, 2, null);
            String str5 = (String) pairSplitAt$default.component1();
            String str6 = (String) pairSplitAt$default.component2();
            sb.append(str5);
            sb.append('.');
            sb.append(str6);
            String string = sb.toString();
            if (string != null) {
                return string;
            }
        }
        return str;
    }

    static /* synthetic */ Pair splitAt$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = '0';
        }
        return splitAt(str, i, c);
    }

    private static final Pair<String, String> splitAt(String str, int i, char c) {
        if (i <= 0) {
            return TuplesKt.m1606to(String.valueOf(c), StringsKt.padStart(str, str.length() - i, c));
        }
        if (i >= str.length()) {
            return TuplesKt.m1606to(StringsKt.padEnd(str, i, c), String.valueOf(c));
        }
        String strSubstring = str.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = str.substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return TuplesKt.m1606to(strSubstring, strSubstring2);
    }

    private static final Pair<String, Integer> removeChar(String str, char c) {
        String str2 = str;
        if (StringsKt.contains$default((CharSequence) str2, c, false, 2, (Object) null)) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, c, 0, false, 6, (Object) null);
            StringBuilder sb = new StringBuilder();
            String strSubstring = str.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            StringBuilder sbAppend = sb.append(strSubstring);
            String strSubstring2 = str.substring(iIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            return TuplesKt.m1606to(sbAppend.append(strSubstring2).toString(), Integer.valueOf(iIndexOf$default));
        }
        return TuplesKt.m1606to(str, Integer.valueOf(str.length()));
    }

    public static final Instant parseEpoch(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        String strExpandExponent = expandExponent(input);
        ParseResult<Long> parseResultInvoke = ParserCombinatorsKt.takeMNDigitsLong(1, 19).invoke(strExpandExponent, 0);
        int pos = parseResultInvoke.getPos();
        long jLongValue = parseResultInvoke.component2().longValue();
        if (pos == strExpandExponent.length()) {
            return Instant.INSTANCE.fromEpochSeconds(jLongValue, 0);
        }
        return Instant.INSTANCE.fromEpochSeconds(jLongValue, ((Number) ((ParseResult) ParserCombinatorsKt.preceded(ParserCombinatorsKt.m12299char('.'), ParserCombinatorsKt.fraction(1, 9, 9)).invoke(strExpandExponent, Integer.valueOf(pos))).component2()).intValue());
    }

    private static final Function2<String, Integer, ParseResult<String>> dayName() {
        return ParserCombinatorsKt.alt(ParserCombinatorsKt.tag("Mon"), ParserCombinatorsKt.tag("Tue"), ParserCombinatorsKt.tag("Wed"), ParserCombinatorsKt.tag("Thu"), ParserCombinatorsKt.tag("Fri"), ParserCombinatorsKt.tag("Sat"), ParserCombinatorsKt.tag("Sun"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sp */
    public static final ParseResult<Character> m504sp(String str, int i) {
        return ParserCombinatorsKt.m12299char(TokenParser.f2383SP).invoke(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r2.equals("Mar") != false) goto L41;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ParseResult dateMonthName$lambda$0(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        int i2 = 3;
        ParserCombinatorsKt.precond(str, i, 3);
        int i3 = i + 3;
        String strSubstring = str.substring(i, i3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        switch (strSubstring.hashCode()) {
            case 66051:
                if (strSubstring.equals("Apr")) {
                    i2 = 4;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 66195:
                if (strSubstring.equals("Aug")) {
                    i2 = 8;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 68578:
                if (strSubstring.equals("Dec")) {
                    i2 = 12;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 70499:
                if (strSubstring.equals("Feb")) {
                    i2 = 2;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 74231:
                if (strSubstring.equals("Jan")) {
                    i2 = 1;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 74849:
                if (strSubstring.equals("Jul")) {
                    i2 = 7;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 74851:
                if (strSubstring.equals("Jun")) {
                    i2 = 6;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 77118:
                break;
            case 77125:
                if (strSubstring.equals("May")) {
                    i2 = 5;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 78517:
                if (strSubstring.equals("Nov")) {
                    i2 = 11;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 79104:
                if (strSubstring.equals("Oct")) {
                    i2 = 10;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
            case 83006:
                if (strSubstring.equals("Sep")) {
                    i2 = 9;
                    return new ParseResult(i3, Integer.valueOf(i2));
                }
                break;
        }
        throw new ParseException(str, "invalid month `" + strSubstring + '`', i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult tzOffsetSecRfc5322$lambda$0(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "str");
        try {
            return (ParseResult) ParserCombinatorsKt.alt(ParserCombinatorsKt.map(ParserCombinatorsKt.alt(ParserCombinatorsKt.tag("GMT"), ParserCombinatorsKt.tag("UTC"), ParserCombinatorsKt.tag("UT"), ParserCombinatorsKt.tag("Z")), new Function1() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(ParsersKt.tzOffsetSecRfc5322$lambda$0$0((String) obj));
                }
            }), tzOffsetHoursMins()).invoke(str, Integer.valueOf(i));
        } catch (ParseException unused) {
            throw new ParseException(str, "invalid timezone offset; expected `GMT` or `(+-)HHMM`", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParseResult rfc5322Time$lambda$0(String str, int i) {
        ParseResult parseResult;
        Intrinsics.checkNotNullParameter(str, "str");
        ParseResult<Integer> parseResultInvoke = timeHour().invoke(str, Integer.valueOf(i));
        int pos = parseResultInvoke.getPos();
        int iIntValue = parseResultInvoke.component2().intValue();
        ParseResult parseResult2 = (ParseResult) ParserCombinatorsKt.preceded(ParserCombinatorsKt.m12299char(AbstractJsonLexerKt.COLON), timeMin()).invoke(str, Integer.valueOf(pos));
        int pos2 = parseResult2.getPos();
        int iIntValue2 = ((Number) parseResult2.component2()).intValue();
        if (pos2 < str.length() && str.charAt(pos2) == ':') {
            parseResult = (ParseResult) ParserCombinatorsKt.preceded(ParserCombinatorsKt.m12299char(AbstractJsonLexerKt.COLON), timeSec()).invoke(str, Integer.valueOf(pos2));
        } else {
            parseResult = new ParseResult(pos2, 0);
        }
        int pos3 = parseResult.getPos();
        int iIntValue3 = ((Number) parseResult.component2()).intValue();
        ParseResult parseResult3 = (ParseResult) ParserCombinatorsKt.optionalOr(ParserCombinatorsKt.preceded(ParserCombinatorsKt.oneOf("."), timeNanos()), 0).invoke(str, Integer.valueOf(pos3));
        int pos4 = parseResult3.getPos();
        int iIntValue4 = ((Number) parseResult3.component2()).intValue();
        ParseResult parseResult4 = (ParseResult) ParserCombinatorsKt.preceded(ParsersKt$rfc5322Time$1$1.INSTANCE, tzOffsetSecRfc5322()).invoke(str, Integer.valueOf(pos4));
        return new ParseResult(parseResult4.getPos(), new ParsedTime(iIntValue, iIntValue2, iIntValue3, iIntValue4, ((Number) parseResult4.component2()).intValue()));
    }

    public static final ParsedDatetime parseRfc5322(String input) {
        ParseResult parseResult;
        Intrinsics.checkNotNullParameter(input, "input");
        if (!StringsKt.isBlank(input) && !ParserCombinatorsKt.isDigit(input.charAt(0))) {
            parseResult = (ParseResult) ParserCombinatorsKt.map(ParserCombinatorsKt.then(ParserCombinatorsKt.then(dayName(), ParserCombinatorsKt.m12299char(AbstractJsonLexerKt.COMMA)), C37911.INSTANCE), new Function1() { // from class: aws.smithy.kotlin.runtime.time.ParsersKt.parseRfc5322.2
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Pair<Pair<String, Character>, Character> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            }).invoke(input, 0);
        } else {
            parseResult = new ParseResult(0, null);
        }
        ParseResult<Integer> parseResultInvoke = dateDay(1).invoke(input, Integer.valueOf(parseResult.getPos()));
        int pos = parseResultInvoke.getPos();
        int iIntValue = parseResultInvoke.component2().intValue();
        ParseResult parseResult2 = (ParseResult) ParserCombinatorsKt.preceded(C37933.INSTANCE, dateMonthName()).invoke(input, Integer.valueOf(pos));
        int pos2 = parseResult2.getPos();
        int iIntValue2 = ((Number) parseResult2.component2()).intValue();
        ParseResult parseResult3 = (ParseResult) ParserCombinatorsKt.preceded(C37944.INSTANCE, dateYear()).invoke(input, Integer.valueOf(pos2));
        int pos3 = parseResult3.getPos();
        int iIntValue3 = ((Number) parseResult3.component2()).intValue();
        ParsedTime parsedTime = (ParsedTime) ((ParseResult) ParserCombinatorsKt.preceded(C37955.INSTANCE, rfc5322Time()).invoke(input, Integer.valueOf(pos3))).component2();
        return new ParsedDatetime(iIntValue3, iIntValue2, iIntValue, parsedTime.getHour(), parsedTime.getMin(), parsedTime.getSec(), parsedTime.getNs(), parsedTime.getOffsetSec());
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.time.ParsersKt$parseRfc5322$1 */
    /* JADX INFO: compiled from: Parsers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37911 extends FunctionReferenceImpl implements Function2<String, Integer, ParseResult<? extends Character>> {
        public static final C37911 INSTANCE = new C37911();

        C37911() {
            super(2, ParsersKt.class, "sp", "sp(Ljava/lang/String;I)Laws/smithy/kotlin/runtime/time/ParseResult;", 1);
        }

        public final ParseResult<Character> invoke(String p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParsersKt.m504sp(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ ParseResult<? extends Character> invoke(String str, Integer num) {
            return invoke(str, num.intValue());
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.time.ParsersKt$parseRfc5322$3 */
    /* JADX INFO: compiled from: Parsers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37933 extends FunctionReferenceImpl implements Function2<String, Integer, ParseResult<? extends Character>> {
        public static final C37933 INSTANCE = new C37933();

        C37933() {
            super(2, ParsersKt.class, "sp", "sp(Ljava/lang/String;I)Laws/smithy/kotlin/runtime/time/ParseResult;", 1);
        }

        public final ParseResult<Character> invoke(String p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParsersKt.m504sp(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ ParseResult<? extends Character> invoke(String str, Integer num) {
            return invoke(str, num.intValue());
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.time.ParsersKt$parseRfc5322$4 */
    /* JADX INFO: compiled from: Parsers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37944 extends FunctionReferenceImpl implements Function2<String, Integer, ParseResult<? extends Character>> {
        public static final C37944 INSTANCE = new C37944();

        C37944() {
            super(2, ParsersKt.class, "sp", "sp(Ljava/lang/String;I)Laws/smithy/kotlin/runtime/time/ParseResult;", 1);
        }

        public final ParseResult<Character> invoke(String p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParsersKt.m504sp(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ ParseResult<? extends Character> invoke(String str, Integer num) {
            return invoke(str, num.intValue());
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.time.ParsersKt$parseRfc5322$5 */
    /* JADX INFO: compiled from: Parsers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37955 extends FunctionReferenceImpl implements Function2<String, Integer, ParseResult<? extends Character>> {
        public static final C37955 INSTANCE = new C37955();

        C37955() {
            super(2, ParsersKt.class, "sp", "sp(Ljava/lang/String;I)Laws/smithy/kotlin/runtime/time/ParseResult;", 1);
        }

        public final ParseResult<Character> invoke(String p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ParsersKt.m504sp(p0, i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ ParseResult<? extends Character> invoke(String str, Integer num) {
            return invoke(str, num.intValue());
        }
    }
}
