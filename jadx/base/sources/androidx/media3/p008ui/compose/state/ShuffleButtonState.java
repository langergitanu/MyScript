package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.media3.common.Player;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShuffleButtonState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0017R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Landroidx/media3/ui/compose/state/ShuffleButtonState;", "", "player", "Landroidx/media3/common/Player;", "<init>", "(Landroidx/media3/common/Player;)V", "<set-?>", "", "isEnabled", "()Z", "setEnabled", "(Z)V", "isEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "shuffleOn", "getShuffleOn", "setShuffleOn", "shuffleOn$delegate", "playerStateObserver", "Landroidx/media3/ui/compose/state/PlayerStateObserver;", "onClick", "", "observe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib-ui-compose_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ShuffleButtonState {
    public static final int $stable = 8;
    private final Player player;
    private final PlayerStateObserver playerStateObserver;

    /* JADX INFO: renamed from: isEnabled$delegate, reason: from kotlin metadata */
    private final MutableState isEnabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: shuffleOn$delegate, reason: from kotlin metadata */
    private final MutableState shuffleOn = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.ShuffleButtonState$observe$1 */
    /* JADX INFO: compiled from: ShuffleButtonState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.ui.compose.state.ShuffleButtonState", m1609f = "ShuffleButtonState.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA9_1}, m1612m = "observe", m1613n = {}, m1615s = {})
    static final class C24921 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C24921(Continuation<? super C24921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShuffleButtonState.this.observe(this);
        }
    }

    public ShuffleButtonState(Player player) {
        this.player = player;
        this.playerStateObserver = player != null ? PlayerStateObserverKt.observeState(player, 9, new int[]{13}, new Function1() { // from class: androidx.media3.ui.compose.state.ShuffleButtonState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ShuffleButtonState.playerStateObserver$lambda$0(this.f$0, (Player) obj);
            }
        }) : null;
    }

    private final void setEnabled(boolean z) {
        this.isEnabled.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isEnabled() {
        return ((Boolean) this.isEnabled.getValue()).booleanValue();
    }

    private final void setShuffleOn(boolean z) {
        this.shuffleOn.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShuffleOn() {
        return ((Boolean) this.shuffleOn.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playerStateObserver$lambda$0(ShuffleButtonState shuffleButtonState, Player it) {
        Intrinsics.checkNotNullParameter(it, "it");
        shuffleButtonState.setEnabled(shuffleButtonState.player.isCommandAvailable(14));
        shuffleButtonState.setShuffleOn(shuffleButtonState.player.getShuffleModeEnabled());
        return Unit.INSTANCE;
    }

    public final void onClick() {
        Player player = this.player;
        if (player == null || !player.isCommandAvailable(14)) {
            return;
        }
        player.setShuffleModeEnabled(!player.getShuffleModeEnabled());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observe(Continuation<? super Unit> continuation) {
        C24921 c24921;
        if (continuation instanceof C24921) {
            c24921 = (C24921) continuation;
            if ((c24921.label & Integer.MIN_VALUE) != 0) {
                c24921.label -= Integer.MIN_VALUE;
            } else {
                c24921 = new C24921(continuation);
            }
        }
        Object obj = c24921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c24921.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PlayerStateObserver playerStateObserver = this.playerStateObserver;
            if (playerStateObserver == null) {
                return Unit.INSTANCE;
            }
            c24921.label = 1;
            if (playerStateObserver.observe(c24921) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
