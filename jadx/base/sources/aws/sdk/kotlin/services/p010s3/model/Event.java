package aws.sdk.kotlin.services.p010s3.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 $2\u00020\u0001:\u001d\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u001c%&'()*+,-./0123456789:;<=>?@¨\u0006A"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event;", "", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "S3IntelligentTiering", "S3LifecycleExpiration", "S3LifecycleExpirationDelete", "S3LifecycleExpirationDeleteMarkerCreated", "S3LifecycleTransition", "S3ObjectAclPut", "S3ObjectCreated", "S3ObjectCreatedCompleteMultipartUpload", "S3ObjectCreatedCopy", "S3ObjectCreatedPost", "S3ObjectCreatedPut", "S3ObjectRemoved", "S3ObjectRemovedDelete", "S3ObjectRemovedDeleteMarkerCreated", "S3ObjectRestore", "S3ObjectRestoreCompleted", "S3ObjectRestoreDelete", "S3ObjectRestorePost", "S3ObjectTagging", "S3ObjectTaggingDelete", "S3ObjectTaggingPut", "S3ReducedRedundancyLostObject", "S3Replication", "S3ReplicationOperationFailedReplication", "S3ReplicationOperationMissedThreshold", "S3ReplicationOperationNotTracked", "S3ReplicationOperationReplicatedAfterThreshold", "SdkUnknown", "Companion", "Laws/sdk/kotlin/services/s3/model/Event$S3IntelligentTiering;", "Laws/sdk/kotlin/services/s3/model/Event$S3LifecycleExpiration;", "Laws/sdk/kotlin/services/s3/model/Event$S3LifecycleExpirationDelete;", "Laws/sdk/kotlin/services/s3/model/Event$S3LifecycleExpirationDeleteMarkerCreated;", "Laws/sdk/kotlin/services/s3/model/Event$S3LifecycleTransition;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectAclPut;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreated;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreatedCompleteMultipartUpload;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreatedCopy;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreatedPost;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreatedPut;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRemoved;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRemovedDelete;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRemovedDeleteMarkerCreated;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRestore;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRestoreCompleted;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRestoreDelete;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRestorePost;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectTagging;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectTaggingDelete;", "Laws/sdk/kotlin/services/s3/model/Event$S3ObjectTaggingPut;", "Laws/sdk/kotlin/services/s3/model/Event$S3ReducedRedundancyLostObject;", "Laws/sdk/kotlin/services/s3/model/Event$S3Replication;", "Laws/sdk/kotlin/services/s3/model/Event$S3ReplicationOperationFailedReplication;", "Laws/sdk/kotlin/services/s3/model/Event$S3ReplicationOperationMissedThreshold;", "Laws/sdk/kotlin/services/s3/model/Event$S3ReplicationOperationNotTracked;", "Laws/sdk/kotlin/services/s3/model/Event$S3ReplicationOperationReplicatedAfterThreshold;", "Laws/sdk/kotlin/services/s3/model/Event$SdkUnknown;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Event {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Event> values = CollectionsKt.listOf((Object[]) new Event[]{S3IntelligentTiering.INSTANCE, S3LifecycleExpiration.INSTANCE, S3LifecycleExpirationDelete.INSTANCE, S3LifecycleExpirationDeleteMarkerCreated.INSTANCE, S3LifecycleTransition.INSTANCE, S3ObjectAclPut.INSTANCE, S3ObjectCreated.INSTANCE, S3ObjectCreatedCompleteMultipartUpload.INSTANCE, S3ObjectCreatedCopy.INSTANCE, S3ObjectCreatedPost.INSTANCE, S3ObjectCreatedPut.INSTANCE, S3ObjectRemoved.INSTANCE, S3ObjectRemovedDelete.INSTANCE, S3ObjectRemovedDeleteMarkerCreated.INSTANCE, S3ObjectRestore.INSTANCE, S3ObjectRestoreCompleted.INSTANCE, S3ObjectRestoreDelete.INSTANCE, S3ObjectRestorePost.INSTANCE, S3ObjectTagging.INSTANCE, S3ObjectTaggingDelete.INSTANCE, S3ObjectTaggingPut.INSTANCE, S3ReducedRedundancyLostObject.INSTANCE, S3Replication.INSTANCE, S3ReplicationOperationFailedReplication.INSTANCE, S3ReplicationOperationMissedThreshold.INSTANCE, S3ReplicationOperationNotTracked.INSTANCE, S3ReplicationOperationReplicatedAfterThreshold.INSTANCE});

    public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    private Event() {
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3IntelligentTiering;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3IntelligentTiering extends Event {
        public static final S3IntelligentTiering INSTANCE = new S3IntelligentTiering();
        private static final String value = "s3:IntelligentTiering";

        private S3IntelligentTiering() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3IntelligentTiering";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3LifecycleExpiration;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3LifecycleExpiration extends Event {
        public static final S3LifecycleExpiration INSTANCE = new S3LifecycleExpiration();
        private static final String value = "s3:LifecycleExpiration:*";

        private S3LifecycleExpiration() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3LifecycleExpiration";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3LifecycleExpirationDelete;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3LifecycleExpirationDelete extends Event {
        public static final S3LifecycleExpirationDelete INSTANCE = new S3LifecycleExpirationDelete();
        private static final String value = "s3:LifecycleExpiration:Delete";

        private S3LifecycleExpirationDelete() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3LifecycleExpirationDelete";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3LifecycleExpirationDeleteMarkerCreated;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3LifecycleExpirationDeleteMarkerCreated extends Event {
        public static final S3LifecycleExpirationDeleteMarkerCreated INSTANCE = new S3LifecycleExpirationDeleteMarkerCreated();
        private static final String value = "s3:LifecycleExpiration:DeleteMarkerCreated";

        private S3LifecycleExpirationDeleteMarkerCreated() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3LifecycleExpirationDeleteMarkerCreated";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3LifecycleTransition;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3LifecycleTransition extends Event {
        public static final S3LifecycleTransition INSTANCE = new S3LifecycleTransition();
        private static final String value = "s3:LifecycleTransition";

        private S3LifecycleTransition() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3LifecycleTransition";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectAclPut;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectAclPut extends Event {
        public static final S3ObjectAclPut INSTANCE = new S3ObjectAclPut();
        private static final String value = "s3:ObjectAcl:Put";

        private S3ObjectAclPut() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectAclPut";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreated;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectCreated extends Event {
        public static final S3ObjectCreated INSTANCE = new S3ObjectCreated();
        private static final String value = "s3:ObjectCreated:*";

        private S3ObjectCreated() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectCreated";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreatedCompleteMultipartUpload;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectCreatedCompleteMultipartUpload extends Event {
        public static final S3ObjectCreatedCompleteMultipartUpload INSTANCE = new S3ObjectCreatedCompleteMultipartUpload();
        private static final String value = "s3:ObjectCreated:CompleteMultipartUpload";

        private S3ObjectCreatedCompleteMultipartUpload() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectCreatedCompleteMultipartUpload";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreatedCopy;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectCreatedCopy extends Event {
        public static final S3ObjectCreatedCopy INSTANCE = new S3ObjectCreatedCopy();
        private static final String value = "s3:ObjectCreated:Copy";

        private S3ObjectCreatedCopy() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectCreatedCopy";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreatedPost;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectCreatedPost extends Event {
        public static final S3ObjectCreatedPost INSTANCE = new S3ObjectCreatedPost();
        private static final String value = "s3:ObjectCreated:Post";

        private S3ObjectCreatedPost() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectCreatedPost";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectCreatedPut;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectCreatedPut extends Event {
        public static final S3ObjectCreatedPut INSTANCE = new S3ObjectCreatedPut();
        private static final String value = "s3:ObjectCreated:Put";

        private S3ObjectCreatedPut() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectCreatedPut";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRemoved;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectRemoved extends Event {
        public static final S3ObjectRemoved INSTANCE = new S3ObjectRemoved();
        private static final String value = "s3:ObjectRemoved:*";

        private S3ObjectRemoved() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectRemoved";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRemovedDelete;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectRemovedDelete extends Event {
        public static final S3ObjectRemovedDelete INSTANCE = new S3ObjectRemovedDelete();
        private static final String value = "s3:ObjectRemoved:Delete";

        private S3ObjectRemovedDelete() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectRemovedDelete";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRemovedDeleteMarkerCreated;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectRemovedDeleteMarkerCreated extends Event {
        public static final S3ObjectRemovedDeleteMarkerCreated INSTANCE = new S3ObjectRemovedDeleteMarkerCreated();
        private static final String value = "s3:ObjectRemoved:DeleteMarkerCreated";

        private S3ObjectRemovedDeleteMarkerCreated() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectRemovedDeleteMarkerCreated";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRestore;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectRestore extends Event {
        public static final S3ObjectRestore INSTANCE = new S3ObjectRestore();
        private static final String value = "s3:ObjectRestore:*";

        private S3ObjectRestore() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectRestore";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRestoreCompleted;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectRestoreCompleted extends Event {
        public static final S3ObjectRestoreCompleted INSTANCE = new S3ObjectRestoreCompleted();
        private static final String value = "s3:ObjectRestore:Completed";

        private S3ObjectRestoreCompleted() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectRestoreCompleted";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRestoreDelete;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectRestoreDelete extends Event {
        public static final S3ObjectRestoreDelete INSTANCE = new S3ObjectRestoreDelete();
        private static final String value = "s3:ObjectRestore:Delete";

        private S3ObjectRestoreDelete() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectRestoreDelete";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectRestorePost;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectRestorePost extends Event {
        public static final S3ObjectRestorePost INSTANCE = new S3ObjectRestorePost();
        private static final String value = "s3:ObjectRestore:Post";

        private S3ObjectRestorePost() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectRestorePost";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectTagging;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectTagging extends Event {
        public static final S3ObjectTagging INSTANCE = new S3ObjectTagging();
        private static final String value = "s3:ObjectTagging:*";

        private S3ObjectTagging() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectTagging";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectTaggingDelete;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectTaggingDelete extends Event {
        public static final S3ObjectTaggingDelete INSTANCE = new S3ObjectTaggingDelete();
        private static final String value = "s3:ObjectTagging:Delete";

        private S3ObjectTaggingDelete() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectTaggingDelete";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ObjectTaggingPut;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ObjectTaggingPut extends Event {
        public static final S3ObjectTaggingPut INSTANCE = new S3ObjectTaggingPut();
        private static final String value = "s3:ObjectTagging:Put";

        private S3ObjectTaggingPut() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ObjectTaggingPut";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ReducedRedundancyLostObject;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ReducedRedundancyLostObject extends Event {
        public static final S3ReducedRedundancyLostObject INSTANCE = new S3ReducedRedundancyLostObject();
        private static final String value = "s3:ReducedRedundancyLostObject";

        private S3ReducedRedundancyLostObject() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ReducedRedundancyLostObject";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3Replication;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3Replication extends Event {
        public static final S3Replication INSTANCE = new S3Replication();
        private static final String value = "s3:Replication:*";

        private S3Replication() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3Replication";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ReplicationOperationFailedReplication;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ReplicationOperationFailedReplication extends Event {
        public static final S3ReplicationOperationFailedReplication INSTANCE = new S3ReplicationOperationFailedReplication();
        private static final String value = "s3:Replication:OperationFailedReplication";

        private S3ReplicationOperationFailedReplication() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ReplicationOperationFailedReplication";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ReplicationOperationMissedThreshold;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ReplicationOperationMissedThreshold extends Event {
        public static final S3ReplicationOperationMissedThreshold INSTANCE = new S3ReplicationOperationMissedThreshold();
        private static final String value = "s3:Replication:OperationMissedThreshold";

        private S3ReplicationOperationMissedThreshold() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ReplicationOperationMissedThreshold";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ReplicationOperationNotTracked;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ReplicationOperationNotTracked extends Event {
        public static final S3ReplicationOperationNotTracked INSTANCE = new S3ReplicationOperationNotTracked();
        private static final String value = "s3:Replication:OperationNotTracked";

        private S3ReplicationOperationNotTracked() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ReplicationOperationNotTracked";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$S3ReplicationOperationReplicatedAfterThreshold;", "Laws/sdk/kotlin/services/s3/model/Event;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class S3ReplicationOperationReplicatedAfterThreshold extends Event {
        public static final S3ReplicationOperationReplicatedAfterThreshold INSTANCE = new S3ReplicationOperationReplicatedAfterThreshold();
        private static final String value = "s3:Replication:OperationReplicatedAfterThreshold";

        private S3ReplicationOperationReplicatedAfterThreshold() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return value;
        }

        public String toString() {
            return "S3ReplicationOperationReplicatedAfterThreshold";
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/Event;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SdkUnknown extends Event {
        private final String value;

        public static /* synthetic */ SdkUnknown copy$default(SdkUnknown sdkUnknown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sdkUnknown.value;
            }
            return sdkUnknown.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final SdkUnknown copy(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SdkUnknown(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SdkUnknown) && Intrinsics.areEqual(this.value, ((SdkUnknown) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SdkUnknown(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Event
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return "SdkUnknown(" + getValue() + ')';
        }
    }

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Event$Companion;", "", "<init>", "()V", "fromValue", "Laws/sdk/kotlin/services/s3/model/Event;", "value", "", "values", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final Event fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case -2131098217:
                    if (value.equals("s3:ObjectRemoved:*")) {
                        return S3ObjectRemoved.INSTANCE;
                    }
                    break;
                case -2121658426:
                    if (value.equals("s3:ObjectAcl:Put")) {
                        return S3ObjectAclPut.INSTANCE;
                    }
                    break;
                case -1929769111:
                    if (value.equals("s3:Replication:OperationReplicatedAfterThreshold")) {
                        return S3ReplicationOperationReplicatedAfterThreshold.INSTANCE;
                    }
                    break;
                case -1599084859:
                    if (value.equals("s3:ObjectRestore:Post")) {
                        return S3ObjectRestorePost.INSTANCE;
                    }
                    break;
                case -1245316736:
                    if (value.equals("s3:ObjectCreated:Copy")) {
                        return S3ObjectCreatedCopy.INSTANCE;
                    }
                    break;
                case -1244929365:
                    if (value.equals("s3:ObjectCreated:Post")) {
                        return S3ObjectCreatedPost.INSTANCE;
                    }
                    break;
                case -1103169364:
                    if (value.equals("s3:ObjectTagging:*")) {
                        return S3ObjectTagging.INSTANCE;
                    }
                    break;
                case -963974075:
                    if (value.equals("s3:ObjectRestore:*")) {
                        return S3ObjectRestore.INSTANCE;
                    }
                    break;
                case -951269250:
                    if (value.equals("s3:ObjectRemoved:Delete")) {
                        return S3ObjectRemovedDelete.INSTANCE;
                    }
                    break;
                case -804608016:
                    if (value.equals("s3:Replication:OperationFailedReplication")) {
                        return S3ReplicationOperationFailedReplication.INSTANCE;
                    }
                    break;
                case -588972030:
                    if (value.equals("s3:Replication:*")) {
                        return S3Replication.INSTANCE;
                    }
                    break;
                case -59922429:
                    if (value.equals("s3:IntelligentTiering")) {
                        return S3IntelligentTiering.INSTANCE;
                    }
                    break;
                case 14301425:
                    if (value.equals("s3:Replication:OperationMissedThreshold")) {
                        return S3ReplicationOperationMissedThreshold.INSTANCE;
                    }
                    break;
                case 33389193:
                    if (value.equals("s3:ObjectTagging:Delete")) {
                        return S3ObjectTaggingDelete.INSTANCE;
                    }
                    break;
                case 124750821:
                    if (value.equals("s3:LifecycleTransition")) {
                        return S3LifecycleTransition.INSTANCE;
                    }
                    break;
                case 164385416:
                    if (value.equals("s3:LifecycleExpiration:DeleteMarkerCreated")) {
                        return S3LifecycleExpirationDeleteMarkerCreated.INSTANCE;
                    }
                    break;
                case 442328292:
                    if (value.equals("s3:ReducedRedundancyLostObject")) {
                        return S3ReducedRedundancyLostObject.INSTANCE;
                    }
                    break;
                case 514030500:
                    if (value.equals("s3:ObjectCreated:Put")) {
                        return S3ObjectCreatedPut.INSTANCE;
                    }
                    break;
                case 524738192:
                    if (value.equals("s3:ObjectRestore:Delete")) {
                        return S3ObjectRestoreDelete.INSTANCE;
                    }
                    break;
                case 711203569:
                    if (value.equals("s3:ObjectTagging:Put")) {
                        return S3ObjectTaggingPut.INSTANCE;
                    }
                    break;
                case 1040332649:
                    if (value.equals("s3:ObjectCreated:CompleteMultipartUpload")) {
                        return S3ObjectCreatedCompleteMultipartUpload.INSTANCE;
                    }
                    break;
                case 1335106735:
                    if (value.equals("s3:LifecycleExpiration:*")) {
                        return S3LifecycleExpiration.INSTANCE;
                    }
                    break;
                case 1458622832:
                    if (value.equals("s3:ObjectRemoved:DeleteMarkerCreated")) {
                        return S3ObjectRemovedDeleteMarkerCreated.INSTANCE;
                    }
                    break;
                case 1479862815:
                    if (value.equals("s3:ObjectCreated:*")) {
                        return S3ObjectCreated.INSTANCE;
                    }
                    break;
                case 1589665622:
                    if (value.equals("s3:Replication:OperationNotTracked")) {
                        return S3ReplicationOperationNotTracked.INSTANCE;
                    }
                    break;
                case 1901944934:
                    if (value.equals("s3:LifecycleExpiration:Delete")) {
                        return S3LifecycleExpirationDelete.INSTANCE;
                    }
                    break;
                case 2045359942:
                    if (value.equals("s3:ObjectRestore:Completed")) {
                        return S3ObjectRestoreCompleted.INSTANCE;
                    }
                    break;
            }
            return new SdkUnknown(value);
        }

        public final List<Event> values() {
            return Event.values;
        }
    }
}
