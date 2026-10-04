package com.myscript.nebo.common.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboNetworkStateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/common/network/NeboNetworkState;", "", "<init>", "()V", "isDataTransferAllowed", "", "Offline", "Connected", "Lcom/myscript/nebo/common/network/NeboNetworkState$Connected;", "Lcom/myscript/nebo/common/network/NeboNetworkState$Offline;", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class NeboNetworkState {
    public /* synthetic */ NeboNetworkState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: NeboNetworkStateRepository.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/common/network/NeboNetworkState$Offline;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Offline extends NeboNetworkState {
        public static final Offline INSTANCE = new Offline();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Offline)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -113515905;
        }

        public String toString() {
            return "Offline";
        }

        private Offline() {
            super(null);
        }
    }

    private NeboNetworkState() {
    }

    /* JADX INFO: compiled from: NeboNetworkStateRepository.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/common/network/NeboNetworkState$Connected;", "Lcom/myscript/nebo/common/network/NeboNetworkState;", "type", "Lcom/myscript/nebo/common/network/ConnectionType;", "isEnabled", "", "<init>", "(Lcom/myscript/nebo/common/network/ConnectionType;Z)V", "getType", "()Lcom/myscript/nebo/common/network/ConnectionType;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "common_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Connected extends NeboNetworkState {
        private final boolean isEnabled;
        private final ConnectionType type;

        public static /* synthetic */ Connected copy$default(Connected connected, ConnectionType connectionType, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                connectionType = connected.type;
            }
            if ((i & 2) != 0) {
                z = connected.isEnabled;
            }
            return connected.copy(connectionType, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConnectionType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final Connected copy(ConnectionType type, boolean isEnabled) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Connected(type, isEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Connected)) {
                return false;
            }
            Connected connected = (Connected) other;
            return this.type == connected.type && this.isEnabled == connected.isEnabled;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + Boolean.hashCode(this.isEnabled);
        }

        public String toString() {
            return "Connected(type=" + this.type + ", isEnabled=" + this.isEnabled + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Connected(ConnectionType type, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.isEnabled = z;
        }

        public final ConnectionType getType() {
            return this.type;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }
    }

    public final boolean isDataTransferAllowed() {
        return (this instanceof Connected) && ((Connected) this).isEnabled();
    }
}
