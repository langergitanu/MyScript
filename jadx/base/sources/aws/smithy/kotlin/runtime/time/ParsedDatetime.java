package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Parsers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJ`\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u000eJ\u0011\u0010\u001e\u001a\u00020\u001dHÖ\u0081\u0004¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b#\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b$\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b%\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b&\u0010\u000eR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b'\u0010\u000eR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b(\u0010\u000e¨\u0006)"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/ParsedDatetime;", "", "", "year", "month", "day", "hour", "min", "sec", "ns", "offsetSec", "<init>", "(IIIIIIII)V", "component1", "()I", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IIIIIIII)Laws/smithy/kotlin/runtime/time/ParsedDatetime;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getYear", "getMonth", "getDay", "getHour", "getMin", "getSec", "getNs", "getOffsetSec", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ParsedDatetime {
    private final int day;
    private final int hour;
    private final int min;
    private final int month;
    private final int ns;
    private final int offsetSec;
    private final int sec;
    private final int year;

    public static /* synthetic */ ParsedDatetime copy$default(ParsedDatetime parsedDatetime, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i = parsedDatetime.year;
        }
        if ((i9 & 2) != 0) {
            i2 = parsedDatetime.month;
        }
        if ((i9 & 4) != 0) {
            i3 = parsedDatetime.day;
        }
        if ((i9 & 8) != 0) {
            i4 = parsedDatetime.hour;
        }
        if ((i9 & 16) != 0) {
            i5 = parsedDatetime.min;
        }
        if ((i9 & 32) != 0) {
            i6 = parsedDatetime.sec;
        }
        if ((i9 & 64) != 0) {
            i7 = parsedDatetime.ns;
        }
        if ((i9 & 128) != 0) {
            i8 = parsedDatetime.offsetSec;
        }
        int i10 = i7;
        int i11 = i8;
        int i12 = i5;
        int i13 = i6;
        return parsedDatetime.copy(i, i2, i3, i4, i12, i13, i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSec() {
        return this.sec;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getNs() {
        return this.ns;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getOffsetSec() {
        return this.offsetSec;
    }

    public final ParsedDatetime copy(int year, int month, int day, int hour, int min, int sec, int ns, int offsetSec) {
        return new ParsedDatetime(year, month, day, hour, min, sec, ns, offsetSec);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedDatetime)) {
            return false;
        }
        ParsedDatetime parsedDatetime = (ParsedDatetime) other;
        return this.year == parsedDatetime.year && this.month == parsedDatetime.month && this.day == parsedDatetime.day && this.hour == parsedDatetime.hour && this.min == parsedDatetime.min && this.sec == parsedDatetime.sec && this.ns == parsedDatetime.ns && this.offsetSec == parsedDatetime.offsetSec;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.year) * 31) + Integer.hashCode(this.month)) * 31) + Integer.hashCode(this.day)) * 31) + Integer.hashCode(this.hour)) * 31) + Integer.hashCode(this.min)) * 31) + Integer.hashCode(this.sec)) * 31) + Integer.hashCode(this.ns)) * 31) + Integer.hashCode(this.offsetSec);
    }

    public String toString() {
        return "ParsedDatetime(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", hour=" + this.hour + ", min=" + this.min + ", sec=" + this.sec + ", ns=" + this.ns + ", offsetSec=" + this.offsetSec + ')';
    }

    public ParsedDatetime(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.hour = i4;
        this.min = i5;
        this.sec = i6;
        this.ns = i7;
        this.offsetSec = i8;
    }

    public /* synthetic */ ParsedDatetime(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, i6, i7, (i9 & 128) != 0 ? 0 : i8);
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMin() {
        return this.min;
    }

    public final int getSec() {
        return this.sec;
    }

    public final int getNs() {
        return this.ns;
    }

    public final int getOffsetSec() {
        return this.offsetSec;
    }
}
