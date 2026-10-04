package com.myscript.nebo.sso.p032ui.login;

import android.app.Activity;
import android.view.Window;
import androidx.compose.p004ui.spatial.RectListKt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CredentialOption;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GoogleSignInHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JP\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0082@¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J \u0010!\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020\u00162\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0002J\u001c\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/GoogleSignInHelper;", "", "credentialManager", "Landroidx/credentials/CredentialManager;", "<init>", "(Landroidx/credentials/CredentialManager;)V", "launchGoogleSignIn", "", "activity", "Landroid/app/Activity;", "serverClientId", "", "onSuccess", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "onError", "Lkotlin/Function0;", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCredentialState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exitImmersiveModeForCredentialManager", "tryAutoSelectAuthorizedAccount", "Landroidx/credentials/GetCredentialResponse;", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryCredentialStep", "Lcom/myscript/nebo/sso/ui/login/GoogleSignInHelper$StepResult;", "stepName", "optionFactory", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isReauthFailure", "", "e", "Landroidx/credentials/exceptions/GetCredentialCancellationException;", "extractGoogleIdToken", "result", "log", "message", "error", "", "StepResult", "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GoogleSignInHelper {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String REAUTH_ERROR_CODE = "16";

    @Deprecated
    public static final String TAG = "GoogleSignIn";
    private final CredentialManager credentialManager;

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.GoogleSignInHelper$clearCredentialState$1 */
    /* JADX INFO: compiled from: GoogleSignInHelper.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.GoogleSignInHelper", m1609f = "GoogleSignInHelper.kt", m1610i = {}, m1611l = {107}, m1612m = "clearCredentialState", m1613n = {}, m1614nl = {108}, m1615s = {}, m1616v = 2)
    static final class C68501 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C68501(Continuation<? super C68501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleSignInHelper.this.clearCredentialState(this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.GoogleSignInHelper$launchGoogleSignIn$1 */
    /* JADX INFO: compiled from: GoogleSignInHelper.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.GoogleSignInHelper", m1609f = "GoogleSignInHelper.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, m1611l = {61, 64, 75, 85}, m1612m = "launchGoogleSignIn", m1613n = {"activity", "serverClientId", "onSuccess", "onError", "restoreImmersiveMode", "activity", "serverClientId", "onSuccess", "onError", "restoreImmersiveMode", "$this$launchGoogleSignIn_u24lambda_u240", "$i$a$-run-GoogleSignInHelper$launchGoogleSignIn$response$1", "activity", "serverClientId", "onSuccess", "onError", "restoreImmersiveMode", "$this$launchGoogleSignIn_u24lambda_u241", "$i$a$-run-GoogleSignInHelper$launchGoogleSignIn$response$2", "activity", "serverClientId", "onSuccess", "onError", "restoreImmersiveMode", "response", "googleIdToken"}, m1614nl = {RectListKt.BitOffsetForGesturable, TsExtractor.TS_SYNC_BYTE, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64, 88}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, m1616v = 2)
    static final class C68511 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C68511(Continuation<? super C68511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleSignInHelper.this.launchGoogleSignIn(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.GoogleSignInHelper$tryAutoSelectAuthorizedAccount$1 */
    /* JADX INFO: compiled from: GoogleSignInHelper.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.GoogleSignInHelper", m1609f = "GoogleSignInHelper.kt", m1610i = {0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_6_1}, m1612m = "tryAutoSelectAuthorizedAccount", m1613n = {"activity", "serverClientId", "option", "request"}, m1614nl = {162}, m1615s = {"L$0", "L$1", "L$2", "L$3"}, m1616v = 2)
    static final class C68521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C68521(Continuation<? super C68521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleSignInHelper.this.tryAutoSelectAuthorizedAccount(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.login.GoogleSignInHelper$tryCredentialStep$1 */
    /* JADX INFO: compiled from: GoogleSignInHelper.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.login.GoogleSignInHelper", m1609f = "GoogleSignInHelper.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_8_1}, m1612m = "tryCredentialStep", m1613n = {"activity", "serverClientId", "stepName", "optionFactory", "option", "request"}, m1614nl = {PDFACompliance.e_PDFA1_8_2}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, m1616v = 2)
    static final class C68531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C68531(Continuation<? super C68531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleSignInHelper.this.tryCredentialStep(null, null, null, null, this);
        }
    }

    private final void log(String message, Throwable error) {
    }

    public GoogleSignInHelper(CredentialManager credentialManager) {
        Intrinsics.checkNotNullParameter(credentialManager, "credentialManager");
        this.credentialManager = credentialManager;
    }

    /* JADX INFO: compiled from: GoogleSignInHelper.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/GoogleSignInHelper$StepResult;", "", "response", "Landroidx/credentials/GetCredentialResponse;", "wasReauthFailure", "", "<init>", "(Landroidx/credentials/GetCredentialResponse;Z)V", "getResponse", "()Landroidx/credentials/GetCredentialResponse;", "getWasReauthFailure", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final /* data */ class StepResult {
        private final GetCredentialResponse response;
        private final boolean wasReauthFailure;

        /* JADX WARN: Multi-variable type inference failed */
        public StepResult() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ StepResult copy$default(StepResult stepResult, GetCredentialResponse getCredentialResponse, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                getCredentialResponse = stepResult.response;
            }
            if ((i & 2) != 0) {
                z = stepResult.wasReauthFailure;
            }
            return stepResult.copy(getCredentialResponse, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GetCredentialResponse getResponse() {
            return this.response;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getWasReauthFailure() {
            return this.wasReauthFailure;
        }

        public final StepResult copy(GetCredentialResponse response, boolean wasReauthFailure) {
            return new StepResult(response, wasReauthFailure);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StepResult)) {
                return false;
            }
            StepResult stepResult = (StepResult) other;
            return Intrinsics.areEqual(this.response, stepResult.response) && this.wasReauthFailure == stepResult.wasReauthFailure;
        }

        public int hashCode() {
            GetCredentialResponse getCredentialResponse = this.response;
            return ((getCredentialResponse == null ? 0 : getCredentialResponse.hashCode()) * 31) + Boolean.hashCode(this.wasReauthFailure);
        }

        public String toString() {
            return "StepResult(response=" + this.response + ", wasReauthFailure=" + this.wasReauthFailure + ")";
        }

        public StepResult(GetCredentialResponse getCredentialResponse, boolean z) {
            this.response = getCredentialResponse;
            this.wasReauthFailure = z;
        }

        public /* synthetic */ StepResult(GetCredentialResponse getCredentialResponse, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : getCredentialResponse, (i & 2) != 0 ? false : z);
        }

        public final GetCredentialResponse getResponse() {
            return this.response;
        }

        public final boolean getWasReauthFailure() {
            return this.wasReauthFailure;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0117 A[Catch: all -> 0x0202, Exception -> 0x0206, CancellationException -> 0x020a, TRY_LEAVE, TryCatch #11 {CancellationException -> 0x020a, Exception -> 0x0206, all -> 0x0202, blocks: (B:41:0x0113, B:43:0x0117), top: B:114:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0151 A[Catch: all -> 0x01a2, Exception -> 0x01a4, CancellationException -> 0x01a6, TRY_LEAVE, TryCatch #10 {CancellationException -> 0x01a6, Exception -> 0x01a4, all -> 0x01a2, blocks: (B:70:0x01ad, B:72:0x01c0, B:74:0x01c6, B:79:0x01f5, B:49:0x0149, B:51:0x0151, B:45:0x013f), top: B:116:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c0 A[Catch: all -> 0x01a2, Exception -> 0x01a4, CancellationException -> 0x01a6, TryCatch #10 {CancellationException -> 0x01a6, Exception -> 0x01a4, all -> 0x01a2, blocks: (B:70:0x01ad, B:72:0x01c0, B:74:0x01c6, B:79:0x01f5, B:49:0x0149, B:51:0x0151, B:45:0x013f), top: B:116:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f5 A[Catch: all -> 0x01a2, Exception -> 0x01a4, CancellationException -> 0x01a6, TRY_LEAVE, TryCatch #10 {CancellationException -> 0x01a6, Exception -> 0x01a4, all -> 0x01a2, blocks: (B:70:0x01ad, B:72:0x01c0, B:74:0x01c6, B:79:0x01f5, B:49:0x0149, B:51:0x0151, B:45:0x013f), top: B:116:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object, kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.myscript.nebo.sso.ui.login.GoogleSignInHelper, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r2v13, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object launchGoogleSignIn(Activity activity, String str, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function2, Function0<Unit> function0, Continuation<? super Unit> continuation) throws Throwable {
        C68511 c68511;
        ?? r10;
        Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function22;
        Function0<Unit> function02;
        Activity activity2;
        Object obj;
        final ?? r3;
        Function0<Unit> function03;
        ?? r102;
        Activity activity3;
        ?? r13;
        ?? r2;
        ?? r132;
        ?? r103;
        GetCredentialResponse response;
        ?? r32;
        ?? r5;
        final ?? r52;
        GetCredentialResponse response2;
        Function0<Unit> function04;
        Function0<Unit> function05;
        ?? r22 = str;
        if (continuation instanceof C68511) {
            c68511 = (C68511) continuation;
            if ((c68511.label & Integer.MIN_VALUE) != 0) {
                c68511.label -= Integer.MIN_VALUE;
            } else {
                c68511 = new C68511(continuation);
            }
        }
        C68511 c685112 = c68511;
        Object obj2 = c685112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = c685112.label;
        try {
            try {
                if (r4 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    log$default(this, "started", null, 2, null);
                    Function0<Unit> function0ExitImmersiveModeForCredentialManager = exitImmersiveModeForCredentialManager(activity);
                    try {
                        try {
                            log$default(this, "step 1: trying auto-select", null, 2, null);
                            c685112.L$0 = activity;
                            c685112.L$1 = r22;
                            c685112.L$2 = function2;
                            function05 = function0;
                            try {
                                c685112.L$3 = function05;
                                c685112.L$4 = function0ExitImmersiveModeForCredentialManager;
                                c685112.label = 1;
                                Object objTryAutoSelectAuthorizedAccount = tryAutoSelectAuthorizedAccount(activity, r22, c685112);
                                if (objTryAutoSelectAuthorizedAccount != coroutine_suspended) {
                                    activity2 = activity;
                                    function22 = function2;
                                    function02 = function0ExitImmersiveModeForCredentialManager;
                                    r3 = r22;
                                    r10 = function05;
                                    obj = objTryAutoSelectAuthorizedAccount;
                                    response = (GetCredentialResponse) obj;
                                    if (response != null) {
                                    }
                                    throw e;
                                }
                                return coroutine_suspended;
                            } catch (Exception e) {
                                e = e;
                                r22 = function0ExitImmersiveModeForCredentialManager;
                                r10 = function05;
                                log("unexpected exception: " + e.getMessage(), e);
                                r10.invoke();
                                r22.invoke();
                                return Unit.INSTANCE;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            function05 = function0;
                        }
                    } catch (CancellationException e3) {
                        throw e3;
                    } catch (Throwable th) {
                        th = th;
                        r22 = function0ExitImmersiveModeForCredentialManager;
                        r22.invoke();
                        throw th;
                    }
                } else {
                    try {
                        if (r4 == 1) {
                            Function0<Unit> function06 = (Function0) c685112.L$4;
                            Function0 function07 = (Function0) c685112.L$3;
                            function22 = (Function2) c685112.L$2;
                            String str2 = (String) c685112.L$1;
                            Activity activity4 = (Activity) c685112.L$0;
                            ResultKt.throwOnFailure(obj2);
                            function02 = function06;
                            activity2 = activity4;
                            r10 = function07;
                            obj = obj2;
                            r3 = str2;
                            try {
                                response = (GetCredentialResponse) obj;
                                if (response != null) {
                                    log$default(this, "step 2: trying account picker", null, 2, null);
                                    Function0 function08 = new Function0() { // from class: com.myscript.nebo.sso.ui.login.GoogleSignInHelper$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return GoogleSignInHelper.launchGoogleSignIn$lambda$0$0(r3);
                                        }
                                    };
                                    c685112.L$0 = activity2;
                                    c685112.L$1 = r3;
                                    c685112.L$2 = function22;
                                    c685112.L$3 = r10;
                                    c685112.L$4 = function02;
                                    c685112.L$5 = SpillingKt.nullOutSpilledVariable(this);
                                    c685112.I$0 = 0;
                                    c685112.label = 2;
                                    function04 = function02;
                                    try {
                                        Object objTryCredentialStep = tryCredentialStep(activity2, r3, "account picker", function08, c685112);
                                        if (objTryCredentialStep == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        r52 = r3;
                                        obj2 = objTryCredentialStep;
                                        r102 = r10;
                                        function03 = function04;
                                        response2 = ((StepResult) obj2).getResponse();
                                        if (response2 != null) {
                                        }
                                    } catch (CancellationException e4) {
                                        e = e4;
                                    } catch (Exception e5) {
                                        e = e5;
                                        r22 = function04;
                                        log("unexpected exception: " + e.getMessage(), e);
                                        r10.invoke();
                                        r22.invoke();
                                        return Unit.INSTANCE;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r22 = function04;
                                        r22.invoke();
                                        throw th;
                                    }
                                } else {
                                    r132 = function02;
                                    r32 = r3;
                                    r103 = r10;
                                    log$default(this, "credential response=" + (response != null), null, 2, null);
                                    if (response == null) {
                                    }
                                    r13.invoke();
                                }
                            } catch (CancellationException e6) {
                                e = e6;
                                function04 = function02;
                            } catch (Exception e7) {
                                e = e7;
                                function04 = function02;
                            } catch (Throwable th3) {
                                th = th3;
                                function04 = function02;
                            }
                            throw e;
                        }
                        if (r4 == 2) {
                            int i = c685112.I$0;
                            Function0<Unit> function09 = (Function0) c685112.L$4;
                            Function0 function010 = (Function0) c685112.L$3;
                            function22 = (Function2) c685112.L$2;
                            String str3 = (String) c685112.L$1;
                            Activity activity5 = (Activity) c685112.L$0;
                            ResultKt.throwOnFailure(obj2);
                            function03 = function09;
                            activity2 = activity5;
                            r102 = function010;
                            r52 = str3;
                            response2 = ((StepResult) obj2).getResponse();
                            if (response2 != null) {
                                log$default(this, "step 3: trying Sign-in-with-Google button", null, 2, null);
                                Function0 function011 = new Function0() { // from class: com.myscript.nebo.sso.ui.login.GoogleSignInHelper$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return GoogleSignInHelper.launchGoogleSignIn$lambda$1$0(r52);
                                    }
                                };
                                c685112.L$0 = SpillingKt.nullOutSpilledVariable(activity2);
                                c685112.L$1 = SpillingKt.nullOutSpilledVariable(r52);
                                c685112.L$2 = function22;
                                c685112.L$3 = r102;
                                c685112.L$4 = function03;
                                c685112.L$5 = SpillingKt.nullOutSpilledVariable(this);
                                c685112.I$0 = 0;
                                c685112.label = 3;
                                ?? r17 = r52;
                                Object objTryCredentialStep2 = tryCredentialStep(activity2, r17, "Sign-in-with-Google", function011, c685112);
                                r5 = r17;
                                if (objTryCredentialStep2 != coroutine_suspended) {
                                    activity3 = activity2;
                                    obj2 = objTryCredentialStep2;
                                    r22 = function03;
                                    r10 = r102;
                                    ?? r133 = r5;
                                    response = ((StepResult) obj2).getResponse();
                                    r32 = r133;
                                    r132 = r22;
                                    activity2 = activity3;
                                    r103 = r10;
                                    log$default(this, "credential response=" + (response != null), null, 2, null);
                                    if (response == null) {
                                    }
                                    r13.invoke();
                                }
                                return coroutine_suspended;
                            }
                            ?? r172 = r52;
                            response = response2;
                            r32 = r172;
                            r103 = r102;
                            r132 = function03;
                            log$default(this, "credential response=" + (response != null), null, 2, null);
                            if (response == null) {
                            }
                            r13.invoke();
                        } else if (r4 == 3) {
                            int i2 = c685112.I$0;
                            Function0 function012 = (Function0) c685112.L$4;
                            Function0 function013 = (Function0) c685112.L$3;
                            function22 = (Function2) c685112.L$2;
                            String str4 = (String) c685112.L$1;
                            activity3 = (Activity) c685112.L$0;
                            ResultKt.throwOnFailure(obj2);
                            r10 = function013;
                            r22 = function012;
                            r5 = str4;
                            try {
                                ?? r1332 = r5;
                                response = ((StepResult) obj2).getResponse();
                                r32 = r1332;
                                r132 = r22;
                                activity2 = activity3;
                                r103 = r10;
                                log$default(this, "credential response=" + (response != null), null, 2, null);
                                if (response == null) {
                                    String strExtractGoogleIdToken = extractGoogleIdToken(response, r103);
                                    r13 = r132;
                                    if (strExtractGoogleIdToken != null) {
                                        c685112.L$0 = SpillingKt.nullOutSpilledVariable(activity2);
                                        c685112.L$1 = SpillingKt.nullOutSpilledVariable(r32);
                                        c685112.L$2 = SpillingKt.nullOutSpilledVariable(function22);
                                        c685112.L$3 = r103;
                                        c685112.L$4 = r132;
                                        c685112.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                        c685112.L$6 = SpillingKt.nullOutSpilledVariable(strExtractGoogleIdToken);
                                        c685112.label = 4;
                                        if (function22.invoke(strExtractGoogleIdToken, c685112) != coroutine_suspended) {
                                            r2 = r132;
                                            r13 = r2;
                                        }
                                        return coroutine_suspended;
                                    }
                                } else {
                                    log$default(this, "all strategies exhausted", null, 2, null);
                                    r103.invoke();
                                    r13 = r132;
                                }
                                r13.invoke();
                            } catch (Exception e8) {
                                e = e8;
                                log("unexpected exception: " + e.getMessage(), e);
                                r10.invoke();
                                r22.invoke();
                            }
                        } else {
                            if (r4 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Function0 function014 = (Function0) c685112.L$4;
                            ResultKt.throwOnFailure(obj2);
                            r2 = function014;
                            r13 = r2;
                            r13.invoke();
                        }
                    } catch (Exception e9) {
                        e = e9;
                        r10 = r4;
                        log("unexpected exception: " + e.getMessage(), e);
                        r10.invoke();
                        r22.invoke();
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            } catch (CancellationException e10) {
                throw e10;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object launchGoogleSignIn$lambda$0$0(String str) {
        return new GetGoogleIdOption.Builder().setServerClientId(str).setAutoSelectEnabled(false).setFilterByAuthorizedAccounts(false).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object launchGoogleSignIn$lambda$1$0(String str) {
        return new GetSignInWithGoogleOption.Builder(str).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearCredentialState(Continuation<? super Unit> continuation) {
        C68501 c68501;
        if (continuation instanceof C68501) {
            c68501 = (C68501) continuation;
            if ((c68501.label & Integer.MIN_VALUE) != 0) {
                c68501.label -= Integer.MIN_VALUE;
            } else {
                c68501 = new C68501(continuation);
            }
        }
        Object obj = c68501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68501.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CredentialManager credentialManager = this.credentialManager;
                ClearCredentialStateRequest clearCredentialStateRequest = new ClearCredentialStateRequest(null, 1, null);
                c68501.label = 1;
                if (credentialManager.clearCredentialState(clearCredentialStateRequest, c68501) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }

    private final Function0<Unit> exitImmersiveModeForCredentialManager(Activity activity) {
        final Window window = activity.getWindow();
        final WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
        Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
        if (insetsController.getSystemBarsBehavior() != 2) {
            return new Function0() { // from class: com.myscript.nebo.sso.ui.login.GoogleSignInHelper$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        final int statusBarColor = window.getStatusBarColor();
        final boolean zIsAppearanceLightStatusBars = insetsController.isAppearanceLightStatusBars();
        window.setStatusBarColor(-16777216);
        insetsController.setAppearanceLightStatusBars(false);
        insetsController.setSystemBarsBehavior(1);
        insetsController.show(WindowInsetsCompat.Type.systemBars());
        return new Function0() { // from class: com.myscript.nebo.sso.ui.login.GoogleSignInHelper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GoogleSignInHelper.exitImmersiveModeForCredentialManager$lambda$1(insetsController, window, statusBarColor, zIsAppearanceLightStatusBars);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitImmersiveModeForCredentialManager$lambda$1(WindowInsetsControllerCompat windowInsetsControllerCompat, Window window, int i, boolean z) {
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        window.setStatusBarColor(i);
        windowInsetsControllerCompat.setAppearanceLightStatusBars(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryAutoSelectAuthorizedAccount(Activity activity, String str, Continuation<? super GetCredentialResponse> continuation) {
        C68521 c68521;
        if (continuation instanceof C68521) {
            c68521 = (C68521) continuation;
            if ((c68521.label & Integer.MIN_VALUE) != 0) {
                c68521.label -= Integer.MIN_VALUE;
            } else {
                c68521 = new C68521(continuation);
            }
        }
        Object credential = c68521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68521.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(credential);
                GetGoogleIdOption getGoogleIdOptionBuild = new GetGoogleIdOption.Builder().setServerClientId(str).setAutoSelectEnabled(true).setFilterByAuthorizedAccounts(true).build();
                GetCredentialRequest getCredentialRequestBuild = new GetCredentialRequest.Builder().addCredentialOption(getGoogleIdOptionBuild).build();
                c68521.L$0 = SpillingKt.nullOutSpilledVariable(activity);
                c68521.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c68521.L$2 = SpillingKt.nullOutSpilledVariable(getGoogleIdOptionBuild);
                c68521.L$3 = SpillingKt.nullOutSpilledVariable(getCredentialRequestBuild);
                c68521.label = 1;
                credential = this.credentialManager.getCredential(activity, getCredentialRequestBuild, c68521);
                if (credential == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(credential);
            }
            return (GetCredentialResponse) credential;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryCredentialStep(Activity activity, String str, String str2, Function0<? extends Object> function0, Continuation<? super StepResult> continuation) {
        C68531 c68531;
        if (continuation instanceof C68531) {
            c68531 = (C68531) continuation;
            if ((c68531.label & Integer.MIN_VALUE) != 0) {
                c68531.label -= Integer.MIN_VALUE;
            } else {
                c68531 = new C68531(continuation);
            }
        }
        Object credential = c68531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c68531.label;
        boolean z = false;
        int i2 = 1;
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(credential);
                Object objInvoke = function0.invoke();
                GetCredentialRequest.Builder builder = new GetCredentialRequest.Builder();
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type androidx.credentials.CredentialOption");
                GetCredentialRequest getCredentialRequestBuild = builder.addCredentialOption((CredentialOption) objInvoke).build();
                c68531.L$0 = SpillingKt.nullOutSpilledVariable(activity);
                c68531.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c68531.L$2 = str2;
                c68531.L$3 = SpillingKt.nullOutSpilledVariable(function0);
                c68531.L$4 = SpillingKt.nullOutSpilledVariable(objInvoke);
                c68531.L$5 = SpillingKt.nullOutSpilledVariable(getCredentialRequestBuild);
                c68531.label = 1;
                credential = this.credentialManager.getCredential(activity, getCredentialRequestBuild, c68531);
                if (credential == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = c68531.L$4;
                str2 = (String) c68531.L$2;
                ResultKt.throwOnFailure(credential);
            }
            log$default(this, str2 + ": got credential response", null, 2, null);
            return new StepResult((GetCredentialResponse) credential, z, i3, defaultConstructorMarker);
        } catch (GetCredentialCancellationException e) {
            boolean zIsReauthFailure = isReauthFailure(e);
            if (zIsReauthFailure) {
                log$default(this, str2 + ": account reauth failed: " + e.getMessage(), null, 2, null);
            } else {
                log$default(this, str2 + ": user cancelled: " + e.getMessage(), null, 2, null);
            }
            return new StepResult(objArr4 == true ? 1 : 0, zIsReauthFailure, i2, objArr3 == true ? 1 : 0);
        } catch (GetCredentialException e2) {
            log(str2 + ": FAILED type=" + e2.getType() + " message=" + e2.getMessage(), e2);
            return new StepResult(objArr2 == true ? 1 : 0, z, 3, objArr == true ? 1 : 0);
        }
    }

    public final boolean isReauthFailure(GetCredentialCancellationException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        String message = e.getMessage();
        if (message == null) {
            return false;
        }
        String str = message;
        return StringsKt.contains$default((CharSequence) str, (CharSequence) REAUTH_ERROR_CODE, false, 2, (Object) null) && StringsKt.contains((CharSequence) str, (CharSequence) "reauth", true);
    }

    private final String extractGoogleIdToken(GetCredentialResponse result, Function0<Unit> onError) {
        Credential credential = result.getCredential();
        if (!(credential instanceof CustomCredential) || !Intrinsics.areEqual(credential.getType(), GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
            log$default(this, "Unexpected credential type: " + credential.getType(), null, 2, null);
            onError.invoke();
            return null;
        }
        try {
            return GoogleIdTokenCredential.INSTANCE.createFrom(credential.getData()).getZzb();
        } catch (GoogleIdTokenParsingException e) {
            log("FAILED: " + e.getMessage(), e);
            onError.invoke();
            return null;
        }
    }

    static /* synthetic */ void log$default(GoogleSignInHelper googleSignInHelper, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        googleSignInHelper.log(str, th);
    }

    /* JADX INFO: compiled from: GoogleSignInHelper.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/login/GoogleSignInHelper$Companion;", "", "<init>", "()V", "TAG", "", "REAUTH_ERROR_CODE", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
