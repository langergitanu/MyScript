package aws.smithy.kotlin.runtime.content;

import aws.smithy.kotlin.runtime.content.Document;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Document.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\b\u001a\u001d\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t¢\u0006\u0004\b\u0003\u0010\n\u001a#\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0004\b\u0003\u0010\f¨\u0006\r"}, m1599d2 = {"", "value", "Laws/smithy/kotlin/runtime/content/Document;", "Document", "(Ljava/lang/Number;)Laws/smithy/kotlin/runtime/content/Document;", "", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/content/Document;", "", "(Z)Laws/smithy/kotlin/runtime/content/Document;", "", "(Ljava/util/List;)Laws/smithy/kotlin/runtime/content/Document;", "", "(Ljava/util/Map;)Laws/smithy/kotlin/runtime/content/Document;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DocumentKt {
    public static final Document Document(Number value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new Document.Number(value);
    }

    public static final Document Document(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new Document.String(value);
    }

    public static final Document Document(boolean z) {
        return new Document.Boolean(z);
    }

    public static final Document Document(List<? extends Document> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new Document.List(value);
    }

    public static final Document Document(Map<String, ? extends Document> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new Document.Map(value);
    }
}
