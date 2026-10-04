package androidx.media3.p008ui.compose;

import android.view.View;
import androidx.media3.common.Player;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PlayerSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1", m1609f = "PlayerSurface.kt", m1610i = {}, m1611l = {175}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Player, T, Unit> $clearVideoView;
    final /* synthetic */ Player $player;
    final /* synthetic */ Function2<Player, T, Unit> $setVideoView;

    /* JADX INFO: Incorrect field signature: TT; */
    final /* synthetic */ View $view;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Landroidx/media3/common/Player;TT;Lkotlin/jvm/functions/Function2<-Landroidx/media3/common/Player;-TT;Lkotlin/Unit;>;Lkotlin/jvm/functions/Function2<-Landroidx/media3/common/Player;-TT;Lkotlin/Unit;>;Lkotlin/coroutines/Continuation<-Landroidx/media3/ui/compose/PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1;>;)V */
    PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1(Player player, View view, Function2 function2, Function2 function22, Continuation continuation) {
        super(2, continuation);
        this.$player = player;
        this.$view = view;
        this.$setVideoView = function2;
        this.$clearVideoView = function22;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1(this.$player, this.$view, this.$setVideoView, this.$clearVideoView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$player != null) {
                Player attachedPlayer = PlayerSurfaceKt.getAttachedPlayer(this.$view);
                if (attachedPlayer != null) {
                    Player player = this.$player;
                    Function2<Player, T, Unit> function2 = this.$clearVideoView;
                    View view = this.$view;
                    if (!Intrinsics.areEqual(attachedPlayer, player) && attachedPlayer.isCommandAvailable(27)) {
                        function2.invoke(attachedPlayer, (T) view);
                    }
                }
                if (this.$player.isCommandAvailable(27)) {
                    this.$setVideoView.invoke(this.$player, (T) this.$view);
                    PlayerSurfaceKt.setAttachedPlayer(this.$view, this.$player);
                }
            } else {
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C24722(this.$view, this.$clearVideoView, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1$2 */
    /* JADX INFO: compiled from: PlayerSurface.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1$2", m1609f = "PlayerSurface.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C24722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Player, T, Unit> $clearVideoView;

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ View $view;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/jvm/functions/Function2<-Landroidx/media3/common/Player;-TT;Lkotlin/Unit;>;Lkotlin/coroutines/Continuation<-Landroidx/media3/ui/compose/PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1$2;>;)V */
        C24722(View view, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$view = view;
            this.$clearVideoView = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24722(this.$view, this.$clearVideoView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Player attachedPlayer = PlayerSurfaceKt.getAttachedPlayer(this.$view);
                if (attachedPlayer != null) {
                    Function2<Player, T, Unit> function2 = this.$clearVideoView;
                    View view = this.$view;
                    if (attachedPlayer.isCommandAvailable(27)) {
                        function2.invoke(attachedPlayer, (T) view);
                    }
                    PlayerSurfaceKt.setAttachedPlayer(view, null);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
