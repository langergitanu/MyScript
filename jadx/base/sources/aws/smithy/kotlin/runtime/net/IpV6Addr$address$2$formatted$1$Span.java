package aws.smithy.kotlin.runtime.net;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IpV6Addr.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0010\u0010\bJ\u0011\u0010\u0012\u001a\u00020\u0011HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, m1599d2 = {"aws/smithy/kotlin/runtime/net/IpV6Addr$address$2$formatted$1$Span", "", "", TtmlNode.START, "len", "<init>", "(II)V", "component1", "()I", "component2", "copy", "(II)Laws/smithy/kotlin/runtime/net/IpV6Addr$address$2$formatted$1$Span;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getStart", "setStart", "(I)V", "getLen", "setLen", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class IpV6Addr$address$2$formatted$1$Span {
    private int len;
    private int start;

    public static /* synthetic */ IpV6Addr$address$2$formatted$1$Span copy$default(IpV6Addr$address$2$formatted$1$Span ipV6Addr$address$2$formatted$1$Span, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ipV6Addr$address$2$formatted$1$Span.start;
        }
        if ((i3 & 2) != 0) {
            i2 = ipV6Addr$address$2$formatted$1$Span.len;
        }
        return ipV6Addr$address$2$formatted$1$Span.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLen() {
        return this.len;
    }

    public final IpV6Addr$address$2$formatted$1$Span copy(int start, int len) {
        return new IpV6Addr$address$2$formatted$1$Span(start, len);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IpV6Addr$address$2$formatted$1$Span)) {
            return false;
        }
        IpV6Addr$address$2$formatted$1$Span ipV6Addr$address$2$formatted$1$Span = (IpV6Addr$address$2$formatted$1$Span) other;
        return this.start == ipV6Addr$address$2$formatted$1$Span.start && this.len == ipV6Addr$address$2$formatted$1$Span.len;
    }

    public int hashCode() {
        return (Integer.hashCode(this.start) * 31) + Integer.hashCode(this.len);
    }

    public String toString() {
        return "Span(start=" + this.start + ", len=" + this.len + ')';
    }

    public IpV6Addr$address$2$formatted$1$Span(int i, int i2) {
        this.start = i;
        this.len = i2;
    }

    public /* synthetic */ IpV6Addr$address$2$formatted$1$Span(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getLen() {
        return this.len;
    }

    public final int getStart() {
        return this.start;
    }

    public final void setLen(int i) {
        this.len = i;
    }

    public final void setStart(int i) {
        this.start = i;
    }
}
