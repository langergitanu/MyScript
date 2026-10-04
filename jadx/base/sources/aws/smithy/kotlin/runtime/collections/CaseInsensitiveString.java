package aws.smithy.kotlin.runtime.collections;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaseInsensitiveString.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/CaseInsensitiveString;", "", "", "original", "<init>", "(Ljava/lang/String;)V", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getOriginal", "normalized", "getNormalized", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CaseInsensitiveString {
    private final String normalized;
    private final String original;

    public CaseInsensitiveString(String original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
        String lowerCase = original.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.normalized = lowerCase;
    }

    public final String getOriginal() {
        return this.original;
    }

    public final String getNormalized() {
        return this.normalized;
    }

    public int hashCode() {
        return this.normalized.hashCode();
    }

    public boolean equals(Object other) {
        return (other instanceof CaseInsensitiveString) && Intrinsics.areEqual(this.normalized, ((CaseInsensitiveString) other).normalized);
    }

    public String toString() {
        return this.original;
    }
}
