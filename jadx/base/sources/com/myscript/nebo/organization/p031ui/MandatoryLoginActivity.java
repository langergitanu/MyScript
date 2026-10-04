package com.myscript.nebo.organization.p031ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.organization.p031ui.State;
import com.myscript.nebo.sso.C6821R;
import com.myscript.nebo.sso.api.SSOManager;
import com.myscript.nebo.sso.p032ui.WebViewActivity;
import com.myscript.nebo.sso.util.AccessTokenExtractorKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MandatoryLoginActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u0012H\u0094@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/organization/ui/MandatoryLoginActivity;", "Lcom/myscript/nebo/sso/ui/WebViewActivity;", "<init>", "()V", "viewModel", "Lcom/myscript/nebo/organization/ui/MandatoryLoginViewModel;", "getViewModel", "()Lcom/myscript/nebo/organization/ui/MandatoryLoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleState", "state", "Lcom/myscript/nebo/organization/ui/State;", "getOrFetchUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interceptUrl", "", ImagesContract.URL, "onCannotConnect", "shouldLoadPageAtStartup", "Companion", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MandatoryLoginActivity extends WebViewActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleState$lambda$2(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    @JvmStatic
    public static final Intent newIntent(Context context) {
        return INSTANCE.newIntent(context);
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity
    protected boolean shouldLoadPageAtStartup() {
        return false;
    }

    public MandatoryLoginActivity() {
        final MandatoryLoginActivity mandatoryLoginActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MandatoryLoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.organization.ui.MandatoryLoginActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mandatoryLoginActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.organization.ui.MandatoryLoginActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MandatoryLoginActivity.viewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.organization.ui.MandatoryLoginActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mandatoryLoginActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MandatoryLoginViewModel getViewModel() {
        return (MandatoryLoginViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0() {
        return MandatoryLoginViewModel.INSTANCE.getFactory();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.organization.ui.MandatoryLoginActivity$onCreate$1 */
    /* JADX INFO: compiled from: MandatoryLoginActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C66731 extends FunctionReferenceImpl implements Function1<State, Unit> {
        C66731(Object obj) {
            super(1, obj, MandatoryLoginActivity.class, "handleState", "handleState(Lcom/myscript/nebo/organization/ui/State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((MandatoryLoginActivity) this.receiver).handleState(p0);
        }
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().getState().observe(this, new MandatoryLoginActivity$sam$androidx_lifecycle_Observer$0(new C66731(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleState(State state) {
        if (Intrinsics.areEqual(state, State.Loading.INSTANCE)) {
            setOverlapProgressEnabled(true);
            return;
        }
        if (state instanceof State.Login) {
            setOverlapProgressEnabled(false);
            if (((State.Login) state).getHasUserBeenKickedOut()) {
                AlertDialog alertDialogShow = new MaterialAlertDialogBuilder(this).setTitle(C6821R.string.organization_popup_not_authorized_title).setMessage(C6821R.string.organization_popup_not_authorized_message).setPositiveButton(C6821R.string.organization_popup_not_authorized_back, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.organization.ui.MandatoryLoginActivity$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.reset();
                    }
                }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.myscript.nebo.organization.ui.MandatoryLoginActivity$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.reset();
                    }
                }).show();
                alertDialogShow.setCancelable(false);
                alertDialogShow.setCanceledOnTouchOutside(false);
                alertDialogShow.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.myscript.nebo.organization.ui.MandatoryLoginActivity$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        return MandatoryLoginActivity.handleState$lambda$2(dialogInterface, i, keyEvent);
                    }
                });
                return;
            }
            reset();
            return;
        }
        if (!Intrinsics.areEqual(state, State.LoggedIn.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        setOverlapProgressEnabled(false);
        setResult(-1);
        finish();
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity
    protected Object getOrFetchUrl(Continuation<? super String> continuation) {
        return getViewModel().getAuthorizeUrl(continuation);
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity
    protected boolean interceptUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!Intrinsics.areEqual(Uri.parse(SSOManager.REDIRECT_URI).getHost(), Uri.parse(url).getHost())) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C66721(url, this, null), 3, null);
        return true;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.organization.ui.MandatoryLoginActivity$interceptUrl$1 */
    /* JADX INFO: compiled from: MandatoryLoginActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.organization.ui.MandatoryLoginActivity$interceptUrl$1", m1609f = "MandatoryLoginActivity.kt", m1610i = {}, m1611l = {TsExtractor.TS_SYNC_BYTE}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {75}, m1615s = {}, m1616v = 2)
    static final class C66721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ MandatoryLoginActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66721(String str, MandatoryLoginActivity mandatoryLoginActivity, Continuation<? super C66721> continuation) {
            super(2, continuation);
            this.$url = str;
            this.this$0 = mandatoryLoginActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C66721(this.$url, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.organization.ui.MandatoryLoginActivity$interceptUrl$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: MandatoryLoginActivity.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.organization.ui.MandatoryLoginActivity$interceptUrl$1$1", m1609f = "MandatoryLoginActivity.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $url;
            int label;
            final /* synthetic */ MandatoryLoginActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, MandatoryLoginActivity mandatoryLoginActivity, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$url = str;
                this.this$0 = mandatoryLoginActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$url, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                String strExtractAuthCode = AccessTokenExtractorKt.extractAuthCode(this.$url);
                if (strExtractAuthCode == null) {
                    return Unit.INSTANCE;
                }
                this.this$0.getViewModel().login(strExtractAuthCode);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.$url, this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.sso.p032ui.WebViewActivity
    protected void onCannotConnect() {
        if (getViewModel().getState().getValue() instanceof State.Login) {
            super.onCannotConnect();
        }
    }

    /* JADX INFO: compiled from: MandatoryLoginActivity.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/organization/ui/MandatoryLoginActivity$Companion;", "", "<init>", "()V", "newIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "account_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Intent newIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) MandatoryLoginActivity.class);
        }
    }
}
