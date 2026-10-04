package com.myscript.nebo.editing;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.common.ColorPolicyRepositoryProvider;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.userdict.IUserDictionaryProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "isDarkMode", "", "<init>", "(Z)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 0;
    private final boolean isDarkMode;

    public PageViewModelFactory() {
        this(false, 1, null);
    }

    public PageViewModelFactory(boolean z) {
        this.isDarkMode = z;
    }

    public /* synthetic */ PageViewModelFactory(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

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
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (modelClass.isAssignableFrom(PageViewModel.class)) {
            Application applicationRequireApplication = ViewModelProviderExtKt.requireApplication(extras);
            Intrinsics.checkNotNull(applicationRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
            TechnicalLogger technicalLoggerProvideTechnicalLogger = ((TechnicalLoggerProvider) applicationRequireApplication).provideTechnicalLogger();
            LibraryRepository libraryRepositoryProvideLibraryRepository = ((LibraryRepository.Provider) applicationRequireApplication).provideLibraryRepository();
            IAutoSyncTimerManager iAutoSyncTimerManagerProvideAutoSyncTimerManager = ((IAutoSyncTimerManager.Provider) applicationRequireApplication).provideAutoSyncTimerManager();
            ImageImporterImpl imageImporterImpl = new ImageImporterImpl(applicationRequireApplication);
            return new PageViewModel(applicationRequireApplication, libraryRepositoryProvideLibraryRepository, iAutoSyncTimerManagerProvideAutoSyncTimerManager, new AndroidNativeClipboard(applicationRequireApplication, technicalLoggerProvideTechnicalLogger, imageImporterImpl), ((IUserDictionaryProvider) applicationRequireApplication).provideUserDictionary(), ((ColorPolicyRepositoryProvider) applicationRequireApplication).provideColorPolicyRepository(), imageImporterImpl, NeboKeyboardSettings.settings(applicationRequireApplication), this.isDarkMode, null, null, null, null, 0L, 15872, null);
        }
        throw new IllegalArgumentException("Unknown ViewModel " + modelClass);
    }
}
