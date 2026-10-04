package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
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

/* JADX INFO: compiled from: PlaybackSpeedState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eJ\u000e\u0010\u001b\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Landroidx/media3/ui/compose/state/PlaybackSpeedState;", "", "player", "Landroidx/media3/common/Player;", "<init>", "(Landroidx/media3/common/Player;)V", "<set-?>", "", "isEnabled", "()Z", "setEnabled", "(Z)V", "isEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "", "playbackSpeed", "getPlaybackSpeed", "()F", "setPlaybackSpeed", "(F)V", "playbackSpeed$delegate", "Landroidx/compose/runtime/MutableFloatState;", "playerStateObserver", "Landroidx/media3/ui/compose/state/PlayerStateObserver;", "updatePlaybackSpeed", "", "speed", "observe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib-ui-compose_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PlaybackSpeedState {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: isEnabled$delegate, reason: from kotlin metadata */
    private final MutableState isEnabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: playbackSpeed$delegate, reason: from kotlin metadata */
    private final MutableFloatState playbackSpeed = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
    private final Player player;
    private final PlayerStateObserver playerStateObserver;

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.PlaybackSpeedState$observe$1 */
    /* JADX INFO: compiled from: PlaybackSpeedState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.ui.compose.state.PlaybackSpeedState", m1609f = "PlaybackSpeedState.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA9_5}, m1612m = "observe", m1613n = {}, m1615s = {})
    static final class C24781 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C24781(Continuation<? super C24781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlaybackSpeedState.this.observe(this);
        }
    }

    public PlaybackSpeedState(Player player) {
        this.player = player;
        this.playerStateObserver = player != null ? PlayerStateObserverKt.observeState(player, 12, new int[]{13}, new Function1() { // from class: androidx.media3.ui.compose.state.PlaybackSpeedState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaybackSpeedState.playerStateObserver$lambda$0(this.f$0, (Player) obj);
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

    private final void setPlaybackSpeed(float f) {
        this.playbackSpeed.setFloatValue(f);
    }

    public final float getPlaybackSpeed() {
        return this.playbackSpeed.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playerStateObserver$lambda$0(PlaybackSpeedState playbackSpeedState, Player it) {
        Intrinsics.checkNotNullParameter(it, "it");
        playbackSpeedState.setEnabled(playbackSpeedState.player.isCommandAvailable(13));
        playbackSpeedState.setPlaybackSpeed(playbackSpeedState.player.getPlaybackParameters().speed);
        return Unit.INSTANCE;
    }

    public final void updatePlaybackSpeed(float speed) {
        Player player = this.player;
        if (player == null || !player.isCommandAvailable(13)) {
            return;
        }
        player.setPlaybackParameters(player.getPlaybackParameters().withSpeed(speed));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observe(Continuation<? super Unit> continuation) {
        C24781 c24781;
        if (continuation instanceof C24781) {
            c24781 = (C24781) continuation;
            if ((c24781.label & Integer.MIN_VALUE) != 0) {
                c24781.label -= Integer.MIN_VALUE;
            } else {
                c24781 = new C24781(continuation);
            }
        }
        Object obj = c24781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c24781.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PlayerStateObserver playerStateObserver = this.playerStateObserver;
            if (playerStateObserver == null) {
                return Unit.INSTANCE;
            }
            c24781.label = 1;
            if (playerStateObserver.observe(c24781) == coroutine_suspended) {
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
