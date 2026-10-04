package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.EventBridgeConfiguration;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GetBucketNotificationConfigurationResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001c\u001a\u00020\u00002\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse$Builder;)V", "eventBridgeConfiguration", "Laws/sdk/kotlin/services/s3/model/EventBridgeConfiguration;", "getEventBridgeConfiguration", "()Laws/sdk/kotlin/services/s3/model/EventBridgeConfiguration;", "lambdaFunctionConfigurations", "", "Laws/sdk/kotlin/services/s3/model/LambdaFunctionConfiguration;", "getLambdaFunctionConfigurations", "()Ljava/util/List;", "queueConfigurations", "Laws/sdk/kotlin/services/s3/model/QueueConfiguration;", "getQueueConfigurations", "topicConfigurations", "Laws/sdk/kotlin/services/s3/model/TopicConfiguration;", "getTopicConfigurations", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetBucketNotificationConfigurationResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final EventBridgeConfiguration eventBridgeConfiguration;
    private final List<LambdaFunctionConfiguration> lambdaFunctionConfigurations;
    private final List<QueueConfiguration> queueConfigurations;
    private final List<TopicConfiguration> topicConfigurations;

    public /* synthetic */ GetBucketNotificationConfigurationResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GetBucketNotificationConfigurationResponse(Builder builder) {
        this.eventBridgeConfiguration = builder.getEventBridgeConfiguration();
        this.lambdaFunctionConfigurations = builder.getLambdaFunctionConfigurations();
        this.queueConfigurations = builder.getQueueConfigurations();
        this.topicConfigurations = builder.getTopicConfigurations();
    }

    public final EventBridgeConfiguration getEventBridgeConfiguration() {
        return this.eventBridgeConfiguration;
    }

    public final List<LambdaFunctionConfiguration> getLambdaFunctionConfigurations() {
        return this.lambdaFunctionConfigurations;
    }

    public final List<QueueConfiguration> getQueueConfigurations() {
        return this.queueConfigurations;
    }

    public final List<TopicConfiguration> getTopicConfigurations() {
        return this.topicConfigurations;
    }

    /* JADX INFO: compiled from: GetBucketNotificationConfigurationResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GetBucketNotificationConfigurationResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketNotificationConfigurationResponse(");
        sb.append("eventBridgeConfiguration=" + this.eventBridgeConfiguration + AbstractJsonLexerKt.COMMA);
        sb.append("lambdaFunctionConfigurations=" + this.lambdaFunctionConfigurations + AbstractJsonLexerKt.COMMA);
        sb.append("queueConfigurations=" + this.queueConfigurations + AbstractJsonLexerKt.COMMA);
        sb.append("topicConfigurations=" + this.topicConfigurations);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        EventBridgeConfiguration eventBridgeConfiguration = this.eventBridgeConfiguration;
        int iHashCode = (eventBridgeConfiguration != null ? eventBridgeConfiguration.hashCode() : 0) * 31;
        List<LambdaFunctionConfiguration> list = this.lambdaFunctionConfigurations;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<QueueConfiguration> list2 = this.queueConfigurations;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<TopicConfiguration> list3 = this.topicConfigurations;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GetBucketNotificationConfigurationResponse getBucketNotificationConfigurationResponse = (GetBucketNotificationConfigurationResponse) other;
        return Intrinsics.areEqual(this.eventBridgeConfiguration, getBucketNotificationConfigurationResponse.eventBridgeConfiguration) && Intrinsics.areEqual(this.lambdaFunctionConfigurations, getBucketNotificationConfigurationResponse.lambdaFunctionConfigurations) && Intrinsics.areEqual(this.queueConfigurations, getBucketNotificationConfigurationResponse.queueConfigurations) && Intrinsics.areEqual(this.topicConfigurations, getBucketNotificationConfigurationResponse.topicConfigurations);
    }

    public static /* synthetic */ GetBucketNotificationConfigurationResponse copy$default(GetBucketNotificationConfigurationResponse getBucketNotificationConfigurationResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.GetBucketNotificationConfigurationResponse.copy.1
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
        Builder builder = new Builder(getBucketNotificationConfigurationResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final GetBucketNotificationConfigurationResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: GetBucketNotificationConfigurationResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020\u0000H\u0000¢\u0006\u0002\b#R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006$"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse;", "(Laws/sdk/kotlin/services/s3/model/GetBucketNotificationConfigurationResponse;)V", "eventBridgeConfiguration", "Laws/sdk/kotlin/services/s3/model/EventBridgeConfiguration;", "getEventBridgeConfiguration", "()Laws/sdk/kotlin/services/s3/model/EventBridgeConfiguration;", "setEventBridgeConfiguration", "(Laws/sdk/kotlin/services/s3/model/EventBridgeConfiguration;)V", "lambdaFunctionConfigurations", "", "Laws/sdk/kotlin/services/s3/model/LambdaFunctionConfiguration;", "getLambdaFunctionConfigurations", "()Ljava/util/List;", "setLambdaFunctionConfigurations", "(Ljava/util/List;)V", "queueConfigurations", "Laws/sdk/kotlin/services/s3/model/QueueConfiguration;", "getQueueConfigurations", "setQueueConfigurations", "topicConfigurations", "Laws/sdk/kotlin/services/s3/model/TopicConfiguration;", "getTopicConfigurations", "setTopicConfigurations", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/EventBridgeConfiguration$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private EventBridgeConfiguration eventBridgeConfiguration;
        private List<LambdaFunctionConfiguration> lambdaFunctionConfigurations;
        private List<QueueConfiguration> queueConfigurations;
        private List<TopicConfiguration> topicConfigurations;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final EventBridgeConfiguration getEventBridgeConfiguration() {
            return this.eventBridgeConfiguration;
        }

        public final void setEventBridgeConfiguration(EventBridgeConfiguration eventBridgeConfiguration) {
            this.eventBridgeConfiguration = eventBridgeConfiguration;
        }

        public final List<LambdaFunctionConfiguration> getLambdaFunctionConfigurations() {
            return this.lambdaFunctionConfigurations;
        }

        public final void setLambdaFunctionConfigurations(List<LambdaFunctionConfiguration> list) {
            this.lambdaFunctionConfigurations = list;
        }

        public final List<QueueConfiguration> getQueueConfigurations() {
            return this.queueConfigurations;
        }

        public final void setQueueConfigurations(List<QueueConfiguration> list) {
            this.queueConfigurations = list;
        }

        public final List<TopicConfiguration> getTopicConfigurations() {
            return this.topicConfigurations;
        }

        public final void setTopicConfigurations(List<TopicConfiguration> list) {
            this.topicConfigurations = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(GetBucketNotificationConfigurationResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.eventBridgeConfiguration = x.getEventBridgeConfiguration();
            this.lambdaFunctionConfigurations = x.getLambdaFunctionConfigurations();
            this.queueConfigurations = x.getQueueConfigurations();
            this.topicConfigurations = x.getTopicConfigurations();
        }

        public final GetBucketNotificationConfigurationResponse build() {
            return new GetBucketNotificationConfigurationResponse(this, null);
        }

        public final void eventBridgeConfiguration(Function1<? super EventBridgeConfiguration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.eventBridgeConfiguration = GetBucketNotificationConfigurationResponseKt.awsSdkKotlinServicesS3ModelEventBridgeConfigurationDslBuilderRef.invoke(block);
        }
    }
}
