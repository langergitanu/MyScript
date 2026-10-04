package aws.sdk.kotlin.services.p010s3.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectObjectContentEventStream.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0013\u0014\u0015\u0016\u0017\u0018B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0082\u0001\u0006\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream;", "", "<init>", "()V", "asCont", "Laws/sdk/kotlin/services/s3/model/ContinuationEvent;", "asContOrNull", "asEnd", "Laws/sdk/kotlin/services/s3/model/EndEvent;", "asEndOrNull", "asProgress", "Laws/sdk/kotlin/services/s3/model/ProgressEvent;", "asProgressOrNull", "asRecords", "Laws/sdk/kotlin/services/s3/model/RecordsEvent;", "asRecordsOrNull", "asStats", "Laws/sdk/kotlin/services/s3/model/StatsEvent;", "asStatsOrNull", "Cont", "End", "Progress", "Records", "Stats", "SdkUnknown", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$Cont;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$End;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$Progress;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$Records;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$Stats;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class SelectObjectContentEventStream {
    public /* synthetic */ SelectObjectContentEventStream(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SelectObjectContentEventStream() {
    }

    /* JADX INFO: compiled from: SelectObjectContentEventStream.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$Cont;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream;", "value", "Laws/sdk/kotlin/services/s3/model/ContinuationEvent;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ContinuationEvent;)V", "getValue", "()Laws/sdk/kotlin/services/s3/model/ContinuationEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Cont extends SelectObjectContentEventStream {
        private final ContinuationEvent value;

        public static /* synthetic */ Cont copy$default(Cont cont, ContinuationEvent continuationEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                continuationEvent = cont.value;
            }
            return cont.copy(continuationEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ContinuationEvent getValue() {
            return this.value;
        }

        public final Cont copy(ContinuationEvent value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Cont(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Cont) && Intrinsics.areEqual(this.value, ((Cont) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Cont(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cont(ContinuationEvent value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ContinuationEvent getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: SelectObjectContentEventStream.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$End;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream;", "value", "Laws/sdk/kotlin/services/s3/model/EndEvent;", "<init>", "(Laws/sdk/kotlin/services/s3/model/EndEvent;)V", "getValue", "()Laws/sdk/kotlin/services/s3/model/EndEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class End extends SelectObjectContentEventStream {
        private final EndEvent value;

        public static /* synthetic */ End copy$default(End end, EndEvent endEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                endEvent = end.value;
            }
            return end.copy(endEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EndEvent getValue() {
            return this.value;
        }

        public final End copy(EndEvent value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new End(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof End) && Intrinsics.areEqual(this.value, ((End) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "End(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public End(EndEvent value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final EndEvent getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: SelectObjectContentEventStream.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$Progress;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream;", "value", "Laws/sdk/kotlin/services/s3/model/ProgressEvent;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ProgressEvent;)V", "getValue", "()Laws/sdk/kotlin/services/s3/model/ProgressEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Progress extends SelectObjectContentEventStream {
        private final ProgressEvent value;

        public static /* synthetic */ Progress copy$default(Progress progress, ProgressEvent progressEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                progressEvent = progress.value;
            }
            return progress.copy(progressEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ProgressEvent getValue() {
            return this.value;
        }

        public final Progress copy(ProgressEvent value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Progress(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Progress) && Intrinsics.areEqual(this.value, ((Progress) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Progress(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Progress(ProgressEvent value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ProgressEvent getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: SelectObjectContentEventStream.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$Records;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream;", "value", "Laws/sdk/kotlin/services/s3/model/RecordsEvent;", "<init>", "(Laws/sdk/kotlin/services/s3/model/RecordsEvent;)V", "getValue", "()Laws/sdk/kotlin/services/s3/model/RecordsEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Records extends SelectObjectContentEventStream {
        private final RecordsEvent value;

        public static /* synthetic */ Records copy$default(Records records, RecordsEvent recordsEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                recordsEvent = records.value;
            }
            return records.copy(recordsEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RecordsEvent getValue() {
            return this.value;
        }

        public final Records copy(RecordsEvent value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Records(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Records) && Intrinsics.areEqual(this.value, ((Records) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Records(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Records(RecordsEvent value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final RecordsEvent getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: SelectObjectContentEventStream.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$Stats;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream;", "value", "Laws/sdk/kotlin/services/s3/model/StatsEvent;", "<init>", "(Laws/sdk/kotlin/services/s3/model/StatsEvent;)V", "getValue", "()Laws/sdk/kotlin/services/s3/model/StatsEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Stats extends SelectObjectContentEventStream {
        private final StatsEvent value;

        public static /* synthetic */ Stats copy$default(Stats stats, StatsEvent statsEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                statsEvent = stats.value;
            }
            return stats.copy(statsEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StatsEvent getValue() {
            return this.value;
        }

        public final Stats copy(StatsEvent value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Stats(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Stats) && Intrinsics.areEqual(this.value, ((Stats) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Stats(value=" + this.value + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Stats(StatsEvent value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final StatsEvent getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: SelectObjectContentEventStream.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentEventStream;", "<init>", "()V", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SdkUnknown extends SelectObjectContentEventStream {
        public static final SdkUnknown INSTANCE = new SdkUnknown();

        private SdkUnknown() {
            super(null);
        }
    }

    public final ContinuationEvent asCont() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.SelectObjectContentEventStream.Cont");
        return ((Cont) this).getValue();
    }

    public final ContinuationEvent asContOrNull() {
        Cont cont = this instanceof Cont ? (Cont) this : null;
        if (cont != null) {
            return cont.getValue();
        }
        return null;
    }

    public final EndEvent asEnd() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.SelectObjectContentEventStream.End");
        return ((End) this).getValue();
    }

    public final EndEvent asEndOrNull() {
        End end = this instanceof End ? (End) this : null;
        if (end != null) {
            return end.getValue();
        }
        return null;
    }

    public final ProgressEvent asProgress() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.SelectObjectContentEventStream.Progress");
        return ((Progress) this).getValue();
    }

    public final ProgressEvent asProgressOrNull() {
        Progress progress = this instanceof Progress ? (Progress) this : null;
        if (progress != null) {
            return progress.getValue();
        }
        return null;
    }

    public final RecordsEvent asRecords() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.SelectObjectContentEventStream.Records");
        return ((Records) this).getValue();
    }

    public final RecordsEvent asRecordsOrNull() {
        Records records = this instanceof Records ? (Records) this : null;
        if (records != null) {
            return records.getValue();
        }
        return null;
    }

    public final StatsEvent asStats() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type aws.sdk.kotlin.services.s3.model.SelectObjectContentEventStream.Stats");
        return ((Stats) this).getValue();
    }

    public final StatsEvent asStatsOrNull() {
        Stats stats = this instanceof Stats ? (Stats) this : null;
        if (stats != null) {
            return stats.getValue();
        }
        return null;
    }
}
