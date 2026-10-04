package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.media3.common.Player;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepeatButtonState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {"Landroidx/media3/ui/compose/state/RepeatButtonState;", "", "player", "Landroidx/media3/common/Player;", "toggleModeSequence", "", "", "<init>", "(Landroidx/media3/common/Player;Ljava/util/List;)V", "<set-?>", "", "isEnabled", "()Z", "setEnabled", "(Z)V", "isEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "repeatModeState", "getRepeatModeState", "()I", "setRepeatModeState", "(I)V", "repeatModeState$delegate", "Landroidx/compose/runtime/MutableIntState;", "playerStateObserver", "Landroidx/media3/ui/compose/state/PlayerStateObserver;", "onClick", "", "observe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNextRepeatModeInSequence", "lib-ui-compose_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class RepeatButtonState {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: isEnabled$delegate, reason: from kotlin metadata */
    private final MutableState isEnabled;
    private final Player player;
    private final PlayerStateObserver playerStateObserver;

    /* JADX INFO: renamed from: repeatModeState$delegate, reason: from kotlin metadata */
    private final MutableIntState repeatModeState;
    private final List<Integer> toggleModeSequence;

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.RepeatButtonState$observe$1 */
    /* JADX INFO: compiled from: RepeatButtonState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.ui.compose.state.RepeatButtonState", m1609f = "RepeatButtonState.kt", m1610i = {}, m1611l = {107}, m1612m = "observe", m1613n = {}, m1615s = {})
    static final class C24891 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C24891(Continuation<? super C24891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepeatButtonState.this.observe(this);
        }
    }

    public RepeatButtonState(Player player, List<Integer> toggleModeSequence) {
        Intrinsics.checkNotNullParameter(toggleModeSequence, "toggleModeSequence");
        this.player = player;
        this.toggleModeSequence = toggleModeSequence;
        this.isEnabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.repeatModeState = SnapshotIntStateKt.mutableIntStateOf(0);
        this.playerStateObserver = player != null ? PlayerStateObserverKt.observeState(player, 8, new int[]{13}, new Function1() { // from class: androidx.media3.ui.compose.state.RepeatButtonState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RepeatButtonState.playerStateObserver$lambda$0(this.f$0, (Player) obj);
            }
        }) : null;
    }

    public /* synthetic */ RepeatButtonState(Player player, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(player, (i & 2) != 0 ? CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2}) : list);
    }

    private final void setEnabled(boolean z) {
        this.isEnabled.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isEnabled() {
        return ((Boolean) this.isEnabled.getValue()).booleanValue();
    }

    private final void setRepeatModeState(int i) {
        this.repeatModeState.setIntValue(i);
    }

    public final int getRepeatModeState() {
        return this.repeatModeState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playerStateObserver$lambda$0(RepeatButtonState repeatButtonState, Player it) {
        Intrinsics.checkNotNullParameter(it, "it");
        repeatButtonState.setEnabled(repeatButtonState.player.isCommandAvailable(15) && !repeatButtonState.toggleModeSequence.isEmpty());
        repeatButtonState.setRepeatModeState(repeatButtonState.player.getRepeatMode());
        return Unit.INSTANCE;
    }

    public final void onClick() {
        Player player = this.player;
        if (player == null || !player.isCommandAvailable(15)) {
            return;
        }
        player.setRepeatMode(getNextRepeatModeInSequence(player));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observe(Continuation<? super Unit> continuation) {
        C24891 c24891;
        if (continuation instanceof C24891) {
            c24891 = (C24891) continuation;
            if ((c24891.label & Integer.MIN_VALUE) != 0) {
                c24891.label -= Integer.MIN_VALUE;
            } else {
                c24891 = new C24891(continuation);
            }
        }
        Object obj = c24891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c24891.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PlayerStateObserver playerStateObserver = this.playerStateObserver;
            if (playerStateObserver == null) {
                return Unit.INSTANCE;
            }
            c24891.label = 1;
            if (playerStateObserver.observe(c24891) == coroutine_suspended) {
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

    private final int getNextRepeatModeInSequence(Player player) {
        int iIndexOf = this.toggleModeSequence.indexOf(Integer.valueOf(player.getRepeatMode()));
        List<Integer> list = this.toggleModeSequence;
        return list.get((iIndexOf + 1) % list.size()).intValue();
    }
}
