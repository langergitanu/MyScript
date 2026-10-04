package com.myscript.nebo.note;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.preference.PreferenceManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.IntSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.BackgroundPatternExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.note.NoteCreationViewModel;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import com.myscript.nebo.note.p030ui.PageBackgroundPatternKt;
import com.myscript.nebo.note.p030ui.compose.CoverData;
import com.myscript.nebo.note.p030ui.compose.CoverKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010)\u001a\u00020#H\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u001dJ\u000e\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\u001fJ\u000e\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u001aJ\u000e\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u0018J\u000e\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\u0007J\u0006\u00109\u001a\u00020+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010#0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020#0&8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006;"}, m1599d2 = {"Lcom/myscript/nebo/note/NoteCreationViewModel;", "Landroidx/lifecycle/ViewModel;", "noteType", "Lcom/myscript/nebo/note/NoteType;", "sharedPreferences", "Landroid/content/SharedPreferences;", "lastChosenLanguage", "", "<init>", "(Lcom/myscript/nebo/note/NoteType;Landroid/content/SharedPreferences;Ljava/lang/String;)V", "defaultPageBackgroundPattern", "Lcom/myscript/atk/core/BackgroundPattern;", "getDefaultPageBackgroundPattern", "()Lcom/myscript/atk/core/BackgroundPattern;", "lastChosenPageBackgroundColor", "", "getLastChosenPageBackgroundColor", "()I", "lastChosenPageBackgroundColor$delegate", "Lcom/myscript/android/utils/IntSharedPreferencesProperty;", "lastChosenPageBackgroundPattern", "getLastChosenPageBackgroundPattern", "currentName", "currentOrientation", "Lcom/myscript/nebo/note/Orientation;", "currentPageSize", "Lcom/myscript/nebo/note/PageSize;", "currentCoverColorIndex", "currentPageBackgroundColor", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "currentPageBackgroundPattern", "Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "currentLanguage", "_noteCreationUIState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/note/NoteCreationUIState;", "kotlin.jvm.PlatformType", "noteCreationUIState", "Landroidx/lifecycle/LiveData;", "getNoteCreationUIState", "()Landroidx/lifecycle/LiveData;", "computeUIState", "setName", "", "name", "setCoverColor", FirebaseAnalytics.Param.INDEX, "setPageColor", "color", "setPagePattern", "pattern", "setPageSize", "pageSize", "setOrientation", "orientation", "setLanguage", "languageKey", "confirmNoteCreation", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteCreationViewModel extends ViewModel {
    private static final String LAST_CHOSEN_PAGE_BACKGROUND_COLOR_PREFIX = "LAST_CHOSEN_PAGE_BACKGROUND_COLOR";
    private static final String LAST_CHOSEN_PAGE_BACKGROUND_PATTERN_PREFIX = "LAST_CHOSEN_PAGE_BACKGROUND_PATTERN";
    private final MutableLiveData<NoteCreationUIState> _noteCreationUIState;
    private int currentCoverColorIndex;
    private String currentLanguage;
    private String currentName;
    private Orientation currentOrientation;
    private PageBackgroundColor currentPageBackgroundColor;
    private PageBackgroundPattern currentPageBackgroundPattern;
    private PageSize currentPageSize;

    /* JADX INFO: renamed from: lastChosenPageBackgroundColor$delegate, reason: from kotlin metadata */
    private final IntSharedPreferencesProperty lastChosenPageBackgroundColor;
    private final NoteType noteType;
    private final SharedPreferences sharedPreferences;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new PropertyReference1Impl(NoteCreationViewModel.class, "lastChosenPageBackgroundColor", "getLastChosenPageBackgroundColor()I", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NoteType.values().length];
            try {
                iArr[NoteType.Notebook.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NoteType.Board.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NoteType.Document.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NoteCreationViewModel(NoteType noteType, SharedPreferences sharedPreferences, String lastChosenLanguage) {
        PageBackgroundColor next;
        PageBackgroundPattern next2;
        Intrinsics.checkNotNullParameter(noteType, "noteType");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(lastChosenLanguage, "lastChosenLanguage");
        this.noteType = noteType;
        this.sharedPreferences = sharedPreferences;
        this.lastChosenPageBackgroundColor = SharedPreferencesExtKt.intPref(sharedPreferences, INSTANCE.preferenceKeyForNoteType(LAST_CHOSEN_PAGE_BACKGROUND_COLOR_PREFIX, noteType), ((Number) CollectionsKt.first((List) PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS())).intValue());
        this.currentName = "";
        this.currentOrientation = Orientation.Portrait;
        this.currentPageSize = (PageSize) CollectionsKt.first((List) NoteCreationViewModelKt.getPageSizes());
        Iterator<PageBackgroundColor> it = NoteCreationViewModelKt.getPageBackgroundColors().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.getColor() == getLastChosenPageBackgroundColor()) {
                    break;
                }
            }
        }
        PageBackgroundColor pageBackgroundColor = next;
        this.currentPageBackgroundColor = pageBackgroundColor == null ? (PageBackgroundColor) CollectionsKt.first((List) NoteCreationViewModelKt.getPageBackgroundColors()) : pageBackgroundColor;
        Iterator<PageBackgroundPattern> it2 = PageBackgroundPatternKt.getPageBackgroundPatterns().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            } else {
                next2 = it2.next();
                if (next2.getPattern() == getLastChosenPageBackgroundPattern()) {
                    break;
                }
            }
        }
        PageBackgroundPattern pageBackgroundPattern = next2;
        this.currentPageBackgroundPattern = pageBackgroundPattern == null ? (PageBackgroundPattern) CollectionsKt.first((List) PageBackgroundPatternKt.getPageBackgroundPatterns()) : pageBackgroundPattern;
        this.currentLanguage = lastChosenLanguage;
        this._noteCreationUIState = new MutableLiveData<>(new NoteCreationUIState(0, null, 0, null, null, null, null, 127, null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66351(null), 3, null);
    }

    public /* synthetic */ NoteCreationViewModel(NoteType noteType, SharedPreferences sharedPreferences, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(noteType, sharedPreferences, (i & 4) != 0 ? "en_US" : str);
    }

    private final BackgroundPattern getDefaultPageBackgroundPattern() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.noteType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return BackgroundPattern.NONE;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getLastChosenPageBackgroundColor() {
        return this.lastChosenPageBackgroundColor.getValue((Object) this, $$delegatedProperties[0]).intValue();
    }

    private final BackgroundPattern getLastChosenPageBackgroundPattern() {
        BackgroundPattern backgroundPatternFromString;
        String string = this.sharedPreferences.getString(INSTANCE.preferenceKeyForNoteType(LAST_CHOSEN_PAGE_BACKGROUND_PATTERN_PREFIX, this.noteType), null);
        return (string == null || (backgroundPatternFromString = BackgroundPatternExt.fromString(string)) == null) ? getDefaultPageBackgroundPattern() : backgroundPatternFromString;
    }

    public final LiveData<NoteCreationUIState> getNoteCreationUIState() {
        return this._noteCreationUIState;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteCreationViewModel$1 */
    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteCreationViewModel$1", m1609f = "NoteCreationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66351(Continuation<? super C66351> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteCreationViewModel.this.new C66351(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteCreationViewModel.this._noteCreationUIState.setValue(NoteCreationViewModel.this.computeUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NoteCreationUIState computeUIState() {
        int i;
        int i2;
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.noteType.ordinal()];
        if (i3 == 1) {
            i = C6079R.string.note_creation_title_notebook;
        } else if (i3 == 2) {
            i = C6079R.string.note_creation_title_board;
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = C6079R.string.note_creation_title_document;
        }
        int i4 = i;
        int i5 = WhenMappings.$EnumSwitchMapping$0[this.noteType.ordinal()];
        if (i5 == 1) {
            i2 = C6079R.string.note_creation_name_hint_notebook;
        } else if (i5 == 2) {
            i2 = C6079R.string.note_creation_name_hint_board;
        } else {
            if (i5 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = C6079R.string.note_creation_name_hint_document;
        }
        int i6 = i2;
        String str = this.currentName;
        boolean z = this.noteType == NoteType.Notebook;
        NotebookDetailsState notebookDetailsState = new NotebookDetailsState(z, null, this.currentPageSize, null, null, new CoverData(((CoverData) CoverKt.getCoverColorsList().get(this.currentCoverColorIndex)).getColors(), this.currentOrientation), this.currentCoverColorIndex, 26, null);
        PersistentList<PageBackgroundColor> pageBackgroundColors = NoteCreationViewModelKt.getPageBackgroundColors();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pageBackgroundColors, 10));
        for (PageBackgroundColor pageBackgroundColor : pageBackgroundColors) {
            arrayList.add(PageBackgroundColor.copy$default(pageBackgroundColor, 0, 0, pageBackgroundColor.getColor() == this.currentPageBackgroundColor.getColor(), 3, null));
        }
        PageColorState pageColorState = new PageColorState(false, ExtensionsKt.toPersistentList(arrayList), 1, null);
        boolean z2 = this.noteType != NoteType.Document;
        PersistentList<PageBackgroundPattern> pageBackgroundPatterns = PageBackgroundPatternKt.getPageBackgroundPatterns();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(pageBackgroundPatterns, 10));
        for (PageBackgroundPattern pageBackgroundPattern : pageBackgroundPatterns) {
            arrayList2.add(PageBackgroundPattern.copy$default(pageBackgroundPattern, null, pageBackgroundPattern.getPattern() == this.currentPageBackgroundPattern.getPattern(), 1, null));
        }
        return new NoteCreationUIState(i4, str, i6, notebookDetailsState, pageColorState, new PagePatternState(z2, ExtensionsKt.toPersistentList(arrayList2)), this.currentLanguage);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteCreationViewModel$setName$1 */
    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteCreationViewModel$setName$1", m1609f = "NoteCreationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66381(Continuation<? super C66381> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteCreationViewModel.this.new C66381(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteCreationViewModel.this._noteCreationUIState.setValue(NoteCreationViewModel.this.computeUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.currentName = name;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66381(null), 3, null);
    }

    public final void setCoverColor(int index) {
        this.currentCoverColorIndex = RangesKt.coerceIn(index, 0, CoverKt.getCoverColorsList().size() - 1);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66361(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteCreationViewModel$setCoverColor$1 */
    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteCreationViewModel$setCoverColor$1", m1609f = "NoteCreationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66361(Continuation<? super C66361> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteCreationViewModel.this.new C66361(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteCreationViewModel.this._noteCreationUIState.setValue(NoteCreationViewModel.this.computeUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteCreationViewModel$setPageColor$1 */
    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteCreationViewModel$setPageColor$1", m1609f = "NoteCreationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66401(Continuation<? super C66401> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteCreationViewModel.this.new C66401(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteCreationViewModel.this._noteCreationUIState.setValue(NoteCreationViewModel.this.computeUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setPageColor(PageBackgroundColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.currentPageBackgroundColor = color;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66401(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteCreationViewModel$setPagePattern$1 */
    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteCreationViewModel$setPagePattern$1", m1609f = "NoteCreationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66411(Continuation<? super C66411> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteCreationViewModel.this.new C66411(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteCreationViewModel.this._noteCreationUIState.setValue(NoteCreationViewModel.this.computeUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setPagePattern(PageBackgroundPattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.currentPageBackgroundPattern = pattern;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66411(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteCreationViewModel$setPageSize$1 */
    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteCreationViewModel$setPageSize$1", m1609f = "NoteCreationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66421(Continuation<? super C66421> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteCreationViewModel.this.new C66421(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteCreationViewModel.this._noteCreationUIState.setValue(NoteCreationViewModel.this.computeUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setPageSize(PageSize pageSize) {
        Intrinsics.checkNotNullParameter(pageSize, "pageSize");
        this.currentPageSize = pageSize;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66421(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteCreationViewModel$setOrientation$1 */
    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteCreationViewModel$setOrientation$1", m1609f = "NoteCreationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66391(Continuation<? super C66391> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteCreationViewModel.this.new C66391(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteCreationViewModel.this._noteCreationUIState.setValue(NoteCreationViewModel.this.computeUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setOrientation(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.currentOrientation = orientation;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66391(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteCreationViewModel$setLanguage$1 */
    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteCreationViewModel$setLanguage$1", m1609f = "NoteCreationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66371(Continuation<? super C66371> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteCreationViewModel.this.new C66371(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteCreationViewModel.this._noteCreationUIState.setValue(NoteCreationViewModel.this.computeUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setLanguage(String languageKey) {
        Intrinsics.checkNotNullParameter(languageKey, "languageKey");
        this.currentLanguage = languageKey;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66371(null), 3, null);
    }

    public final void confirmNoteCreation() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        Companion companion = INSTANCE;
        editorEdit.putInt(companion.preferenceKeyForNoteType(LAST_CHOSEN_PAGE_BACKGROUND_COLOR_PREFIX, this.noteType), this.currentPageBackgroundColor.getColor());
        editorEdit.putString(companion.preferenceKeyForNoteType(LAST_CHOSEN_PAGE_BACKGROUND_PATTERN_PREFIX, this.noteType), BackgroundPatternExt.toString(this.currentPageBackgroundPattern.getPattern()));
        editorEdit.apply();
    }

    /* JADX INFO: compiled from: NoteCreationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/note/NoteCreationViewModel$Companion;", "", "<init>", "()V", "LAST_CHOSEN_PAGE_BACKGROUND_COLOR_PREFIX", "", "LAST_CHOSEN_PAGE_BACKGROUND_PATTERN_PREFIX", "preferenceKeyForNoteType", "keyPrefix", "noteType", "Lcom/myscript/nebo/note/NoteType;", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "type", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: NoteCreationViewModel.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[NoteType.values().length];
                try {
                    iArr[NoteType.Notebook.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[NoteType.Board.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[NoteType.Document.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String preferenceKeyForNoteType(String keyPrefix, NoteType noteType) {
            int i = WhenMappings.$EnumSwitchMapping$0[noteType.ordinal()];
            if (i == 1) {
                return keyPrefix + "__NOTEBOOK";
            }
            if (i == 2) {
                return keyPrefix + "__BOARD";
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return keyPrefix + "__DOCUMENT";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final NoteCreationViewModel Factory$lambda$0$0(NoteType noteType, CreationExtras initializer) {
            Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
            Object objRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context) objRequireApplication);
            Intrinsics.checkNotNull(objRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
            LibraryRepository libraryRepositoryProvideLibraryRepository = ((LibraryRepository.Provider) objRequireApplication).provideLibraryRepository();
            String lastChosenLanguage = libraryRepositoryProvideLibraryRepository.getLastChosenLanguage();
            if (!libraryRepositoryProvideLibraryRepository.isLanguageAvailable(lastChosenLanguage)) {
                lastChosenLanguage = null;
            }
            if (lastChosenLanguage == null) {
                lastChosenLanguage = "en_US";
            }
            Intrinsics.checkNotNull(defaultSharedPreferences);
            return new NoteCreationViewModel(noteType, defaultSharedPreferences, lastChosenLanguage);
        }

        public final ViewModelProvider.Factory Factory(final NoteType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(NoteCreationViewModel.class), new Function1() { // from class: com.myscript.nebo.note.NoteCreationViewModel$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NoteCreationViewModel.Companion.Factory$lambda$0$0(type, (CreationExtras) obj);
                }
            });
            return initializerViewModelFactoryBuilder.build();
        }
    }
}
