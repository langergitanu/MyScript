package com.myscript.nebo.note;

import android.content.ComponentCallbacks2;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.note.p030ui.compose.CoverData;
import com.myscript.nebo.note.p030ui.compose.CoverKt;
import com.myscript.snt.core.PageKey;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NoteEditingViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000fJ\b\u0010 \u001a\u00020\u0014H\u0002J\u0006\u0010!\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/note/NoteEditingViewModel;", "Landroidx/lifecycle/ViewModel;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/myscript/snt/core/PageKey;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "<init>", "(Lcom/myscript/snt/core/PageKey;Lcom/myscript/nebo/dms/core/LibraryRepository;)V", "getKey", "()Lcom/myscript/snt/core/PageKey;", "getLibraryRepository", "()Lcom/myscript/nebo/dms/core/LibraryRepository;", "hasCover", "", "currentTitle", "", "currentCover", "Lcom/myscript/nebo/note/ui/compose/CoverData;", "_noteEditingUIState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/note/NoteEditingUIState;", "kotlin.jvm.PlatformType", "noteEditingUIState", "Landroidx/lifecycle/LiveData;", "getNoteEditingUIState", "()Landroidx/lifecycle/LiveData;", "setCoverColor", "", FirebaseAnalytics.Param.INDEX, "", "setTitle", "title", "computeNoteEditionUIState", "applyChanges", "NoteEditionViewModelFactory", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteEditingViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<NoteEditingUIState> _noteEditingUIState;
    private CoverData currentCover;
    private String currentTitle;
    private final boolean hasCover;
    private final PageKey key;
    private final LibraryRepository libraryRepository;

    public NoteEditingViewModel(PageKey key, LibraryRepository libraryRepository) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        this.key = key;
        this.libraryRepository = libraryRepository;
        this.currentTitle = "";
        this.currentCover = new CoverData(ExtensionsKt.persistentListOf(), null, 2, null);
        this._noteEditingUIState = new MutableLiveData<>(new NoteEditingUIState(null, false, null, null, 15, null));
        PageModel page = libraryRepository.getPage(key);
        if (page == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        this.hasCover = page.isContainer();
        this.currentTitle = page.getTitle();
        this.currentCover = CoverKt.getCoverData(page);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66431(null), 3, null);
    }

    public final PageKey getKey() {
        return this.key;
    }

    public final LibraryRepository getLibraryRepository() {
        return this.libraryRepository;
    }

    public final LiveData<NoteEditingUIState> getNoteEditingUIState() {
        return this._noteEditingUIState;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteEditingViewModel$1 */
    /* JADX INFO: compiled from: NoteEditingViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteEditingViewModel$1", m1609f = "NoteEditingViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66431(Continuation<? super C66431> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditingViewModel.this.new C66431(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteEditingViewModel.this._noteEditingUIState.setValue(NoteEditingViewModel.this.computeNoteEditionUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setCoverColor(int index) {
        CoverData coverData;
        ImmutableList<CoverData> availableNoteCovers;
        NoteEditingUIState value = this._noteEditingUIState.getValue();
        if (value == null || (availableNoteCovers = value.getAvailableNoteCovers()) == null || (coverData = availableNoteCovers.get(index)) == null) {
            coverData = new CoverData(ExtensionsKt.persistentListOf(), null, 2, null);
        }
        this.currentCover = new CoverData(coverData.getColors(), this.currentCover.getOrientation());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66441(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteEditingViewModel$setCoverColor$1 */
    /* JADX INFO: compiled from: NoteEditingViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteEditingViewModel$setCoverColor$1", m1609f = "NoteEditingViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66441(Continuation<? super C66441> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditingViewModel.this.new C66441(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteEditingViewModel.this._noteEditingUIState.setValue(NoteEditingViewModel.this.computeNoteEditionUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.note.NoteEditingViewModel$setTitle$1 */
    /* JADX INFO: compiled from: NoteEditingViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.note.NoteEditingViewModel$setTitle$1", m1609f = "NoteEditingViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C66451(Continuation<? super C66451> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteEditingViewModel.this.new C66451(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NoteEditingViewModel.this._noteEditingUIState.setValue(NoteEditingViewModel.this.computeNoteEditionUIState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.currentTitle = title;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C66451(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NoteEditingUIState computeNoteEditionUIState() {
        return new NoteEditingUIState(this.currentTitle, this.hasCover, null, this.currentCover, 4, null);
    }

    public final void applyChanges() {
        LibraryRepository libraryRepository = this.libraryRepository;
        PageKey pageKey = this.key;
        String str = this.currentTitle;
        ImmutableList<Color> colors = this.currentCover.getColors();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(colors, 10));
        Iterator<Color> it = colors.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(ColorKt.m8202toArgb8_81llA(it.next().m8158unboximpl())));
        }
        libraryRepository.editPaginatedContainer(pageKey, str, arrayList);
    }

    /* JADX INFO: compiled from: NoteEditingViewModel.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/note/NoteEditingViewModel$NoteEditionViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/myscript/snt/core/PageKey;", "<init>", "(Lcom/myscript/snt/core/PageKey;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class NoteEditionViewModelFactory implements ViewModelProvider.Factory {
        public static final int $stable = 8;
        private final PageKey key;

        public NoteEditionViewModelFactory(PageKey key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(Class<T> cls) {
            return (T) super.create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
            return (T) super.create(kClass, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (modelClass.isAssignableFrom(NoteEditingViewModel.class)) {
                ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(extras);
                Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
                return new NoteEditingViewModel(this.key, ((LibraryRepository.Provider) componentCallbacks2RequireApplication).provideLibraryRepository());
            }
            throw new IllegalArgumentException("Unknown ViewModel " + modelClass);
        }
    }
}
