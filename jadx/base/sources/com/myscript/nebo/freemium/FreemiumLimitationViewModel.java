package com.myscript.nebo.freemium;

import android.content.ComponentCallbacks2;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "Landroidx/lifecycle/ViewModel;", "profileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "isFreemiumBusinessModelEnabled", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/myscript/nebo/account/UserProfileManager;ZLkotlinx/coroutines/CoroutineDispatcher;)V", "_freemiumLimitationDialogState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/freemium/FreemiumLimitationDialogState;", "freemiumLimitationDialogState", "Landroidx/lifecycle/LiveData;", "getFreemiumLimitationDialogState", "()Landroidx/lifecycle/LiveData;", "closeFreemiumLimitationDialog", "", "tryUsePremiumFeature", "freemiumLimitationTrigger", "Lcom/myscript/nebo/freemium/FreemiumLimitationTrigger;", "premiumFeature", "Lkotlin/Function0;", "trigger", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FreemiumLimitationViewModel extends ViewModel {
    public static final ViewModelProvider.Factory Factory;
    private MutableLiveData<FreemiumLimitationDialogState> _freemiumLimitationDialogState;
    private final boolean isFreemiumBusinessModelEnabled;
    private final CoroutineDispatcher mainDispatcher;
    private final UserProfileManager profileManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public FreemiumLimitationViewModel(UserProfileManager profileManager, boolean z, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(profileManager, "profileManager");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.profileManager = profileManager;
        this.isFreemiumBusinessModelEnabled = z;
        this.mainDispatcher = mainDispatcher;
        this._freemiumLimitationDialogState = new MutableLiveData<>(new FreemiumLimitationDialogState(null, false, 0, 0, 0, 31, null));
    }

    public /* synthetic */ FreemiumLimitationViewModel(UserProfileManager userProfileManager, boolean z, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(userProfileManager, z, (i & 4) != 0 ? Dispatchers.getMain() : mainCoroutineDispatcher);
    }

    public final LiveData<FreemiumLimitationDialogState> getFreemiumLimitationDialogState() {
        return this._freemiumLimitationDialogState;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.freemium.FreemiumLimitationViewModel$closeFreemiumLimitationDialog$1 */
    /* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.freemium.FreemiumLimitationViewModel$closeFreemiumLimitationDialog$1", m1609f = "FreemiumLimitationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64641(Continuation<? super C64641> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FreemiumLimitationViewModel.this.new C64641(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData = FreemiumLimitationViewModel.this._freemiumLimitationDialogState;
                FreemiumLimitationDialogState freemiumLimitationDialogState = (FreemiumLimitationDialogState) FreemiumLimitationViewModel.this._freemiumLimitationDialogState.getValue();
                mutableLiveData.setValue(freemiumLimitationDialogState != null ? FreemiumLimitationDialogState.copy$default(freemiumLimitationDialogState, null, false, 0, 0, 0, 29, null) : null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void closeFreemiumLimitationDialog() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64641(null), 2, null);
    }

    public final void tryUsePremiumFeature(FreemiumLimitationTrigger freemiumLimitationTrigger, Function0<Unit> premiumFeature) {
        Intrinsics.checkNotNullParameter(freemiumLimitationTrigger, "freemiumLimitationTrigger");
        Intrinsics.checkNotNullParameter(premiumFeature, "premiumFeature");
        if (this.profileManager.hasAccessToAllFeatures()) {
            premiumFeature.invoke();
        } else {
            trigger(freemiumLimitationTrigger);
        }
    }

    public final void trigger(FreemiumLimitationTrigger trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        if (this.isFreemiumBusinessModelEnabled) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.mainDispatcher, null, new C64651(trigger, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.freemium.FreemiumLimitationViewModel$trigger$1 */
    /* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.freemium.FreemiumLimitationViewModel$trigger$1", m1609f = "FreemiumLimitationViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C64651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FreemiumLimitationTrigger $trigger;
        int label;

        /* JADX INFO: renamed from: com.myscript.nebo.freemium.FreemiumLimitationViewModel$trigger$1$WhenMappings */
        /* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FreemiumLimitationTrigger.values().length];
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_EDIT_MENU_LASSO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_CONVERT_BLOCK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_CONVERT_ALL_BUTTON.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_CONVERSION_PREVIEW_TOGGLE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_AI_TAP_ON_BUTTON.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_AI_BUTTON_SHOW_HIDE_SETTING.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_AI_EDIT_MENU_ENTRY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_GRID_CREATE_BUTTON.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_GRID_VIEW_DUPLICATE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_OPENING_AN_EXTERNAL_PDF.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_ADD_A_PAGE_FROM_LONG_NOTE_BANNER.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_IMPORT_AS_PDF_BUTTON.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_SHAPE_ON_HOLD_GESTURE.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_SCRATCH_GESTURE.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_SYNC_SETTING_INTERACTION.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[FreemiumLimitationTrigger.TRIGGER_PDF_INSERT_BLANK_PAGE.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C64651(FreemiumLimitationTrigger freemiumLimitationTrigger, Continuation<? super C64651> continuation) {
            super(2, continuation);
            this.$trigger = freemiumLimitationTrigger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FreemiumLimitationViewModel.this.new C64651(this.$trigger, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FreemiumLimitationDialogState freemiumLimitationDialogState;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NeboFirebaseEvent neboFirebaseEvent = NeboFirebaseEvent.premiumModal;
            final FreemiumLimitationTrigger freemiumLimitationTrigger = this.$trigger;
            neboFirebaseEvent.log(new Function1() { // from class: com.myscript.nebo.freemium.FreemiumLimitationViewModel$trigger$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FreemiumLimitationViewModel.C64651.invokeSuspend$lambda$0(freemiumLimitationTrigger, (Bundle) obj2);
                }
            });
            MutableLiveData mutableLiveData = FreemiumLimitationViewModel.this._freemiumLimitationDialogState;
            switch (WhenMappings.$EnumSwitchMapping$0[this.$trigger.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, true, C6471R.drawable.freemium_limitation_convert, C6471R.string.freemium_limitation_dialog_convert_title, C6471R.string.freemium_limitation_dialog_convert_text, 1, null);
                    break;
                case 5:
                case 6:
                case 7:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, true, C6471R.drawable.freemium_limitation_ai, C6471R.string.freemium_limitation_dialog_ai_title, C6471R.string.freemium_limitation_dialog_ai_text, 1, null);
                    break;
                case 8:
                case 9:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, true, C6471R.drawable.freemium_limitation_formats, C6471R.string.freemium_limitation_dialog_board_and_document_title, C6471R.string.freemium_limitation_dialog_board_and_document_text, 1, null);
                    break;
                case 10:
                case 11:
                case 12:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, true, C6471R.drawable.freemium_limitation_import, C6471R.string.freemium_limitation_dialog_pdf_title, C6471R.string.freemium_limitation_dialog_pdf_text, 1, null);
                    break;
                case 13:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, true, C6471R.drawable.freemium_limitation_shapes, C6471R.string.freemium_limitation_dialog_shapes_title, C6471R.string.freemium_limitation_dialog_shapes_text, 1, null);
                    break;
                case 14:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, true, C6471R.drawable.freemium_limitation_scratch, C6471R.string.freemium_limitation_dialog_scratch_title, C6471R.string.freemium_limitation_dialog_scratch_text, 1, null);
                    break;
                case 15:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, true, C6471R.drawable.freemium_limitation_sync, C6471R.string.freemium_limitation_dialog_sync_title, C6471R.string.freemium_limitation_dialog_sync_text, 1, null);
                    break;
                case 16:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, true, C6471R.drawable.freemium_limitation_pdf, C6471R.string.freemium_limitation_dialog_add_pdf_page_title, C6471R.string.freemium_limitation_dialog_add_pdf_page_text, 1, null);
                    break;
                default:
                    freemiumLimitationDialogState = new FreemiumLimitationDialogState(null, false, 0, 0, 0, 31, null);
                    break;
            }
            mutableLiveData.setValue(freemiumLimitationDialogState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(FreemiumLimitationTrigger freemiumLimitationTrigger, Bundle bundle) {
            bundle.putString("origin", FreemiumLimitationViewModelKt.getOriginForAnalytics(freemiumLimitationTrigger));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel$Companion;", "", "<init>", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FreemiumLimitationViewModel Companion$Factory$lambda$0$0(CreationExtras initializer) {
            Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
            ComponentCallbacks2 componentCallbacks2RequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
            Intrinsics.checkNotNull(componentCallbacks2RequireApplication, "null cannot be cast to non-null type com.myscript.nebo.freemium.FreemiumBusinessModelStatus");
            return new FreemiumLimitationViewModel(((UserProfileManager.Provider) componentCallbacks2RequireApplication).provideUserProfileManager(), ((FreemiumBusinessModelStatus) componentCallbacks2RequireApplication).isFreemiumBusinessModelEnabled(), null, 4, null);
        }
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function1() { // from class: com.myscript.nebo.freemium.FreemiumLimitationViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FreemiumLimitationViewModel.Companion.Companion$Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
