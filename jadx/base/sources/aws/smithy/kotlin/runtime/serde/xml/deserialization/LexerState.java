package aws.smithy.kotlin.runtime.serde.xml.deserialization;

import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LexerState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState;", "", "<init>", "()V", "depth", "", "getDepth", "()I", "Initial", "BeforeRootTag", "Tag", "EndOfDocument", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$BeforeRootTag;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$EndOfDocument;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Initial;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class LexerState {
    public /* synthetic */ LexerState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getDepth();

    private LexerState() {
    }

    /* JADX INFO: compiled from: LexerState.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Initial;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState;", "<init>", "()V", "depth", "", "getDepth", "()I", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Initial extends LexerState {
        public static final Initial INSTANCE = new Initial();
        private static final int depth = 0;

        private Initial() {
            super(null);
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState
        public int getDepth() {
            return depth;
        }
    }

    /* JADX INFO: compiled from: LexerState.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$BeforeRootTag;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState;", "<init>", "()V", "depth", "", "getDepth", "()I", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class BeforeRootTag extends LexerState {
        public static final BeforeRootTag INSTANCE = new BeforeRootTag();
        private static final int depth = 0;

        private BeforeRootTag() {
            super(null);
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState
        public int getDepth() {
            return depth;
        }
    }

    /* JADX INFO: compiled from: LexerState.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\t¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState;", "<init>", "()V", "name", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "getName", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "parent", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$OpenTag;", "getParent", "()Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$OpenTag;", "OpenTag", "EmptyTag", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$EmptyTag;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static abstract class Tag extends LexerState {
        public /* synthetic */ Tag(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract XmlToken.QualifiedName getName();

        public abstract OpenTag getParent();

        private Tag() {
            super(null);
        }

        /* JADX INFO: compiled from: LexerState.kt */
        @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$OpenTag;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag;", "name", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "parent", "seenChildren", "", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$OpenTag;Z)V", "getName", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "getParent", "()Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$OpenTag;", "getSeenChildren", "()Z", "depth", "", "getDepth", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class OpenTag extends Tag {
            private final int depth;
            private final XmlToken.QualifiedName name;
            private final OpenTag parent;
            private final boolean seenChildren;

            public static /* synthetic */ OpenTag copy$default(OpenTag openTag, XmlToken.QualifiedName qualifiedName, OpenTag openTag2, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    qualifiedName = openTag.name;
                }
                if ((i & 2) != 0) {
                    openTag2 = openTag.parent;
                }
                if ((i & 4) != 0) {
                    z = openTag.seenChildren;
                }
                return openTag.copy(qualifiedName, openTag2, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final XmlToken.QualifiedName getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final OpenTag getParent() {
                return this.parent;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getSeenChildren() {
                return this.seenChildren;
            }

            public final OpenTag copy(XmlToken.QualifiedName name, OpenTag parent, boolean seenChildren) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new OpenTag(name, parent, seenChildren);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OpenTag)) {
                    return false;
                }
                OpenTag openTag = (OpenTag) other;
                return Intrinsics.areEqual(this.name, openTag.name) && Intrinsics.areEqual(this.parent, openTag.parent) && this.seenChildren == openTag.seenChildren;
            }

            public int hashCode() {
                int iHashCode = this.name.hashCode() * 31;
                OpenTag openTag = this.parent;
                return ((iHashCode + (openTag == null ? 0 : openTag.hashCode())) * 31) + Boolean.hashCode(this.seenChildren);
            }

            public String toString() {
                return "OpenTag(name=" + this.name + ", parent=" + this.parent + ", seenChildren=" + this.seenChildren + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenTag(XmlToken.QualifiedName name, OpenTag openTag, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
                this.parent = openTag;
                this.seenChildren = z;
                OpenTag parent = getParent();
                this.depth = (parent != null ? parent.getDepth() : 0) + 1;
            }

            @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState.Tag
            public XmlToken.QualifiedName getName() {
                return this.name;
            }

            @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState.Tag
            public OpenTag getParent() {
                return this.parent;
            }

            public final boolean getSeenChildren() {
                return this.seenChildren;
            }

            @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState
            public int getDepth() {
                return this.depth;
            }
        }

        /* JADX INFO: compiled from: LexerState.kt */
        @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$EmptyTag;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag;", "name", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "parent", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$OpenTag;", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$OpenTag;)V", "getName", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "getParent", "()Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$Tag$OpenTag;", "depth", "", "getDepth", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* data */ class EmptyTag extends Tag {
            private final int depth;
            private final XmlToken.QualifiedName name;
            private final OpenTag parent;

            public static /* synthetic */ EmptyTag copy$default(EmptyTag emptyTag, XmlToken.QualifiedName qualifiedName, OpenTag openTag, int i, Object obj) {
                if ((i & 1) != 0) {
                    qualifiedName = emptyTag.name;
                }
                if ((i & 2) != 0) {
                    openTag = emptyTag.parent;
                }
                return emptyTag.copy(qualifiedName, openTag);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final XmlToken.QualifiedName getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final OpenTag getParent() {
                return this.parent;
            }

            public final EmptyTag copy(XmlToken.QualifiedName name, OpenTag parent) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new EmptyTag(name, parent);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmptyTag)) {
                    return false;
                }
                EmptyTag emptyTag = (EmptyTag) other;
                return Intrinsics.areEqual(this.name, emptyTag.name) && Intrinsics.areEqual(this.parent, emptyTag.parent);
            }

            public int hashCode() {
                int iHashCode = this.name.hashCode() * 31;
                OpenTag openTag = this.parent;
                return iHashCode + (openTag == null ? 0 : openTag.hashCode());
            }

            public String toString() {
                return "EmptyTag(name=" + this.name + ", parent=" + this.parent + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmptyTag(XmlToken.QualifiedName name, OpenTag openTag) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
                this.parent = openTag;
                OpenTag parent = getParent();
                this.depth = (parent != null ? parent.getDepth() : 0) + 1;
            }

            @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState.Tag
            public XmlToken.QualifiedName getName() {
                return this.name;
            }

            @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState.Tag
            public OpenTag getParent() {
                return this.parent;
            }

            @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState
            public int getDepth() {
                return this.depth;
            }
        }
    }

    /* JADX INFO: compiled from: LexerState.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState$EndOfDocument;", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexerState;", "<init>", "()V", "depth", "", "getDepth", "()I", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EndOfDocument extends LexerState {
        public static final EndOfDocument INSTANCE = new EndOfDocument();
        private static final int depth = 0;

        private EndOfDocument() {
            super(null);
        }

        @Override // aws.smithy.kotlin.runtime.serde.xml.deserialization.LexerState
        public int getDepth() {
            return depth;
        }
    }
}
