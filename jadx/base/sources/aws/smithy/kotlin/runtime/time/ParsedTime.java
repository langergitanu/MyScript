package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: Parsers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u000bJ\u0011\u0010\u0018\u001a\u00020\u0017HÖ\u0081\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001e\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001f\u0010\u000b¨\u0006 "}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/ParsedTime;", "", "", "hour", "min", "sec", "ns", "offsetSec", "<init>", "(IIIII)V", "component1", "()I", "component2", "component3", "component4", "component5", "copy", "(IIIII)Laws/smithy/kotlin/runtime/time/ParsedTime;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getHour", "getMin", "getSec", "getNs", "getOffsetSec", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class ParsedTime {
    private final int hour;
    private final int min;
    private final int ns;
    private final int offsetSec;
    private final int sec;

    public static /* synthetic */ ParsedTime copy$default(ParsedTime parsedTime, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = parsedTime.hour;
        }
        if ((i6 & 2) != 0) {
            i2 = parsedTime.min;
        }
        if ((i6 & 4) != 0) {
            i3 = parsedTime.sec;
        }
        if ((i6 & 8) != 0) {
            i4 = parsedTime.ns;
        }
        if ((i6 & 16) != 0) {
            i5 = parsedTime.offsetSec;
        }
        int i7 = i5;
        int i8 = i3;
        return parsedTime.copy(i, i2, i8, i4, i7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSec() {
        return this.sec;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getNs() {
        return this.ns;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getOffsetSec() {
        return this.offsetSec;
    }

    public final ParsedTime copy(int hour, int min, int sec, int ns, int offsetSec) {
        return new ParsedTime(hour, min, sec, ns, offsetSec);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedTime)) {
            return false;
        }
        ParsedTime parsedTime = (ParsedTime) other;
        return this.hour == parsedTime.hour && this.min == parsedTime.min && this.sec == parsedTime.sec && this.ns == parsedTime.ns && this.offsetSec == parsedTime.offsetSec;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.hour) * 31) + Integer.hashCode(this.min)) * 31) + Integer.hashCode(this.sec)) * 31) + Integer.hashCode(this.ns)) * 31) + Integer.hashCode(this.offsetSec);
    }

    public String toString() {
        return "ParsedTime(hour=" + this.hour + ", min=" + this.min + ", sec=" + this.sec + ", ns=" + this.ns + ", offsetSec=" + this.offsetSec + ')';
    }

    public ParsedTime(int i, int i2, int i3, int i4, int i5) {
        this.hour = i;
        this.min = i2;
        this.sec = i3;
        this.ns = i4;
        this.offsetSec = i5;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMin() {
        return this.min;
    }

    public final int getNs() {
        return this.ns;
    }

    public final int getOffsetSec() {
        return this.offsetSec;
    }

    public final int getSec() {
        return this.sec;
    }
}
