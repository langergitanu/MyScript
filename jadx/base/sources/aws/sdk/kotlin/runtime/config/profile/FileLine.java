package aws.sdk.kotlin.runtime.config.profile;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileLine.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/profile/FileLine;", "", "lineNumber", "", FirebaseAnalytics.Param.CONTENT, "", "<init>", "(ILjava/lang/String;)V", "getLineNumber", "()I", "getContent", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FileLine {
    private final String content;
    private final int lineNumber;

    public static /* synthetic */ FileLine copy$default(FileLine fileLine, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = fileLine.lineNumber;
        }
        if ((i2 & 2) != 0) {
            str = fileLine.content;
        }
        return fileLine.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLineNumber() {
        return this.lineNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final FileLine copy(int lineNumber, String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new FileLine(lineNumber, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileLine)) {
            return false;
        }
        FileLine fileLine = (FileLine) other;
        return this.lineNumber == fileLine.lineNumber && Intrinsics.areEqual(this.content, fileLine.content);
    }

    public int hashCode() {
        return (Integer.hashCode(this.lineNumber) * 31) + this.content.hashCode();
    }

    public String toString() {
        return "FileLine(lineNumber=" + this.lineNumber + ", content=" + this.content + ')';
    }

    public FileLine(int i, String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.lineNumber = i;
        this.content = content;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }
}
