package com.survicate.surveys;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.survicate.surveys.entities.colors.MicroColorControlOpacity;
import com.survicate.surveys.entities.models.SurveyPointDisplayRequest;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.theme.ColorScheme;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.entities.survey.theme.ThemeType;
import com.survicate.surveys.helpers.BehaviourObservable;
import com.survicate.surveys.helpers.Observable;
import com.survicate.surveys.presentation.base.ActivityListener;
import com.survicate.surveys.presentation.base.DisplayEngine;
import com.survicate.surveys.presentation.base.SurveyPointFragment;
import com.survicate.surveys.presentation.base.SurveyViewModel;
import com.survicate.surveys.presentation.design.DisplayDesignFactory;
import com.survicate.surveys.presentation.theming.ColorHelper;
import com.survicate.surveys.utils.AccessibilityUtils;
import com.survicate.surveys.utils.AndroidLayoutDirectionProvider;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyActivity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0014J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0013H\u0002J\n\u0010)\u001a\u0004\u0018\u00010*H\u0017J\b\u0010+\u001a\u00020\u0015H\u0014J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0015H\u0016J\b\u00100\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020\u0015H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020'H\u0002R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m1599d2 = {"Lcom/survicate/surveys/SurveyActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/survicate/surveys/presentation/base/ActivityListener;", "<init>", "()V", "value", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "displayEngine", "getDisplayEngine", "()Lcom/survicate/surveys/presentation/base/DisplayEngine;", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "surveyViewModel", "getSurveyViewModel", "()Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "surveyPointObserver", "Lcom/survicate/surveys/helpers/Observable$Observer;", "Lcom/survicate/surveys/entities/models/SurveyPointDisplayRequest;", "kotlin.jvm.PlatformType", "activityUUID", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initializeViewModel", "setupWindow", "registerOnBackPressedCallback", "setSurveyBackground", "onResume", "onPause", "attachToActivity", "pointDisplayRequest", "createSurveyPointFragment", "Landroidx/fragment/app/Fragment;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "replaceFragment", "pointFragment", "isNavigatingBack", "", "tag", "onRetainCustomNonConfigurationInstance", "", "onDestroy", "setLayoutDirection", "layoutDirection", "", "finishActivity", "overrideStartAnimation", "overrideFinishAnimation", "clearSurveyBackground", "isCurrentSurveyMicroThemed", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyActivity extends AppCompatActivity implements ActivityListener {
    private final String activityUUID;
    private DisplayEngine displayEngine;
    private final Observable.Observer<SurveyPointDisplayRequest> surveyPointObserver = new Observable.Observer() { // from class: com.survicate.surveys.SurveyActivity$$ExternalSyntheticLambda0
        @Override // com.survicate.surveys.helpers.Observable.Observer
        public final void update(Object obj) {
            this.f$0.attachToActivity((SurveyPointDisplayRequest) obj);
        }
    };
    private SurveyViewModel surveyViewModel;

    public SurveyActivity() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.activityUUID = string;
    }

    public final DisplayEngine getDisplayEngine() {
        return this.displayEngine;
    }

    public final SurveyViewModel getSurveyViewModel() {
        return this.surveyViewModel;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Survicate survicate = Survicate.instance;
        if (survicate == null) {
            finish();
            return;
        }
        DisplayEngine displayEngine = survicate.displayEngine;
        this.displayEngine = displayEngine;
        if (displayEngine.getCurrentSurvey() == null) {
            finish();
            return;
        }
        displayEngine.setActivityListener(this, this.activityUUID);
        Intrinsics.checkNotNull(displayEngine);
        this.surveyViewModel = initializeViewModel(displayEngine);
        setupWindow();
        overrideStartAnimation();
        setContentView(C8369R.layout.activity_survey);
        registerOnBackPressedCallback();
        setSurveyBackground();
    }

    private final SurveyViewModel initializeViewModel(DisplayEngine displayEngine) {
        Object lastCustomNonConfigurationInstance = getLastCustomNonConfigurationInstance();
        if (lastCustomNonConfigurationInstance != null) {
            return (SurveyViewModel) lastCustomNonConfigurationInstance;
        }
        return new SurveyViewModel(displayEngine, new AndroidLayoutDirectionProvider());
    }

    private final void setupWindow() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
    }

    private final void registerOnBackPressedCallback() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.survicate.surveys.SurveyActivity.registerOnBackPressedCallback.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                DisplayEngine displayEngine = SurveyActivity.this.getDisplayEngine();
                if (displayEngine != null) {
                    displayEngine.surveyClosed();
                }
            }
        });
    }

    private final void setSurveyBackground() {
        Theme surveyTheme;
        DisplayEngine displayEngine = this.displayEngine;
        if (displayEngine == null || (surveyTheme = displayEngine.getSurveyTheme(this)) == null) {
            return;
        }
        ColorScheme colorScheme = surveyTheme.getColorScheme();
        if (!(colorScheme instanceof ColorScheme)) {
            colorScheme = null;
        }
        if (colorScheme == null) {
            return;
        }
        findViewById(C8369R.id.survey_point_container).setBackgroundColor(ColorHelper.getArgbValue(colorScheme.getAnswer(), MicroColorControlOpacity.SurveyBackgroundDim.getOpacityValue()));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        BehaviourObservable<SurveyPointDisplayRequest> surveyPointObservable;
        super.onResume();
        DisplayEngine displayEngine = this.displayEngine;
        if (displayEngine == null || (surveyPointObservable = displayEngine.getSurveyPointObservable()) == null) {
            return;
        }
        surveyPointObservable.addObserver(this.surveyPointObserver);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        BehaviourObservable<SurveyPointDisplayRequest> surveyPointObservable;
        super.onPause();
        DisplayEngine displayEngine = this.displayEngine;
        if (displayEngine == null || (surveyPointObservable = displayEngine.getSurveyPointObservable()) == null) {
            return;
        }
        surveyPointObservable.removeObserver(this.surveyPointObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attachToActivity(SurveyPointDisplayRequest pointDisplayRequest) {
        SurveyPoint surveyPoint = pointDisplayRequest.getSurveyPoint();
        String str = surveyPoint.getId() + "";
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = createSurveyPointFragment(surveyPoint);
        }
        if (Intrinsics.areEqual(fragmentFindFragmentByTag, getSupportFragmentManager().findFragmentById(C8369R.id.survey_point_container))) {
            return;
        }
        replaceFragment(fragmentFindFragmentByTag, pointDisplayRequest.isNavigatingBack(), str);
    }

    private final Fragment createSurveyPointFragment(SurveyPoint surveyPoint) {
        SurveyAnswerType surveyAnswerTypeFromString = SurveyAnswerType.INSTANCE.fromString(surveyPoint.getAnswerType());
        if (surveyAnswerTypeFromString == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        DisplayEngine displayEngine = this.displayEngine;
        DisplayDesignFactory displayDesignFactoryProvideDesignFactory = displayEngine != null ? displayEngine.provideDesignFactory() : null;
        if (displayDesignFactoryProvideDesignFactory == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        DisplayEngine displayEngine2 = this.displayEngine;
        Theme surveyTheme = displayEngine2 != null ? displayEngine2.getSurveyTheme(this) : null;
        if (surveyTheme == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Fragment fragmentCreateSurveyPointFragment = displayDesignFactoryProvideDesignFactory.createSurveyPointFragment(surveyAnswerTypeFromString, surveyTheme.getType());
        Bundle bundle = new Bundle();
        bundle.putParcelable(SurveyPointFragment.SURVEY_POINT_ARG, surveyPoint);
        fragmentCreateSurveyPointFragment.setArguments(bundle);
        return fragmentCreateSurveyPointFragment;
    }

    private final void replaceFragment(Fragment pointFragment, boolean isNavigatingBack, String tag) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        if (!AccessibilityUtils.isTalkbackEnabled(this)) {
            int i = isNavigatingBack ? C8369R.anim.survicate_slide_in_from_left : C8369R.anim.survicate_slide_in_from_right;
            int i2 = isNavigatingBack ? C8369R.anim.survicate_slide_out_to_right : C8369R.anim.survicate_slide_out_to_left;
            fragmentTransactionBeginTransaction.setCustomAnimations(i, i2, i, i2);
        }
        fragmentTransactionBeginTransaction.replace(C8369R.id.survey_point_container, pointFragment, tag);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.activity.ComponentActivity
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "surveyViewModel", imports = {}))
    public Object onRetainCustomNonConfigurationInstance() {
        return this.surveyViewModel;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        SurveyViewModel surveyViewModel;
        super.onDestroy();
        DisplayEngine displayEngine = this.displayEngine;
        if (displayEngine != null) {
            displayEngine.clearActivityListener(this.activityUUID);
        }
        if (isChangingConfigurations() || (surveyViewModel = this.surveyViewModel) == null) {
            return;
        }
        surveyViewModel.onCleared();
    }

    @Override // com.survicate.surveys.presentation.base.ActivityListener
    public void setLayoutDirection(int layoutDirection) {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setLayoutDirection(layoutDirection);
    }

    @Override // com.survicate.surveys.presentation.base.ActivityListener
    public void finishActivity() {
        clearSurveyBackground();
        finish();
        if (isCurrentSurveyMicroThemed()) {
            overrideFinishAnimation();
        }
    }

    private final void overrideStartAnimation() {
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(0, android.R.anim.fade_in, 0);
        } else {
            overridePendingTransition(android.R.anim.fade_in, 0);
        }
    }

    private final void overrideFinishAnimation() {
        int i = C8369R.anim.survicate_slide_out_bottom;
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(1, 0, i);
        } else {
            overridePendingTransition(0, i);
        }
    }

    private final void clearSurveyBackground() {
        View viewFindViewById = findViewById(C8369R.id.survey_point_container);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(0);
        }
    }

    private final boolean isCurrentSurveyMicroThemed() {
        Theme surveyTheme;
        DisplayEngine displayEngine = this.displayEngine;
        return ((displayEngine == null || (surveyTheme = displayEngine.getSurveyTheme(this)) == null) ? null : surveyTheme.getType()) == ThemeType.MICRO;
    }
}
