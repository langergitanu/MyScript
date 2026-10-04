package com.myscript.nebo.storage;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/storage/StorageState;", "", "<init>", "()V", "availableSpace", "", "getAvailableSpace", "()J", "Good", "Low", "Critical", "Companion", "Lcom/myscript/nebo/storage/StorageState$Critical;", "Lcom/myscript/nebo/storage/StorageState$Good;", "Lcom/myscript/nebo/storage/StorageState$Low;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class StorageState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ StorageState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final StorageState fromSpace(long j, long j2, long j3) {
        return INSTANCE.fromSpace(j, j2, j3);
    }

    public abstract long getAvailableSpace();

    private StorageState() {
    }

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/storage/StorageState$Good;", "Lcom/myscript/nebo/storage/StorageState;", "availableSpace", "", "<init>", "(J)V", "getAvailableSpace", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Good extends StorageState {
        public static final int $stable = 0;
        private final long availableSpace;

        public Good() {
            this(0L, 1, null);
        }

        public static /* synthetic */ Good copy$default(Good good, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = good.availableSpace;
            }
            return good.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getAvailableSpace() {
            return this.availableSpace;
        }

        public final Good copy(long availableSpace) {
            return new Good(availableSpace);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Good) && this.availableSpace == ((Good) other).availableSpace;
        }

        public int hashCode() {
            return Long.hashCode(this.availableSpace);
        }

        public String toString() {
            return "Good(availableSpace=" + this.availableSpace + ")";
        }

        public Good(long j) {
            super(null);
            this.availableSpace = j;
        }

        public /* synthetic */ Good(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Long.MAX_VALUE : j);
        }

        @Override // com.myscript.nebo.storage.StorageState
        public long getAvailableSpace() {
            return this.availableSpace;
        }
    }

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/storage/StorageState$Low;", "Lcom/myscript/nebo/storage/StorageState;", "availableSpace", "", "<init>", "(J)V", "getAvailableSpace", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Low extends StorageState {
        public static final int $stable = 0;
        private final long availableSpace;

        public static /* synthetic */ Low copy$default(Low low, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = low.availableSpace;
            }
            return low.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getAvailableSpace() {
            return this.availableSpace;
        }

        public final Low copy(long availableSpace) {
            return new Low(availableSpace);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Low) && this.availableSpace == ((Low) other).availableSpace;
        }

        public int hashCode() {
            return Long.hashCode(this.availableSpace);
        }

        public String toString() {
            return "Low(availableSpace=" + this.availableSpace + ")";
        }

        public Low(long j) {
            super(null);
            this.availableSpace = j;
        }

        @Override // com.myscript.nebo.storage.StorageState
        public long getAvailableSpace() {
            return this.availableSpace;
        }
    }

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/storage/StorageState$Critical;", "Lcom/myscript/nebo/storage/StorageState;", "availableSpace", "", "<init>", "(J)V", "getAvailableSpace", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Critical extends StorageState {
        public static final int $stable = 0;
        private final long availableSpace;

        public static /* synthetic */ Critical copy$default(Critical critical, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = critical.availableSpace;
            }
            return critical.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getAvailableSpace() {
            return this.availableSpace;
        }

        public final Critical copy(long availableSpace) {
            return new Critical(availableSpace);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Critical) && this.availableSpace == ((Critical) other).availableSpace;
        }

        public int hashCode() {
            return Long.hashCode(this.availableSpace);
        }

        public String toString() {
            return "Critical(availableSpace=" + this.availableSpace + ")";
        }

        public Critical(long j) {
            super(null);
            this.availableSpace = j;
        }

        @Override // com.myscript.nebo.storage.StorageState
        public long getAvailableSpace() {
            return this.availableSpace;
        }
    }

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/storage/StorageState$Companion;", "", "<init>", "()V", "fromSpace", "Lcom/myscript/nebo/storage/StorageState;", "availableSpace", "", "criticalThreshold", "lowThreshold", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StorageState fromSpace(long availableSpace, long criticalThreshold, long lowThreshold) {
            if (0 <= availableSpace && availableSpace <= criticalThreshold) {
                return new Critical(availableSpace);
            }
            if (criticalThreshold <= availableSpace && availableSpace <= lowThreshold) {
                return new Low(availableSpace);
            }
            return new Good(availableSpace);
        }
    }
}
