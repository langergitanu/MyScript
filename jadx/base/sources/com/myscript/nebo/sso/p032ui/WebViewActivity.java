package com.myscript.nebo.sso.p032ui;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.sso.databinding.WebViewLayoutBinding;
import java.net.UnknownHostException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.http.HttpStatus;

/* JADX INFO: compiled from: WebViewActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\tH¤@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tH$J\b\u0010\u0011\u001a\u00020\u0005H\u0014J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0014J\b\u0010\u001b\u001a\u00020\u0013H\u0004J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0005H\u0005J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0004J\b\u0010$\u001a\u00020\u0013H\u0002J\u0006\u0010%\u001a\u00020\u0013J\b\u0010&\u001a\u00020\u0013H\u0017J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0005H\u0004J\u0006\u0010)\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\fX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006*"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/WebViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "isLeaving", "", "binding", "Lcom/myscript/nebo/sso/databinding/WebViewLayoutBinding;", "getOrFetchUrl", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appRequestHeaders", "", "getAppRequestHeaders", "()Ljava/util/Map;", "interceptUrl", ImagesContract.URL, "shouldLoadPageAtStartup", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onSaveInstanceState", "outState", "onCannotConnect", "stop", "setOverlapProgressEnabled", "enabled", "updateNavigationButton", "onWebViewBack", "onWebViewForward", "onWebViewRefresh", "onWebViewClose", "reset", "loadUrl", "hideKeyboard", "onBackPressed", "setChromeVisible", "visible", "clearCache", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class WebViewActivity extends AppCompatActivity {
    private final Map<String, String> appRequestHeaders = MapsKt.emptyMap();
    private WebViewLayoutBinding binding;
    private boolean isLeaving;

    protected abstract Object getOrFetchUrl(Continuation<? super String> continuation);

    protected abstract boolean interceptUrl(String url);

    protected boolean shouldLoadPageAtStartup() {
        return true;
    }

    protected Map<String, String> getAppRequestHeaders() {
        return this.appRequestHeaders;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebViewLayoutBinding webViewLayoutBindingInflate = WebViewLayoutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(webViewLayoutBindingInflate, "inflate(...)");
        this.binding = webViewLayoutBindingInflate;
        WebViewLayoutBinding webViewLayoutBinding = null;
        if (webViewLayoutBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBindingInflate = null;
        }
        setContentView(webViewLayoutBindingInflate.getRoot());
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setChromeVisible(true);
        WebViewLayoutBinding webViewLayoutBinding2 = this.binding;
        if (webViewLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding2 = null;
        }
        WebView webView = webViewLayoutBinding2.webViewWebView;
        webView.setWebViewClient(new WebViewClient() { // from class: com.myscript.nebo.sso.ui.WebViewActivity$onCreate$1$1
            private boolean error;

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = (error.getErrorCode() == -1 || error.getErrorCode() == -10) ? false : true;
                WebViewLayoutBinding webViewLayoutBinding3 = this.this$0.binding;
                if (webViewLayoutBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    webViewLayoutBinding3 = null;
                }
                webViewLayoutBinding3.webViewProgressBar.setVisibility(4);
                view.setVisibility(4);
                this.this$0.updateNavigationButton();
                if (this.error) {
                    this.this$0.onCannotConnect();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                this.this$0.hideKeyboard();
                this.error = false;
                WebViewLayoutBinding webViewLayoutBinding3 = this.this$0.binding;
                if (webViewLayoutBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    webViewLayoutBinding3 = null;
                }
                webViewLayoutBinding3.webViewProgressBar.setVisibility(0);
                view.setVisibility(4);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                WebViewActivity webViewActivity = this.this$0;
                String string = request.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return webViewActivity.interceptUrl(string);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                if (!this.error) {
                    WebViewLayoutBinding webViewLayoutBinding3 = this.this$0.binding;
                    if (webViewLayoutBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        webViewLayoutBinding3 = null;
                    }
                    webViewLayoutBinding3.webViewProgressBar.setVisibility(4);
                    view.setVisibility(0);
                }
                View currentFocus = this.this$0.getCurrentFocus();
                if (currentFocus != null) {
                    currentFocus.clearFocus();
                }
                this.this$0.updateNavigationButton();
            }
        });
        clearCache();
        String property = System.getProperty("http.agent");
        String str = property;
        if (str == null || str.length() == 0) {
            property = "Mozilla/5.0 (Linux; Android 10) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.101 Mobile Safari/537.36";
        }
        webView.getSettings().setUserAgentString(property);
        webView.getSettings().setJavaScriptEnabled(true);
        if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
            WebSettings settings = webView.getSettings();
            Intrinsics.checkNotNull(webView);
            WebSettingsCompat.setForceDark(settings, DarkModeUtils.isDarkMode(webView) ? 2 : 0);
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                WebSettingsCompat.setForceDarkStrategy(webView.getSettings(), 1);
            }
        }
        updateNavigationButton();
        if (savedInstanceState != null) {
            WebViewLayoutBinding webViewLayoutBinding3 = this.binding;
            if (webViewLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                webViewLayoutBinding = webViewLayoutBinding3;
            }
            if (webViewLayoutBinding.webViewWebView.restoreState(savedInstanceState) == null) {
            }
        } else if (shouldLoadPageAtStartup()) {
            loadUrl();
        }
        this.isLeaving = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        webViewLayoutBinding.webViewButtonBack.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.sso.ui.WebViewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onWebViewBack();
            }
        });
        webViewLayoutBinding.webViewButtonForward.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.sso.ui.WebViewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onWebViewForward();
            }
        });
        webViewLayoutBinding.webViewButtonRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.sso.ui.WebViewActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onWebViewRefresh();
            }
        });
        webViewLayoutBinding.webViewButtonClose.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.sso.ui.WebViewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onWebViewClose();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        webViewLayoutBinding.webViewButtonBack.setOnClickListener(null);
        webViewLayoutBinding.webViewButtonForward.setOnClickListener(null);
        webViewLayoutBinding.webViewButtonRefresh.setOnClickListener(null);
        webViewLayoutBinding.webViewButtonClose.setOnClickListener(null);
        super.onStop();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        webViewLayoutBinding.webViewWebView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    protected void onCannotConnect() {
        if (this.isLeaving) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.myscript.nebo.sso.ui.WebViewActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.onCannotConnect$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCannotConnect$lambda$0(final WebViewActivity webViewActivity) {
        if (webViewActivity.isFinishing()) {
            return;
        }
        WebViewLayoutBinding webViewLayoutBinding = webViewActivity.binding;
        WebViewLayoutBinding webViewLayoutBinding2 = null;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        webViewLayoutBinding.webViewWebView.setVisibility(8);
        WebViewLayoutBinding webViewLayoutBinding3 = webViewActivity.binding;
        if (webViewLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            webViewLayoutBinding2 = webViewLayoutBinding3;
        }
        webViewLayoutBinding2.webViewProgressBar.setVisibility(8);
        new MaterialAlertDialogBuilder(webViewActivity).setTitle(C6183R.string.cannot_connect_title).setMessage(C6183R.string.cannot_connect_message_sso).setPositiveButton(C6183R.string.cannot_connect_sso_retry, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.sso.ui.WebViewActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WebViewActivity.onCannotConnect$lambda$0$0(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCannotConnect$lambda$0$0(WebViewActivity webViewActivity, DialogInterface dialogInterface, int i) {
        WebViewLayoutBinding webViewLayoutBinding = webViewActivity.binding;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        webViewLayoutBinding.webViewWebView.reload();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void stop() {
        this.isLeaving = true;
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        WebViewLayoutBinding webViewLayoutBinding2 = null;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        webViewLayoutBinding.webViewProgressBar.setVisibility(0);
        WebViewLayoutBinding webViewLayoutBinding3 = this.binding;
        if (webViewLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding3 = null;
        }
        webViewLayoutBinding3.webViewWebView.setVisibility(4);
        WebViewLayoutBinding webViewLayoutBinding4 = this.binding;
        if (webViewLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            webViewLayoutBinding2 = webViewLayoutBinding4;
        }
        webViewLayoutBinding2.webViewWebView.stopLoading();
    }

    protected final void setOverlapProgressEnabled(boolean enabled) {
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        WebViewLayoutBinding webViewLayoutBinding2 = null;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        ProgressBar webViewProgressBarOverlap = webViewLayoutBinding.webViewProgressBarOverlap;
        Intrinsics.checkNotNullExpressionValue(webViewProgressBarOverlap, "webViewProgressBarOverlap");
        webViewProgressBarOverlap.setVisibility(enabled ? 0 : 8);
        WebViewLayoutBinding webViewLayoutBinding3 = this.binding;
        if (webViewLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            webViewLayoutBinding2 = webViewLayoutBinding3;
        }
        LinearLayout webViewContent = webViewLayoutBinding2.webViewContent;
        Intrinsics.checkNotNullExpressionValue(webViewContent, "webViewContent");
        webViewContent.setVisibility(enabled ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNavigationButton() {
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        WebViewLayoutBinding webViewLayoutBinding2 = null;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        ImageView imageView = webViewLayoutBinding.webViewButtonBack;
        WebViewLayoutBinding webViewLayoutBinding3 = this.binding;
        if (webViewLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding3 = null;
        }
        imageView.setEnabled(webViewLayoutBinding3.webViewWebView.canGoBack());
        WebViewLayoutBinding webViewLayoutBinding4 = this.binding;
        if (webViewLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding4 = null;
        }
        ImageView imageView2 = webViewLayoutBinding4.webViewButtonForward;
        WebViewLayoutBinding webViewLayoutBinding5 = this.binding;
        if (webViewLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            webViewLayoutBinding2 = webViewLayoutBinding5;
        }
        imageView2.setEnabled(webViewLayoutBinding2.webViewWebView.canGoForward());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWebViewBack() {
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        WebViewLayoutBinding webViewLayoutBinding2 = null;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        if (webViewLayoutBinding.webViewWebView.canGoBack()) {
            WebViewLayoutBinding webViewLayoutBinding3 = this.binding;
            if (webViewLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                webViewLayoutBinding2 = webViewLayoutBinding3;
            }
            webViewLayoutBinding2.webViewWebView.goBack();
            return;
        }
        updateNavigationButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWebViewForward() {
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        WebViewLayoutBinding webViewLayoutBinding2 = null;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        if (webViewLayoutBinding.webViewWebView.canGoForward()) {
            WebViewLayoutBinding webViewLayoutBinding3 = this.binding;
            if (webViewLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                webViewLayoutBinding2 = webViewLayoutBinding3;
            }
            webViewLayoutBinding2.webViewWebView.goForward();
            return;
        }
        updateNavigationButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWebViewRefresh() {
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        webViewLayoutBinding.webViewWebView.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWebViewClose() {
        setResult(0);
        finish();
    }

    protected final void reset() {
        clearCache();
        loadUrl();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sso.ui.WebViewActivity$loadUrl$1 */
    /* JADX INFO: compiled from: WebViewActivity.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.sso.ui.WebViewActivity$loadUrl$1", m1609f = "WebViewActivity.kt", m1610i = {0, 0, 0}, m1611l = {HttpStatus.SC_RESET_CONTENT}, m1612m = "invokeSuspend", m1613n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-WebViewActivity$loadUrl$1$url$1"}, m1614nl = {204}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C68481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C68481(Continuation<? super C68481> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C68481 c68481 = WebViewActivity.this.new C68481(continuation);
            c68481.L$0 = obj;
            return c68481;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C68481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM14499constructorimpl;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    WebViewActivity webViewActivity = WebViewActivity.this;
                    Result.Companion companion = Result.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.I$0 = 0;
                    this.label = 1;
                    obj = webViewActivity.getOrFetchUrl(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                objM14499constructorimpl = Result.m14499constructorimpl((String) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            WebViewActivity webViewActivity2 = WebViewActivity.this;
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
            if (thM14502exceptionOrNullimpl != null && (thM14502exceptionOrNullimpl instanceof UnknownHostException)) {
                Toast.makeText(webViewActivity2, webViewActivity2.getString(C6183R.string.cannot_connect_message_sso), 1).show();
            }
            WebViewLayoutBinding webViewLayoutBinding = null;
            if (Result.m14505isFailureimpl(objM14499constructorimpl)) {
                objM14499constructorimpl = null;
            }
            String str = (String) objM14499constructorimpl;
            String str2 = str;
            if (str2 == null || StringsKt.isBlank(str2)) {
                WebViewActivity.this.finish();
                return Unit.INSTANCE;
            }
            Map<String, String> appRequestHeaders = WebViewActivity.this.getAppRequestHeaders();
            if (appRequestHeaders.isEmpty()) {
                WebViewLayoutBinding webViewLayoutBinding2 = WebViewActivity.this.binding;
                if (webViewLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    webViewLayoutBinding = webViewLayoutBinding2;
                }
                webViewLayoutBinding.webViewWebView.loadUrl(str);
            } else {
                WebViewLayoutBinding webViewLayoutBinding3 = WebViewActivity.this.binding;
                if (webViewLayoutBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    webViewLayoutBinding = webViewLayoutBinding3;
                }
                webViewLayoutBinding.webViewWebView.loadUrl(str, appRequestHeaders);
            }
            return Unit.INSTANCE;
        }
    }

    private final void loadUrl() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C68481(null), 3, null);
    }

    public final void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            WebViewLayoutBinding webViewLayoutBinding = this.binding;
            if (webViewLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                webViewLayoutBinding = null;
            }
            inputMethodManager.hideSoftInputFromWindow(webViewLayoutBinding.webViewWebView.getWindowToken(), 0);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    protected final void setChromeVisible(boolean visible) {
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        RelativeLayout activityWebViewChrome = webViewLayoutBinding.activityWebViewChrome;
        Intrinsics.checkNotNullExpressionValue(activityWebViewChrome, "activityWebViewChrome");
        activityWebViewChrome.setVisibility(visible ? 0 : 8);
    }

    public final void clearCache() {
        WebViewLayoutBinding webViewLayoutBinding = this.binding;
        if (webViewLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            webViewLayoutBinding = null;
        }
        webViewLayoutBinding.webViewWebView.clearCache(true);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }
}
