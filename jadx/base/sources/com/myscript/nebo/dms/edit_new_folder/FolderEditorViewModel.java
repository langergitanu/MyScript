package com.myscript.nebo.dms.edit_new_folder;

import android.content.ComponentCallbacks2;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.FolderPropertiesValidator;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.snt.core.CollectionKey;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FolderEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\"BY\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u001c\u001a\u00020\u001a2\b\b\u0001\u0010\r\u001a\u00020\u000eJ<\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0001\u0010\r\u001a\u00020\u000eJZ\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u001a\u0010!\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0002R\"\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "folderValidator", "Lkotlin/Function2;", "Lcom/myscript/snt/core/CollectionKey;", "", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", "folderCreateEditAction", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorAction;", "folderName", "collectionKey", "collectionNames", "", "color", "", "<init>", "(Lkotlin/jvm/functions/Function2;Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorAction;Ljava/lang/String;Lcom/myscript/snt/core/CollectionKey;Ljava/util/Map;I)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorState;", "kotlin.jvm.PlatformType", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "setFolderName", "", "setCollectionKey", "setFolderColor", "update", "createInitialState", "folderEditorAction", "collections", "validate", "Factory", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FolderEditorViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<FolderEditorState> _state;
    private final FolderEditorAction folderCreateEditAction;
    private final Function2<CollectionKey, String, FolderPropertiesValidator.Status> folderValidator;

    /* JADX INFO: compiled from: FolderEditorViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FolderEditorAction.values().length];
            try {
                iArr[FolderEditorAction.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FolderEditorAction.EDIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FolderEditorViewModel(Function2<? super CollectionKey, ? super String, ? extends FolderPropertiesValidator.Status> folderValidator, FolderEditorAction folderCreateEditAction, String folderName, CollectionKey collectionKey, Map<CollectionKey, String> collectionNames, int i) {
        Intrinsics.checkNotNullParameter(folderValidator, "folderValidator");
        Intrinsics.checkNotNullParameter(folderCreateEditAction, "folderCreateEditAction");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(collectionNames, "collectionNames");
        this.folderValidator = folderValidator;
        this.folderCreateEditAction = folderCreateEditAction;
        this._state = new MutableLiveData<>(createInitialState(folderCreateEditAction, folderName, collectionKey, collectionNames, i, folderValidator));
    }

    public final LiveData<FolderEditorState> getState() {
        return this._state;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$setFolderName$1 */
    /* JADX INFO: compiled from: FolderEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$setFolderName$1", m1609f = "FolderEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $folderName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62581(String str, Continuation<? super C62581> continuation) {
            super(2, continuation);
            this.$folderName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FolderEditorViewModel.this.new C62581(this.$folderName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FolderEditorState folderEditorState = (FolderEditorState) FolderEditorViewModel.this._state.getValue();
                if (folderEditorState != null) {
                    FolderEditorViewModel folderEditorViewModel = FolderEditorViewModel.this;
                    String str = this.$folderName;
                    folderEditorViewModel._state.setValue(FolderEditorState.copy$default(folderEditorState, 0, 0, FolderEditorViewModelKt.isActionAllowed(folderEditorState.getCollectionKey(), str, folderEditorViewModel.folderValidator), str, null, null, 0, null, PDFACompliance.e_PDFA2_4_3, null));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setFolderName(String folderName) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62581(folderName, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$setCollectionKey$1 */
    /* JADX INFO: compiled from: FolderEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$setCollectionKey$1", m1609f = "FolderEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CollectionKey $collectionKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62561(CollectionKey collectionKey, Continuation<? super C62561> continuation) {
            super(2, continuation);
            this.$collectionKey = collectionKey;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FolderEditorViewModel.this.new C62561(this.$collectionKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = FolderEditorViewModel.this._state;
                FolderEditorState folderEditorState = (FolderEditorState) FolderEditorViewModel.this._state.getValue();
                mutableLiveData.setValue(folderEditorState != null ? FolderEditorState.copy$default(folderEditorState, 0, 0, false, null, this.$collectionKey, null, 0, null, 239, null) : null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setCollectionKey(CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62561(collectionKey, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$setFolderColor$1 */
    /* JADX INFO: compiled from: FolderEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$setFolderColor$1", m1609f = "FolderEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $color;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62571(int i, Continuation<? super C62571> continuation) {
            super(2, continuation);
            this.$color = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FolderEditorViewModel.this.new C62571(this.$color, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = FolderEditorViewModel.this._state;
                FolderEditorState folderEditorState = (FolderEditorState) FolderEditorViewModel.this._state.getValue();
                mutableLiveData.setValue(folderEditorState != null ? FolderEditorState.copy$default(folderEditorState, 0, 0, false, null, null, null, this.$color, null, 191, null) : null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setFolderColor(int color) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62571(color, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$update$1 */
    /* JADX INFO: compiled from: FolderEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$update$1", m1609f = "FolderEditorViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CollectionKey $collectionKey;
        final /* synthetic */ Map<CollectionKey, String> $collectionNames;
        final /* synthetic */ int $color;
        final /* synthetic */ FolderEditorAction $folderCreateEditAction;
        final /* synthetic */ String $folderName;
        int label;

        /* JADX INFO: renamed from: com.myscript.nebo.dms.edit_new_folder.FolderEditorViewModel$update$1$WhenMappings */
        /* JADX INFO: compiled from: FolderEditorViewModel.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FolderEditorAction.values().length];
                try {
                    iArr[FolderEditorAction.CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FolderEditorAction.EDIT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62591(FolderEditorAction folderEditorAction, CollectionKey collectionKey, String str, Map<CollectionKey, String> map, int i, Continuation<? super C62591> continuation) {
            super(2, continuation);
            this.$folderCreateEditAction = folderEditorAction;
            this.$collectionKey = collectionKey;
            this.$folderName = str;
            this.$collectionNames = map;
            this.$color = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FolderEditorViewModel.this.new C62591(this.$folderCreateEditAction, this.$collectionKey, this.$folderName, this.$collectionNames, this.$color, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            int i2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = FolderEditorViewModel.this._state;
                int i3 = WhenMappings.$EnumSwitchMapping$0[this.$folderCreateEditAction.ordinal()];
                if (i3 == 1) {
                    i = C6208R.string.dialog_new_folder_title;
                } else {
                    if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = C6208R.string.dialog_edit_folder_title;
                }
                int i4 = WhenMappings.$EnumSwitchMapping$0[this.$folderCreateEditAction.ordinal()];
                if (i4 == 1) {
                    i2 = C6208R.string.action_create_notebook;
                } else {
                    if (i4 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i2 = C6208R.string.dms_edit;
                }
                mutableLiveData.setValue(new FolderEditorState(i, i2, FolderEditorViewModelKt.isActionAllowed(this.$collectionKey, this.$folderName, FolderEditorViewModel.this.folderValidator), this.$folderName, this.$collectionKey, ExtensionsKt.toImmutableMap(this.$collectionNames), this.$color, FolderEditorViewModelKt.colors));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void update(FolderEditorAction folderCreateEditAction, String folderName, CollectionKey collectionKey, Map<CollectionKey, String> collectionNames, int color) {
        Intrinsics.checkNotNullParameter(folderCreateEditAction, "folderCreateEditAction");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(collectionNames, "collectionNames");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C62591(folderCreateEditAction, collectionKey, folderName, collectionNames, color, null), 3, null);
    }

    private final FolderEditorState createInitialState(FolderEditorAction folderEditorAction, String folderName, CollectionKey collectionKey, Map<CollectionKey, String> collections, int color, Function2<? super CollectionKey, ? super String, ? extends FolderPropertiesValidator.Status> validate) {
        int i;
        int i2;
        int i3 = WhenMappings.$EnumSwitchMapping$0[folderEditorAction.ordinal()];
        if (i3 == 1) {
            i = C6208R.string.dialog_new_folder_title;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = C6208R.string.dialog_edit_folder_title;
        }
        int i4 = i;
        int i5 = WhenMappings.$EnumSwitchMapping$0[folderEditorAction.ordinal()];
        if (i5 == 1) {
            i2 = C6208R.string.action_create_notebook;
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = C6208R.string.dms_edit;
        }
        int i6 = i2;
        CollectionKey collectionKey2 = collections.keySet().contains(collectionKey) ? collectionKey : null;
        if (collectionKey2 == null && (collectionKey2 = (CollectionKey) CollectionsKt.firstOrNull(collections.keySet())) == null) {
            collectionKey2 = new CollectionKey();
        }
        return new FolderEditorState(i4, i6, FolderEditorViewModelKt.isActionAllowed(collectionKey, folderName, validate), folderName, collectionKey2, ExtensionsKt.toImmutableMap(collections), color, FolderEditorViewModelKt.colors);
    }

    /* JADX INFO: compiled from: FolderEditorViewModel.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "folderCreateEditAction", "Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorAction;", "folderName", "", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "collectionNames", "", "color", "", "<init>", "(Lcom/myscript/nebo/dms/edit_new_folder/FolderEditorAction;Ljava/lang/String;Lcom/myscript/snt/core/CollectionKey;Ljava/util/Map;I)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Factory implements ViewModelProvider.Factory {
        public static final int $stable = 8;
        private CollectionKey collectionKey;
        private Map<CollectionKey, String> collectionNames;
        private int color;
        private FolderEditorAction folderCreateEditAction;
        private String folderName;

        public Factory() {
            this(null, null, null, null, 0, 31, null);
        }

        public Factory(FolderEditorAction folderCreateEditAction, String folderName, CollectionKey collectionKey, Map<CollectionKey, String> collectionNames, int i) {
            Intrinsics.checkNotNullParameter(folderCreateEditAction, "folderCreateEditAction");
            Intrinsics.checkNotNullParameter(folderName, "folderName");
            Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
            Intrinsics.checkNotNullParameter(collectionNames, "collectionNames");
            this.folderCreateEditAction = folderCreateEditAction;
            this.folderName = folderName;
            this.collectionKey = collectionKey;
            this.collectionNames = collectionNames;
            this.color = i;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(Class<T> cls) {
            return (T) super.create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
            return (T) super.create(kClass, creationExtras);
        }

        public /* synthetic */ Factory(FolderEditorAction folderEditorAction, String str, CollectionKey collectionKey, Map map, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? FolderEditorAction.CREATE : folderEditorAction, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? new CollectionKey() : collectionKey, (i2 & 8) != 0 ? MapsKt.emptyMap() : map, (i2 & 16) != 0 ? 0 : i);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (modelClass.isAssignableFrom(FolderEditorViewModel.class)) {
                ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(extras);
                Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
                return new FolderEditorViewModel(new FolderEditorViewModel$Factory$create$1(((LibraryRepository.Provider) componentCallbacks2RequireApplication).provideLibraryRepository()), this.folderCreateEditAction, this.folderName, this.collectionKey, this.collectionNames, this.color);
            }
            throw new IllegalArgumentException("Unknown ViewModel " + modelClass);
        }
    }
}
