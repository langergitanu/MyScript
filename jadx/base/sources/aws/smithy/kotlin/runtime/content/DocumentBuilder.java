package aws.smithy.kotlin.runtime.content;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086\u0004¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0086\u0004¢\u0006\u0004\b\b\u0010\nJ\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH\u0086\u0004¢\u0006\u0004\b\b\u0010\fJ\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0086\u0004¢\u0006\u0004\b\b\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0086\u0004¢\u0006\u0004\b\b\u0010\u0010J&\u0010\u0015\u001a\u00020\r2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0013¢\u0006\u0004\b\u0015\u0010\u0016R%\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/DocumentBuilder;", "", "<init>", "()V", "", "", "value", "", TypedValues.TransitionType.S_TO, "(Ljava/lang/String;Ljava/lang/Number;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "Laws/smithy/kotlin/runtime/content/Document;", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/content/Document;)V", "", "(Ljava/lang/String;Ljava/lang/Void;)V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/content/DocumentBuilder$ListBuilder;", "Lkotlin/ExtensionFunctionType;", "init", "buildList", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/content/Document;", "", FirebaseAnalytics.Param.CONTENT, "Ljava/util/Map;", "getContent", "()Ljava/util/Map;", "ListBuilder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DocumentBuilder {
    private final Map<String, Document> content = new LinkedHashMap();

    public final Map<String, Document> getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: to */
    public final void m501to(String str, Number number) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (this.content.containsKey(str)) {
            throw new IllegalArgumentException(("Key " + str + " is already registered in builder").toString());
        }
        this.content.put(str, number != null ? DocumentKt.Document(number) : null);
    }

    /* JADX INFO: renamed from: to */
    public final void m502to(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (this.content.containsKey(str)) {
            throw new IllegalArgumentException(("Key " + str + " is already registered in builder").toString());
        }
        this.content.put(str, str2 != null ? DocumentKt.Document(str2) : null);
    }

    /* JADX INFO: renamed from: to */
    public final void m500to(String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (this.content.containsKey(str)) {
            throw new IllegalArgumentException(("Key " + str + " is already registered in builder").toString());
        }
        this.content.put(str, bool != null ? DocumentKt.Document(bool.booleanValue()) : null);
    }

    /* JADX INFO: renamed from: to */
    public final void m499to(String str, Document document) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (this.content.containsKey(str)) {
            throw new IllegalArgumentException(("Key " + str + " is already registered in builder").toString());
        }
        this.content.put(str, document);
    }

    /* JADX INFO: renamed from: to */
    public final void m503to(String str, Void r3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (this.content.containsKey(str)) {
            throw new IllegalArgumentException(("Key " + str + " is already registered in builder").toString());
        }
        this.content.put(str, null);
    }

    /* JADX INFO: compiled from: DocumentBuilder.kt */
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0007\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010H\u0007¢\u0006\u0004\b\u0016\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0010H\u0007¢\u0006\u0004\b\u0017\u0010\u0013R\u001f\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/DocumentBuilder$ListBuilder;", "", "<init>", "()V", "", "value", "", "add", "(Ljava/lang/Number;)Z", "", "(Ljava/lang/String;)Z", "(Ljava/lang/Boolean;)Z", "Laws/smithy/kotlin/runtime/content/Document;", "(Laws/smithy/kotlin/runtime/content/Document;)Z", "", "(Ljava/lang/Void;)Z", "", "", "addAllNumbers", "(Ljava/util/List;)V", "addAll", "addAllStrings", "addAllBooleans", "addAllDocuments", "", FirebaseAnalytics.Param.CONTENT, "Ljava/util/List;", "getContent", "()Ljava/util/List;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ListBuilder {
        private final List<Document> content = new ArrayList();

        public final List<Document> getContent() {
            return this.content;
        }

        public final boolean add(Number value) {
            return this.content.add(value != null ? DocumentKt.Document(value) : null);
        }

        public final boolean add(String value) {
            return this.content.add(value != null ? DocumentKt.Document(value) : null);
        }

        public final boolean add(Boolean value) {
            return this.content.add(value != null ? DocumentKt.Document(value.booleanValue()) : null);
        }

        public final boolean add(Document value) {
            return this.content.add(value);
        }

        public final boolean add(Void value) {
            return this.content.add(null);
        }

        public final void addAllNumbers(List<? extends Number> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                add((Number) it.next());
            }
        }

        public final void addAllStrings(List<String> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                add((String) it.next());
            }
        }

        public final void addAllBooleans(List<Boolean> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                add((Boolean) it.next());
            }
        }

        public final void addAllDocuments(List<? extends Document> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                add((Document) it.next());
            }
        }
    }

    public final Document buildList(Function1<? super ListBuilder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        ListBuilder listBuilder = new ListBuilder();
        init.invoke(listBuilder);
        return DocumentKt.Document(listBuilder.getContent());
    }
}
