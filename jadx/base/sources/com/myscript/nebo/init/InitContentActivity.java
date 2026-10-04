package com.myscript.nebo.init;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.databinding.InitContentActivityBinding;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.onboarding.C6669R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: InitContentActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/init/InitContentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/myscript/nebo/init/InitContentViewModel;", "getViewModel", "()Lcom/myscript/nebo/init/InitContentViewModel;", "viewModel$delegate", "binding", "Lcom/myscript/nebo/databinding/InitContentActivityBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InitContentActivity extends AppCompatActivity {
    private static final String LANGUAGE_KEY = "init_content_language_key";
    private InitContentActivityBinding binding;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.init.InitContentActivity$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return InitContentActivity.logger_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final Intent newIntent(Context context, String str) {
        return INSTANCE.newIntent(context, str);
    }

    public InitContentActivity() {
        final InitContentActivity initContentActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(InitContentViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.init.InitContentActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return initContentActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.init.InitContentActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InitContentActivity.viewModel_delegate$lambda$0(this.f$0);
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.init.InitContentActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? initContentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(InitContentActivity initContentActivity) {
        ComponentCallbacks2 application = initContentActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) application).provideTechnicalLogger();
    }

    private final InitContentViewModel getViewModel() {
        return (InitContentViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0(InitContentActivity initContentActivity) {
        String stringExtra = initContentActivity.getIntent().getStringExtra(LANGUAGE_KEY);
        initContentActivity.getLogger().setKeyValue(LANGUAGE_KEY, stringExtra);
        if (stringExtra != null) {
            return new InitContentViewModelFactory(stringExtra);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitContentActivityBinding initContentActivityBindingInflate = InitContentActivityBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(initContentActivityBindingInflate, "inflate(...)");
        this.binding = initContentActivityBindingInflate;
        if (initContentActivityBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            initContentActivityBindingInflate = null;
        }
        setContentView(initContentActivityBindingInflate.getRoot());
        getViewModel().getState().observe(this, new InitContentActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.init.InitContentActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InitContentActivity.onCreate$lambda$0(this.f$0, (InitContentState) obj);
            }
        }));
        if (savedInstanceState == null) {
            String string = getString(C6669R.string.onboarding_sample_my_collection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(C6669R.string.onboarding_sample_folder_name);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int color = ResourcesCompat.getColor(getResources(), C6183R.color.default_folder_cover_color, getTheme());
            String string3 = getString(C6669R.string.onboarding_sample_notebook2024_name);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            getViewModel().createInitialContent(string, string2, color, string3, ResourcesCompat.getColor(getResources(), C6183R.color.default_notebook_cover_color, getTheme()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(InitContentActivity initContentActivity, InitContentState initContentState) {
        InitContentActivityBinding initContentActivityBinding = initContentActivity.binding;
        if (initContentActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            initContentActivityBinding = null;
        }
        ContentLoadingProgressBar initContentProgress = initContentActivityBinding.initContentProgress;
        Intrinsics.checkNotNullExpressionValue(initContentProgress, "initContentProgress");
        initContentProgress.setVisibility(initContentState.isLoading() ? 0 : 8);
        if (initContentState.getError() != null) {
            initContentActivity.getLogger().logError(new RuntimeException(initContentState.getError().name()));
        }
        if (initContentState.isDone()) {
            initContentActivity.setResult(-1);
            initContentActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: InitContentActivity.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/init/InitContentActivity$Companion;", "", "<init>", "()V", "LANGUAGE_KEY", "", "newIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "languageKey", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Intent newIntent(Context context, String languageKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(languageKey, "languageKey");
            Intent intent = new Intent(context, (Class<?>) InitContentActivity.class);
            intent.putExtra(InitContentActivity.LANGUAGE_KEY, languageKey);
            return intent;
        }
    }
}
