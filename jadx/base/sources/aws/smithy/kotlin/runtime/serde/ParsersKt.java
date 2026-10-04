package aws.smithy.kotlin.runtime.serde;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Parsers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a5\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001f\u001a;\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010 \u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010!\u001a%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"parse", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "", "transform", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "parseBoolean", "", "(Ljava/lang/String;)Ljava/lang/Object;", "parseInt", "", "parseShort", "", "parseLong", "", "parseFloat", "", "parseDouble", "", "parseByte", "", "parseBigInteger", "Laws/smithy/kotlin/runtime/content/BigInteger;", "parseBigDecimal", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "toTimestamp", "Laws/smithy/kotlin/runtime/time/Instant;", "fmt", "Laws/smithy/kotlin/runtime/time/TimestampFormat;", "parseTimestamp", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/time/TimestampFormat;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/time/TimestampFormat;)Ljava/lang/Object;", "serde"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ParsersKt {

    /* JADX INFO: compiled from: Parsers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimestampFormat.values().length];
            try {
                iArr[TimestampFormat.ISO_8601_CONDENSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimestampFormat.ISO_8601_CONDENSED_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimestampFormat.ISO_8601_FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimestampFormat.ISO_8601.ordinal()] = 4;
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

    @InternalApi
    public static final <T> Object parse(String str, Function1<? super String, ? extends T> transform) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(transform.invoke(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    private static final Instant toTimestamp(String str, TimestampFormat timestampFormat) {
        switch (WhenMappings.$EnumSwitchMapping$0[timestampFormat.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return Instant.INSTANCE.fromIso8601(str);
            case 5:
                return Instant.INSTANCE.fromRfc5322(str);
            case 6:
                return Instant.INSTANCE.fromEpochSeconds(str);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @InternalApi
    public static final <T> Object parse(Object obj, Function1<? super String, ? extends T> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(transform.invoke(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseBoolean(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Boolean.valueOf(Boolean.parseBoolean(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Integer.valueOf(Integer.parseInt(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Short.valueOf(Short.parseShort(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Long.valueOf(Long.parseLong(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Float.valueOf(Float.parseFloat(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Double.valueOf(Double.parseDouble(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Byte.valueOf((byte) Integer.parseInt(str)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(new BigInteger(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(new BigDecimal(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseTimestamp(String str, TimestampFormat fmt) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(fmt, "fmt");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(toTimestamp(str, fmt));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseBoolean(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Boolean.valueOf(Boolean.parseBoolean((String) obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseInt(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Integer.valueOf(Integer.parseInt((String) obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseShort(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Short.valueOf(Short.parseShort((String) obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseLong(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Long.valueOf(Long.parseLong((String) obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseFloat(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Float.valueOf(Float.parseFloat((String) obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseDouble(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Double.valueOf(Double.parseDouble((String) obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseByte(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(Byte.valueOf((byte) Integer.parseInt((String) obj)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseBigInteger(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(new BigInteger((String) obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseBigDecimal(Object obj) {
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(new BigDecimal((String) obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @InternalApi
    public static final Object parseTimestamp(Object obj, TimestampFormat fmt) {
        Intrinsics.checkNotNullParameter(fmt, "fmt");
        if (!Result.m14506isSuccessimpl(obj)) {
            return Result.m14499constructorimpl(obj);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m14499constructorimpl(toTimestamp((String) obj, fmt));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }
}
