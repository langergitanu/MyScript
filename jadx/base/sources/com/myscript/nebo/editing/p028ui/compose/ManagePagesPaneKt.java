package com.myscript.nebo.editing.p028ui.compose;

import android.content.res.Configuration;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.myscript.nebo.editing.ChildPage;
import com.myscript.nebo.editing.ChildPagesViewModel;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: ManagePagesPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002"}, m1599d2 = {"ManagePagesPane", "", "viewModel", "Lcom/myscript/nebo/editing/ChildPagesViewModel;", "onPageClick", "Lkotlin/Function1;", "Lcom/myscript/nebo/editing/ChildPage;", "onLongPageClick", "onThumbnailRequest", "(Lcom/myscript/nebo/editing/ChildPagesViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_standardRelease", "childPages", "Lkotlinx/collections/immutable/ImmutableList;", "hasDuplicatedIds", ""}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ManagePagesPaneKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ManagePagesPane$lambda$5(ChildPagesViewModel childPagesViewModel, Function1 function1, Function1 function12, Function1 function13, int i, Composer composer, int i2) {
        ManagePagesPane(childPagesViewModel, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ManagePagesPane(final ChildPagesViewModel viewModel, final Function1<? super ChildPage, Unit> onPageClick, final Function1<? super ChildPage, Unit> onLongPageClick, final Function1<? super ChildPage, Unit> onThumbnailRequest, Composer composer, final int i) {
        Composer composer2;
        Modifier.Companion companionM2912heightInVpY3zN4$default;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onPageClick, "onPageClick");
        Intrinsics.checkNotNullParameter(onLongPageClick, "onLongPageClick");
        Intrinsics.checkNotNullParameter(onThumbnailRequest, "onThumbnailRequest");
        Composer composerStartRestartGroup = composer.startRestartGroup(333510519);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ManagePagesPane)N(viewModel,onPageClick,onLongPageClick,onThumbnailRequest)29@1164L7,32@1275L34,40@1787L135,59@2392L434,47@1988L844:ManagePagesPane.kt#a4olte");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPageClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onLongPageClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onThumbnailRequest) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(333510519, i2, -1, "com.myscript.nebo.editing.ui.compose.ManagePagesPane (ManagePagesPane.kt:28)");
            }
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z = C1486Dp.m11016compareTo0680j_4(C1486Dp.m11017constructorimpl((float) ((Configuration) objConsume).screenWidthDp), C1486Dp.m11017constructorimpl((float) 600)) < 0;
            final State stateObserveAsState = LiveDataAdapterKt.observeAsState(viewModel.getChildPages(), ExtensionsKt.persistentListOf(), composerStartRestartGroup, 48);
            ImmutableList<ChildPage> immutableListManagePagesPane$lambda$0 = ManagePagesPane$lambda$0(stateObserveAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1618911106, "CC(remember):ManagePagesPane.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(immutableListManagePagesPane$lambda$0);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                ImmutableList<ChildPage> immutableListManagePagesPane$lambda$02 = ManagePagesPane$lambda$0(stateObserveAsState);
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (ChildPage childPage : immutableListManagePagesPane$lambda$02) {
                    if (hashSet.add(childPage.getId())) {
                        arrayList.add(childPage);
                    }
                }
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(arrayList.size() != ManagePagesPane$lambda$0(stateObserveAsState).size()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ManagePagesPaneKt$ManagePagesPane$key$1 managePagesPaneKt$ManagePagesPane$key$1 = new PropertyReference1Impl() { // from class: com.myscript.nebo.editing.ui.compose.ManagePagesPaneKt$ManagePagesPane$key$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((ChildPage) obj).getId();
                }
            };
            if (ManagePagesPane$lambda$2((MutableState) objRememberedValue)) {
                managePagesPaneKt$ManagePagesPane$key$1 = null;
            }
            final ManagePagesPaneKt$ManagePagesPane$key$1 managePagesPaneKt$ManagePagesPane$key$12 = managePagesPaneKt$ManagePagesPane$key$1;
            if (z) {
                companionM2912heightInVpY3zN4$default = Modifier.INSTANCE;
            } else {
                companionM2912heightInVpY3zN4$default = SizeKt.m2912heightInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(620), 1, null);
            }
            Modifier modifier = companionM2912heightInVpY3zN4$default;
            GridCells.Adaptive adaptive = new GridCells.Adaptive(C1486Dp.m11017constructorimpl(128), null);
            PaddingValues paddingValuesM2847PaddingValues0680j_4 = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(12));
            float f = 48;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_42 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            GridCells.Adaptive adaptive2 = adaptive;
            Arrangement.HorizontalOrVertical horizontalOrVertical = horizontalOrVerticalM2528spacedBy0680j_42;
            Arrangement.HorizontalOrVertical horizontalOrVertical2 = horizontalOrVerticalM2528spacedBy0680j_4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1618891447, "CC(remember):ManagePagesPane.kt#9igjgp");
            boolean zChanged2 = ((i2 & 112) == 32) | composerStartRestartGroup.changed(stateObserveAsState) | composerStartRestartGroup.changedInstance(managePagesPaneKt$ManagePagesPane$key$12) | ((i2 & 896) == 256) | ((i2 & 7168) == 2048);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ManagePagesPaneKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ManagePagesPaneKt.ManagePagesPane$lambda$4$0(managePagesPaneKt$ManagePagesPane$key$12, stateObserveAsState, onPageClick, onLongPageClick, onThumbnailRequest, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyGridDslKt.LazyVerticalGrid(adaptive2, modifier, null, paddingValuesM2847PaddingValues0680j_4, false, horizontalOrVertical, horizontalOrVertical2, null, false, null, (Function1) objRememberedValue2, composer2, 1772544, 0, 916);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ManagePagesPaneKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ManagePagesPaneKt.ManagePagesPane$lambda$5(viewModel, onPageClick, onLongPageClick, onThumbnailRequest, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ManagePagesPane$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ManagePagesPane$lambda$4$0(KProperty1 kProperty1, State state, final Function1 function1, final Function1 function12, final Function1 function13, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        final ImmutableList<ChildPage> immutableListManagePagesPane$lambda$0 = ManagePagesPane$lambda$0(state);
        final KProperty1 kProperty12 = kProperty1;
        final C6451xe4f849fd c6451xe4f849fd = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ManagePagesPaneKt$ManagePagesPane$lambda$4$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(ChildPage childPage) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((ChildPage) obj);
            }
        };
        LazyVerticalGrid.items(immutableListManagePagesPane$lambda$0.size(), kProperty12 != null ? new Function1<Integer, Object>() { // from class: com.myscript.nebo.editing.ui.compose.ManagePagesPaneKt$ManagePagesPane$lambda$4$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return kProperty12.invoke(immutableListManagePagesPane$lambda$0.get(i));
            }
        } : null, null, new Function1<Integer, Object>() { // from class: com.myscript.nebo.editing.ui.compose.ManagePagesPaneKt$ManagePagesPane$lambda$4$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return c6451xe4f849fd.invoke(immutableListManagePagesPane$lambda$0.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.myscript.nebo.editing.ui.compose.ManagePagesPaneKt$ManagePagesPane$lambda$4$0$$inlined$items$default$5
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
                if ((i2 & 6) == 0) {
                    i3 = i2 | (composer.changed(lazyGridItemScope) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1117249557, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                }
                ChildPage childPage = (ChildPage) immutableListManagePagesPane$lambda$0.get(i);
                composer.startReplaceGroup(-1227583639);
                ComposerKt.sourceInformation(composer, "CN(childPage)*64@2520L282:ManagePagesPane.kt#a4olte");
                ChildPagesPaneKt.ChildPageItem(true, childPage, function1, function12, null, null, null, null, null, null, null, null, null, function13, null, composer, 6, 0, 24560);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    private static final ImmutableList<ChildPage> ManagePagesPane$lambda$0(State<? extends ImmutableList<ChildPage>> state) {
        return state.getValue();
    }
}
