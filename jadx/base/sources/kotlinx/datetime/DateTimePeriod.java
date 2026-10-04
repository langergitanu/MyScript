package kotlinx.datetime;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.serializers.DateTimePeriodSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: DateTimePeriod.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 !2\u00020\u0001:\u0001!B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0013\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020\tH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0005X \u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000b\u0082\u0001\u0002\"#¨\u0006$"}, m1599d2 = {"Lkotlinx/datetime/DateTimePeriod;", "", "<init>", "()V", "totalMonths", "", "getTotalMonths$kotlinx_datetime", "()J", "days", "", "getDays", "()I", "totalNanoseconds", "getTotalNanoseconds$kotlinx_datetime", "years", "getYears", "months", "getMonths", "hours", "getHours", "minutes", "getMinutes", "seconds", "getSeconds", "nanoseconds", "getNanoseconds", "allNonpositive", "", "toString", "", "equals", "other", "hashCode", "Companion", "Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/DateTimePeriodImpl;", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable(with = DateTimePeriodSerializer.class)
public abstract class DateTimePeriod {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ DateTimePeriod(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getDays();

    public abstract long getTotalMonths$kotlinx_datetime();

    public abstract long getTotalNanoseconds$kotlinx_datetime();

    private DateTimePeriod() {
    }

    public final int getYears() {
        return (int) (getTotalMonths$kotlinx_datetime() / ((long) 12));
    }

    public final int getMonths() {
        return (int) (getTotalMonths$kotlinx_datetime() % ((long) 12));
    }

    public int getHours() {
        return (int) (getTotalNanoseconds$kotlinx_datetime() / DateCalculationsKt.NANOS_PER_HOUR);
    }

    public int getMinutes() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime() % DateCalculationsKt.NANOS_PER_HOUR) / DateCalculationsKt.NANOS_PER_MINUTE);
    }

    public int getSeconds() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime() % DateCalculationsKt.NANOS_PER_MINUTE) / ((long) 1000000000));
    }

    public int getNanoseconds() {
        return (int) (getTotalNanoseconds$kotlinx_datetime() % ((long) 1000000000));
    }

    private final boolean allNonpositive() {
        if (getTotalMonths$kotlinx_datetime() > 0 || getDays() > 0 || getTotalNanoseconds$kotlinx_datetime() > 0) {
            return false;
        }
        return ((getTotalMonths$kotlinx_datetime() | getTotalNanoseconds$kotlinx_datetime()) == 0 && getDays() == 0) ? false : true;
    }

    public String toString() {
        int i;
        String strValueOf;
        StringBuilder sb = new StringBuilder();
        if (allNonpositive()) {
            sb.append(Soundex.SILENT_MARKER);
            i = -1;
        } else {
            i = 1;
        }
        sb.append('P');
        if (getYears() != 0) {
            sb.append(getYears() * i).append('Y');
        }
        if (getMonths() != 0) {
            sb.append(getMonths() * i).append('M');
        }
        if (getDays() != 0) {
            sb.append(getDays() * i).append('D');
        }
        int hours = getHours();
        String str = "";
        String str2 = ExifInterface.GPS_DIRECTION_TRUE;
        if (hours != 0) {
            sb.append(ExifInterface.GPS_DIRECTION_TRUE).append(getHours() * i).append('H');
            str2 = "";
        }
        if (getMinutes() != 0) {
            sb.append(str2).append(getMinutes() * i).append('M');
        } else {
            str = str2;
        }
        if ((getSeconds() | getNanoseconds()) != 0) {
            sb.append(str);
            if (getSeconds() != 0) {
                strValueOf = Integer.valueOf(getSeconds() * i);
            } else {
                strValueOf = getNanoseconds() * i < 0 ? "-0" : "0";
            }
            sb.append(strValueOf);
            if (getNanoseconds() != 0) {
                sb.append('.').append(StringsKt.padStart(String.valueOf(Math.abs(getNanoseconds())), 9, '0'));
            }
            sb.append('S');
        }
        if (sb.length() == 1) {
            sb.append("0D");
        }
        return sb.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateTimePeriod)) {
            return false;
        }
        DateTimePeriod dateTimePeriod = (DateTimePeriod) other;
        return getTotalMonths$kotlinx_datetime() == dateTimePeriod.getTotalMonths$kotlinx_datetime() && getDays() == dateTimePeriod.getDays() && getTotalNanoseconds$kotlinx_datetime() == dateTimePeriod.getTotalNanoseconds$kotlinx_datetime();
    }

    public int hashCode() {
        return (((Long.hashCode(getTotalMonths$kotlinx_datetime()) * 31) + getDays()) * 31) + Long.hashCode(getTotalNanoseconds$kotlinx_datetime());
    }

    /* JADX INFO: compiled from: DateTimePeriod.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, m1599d2 = {"Lkotlinx/datetime/DateTimePeriod$Companion;", "", "<init>", "()V", "parse", "Lkotlinx/datetime/DateTimePeriod;", "text", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DateTimePeriod> serializer() {
            return DateTimePeriodSerializer.INSTANCE;
        }

        private static final Void parse$parseException(String str, int i) {
            throw new DateTimeFormatException("Parse error at char " + i + ": " + str);
        }

        /* JADX WARN: Removed duplicated region for block: B:199:0x0376 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0168  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01bc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DateTimePeriod parse(String text) {
            int i;
            int i2;
            char cCharAt;
            char c;
            char c2;
            int i3;
            int i4;
            long j;
            int i5;
            char cCharAt2;
            char c3;
            Intrinsics.checkNotNullParameter(text, "text");
            int i6 = 0;
            char c4 = 0;
            int i7 = 1;
            int i8 = 0;
            int i9 = 0;
            boolean z = false;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i6 < text.length()) {
                int i16 = i15;
                int i17 = i14;
                int i18 = i13;
                int i19 = i11;
                int i20 = i10;
                if (c4 == 0) {
                    int i21 = i6 + 1;
                    if (i21 >= text.length() && (text.charAt(i6) == '+' || text.charAt(i6) == '-')) {
                        parse$parseException("Unexpected end of string; 'P' designator is required", i6);
                        throw new KotlinNothingValueException();
                    }
                    char cCharAt3 = text.charAt(i6);
                    int i22 = i7;
                    if (cCharAt3 == '+' || cCharAt3 == '-') {
                        int i23 = text.charAt(i6) == '-' ? -1 : i22;
                        if (text.charAt(i21) != 'P') {
                            parse$parseException("Expected 'P', got '" + text.charAt(i21) + '\'', i21);
                            throw new KotlinNothingValueException();
                        }
                        i6 += 2;
                        i7 = i23;
                    } else {
                        if (cCharAt3 != 'P') {
                            parse$parseException("Expected '+', '-', 'P', got '" + text.charAt(i6) + '\'', i6);
                            throw new KotlinNothingValueException();
                        }
                        i6 = i21;
                        i7 = i22;
                    }
                    i10 = i20;
                    i11 = i19;
                    i13 = i18;
                    i14 = i17;
                    i15 = i16;
                    c4 = 1;
                } else {
                    int i24 = i7;
                    char cCharAt4 = text.charAt(i6);
                    char c5 = '0';
                    if (cCharAt4 == '+' || cCharAt4 == '-') {
                        i = text.charAt(i6) == '-' ? i24 * (-1) : i24;
                        i2 = i6 + 1;
                        if (i2 < text.length() && '0' <= (cCharAt = text.charAt(i2))) {
                            c = AbstractJsonLexerKt.COLON;
                            if (cCharAt >= ':') {
                            }
                            long jSafeAdd = 0;
                            while (i2 < text.length()) {
                                char cCharAt5 = text.charAt(i2);
                                if (c5 > cCharAt5 || cCharAt5 >= c) {
                                    c2 = c5;
                                    i3 = i20;
                                    i4 = i6;
                                    j = jSafeAdd;
                                    break;
                                }
                                char c6 = c5;
                                int i25 = i20;
                                int i26 = i6;
                                try {
                                    jSafeAdd = MathJvmKt.safeAdd(MathJvmKt.safeMultiply(jSafeAdd, 10L), text.charAt(i2) - '0');
                                    i2++;
                                    i20 = i25;
                                    c5 = c6;
                                    i6 = i26;
                                    c = AbstractJsonLexerKt.COLON;
                                } catch (ArithmeticException unused) {
                                    parse$parseException("The number is too large", i26);
                                    throw new KotlinNothingValueException();
                                }
                            }
                            c2 = c5;
                            i3 = i20;
                            i4 = i6;
                            j = jSafeAdd;
                            long j2 = ((long) i) * j;
                            int i27 = i;
                            if (i2 != text.length()) {
                                parse$parseException("Expected a designator after the numerical value", i2);
                                throw new KotlinNothingValueException();
                            }
                            char upperCase = Character.toUpperCase(text.charAt(i2));
                            int i28 = i8;
                            int i29 = i9;
                            if (upperCase == ',' || upperCase == '.') {
                                int i30 = i2 + 1;
                                if (i30 >= text.length()) {
                                    parse$parseException("Expected designator 'S' after " + text.charAt(i2), i30);
                                    throw new KotlinNothingValueException();
                                }
                                i2 = i30;
                                while (i2 < text.length() && (c3 = c2) <= (cCharAt2 = text.charAt(i2)) && cCharAt2 < ':') {
                                    i2++;
                                    c2 = c3;
                                }
                                int i31 = i2 - i30;
                                if (i31 > 9) {
                                    parse$parseException("Only the nanosecond fractions of a second are supported", i30);
                                    throw new KotlinNothingValueException();
                                }
                                StringBuilder sb = new StringBuilder();
                                String strSubstring = text.substring(i30, i2);
                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                int i32 = Integer.parseInt(sb.append(strSubstring).append(StringsKt.repeat("0", 9 - i31)).toString(), CharsKt.checkRadix(10)) * i27;
                                if (text.charAt(i2) != 'S') {
                                    parse$parseException("Expected the 'S' designator after a fraction", i2);
                                    throw new KotlinNothingValueException();
                                }
                                if (c4 >= '\t' || c4 < 6) {
                                    parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                    throw new KotlinNothingValueException();
                                }
                                i5 = parse$toIntThrowing(j2, i4, 'S');
                                i12 = i32;
                                c4 = '\t';
                                i10 = i3;
                                i11 = i19;
                                i13 = i18;
                                i14 = i17;
                                i8 = i28;
                                i9 = i29;
                            } else {
                                if (upperCase != 'D') {
                                    if (upperCase != 'H') {
                                        if (upperCase != 'M') {
                                            if (upperCase != 'S') {
                                                if (upperCase != 'W') {
                                                    if (upperCase != 'Y') {
                                                        parse$parseException("Expected a designator after the numerical value", i2);
                                                        throw new KotlinNothingValueException();
                                                    }
                                                    if (c4 >= 2) {
                                                        parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                        throw new KotlinNothingValueException();
                                                    }
                                                    i10 = parse$toIntThrowing(j2, i4, 'Y');
                                                    c4 = 2;
                                                    i11 = i19;
                                                    i13 = i18;
                                                    i14 = i17;
                                                    i15 = i16;
                                                    i8 = i28;
                                                } else {
                                                    if (c4 >= 4) {
                                                        parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                        throw new KotlinNothingValueException();
                                                    }
                                                    i9 = parse$toIntThrowing(j2, i4, 'W');
                                                    c4 = 4;
                                                    i10 = i3;
                                                    i11 = i19;
                                                    i13 = i18;
                                                    i14 = i17;
                                                    i15 = i16;
                                                    i8 = i28;
                                                }
                                            } else {
                                                if (c4 >= '\t' || c4 < 6) {
                                                    parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                    throw new KotlinNothingValueException();
                                                }
                                                i5 = parse$toIntThrowing(j2, i4, 'S');
                                                i10 = i3;
                                                i11 = i19;
                                                i13 = i18;
                                                i14 = i17;
                                                i8 = i28;
                                                i9 = i29;
                                                c4 = '\t';
                                            }
                                        } else if (c4 >= 6) {
                                            if (c4 >= '\b') {
                                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                throw new KotlinNothingValueException();
                                            }
                                            int i33 = parse$toIntThrowing(j2, i4, 'M');
                                            c4 = '\b';
                                            i10 = i3;
                                            i11 = i19;
                                            i13 = i18;
                                            i15 = i16;
                                            i8 = i28;
                                            i9 = i29;
                                            i14 = i33;
                                        } else {
                                            if (c4 >= 3) {
                                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                                throw new KotlinNothingValueException();
                                            }
                                            i11 = parse$toIntThrowing(j2, i4, 'M');
                                            c4 = 3;
                                            i10 = i3;
                                            i13 = i18;
                                            i14 = i17;
                                            i15 = i16;
                                            i8 = i28;
                                        }
                                    } else {
                                        if (c4 >= 7 || c4 < 6) {
                                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                            throw new KotlinNothingValueException();
                                        }
                                        int i34 = parse$toIntThrowing(j2, i4, 'H');
                                        c4 = 7;
                                        i10 = i3;
                                        i11 = i19;
                                        i14 = i17;
                                        i15 = i16;
                                        i8 = i28;
                                        i9 = i29;
                                        i13 = i34;
                                    }
                                    i6 = i2 + 1;
                                    z = true;
                                    i7 = i24;
                                } else {
                                    if (c4 >= 5) {
                                        parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i2);
                                        throw new KotlinNothingValueException();
                                    }
                                    i8 = parse$toIntThrowing(j2, i4, 'D');
                                    c4 = 5;
                                    i10 = i3;
                                    i11 = i19;
                                    i13 = i18;
                                    i14 = i17;
                                    i15 = i16;
                                }
                                i9 = i29;
                                i6 = i2 + 1;
                                z = true;
                                i7 = i24;
                            }
                            i15 = i5;
                            i6 = i2 + 1;
                            z = true;
                            i7 = i24;
                        }
                        parse$parseException("A number expected after '" + text.charAt(i2) + '\'', i2);
                        throw new KotlinNothingValueException();
                    }
                    if (('0' <= cCharAt4 && cCharAt4 < ':') || cCharAt4 != 'T') {
                        i2 = i6;
                        i = i24;
                        c = AbstractJsonLexerKt.COLON;
                        long jSafeAdd2 = 0;
                        while (i2 < text.length()) {
                        }
                        c2 = c5;
                        i3 = i20;
                        i4 = i6;
                        j = jSafeAdd2;
                        long j22 = ((long) i) * j;
                        int i272 = i;
                        if (i2 != text.length()) {
                        }
                    } else {
                        if (c4 >= 6) {
                            parse$parseException("Only one 'T' designator is allowed", i6);
                            throw new KotlinNothingValueException();
                        }
                        i6++;
                        i10 = i20;
                        i11 = i19;
                        i13 = i18;
                        i14 = i17;
                        i15 = i16;
                        i7 = i24;
                        c4 = 6;
                    }
                }
            }
            if (c4 == 0) {
                parse$parseException("Unexpected end of input; 'P' designator is required", i6);
                throw new KotlinNothingValueException();
            }
            if (c4 == 6) {
                parse$parseException("Unexpected end of input; at least one time component is required after 'T'", i6);
                throw new KotlinNothingValueException();
            }
            long j3 = ((long) i8) + ((long) (i9 * 7));
            if (SieveCacheKt.NodeMetaAndPreviousMask > j3 || j3 > SieveCacheKt.NodeLinkMask) {
                parse$parseException("The total number of days under 'D' and 'W' designators should fit into an Int", 0);
                throw new KotlinNothingValueException();
            }
            int i35 = (int) j3;
            if (!z) {
                parse$parseException("At least one component is required, but none were found", 0);
                throw new KotlinNothingValueException();
            }
            return DateTimePeriodKt.DateTimePeriod(i10, i11, i35, i13, i14, i15, i12);
        }

        private static final int parse$toIntThrowing(long j, int i, char c) {
            if (j >= SieveCacheKt.NodeMetaAndPreviousMask && j <= SieveCacheKt.NodeLinkMask) {
                return (int) j;
            }
            parse$parseException("Value " + j + " does not fit into an Int, which is required for component '" + c + '\'', i);
            throw new KotlinNothingValueException();
        }
    }
}
