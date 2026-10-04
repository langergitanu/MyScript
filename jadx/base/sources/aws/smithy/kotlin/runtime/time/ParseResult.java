package aws.smithy.kotlin.runtime.time;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParserCombinators.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\tJ\u0011\u0010\u0014\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/ParseResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "pos", "result", "<init>", "(ILjava/lang/Object;)V", "component1", "()I", "component2", "()Ljava/lang/Object;", "copy", "(ILjava/lang/Object;)Laws/smithy/kotlin/runtime/time/ParseResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPos", "Ljava/lang/Object;", "getResult", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ParseResult<T> {
    private final int pos;
    private final T result;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParseResult copy$default(ParseResult parseResult, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = parseResult.pos;
        }
        if ((i2 & 2) != 0) {
            obj = parseResult.result;
        }
        return parseResult.copy(i, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPos() {
        return this.pos;
    }

    public final T component2() {
        return this.result;
    }

    public final ParseResult<T> copy(int pos, T result) {
        return new ParseResult<>(pos, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParseResult)) {
            return false;
        }
        ParseResult parseResult = (ParseResult) other;
        return this.pos == parseResult.pos && Intrinsics.areEqual(this.result, parseResult.result);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.pos) * 31;
        T t = this.result;
        return iHashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "ParseResult(pos=" + this.pos + ", result=" + this.result + ')';
    }

    public ParseResult(int i, T t) {
        this.pos = i;
        this.result = t;
    }

    public final int getPos() {
        return this.pos;
    }

    public final T getResult() {
        return this.result;
    }
}
