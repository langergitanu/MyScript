package com.myscript.nebo.note.p030ui.compose;

import android.content.res.Configuration;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.dms.p026ui.compose.components.TextualDropdownMenuKt;
import com.myscript.nebo.dms.p026ui.compose.components.TextualDropdownOption;
import com.myscript.nebo.languagemanager.presentation.LanguageViewModel;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import com.myscript.nebo.note.NoteCreationUIState;
import com.myscript.nebo.note.NoteCreationViewModel;
import com.myscript.nebo.note.Orientation;
import com.myscript.nebo.note.PageSize;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: noteCreationPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001aÓ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a¬\u0003\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\b2\b\b\u0001\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#2\u0006\u0010$\u001a\u00020\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100#2\u0006\u0010&\u001a\u00020\u00102\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120#2\u0006\u0010(\u001a\u00020\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0#2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\u0018\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0,0#2\u0006\u0010-\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015H\u0007¢\u0006\u0002\u00101\u001aÖ\u0001\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100#2\u0006\u0010&\u001a\u00020\u00102\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120#2\u0006\u0010(\u001a\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#2\u0006\u0010$\u001a\u00020\n2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¢\u0006\u0002\u00103\u001aC\u00104\u001a\u00020\u00012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u0010052\u0006\u00106\u001a\u00020\u00102\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u00107\u001a\u000208H\u0007¢\u0006\u0002\u00109\u001aR\u0010:\u001a\u00020\u00012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u0012052\u0006\u0010(\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u0002082#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010;\u001a_\u0010<\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0,052\u0006\u0010-\u001a\u00020\b2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\b\b\u0002\u00107\u001a\u000208H\u0007¢\u0006\u0002\u0010=\u001a \u0010>\u001a\u00020\u00012\u0011\u0010?\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b@H\u0007¢\u0006\u0002\u0010A¨\u0006B²\u0006\n\u0010C\u001a\u00020DX\u008a\u0084\u0002²\u0006\u0010\u0010E\u001a\b\u0012\u0004\u0012\u00020F05X\u008a\u0084\u0002"}, m1599d2 = {"NoteCreationPane", "", "noteCreationViewModel", "Lcom/myscript/nebo/note/NoteCreationViewModel;", "languageViewModel", "Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "onNoteNameChanged", "Lkotlin/Function1;", "", "onCoverColorChanged", "", "onPageColorClicked", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "onPagePatternClicked", "Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "onPageSizeSelected", "Lcom/myscript/nebo/note/PageSize;", "onOrientationSelected", "Lcom/myscript/nebo/note/Orientation;", "onLanguageSelected", "onManageLanguage", "Lkotlin/Function0;", "onCreate", "onDismiss", "(Lcom/myscript/nebo/note/NoteCreationViewModel;Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NoteCreationPaneContent", "showNotebookDetailSection", "", "showPageColorSection", "showPagePatternSection", "noteName", "noteNameHint", "coverData", "Lcom/myscript/nebo/note/ui/compose/CoverData;", "coverColors", "Lkotlinx/collections/immutable/ImmutableList;", "coverColorIndex", "pageSizes", "pageSize", "orientations", "currentOrientation", "pageBackgroundColors", "pageBackgroundPatterns", "languages", "Lkotlin/Pair;", "selectedLanguage", "Lkotlin/ParameterName;", "name", "orientation", "(ZZZLjava/lang/String;ILcom/myscript/nebo/note/ui/compose/CoverData;Lkotlinx/collections/immutable/ImmutableList;ILkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/note/PageSize;Lkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/note/Orientation;Lkotlinx/collections/immutable/ImmutableList;Lkotlinx/collections/immutable/ImmutableList;Lkotlinx/collections/immutable/ImmutableList;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;IIII)V", "NotebookDetails", "(Lcom/myscript/nebo/note/ui/compose/CoverData;Ljava/lang/String;ILkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/note/PageSize;Lkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/note/Orientation;Lkotlinx/collections/immutable/ImmutableList;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "PageSizeSelector", "", "selectedPageSize", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Lcom/myscript/nebo/note/PageSize;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OrientationSelector", "(Ljava/util/List;Lcom/myscript/nebo/note/Orientation;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LanguageSelector", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NoteCreationSectionCard", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_standardRelease", "uiState", "Lcom/myscript/nebo/note/NoteCreationUIState;", "languagesState", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem;"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteCreationPaneKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$2(List list, String str, Function1 function1, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LanguageSelector(list, str, function1, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCreationPane$lambda$4(NoteCreationViewModel noteCreationViewModel, LanguageViewModel languageViewModel, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function0 function0, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        NoteCreationPane(noteCreationViewModel, languageViewModel, function1, function12, function13, function14, function15, function16, function17, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCreationPaneContent$lambda$2(boolean z, boolean z2, boolean z3, String str, int i, CoverData coverData, ImmutableList immutableList, int i2, ImmutableList immutableList2, PageSize pageSize, ImmutableList immutableList3, Orientation orientation, ImmutableList immutableList4, ImmutableList immutableList5, ImmutableList immutableList6, String str2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, int i5, int i6, Composer composer, int i7) {
        NoteCreationPaneContent(z, z2, z3, str, i, coverData, immutableList, i2, immutableList2, pageSize, immutableList3, orientation, immutableList4, immutableList5, immutableList6, str2, function1, function12, function13, function14, function15, function16, function17, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCreationSectionCard$lambda$1(Function2 function2, int i, Composer composer, int i2) {
        NoteCreationSectionCard(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotebookDetails$lambda$1(CoverData coverData, String str, int i, ImmutableList immutableList, PageSize pageSize, ImmutableList immutableList2, Orientation orientation, ImmutableList immutableList3, int i2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i3, int i4, int i5, Composer composer, int i6) {
        NotebookDetails(coverData, str, i, immutableList, pageSize, immutableList2, orientation, immutableList3, i2, function1, function12, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrientationSelector$lambda$3(List list, Orientation orientation, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        OrientationSelector(list, orientation, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageSizeSelector$lambda$3(List list, PageSize pageSize, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PageSizeSelector(list, pageSize, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void NoteCreationPane(final NoteCreationViewModel noteCreationViewModel, final LanguageViewModel languageViewModel, final Function1<? super String, Unit> onNoteNameChanged, final Function1<? super Integer, Unit> onCoverColorChanged, final Function1<? super PageBackgroundColor, Unit> onPageColorClicked, final Function1<? super PageBackgroundPattern, Unit> onPagePatternClicked, final Function1<? super PageSize, Unit> onPageSizeSelected, final Function1<? super Orientation, Unit> onOrientationSelected, final Function1<? super String, Unit> onLanguageSelected, final Function0<Unit> onManageLanguage, final Function0<Unit> onCreate, final Function0<Unit> onDismiss, Composer composer, final int i, final int i2) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(noteCreationViewModel, "noteCreationViewModel");
        Intrinsics.checkNotNullParameter(languageViewModel, "languageViewModel");
        Intrinsics.checkNotNullParameter(onNoteNameChanged, "onNoteNameChanged");
        Intrinsics.checkNotNullParameter(onCoverColorChanged, "onCoverColorChanged");
        Intrinsics.checkNotNullParameter(onPageColorClicked, "onPageColorClicked");
        Intrinsics.checkNotNullParameter(onPagePatternClicked, "onPagePatternClicked");
        Intrinsics.checkNotNullParameter(onPageSizeSelected, "onPageSizeSelected");
        Intrinsics.checkNotNullParameter(onOrientationSelected, "onOrientationSelected");
        Intrinsics.checkNotNullParameter(onLanguageSelected, "onLanguageSelected");
        Intrinsics.checkNotNullParameter(onManageLanguage, "onManageLanguage");
        Intrinsics.checkNotNullParameter(onCreate, "onCreate");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1191419780);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteCreationPane)N(noteCreationViewModel,languageViewModel,onNoteNameChanged,onCoverColorChanged,onPageColorClicked,onPagePatternClicked,onPageSizeSelected,onOrientationSelected,onLanguageSelected,onManageLanguage,onCreate,onDismiss)86@4225L37,87@4317L27,89@4350L1733:noteCreationPane.kt#ku1rws");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(noteCreationViewModel) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(languageViewModel) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNoteNameChanged) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCoverColorChanged) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPageColorClicked) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPagePatternClicked) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPageSizeSelected) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onOrientationSelected) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onLanguageSelected) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onManageLanguage) ? 536870912 : 268435456;
        }
        int i4 = (i2 & 6) == 0 ? i2 | (composerStartRestartGroup.changedInstance(onCreate) ? 4 : 2) : i2;
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 19) == 18) ? false : true, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1191419780, i3, i4, "com.myscript.nebo.note.ui.compose.NoteCreationPane (noteCreationPane.kt:85)");
            }
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(noteCreationViewModel.getNoteCreationUIState(), new NoteCreationUIState(0, null, 0, null, null, null, null, 127, null), composerStartRestartGroup, 0);
            State stateObserveAsState2 = LiveDataAdapterKt.observeAsState(languageViewModel.getLanguages(), CollectionsKt.emptyList(), composerStartRestartGroup, 48);
            boolean showNotebookDetailsSection = NoteCreationPane$lambda$0(stateObserveAsState).getNotebookDetailsState().getShowNotebookDetailsSection();
            boolean showPageColorSection = NoteCreationPane$lambda$0(stateObserveAsState).getPageColorState().getShowPageColorSection();
            boolean showPagePatternSection = NoteCreationPane$lambda$0(stateObserveAsState).getPagePatternState().getShowPagePatternSection();
            String noteName = NoteCreationPane$lambda$0(stateObserveAsState).getNoteName();
            int noteNameHint = NoteCreationPane$lambda$0(stateObserveAsState).getNoteNameHint();
            CoverData coverData = NoteCreationPane$lambda$0(stateObserveAsState).getNotebookDetailsState().getCoverData();
            ImmutableList<CoverData> availableCoverColors = NoteCreationPane$lambda$0(stateObserveAsState).getNotebookDetailsState().getAvailableCoverColors();
            int coverColorIndex = NoteCreationPane$lambda$0(stateObserveAsState).getNotebookDetailsState().getCoverColorIndex();
            ImmutableList<PageSize> availablePageSizes = NoteCreationPane$lambda$0(stateObserveAsState).getNotebookDetailsState().getAvailablePageSizes();
            PageSize pageSize = NoteCreationPane$lambda$0(stateObserveAsState).getNotebookDetailsState().getPageSize();
            ImmutableList<Orientation> availableOrientations = NoteCreationPane$lambda$0(stateObserveAsState).getNotebookDetailsState().getAvailableOrientations();
            Orientation orientation = NoteCreationPane$lambda$0(stateObserveAsState).getNotebookDetailsState().getCoverData().getOrientation();
            ImmutableList<PageBackgroundColor> colors = NoteCreationPane$lambda$0(stateObserveAsState).getPageColorState().getColors();
            ImmutableList<PageBackgroundPattern> patterns = NoteCreationPane$lambda$0(stateObserveAsState).getPagePatternState().getPatterns();
            List<LanguageManagerItem> listNoteCreationPane$lambda$1 = NoteCreationPane$lambda$1(stateObserveAsState2);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listNoteCreationPane$lambda$1) {
                boolean z = showNotebookDetailsSection;
                boolean z2 = showPageColorSection;
                if (obj instanceof LanguageManagerItem.Lang) {
                    arrayList.add(obj);
                }
                showNotebookDetailsSection = z;
                showPageColorSection = z2;
            }
            boolean z3 = showNotebookDetailsSection;
            boolean z4 = showPageColorSection;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((LanguageManagerItem.Lang) obj2).getInstalled()) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (Iterator it = r1.iterator(); it.hasNext(); it = it) {
                LanguageManagerItem.Lang lang = (LanguageManagerItem.Lang) it.next();
                arrayList3.add(TuplesKt.m1606to(lang.getKey(), lang.getLabel()));
            }
            int i5 = i4 << 12;
            composer2 = composerStartRestartGroup;
            NoteCreationPaneContent(z3, z4, showPagePatternSection, noteName, noteNameHint, coverData, availableCoverColors, coverColorIndex, availablePageSizes, pageSize, availableOrientations, orientation, colors, patterns, ExtensionsKt.toPersistentList(arrayList3), NoteCreationPane$lambda$0(stateObserveAsState).getLanguage(), onNoteNameChanged, onCoverColorChanged, onPageColorClicked, onPagePatternClicked, onPageSizeSelected, onOrientationSelected, onLanguageSelected, onManageLanguage, onCreate, onDismiss, composer2, 0, (i3 << 12) & 2146959360, ((i3 >> 18) & 8190) | (i5 & 57344) | (i5 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return NoteCreationPaneKt.NoteCreationPane$lambda$4(noteCreationViewModel, languageViewModel, onNoteNameChanged, onCoverColorChanged, onPageColorClicked, onPagePatternClicked, onPageSizeSelected, onOrientationSelected, onLanguageSelected, onManageLanguage, onCreate, onDismiss, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:281:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NoteCreationPaneContent(final boolean z, final boolean z2, final boolean z3, final String noteName, final int i, final CoverData coverData, final ImmutableList<CoverData> coverColors, final int i2, final ImmutableList<? extends PageSize> pageSizes, final PageSize pageSize, final ImmutableList<? extends Orientation> orientations, final Orientation currentOrientation, final ImmutableList<PageBackgroundColor> pageBackgroundColors, final ImmutableList<PageBackgroundPattern> pageBackgroundPatterns, final ImmutableList<Pair<String, String>> languages, final String selectedLanguage, Function1<? super String, Unit> function1, Function1<? super Integer, Unit> function12, Function1<? super PageBackgroundColor, Unit> function13, Function1<? super PageBackgroundPattern, Unit> function14, Function1<? super PageSize, Unit> function15, Function1<? super Orientation, Unit> function16, Function1<? super String, Unit> function17, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final Function1<? super String, Unit> function18;
        final Function1<? super Integer, Unit> function19;
        final Function1<? super PageBackgroundColor, Unit> function110;
        final Function1<? super PageBackgroundPattern, Unit> function111;
        final Function1<? super PageSize, Unit> function112;
        final Function1<? super Orientation, Unit> function113;
        final Function1<? super String, Unit> function114;
        final Function0<Unit> function04;
        final Function0<Unit> function05;
        final Function0<Unit> function06;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z4;
        Modifier.Companion companionM2912heightInVpY3zN4$default;
        Intrinsics.checkNotNullParameter(noteName, "noteName");
        Intrinsics.checkNotNullParameter(coverData, "coverData");
        Intrinsics.checkNotNullParameter(coverColors, "coverColors");
        Intrinsics.checkNotNullParameter(pageSizes, "pageSizes");
        Intrinsics.checkNotNullParameter(pageSize, "pageSize");
        Intrinsics.checkNotNullParameter(orientations, "orientations");
        Intrinsics.checkNotNullParameter(currentOrientation, "currentOrientation");
        Intrinsics.checkNotNullParameter(pageBackgroundColors, "pageBackgroundColors");
        Intrinsics.checkNotNullParameter(pageBackgroundPatterns, "pageBackgroundPatterns");
        Intrinsics.checkNotNullParameter(languages, "languages");
        Intrinsics.checkNotNullParameter(selectedLanguage, "selectedLanguage");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1837429267);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteCreationPaneContent)N(showNotebookDetailSection,showPageColorSection,showPagePatternSection,noteName,noteNameHint,coverData,coverColors,coverColorIndex,pageSizes,pageSize,orientations,currentOrientation,pageBackgroundColors,pageBackgroundPatterns,languages,selectedLanguage,onNoteNameChanged,onCoverColorChanged,onPageColorClicked,onPagePatternClicked,onPageSizeSelected,onOrientationSelected,onLanguageSelected,onManageLanguage,onCreate,onDismiss)146@7918L7,156@8210L656,170@8868L1641,148@7989L2520:noteCreationPane.kt#ku1rws");
        if ((i3 & 6) == 0) {
            i7 = i3 | (composerStartRestartGroup.changed(z) ? 4 : 2);
        } else {
            i7 = i3;
        }
        if ((i3 & 48) == 0) {
            i7 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i7 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i7 |= composerStartRestartGroup.changed(noteName) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i8 = i;
            i7 |= composerStartRestartGroup.changed(i8) ? 16384 : 8192;
        } else {
            i8 = i;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
            i7 |= composerStartRestartGroup.changed(coverData) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i7 |= composerStartRestartGroup.changed(coverColors) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i7 |= composerStartRestartGroup.changed(i2) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i7 |= composerStartRestartGroup.changed(pageSizes) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i7 |= composerStartRestartGroup.changed(pageSize.ordinal()) ? 536870912 : 268435456;
        }
        int i16 = i7;
        if ((i4 & 6) == 0) {
            i9 = i4 | (composerStartRestartGroup.changed(orientations) ? 4 : 2);
        } else {
            i9 = i4;
        }
        if ((i4 & 48) == 0) {
            i9 |= composerStartRestartGroup.changed(currentOrientation.ordinal()) ? 32 : 16;
        }
        if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i9 |= composerStartRestartGroup.changed(pageBackgroundColors) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i9 |= composerStartRestartGroup.changed(pageBackgroundPatterns) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i9 |= composerStartRestartGroup.changed(languages) ? 16384 : 8192;
        }
        if ((i4 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
            i9 |= composerStartRestartGroup.changed(selectedLanguage) ? 131072 : 65536;
        }
        int i17 = i6 & 65536;
        if (i17 != 0) {
            i9 |= 1572864;
        } else if ((i4 & 1572864) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        int i18 = i6 & 131072;
        if (i18 != 0) {
            i9 |= 12582912;
        } else if ((i4 & 12582912) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
        }
        int i19 = i6 & 262144;
        if (i19 != 0) {
            i9 |= 100663296;
        } else if ((i4 & 100663296) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(function13) ? 67108864 : 33554432;
        }
        int i20 = i6 & 524288;
        int i21 = 805306368;
        if (i20 != 0) {
            i9 |= i21;
        } else if ((i4 & 805306368) == 0) {
            i21 = composerStartRestartGroup.changedInstance(function14) ? 536870912 : 268435456;
            i9 |= i21;
        }
        int i22 = i9;
        int i23 = i6 & 1048576;
        if (i23 != 0) {
            i11 = i5 | 6;
            i10 = i17;
        } else {
            i10 = i17;
            if ((i5 & 6) == 0) {
                i11 = i5 | (composerStartRestartGroup.changedInstance(function15) ? 4 : 2);
            } else {
                i11 = i5;
            }
        }
        int i24 = i6 & 2097152;
        if (i24 != 0) {
            i11 |= 48;
        } else if ((i5 & 48) == 0) {
            i11 |= composerStartRestartGroup.changedInstance(function16) ? 32 : 16;
        }
        int i25 = i11;
        int i26 = i6 & 4194304;
        if (i26 != 0) {
            i12 = i25 | RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i12 = i25 | (composerStartRestartGroup.changedInstance(function17) ? 256 : 128);
        } else {
            i12 = i25;
        }
        int i27 = i6 & 8388608;
        if (i27 != 0) {
            i13 = i12 | 3072;
        } else {
            int i28 = i12;
            if ((i5 & 3072) == 0) {
                i28 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
            }
            i13 = i28;
        }
        int i29 = i6 & 16777216;
        if (i29 == 0) {
            i14 = i13;
            if ((i5 & 24576) == 0) {
                i14 |= composerStartRestartGroup.changedInstance(function02) ? 16384 : 8192;
            }
            i15 = i6 & 33554432;
            if (i15 == 0) {
                i14 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
            } else if ((i5 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                i14 |= composerStartRestartGroup.changedInstance(function03) ? 131072 : 65536;
            }
            if (composerStartRestartGroup.shouldExecute(((i16 & 306783379) != 306783378 && (306783379 & i22) == 306783378 && (i14 & 74899) == 74898) ? false : true, i16 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function18 = function1;
                function19 = function12;
                function110 = function13;
                function111 = function14;
                function112 = function15;
                function113 = function16;
                function114 = function17;
                function04 = function0;
                function05 = function02;
                function06 = function03;
            } else {
                final Function1<? super String, Unit> function115 = i10 != 0 ? null : function1;
                final Function1<? super Integer, Unit> function116 = i18 != 0 ? null : function12;
                final Function1<? super PageBackgroundColor, Unit> function117 = i19 != 0 ? null : function13;
                final Function1<? super PageBackgroundPattern, Unit> function118 = i20 != 0 ? null : function14;
                final Function1<? super PageSize, Unit> function119 = i23 != 0 ? null : function15;
                final Function1<? super Orientation, Unit> function120 = i24 != 0 ? null : function16;
                final Function1<? super String, Unit> function121 = i26 != 0 ? null : function17;
                final Function0<Unit> function07 = i27 != 0 ? null : function0;
                final Function0<Unit> function08 = i29 != 0 ? null : function02;
                Function0<Unit> function09 = i15 != 0 ? null : function03;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1837429267, i16, i22, "com.myscript.nebo.note.ui.compose.NoteCreationPaneContent (noteCreationPane.kt:144)");
                }
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (C1486Dp.m11016compareTo0680j_4(C1486Dp.m11017constructorimpl(((Configuration) objConsume).screenWidthDp), C1486Dp.m11017constructorimpl(600)) < 0) {
                    companionM2912heightInVpY3zN4$default = Modifier.INSTANCE;
                    z4 = true;
                } else {
                    z4 = true;
                    companionM2912heightInVpY3zN4$default = SizeKt.m2912heightInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(620), 1, null);
                }
                Modifier modifier = companionM2912heightInVpY3zN4$default;
                final Function0<Unit> function010 = function09;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-335263897, z4, new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NoteCreationPaneKt.NoteCreationPaneContent$lambda$0(function010, function08, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                Function0<Unit> function011 = function08;
                final int i30 = i8;
                Function3 function3 = new Function3() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NoteCreationPaneKt.NoteCreationPaneContent$lambda$1(z, coverData, noteName, i30, pageSizes, pageSize, orientations, currentOrientation, coverColors, i2, function115, function119, function120, function116, z2, pageBackgroundColors, function117, z3, pageBackgroundPatterns, function118, languages, selectedLanguage, function121, function07, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                Function1<? super String, Unit> function122 = function115;
                Function1<? super PageSize, Unit> function123 = function119;
                Function1<? super Orientation, Unit> function124 = function120;
                Function1<? super Integer, Unit> function125 = function116;
                Function1<? super PageBackgroundColor, Unit> function126 = function117;
                Function1<? super PageBackgroundPattern, Unit> function127 = function118;
                Function1<? super String, Unit> function128 = function121;
                Function0<Unit> function012 = function07;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m4390Scaffold27mzLpw(modifier, null, null, composableLambdaRememberComposableLambda, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(1750048879, true, function3, composerStartRestartGroup, 54), composer2, 3072, 12582912, 131062);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function112 = function123;
                function113 = function124;
                function18 = function122;
                function19 = function125;
                function110 = function126;
                function111 = function127;
                function114 = function128;
                function04 = function012;
                function06 = function09;
                function05 = function011;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NoteCreationPaneKt.NoteCreationPaneContent$lambda$2(z, z2, z3, noteName, i, coverData, coverColors, i2, pageSizes, pageSize, orientations, currentOrientation, pageBackgroundColors, pageBackgroundPatterns, languages, selectedLanguage, function18, function19, function110, function111, function112, function113, function114, function04, function05, function06, i3, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i14 = i13 | 24576;
        i15 = i6 & 33554432;
        if (i15 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i16 & 306783379) != 306783378 && (306783379 & i22) == 306783378 && (i14 & 74899) == 74898) ? false : true, i16 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCreationPaneContent$lambda$0(Function0 function0, Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C157@8228L624:noteCreationPane.kt#ku1rws");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-335263897, i, -1, "com.myscript.nebo.note.ui.compose.NoteCreationPaneContent.<anonymous> (noteCreationPane.kt:157)");
            }
            Arrangement.Horizontal horizontalM2529spacedByD5KLDUw = Arrangement.INSTANCE.m2529spacedByD5KLDUw(C1486Dp.m11017constructorimpl(16), Alignment.INSTANCE.getEnd());
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(24), C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM2529spacedByD5KLDUw, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2855paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2062371471, "C163@8531L138,166@8690L144:noteCreationPane.kt#ku1rws");
            if (function0 == null) {
                composer.startReplaceGroup(-2062347075);
                ComposerKt.sourceInformation(composer, "163@8565L2");
                ComposerKt.sourceInformationMarkerStart(composer, -2144737307, "CC(remember):noteCreationPane.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
            } else {
                composer.startReplaceGroup(-2144737710);
            }
            composer.endReplaceGroup();
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$NoteCreationPaneKt.INSTANCE.getLambda$1131034022$app_standardRelease(), composer, 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (function02 == null) {
                composer.startReplaceGroup(-2062194307);
                ComposerKt.sourceInformation(composer, "166@8719L2");
                ComposerKt.sourceInformationMarkerStart(composer, -2144732379, "CC(remember):noteCreationPane.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                function02 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
            } else {
                composer.startReplaceGroup(-2144732751);
            }
            composer.endReplaceGroup();
            ButtonKt.Button(function02, null, false, null, null, null, null, null, null, ComposableSingletons$NoteCreationPaneKt.INSTANCE.m13286getLambda$505829485$app_standardRelease(), composer, 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCreationPaneContent$lambda$1(boolean z, CoverData coverData, String str, int i, ImmutableList immutableList, PageSize pageSize, ImmutableList immutableList2, Orientation orientation, ImmutableList immutableList3, int i2, Function1 function1, Function1 function12, Function1 function13, Function1 function14, boolean z2, ImmutableList immutableList4, Function1 function15, boolean z3, ImmutableList immutableList5, Function1 function16, ImmutableList immutableList6, String str2, Function1 function17, Function0 function0, PaddingValues padding, Composer composer, int i3) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)176@9135L21,171@8889L1614:noteCreationPane.kt#ku1rws");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.changed(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (!composer.shouldExecute((i4 & 19) != 18, i4 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1750048879, i4, -1, "com.myscript.nebo.note.ui.compose.NoteCreationPaneContent.<anonymous> (noteCreationPane.kt:171)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(16));
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m2856paddingVpY3zN4$default(PaddingKt.padding(Modifier.INSTANCE, padding), C1486Dp.m11017constructorimpl(24), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1215584259, "C205@10410L83:noteCreationPane.kt#ku1rws");
            if (z) {
                composer.startReplaceGroup(1215598270);
                ComposerKt.sourceInformation(composer, "179@9223L747");
                NotebookDetails(coverData, str, i, immutableList, pageSize, immutableList2, orientation, immutableList3, i2, function1, function12, function13, function14, composer, 0, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1216356933);
                ComposerKt.sourceInformation(composer, "194@10008L100");
                NoteKt.NoteNameField(str, PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(8), 7, null), i, function1, composer, 48, 0);
                composer.endReplaceGroup();
            }
            if (z2) {
                composer.startReplaceGroup(1216526348);
                ComposerKt.sourceInformation(composer, "198@10180L61");
                i5 = 0;
                PageBackgroundColorsKt.BackgroundColorList(immutableList4, function15, composer, 0);
                composer.endReplaceGroup();
            } else {
                i5 = 0;
                composer.startReplaceGroup(1216615721);
                composer.endReplaceGroup();
            }
            if (z3) {
                composer.startReplaceGroup(1216660454);
                ComposerKt.sourceInformation(composer, "202@10315L67");
                PageBackgroundPatternsKt.BackgroundPatternList(immutableList5, function16, composer, i5);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1216755593);
                composer.endReplaceGroup();
            }
            LanguageSelector(immutableList6, str2, function17, function0, null, composer, 0, 16);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void NotebookDetails(final CoverData coverData, final String noteName, final int i, final ImmutableList<? extends PageSize> pageSizes, final PageSize pageSize, final ImmutableList<? extends Orientation> orientations, final Orientation currentOrientation, final ImmutableList<CoverData> coverColors, final int i2, Function1<? super String, Unit> function1, Function1<? super PageSize, Unit> function12, Function1<? super Orientation, Unit> function13, Function1<? super Integer, Unit> function14, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Function1<? super String, Unit> function15;
        int i7;
        int i8;
        int i9;
        int i10;
        final Function1<? super PageSize, Unit> function16;
        final Function1<? super Orientation, Unit> function17;
        final Function1<? super Integer, Unit> function18;
        final Function1<? super String, Unit> function19;
        Function1<? super PageSize, Unit> function110;
        int i11;
        Function1<? super Orientation, Unit> function111;
        Intrinsics.checkNotNullParameter(coverData, "coverData");
        Intrinsics.checkNotNullParameter(noteName, "noteName");
        Intrinsics.checkNotNullParameter(pageSizes, "pageSizes");
        Intrinsics.checkNotNullParameter(pageSize, "pageSize");
        Intrinsics.checkNotNullParameter(orientations, "orientations");
        Intrinsics.checkNotNullParameter(currentOrientation, "currentOrientation");
        Intrinsics.checkNotNullParameter(coverColors, "coverColors");
        Composer composerStartRestartGroup = composer.startRestartGroup(1370142408);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotebookDetails)N(coverData,noteName,noteNameHint,pageSizes,pageSize,orientations,currentOrientation,coverColors,coverColorIndex,onNoteNameChanged,onPageSizeSelected,onOrientationSelected,onCoverColorChanged)225@11119L2043,276@13168L148:noteCreationPane.kt#ku1rws");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(coverData) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(noteName) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(pageSizes) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(pageSize.ordinal()) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i6 |= composerStartRestartGroup.changed(orientations) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i6 |= composerStartRestartGroup.changed(currentOrientation.ordinal()) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i6 |= composerStartRestartGroup.changed(coverColors) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 67108864 : 33554432;
        }
        int i12 = i5 & 512;
        if (i12 != 0) {
            i6 |= 805306368;
            function15 = function1;
        } else {
            function15 = function1;
            if ((i3 & 805306368) == 0) {
                i6 |= composerStartRestartGroup.changedInstance(function15) ? 536870912 : 268435456;
            }
        }
        int i13 = i5 & 1024;
        if (i13 != 0) {
            i8 = i4 | 6;
            i7 = i13;
        } else if ((i4 & 6) == 0) {
            i7 = i13;
            i8 = i4 | (composerStartRestartGroup.changedInstance(function12) ? 4 : 2);
        } else {
            i7 = i13;
            i8 = i4;
        }
        int i14 = i5 & 2048;
        if (i14 != 0) {
            i8 |= 48;
            i9 = i14;
        } else if ((i4 & 48) == 0) {
            i9 = i14;
            i8 |= composerStartRestartGroup.changedInstance(function13) ? 32 : 16;
        } else {
            i9 = i14;
        }
        int i15 = i8;
        int i16 = i5 & 4096;
        if (i16 != 0) {
            i10 = i15 | RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            int i17 = i15;
            if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i17 |= composerStartRestartGroup.changedInstance(function14) ? 256 : 128;
            }
            i10 = i17;
        }
        if (!composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i10 & 147) == 146) ? false : true, i6 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function16 = function12;
            function17 = function13;
            function18 = function14;
            function19 = function15;
        } else {
            Function1<? super String, Unit> function112 = i12 != 0 ? null : function15;
            Function1<? super PageSize, Unit> function113 = i7 != 0 ? null : function12;
            Function1<? super Orientation, Unit> function114 = i9 != 0 ? null : function13;
            Function1<? super Integer, Unit> function115 = i16 != 0 ? null : function14;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1370142408, i6, i10, "com.myscript.nebo.note.ui.compose.NotebookDetails (noteCreationPane.kt:224)");
            }
            float f = 16;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            Function1<? super PageSize, Unit> function116 = function113;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            Function1<? super String, Unit> function117 = function112;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i18 = i10;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -170750253, "C226@11225L7:noteCreationPane.kt#ku1rws");
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (C1486Dp.m11016compareTo0680j_4(C1486Dp.m11017constructorimpl(((Configuration) objConsume).screenWidthDp), C1486Dp.m11017constructorimpl(600)) < 0) {
                composerStartRestartGroup.startReplaceGroup(-170612614);
                ComposerKt.sourceInformation(composerStartRestartGroup, "232@11376L754");
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composerStartRestartGroup);
                Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1317327074, "C234@11454L266,241@11738L113,243@11869L57,244@11943L173:noteCreationPane.kt#ku1rws");
                CoverKt.m13292CoverxKlaLpw(new CoverData(coverData.getColors(), coverData.getOrientation()), SizeKt.m2912heightInVpY3zN4$default(AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, null, null, 3, null), 0.0f, C1486Dp.m11017constructorimpl(120), 1, null), false, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 56);
                i11 = i6;
                NoteKt.NoteNameField(noteName, PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(f), 0.0f, C1486Dp.m11017constructorimpl(8), 5, null), i, function117, composerStartRestartGroup, ((i6 >> 3) & 14) | 48 | (i6 & 896) | ((i6 >> 18) & 7168), 0);
                int i19 = i18 << 6;
                PageSizeSelector(pageSizes, pageSize, function116, null, composerStartRestartGroup, ((i11 >> 9) & WebSocketProtocol.PAYLOAD_SHORT) | (i19 & 896), 8);
                function110 = function116;
                function111 = function114;
                OrientationSelector(orientations, currentOrientation, null, function111, composerStartRestartGroup, ((i11 >> 15) & WebSocketProtocol.PAYLOAD_SHORT) | (i19 & 7168), 4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                function110 = function116;
                i11 = i6;
                Function1<? super Orientation, Unit> function118 = function114;
                composerStartRestartGroup.startReplaceGroup(-169827694);
                ComposerKt.sourceInformation(composerStartRestartGroup, "250@12160L986");
                Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Max);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_42 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_42, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHeight);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composerStartRestartGroup);
                Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2076640583, "C255@12392L256,262@12666L466:noteCreationPane.kt#ku1rws");
                CoverKt.m13292CoverxKlaLpw(new CoverData(coverData.getColors(), coverData.getOrientation()), RowScope.weight$default(rowScopeInstance, AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, null, null, 3, null), 0.35f, false, 2, null), true, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 56);
                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM7248constructorimpl4 = Updater.m7248constructorimpl(composerStartRestartGroup);
                Updater.m7256setimpl(composerM7248constructorimpl4, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -309962715, "C264@12728L101,266@12851L57,267@12929L185:noteCreationPane.kt#ku1rws");
                NoteKt.NoteNameField(noteName, PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(8), 7, null), i, function117, composerStartRestartGroup, ((i11 >> 3) & 14) | 48 | (i11 & 896) | ((i11 >> 18) & 7168), 0);
                int i20 = i18 << 6;
                PageSizeSelector(pageSizes, pageSize, function110, null, composerStartRestartGroup, ((i11 >> 9) & WebSocketProtocol.PAYLOAD_SHORT) | (i20 & 896), 8);
                function111 = function118;
                OrientationSelector(orientations, currentOrientation, null, function111, composerStartRestartGroup, ((i11 >> 15) & WebSocketProtocol.PAYLOAD_SHORT) | (i20 & 7168), 4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function1<? super Integer, Unit> function119 = function115;
            NoteKt.NotebookCoverList(coverColors, i2, null, function119, composerStartRestartGroup, ((i11 >> 21) & WebSocketProtocol.PAYLOAD_SHORT) | ((i18 << 3) & 7168), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function17 = function111;
            function18 = function119;
            function19 = function117;
            function16 = function110;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NoteCreationPaneKt.NotebookDetails$lambda$1(coverData, noteName, i, pageSizes, pageSize, orientations, currentOrientation, coverColors, i2, function19, function16, function17, function18, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PageSizeSelector(final List<? extends PageSize> pageSizes, final PageSize selectedPageSize, final Function1<? super PageSize, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object obj;
        Intrinsics.checkNotNullParameter(pageSizes, "pageSizes");
        Intrinsics.checkNotNullParameter(selectedPageSize, "selectedPageSize");
        Composer composerStartRestartGroup = composer.startRestartGroup(667600622);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PageSizeSelector)N(pageSizes,selectedPageSize,onPageSizeSelected,modifier)289@13689L54,293@13974L50,287@13611L414:noteCreationPane.kt#ku1rws");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(pageSizes) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(selectedPageSize.ordinal()) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(667600622, i3, -1, "com.myscript.nebo.note.ui.compose.PageSizeSelector (noteCreationPane.kt:283)");
                }
                composerStartRestartGroup.startReplaceGroup(1614076957);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*285@13567L32");
                List<? extends PageSize> list = pageSizes;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (PageSize pageSize : list) {
                    arrayList.add(new TextualDropdownOption(pageSize, StringResources_androidKt.stringResource(pageSize.getLabelRes(), composerStartRestartGroup, 0)));
                }
                ArrayList arrayList2 = arrayList;
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                String strStringResource = StringResources_androidKt.stringResource(C6079R.string.note_creation_size_label, composerStartRestartGroup, 0);
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    if (((TextualDropdownOption) next).getValue() == selectedPageSize) {
                        obj = next;
                        break;
                    }
                }
                TextualDropdownOption textualDropdownOption = (TextualDropdownOption) obj;
                if (textualDropdownOption == null) {
                    textualDropdownOption = (TextualDropdownOption) CollectionsKt.first((List) arrayList2);
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1614091232, "CC(remember):noteCreationPane.kt#9igjgp");
                boolean z = (i3 & 896) == 256;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return NoteCreationPaneKt.PageSizeSelector$lambda$2$0(function1, (TextualDropdownOption) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextualDropdownMenuKt.TextualDropdownMenu(modifierFillMaxWidth$default, strStringResource, arrayList2, textualDropdownOption, (Function1) objRememberedValue, composerStartRestartGroup, TextualDropdownOption.$stable << 9, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return NoteCreationPaneKt.PageSizeSelector$lambda$3(pageSizes, selectedPageSize, function1, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageSizeSelector$lambda$2$0(Function1 function1, TextualDropdownOption item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (function1 != null) {
            function1.invoke(item.getValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OrientationSelector(final List<? extends Orientation> pageSizes, final Orientation currentOrientation, Modifier modifier, final Function1<? super Orientation, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(pageSizes, "pageSizes");
        Intrinsics.checkNotNullParameter(currentOrientation, "currentOrientation");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1337843534);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OrientationSelector)N(pageSizes,currentOrientation,modifier,onOrientationSelected)303@14423L61,306@14661L42,301@14353L351:noteCreationPane.kt#ku1rws");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(pageSizes) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(currentOrientation.ordinal()) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1337843534, i3, -1, "com.myscript.nebo.note.ui.compose.OrientationSelector (noteCreationPane.kt:297)");
                }
                composerStartRestartGroup.startReplaceGroup(-1472407295);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*299@14309L32");
                List<? extends Orientation> list = pageSizes;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (Orientation orientation : list) {
                    arrayList.add(new TextualDropdownOption(orientation, StringResources_androidKt.stringResource(orientation.getLabelRes(), composerStartRestartGroup, 0)));
                }
                ArrayList<TextualDropdownOption> arrayList2 = arrayList;
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                String strStringResource = StringResources_androidKt.stringResource(C6079R.string.note_creation_orientation_label, composerStartRestartGroup, 0);
                for (TextualDropdownOption textualDropdownOption : arrayList2) {
                    if (textualDropdownOption.getValue() == currentOrientation) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1472394788, "CC(remember):noteCreationPane.kt#9igjgp");
                        boolean z = (i3 & 7168) == 2048;
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NoteCreationPaneKt.OrientationSelector$lambda$2$0(function1, (TextualDropdownOption) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        TextualDropdownMenuKt.TextualDropdownMenu(modifierFillMaxWidth$default, strStringResource, arrayList2, textualDropdownOption, (Function1) objRememberedValue, composerStartRestartGroup, TextualDropdownOption.$stable << 9, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NoteCreationPaneKt.OrientationSelector$lambda$3(pageSizes, currentOrientation, modifier3, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrientationSelector$lambda$2$0(Function1 function1, TextualDropdownOption it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (function1 != null) {
            function1.invoke(it.getValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LanguageSelector(final List<Pair<String, String>> languages, final String selectedLanguage, final Function1<? super String, Unit> function1, final Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Function0<Unit> function02;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(languages, "languages");
        Intrinsics.checkNotNullParameter(selectedLanguage, "selectedLanguage");
        Composer composerStartRestartGroup = composer.startRestartGroup(1428074809);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LanguageSelector)N(languages,selectedLanguage,onLanguageSelected,onManageLanguage,modifier)312@15028L1091,312@15004L1115:noteCreationPane.kt#ku1rws");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(languages) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(selectedLanguage) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function02 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1428074809, i3, -1, "com.myscript.nebo.note.ui.compose.LanguageSelector (noteCreationPane.kt:310)");
                }
                List<Pair<String, String>> list = languages;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    arrayList.add(new TextualDropdownOption(pair.getFirst(), (String) pair.getSecond()));
                }
                final ArrayList arrayList2 = arrayList;
                final Modifier modifier4 = modifier2;
                NoteCreationSectionCard(ComposableLambdaKt.rememberComposableLambda(807847346, true, new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NoteCreationPaneKt.LanguageSelector$lambda$1(arrayList2, modifier4, function1, function02, selectedLanguage, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NoteCreationPaneKt.LanguageSelector$lambda$2(languages, selectedLanguage, function1, function0, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$1(List list, Modifier modifier, final Function1 function1, Function0 function0, String str, Composer composer, int i) {
        Object next;
        Function0 function02;
        ComposerKt.sourceInformation(composer, "C313@15038L1075:noteCreationPane.kt#ku1rws");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(807847346, i, -1, "com.myscript.nebo.note.ui.compose.LanguageSelector.<anonymous> (noteCreationPane.kt:313)");
            }
            float f = 16;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1291682357, "C317@15216L58,317@15298L10,317@15342L6,317@15211L148,322@15579L110,319@15373L373,327@15765L60,328@15869L10,329@15931L6,327@15760L188,330@15961L142:noteCreationPane.kt#ku1rws");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.note_creation_language_label, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getSubtitle2(), composer, 0, 0, 65530);
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((TextualDropdownOption) next).getValue(), str)) {
                    break;
                }
            }
            TextualDropdownOption textualDropdownOption = (TextualDropdownOption) next;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 928175146, "CC(remember):noteCreationPane.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NoteCreationPaneKt.LanguageSelector$lambda$1$0$1$0(function1, (TextualDropdownOption) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextualDropdownMenuKt.TextualDropdownMenu(modifierFillMaxWidth$default2, null, list, textualDropdownOption, (Function1) objRememberedValue, composer, TextualDropdownOption.$stable << 9, 2);
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.note_creation_language_caption, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getCaption(), composer, 0, 0, 65530);
            if (function0 == null) {
                composer.startReplaceGroup(-1290925276);
                ComposerKt.sourceInformation(composer, "330@16002L2");
                ComposerKt.sourceInformationMarkerStart(composer, 928188574, "CC(remember):noteCreationPane.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                function02 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(928187954);
                composer.endReplaceGroup();
                function02 = function0;
            }
            ButtonKt.TextButton(function02, null, false, null, null, null, null, null, null, ComposableSingletons$NoteCreationPaneKt.INSTANCE.getLambda$23323743$app_standardRelease(), composer, 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LanguageSelector$lambda$1$0$1$0(Function1 function1, TextualDropdownOption selectedItem) {
        Intrinsics.checkNotNullParameter(selectedItem, "selectedItem");
        if (function1 != null) {
            function1.invoke(selectedItem.getValue());
        }
        return Unit.INSTANCE;
    }

    public static final void NoteCreationSectionCard(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-34091516);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteCreationSectionCard)N(content)341@16317L6,341@16355L25,339@16204L176:noteCreationPane.kt#ku1rws");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-34091516, i2, -1, "com.myscript.nebo.note.ui.compose.NoteCreationSectionCard (noteCreationPane.kt:338)");
            }
            CardKt.m4173CardFjzlyU(null, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(8)), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.03f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, C1486Dp.m11017constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-1229795417, true, new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NoteCreationPaneKt.NoteCreationSectionCard$lambda$0(content, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1769472, 25);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteCreationPaneKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NoteCreationPaneKt.NoteCreationSectionCard$lambda$1(content, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCreationSectionCard$lambda$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C342@16365L9:noteCreationPane.kt#ku1rws");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229795417, i, -1, "com.myscript.nebo.note.ui.compose.NoteCreationSectionCard.<anonymous> (noteCreationPane.kt:342)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final NoteCreationUIState NoteCreationPane$lambda$0(State<NoteCreationUIState> state) {
        return state.getValue();
    }

    private static final List<LanguageManagerItem> NoteCreationPane$lambda$1(State<? extends List<? extends LanguageManagerItem>> state) {
        return (List) state.getValue();
    }
}
