package androidx.media3.p008ui.compose.state;

import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.Player;
import androidx.media3.common.PlayerExtensionsKt;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerStateObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00020\u0007\"\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Landroidx/media3/ui/compose/state/PlayerStateObserver;", "", "player", "Landroidx/media3/common/Player;", "firstEvent", "", "otherEvents", "", "stateUpdater", "Lkotlin/Function1;", "", "<init>", "(Landroidx/media3/common/Player;I[ILkotlin/jvm/functions/Function1;)V", "otherEventsArray", "observe", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "lib-ui-compose_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PlayerStateObserver {
    private final int firstEvent;
    private final int[] otherEventsArray;
    private final Player player;
    private final Function1<Player, Unit> stateUpdater;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.media3.ui.compose.state.PlayerStateObserver$observe$1 */
    /* JADX INFO: compiled from: PlayerStateObserver.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "androidx.media3.ui.compose.state.PlayerStateObserver", m1609f = "PlayerStateObserver.kt", m1610i = {}, m1611l = {49}, m1612m = "observe", m1613n = {}, m1615s = {})
    static final class C24791 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C24791(Continuation<? super C24791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayerStateObserver.this.observe(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerStateObserver(Player player, int i, int[] otherEvents, Function1<? super Player, Unit> stateUpdater) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(otherEvents, "otherEvents");
        Intrinsics.checkNotNullParameter(stateUpdater, "stateUpdater");
        this.player = player;
        this.firstEvent = i;
        this.stateUpdater = stateUpdater;
        this.otherEventsArray = otherEvents;
        stateUpdater.invoke(player);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observe(Continuation<?> continuation) {
        C24791 c24791;
        if (continuation instanceof C24791) {
            c24791 = (C24791) continuation;
            if ((c24791.label & Integer.MIN_VALUE) != 0) {
                c24791.label -= Integer.MIN_VALUE;
            } else {
                c24791 = new C24791(continuation);
            }
        }
        Object obj = c24791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c24791.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.stateUpdater.invoke(this.player);
            Player player = this.player;
            int i2 = this.firstEvent;
            int[] iArr = this.otherEventsArray;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            Function2 function2 = new Function2() { // from class: androidx.media3.ui.compose.state.PlayerStateObserver$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PlayerStateObserver.observe$lambda$0(this.f$0, (Player) obj2, (Player.Events) obj3);
                }
            };
            c24791.label = 1;
            if (PlayerExtensionsKt.listenTo(player, i2, iArrCopyOf, function2, c24791) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$0(PlayerStateObserver playerStateObserver, Player listenTo, Player.Events it) {
        Intrinsics.checkNotNullParameter(listenTo, "$this$listenTo");
        Intrinsics.checkNotNullParameter(it, "it");
        playerStateObserver.stateUpdater.invoke(playerStateObserver.player);
        return Unit.INSTANCE;
    }

    static {
        MediaLibraryInfo.registerModule("media3.ui.compose");
    }
}
