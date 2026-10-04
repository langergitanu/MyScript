package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointsExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u000e\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0087@¢\u0006\u0002\u0010\u0014\"2\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, m1599d2 = {"value", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointListener;", "checkpointListener", "Lcom/revenuecat/purchases/Purchases;", "getCheckpointListener$annotations", "(Lcom/revenuecat/purchases/Purchases;)V", "getCheckpointListener", "(Lcom/revenuecat/purchases/Purchases;)Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointListener;", "setCheckpointListener", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointListener;)V", "checkpointsManager", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointsManager;", "getCheckpointsManager", "(Lcom/revenuecat/purchases/Purchases;)Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointsManager;", "awaitCheckpoint", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult;", "checkpointIdentifier", "", "params", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams;", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointsExtensionsKt {
    public static /* synthetic */ void getCheckpointListener$annotations(Purchases purchases) {
    }

    public static /* synthetic */ Object awaitCheckpoint$default(Purchases purchases, String str, CheckpointParams checkpointParams, Continuation continuation, int i, Object obj) throws PurchasesException {
        if ((i & 2) != 0) {
            checkpointParams = null;
        }
        return awaitCheckpoint(purchases, str, checkpointParams, continuation);
    }

    public static final /* synthetic */ Object awaitCheckpoint(Purchases purchases, String str, CheckpointParams checkpointParams, Continuation continuation) throws PurchasesException {
        return getCheckpointsManager(purchases).checkpoint(purchases, str, checkpointParams, continuation);
    }

    public static final /* synthetic */ CheckpointListener getCheckpointListener(Purchases purchases) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        return getCheckpointsManager(purchases).getCheckpointListener();
    }

    public static final /* synthetic */ void setCheckpointListener(Purchases purchases, CheckpointListener checkpointListener) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        getCheckpointsManager(purchases).setCheckpointListener(checkpointListener);
    }

    public static final CheckpointsManager getCheckpointsManager(Purchases purchases) {
        CheckpointsManager checkpointsManager;
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        synchronized (purchases) {
            Object checkpointManagerSlot = purchases.getCheckpointManagerSlot();
            checkpointsManager = checkpointManagerSlot instanceof CheckpointsManager ? (CheckpointsManager) checkpointManagerSlot : null;
            if (checkpointsManager == null) {
                checkpointsManager = new CheckpointsManager();
                purchases.setCheckpointManagerSlot(checkpointsManager);
            }
        }
        return checkpointsManager;
    }
}
