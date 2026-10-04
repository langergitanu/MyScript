package aws.smithy.kotlin.runtime.serde.xml;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.common.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: XmlToken.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "", "<init>", "()V", "depth", "", "getDepth", "()I", "toString", "", "Namespace", "QualifiedName", "BeginElement", "EndElement", "Text", "StartDocument", "EndDocument", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$BeginElement;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$EndDocument;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$EndElement;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$StartDocument;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$Text;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class XmlToken {
    public /* synthetic */ XmlToken(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getDepth();

    private XmlToken() {
    }

    /* JADX INFO: compiled from: XmlToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken$Namespace;", "", "uri", "", "prefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "getPrefix", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Namespace {
        private final String prefix;
        private final String uri;

        public static /* synthetic */ Namespace copy$default(Namespace namespace, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = namespace.uri;
            }
            if ((i & 2) != 0) {
                str2 = namespace.prefix;
            }
            return namespace.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPrefix() {
            return this.prefix;
        }

        public final Namespace copy(String uri, String prefix) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new Namespace(uri, prefix);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Namespace)) {
                return false;
            }
            Namespace namespace = (Namespace) other;
            return Intrinsics.areEqual(this.uri, namespace.uri) && Intrinsics.areEqual(this.prefix, namespace.prefix);
        }

        public int hashCode() {
            int iHashCode = this.uri.hashCode() * 31;
            String str = this.prefix;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Namespace(uri=" + this.uri + ", prefix=" + this.prefix + ')';
        }

        public Namespace(String uri, String str) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.prefix = str;
        }

        public /* synthetic */ Namespace(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getUri() {
            return this.uri;
        }
    }

    /* JADX INFO: compiled from: XmlToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\n\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "", ImagesContract.LOCAL, "", "prefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLocal", "()Ljava/lang/String;", "getPrefix", "toString", "tag", "getTag", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "Companion", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class QualifiedName {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String local;
        private final String prefix;

        public static /* synthetic */ QualifiedName copy$default(QualifiedName qualifiedName, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = qualifiedName.local;
            }
            if ((i & 2) != 0) {
                str2 = qualifiedName.prefix;
            }
            return qualifiedName.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocal() {
            return this.local;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPrefix() {
            return this.prefix;
        }

        public final QualifiedName copy(String local, String prefix) {
            Intrinsics.checkNotNullParameter(local, "local");
            return new QualifiedName(local, prefix);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QualifiedName)) {
                return false;
            }
            QualifiedName qualifiedName = (QualifiedName) other;
            return Intrinsics.areEqual(this.local, qualifiedName.local) && Intrinsics.areEqual(this.prefix, qualifiedName.prefix);
        }

        public int hashCode() {
            int iHashCode = this.local.hashCode() * 31;
            String str = this.prefix;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public QualifiedName(String local, String str) {
            Intrinsics.checkNotNullParameter(local, "local");
            this.local = local;
            this.prefix = str;
        }

        public /* synthetic */ QualifiedName(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        public final String getLocal() {
            return this.local;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public String toString() {
            if (this.prefix == null) {
                return this.local;
            }
            return this.prefix + AbstractJsonLexerKt.COLON + this.local;
        }

        /* JADX INFO: compiled from: XmlToken.kt */
        @InternalApi
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName$Companion;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "qualified", "", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final QualifiedName from(String qualified) {
                Pair pairM1606to;
                Intrinsics.checkNotNullParameter(qualified, "qualified");
                List listSplit$default = StringsKt.split$default((CharSequence) qualified, new String[]{Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR}, false, 2, 2, (Object) null);
                boolean z = listSplit$default.size() == 2;
                if (z) {
                    pairM1606to = TuplesKt.m1606to(listSplit$default.get(1), listSplit$default.get(0));
                } else {
                    if (z) {
                        throw new NoWhenBranchMatchedException();
                    }
                    pairM1606to = TuplesKt.m1606to(listSplit$default.get(0), null);
                }
                return new QualifiedName((String) pairM1606to.component1(), (String) pairM1606to.component2());
            }
        }

        public final String getTag() {
            return toString();
        }
    }

    /* JADX INFO: compiled from: XmlToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u000eB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\f\u0010\u000fJ\n\u0010\u0018\u001a\u00020\bH\u0096\u0080\u0004J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JC\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken$BeginElement;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "depth", "", "name", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "attributes", "", "", "nsDeclarations", "", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$Namespace;", "<init>", "(ILaws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;Ljava/util/Map;Ljava/util/List;)V", "(ILjava/lang/String;)V", "(ILjava/lang/String;Ljava/util/Map;)V", "getDepth", "()I", "getName", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "getAttributes", "()Ljava/util/Map;", "getNsDeclarations", "()Ljava/util/List;", "toString", "getAttr", "qualified", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class BeginElement extends XmlToken {
        private final Map<QualifiedName, String> attributes;
        private final int depth;
        private final QualifiedName name;
        private final List<Namespace> nsDeclarations;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BeginElement copy$default(BeginElement beginElement, int i, QualifiedName qualifiedName, Map map, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = beginElement.depth;
            }
            if ((i2 & 2) != 0) {
                qualifiedName = beginElement.name;
            }
            if ((i2 & 4) != 0) {
                map = beginElement.attributes;
            }
            if ((i2 & 8) != 0) {
                list = beginElement.nsDeclarations;
            }
            return beginElement.copy(i, qualifiedName, map, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDepth() {
            return this.depth;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final QualifiedName getName() {
            return this.name;
        }

        public final Map<QualifiedName, String> component3() {
            return this.attributes;
        }

        public final List<Namespace> component4() {
            return this.nsDeclarations;
        }

        public final BeginElement copy(int depth, QualifiedName name, Map<QualifiedName, String> attributes, List<Namespace> nsDeclarations) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(nsDeclarations, "nsDeclarations");
            return new BeginElement(depth, name, attributes, nsDeclarations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BeginElement)) {
                return false;
            }
            BeginElement beginElement = (BeginElement) other;
            return this.depth == beginElement.depth && Intrinsics.areEqual(this.name, beginElement.name) && Intrinsics.areEqual(this.attributes, beginElement.attributes) && Intrinsics.areEqual(this.nsDeclarations, beginElement.nsDeclarations);
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.depth) * 31) + this.name.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.nsDeclarations.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BeginElement(int i, QualifiedName name, Map<QualifiedName, String> attributes, List<Namespace> nsDeclarations) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(nsDeclarations, "nsDeclarations");
            this.depth = i;
            this.name = name;
            this.attributes = attributes;
            this.nsDeclarations = nsDeclarations;
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.XmlToken
        public int getDepth() {
            return this.depth;
        }

        public final QualifiedName getName() {
            return this.name;
        }

        public /* synthetic */ BeginElement(int i, QualifiedName qualifiedName, Map map, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, qualifiedName, (i2 & 4) != 0 ? MapsKt.emptyMap() : map, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final Map<QualifiedName, String> getAttributes() {
            return this.attributes;
        }

        public final List<Namespace> getNsDeclarations() {
            return this.nsDeclarations;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BeginElement(int i, String name) {
            this(i, new QualifiedName(name, null, 2, 0 == true ? 1 : 0), null, null, 12, null);
            Intrinsics.checkNotNullParameter(name, "name");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BeginElement(int i, String name, Map<QualifiedName, String> attributes) {
            this(i, new QualifiedName(name, null, 2, 0 == true ? 1 : 0), attributes, null, 8, null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.XmlToken
        public String toString() {
            return "<" + this.name + " (" + getDepth() + ")>";
        }

        public final String getAttr(String qualified) {
            Intrinsics.checkNotNullParameter(qualified, "qualified");
            return this.attributes.get(QualifiedName.INSTANCE.from(qualified));
        }
    }

    /* JADX INFO: compiled from: XmlToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\tJ\n\u0010\u000e\u001a\u00020\bH\u0096\u0080\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken$EndElement;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "depth", "", "name", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "<init>", "(ILaws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;)V", "", "(ILjava/lang/String;)V", "getDepth", "()I", "getName", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class EndElement extends XmlToken {
        private final int depth;
        private final QualifiedName name;

        public static /* synthetic */ EndElement copy$default(EndElement endElement, int i, QualifiedName qualifiedName, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = endElement.depth;
            }
            if ((i2 & 2) != 0) {
                qualifiedName = endElement.name;
            }
            return endElement.copy(i, qualifiedName);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDepth() {
            return this.depth;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final QualifiedName getName() {
            return this.name;
        }

        public final EndElement copy(int depth, QualifiedName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new EndElement(depth, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EndElement)) {
                return false;
            }
            EndElement endElement = (EndElement) other;
            return this.depth == endElement.depth && Intrinsics.areEqual(this.name, endElement.name);
        }

        public int hashCode() {
            return (Integer.hashCode(this.depth) * 31) + this.name.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EndElement(int i, QualifiedName name) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.depth = i;
            this.name = name;
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.XmlToken
        public int getDepth() {
            return this.depth;
        }

        public final QualifiedName getName() {
            return this.name;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public EndElement(int i, String name) {
            this(i, new QualifiedName(name, null, 2, 0 == true ? 1 : 0));
            Intrinsics.checkNotNullParameter(name, "name");
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.XmlToken
        public String toString() {
            return "</" + this.name + "> (" + getDepth() + ')';
        }
    }

    /* JADX INFO: compiled from: XmlToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\u0005H\u0096\u0080\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken$Text;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "depth", "", "value", "", "<init>", "(ILjava/lang/String;)V", "getDepth", "()I", "getValue", "()Ljava/lang/String;", "toString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Text extends XmlToken {
        private final int depth;
        private final String value;

        public static /* synthetic */ Text copy$default(Text text, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = text.depth;
            }
            if ((i2 & 2) != 0) {
                str = text.value;
            }
            return text.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDepth() {
            return this.depth;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Text copy(int depth, String value) {
            return new Text(depth, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Text)) {
                return false;
            }
            Text text = (Text) other;
            return this.depth == text.depth && Intrinsics.areEqual(this.value, text.value);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.depth) * 31;
            String str = this.value;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public Text(int i, String str) {
            super(null);
            this.depth = i;
            this.value = str;
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.XmlToken
        public int getDepth() {
            return this.depth;
        }

        public final String getValue() {
            return this.value;
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.XmlToken
        public String toString() {
            return this.value + " (" + getDepth() + ')';
        }
    }

    /* JADX INFO: compiled from: XmlToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken$StartDocument;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "<init>", "()V", "depth", "", "getDepth", "()I", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class StartDocument extends XmlToken {
        public static final StartDocument INSTANCE = new StartDocument();
        private static final int depth = 0;

        private StartDocument() {
            super(null);
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.XmlToken
        public int getDepth() {
            return depth;
        }
    }

    /* JADX INFO: compiled from: XmlToken.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlToken$EndDocument;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "<init>", "()V", "depth", "", "getDepth", "()I", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EndDocument extends XmlToken {
        public static final EndDocument INSTANCE = new EndDocument();

        @Override // aws.smithy.kotlin.runtime.serde.xml.XmlToken
        public int getDepth() {
            return 0;
        }

        private EndDocument() {
            super(null);
        }
    }

    public String toString() {
        if (this instanceof BeginElement) {
            return "<" + ((BeginElement) this).getName() + Typography.greater;
        }
        if (this instanceof EndElement) {
            return "</" + ((EndElement) this).getName() + Typography.greater;
        }
        if (this instanceof Text) {
            return String.valueOf(((Text) this).getValue());
        }
        if (Intrinsics.areEqual(this, StartDocument.INSTANCE)) {
            return "[StartDocument]";
        }
        if (Intrinsics.areEqual(this, EndDocument.INSTANCE)) {
            return "[EndDocument]";
        }
        throw new NoWhenBranchMatchedException();
    }
}
