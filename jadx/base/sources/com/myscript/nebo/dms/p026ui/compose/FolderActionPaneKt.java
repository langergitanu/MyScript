package com.myscript.nebo.dms.p026ui.compose;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextFieldKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.focus.FocusRequester;
import androidx.compose.p004ui.focus.FocusRequesterModifierKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.TestTagKt;
import androidx.compose.p004ui.res.ColorResources_androidKt;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.semantics.Role;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.p004ui.text.input.VisualTransformation;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import com.myscript.android.utils.ColorExt;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.utils.NameUtils;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.FolderPropertiesValidator;
import com.myscript.nebo.dms.edit_new_folder.FolderEditorAction;
import com.myscript.nebo.dms.edit_new_folder.FolderEditorState;
import com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel;
import com.myscript.nebo.dms.p026ui.compose.components.FadingEdgeModifierKt;
import com.myscript.nebo.dms.p026ui.compose.components.TextualDropdownMenuKt;
import com.myscript.nebo.dms.p026ui.compose.components.TextualDropdownOption;
import com.myscript.snt.core.CollectionKey;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableMap;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: folderActionPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0000\u001am\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0007¢\u0006\u0002\u0010\u000f\u001aY\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\u0010\u0016\u001a1\u0010\u0017\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0018\u001a9\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0004\b\u001f\u0010 \u001aC\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0007¢\u0006\u0004\b*\u0010+\u001a=\u0010,\u001a\u00020\u00032\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010.2\u0006\u0010/\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\u00100\u001a\r\u00101\u001a\u00020\u0003H\u0007¢\u0006\u0002\u00102\u001a\r\u00103\u001a\u00020\u0003H\u0007¢\u0006\u0002\u00102\u001a\r\u00104\u001a\u00020\u0003H\u0007¢\u0006\u0002\u00102\u001a\r\u00105\u001a\u00020\u0003H\u0007¢\u0006\u0002\u00102\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u00066²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dX\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020(X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010:\u001a\u00020;X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020(X\u008a\u0084\u0002"}, m1599d2 = {"FOLDER_NAME_TEXT_FIELD_TAG", "", "FolderActionPane", "", "folderCreationViewModel", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorViewModel;", "onFolderColorChanged", "Lkotlin/Function1;", "", "onFolderNameChanged", "onCollectionChanged", "Lcom/myscript/snt/core/CollectionKey;", "onCreate", "Lkotlin/Function0;", "onDismiss", "(Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FolderActionContent", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "uiState", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorState;", "onCollectionNameChanged", "(Landroidx/compose/foundation/layout/PaddingValues;Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FolderActionBottomBar", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorState;Landroidx/compose/runtime/Composer;I)V", "FolderList", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "folderColors", "", "onFolderColorSelected", "FolderList-3J-VO9M", "(JLjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Folder", "color", "modifier", "Landroidx/compose/ui/Modifier;", "isSelected", "", "size", "Landroidx/compose/ui/unit/Dp;", "onClick", "Folder-L8y2Mks", "(JLandroidx/compose/ui/Modifier;ZFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CollectionSelector", "collections", "Lkotlinx/collections/immutable/ImmutableMap;", "collectionKey", "(Lkotlinx/collections/immutable/ImmutableMap;Lcom/myscript/snt/core/CollectionKey;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FolderCreationPanePreview", "(Landroidx/compose/runtime/Composer;I)V", "FolderPreviewIsSelected", "FolderPreviewNonSelected", "FolderListPreview", "dms_release", "colors", "currentFolderSpacing", "animatedColorPillsSpacing", "animatedAlpha", "", "selectionFeedbackSize"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderActionPaneKt {
    public static final String FOLDER_NAME_TEXT_FIELD_TAG = "folderNameTextField";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionSelector$lambda$3(ImmutableMap immutableMap, CollectionKey collectionKey, Function1 function1, int i, Composer composer, int i2) {
        CollectionSelector(immutableMap, collectionKey, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderActionBottomBar$lambda$1(Function0 function0, Function0 function02, FolderEditorState folderEditorState, int i, Composer composer, int i2) {
        FolderActionBottomBar(function0, function02, folderEditorState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderActionContent$lambda$8(PaddingValues paddingValues, FolderEditorState folderEditorState, Function1 function1, Function1 function12, Function1 function13, int i, Composer composer, int i2) {
        FolderActionContent(paddingValues, folderEditorState, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderActionPane$lambda$4(FolderEditorViewModel folderEditorViewModel, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        FolderActionPane(folderEditorViewModel, function1, function12, function13, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderCreationPanePreview$lambda$6(int i, Composer composer, int i2) {
        FolderCreationPanePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderListPreview$lambda$2(int i, Composer composer, int i2) {
        FolderListPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderList_3J_VO9M$lambda$6(long j, List list, Function1 function1, int i, Composer composer, int i2) {
        m13015FolderList3JVO9M(j, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderPreviewIsSelected$lambda$1(int i, Composer composer, int i2) {
        FolderPreviewIsSelected(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderPreviewNonSelected$lambda$1(int i, Composer composer, int i2) {
        FolderPreviewNonSelected(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Folder_L8y2Mks$lambda$3(long j, Modifier modifier, boolean z, float f, Function0 function0, int i, int i2, Composer composer, int i3) {
        m13014FolderL8y2Mks(j, modifier, z, f, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void FolderActionPane(final FolderEditorViewModel folderCreationViewModel, final Function1<? super Integer, Unit> onFolderColorChanged, final Function1<? super String, Unit> onFolderNameChanged, final Function1<? super CollectionKey, Unit> onCollectionChanged, final Function0<Unit> onCreate, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(folderCreationViewModel, "folderCreationViewModel");
        Intrinsics.checkNotNullParameter(onFolderColorChanged, "onFolderColorChanged");
        Intrinsics.checkNotNullParameter(onFolderNameChanged, "onFolderNameChanged");
        Intrinsics.checkNotNullParameter(onCollectionChanged, "onCollectionChanged");
        Intrinsics.checkNotNullParameter(onCreate, "onCreate");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-94912560);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderActionPane)N(folderCreationViewModel,onFolderColorChanged,onFolderNameChanged,onCollectionChanged,onCreate,onDismiss)85@3963L35,88@4078L142,91@4246L83,93@4331L128,87@4004L455:folderActionPane.kt#3ga04k");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(folderCreationViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFolderColorChanged) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFolderNameChanged) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCollectionChanged) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCreate) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-94912560, i2, -1, "com.myscript.nebo.dms.ui.compose.FolderActionPane (folderActionPane.kt:84)");
            }
            final State stateObserveAsState = LiveDataAdapterKt.observeAsState(folderCreationViewModel.getState(), new FolderEditorState(0, 0, false, null, null, null, 0, null, 255, null), composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4390Scaffold27mzLpw(SizeKt.m2912heightInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(WorkflowTransitionState.SLIDE_DURATION_MS), 1, null), null, ComposableLambdaKt.rememberComposableLambda(-125469739, true, new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderActionPane$lambda$1(stateObserveAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-115699178, true, new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderActionPane$lambda$2(onDismiss, onCreate, stateObserveAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-403639282, true, new Function3() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FolderActionPaneKt.FolderActionPane$lambda$3(onFolderColorChanged, onFolderNameChanged, onCollectionChanged, stateObserveAsState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 3462, 12582912, 131058);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderActionPane$lambda$4(folderCreationViewModel, onFolderColorChanged, onFolderNameChanged, onCollectionChanged, onCreate, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderActionPane$lambda$1(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@4108L40,89@4096L110:folderActionPane.kt#3ga04k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-125469739, i, -1, "com.myscript.nebo.dms.ui.compose.FolderActionPane.<anonymous> (folderActionPane.kt:89)");
            }
            float f = 16;
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(FolderActionPane$lambda$0(state).getDialogTitle(), composer, 0), PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f), 0.0f, 0.0f, 12, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 48, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderActionPane$lambda$2(Function0 function0, Function0 function02, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C92@4264L51:folderActionPane.kt#3ga04k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-115699178, i, -1, "com.myscript.nebo.dms.ui.compose.FolderActionPane.<anonymous> (folderActionPane.kt:92)");
            }
            FolderActionBottomBar(function0, function02, FolderActionPane$lambda$0(state), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderActionPane$lambda$3(Function1 function1, Function1 function12, Function1 function13, State state, PaddingValues padding, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)94@4352L101:folderActionPane.kt#3ga04k");
        if ((i & 6) == 0) {
            i2 = (composer.changed(padding) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-403639282, i2, -1, "com.myscript.nebo.dms.ui.compose.FolderActionPane.<anonymous> (folderActionPane.kt:94)");
            }
            FolderActionContent(padding, FolderActionPane$lambda$0(state), function1, function12, function13, composer, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void FolderActionContent(final PaddingValues padding, final FolderEditorState uiState, final Function1<? super Integer, Unit> onFolderColorChanged, final Function1<? super String, Unit> onFolderNameChanged, final Function1<? super CollectionKey, Unit> onCollectionNameChanged, Composer composer, final int i) {
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(onFolderColorChanged, "onFolderColorChanged");
        Intrinsics.checkNotNullParameter(onFolderNameChanged, "onFolderNameChanged");
        Intrinsics.checkNotNullParameter(onCollectionNameChanged, "onCollectionNameChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1367092665);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderActionContent)N(padding,uiState,onFolderColorChanged,onFolderNameChanged,onCollectionNameChanged)101@4739L55,102@4820L29,103@4885L140,103@4854L171,108@5045L47,119@5523L21,113@5233L1340:folderActionPane.kt#3ga04k");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(padding) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(uiState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFolderColorChanged) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFolderNameChanged) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCollectionNameChanged) ? 16384 : 8192;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1367092665, i3, -1, "com.myscript.nebo.dms.ui.compose.FolderActionContent (folderActionPane.kt:99)");
            }
            String folderName = uiState.getFolderName();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 483950014, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                str = folderName;
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(folderName, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                str = folderName;
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 483952580, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            FocusRequester focusRequester = (FocusRequester) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 483954771, "CC(remember):folderActionPane.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(str);
            FolderActionPaneKt$FolderActionContent$1$1 folderActionPaneKt$FolderActionContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || folderActionPaneKt$FolderActionContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                folderActionPaneKt$FolderActionContent$1$1RememberedValue = new FolderActionPaneKt$FolderActionContent$1$1(focusRequester, mutableState, str, null);
                composerStartRestartGroup.updateRememberedValue(folderActionPaneKt$FolderActionContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(focusRequester, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderActionPaneKt$FolderActionContent$1$1RememberedValue, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 483959798, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (FolderActionContent$lambda$4(mutableState2).isEmpty() && !uiState.getFolderColors().isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(2117962708);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*110@5202L17");
                ImmutableList<Integer> folderColors = uiState.getFolderColors();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(folderColors, 10));
                Iterator<Integer> it = folderColors.iterator();
                while (it.hasNext()) {
                    arrayList.add(Color.m8138boximpl(ColorResources_androidKt.colorResource(it.next().intValue(), composerStartRestartGroup, 0)));
                }
                mutableState2.setValue(arrayList);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(2118030939);
                composerStartRestartGroup.endReplaceGroup();
            }
            float f = 16;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m2856paddingVpY3zN4$default(PaddingKt.padding(Modifier.INSTANCE, padding), C1486Dp.m11017constructorimpl(24), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1404426043, "C121@5562L41,122@5612L99,123@5720L41,131@6161L6,131@6113L85,126@5854L131,124@5770L667,138@6446L121:folderActionPane.kt#3ga04k");
            SpacerKt.Spacer(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), composerStartRestartGroup, 6);
            m13015FolderList3JVO9M(ColorKt.Color(uiState.getFolderColor()), FolderActionContent$lambda$4(mutableState2), onFolderColorChanged, composerStartRestartGroup, i3 & 896);
            SpacerKt.Spacer(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), composerStartRestartGroup, 6);
            TextFieldValue textFieldValue = (TextFieldValue) mutableState.getValue();
            TextFieldColors textFieldColorsM4499textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m4499textFieldColorsdx8h9Zs(0L, 0L, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097147);
            Modifier modifierTestTag = TestTagKt.testTag(FocusRequesterModifierKt.focusRequester(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), focusRequester), FOLDER_NAME_TEXT_FIELD_TAG);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -45295596, "CC(remember):folderActionPane.kt#9igjgp");
            boolean z = (i3 & 7168) == 2048;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderActionPaneKt.FolderActionContent$lambda$7$0$0(mutableState, onFolderNameChanged, (TextFieldValue) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextFieldKt.TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) objRememberedValue4, modifierTestTag, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$FolderActionPaneKt.INSTANCE.getLambda$519803061$dms_release(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, textFieldColorsM4499textFieldColorsdx8h9Zs, composerStartRestartGroup, 1572864, 24576, 507832);
            composerStartRestartGroup = composerStartRestartGroup;
            CollectionSelector(uiState.getCollectionNames(), uiState.getCollectionKey(), onCollectionNameChanged, composerStartRestartGroup, (i3 >> 6) & 896);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderActionContent$lambda$8(padding, uiState, onFolderColorChanged, onFolderNameChanged, onCollectionNameChanged, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<Color> FolderActionContent$lambda$4(MutableState<List<Color>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderActionContent$lambda$7$0$0(MutableState mutableState, Function1 function1, TextFieldValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        mutableState.setValue(value);
        function1.invoke(value.getText());
        return Unit.INSTANCE;
    }

    public static final void FolderActionBottomBar(Function0<Unit> onDismiss, Function0<Unit> onCreate, final FolderEditorState uiState, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final Function0<Unit> function02;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onCreate, "onCreate");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Composer composerStartRestartGroup = composer.startRestartGroup(856678670);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderActionBottomBar)N(onDismiss,onCreate,uiState)144@6694L564:folderActionPane.kt#3ga04k");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onDismiss) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCreate) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(uiState) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            function0 = onDismiss;
            function02 = onCreate;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(856678670, i2, -1, "com.myscript.nebo.dms.ui.compose.FolderActionBottomBar (folderActionPane.kt:143)");
            }
            float f = 16;
            Arrangement.Horizontal horizontalM2529spacedByD5KLDUw = Arrangement.INSTANCE.m2529spacedByD5KLDUw(C1486Dp.m11017constructorimpl(f), Alignment.INSTANCE.getEnd());
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM2529spacedByD5KLDUw, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2855paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -233230498, "C150@6937L118,156@7168L84,153@7064L188:folderActionPane.kt#3ga04k");
            ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$FolderActionPaneKt.INSTANCE.m13003getLambda$305670707$dms_release(), composerStartRestartGroup, (i2 & 14) | 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
            function0 = onDismiss;
            function02 = onCreate;
            ButtonKt.Button(function02, null, uiState.isActionAllowed(), null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(634430266, true, new Function3() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FolderActionPaneKt.FolderActionBottomBar$lambda$0$0(uiState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 805306368, TypedValues.PositionType.TYPE_PERCENT_X);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderActionBottomBar$lambda$1(function0, function02, uiState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderActionBottomBar$lambda$0$0(FolderEditorState folderEditorState, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C157@7194L47,157@7182L60:folderActionPane.kt#3ga04k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(634430266, i, -1, "com.myscript.nebo.dms.ui.compose.FolderActionBottomBar.<anonymous>.<anonymous> (folderActionPane.kt:157)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(folderEditorState.getDialogConfirmTitle(), composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: FolderList-3J-VO9M, reason: not valid java name */
    public static final void m13015FolderList3JVO9M(final long j, final List<Color> folderColors, final Function1<? super Integer, Unit> onFolderColorSelected, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(folderColors, "folderColors");
        Intrinsics.checkNotNullParameter(onFolderColorSelected, "onFolderColorSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(1620060456);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderList)N(selectedColor:c#ui.graphics.Color,folderColors,onFolderColorSelected)165@7440L43,167@7522L186,173@7735L52,173@7714L73,177@7811L23,179@7908L6,182@8092L251,178@7839L504:folderActionPane.kt#3ga04k");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(folderColors) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFolderColorSelected) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1620060456, i3, -1, "com.myscript.nebo.dms.ui.compose.FolderList (folderActionPane.kt:163)");
            }
            float fM11017constructorimpl = C1486Dp.m11017constructorimpl(12);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099942419, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(C1486Dp.m11015boximpl(C1486Dp.m11017constructorimpl(-fM11017constructorimpl)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State<C1486Dp> stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(FolderList_3J_VO9M$lambda$1(mutableState), AnimationSpecKt.spring$default(0.5f, 50.0f, null, 4, null), "folder spacing", null, composerStartRestartGroup, 432, 8);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099951868, "CC(remember):folderActionPane.kt#9igjgp");
            FolderActionPaneKt$FolderList$1$1 folderActionPaneKt$FolderList$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (folderActionPaneKt$FolderList$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                folderActionPaneKt$FolderList$1$1RememberedValue = new FolderActionPaneKt$FolderList$1$1(fM11017constructorimpl, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(folderActionPaneKt$FolderList$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderActionPaneKt$FolderList$1$1RememberedValue, composerStartRestartGroup, 6);
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Modifier modifierM13021fadingEdgesbN7B8ug = FadingEdgeModifierKt.m13021fadingEdgesbN7B8ug(Modifier.INSTANCE, lazyListStateRememberLazyListState, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4207getSurface0d7_KjU(), C1486Dp.m11017constructorimpl(48), Orientation.Horizontal);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(FolderList_3J_VO9M$lambda$3(stateM1892animateDpAsStateAjpBEmI));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2099963491, "CC(remember):folderActionPane.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(folderColors) | ((i3 & 14) == 4) | ((i3 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderActionPaneKt.FolderList_3J_VO9M$lambda$5$0(folderColors, j, onFolderColorSelected, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyRow(modifierM13021fadingEdgesbN7B8ug, lazyListStateRememberLazyListState, null, false, horizontalOrVerticalM2528spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue2, composerStartRestartGroup, 0, 492);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderList_3J_VO9M$lambda$6(j, folderColors, onFolderColorSelected, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float FolderList_3J_VO9M$lambda$1(MutableState<C1486Dp> mutableState) {
        return mutableState.getValue().m11031unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FolderList_3J_VO9M$lambda$2(MutableState<C1486Dp> mutableState, float f) {
        mutableState.setValue(C1486Dp.m11015boximpl(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Folder-L8y2Mks, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m13014FolderL8y2Mks(final long j, Modifier modifier, boolean z, float f, final Function0<Unit> onClick, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        float f2;
        final Modifier modifier3;
        final boolean z3;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1663179662);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Folder)N(color:c#ui.graphics.Color,modifier,isSelected,size:c#ui.unit.Dp,onClick)196@8510L111,197@8669L6,199@8748L211,206@9103L631:folderActionPane.kt#3ga04k");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        f2 = f;
                        i3 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
                    }
                    if ((i & 24576) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(onClick) ? 16384 : 8192;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        f3 = f2;
                    } else {
                        Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z4 = i4 != 0 ? false : z2;
                        float fM11017constructorimpl = i5 != 0 ? C1486Dp.m11017constructorimpl(32) : f2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1663179662, i3, -1, "com.myscript.nebo.dms.ui.compose.Folder (folderActionPane.kt:195)");
                        }
                        long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), Folder_L8y2Mks$lambda$0(AnimateAsStateKt.animateFloatAsState(z4 ? 0.08f : 0.0f, null, 0.0f, "color pill selection feedback alpha", null, composerStartRestartGroup, 3072, 22)), 0.0f, 0.0f, 0.0f, 14, null);
                        State<C1486Dp> stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(z4 ? fM11017constructorimpl : C1486Dp.m11017constructorimpl(0), AnimationSpecKt.spring$default(0.5f, 50.0f, null, 4, null), "color pill selection feedback size", null, composerStartRestartGroup, 432, 8);
                        composerStartRestartGroup = composerStartRestartGroup;
                        float f4 = fM11017constructorimpl;
                        int i7 = i3;
                        Modifier modifier4 = companion;
                        Modifier modifierM2062clickableoSLSa3U$default = ClickableKt.m2062clickableoSLSa3U$default(SizeKt.m2924size3ABfNKs(ClipKt.clip(companion, RoundedCornerShapeKt.getCircleShape()), fM11017constructorimpl), false, null, Role.m10186boximpl(Role.INSTANCE.m10193getButtono7Vup1c()), null, onClick, 11, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2062clickableoSLSa3U$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769572879, "C213@9346L206,220@9593L42,219@9561L167:folderActionPane.kt#3ga04k");
                        BoxKt.Box(SizeKt.m2924size3ABfNKs(BackgroundKt.m2016backgroundbw27NRU$default(ClipKt.clip(modifier4, RoundedCornerShapeKt.getCircleShape()), jM8147copywmQWz5c$default, null, 2, null), Folder_L8y2Mks$lambda$1(stateM1892animateDpAsStateAjpBEmI)), composerStartRestartGroup, 0);
                        IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6208R.drawable.ic_folder, composerStartRestartGroup, 0), "Folder icon", (Modifier) null, j, composerStartRestartGroup, Painter.$stable | 48 | ((i7 << 9) & 7168), 4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z3 = z4;
                        f3 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FolderActionPaneKt.Folder_L8y2Mks$lambda$3(j, modifier3, z3, f3, onClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                f2 = f;
                if ((i & 24576) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            f2 = f;
            if ((i & 24576) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        f2 = f;
        if ((i & 24576) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final void CollectionSelector(final ImmutableMap<CollectionKey, String> collections, final CollectionKey collectionKey, final Function1<? super CollectionKey, Unit> onCollectionChanged, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(collections, "collections");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(onCollectionChanged, "onCollectionChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(895278577);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionSelector)N(collections,collectionKey,onCollectionChanged)234@10100L46,237@10324L33,232@10011L352:folderActionPane.kt#3ga04k");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(collections) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(collectionKey) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCollectionChanged) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(895278577, i2, -1, "com.myscript.nebo.dms.ui.compose.CollectionSelector (folderActionPane.kt:228)");
            }
            ImmutableMap<CollectionKey, String> immutableMap = collections;
            ArrayList arrayList = new ArrayList(immutableMap.size());
            for (Map.Entry<CollectionKey, String> entry : immutableMap.entrySet()) {
                arrayList.add(new TextualDropdownOption(entry.getKey(), entry.getValue()));
            }
            ArrayList arrayList2 = arrayList;
            Object obj = null;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            String strStringResource = StringResources_androidKt.stringResource(C6208R.string.collection_label, composerStartRestartGroup, 0);
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((TextualDropdownOption) next).getValue(), collectionKey)) {
                    obj = next;
                    break;
                }
            }
            TextualDropdownOption textualDropdownOption = (TextualDropdownOption) obj;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1369271698, "CC(remember):folderActionPane.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FolderActionPaneKt.CollectionSelector$lambda$2$0(onCollectionChanged, (TextualDropdownOption) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextualDropdownMenuKt.TextualDropdownMenu(modifierFillMaxWidth$default, strStringResource, arrayList2, textualDropdownOption, (Function1) objRememberedValue, composerStartRestartGroup, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return FolderActionPaneKt.CollectionSelector$lambda$3(collections, collectionKey, onCollectionChanged, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionSelector$lambda$2$0(Function1 function1, TextualDropdownOption it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getValue());
        return Unit.INSTANCE;
    }

    public static final void FolderCreationPanePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(948800455);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderCreationPanePreview)246@10543L170,254@11006L2,255@11044L2,256@11082L2,257@11109L2,258@11137L2,244@10426L719:folderActionPane.kt#3ga04k");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(948800455, i, -1, "com.myscript.nebo.dms.ui.compose.FolderCreationPanePreview (folderActionPane.kt:243)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1264175633, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderActionPaneKt.FolderCreationPanePreview$lambda$0$0((CollectionKey) obj, (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FolderEditorViewModel folderEditorViewModel = new FolderEditorViewModel((Function2) objRememberedValue, FolderEditorAction.CREATE, "", new CollectionKey(), MapsKt.emptyMap(), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1264190281, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderActionPaneKt.FolderCreationPanePreview$lambda$1$0(((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1264191497, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderActionPaneKt.FolderCreationPanePreview$lambda$2$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function12 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1264192713, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderActionPaneKt.FolderCreationPanePreview$lambda$3$0((CollectionKey) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function13 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1264193577, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function0 function0 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1264194473, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FolderActionPane(folderEditorViewModel, function1, function12, function13, function0, (Function0) objRememberedValue6, composerStartRestartGroup, 224688);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderCreationPanePreview$lambda$6(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FolderPropertiesValidator.Status FolderCreationPanePreview$lambda$0$0(CollectionKey collectionKey, String folderName) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        String str = folderName;
        return StringsKt.isBlank(str) ? FolderPropertiesValidator.Status.Blank.INSTANCE : new FolderPropertiesValidator.Status.Valid(NameUtils.normalizeSpaces(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderCreationPanePreview$lambda$1$0(int i) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderCreationPanePreview$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderCreationPanePreview$lambda$3$0(CollectionKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void FolderPreviewIsSelected(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1535329357);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderPreviewIsSelected)265@11244L45,265@11320L2,265@11229L94:folderActionPane.kt#3ga04k");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1535329357, i, -1, "com.myscript.nebo.dms.ui.compose.FolderPreviewIsSelected (folderActionPane.kt:264)");
            }
            long jColorResource = ColorResources_androidKt.colorResource(C6183R.color.coverColorPurple, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2017241813, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m13014FolderL8y2Mks(jColorResource, null, true, 0.0f, (Function0) objRememberedValue, composerStartRestartGroup, 24960, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderPreviewIsSelected$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void FolderPreviewNonSelected(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(408327422);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderPreviewNonSelected)271@11423L45,271@11500L2,271@11408L95:folderActionPane.kt#3ga04k");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(408327422, i, -1, "com.myscript.nebo.dms.ui.compose.FolderPreviewNonSelected (folderActionPane.kt:270)");
            }
            long jColorResource = ColorResources_androidKt.colorResource(C6183R.color.coverColorPurple, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1560632736, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m13014FolderL8y2Mks(jColorResource, null, false, 0.0f, (Function0) objRememberedValue, composerStartRestartGroup, 24960, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderPreviewNonSelected$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void FolderListPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2015859280);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderListPreview)288@12100L2,288@12007L96:folderActionPane.kt#3ga04k");
        if (composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2015859280, i, -1, "com.myscript.nebo.dms.ui.compose.FolderListPreview (folderActionPane.kt:276)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C6183R.color.coverColorPurple), Integer.valueOf(C6183R.color.coverColorMagenta), Integer.valueOf(C6183R.color.coverColorCobalt), Integer.valueOf(C6183R.color.coverColorCyan), Integer.valueOf(C6183R.color.coverColorEmerald), Integer.valueOf(C6183R.color.coverColorOlive), Integer.valueOf(C6183R.color.coverColorCorn), Integer.valueOf(C6183R.color.coverColorOrange), Integer.valueOf(C6183R.color.coverColorRaspberry)});
            long jColor = ColorKt.Color(ColorExt.getOpaque(10563835));
            composerStartRestartGroup.startReplaceGroup(-210501623);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*288@12055L17");
            List list = listListOf;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Color.m8138boximpl(ColorResources_androidKt.colorResource(((Number) it.next()).intValue(), composerStartRestartGroup, 0)));
            }
            ArrayList arrayList2 = arrayList;
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -210500014, "CC(remember):folderActionPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderActionPaneKt.FolderListPreview$lambda$1$0(((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m13015FolderList3JVO9M(jColor, arrayList2, (Function1) objRememberedValue, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderActionPaneKt.FolderListPreview$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderListPreview$lambda$1$0(int i) {
        return Unit.INSTANCE;
    }

    private static final FolderEditorState FolderActionPane$lambda$0(State<FolderEditorState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderList_3J_VO9M$lambda$5$0(final List list, final long j, final Function1 function1, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final C6308x3f8272ba c6308x3f8272ba = new Function1() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$FolderList_3J_VO9M$lambda$5$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Color color) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Color) obj);
            }
        };
        LazyRow.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$FolderList_3J_VO9M$lambda$5$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return c6308x3f8272ba.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$FolderList_3J_VO9M$lambda$5$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final long jM8158unboximpl = ((Color) list.get(i)).m8158unboximpl();
                composer.startReplaceGroup(-709810971);
                ComposerKt.sourceInformation(composer, "CN(color:c#ui.graphics.Color)*187@8258L69,184@8145L182:folderActionPane.kt#3ga04k");
                boolean zM8149equalsimpl0 = Color.m8149equalsimpl0(jM8158unboximpl, j);
                ComposerKt.sourceInformationMarkerStart(composer, -1962556275, "CC(remember):folderActionPane.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changed(jM8158unboximpl);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function12 = function1;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.myscript.nebo.dms.ui.compose.FolderActionPaneKt$FolderList$2$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function12.invoke(Integer.valueOf(ColorKt.m8202toArgb8_81llA(jM8158unboximpl)));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FolderActionPaneKt.m13014FolderL8y2Mks(jM8158unboximpl, null, zM8149equalsimpl0, 0.0f, (Function0) objRememberedValue, composer, 0, 10);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    private static final float FolderList_3J_VO9M$lambda$3(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    private static final float Folder_L8y2Mks$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Folder_L8y2Mks$lambda$1(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }
}
