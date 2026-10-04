package com.myscript.nebo;

import android.content.ComponentCallbacks2;
import android.content.SharedPreferences;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.CredentialManager;
import androidx.preference.PreferenceManager;
import com.myscript.nebo.dms.gdrive.DriveLoginHelper;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NeboBaseActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$revokeDriveAuthorisation$2$1", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {601, TypedValues.MotionType.TYPE_POLAR_RELATIVETO}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, 612}, m1615s = {}, m1616v = 2)
final class NeboBaseActivity$revokeDriveAuthorisation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NeboBaseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboBaseActivity$revokeDriveAuthorisation$2$1(NeboBaseActivity neboBaseActivity, Continuation<? super NeboBaseActivity$revokeDriveAuthorisation$2$1> continuation) {
        super(2, continuation);
        this.this$0 = neboBaseActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboBaseActivity$revokeDriveAuthorisation$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NeboBaseActivity$revokeDriveAuthorisation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new com.myscript.nebo.NeboBaseActivity$revokeDriveAuthorisation$2$1.C60772(r6.this$0, null), r6) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            ComponentCallbacks2 application = this.this$0.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
            ((TechnicalLoggerProvider) application).provideTechnicalLogger().logError(e2);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (CredentialManager.INSTANCE.create(this.this$0).clearCredentialState(new ClearCredentialStateRequest(null, 1, null), this) == coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        DriveLoginHelper.getInstance().setTokenProvider(null);
        DriveLoginHelper.destroy();
        this.this$0.getUserData().setGDriveAuthCode("");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.this$0);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putBoolean("NEEDS_NEW_AUTH_CODE_KEY", true);
        editorEdit.apply();
        this.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.NeboBaseActivity$revokeDriveAuthorisation$2$1$2 */
    /* JADX INFO: compiled from: NeboBaseActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.NeboBaseActivity$revokeDriveAuthorisation$2$1$2", m1609f = "NeboBaseActivity.kt", m1610i = {}, m1611l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {611}, m1615s = {}, m1616v = 2)
    static final class C60772 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NeboBaseActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C60772(NeboBaseActivity neboBaseActivity, Continuation<? super C60772> continuation) {
            super(2, continuation);
            this.this$0 = neboBaseActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C60772(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C60772) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.getCloudManager().disconnect(this) == coroutine_suspended) {
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
}
