package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointListener;", "", "onCheckpointCompleted", "", WebViewMessageType.CONTEXT, "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointCompletedContext;", "onCheckpointHit", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointHitContext;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface CheckpointListener {
    default void onCheckpointCompleted(CheckpointCompletedContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void onCheckpointHit(CheckpointHitContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: compiled from: CheckpointListener.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onCheckpointHit(CheckpointListener checkpointListener, CheckpointHitContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CheckpointListener.super.onCheckpointHit(context);
        }

        @Deprecated
        public static void onCheckpointCompleted(CheckpointListener checkpointListener, CheckpointCompletedContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CheckpointListener.super.onCheckpointCompleted(context);
        }
    }
}
