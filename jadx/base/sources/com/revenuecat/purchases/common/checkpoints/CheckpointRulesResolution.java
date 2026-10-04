package com.revenuecat.purchases.common.checkpoints;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointRulesResolution.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution;", "", "()V", "Found", "NotConfigured", "Unavailable", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution$Found;", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution$NotConfigured;", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution$Unavailable;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class CheckpointRulesResolution {
    public /* synthetic */ CheckpointRulesResolution(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CheckpointRulesResolution() {
    }

    /* JADX INFO: compiled from: CheckpointRulesResolution.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution$Found;", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution;", "checkpoint", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointResponse;", "configGeneration", "", "(Lcom/revenuecat/purchases/common/checkpoints/CheckpointResponse;I)V", "getCheckpoint", "()Lcom/revenuecat/purchases/common/checkpoints/CheckpointResponse;", "getConfigGeneration", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class Found extends CheckpointRulesResolution {
        private final CheckpointResponse checkpoint;
        private final int configGeneration;

        public static /* synthetic */ Found copy$default(Found found, CheckpointResponse checkpointResponse, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                checkpointResponse = found.checkpoint;
            }
            if ((i2 & 2) != 0) {
                i = found.configGeneration;
            }
            return found.copy(checkpointResponse, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CheckpointResponse getCheckpoint() {
            return this.checkpoint;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getConfigGeneration() {
            return this.configGeneration;
        }

        public final Found copy(CheckpointResponse checkpoint, int configGeneration) {
            Intrinsics.checkNotNullParameter(checkpoint, "checkpoint");
            return new Found(checkpoint, configGeneration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Found)) {
                return false;
            }
            Found found = (Found) other;
            return Intrinsics.areEqual(this.checkpoint, found.checkpoint) && this.configGeneration == found.configGeneration;
        }

        public int hashCode() {
            return (this.checkpoint.hashCode() * 31) + Integer.hashCode(this.configGeneration);
        }

        public String toString() {
            return "Found(checkpoint=" + this.checkpoint + ", configGeneration=" + this.configGeneration + ')';
        }

        public final CheckpointResponse getCheckpoint() {
            return this.checkpoint;
        }

        public final int getConfigGeneration() {
            return this.configGeneration;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Found(CheckpointResponse checkpoint, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(checkpoint, "checkpoint");
            this.checkpoint = checkpoint;
            this.configGeneration = i;
        }
    }

    /* JADX INFO: compiled from: CheckpointRulesResolution.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution$NotConfigured;", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class NotConfigured extends CheckpointRulesResolution {
        public static final NotConfigured INSTANCE = new NotConfigured();

        private NotConfigured() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CheckpointRulesResolution.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution$Unavailable;", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRulesResolution;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Unavailable extends CheckpointRulesResolution {
        public static final Unavailable INSTANCE = new Unavailable();

        private Unavailable() {
            super(null);
        }
    }
}
