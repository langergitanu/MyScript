package androidx.media3.p008ui.compose;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.SurfaceView;
import android.view.View;
import android.window.SurfaceSyncGroup;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PlayerSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0091\u0001\u0010\t\u001a\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\n0\r2\u001d\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u00112\u001d\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u00112\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0002\u0010\u0014\",\u0010\u0015\u001a\u0004\u0018\u00010\u0003*\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\"\u0010\u0010\u001a\u001a\u00020\u00078\u0006X\u0087T¢\u0006\u0002\n\u0000\"\u0010\u0010\u001b\u001a\u00020\u00078\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u001c²\u0006\f\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u008a\u008e\u0002²\u0006\u0016\u0010\u001f\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u000bX\u008a\u008e\u0002"}, m1599d2 = {"PlayerSurface", "", "player", "Landroidx/media3/common/Player;", "modifier", "Landroidx/compose/ui/Modifier;", "surfaceType", "", "(Landroidx/media3/common/Player;Landroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "PlayerSurfaceInternal", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "createView", "Lkotlin/Function1;", "Landroid/content/Context;", "setVideoView", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "clearVideoView", "onSurfaceSizeChanged", "(Landroidx/media3/common/Player;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "attachedPlayer", "getAttachedPlayer", "(Landroid/view/View;)Landroidx/media3/common/Player;", "setAttachedPlayer", "(Landroid/view/View;Landroidx/media3/common/Player;)V", "SURFACE_TYPE_SURFACE_VIEW", "SURFACE_TYPE_TEXTURE_VIEW", "lib-ui-compose_release", "surfaceSyncGroup", "Landroid/window/SurfaceSyncGroup;", "view"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PlayerSurfaceKt {
    public static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    public static final int SURFACE_TYPE_TEXTURE_VIEW = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayerSurface$lambda$12(Player player, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        PlayerSurface(player, modifier, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayerSurfaceInternal$lambda$31(Player player, Modifier modifier, Function1 function1, Function2 function2, Function2 function22, Function1 function12, int i, int i2, Composer composer, int i3) {
        PlayerSurfaceInternal(player, modifier, function1, function2, function22, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PlayerSurface(final Player player, Modifier modifier, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        int i7;
        Modifier modifier3;
        final Modifier modifier4;
        final int i8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(12998269);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlayerSurface)P(1):PlayerSurface.kt#gavle6");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(player) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 256 : 128;
                }
                if ((i4 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
                    Modifier.Companion companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                    i7 = i5 == 0 ? 1 : i6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(12998269, i4, -1, "androidx.media3.ui.compose.PlayerSurface (PlayerSurface.kt:63)");
                    }
                    if (i7 != 1) {
                        modifier3 = companion;
                        composerStartRestartGroup.startReplaceGroup(-1232449568);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@2390L33,68@2481L308,80@2818L24,81@2899L843,105@3870L27,106@3924L29,101@3750L265");
                        composerStartRestartGroup.startReplaceGroup(-316851119);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final MutableState mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-316847932);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return PlayerSurfaceKt.PlayerSurface$lambda$4$lambda$3(mutableState, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function1 = (Function1) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            objRememberedValue3 = compositionScopedCoroutineScopeCanceller;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.startReplaceGroup(-316834021);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope);
                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return PlayerSurfaceKt.PlayerSurface$lambda$6$lambda$5(coroutineScope, mutableState, (SurfaceView) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function12 = (Function1) objRememberedValue4;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-316803765);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        PlayerSurfaceKt$PlayerSurface$1$1 playerSurfaceKt$PlayerSurface$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (playerSurfaceKt$PlayerSurface$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            playerSurfaceKt$PlayerSurface$1$1RememberedValue = PlayerSurfaceKt$PlayerSurface$1$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(playerSurfaceKt$PlayerSurface$1$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Function2 function2 = (Function2) ((KFunction) playerSurfaceKt$PlayerSurface$1$1RememberedValue);
                        composerStartRestartGroup.startReplaceGroup(-316802035);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        PlayerSurfaceKt$PlayerSurface$2$1 playerSurfaceKt$PlayerSurface$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (playerSurfaceKt$PlayerSurface$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            playerSurfaceKt$PlayerSurface$2$1RememberedValue = PlayerSurfaceKt$PlayerSurface$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(playerSurfaceKt$PlayerSurface$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        PlayerSurfaceInternal(player, modifier3, function1, function2, (Function2) ((KFunction) playerSurfaceKt$PlayerSurface$2$1RememberedValue), function12, composerStartRestartGroup, (i4 & 14) | 28032 | (i4 & 112), 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (i7 == 2) {
                        composerStartRestartGroup.startReplaceGroup(-316797472);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "114@4139L13,115@4177L27,116@4231L29,111@4061L208");
                        composerStartRestartGroup.startReplaceGroup(-316795171);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        PlayerSurfaceKt$PlayerSurface$3$1 playerSurfaceKt$PlayerSurface$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (playerSurfaceKt$PlayerSurface$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            playerSurfaceKt$PlayerSurface$3$1RememberedValue = PlayerSurfaceKt$PlayerSurface$3$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(playerSurfaceKt$PlayerSurface$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Function1 function13 = (Function1) ((KFunction) playerSurfaceKt$PlayerSurface$3$1RememberedValue);
                        composerStartRestartGroup.startReplaceGroup(-316793941);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        PlayerSurfaceKt$PlayerSurface$4$1 playerSurfaceKt$PlayerSurface$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (playerSurfaceKt$PlayerSurface$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            playerSurfaceKt$PlayerSurface$4$1RememberedValue = PlayerSurfaceKt$PlayerSurface$4$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(playerSurfaceKt$PlayerSurface$4$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Function2 function22 = (Function2) ((KFunction) playerSurfaceKt$PlayerSurface$4$1RememberedValue);
                        composerStartRestartGroup.startReplaceGroup(-316792211);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        PlayerSurfaceKt$PlayerSurface$5$1 playerSurfaceKt$PlayerSurface$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (playerSurfaceKt$PlayerSurface$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            playerSurfaceKt$PlayerSurface$5$1RememberedValue = PlayerSurfaceKt$PlayerSurface$5$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(playerSurfaceKt$PlayerSurface$5$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        modifier3 = companion;
                        PlayerSurfaceInternal(player, modifier3, function13, function22, (Function2) ((KFunction) playerSurfaceKt$PlayerSurface$5$1RememberedValue), null, composerStartRestartGroup, (i4 & 14) | 28032 | (i4 & 112), 32);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-316790535);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new IllegalArgumentException("Unrecognized surface type: " + i7);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    i8 = i7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    i8 = i6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PlayerSurfaceKt.PlayerSurface$lambda$12(player, modifier4, i8, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            i6 = i;
            if ((i4 & 147) != 146) {
                if (i9 == 0) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (i7 != 1) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                i8 = i7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 != 0) {
        }
        i6 = i;
        if ((i4 & 147) != 146) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurfaceSyncGroup PlayerSurface$lambda$1(MutableState<SurfaceSyncGroup> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurface$createSurfaceView$1$1$1] */
    public static final PlayerSurfaceKt$PlayerSurface$createSurfaceView$1$1$1 PlayerSurface$lambda$4$lambda$3(final MutableState mutableState, final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SurfaceView(context) { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurface$createSurfaceView$1$1$1
            @Override // android.view.SurfaceView, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                super.dispatchDraw(canvas);
                if (Build.VERSION.SDK_INT == 34) {
                    SurfaceSyncGroup surfaceSyncGroupPlayerSurface$lambda$1 = PlayerSurfaceKt.PlayerSurface$lambda$1(mutableState);
                    if (surfaceSyncGroupPlayerSurface$lambda$1 != null) {
                        surfaceSyncGroupPlayerSurface$lambda$1.markSyncReady();
                    }
                    mutableState.setValue(null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayerSurface$lambda$6$lambda$5(CoroutineScope coroutineScope, MutableState mutableState, SurfaceView surfaceView) {
        Intrinsics.checkNotNullParameter(surfaceView, "surfaceView");
        if (Build.VERSION.SDK_INT == 34 && !StringsKt.equals(Build.FINGERPRINT, "robolectric", true)) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new PlayerSurfaceKt$PlayerSurface$onSurfaceSizeChanged$1$1$1(surfaceView, mutableState, null), 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayerSurfaceInternal$lambda$14$lambda$13(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final <T extends View> void PlayerSurfaceInternal(final Player player, final Modifier modifier, final Function1<? super Context, ? extends T> function1, final Function2<? super Player, ? super T, Unit> function2, final Function2<? super Player, ? super T, Unit> function22, Function1<? super T, Unit> function12, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Function2<? super Player, ? super T, Unit> function23;
        int i4;
        Function1<? super T, Unit> function13;
        Function1<? super T, Unit> function14;
        Object objRememberedValue;
        boolean z;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        final View viewPlayerSurfaceInternal$lambda$16;
        View view;
        Function1<? super T, Unit> function15;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(25948461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PlayerSurfaceInternal)P(4,2,1,5)129@4604L2,131@4626L37,135@4719L18,136@4753L2,137@4770L13,133@4667L121,*141@4847L374,141@4816L405,155@5256L1148,155@5227L1177:PlayerSurface.kt#gavle6");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(player) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                function23 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function23) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
                }
                i4 = i2 & 32;
                if (i4 == 0) {
                    if ((196608 & i) == 0) {
                        function13 = function12;
                        i3 |= composerStartRestartGroup.changedInstance(function13) ? 131072 : 65536;
                    }
                    if ((i3 & 74899) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        if (i4 == 0) {
                            composerStartRestartGroup.startReplaceGroup(-1838626673);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return PlayerSurfaceKt.PlayerSurfaceInternal$lambda$14$lambda$13((View) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function14 = (Function1) objRememberedValue5;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            function14 = function13;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(25948461, i3, -1, "androidx.media3.ui.compose.PlayerSurfaceInternal (PlayerSurface.kt:130)");
                        }
                        composerStartRestartGroup.startReplaceGroup(-1838625934);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final MutableState mutableState = (MutableState) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1838622977);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        z = (i3 & 896) != 256;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return PlayerSurfaceKt.PlayerSurfaceInternal$lambda$19$lambda$18(function1, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function16 = (Function1) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1838621905);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return PlayerSurfaceKt.PlayerSurfaceInternal$lambda$21$lambda$20((View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function1 function17 = (Function1) objRememberedValue3;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1838621350);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return PlayerSurfaceKt.PlayerSurfaceInternal$lambda$23$lambda$22(mutableState, (View) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function1<? super T, Unit> function18 = function14;
                        AndroidView_androidKt.AndroidView(function16, modifier2, function17, null, (Function1) objRememberedValue4, composerStartRestartGroup, (i3 & 112) | 24960, 8);
                        viewPlayerSurfaceInternal$lambda$16 = PlayerSurfaceInternal$lambda$16(mutableState);
                        if (viewPlayerSurfaceInternal$lambda$16 != null) {
                            function15 = function18;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-898367774);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                            boolean zChangedInstance = composerStartRestartGroup.changedInstance(player) | ((458752 & i3) == 131072) | composerStartRestartGroup.changedInstance(viewPlayerSurfaceInternal$lambda$16);
                            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return PlayerSurfaceKt.PlayerSurfaceInternal$lambda$30$lambda$28$lambda$27(player, function18, viewPlayerSurfaceInternal$lambda$16, (DisposableEffectScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            int i5 = (i3 << 3) & 112;
                            EffectsKt.DisposableEffect(viewPlayerSurfaceInternal$lambda$16, player, (Function1) objRememberedValue6, composerStartRestartGroup, i5);
                            composerStartRestartGroup.startReplaceGroup(-898353912);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(player) | composerStartRestartGroup.changedInstance(viewPlayerSurfaceInternal$lambda$16) | ((57344 & i3) == 16384) | ((i3 & 7168) == 2048);
                            PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1 playerSurfaceKt$PlayerSurfaceInternal$5$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance2 || playerSurfaceKt$PlayerSurfaceInternal$5$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                view = viewPlayerSurfaceInternal$lambda$16;
                                function15 = function18;
                                playerSurfaceKt$PlayerSurfaceInternal$5$2$1RememberedValue = new PlayerSurfaceKt$PlayerSurfaceInternal$5$2$1(player, view, function23, function22, null);
                                composerStartRestartGroup.updateRememberedValue(playerSurfaceKt$PlayerSurfaceInternal$5$2$1RememberedValue);
                            } else {
                                view = viewPlayerSurfaceInternal$lambda$16;
                                function15 = function18;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(view, player, (Function2) playerSurfaceKt$PlayerSurfaceInternal$5$2$1RememberedValue, composerStartRestartGroup, i5);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function13 = function15;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final Function1<? super T, Unit> function19 = function13;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PlayerSurfaceKt.PlayerSurfaceInternal$lambda$31(player, modifier, function1, function2, function22, function19, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                function13 = function12;
                if ((i3 & 74899) == 74898) {
                    if (i4 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.startReplaceGroup(-1838625934);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableState mutableState2 = (MutableState) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1838622977);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                    if ((i3 & 896) != 256) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue2 = new Function1() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PlayerSurfaceKt.PlayerSurfaceInternal$lambda$19$lambda$18(function1, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        Function1 function162 = (Function1) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1838621905);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        Function1 function172 = (Function1) objRememberedValue3;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1838621350);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PlayerSurface.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function1 function182 = function14;
                        AndroidView_androidKt.AndroidView(function162, modifier2, function172, null, (Function1) objRememberedValue4, composerStartRestartGroup, (i3 & 112) | 24960, 8);
                        viewPlayerSurfaceInternal$lambda$16 = PlayerSurfaceInternal$lambda$16(mutableState2);
                        if (viewPlayerSurfaceInternal$lambda$16 != null) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function13 = function15;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i4 = i2 & 32;
            if (i4 == 0) {
            }
            function13 = function12;
            if ((i3 & 74899) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function23 = function2;
        if ((i2 & 16) == 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        function13 = function12;
        if ((i3 & 74899) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final <T extends View> T PlayerSurfaceInternal$lambda$16(MutableState<T> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View PlayerSurfaceInternal$lambda$19$lambda$18(Function1 function1, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (View) function1.invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayerSurfaceInternal$lambda$21$lambda$20(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayerSurfaceInternal$lambda$23$lambda$22(MutableState mutableState, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final DisposableEffectResult PlayerSurfaceInternal$lambda$30$lambda$28$lambda$27(final Player player, final Function1 function1, final View view, DisposableEffectScope DisposableEffect) {
        final PlayerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$1 playerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$1;
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (player != null) {
            Player.Listener listener = new Player.Listener() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$1
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // androidx.media3.common.Player.Listener
                public void onSurfaceSizeChanged(int width, int height) {
                    function1.invoke((T) view);
                }
            };
            player.addListener(listener);
            playerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$1 = listener;
        } else {
            playerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$1 = 0;
        }
        return new DisposableEffectResult() { // from class: androidx.media3.ui.compose.PlayerSurfaceKt$PlayerSurfaceInternal$lambda$30$lambda$28$lambda$27$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Player player2;
                PlayerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$1 playerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$12 = playerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$1;
                if (playerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$12 == null || (player2 = player) == null) {
                    return;
                }
                player2.removeListener(playerSurfaceKt$PlayerSurfaceInternal$5$1$1$listener$12);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Player getAttachedPlayer(View view) {
        Object tag = view.getTag();
        if (tag instanceof Player) {
            return (Player) tag;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAttachedPlayer(View view, Player player) {
        view.setTag(player);
    }
}
