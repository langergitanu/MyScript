package aws.smithy.kotlin.runtime.time;

import com.survicate.surveys.TextRecallingManager;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: InstantJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/ParsedDatetime;", "parsed", "Laws/smithy/kotlin/runtime/time/Instant;", "fromParsedDateTime", "(Laws/smithy/kotlin/runtime/time/ParsedDatetime;)Laws/smithy/kotlin/runtime/time/Instant;", "Ljava/time/format/DateTimeFormatter;", "buildRfc5322Formatter", "()Ljava/time/format/DateTimeFormatter;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InstantJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Instant fromParsedDateTime(ParsedDatetime parsedDatetime) {
        List listListOf;
        if (parsedDatetime.getHour() == 24 && parsedDatetime.getMin() == 0 && parsedDatetime.getSec() == 0) {
            listListOf = CollectionsKt.listOf((Object[]) new Integer[]{1, 0, 0, 0});
        } else if (parsedDatetime.getHour() == 23 && parsedDatetime.getMin() == 59 && parsedDatetime.getSec() == 60) {
            listListOf = CollectionsKt.listOf((Object[]) new Integer[]{0, 23, 59, 59});
        } else {
            listListOf = CollectionsKt.listOf((Object[]) new Integer[]{0, Integer.valueOf(parsedDatetime.getHour()), Integer.valueOf(parsedDatetime.getMin()), Integer.valueOf(parsedDatetime.getSec())});
        }
        java.time.Instant instant = LocalDateTime.of(parsedDatetime.getYear(), parsedDatetime.getMonth(), parsedDatetime.getDay(), ((Number) listListOf.get(1)).intValue(), ((Number) listListOf.get(2)).intValue(), ((Number) listListOf.get(3)).intValue(), parsedDatetime.getNs()).plusDays(((Number) listListOf.get(0)).intValue()).atOffset(ZoneOffset.ofTotalSeconds(parsedDatetime.getOffsetSec())).toInstant();
        Intrinsics.checkNotNull(instant);
        return new Instant(instant);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DateTimeFormatter buildRfc5322Formatter() {
        DateTimeFormatter dateTimeFormatterWithChronology = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient().optionalStart().appendText(ChronoField.DAY_OF_WEEK, MapsKt.mapOf(TuplesKt.m1606to(1L, "Mon"), TuplesKt.m1606to(2L, "Tue"), TuplesKt.m1606to(3L, "Wed"), TuplesKt.m1606to(4L, "Thu"), TuplesKt.m1606to(5L, "Fri"), TuplesKt.m1606to(6L, "Sat"), TuplesKt.m1606to(7L, "Sun"))).appendLiteral(TextRecallingManager.ANSWER_SEPARATOR).optionalEnd().appendValue(ChronoField.DAY_OF_MONTH, 2, 2, SignStyle.NOT_NEGATIVE).appendLiteral(TokenParser.f2383SP).appendText(ChronoField.MONTH_OF_YEAR, MapsKt.mapOf(TuplesKt.m1606to(1L, "Jan"), TuplesKt.m1606to(2L, "Feb"), TuplesKt.m1606to(3L, "Mar"), TuplesKt.m1606to(4L, "Apr"), TuplesKt.m1606to(5L, "May"), TuplesKt.m1606to(6L, "Jun"), TuplesKt.m1606to(7L, "Jul"), TuplesKt.m1606to(8L, "Aug"), TuplesKt.m1606to(9L, "Sep"), TuplesKt.m1606to(10L, "Oct"), TuplesKt.m1606to(11L, "Nov"), TuplesKt.m1606to(12L, "Dec"))).appendLiteral(TokenParser.f2383SP).appendValue(ChronoField.YEAR, 4).appendLiteral(TokenParser.f2383SP).appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(AbstractJsonLexerKt.COLON).appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(AbstractJsonLexerKt.COLON).appendValue(ChronoField.SECOND_OF_MINUTE, 2).optionalEnd().appendLiteral(TokenParser.f2383SP).appendOffset("+HHMM", "GMT").toFormatter().withChronology(IsoChronology.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterWithChronology, "withChronology(...)");
        return dateTimeFormatterWithChronology;
    }
}
