package androidx.media3.p008ui.compose.state;

import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.Player;
import androidx.media3.common.PlayerExtensionsKt;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PresentationState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010 \u001a\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\b$J\u0012\u0010%\u001a\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0005R&\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Landroidx/media3/ui/compose/state/PresentationState;", "", "keepContentOnReset", "", "<init>", "(Z)V", "<set-?>", "Landroidx/compose/ui/geometry/Size;", "videoSizeDp", "getVideoSizeDp-VsRJwc0", "()Landroidx/compose/ui/geometry/Size;", "setVideoSizeDp-iaC8Vc4", "(Landroidx/compose/ui/geometry/Size;)V", "videoSizeDp$delegate", "Landroidx/compose/runtime/MutableState;", "coverSurface", "getCoverSurface", "()Z", "setCoverSurface", "coverSurface$delegate", "value", "getKeepContentOnReset", "setKeepContentOnReset", "player", "Landroidx/media3/common/Player;", "getPlayer$annotations", "()V", "getPlayer", "()Landroidx/media3/common/Player;", "setPlayer", "(Landroidx/media3/common/Player;)V", "lastPeriodUidWithTracks", "observe", "", "(Landroidx/media3/common/Player;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoSizeDp", "getVideoSizeDp-hgXytuQ", "maybeHideSurface", "shouldKeepSurfaceVisible", "hasSelectedVideoTrack", "Companion", "lib-ui-compose_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PresentationState {

    /* JADX INFO: renamed from: coverSurface$delegate, reason: from kotlin metadata */
    private final MutableState coverSurface;
    private boolean keepContentOnReset;
    private Object lastPeriodUidWithTracks;
    private Player player;

    /* JADX INFO: renamed from: videoSizeDp$delegate, reason: from kotlin metadata */
    private final MutableState videoSizeDp;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.PresentationState$observe$1 */
    /* JADX INFO: compiled from: PresentationState.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.ui.compose.state.PresentationState", m1609f = "PresentationState.kt", m1610i = {0}, m1611l = {106}, m1612m = "observe", m1613n = {"this"}, m1615s = {"L$0"})
    static final class C24801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C24801(Continuation<? super C24801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PresentationState.this.observe(null, this);
        }
    }

    public PresentationState() {
        this(false, 1, null);
    }

    public static /* synthetic */ void getPlayer$annotations() {
    }

    public PresentationState(boolean z) {
        this.videoSizeDp = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.coverSurface = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.keepContentOnReset = z;
    }

    public /* synthetic */ PresentationState(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    /* JADX INFO: renamed from: setVideoSizeDp-iaC8Vc4, reason: not valid java name */
    private final void m11725setVideoSizeDpiaC8Vc4(Size size) {
        this.videoSizeDp.setValue(size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getVideoSizeDp-VsRJwc0, reason: not valid java name */
    public final Size m11726getVideoSizeDpVsRJwc0() {
        return (Size) this.videoSizeDp.getValue();
    }

    private final void setCoverSurface(boolean z) {
        this.coverSurface.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getCoverSurface() {
        return ((Boolean) this.coverSurface.getValue()).booleanValue();
    }

    public final boolean getKeepContentOnReset() {
        return this.keepContentOnReset;
    }

    public final void setKeepContentOnReset(boolean z) {
        if (z != this.keepContentOnReset) {
            this.keepContentOnReset = z;
            maybeHideSurface(this.player);
        }
    }

    public final Player getPlayer() {
        return this.player;
    }

    public final void setPlayer(Player player) {
        this.player = player;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observe(final Player player, Continuation<? super Unit> continuation) throws Throwable {
        C24801 c24801;
        PresentationState presentationState;
        if (continuation instanceof C24801) {
            c24801 = (C24801) continuation;
            if ((c24801.label & Integer.MIN_VALUE) != 0) {
                c24801.label -= Integer.MIN_VALUE;
            } else {
                c24801 = new C24801(continuation);
            }
        }
        Object obj = c24801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c24801.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                this.player = player;
                m11725setVideoSizeDpiaC8Vc4(m11724getVideoSizeDphgXytuQ(player));
                maybeHideSurface(player);
                if (player != null) {
                    Function2 function2 = new Function2() { // from class: androidx.media3.ui.compose.state.PresentationState$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return PresentationState.observe$lambda$0(this.f$0, player, (Player) obj2, (Player.Events) obj3);
                        }
                    };
                    c24801.L$0 = this;
                    c24801.label = 1;
                    if (PlayerExtensionsKt.listen(player, function2, c24801) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    presentationState = this;
                } else {
                    this.player = null;
                    return Unit.INSTANCE;
                }
            } catch (Throwable th) {
                th = th;
                presentationState = this;
                presentationState.player = null;
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            presentationState = (PresentationState) c24801.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                presentationState.player = null;
                throw th;
            }
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$0(PresentationState presentationState, Player player, Player listen, Player.Events events) {
        Intrinsics.checkNotNullParameter(listen, "$this$listen");
        Intrinsics.checkNotNullParameter(events, "events");
        if (events.contains(25) && !Intrinsics.areEqual(listen.getVideoSize(), VideoSize.UNKNOWN) && listen.getPlaybackState() != 1) {
            presentationState.m11725setVideoSizeDpiaC8Vc4(presentationState.m11724getVideoSizeDphgXytuQ(player));
        }
        if (events.contains(26)) {
            presentationState.setCoverSurface(false);
        }
        if (events.contains(2) && !presentationState.shouldKeepSurfaceVisible(player)) {
            presentationState.maybeHideSurface(player);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getVideoSizeDp-hgXytuQ, reason: not valid java name */
    private final Size m11724getVideoSizeDphgXytuQ(Player player) {
        if (player == null) {
            return null;
        }
        long jSize = SizeKt.Size(player.getVideoSize().width, player.getVideoSize().height);
        if (Size.m7972getWidthimpl(jSize) == 0.0f || Size.m7969getHeightimpl(jSize) == 0.0f) {
            return null;
        }
        float f = player.getVideoSize().pixelWidthHeightRatio;
        double d = f;
        if (d < 1.0d) {
            jSize = Size.m7965copyxjbvk4A$default(jSize, Size.m7972getWidthimpl(jSize) * f, 0.0f, 2, null);
        } else if (d > 1.0d) {
            jSize = Size.m7965copyxjbvk4A$default(jSize, 0.0f, Size.m7969getHeightimpl(jSize) / f, 1, null);
        }
        return Size.m7960boximpl(jSize);
    }

    private final void maybeHideSurface(Player player) {
        if (player != null) {
            if (player.isCommandAvailable(30) && !player.getCurrentTracks().isEmpty()) {
                z = true;
            }
            if (!this.keepContentOnReset && !z) {
                setCoverSurface(true);
            }
            if (!z || hasSelectedVideoTrack(player)) {
                return;
            }
            setCoverSurface(true);
            return;
        }
        setCoverSurface(getCoverSurface() || !this.keepContentOnReset);
    }

    private final boolean shouldKeepSurfaceVisible(Player player) {
        Timeline currentTimeline = player.isCommandAvailable(17) ? player.getCurrentTimeline() : Timeline.EMPTY;
        Intrinsics.checkNotNull(currentTimeline);
        if (currentTimeline.isEmpty()) {
            this.lastPeriodUidWithTracks = null;
            return false;
        }
        Timeline.Period period = new Timeline.Period();
        if (player.isCommandAvailable(30) && !player.getCurrentTracks().isEmpty()) {
            this.lastPeriodUidWithTracks = currentTimeline.getPeriod(player.getCurrentPeriodIndex(), period, true).uid;
        } else {
            Object obj = this.lastPeriodUidWithTracks;
            if (obj != null) {
                int indexOfPeriod = currentTimeline.getIndexOfPeriod(obj);
                if (indexOfPeriod != -1) {
                    if (player.getCurrentMediaItemIndex() == currentTimeline.getPeriod(indexOfPeriod, period).windowIndex) {
                        return true;
                    }
                }
                this.lastPeriodUidWithTracks = null;
            }
        }
        return false;
    }

    private final boolean hasSelectedVideoTrack(Player player) {
        return player.isCommandAvailable(30) && player.getCurrentTracks().isTypeSelected(2);
    }

    static {
        MediaLibraryInfo.registerModule("media3.ui.compose");
    }
}
