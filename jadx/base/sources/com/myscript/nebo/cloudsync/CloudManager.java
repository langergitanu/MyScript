package com.myscript.nebo.cloudsync;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: CloudManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0005$%&'(J\u0014\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u000e\u0010\u0015\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0016J\b\u0010\u001b\u001a\u00020\u000bH&J\b\u0010\u001c\u001a\u00020\u0012H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\"H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006)À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/CloudManager;", "", "connectedProvider", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "getConnectedProvider", "()Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "providerName", "", "getProviderName", "()Ljava/lang/String;", "isCloudConnected", "", "()Z", "isCloudBound", "isClientInstantiated", "isConnectedToDropbox", "isConnectedToGDrive", "bindCloud", "", "callback", "Lcom/myscript/nebo/cloudsync/CloudManager$BindCloudCallback;", "unbindCloud", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect", "providerType", "(Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CloudTokenInvalidDialogFragment.ACTION_DISCONNECT, "hasForwardCompatibilityIssue", "setHasForwardCompatibilityIssue", "addCloudSyncInitializedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/cloudsync/CloudManager$CloudSyncInitializedListener;", "removeCloudSyncInitializedListener", "addCloudDisconnectedListener", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudDisconnectedListener;", "removeCloudDisconnectedListener", "Provider", "CloudSyncInitializedListener", "CloudDisconnectedListener", "BindCloudCallback", "CloudProviderType", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CloudManager {

    /* JADX INFO: compiled from: CloudManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/CloudManager$CloudDisconnectedListener;", "", "onCloudDisconnecting", "", "provider", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "onCloudDisconnected", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface CloudDisconnectedListener {
        void onCloudDisconnected(CloudProviderType provider);

        void onCloudDisconnecting(CloudProviderType provider);
    }

    /* JADX INFO: compiled from: CloudManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/CloudManager$CloudSyncInitializedListener;", "", "onCloudSyncInitialized", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface CloudSyncInitializedListener {
        void onCloudSyncInitialized();
    }

    /* JADX INFO: compiled from: CloudManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/CloudManager$Provider;", "", "provideCloudManager", "Lcom/myscript/nebo/cloudsync/CloudManager;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        CloudManager provideCloudManager();
    }

    void addCloudDisconnectedListener(CloudDisconnectedListener listener);

    void addCloudSyncInitializedListener(CloudSyncInitializedListener listener);

    void bindCloud(BindCloudCallback callback);

    Object connect(CloudProviderType cloudProviderType, Continuation<? super Unit> continuation);

    Object disconnect(Continuation<? super Unit> continuation);

    CloudProviderType getConnectedProvider();

    String getProviderName();

    String getProviderName(CloudProviderType providerType);

    boolean hasForwardCompatibilityIssue();

    boolean isClientInstantiated();

    boolean isCloudBound();

    boolean isCloudConnected();

    boolean isConnectedToDropbox();

    boolean isConnectedToGDrive();

    void removeCloudDisconnectedListener(CloudDisconnectedListener listener);

    void removeCloudSyncInitializedListener(CloudSyncInitializedListener listener);

    void setHasForwardCompatibilityIssue();

    Object unbindCloud(Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: CloudManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/CloudManager$BindCloudCallback;", "", "onResult", "", "bound", "", "handled", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface BindCloudCallback {
        void onResult(boolean bound, boolean handled);

        /* JADX INFO: compiled from: CloudManager.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class DefaultImpls {
        }

        static /* synthetic */ void onResult$default(BindCloudCallback bindCloudCallback, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            bindCloudCallback.onResult(z, z2);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: CloudManager.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "", "<init>", "(Ljava/lang/String;I)V", "Dropbox", "GDrive", "None", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CloudProviderType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CloudProviderType[] $VALUES;
        public static final CloudProviderType Dropbox = new CloudProviderType("Dropbox", 0);
        public static final CloudProviderType GDrive = new CloudProviderType("GDrive", 1);
        public static final CloudProviderType None = new CloudProviderType("None", 2);

        private static final /* synthetic */ CloudProviderType[] $values() {
            return new CloudProviderType[]{Dropbox, GDrive, None};
        }

        public static EnumEntries<CloudProviderType> getEntries() {
            return $ENTRIES;
        }

        public static CloudProviderType valueOf(String str) {
            return (CloudProviderType) Enum.valueOf(CloudProviderType.class, str);
        }

        public static CloudProviderType[] values() {
            return (CloudProviderType[]) $VALUES.clone();
        }

        private CloudProviderType(String str, int i) {
        }

        static {
            CloudProviderType[] cloudProviderTypeArr$values = $values();
            $VALUES = cloudProviderTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(cloudProviderTypeArr$values);
        }
    }

    /* JADX INFO: compiled from: CloudManager.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void bindCloud$default(CloudManager cloudManager, BindCloudCallback bindCloudCallback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindCloud");
        }
        if ((i & 1) != 0) {
            bindCloudCallback = null;
        }
        cloudManager.bindCloud(bindCloudCallback);
    }
}
