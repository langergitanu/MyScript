package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.NotificationConfigurationFilter;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: TopicConfiguration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002 !B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0015\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001b\u001a\u00020\u00002\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fH\u0086\bø\u0001\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/TopicConfiguration;", "", "builder", "Laws/sdk/kotlin/services/s3/model/TopicConfiguration$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/TopicConfiguration$Builder;)V", "events", "", "Laws/sdk/kotlin/services/s3/model/Event;", "getEvents", "()Ljava/util/List;", "filter", "Laws/sdk/kotlin/services/s3/model/NotificationConfigurationFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/NotificationConfigurationFilter;", "id", "", "getId", "()Ljava/lang/String;", "topicArn", "getTopicArn", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TopicConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Event> events;
    private final NotificationConfigurationFilter filter;
    private final String id;
    private final String topicArn;

    public /* synthetic */ TopicConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private TopicConfiguration(Builder builder) {
        List<Event> events = builder.getEvents();
        if (events == null) {
            throw new IllegalArgumentException("A non-null value must be provided for events".toString());
        }
        this.events = events;
        this.filter = builder.getFilter();
        this.id = builder.getId();
        String topicArn = builder.getTopicArn();
        if (topicArn == null) {
            throw new IllegalArgumentException("A non-null value must be provided for topicArn".toString());
        }
        this.topicArn = topicArn;
    }

    public final List<Event> getEvents() {
        return this.events;
    }

    public final NotificationConfigurationFilter getFilter() {
        return this.filter;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTopicArn() {
        return this.topicArn;
    }

    /* JADX INFO: compiled from: TopicConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/TopicConfiguration$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/TopicConfiguration;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/TopicConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TopicConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TopicConfiguration(");
        sb.append("events=" + this.events + AbstractJsonLexerKt.COMMA);
        sb.append("filter=" + this.filter + AbstractJsonLexerKt.COMMA);
        sb.append("id=" + this.id + AbstractJsonLexerKt.COMMA);
        sb.append("topicArn=" + this.topicArn);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        int iHashCode = this.events.hashCode() * 31;
        NotificationConfigurationFilter notificationConfigurationFilter = this.filter;
        int iHashCode2 = (iHashCode + (notificationConfigurationFilter != null ? notificationConfigurationFilter.hashCode() : 0)) * 31;
        String str = this.id;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.topicArn.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        TopicConfiguration topicConfiguration = (TopicConfiguration) other;
        return Intrinsics.areEqual(this.events, topicConfiguration.events) && Intrinsics.areEqual(this.filter, topicConfiguration.filter) && Intrinsics.areEqual(this.id, topicConfiguration.id) && Intrinsics.areEqual(this.topicArn, topicConfiguration.topicArn);
    }

    public static /* synthetic */ TopicConfiguration copy$default(TopicConfiguration topicConfiguration, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.TopicConfiguration.copy.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(topicConfiguration);
        block.invoke(builder);
        return builder.build();
    }

    public final TopicConfiguration copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: TopicConfiguration.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0005H\u0001J\u001f\u0010\u000e\u001a\u00020\u001e2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001e0 ¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u0000H\u0000¢\u0006\u0002\b$R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/TopicConfiguration$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/TopicConfiguration;", "(Laws/sdk/kotlin/services/s3/model/TopicConfiguration;)V", "events", "", "Laws/sdk/kotlin/services/s3/model/Event;", "getEvents", "()Ljava/util/List;", "setEvents", "(Ljava/util/List;)V", "filter", "Laws/sdk/kotlin/services/s3/model/NotificationConfigurationFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/NotificationConfigurationFilter;", "setFilter", "(Laws/sdk/kotlin/services/s3/model/NotificationConfigurationFilter;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "topicArn", "getTopicArn", "setTopicArn", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/NotificationConfigurationFilter$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<? extends Event> events;
        private NotificationConfigurationFilter filter;
        private String id;
        private String topicArn;

        public final List<Event> getEvents() {
            return this.events;
        }

        public final void setEvents(List<? extends Event> list) {
            this.events = list;
        }

        public final NotificationConfigurationFilter getFilter() {
            return this.filter;
        }

        public final void setFilter(NotificationConfigurationFilter notificationConfigurationFilter) {
            this.filter = notificationConfigurationFilter;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final String getTopicArn() {
            return this.topicArn;
        }

        public final void setTopicArn(String str) {
            this.topicArn = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(TopicConfiguration x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.events = x.getEvents();
            this.filter = x.getFilter();
            this.id = x.getId();
            this.topicArn = x.getTopicArn();
        }

        public final TopicConfiguration build() {
            return new TopicConfiguration(this, null);
        }

        public final void filter(Function1<? super NotificationConfigurationFilter.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.filter = TopicConfigurationKt.f510x3814a43f.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.events == null) {
                this.events = CollectionsKt.emptyList();
            }
            if (this.topicArn == null) {
                this.topicArn = "";
            }
            return this;
        }
    }
}
