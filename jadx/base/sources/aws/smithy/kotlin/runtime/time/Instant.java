package aws.smithy.kotlin.runtime.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: InstantJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\fH\u0096\u0082\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u0010H\u0096\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0011\u0010&\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010(\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b'\u0010\u000b¨\u0006*"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/Instant;", "", "Ljava/time/Instant;", "value", "<init>", "(Ljava/time/Instant;)V", "other", "", "compareTo", "(Laws/smithy/kotlin/runtime/time/Instant;)I", "hashCode", "()I", "", "", "equals", "(Ljava/lang/Object;)Z", "", "toString", "()Ljava/lang/String;", "Lkotlin/time/Duration;", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(J)Laws/smithy/kotlin/runtime/time/Instant;", "plus", "minus-LRDsOJo", "minus", "minus-5sfh64U", "(Laws/smithy/kotlin/runtime/time/Instant;)J", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "fmt", "format", "(Laws/smithy/kotlin/runtime/time/TimestampFormat;)Ljava/lang/String;", "Ljava/time/Instant;", "getValue$runtime_core", "()Ljava/time/Instant;", "", "getEpochSeconds", "()J", "epochSeconds", "getNanosecondsOfSecond", "nanosecondsOfSecond", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Instant implements Comparable<Instant> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final DateTimeFormatter ISO_8601_CONDENSED;
    private static final DateTimeFormatter ISO_8601_CONDENSED_DATE;
    private static final Instant MAX_VALUE;
    private static final Instant MIN_VALUE;
    private static final DateTimeFormatter RFC_5322_FIXED_DATE_TIME;
    private static final ZoneId utcZone;
    private final java.time.Instant value;

    /* JADX INFO: compiled from: InstantJVM.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimestampFormat.values().length];
            try {
                iArr[TimestampFormat.ISO_8601.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimestampFormat.ISO_8601_CONDENSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimestampFormat.ISO_8601_CONDENSED_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimestampFormat.ISO_8601_FULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TimestampFormat.RFC_5322.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TimestampFormat.EPOCH_SECONDS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Instant(java.time.Instant value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    /* JADX INFO: renamed from: getValue$runtime_core, reason: from getter */
    public final java.time.Instant getValue() {
        return this.value;
    }

    public final long getEpochSeconds() {
        return this.value.getEpochSecond();
    }

    public final int getNanosecondsOfSecond() {
        return this.value.getNano();
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Instant) && Intrinsics.areEqual(this.value, ((Instant) other).value);
        }
        return true;
    }

    public String toString() {
        return format(TimestampFormat.ISO_8601);
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public final Instant m12288minusLRDsOJo(long duration) {
        return m12289plusLRDsOJo(Duration.m15900unaryMinusUwyO8pc(duration));
    }

    /* JADX INFO: renamed from: minus-5sfh64U, reason: not valid java name */
    public final long m12287minus5sfh64U(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        java.time.Duration durationBetween = java.time.Duration.between(other.value, this.value);
        Intrinsics.checkNotNullExpressionValue(durationBetween, "between(...)");
        return Duration.m15885plusLRDsOJo(DurationKt.toDuration(durationBetween.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration(durationBetween.getNano(), DurationUnit.NANOSECONDS));
    }

    public final String format(TimestampFormat fmt) {
        Intrinsics.checkNotNullParameter(fmt, "fmt");
        switch (WhenMappings.$EnumSwitchMapping$0[fmt.ordinal()]) {
            case 1:
                String str = DateTimeFormatter.ISO_INSTANT.format(this.value.truncatedTo(ChronoUnit.MICROS));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            case 2:
                String str2 = ISO_8601_CONDENSED.format(this.value);
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return str2;
            case 3:
                String str3 = ISO_8601_CONDENSED_DATE.format(this.value);
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                return str3;
            case 4:
                String str4 = DateTimeFormatter.ISO_INSTANT.format(this.value);
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                return str4;
            case 5:
                String str5 = RFC_5322_FIXED_DATE_TIME.format(ZonedDateTime.ofInstant(this.value, ZoneOffset.UTC));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                return str5;
            case 6:
                StringBuffer stringBuffer = new StringBuffer(String.valueOf(getEpochSeconds()));
                if (getNanosecondsOfSecond() > 0) {
                    stringBuffer.append(".");
                    String strValueOf = String.valueOf(getNanosecondsOfSecond());
                    stringBuffer.append(StringsKt.repeat("0", 9 - strValueOf.length()));
                    stringBuffer.append(strValueOf);
                    return StringsKt.trimEnd(stringBuffer, '0').toString();
                }
                String string = stringBuffer.toString();
                Intrinsics.checkNotNull(string);
                return string;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: InstantJVM.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\bJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0011¨\u0006 "}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/Instant$Companion;", "", "<init>", "()V", "", "ts", "Laws/smithy/kotlin/runtime/time/Instant;", "fromIso8601", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/time/Instant;", "fromRfc5322", "", "seconds", "", "ns", "fromEpochSeconds", "(JI)Laws/smithy/kotlin/runtime/time/Instant;", "now", "()Laws/smithy/kotlin/runtime/time/Instant;", "Ljava/time/format/DateTimeFormatter;", "RFC_5322_FIXED_DATE_TIME", "Ljava/time/format/DateTimeFormatter;", "Ljava/time/ZoneId;", "kotlin.jvm.PlatformType", "utcZone", "Ljava/time/ZoneId;", "ISO_8601_CONDENSED", "ISO_8601_CONDENSED_DATE", "MIN_VALUE", "Laws/smithy/kotlin/runtime/time/Instant;", "getMIN_VALUE", "MAX_VALUE", "getMAX_VALUE", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Instant fromIso8601(String ts) {
            Intrinsics.checkNotNullParameter(ts, "ts");
            return InstantJVMKt.fromParsedDateTime(ParsersKt.parseIso8601(ts));
        }

        public final Instant fromRfc5322(String ts) {
            Intrinsics.checkNotNullParameter(ts, "ts");
            return InstantJVMKt.fromParsedDateTime(ParsersKt.parseRfc5322(ts));
        }

        public static /* synthetic */ Instant fromEpochSeconds$default(Companion companion, long j, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.fromEpochSeconds(j, i);
        }

        public final Instant fromEpochSeconds(long seconds, int ns) {
            java.time.Instant instantOfEpochSecond = java.time.Instant.ofEpochSecond(seconds, ns);
            Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, "ofEpochSecond(...)");
            return new Instant(instantOfEpochSecond);
        }

        public final Instant fromEpochSeconds(String ts) {
            Intrinsics.checkNotNullParameter(ts, "ts");
            return ParsersKt.parseEpoch(ts);
        }

        public final Instant now() {
            java.time.Instant instantNow = java.time.Instant.now();
            Intrinsics.checkNotNullExpressionValue(instantNow, "now(...)");
            return new Instant(instantNow);
        }

        public final Instant getMIN_VALUE() {
            return Instant.MIN_VALUE;
        }

        public final Instant getMAX_VALUE() {
            return Instant.MAX_VALUE;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        RFC_5322_FIXED_DATE_TIME = InstantJVMKt.buildRfc5322Formatter();
        ZoneId zoneIdOf = ZoneId.of("Z");
        utcZone = zoneIdOf;
        DateTimeFormatter dateTimeFormatterWithZone = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'").withZone(zoneIdOf);
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterWithZone, "withZone(...)");
        ISO_8601_CONDENSED = dateTimeFormatterWithZone;
        DateTimeFormatter dateTimeFormatterWithZone2 = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(zoneIdOf);
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterWithZone2, "withZone(...)");
        ISO_8601_CONDENSED_DATE = dateTimeFormatterWithZone2;
        MIN_VALUE = InstantKt.fromEpochMilliseconds(companion, kotlin.time.Instant.INSTANCE.getDISTANT_PAST().toEpochMilliseconds());
        MAX_VALUE = InstantKt.fromEpochMilliseconds(companion, kotlin.time.Instant.INSTANCE.getDISTANT_FUTURE().toEpochMilliseconds());
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public final Instant m12289plusLRDsOJo(long duration) {
        return INSTANCE.fromEpochSeconds(getEpochSeconds() + Duration.m15870getInWholeSecondsimpl(duration), getNanosecondsOfSecond() + Duration.m15872getNanosecondsComponentimpl(duration));
    }
}
