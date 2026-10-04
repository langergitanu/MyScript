package com.myscript.nebo;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.C0028R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.content.FileProvider;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.ActivityNavigatorDestinationBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.nebo.clipboard.ContentProviderUtils;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.dms.util.ImportController;
import com.myscript.nebo.grid.ImportRequestData;
import com.myscript.nebo.grid.MainActivity;
import com.myscript.nebo.grid.PdfImporter;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.onboarding.OnboardingLanguageSelectionFragment;
import com.myscript.nebo.p034ui.compose.LenovoWelcomeKt;
import com.myscript.nebo.p034ui.compose.OnboardingSlidesKt;
import com.myscript.nebo.screennavigation.BootstrapViewModelFactory;
import com.myscript.nebo.screennavigation.LaunchViewModel;
import com.myscript.nebo.utils.NewFeatureVisibilityHelper;
import com.myscript.nebo.whatsnew.IApplicationStateProvider;
import com.myscript.nebo.whatsnew.PLSMigrationFragment;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LaunchActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002"}, m1599d2 = {"Lcom/myscript/nebo/LaunchActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "route", "", "Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchStep;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "launchViewModel", "Lcom/myscript/nebo/screennavigation/LaunchViewModel;", "getLaunchViewModel", "()Lcom/myscript/nebo/screennavigation/LaunchViewModel;", "launchViewModel$delegate", "Lkotlin/Lazy;", "appUpdateHandler", "Lcom/myscript/nebo/AppUpdateHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "LaunchRoute", "app_standardRelease", "uiState", "Lcom/myscript/nebo/screennavigation/LaunchViewModel$LaunchScreenUIState;"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LaunchActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private final AppUpdateHandler appUpdateHandler = new AppUpdateHandler();

    /* JADX INFO: renamed from: launchViewModel$delegate, reason: from kotlin metadata */
    private final Lazy launchViewModel;
    private TechnicalLogger logger;

    /* JADX INFO: compiled from: LaunchActivity.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LaunchViewModel.LaunchStep.values().length];
            try {
                iArr[LaunchViewModel.LaunchStep.SplashScreen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LaunchViewModel.LaunchStep.OnboardingSlides.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LaunchViewModel.LaunchStep.App.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LaunchViewModel.LaunchStep.PlsMigration.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LaunchViewModel.LaunchStep.LenovoWelcome.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LaunchViewModel.LaunchStep.MandatoryLoginEnterprise.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LaunchViewModel.LaunchStep.Language.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LaunchViewModel.LaunchStep.InitContent.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LaunchActivity() {
        final LaunchActivity launchActivity = this;
        final Function0 function0 = null;
        this.launchViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LaunchViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.LaunchActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return launchActivity.getViewModelStore();
            }
        }, new Function0() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LaunchActivity.launchViewModel_delegate$lambda$0();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.LaunchActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? launchActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: compiled from: LaunchActivity.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/LaunchActivity$LaunchRoute;", "", "<init>", "()V", "SplashScreen", "", "PLSMigration", "LenovoWelcome", "OnboardingSlides", "MandatoryLoginEnterprise", "Language", "InitContent", "App", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class LaunchRoute {
        public static final String App = "app";
        public static final LaunchRoute INSTANCE = new LaunchRoute();
        public static final String InitContent = "initContent";
        public static final String Language = "language";
        public static final String LenovoWelcome = "lenovoWelcome";
        public static final String MandatoryLoginEnterprise = "mandatoryLoginEnterprise";
        public static final String OnboardingSlides = "login";
        public static final String PLSMigration = "plsMigration";
        public static final String SplashScreen = "splashscreen";

        private LaunchRoute() {
        }
    }

    private final String route(LaunchViewModel.LaunchStep launchStep) {
        switch (WhenMappings.$EnumSwitchMapping$0[launchStep.ordinal()]) {
            case 1:
                return LaunchRoute.SplashScreen;
            case 2:
                return "login";
            case 3:
                return LaunchRoute.App;
            case 4:
                return LaunchRoute.PLSMigration;
            case 5:
                return LaunchRoute.LenovoWelcome;
            case 6:
                return LaunchRoute.MandatoryLoginEnterprise;
            case 7:
                return LaunchRoute.Language;
            case 8:
                return LaunchRoute.InitContent;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final LaunchViewModel getLaunchViewModel() {
        return (LaunchViewModel) this.launchViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory launchViewModel_delegate$lambda$0() {
        return new BootstrapViewModelFactory();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [T, android.net.Uri] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreenInstallSplashScreen = SplashScreen.INSTANCE.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        Function1<Activity, Boolean> redirect = AppLaunchRouter.INSTANCE.getRedirect();
        if (redirect != null && redirect.invoke(this).booleanValue()) {
            finish();
            return;
        }
        this.appUpdateHandler.registerActivity(this);
        splashScreenInstallSplashScreen.setKeepOnScreenCondition(new SplashScreen.KeepOnScreenCondition() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda7
            @Override // androidx.core.splashscreen.SplashScreen.KeepOnScreenCondition
            public final boolean shouldKeepOnScreen() {
                return LaunchActivity.onCreate$lambda$0(this.f$0);
            }
        });
        LaunchActivity launchActivity = this;
        EdgeToEdge.enable$default(launchActivity, null, null, 3, null);
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        this.logger = ((TechnicalLoggerProvider) application).provideTechnicalLogger();
        ComponentCallbacks2 application2 = getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.myscript.nebo.whatsnew.IApplicationStateProvider");
        if (((IApplicationStateProvider) application2).provideApplicationState().getStoredVersion() == null) {
            NewFeatureVisibilityHelper.markAllFeaturesDiscovered(this);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LaunchActivity launchActivity2 = this;
        ImportRequestData importRequestDataFromIntent = ImportRequestData.fromIntent(launchActivity2, getIntent());
        if (importRequestDataFromIntent != null) {
            Application application3 = getApplication();
            Intrinsics.checkNotNullExpressionValue(application3, "getApplication(...)");
            PdfImporter pdfImporter = new PdfImporter(application3, new File(getApplication().getCacheDir(), "imported"));
            Uri uri = importRequestDataFromIntent.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
            ImportController.ImportResult importResultImportPdf = pdfImporter.importPdf(uri);
            File file = importResultImportPdf.file;
            if (importResultImportPdf.status == ImportController.ImportStatus.OK && file != null) {
                objectRef.element = FileProvider.getUriForFile(launchActivity2, ContentProviderUtils.ContentProviderFileGeneric, file);
            }
        }
        ComponentActivityKt.setContent$default(launchActivity, null, ComposableLambdaKt.composableLambdaInstance(886393654, true, new Function2() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return LaunchActivity.onCreate$lambda$2(this.f$0, objectRef, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        LaunchActivity launchActivity3 = this;
        supportFragmentManager.setFragmentResultListener(OnboardingLanguageSelectionFragment.LANGUAGE_REQUEST_KEY, launchActivity3, new FragmentResultListener() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda9
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                LaunchActivity.onCreate$lambda$3(this.f$0, str, bundle);
            }
        });
        supportFragmentManager.setFragmentResultListener(PLSMigrationFragment.PLS_MIGRATION_KEY, launchActivity3, new FragmentResultListener() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda10
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                LaunchActivity.onCreate$lambda$4(this.f$0, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(LaunchActivity launchActivity) {
        return launchActivity.getLaunchViewModel().getUiState().getValue().getStep() == LaunchViewModel.LaunchStep.SplashScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(final LaunchActivity launchActivity, final Ref.ObjectRef objectRef, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C121@5640L29,122@5702L23,125@5806L300,125@5784L322,137@6212L1858,137@6120L1950:LaunchActivity.kt#3ig9qq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(886393654, i, -1, "com.myscript.nebo.LaunchActivity.onCreate.<anonymous> (LaunchActivity.kt:121)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(launchActivity.getLaunchViewModel().getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composer, 0);
            String strRoute = launchActivity.route(onCreate$lambda$2$0(stateCollectAsStateWithLifecycle).getStep());
            ComposerKt.sourceInformationMarkerStart(composer, 1420784194, "CC(remember):LaunchActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostControllerRememberNavController) | composer.changed(strRoute) | composer.changed(stateCollectAsStateWithLifecycle) | composer.changedInstance(launchActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function2) new LaunchActivity$onCreate$3$1$1(navHostControllerRememberNavController, strRoute, launchActivity, stateCollectAsStateWithLifecycle, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(strRoute, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composer, 0);
            ThemeKt.m13017NeboTheme3IgeMak(false, ColorKt.Color(ContextExtKt.resolveColorAttribute(launchActivity, C0028R.attr.colorPrimary)), ComposableLambdaKt.rememberComposableLambda(-1050051394, true, new Function2() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LaunchActivity.onCreate$lambda$2$2(navHostControllerRememberNavController, launchActivity, objectRef, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2$2(NavHostController navHostController, final LaunchActivity launchActivity, final Ref.ObjectRef objectRef, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C139@6231L1825:LaunchActivity.kt#3ig9qq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1050051394, i, -1, "com.myscript.nebo.LaunchActivity.onCreate.<anonymous>.<anonymous> (LaunchActivity.kt:139)");
            }
            NavHostKt.NavHost(navHostController, LaunchRoute.SplashScreen, null, null, null, null, null, null, null, null, new Function1() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LaunchActivity.onCreate$lambda$2$2$0(this.f$0, objectRef, (NavGraphBuilder) obj);
                }
            }, composer, 48, 0, 1020);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onCreate$lambda$2$2$0(final LaunchActivity launchActivity, Ref.ObjectRef objectRef, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.composable$default(NavHost, LaunchRoute.SplashScreen, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$LaunchActivityKt.INSTANCE.getLambda$1577729889$app_standardRelease(), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, "login", (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(867959384, true, new Function4() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return LaunchActivity.onCreate$lambda$2$2$0$0(this.f$0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, LaunchRoute.Language, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$LaunchActivityKt.INSTANCE.getLambda$1516186841$app_standardRelease(), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, LaunchRoute.InitContent, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$LaunchActivityKt.INSTANCE.m12781getLambda$2130552998$app_standardRelease(), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, LaunchRoute.PLSMigration, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$LaunchActivityKt.INSTANCE.m12779getLambda$1482325541$app_standardRelease(), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, LaunchRoute.LenovoWelcome, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-834098084, true, new Function4() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return LaunchActivity.onCreate$lambda$2$2$0$1(this.f$0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, LaunchRoute.MandatoryLoginEnterprise, (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$LaunchActivityKt.INSTANCE.m12780getLambda$185870627$app_standardRelease(), 254, (Object) null);
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder((ActivityNavigator) NavHost.getProvider().getNavigator(ActivityNavigator.class), LaunchRoute.App);
        activityNavigatorDestinationBuilder.setActivityClass(Reflection.getOrCreateKotlinClass(MainActivity.class));
        Uri data = (Uri) objectRef.element;
        if (data == null) {
            data = launchActivity.getIntent().getData();
        }
        activityNavigatorDestinationBuilder.setData(data);
        activityNavigatorDestinationBuilder.setAction(launchActivity.getIntent().getAction());
        NavHost.destination(activityNavigatorDestinationBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2$2$0$0(final LaunchActivity launchActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)148@6742L124,147@6677L215:LaunchActivity.kt#3ig9qq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(867959384, i, -1, "com.myscript.nebo.LaunchActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LaunchActivity.kt:147)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 885315636, "CC(remember):LaunchActivity.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(launchActivity);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LaunchActivity.onCreate$lambda$2$2$0$0$0$0(this.f$0, ((Integer) obj).intValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnboardingSlidesKt.OnboardingSlides((Function1) objRememberedValue, false, composer, 0, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2$2$0$0$0$0(LaunchActivity launchActivity, int i) {
        launchActivity.getLaunchViewModel().onboardingCtaClicked(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2$2$0$1(final LaunchActivity launchActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)166@7567L43,165@7496L140:LaunchActivity.kt#3ig9qq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-834098084, i, -1, "com.myscript.nebo.LaunchActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LaunchActivity.kt:165)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1590628775, "CC(remember):LaunchActivity.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(launchActivity);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.LaunchActivity$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LaunchActivity.onCreate$lambda$2$2$0$1$0$0(this.f$0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LenovoWelcomeKt.LenovoMigrationWelcomeScreen((Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2$2$0$1$0$0(LaunchActivity launchActivity) {
        launchActivity.getLaunchViewModel().lenovoWelcomeContinue();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(LaunchActivity launchActivity, String str, Bundle result) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        TechnicalLogger technicalLogger = null;
        String string = result.getString(OnboardingLanguageSelectionFragment.SELECTED_LANGUAGE_KEY, null);
        TechnicalLogger technicalLogger2 = launchActivity.logger;
        if (technicalLogger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logger");
        } else {
            technicalLogger = technicalLogger2;
        }
        technicalLogger.logTrace("[Onboarding] selected language key " + string);
        if (string != null) {
            launchActivity.getLaunchViewModel().languageSelected(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(LaunchActivity launchActivity, String str, Bundle result) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getBoolean(PLSMigrationFragment.PLS_MIGRATION_DONE_KEY, false)) {
            launchActivity.getLaunchViewModel().plsMigrationEnded();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.appUpdateHandler.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.appUpdateHandler.unregisterActivity();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LaunchViewModel.LaunchScreenUIState onCreate$lambda$2$0(State<LaunchViewModel.LaunchScreenUIState> state) {
        return state.getValue();
    }
}
