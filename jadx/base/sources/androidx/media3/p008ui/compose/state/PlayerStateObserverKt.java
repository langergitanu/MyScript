package androidx.media3.p008ui.compose.state;

import androidx.media3.common.Player;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerStateObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00020\u0006\"\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bH\u0007¨\u0006\n"}, m1599d2 = {"observeState", "Landroidx/media3/ui/compose/state/PlayerStateObserver;", "Landroidx/media3/common/Player;", "firstEvent", "", "otherEvents", "", "stateUpdater", "Lkotlin/Function1;", "", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PlayerStateObserverKt {
    public static final PlayerStateObserver observeState(Player player, int i, int[] otherEvents, Function1<? super Player, Unit> stateUpdater) {
        Intrinsics.checkNotNullParameter(player, "<this>");
        Intrinsics.checkNotNullParameter(otherEvents, "otherEvents");
        Intrinsics.checkNotNullParameter(stateUpdater, "stateUpdater");
        return new PlayerStateObserver(player, i, Arrays.copyOf(otherEvents, otherEvents.length), stateUpdater);
    }
}
