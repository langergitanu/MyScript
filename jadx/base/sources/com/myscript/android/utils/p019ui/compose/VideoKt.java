package com.myscript.android.utils.p019ui.compose;

import android.content.Context;
import android.net.Uri;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.p008ui.compose.PlayerSurfaceKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Video.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Video", "", "videoUri", "Landroid/net/Uri;", "modifier", "Landroidx/compose/ui/Modifier;", "enableClipping", "", "(Landroid/net/Uri;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class VideoKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Video$lambda$2(Uri uri, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        Video(uri, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void Video(final Uri videoUri, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final boolean z2;
        Intrinsics.checkNotNullParameter(videoUri, "videoUri");
        Composer composerStartRestartGroup = composer.startRestartGroup(1745851243);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Video)N(videoUri,modifier,enableClipping)30@1162L7,32@1191L336,43@1533L305,50@1867L123,50@1844L146:Video.kt#vd5fha");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(videoUri) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            z2 = z;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            z2 = i5 != 0 ? false : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1745851243, i3, -1, "com.myscript.android.utils.ui.compose.Video (Video.kt:29)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1569162597, "CC(remember):Video.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(context).build();
                exoPlayerBuild.setMediaItem(MediaItem.fromUri(videoUri));
                exoPlayerBuild.setVideoScalingMode(2);
                exoPlayerBuild.setRepeatMode(1);
                exoPlayerBuild.setPlayWhenReady(true);
                exoPlayerBuild.prepare();
                composerStartRestartGroup.updateRememberedValue(exoPlayerBuild);
                obj = exoPlayerBuild;
            }
            final ExoPlayer exoPlayer = (ExoPlayer) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(exoPlayer);
            Modifier modifier3 = modifier;
            PlayerSurfaceKt.PlayerSurface(exoPlayer, modifier3, z2 ? 2 : 1, composerStartRestartGroup, i3 & 112, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1569141178, "CC(remember):Video.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(exoPlayer);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.android.utils.ui.compose.VideoKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return VideoKt.Video$lambda$1$0(exoPlayer, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.android.utils.ui.compose.VideoKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return VideoKt.Video$lambda$2(videoUri, modifier2, z2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult Video$lambda$1$0(final ExoPlayer exoPlayer, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.myscript.android.utils.ui.compose.VideoKt$Video$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                exoPlayer.release();
            }
        };
    }
}
