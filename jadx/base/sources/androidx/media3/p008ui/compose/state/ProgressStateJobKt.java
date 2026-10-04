package androidx.media3.p008ui.compose.state;

import androidx.media3.common.C2181C;
import androidx.media3.common.Player;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressStateJob.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\"\u0010\u0010\b\u001a\u00020\u00018\u0006X\u0087T¢\u0006\u0002\n\u0000\"\u0016\u0010\t\u001a\u00020\u00018\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"getCurrentPositionMsOrDefault", "", "player", "Landroidx/media3/common/Player;", "getBufferedPositionMsOrDefault", "getDurationMsOrDefault", "isReadyOrBuffering", "", "MIN_UPDATE_INTERVAL_MS", "FALLBACK_UPDATE_INTERVAL_MS", "getFALLBACK_UPDATE_INTERVAL_MS$annotations", "()V", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ProgressStateJobKt {
    public static final long FALLBACK_UPDATE_INTERVAL_MS = 1000;
    public static final long MIN_UPDATE_INTERVAL_MS = 8;

    public static /* synthetic */ void getFALLBACK_UPDATE_INTERVAL_MS$annotations() {
    }

    public static final long getCurrentPositionMsOrDefault(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (player.isCommandAvailable(16)) {
            return player.getCurrentPosition();
        }
        return 0L;
    }

    public static final long getBufferedPositionMsOrDefault(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (player.isCommandAvailable(16)) {
            return player.getBufferedPosition();
        }
        return 0L;
    }

    public static final long getDurationMsOrDefault(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return player.isCommandAvailable(16) ? player.getDuration() : C2181C.TIME_UNSET;
    }

    public static final boolean isReadyOrBuffering(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return player.getPlaybackState() == 3 || player.getPlaybackState() == 2;
    }
}
