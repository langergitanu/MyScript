package aws.sdk.kotlin.services.p010s3.model;

import androidx.compose.material3.internal.TextFieldImplKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsFilter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0082\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "", "<init>", "()V", "asAnd", "Laws/sdk/kotlin/services/s3/model/AnalyticsAndOperator;", "asAndOrNull", "asPrefix", "", "asPrefixOrNull", "asTag", "Laws/sdk/kotlin/services/s3/model/Tag;", "asTagOrNull", "And", TextFieldImplKt.PrefixId, "Tag", "SdkUnknown", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter$And;", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter$Prefix;", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter$Tag;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AnalyticsFilter {
    public /* synthetic */ AnalyticsFilter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AnalyticsFilter() {
    }

    /* JADX INFO: compiled from: AnalyticsFilter.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AnalyticsFilter$And;", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "value", "Laws/sdk/kotlin/services/s3/model/AnalyticsAndOperator;", "<init>", "(Laws/sdk/kotlin/services/s3/model/AnalyticsAndOperator;)V", "getValue", "()Laws/sdk/kotlin/services/s3/model/AnalyticsAndOperator;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class And extends AnalyticsFilter {
        private final AnalyticsAndOperator value;

        public static /* synthetic */ And copy$default(And and, AnalyticsAndOperator analyticsAndOperator, int i, Object obj) {
            if ((i & 1) != 0) {
                analyticsAndOperator = and.value;
            }
            return and.copy(analyticsAndOperator);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnalyticsAndOperator getValue() {
            return this.value;
        }

        public final And copy(AnalyticsAndOperator value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new And(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof And) && Intrinsics.areEqual(this.value, ((And) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "And(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public And(AnalyticsAndOperator value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final AnalyticsAndOperator getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: AnalyticsFilter.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AnalyticsFilter$Prefix;", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Prefix extends AnalyticsFilter {
        private final String value;

        public static /* synthetic */ Prefix copy$default(Prefix prefix, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = prefix.value;
            }
            return prefix.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Prefix copy(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Prefix(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Prefix) && Intrinsics.areEqual(this.value, ((Prefix) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Prefix(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Prefix(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: AnalyticsFilter.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AnalyticsFilter$Tag;", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "value", "Laws/sdk/kotlin/services/s3/model/Tag;", "<init>", "(Laws/sdk/kotlin/services/s3/model/Tag;)V", "getValue", "()Laws/sdk/kotlin/services/s3/model/Tag;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Tag extends AnalyticsFilter {
        private final aws.sdk.kotlin.services.p010s3.model.Tag value;

        public static /* synthetic */ Tag copy$default(Tag tag, aws.sdk.kotlin.services.p010s3.model.Tag tag2, int i, Object obj) {
            if ((i & 1) != 0) {
                tag2 = tag.value;
            }
            return tag.copy(tag2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final aws.sdk.kotlin.services.p010s3.model.Tag getValue() {
            return this.value;
        }

        public final Tag copy(aws.sdk.kotlin.services.p010s3.model.Tag value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Tag(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Tag) && Intrinsics.areEqual(this.value, ((Tag) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Tag(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tag(aws.sdk.kotlin.services.p010s3.model.Tag value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final aws.sdk.kotlin.services.p010s3.model.Tag getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: AnalyticsFilter.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AnalyticsFilter$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "<init>", "()V", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SdkUnknown extends AnalyticsFilter {
        public static final SdkUnknown INSTANCE = new SdkUnknown();

        private SdkUnknown() {
            super(null);
        }
    }

    public final AnalyticsAndOperator asAnd() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.AnalyticsFilter.And");
        return ((And) this).getValue();
    }

    public final AnalyticsAndOperator asAndOrNull() {
        And and = this instanceof And ? (And) this : null;
        if (and != null) {
            return and.getValue();
        }
        return null;
    }

    public final String asPrefix() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.AnalyticsFilter.Prefix");
        return ((Prefix) this).getValue();
    }

    public final String asPrefixOrNull() {
        Prefix prefix = this instanceof Prefix ? (Prefix) this : null;
        if (prefix != null) {
            return prefix.getValue();
        }
        return null;
    }

    public final aws.sdk.kotlin.services.p010s3.model.Tag asTag() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.AnalyticsFilter.Tag");
        return ((Tag) this).getValue();
    }

    public final aws.sdk.kotlin.services.p010s3.model.Tag asTagOrNull() {
        Tag tag = this instanceof Tag ? (Tag) this : null;
        if (tag != null) {
            return tag.getValue();
        }
        return null;
    }
}
