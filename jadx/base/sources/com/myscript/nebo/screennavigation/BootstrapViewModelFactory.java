package com.myscript.nebo.screennavigation;

import android.app.Application;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.work.WorkManager;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.migration.IInstallReferralRepository;
import com.myscript.nebo.onboarding.C6669R;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: LaunchViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/screennavigation/BootstrapViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BootstrapViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 0;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ <T extends ViewModel> T create(Class<T> cls) {
        return (T) super.create(cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* bridge */ <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras) {
        return (T) super.create(kClass, creationExtras);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        Object objM14499constructorimpl;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (modelClass.isAssignableFrom(LaunchViewModel.class)) {
            Application applicationRequireApplication = ViewModelProviderExtKt.requireApplication(extras);
            LaunchState launchState = new LaunchState(applicationRequireApplication);
            ISubscriptionRepository.Provider provider = applicationRequireApplication instanceof ISubscriptionRepository.Provider ? (ISubscriptionRepository.Provider) applicationRequireApplication : null;
            ISubscriptionRepository iSubscriptionRepositoryProvideSubscriptionRepository = provider != null ? provider.provideSubscriptionRepository() : null;
            LibraryRepository.Provider provider2 = applicationRequireApplication instanceof LibraryRepository.Provider ? (LibraryRepository.Provider) applicationRequireApplication : null;
            LibraryRepository libraryRepositoryProvideLibraryRepository = provider2 != null ? provider2.provideLibraryRepository() : null;
            NeboNetworkStateRepositoryProvider neboNetworkStateRepositoryProvider = applicationRequireApplication instanceof NeboNetworkStateRepositoryProvider ? (NeboNetworkStateRepositoryProvider) applicationRequireApplication : null;
            NeboNetworkStateRepository neboNetworkStateRepositoryProvideNeboNetworkStateRepository = neboNetworkStateRepositoryProvider != null ? neboNetworkStateRepositoryProvider.provideNeboNetworkStateRepository() : null;
            Application application = applicationRequireApplication;
            String versionName = CommonUtils.getVersionName(application);
            IInstallReferralRepository.Provider provider3 = applicationRequireApplication instanceof IInstallReferralRepository.Provider ? (IInstallReferralRepository.Provider) applicationRequireApplication : null;
            IInstallReferralRepository iInstallReferralRepositoryProvideInstallReferralRepository = provider3 != null ? provider3.provideInstallReferralRepository() : null;
            try {
                Result.Companion companion = Result.INSTANCE;
                BootstrapViewModelFactory bootstrapViewModelFactory = this;
                objM14499constructorimpl = Result.m14499constructorimpl(applicationRequireApplication.getPackageManager().getPackageInfo("com.myscript.nebo.lenovo", 0));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
            }
            boolean zM14506isSuccessimpl = Result.m14506isSuccessimpl(objM14499constructorimpl);
            LibraryRepository libraryRepository = libraryRepositoryProvideLibraryRepository;
            LaunchState launchState2 = launchState;
            if (iSubscriptionRepositoryProvideSubscriptionRepository == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            if (libraryRepository != null) {
                LibraryRepository libraryRepository2 = libraryRepository;
                String string = applicationRequireApplication.getString(C6669R.string.onboarding_sample_my_collection);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = applicationRequireApplication.getString(C6669R.string.onboarding_sample_folder_name);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                Application application2 = applicationRequireApplication;
                int color = ResourcesCompat.getColor(application2.getResources(), C6183R.color.default_folder_cover_color, application2.getTheme());
                String string3 = applicationRequireApplication.getString(C6669R.string.onboarding_sample_notebook2024_name);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                int color2 = ResourcesCompat.getColor(application2.getResources(), C6183R.color.default_notebook_cover_color, application2.getTheme());
                if (neboNetworkStateRepositoryProvideNeboNetworkStateRepository == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                WorkManager companion3 = WorkManager.INSTANCE.getInstance(application);
                if (iInstallReferralRepositoryProvideInstallReferralRepository != null) {
                    return new LaunchViewModel(launchState2, iSubscriptionRepositoryProvideSubscriptionRepository, libraryRepository2, string, string2, color, string3, color2, false, neboNetworkStateRepositoryProvideNeboNetworkStateRepository, versionName, companion3, iInstallReferralRepositoryProvideInstallReferralRepository, zM14506isSuccessimpl, null, null, null, 114944, null);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Unknown ViewModel " + modelClass);
    }
}
