package aws.smithy.kotlin.runtime.serde.xml;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlFieldTraits.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlCollectionName;", "Laws/smithy/kotlin/runtime/serde/FieldTrait;", "element", "", "<init>", "(Ljava/lang/String;)V", "getElement", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class XmlCollectionName implements FieldTrait {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final XmlCollectionName Default = new XmlCollectionName("member");
    private final String element;

    public static /* synthetic */ XmlCollectionName copy$default(XmlCollectionName xmlCollectionName, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = xmlCollectionName.element;
        }
        return xmlCollectionName.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getElement() {
        return this.element;
    }

    public final XmlCollectionName copy(String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return new XmlCollectionName(element);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof XmlCollectionName) && Intrinsics.areEqual(this.element, ((XmlCollectionName) other).element);
    }

    public int hashCode() {
        return this.element.hashCode();
    }

    public String toString() {
        return "XmlCollectionName(element=" + this.element + ')';
    }

    public XmlCollectionName(String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.element = element;
    }

    public final String getElement() {
        return this.element;
    }

    /* JADX INFO: compiled from: XmlFieldTraits.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlCollectionName$Companion;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/serde/xml/XmlCollectionName;", "getDefault", "()Laws/smithy/kotlin/runtime/serde/xml/XmlCollectionName;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final XmlCollectionName getDefault() {
            return XmlCollectionName.Default;
        }
    }
}
