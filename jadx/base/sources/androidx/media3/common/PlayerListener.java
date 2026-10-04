package androidx.media3.common;

import androidx.media3.common.Player;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: PlayerExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@kotlin.Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B>\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001d\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0012"}, m1599d2 = {"Landroidx/media3/common/PlayerListener;", "Landroidx/media3/common/Player$Listener;", "events", "Landroidx/media3/common/Player$Events;", "onEvents", "Lkotlin/Function2;", "Landroidx/media3/common/Player;", "", "Lkotlin/ExtensionFunctionType;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Landroidx/media3/common/Player$Events;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CancellableContinuation;)V", "isCancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "player", "lib-common-ktx_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
final class PlayerListener implements Player.Listener {
    private final CancellableContinuation<?> continuation;
    private final Player.Events events;
    private final AtomicBoolean isCancelled;
    private final Function2<Player, Player.Events, Unit> onEvents;

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerListener(Player.Events events, Function2<? super Player, ? super Player.Events, Unit> onEvents, CancellableContinuation<?> continuation) {
        Intrinsics.checkNotNullParameter(onEvents, "onEvents");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.events = events;
        this.onEvents = onEvents;
        this.continuation = continuation;
        this.isCancelled = new AtomicBoolean(false);
    }

    /* JADX INFO: renamed from: isCancelled, reason: from getter */
    public final AtomicBoolean getIsCancelled() {
        return this.isCancelled;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onEvents(Player player, Player.Events events) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(events, "events");
        try {
            if (this.isCancelled.get()) {
                return;
            }
            Player.Events events2 = this.events;
            if (events2 == null || events.containsAny(events2)) {
                this.onEvents.invoke(player, events);
            }
        } catch (Throwable th) {
            this.isCancelled.set(true);
            CancellableContinuation<?> cancellableContinuation = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m14499constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
