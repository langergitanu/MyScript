package androidx.media3.p008ui.compose;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.p008ui.compose.modifiers.ExtensionsKt;
import androidx.media3.p008ui.compose.state.PresentationState;
import androidx.media3.p008ui.compose.state.PresentationStateKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ContentFrame.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"ContentFrame", "", "player", "Landroidx/media3/common/Player;", "modifier", "Landroidx/compose/ui/Modifier;", "surfaceType", "", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "keepContentOnReset", "", "shutter", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/media3/common/Player;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/layout/ContentScale;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ContentFrameKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentFrame$lambda$0(Player player, Modifier modifier, int i, ContentScale contentScale, boolean z, Function2 function2, int i2, int i3, Composer composer, int i4) {
        ContentFrame(player, modifier, i, contentScale, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContentFrame(final Player player, Modifier modifier, int i, ContentScale contentScale, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        int i7;
        ContentScale fit;
        int i8;
        boolean z2;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final int i10;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function2M11709getLambda1$lib_ui_compose_release;
        PresentationState presentationStateRememberPresentationState;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(2125407251);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContentFrame)P(3,2,5)58@2591L53,59@2677L67,64@3034L50,67@3130L9:ContentFrame.kt#gavle6");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(player) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 256 : 128;
                }
                i7 = i3 & 8;
                if (i7 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        fit = contentScale;
                        i4 |= composerStartRestartGroup.changed(fit) ? 2048 : 1024;
                    }
                    i8 = i3 & 16;
                    if (i8 == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            z2 = z;
                            i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
                        }
                        i9 = i3 & 32;
                        if (i9 == 0) {
                            if ((196608 & i2) == 0) {
                                function22 = function2;
                                i4 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
                            }
                            if ((74899 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i11 == 0 ? Modifier.INSTANCE : modifier2;
                                i10 = i5 == 0 ? 1 : i6;
                                if (i7 != 0) {
                                    fit = ContentScale.INSTANCE.getFit();
                                }
                                z3 = i8 == 0 ? false : z2;
                                function2M11709getLambda1$lib_ui_compose_release = i9 == 0 ? ComposableSingletons$ContentFrameKt.INSTANCE.m11709getLambda1$lib_ui_compose_release() : function22;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2125407251, i4, -1, "androidx.media3.ui.compose.ContentFrame (ContentFrame.kt:57)");
                                }
                                presentationStateRememberPresentationState = PresentationStateKt.rememberPresentationState(player, z3, composerStartRestartGroup, (i4 & 14) | ((i4 >> 9) & 112), 0);
                                Modifier modifier4 = companion;
                                PlayerSurfaceKt.PlayerSurface(player, ExtensionsKt.m11722resizeWithContentScaleXrYQPog(modifier4, fit, presentationStateRememberPresentationState.m11726getVideoSizeDpVsRJwc0(), null, composerStartRestartGroup, ((i4 >> 3) & 14) | ((i4 >> 6) & 112), 4), i10, composerStartRestartGroup, i4 & 910, 0);
                                if (presentationStateRememberPresentationState.getCoverSurface()) {
                                    function2M11709getLambda1$lib_ui_compose_release.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 15) & 14));
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                i10 = i6;
                                z3 = z2;
                                function2M11709getLambda1$lib_ui_compose_release = function22;
                            }
                            final ContentScale contentScale2 = fit;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.media3.ui.compose.ContentFrameKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ContentFrameKt.ContentFrame$lambda$0(player, modifier3, i10, contentScale2, z3, function2M11709getLambda1$lib_ui_compose_release, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        function22 = function2;
                        if ((74899 & i4) == 74898) {
                            if (i11 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 == 0) {
                            }
                            if (i9 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            presentationStateRememberPresentationState = PresentationStateKt.rememberPresentationState(player, z3, composerStartRestartGroup, (i4 & 14) | ((i4 >> 9) & 112), 0);
                            Modifier modifier42 = companion;
                            PlayerSurfaceKt.PlayerSurface(player, ExtensionsKt.m11722resizeWithContentScaleXrYQPog(modifier42, fit, presentationStateRememberPresentationState.m11726getVideoSizeDpVsRJwc0(), null, composerStartRestartGroup, ((i4 >> 3) & 14) | ((i4 >> 6) & 112), 4), i10, composerStartRestartGroup, i4 & 910, 0);
                            if (presentationStateRememberPresentationState.getCoverSurface()) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                        }
                        final ContentScale contentScale22 = fit;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z2 = z;
                    i9 = i3 & 32;
                    if (i9 == 0) {
                    }
                    function22 = function2;
                    if ((74899 & i4) == 74898) {
                    }
                    final ContentScale contentScale222 = fit;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                fit = contentScale;
                i8 = i3 & 16;
                if (i8 == 0) {
                }
                z2 = z;
                i9 = i3 & 32;
                if (i9 == 0) {
                }
                function22 = function2;
                if ((74899 & i4) == 74898) {
                }
                final ContentScale contentScale2222 = fit;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i6 = i;
            i7 = i3 & 8;
            if (i7 != 0) {
            }
            fit = contentScale;
            i8 = i3 & 16;
            if (i8 == 0) {
            }
            z2 = z;
            i9 = i3 & 32;
            if (i9 == 0) {
            }
            function22 = function2;
            if ((74899 & i4) == 74898) {
            }
            final ContentScale contentScale22222 = fit;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        i6 = i;
        i7 = i3 & 8;
        if (i7 != 0) {
        }
        fit = contentScale;
        i8 = i3 & 16;
        if (i8 == 0) {
        }
        z2 = z;
        i9 = i3 & 32;
        if (i9 == 0) {
        }
        function22 = function2;
        if ((74899 & i4) == 74898) {
        }
        final ContentScale contentScale222222 = fit;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
