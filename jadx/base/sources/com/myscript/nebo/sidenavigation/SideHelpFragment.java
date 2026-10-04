package com.myscript.nebo.sidenavigation;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.BuildConfig;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.about.CreditsActivity;
import com.myscript.nebo.about.EULAActivity;
import com.myscript.nebo.account.Feature;
import com.myscript.nebo.account.FeatureAccessListener;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.nebo.analytics.firebase.NeboFirebaseEvent;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.nebo.draft.videotutorial.FreeformTypesetPageVideoTutorialDialogFragment;
import com.myscript.nebo.inspector.NeboInspectorActivity;
import com.myscript.nebo.inspector.NeboInspectorTrigger;
import com.myscript.nebo.keyboard.videotutorial.KeyboardVideoTutorialDialogFragment;
import com.myscript.nebo.page.videotutorial.PageVideoTutorialDialogFragment;
import com.myscript.nebo.pdf.videotutorial.PdfVideoTutorialDialogFragment;
import com.myscript.nebo.rating.feedback.FeedBackDialog;
import com.myscript.nebo.utils.NewFeatureVisibilityHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SideHelpFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR(\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, m1599d2 = {"Lcom/myscript/nebo/sidenavigation/SideHelpFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "mNavigator", "Lcom/myscript/android/utils/Navigator;", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "neboInspectorLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "featureAccessListener", "Lcom/myscript/nebo/account/FeatureAccessListener;", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "onDestroyView", "updateAppName", "fullVersion", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SideHelpFragment extends PreferenceFragmentCompat implements NestedFragment {
    public static final String TAG = "SideHelpFragmentTag";
    private final FeatureAccessListener featureAccessListener;
    private Navigator mNavigator;
    private final ActivityResultLauncher<Intent> neboInspectorLauncher;
    private UserProfileManager userProfileManager;
    public static final int $stable = 8;

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return 0;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    public SideHelpFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SideHelpFragment.neboInspectorLauncher$lambda$0((ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.neboInspectorLauncher = activityResultLauncherRegisterForActivityResult;
        this.featureAccessListener = new FeatureAccessListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda3
            @Override // com.myscript.nebo.account.FeatureAccessListener
            public final void featuresAccessChanged(Map map) {
                SideHelpFragment.featureAccessListener$lambda$0(this.f$0, map);
            }
        };
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_help_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    /* JADX INFO: renamed from: getNavigator, reason: from getter */
    public Navigator getMNavigator() {
        return this.mNavigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.mNavigator = navigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void neboInspectorLauncher$lambda$0(ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (NeboInspectorActivity.INSTANCE.hasRestoredContent(result.getData())) {
            AnalyticsController.logDevAnalytics("nebo-inspector-restored-content");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void featureAccessListener$lambda$0(SideHelpFragment sideHelpFragment, Map access) {
        Intrinsics.checkNotNullParameter(access, "access");
        Object obj = access.get(Feature.UnlimitedPages);
        if (obj == null) {
            obj = false;
        }
        sideHelpFragment.updateAppName(((Boolean) obj).booleanValue());
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(C6079R.xml.side_help, rootKey);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.account.UserProfileManager.Provider");
        this.userProfileManager = ((UserProfileManager.Provider) application).provideUserProfileManager();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        UserProfileManager userProfileManager = this.userProfileManager;
        UserProfileManager userProfileManager2 = null;
        if (userProfileManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager = null;
        }
        userProfileManager.addFeatureAccessListener(this.featureAccessListener);
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_help_nebo_header_key));
        UserProfileManager userProfileManager3 = this.userProfileManager;
        if (userProfileManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
        } else {
            userProfileManager2 = userProfileManager3;
        }
        updateAppName(userProfileManager2.hasFeatureAccess(Feature.UnlimitedPages));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setSummary(getString(C6079R.string.about_version, PlatformUtils.getVersion(requireContext(), BuildConfig.BUILD_NUMBER)));
        }
        if (getResources().getBoolean(C6079R.bool.enable_nebo_inspector_trigger)) {
            final Application application = requireActivity().getApplication();
            Intrinsics.checkNotNull(application);
            final NeboInspectorTrigger neboInspectorTrigger = new NeboInspectorTrigger(application, new Function0() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SideHelpFragment.onViewCreated$lambda$0(this.f$0, application);
                }
            });
            if (preferenceFindPreference != null) {
                preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda6
                    @Override // androidx.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        return SideHelpFragment.onViewCreated$lambda$1(neboInspectorTrigger, preference);
                    }
                });
            }
        }
        Preference preferenceFindPreference2 = findPreference(getString(C6079R.string.pref_help_page_tutorial_key));
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda7
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SideHelpFragment.onViewCreated$lambda$2(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference3 = findPreference(getString(C6079R.string.pref_help_keyboard_tutorial_key));
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda8
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SideHelpFragment.onViewCreated$lambda$3(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference4 = findPreference(getString(C6079R.string.pref_help_draft_tutorial_key));
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda9
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SideHelpFragment.onViewCreated$lambda$4(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference5 = findPreference(getString(C6079R.string.pref_help_pdf_tutorial_key));
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda10
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SideHelpFragment.onViewCreated$lambda$5(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference6 = findPreference(getString(C6079R.string.pref_help_share_feedback_key));
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda11
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SideHelpFragment.onViewCreated$lambda$6(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference7 = findPreference(getString(C6079R.string.pref_help_credits_key));
        if (preferenceFindPreference7 != null) {
            preferenceFindPreference7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SideHelpFragment.onViewCreated$lambda$7(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference8 = findPreference(getString(C6079R.string.pref_help_licence_key));
        if (preferenceFindPreference8 != null) {
            preferenceFindPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SideHelpFragment.onViewCreated$lambda$8(this.f$0, preference);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(SideHelpFragment sideHelpFragment, Application application) {
        try {
            ActivityResultLauncher<Intent> activityResultLauncher = sideHelpFragment.neboInspectorLauncher;
            NeboInspectorActivity.Companion companion = NeboInspectorActivity.INSTANCE;
            Intrinsics.checkNotNull(application);
            activityResultLauncher.launch(companion.newIntent(application));
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1(NeboInspectorTrigger neboInspectorTrigger, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AnalyticsController.logDevAnalytics("nebo-inspector-triggered");
        return neboInspectorTrigger.onClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2(SideHelpFragment sideHelpFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context context = sideHelpFragment.getContext();
        if (context == null) {
            return false;
        }
        NewFeatureVisibilityHelper.markFeatureDiscovered$default(context, NewFeatureVisibilityHelper.Key.REGULAR_PAGE, false, 2, null);
        PageVideoTutorialDialogFragment.INSTANCE.newInstance().show(sideHelpFragment.getChildFragmentManager(), PageVideoTutorialDialogFragment.TAG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3(SideHelpFragment sideHelpFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context context = sideHelpFragment.getContext();
        if (context == null) {
            return false;
        }
        NewFeatureVisibilityHelper.markFeatureDiscovered$default(context, NewFeatureVisibilityHelper.Key.KEYBOARD, false, 2, null);
        KeyboardVideoTutorialDialogFragment.INSTANCE.newInstance().show(sideHelpFragment.getChildFragmentManager(), KeyboardVideoTutorialDialogFragment.TAG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4(SideHelpFragment sideHelpFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context context = sideHelpFragment.getContext();
        if (context == null) {
            return false;
        }
        NewFeatureVisibilityHelper.markFeatureDiscovered$default(context, NewFeatureVisibilityHelper.Key.DRAFT_FULL_PAGE, false, 2, null);
        FreeformTypesetPageVideoTutorialDialogFragment.INSTANCE.newInstance().show(sideHelpFragment.getChildFragmentManager(), FreeformTypesetPageVideoTutorialDialogFragment.TAG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$5(SideHelpFragment sideHelpFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context context = sideHelpFragment.getContext();
        if (context == null) {
            return false;
        }
        NewFeatureVisibilityHelper.markFeatureDiscovered$default(context, NewFeatureVisibilityHelper.Key.PDF_INTERACTIVITY, false, 2, null);
        PdfVideoTutorialDialogFragment.INSTANCE.newInstance().show(sideHelpFragment.getChildFragmentManager(), PdfVideoTutorialDialogFragment.TAG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$6(SideHelpFragment sideHelpFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        NeboFirebaseEvent.ShareFeedbackModal.log(new Function1() { // from class: com.myscript.nebo.sidenavigation.SideHelpFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SideHelpFragment.onViewCreated$lambda$6$0((Bundle) obj);
            }
        });
        FeedBackDialog.INSTANCE.newInstance().show(sideHelpFragment.getChildFragmentManager(), FeedBackDialog.TAG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6$0(Bundle log) {
        Intrinsics.checkNotNullParameter(log, "$this$log");
        log.putString("origin", "help_menu");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$7(SideHelpFragment sideHelpFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context context = sideHelpFragment.getContext();
        if (context == null) {
            return false;
        }
        context.startActivity(CreditsActivity.newIntent(context));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$8(SideHelpFragment sideHelpFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Context context = sideHelpFragment.getContext();
        if (context == null) {
            return false;
        }
        context.startActivity(EULAActivity.INSTANCE.newIntent(context));
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        UserProfileManager userProfileManager = this.userProfileManager;
        if (userProfileManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userProfileManager");
            userProfileManager = null;
        }
        userProfileManager.removeFeatureAccessListener(this.featureAccessListener);
        super.onDestroyView();
    }

    private final void updateAppName(boolean fullVersion) {
        String string;
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_help_nebo_header_key));
        if (fullVersion) {
            string = "";
        } else {
            string = getString(C6079R.string.about_free_app_suffix);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setTitle(getString(C6079R.string.about_app_name, string));
        }
    }
}
