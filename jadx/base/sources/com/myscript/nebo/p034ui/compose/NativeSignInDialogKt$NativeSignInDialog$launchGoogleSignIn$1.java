package com.myscript.nebo.p034ui.compose;

import android.app.Activity;
import android.content.Context;
import androidx.compose.runtime.MutableState;
import com.myscript.nebo.sso.p032ui.login.GoogleSignInHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NativeSignInDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.ui.compose.NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1", m1609f = "NativeSignInDialog.kt", m1610i = {}, m1611l = {224}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {234}, m1615s = {}, m1616v = 2)
final class NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $googleServerClientId;
    final /* synthetic */ GoogleSignInHelper $googleSignInHelper;
    final /* synthetic */ Function0<Unit> $onClose;
    final /* synthetic */ MutableState<Boolean> $showProgress$delegate;
    final /* synthetic */ Function2<String, Continuation<? super Boolean>, Object> $startNativeLogin;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1(GoogleSignInHelper googleSignInHelper, Context context, String str, MutableState<Boolean> mutableState, Function2<? super String, ? super Continuation<? super Boolean>, ? extends Object> function2, Function0<Unit> function0, Continuation<? super NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1> continuation) {
        super(2, continuation);
        this.$googleSignInHelper = googleSignInHelper;
        this.$context = context;
        this.$googleServerClientId = str;
        this.$showProgress$delegate = mutableState;
        this.$startNativeLogin = function2;
        this.$onClose = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1(this.$googleSignInHelper, this.$context, this.$googleServerClientId, this.$showProgress$delegate, this.$startNativeLogin, this.$onClose, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NativeSignInDialogKt.NativeSignInDialog$lambda$4(this.$showProgress$delegate, true);
            GoogleSignInHelper googleSignInHelper = this.$googleSignInHelper;
            Context context = this.$context;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            String str = this.$googleServerClientId;
            C68861 c68861 = new C68861(this.$startNativeLogin, this.$onClose, this.$showProgress$delegate, null);
            final MutableState<Boolean> mutableState = this.$showProgress$delegate;
            this.label = 1;
            if (googleSignInHelper.launchGoogleSignIn(activity, str, c68861, new Function0() { // from class: com.myscript.nebo.ui.compose.NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1.invokeSuspend$lambda$0(mutableState);
                }
            }, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.myscript.nebo.ui.compose.NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1$1 */
    /* JADX INFO: compiled from: NativeSignInDialog.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "googleIdToken", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.ui.compose.NativeSignInDialogKt$NativeSignInDialog$launchGoogleSignIn$1$1", m1609f = "NativeSignInDialog.kt", m1610i = {0}, m1611l = {228}, m1612m = "invokeSuspend", m1613n = {"googleIdToken"}, m1614nl = {229}, m1615s = {"L$0"}, m1616v = 2)
    static final class C68861 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onClose;
        final /* synthetic */ MutableState<Boolean> $showProgress$delegate;
        final /* synthetic */ Function2<String, Continuation<? super Boolean>, Object> $startNativeLogin;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C68861(Function2<? super String, ? super Continuation<? super Boolean>, ? extends Object> function2, Function0<Unit> function0, MutableState<Boolean> mutableState, Continuation<? super C68861> continuation) {
            super(2, continuation);
            this.$startNativeLogin = function2;
            this.$onClose = function0;
            this.$showProgress$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C68861 c68861 = new C68861(this.$startNativeLogin, this.$onClose, this.$showProgress$delegate, continuation);
            c68861.L$0 = obj;
            return c68861;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return ((C68861) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2<String, Continuation<? super Boolean>, Object> function2 = this.$startNativeLogin;
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.label = 1;
                obj = function2.invoke(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            NativeSignInDialogKt.NativeSignInDialog$lambda$4(this.$showProgress$delegate, false);
            if (zBooleanValue) {
                this.$onClose.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MutableState mutableState) {
        NativeSignInDialogKt.NativeSignInDialog$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }
}
