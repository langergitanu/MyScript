package aws.smithy.kotlin.runtime.serde.xml.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TagChild.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/serialization/TagChild;", "", "<init>", "()V", "Tag", "Text", "Laws/smithy/kotlin/runtime/serde/xml/serialization/TagChild$Tag;", "Laws/smithy/kotlin/runtime/serde/xml/serialization/TagChild$Text;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class TagChild {
    public /* synthetic */ TagChild(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TagChild() {
    }

    /* JADX INFO: compiled from: TagChild.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/serialization/TagChild$Tag;", "Laws/smithy/kotlin/runtime/serde/xml/serialization/TagChild;", "lazyTagWriter", "Laws/smithy/kotlin/runtime/serde/xml/serialization/LazyTagWriter;", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/serialization/LazyTagWriter;)V", "getLazyTagWriter", "()Laws/smithy/kotlin/runtime/serde/xml/serialization/LazyTagWriter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Tag extends TagChild {
        private final LazyTagWriter lazyTagWriter;

        public static /* synthetic */ Tag copy$default(Tag tag, LazyTagWriter lazyTagWriter, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyTagWriter = tag.lazyTagWriter;
            }
            return tag.copy(lazyTagWriter);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LazyTagWriter getLazyTagWriter() {
            return this.lazyTagWriter;
        }

        public final Tag copy(LazyTagWriter lazyTagWriter) {
            Intrinsics.checkNotNullParameter(lazyTagWriter, "lazyTagWriter");
            return new Tag(lazyTagWriter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Tag) && Intrinsics.areEqual(this.lazyTagWriter, ((Tag) other).lazyTagWriter);
        }

        public int hashCode() {
            return this.lazyTagWriter.hashCode();
        }

        public String toString() {
            return "Tag(lazyTagWriter=" + this.lazyTagWriter + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tag(LazyTagWriter lazyTagWriter) {
            super(null);
            Intrinsics.checkNotNullParameter(lazyTagWriter, "lazyTagWriter");
            this.lazyTagWriter = lazyTagWriter;
        }

        public final LazyTagWriter getLazyTagWriter() {
            return this.lazyTagWriter;
        }
    }

    /* JADX INFO: compiled from: TagChild.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/serialization/TagChild$Text;", "Laws/smithy/kotlin/runtime/serde/xml/serialization/TagChild;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Text extends TagChild {
        private final String text;

        public static /* synthetic */ Text copy$default(Text text, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text.text;
            }
            return text.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Text copy(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Text(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Text) && Intrinsics.areEqual(this.text, ((Text) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Text(text=" + this.text + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public final String getText() {
            return this.text;
        }
    }
}
