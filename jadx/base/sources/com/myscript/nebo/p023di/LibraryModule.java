package com.myscript.nebo.p023di;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.preference.PreferenceManager;
import com.myscript.atk.resourcemanager.ResourceManager;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.LibraryRepositoryConfig;
import com.myscript.nebo.dms.sharepage.SharePageController;
import com.myscript.nebo.init.UserAgentReader;
import com.myscript.nebo.log.FirebaseCorruptionListener;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.sso.model.UserData;
import com.myscript.nebo.whatsnew.ApplicationState;
import com.myscript.snt.dms.DMS;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: LibraryModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J6\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/di/LibraryModule;", "", "<init>", "()V", "provideSharePageController", "Lcom/myscript/nebo/dms/sharepage/SharePageController;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/myscript/nebo/NeboApplication;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "httpClient", "Lokhttp3/OkHttpClient;", "backendUrl", "", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "provideLibraryRepository", "Landroid/app/Application;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "applicationState", "Lcom/myscript/nebo/whatsnew/ApplicationState;", "userProfileManager", "Lcom/myscript/nebo/account/UserProfileManager;", "userDir", "Ljava/io/File;", "resourceManager", "Lcom/myscript/atk/resourcemanager/ResourceManager;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LibraryModule {
    public static final int $stable = 0;
    public static final LibraryModule INSTANCE = new LibraryModule();

    private LibraryModule() {
    }

    public final SharePageController provideSharePageController(NeboApplication application, LibraryRepository libraryRepository, final UserData userData, final OkHttpClient httpClient, final String backendUrl, final NeboNetworkStateRepository networkStateRepository) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(backendUrl, "backendUrl");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        final SharePageController.DocumentParams documentParams = new SharePageController.DocumentParams(new File(application.getCacheDir(), "sharepage").getAbsolutePath(), new File(application.getFilesDir(), "sharepage").getAbsolutePath());
        return (SharePageController) libraryRepository.withDMS(new Function1() { // from class: com.myscript.nebo.di.LibraryModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LibraryModule.provideSharePageController$lambda$0(documentParams, userData, httpClient, backendUrl, networkStateRepository, (DMS) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharePageController provideSharePageController$lambda$0(SharePageController.DocumentParams documentParams, UserData userData, OkHttpClient okHttpClient, String str, NeboNetworkStateRepository neboNetworkStateRepository, DMS dms) {
        Intrinsics.checkNotNullParameter(dms, "dms");
        return new SharePageController(dms, documentParams, userData, okHttpClient, str, neboNetworkStateRepository);
    }

    public final LibraryRepository provideLibraryRepository(Application application, TechnicalLogger logger, ApplicationState applicationState, UserProfileManager userProfileManager, File userDir, ResourceManager resourceManager) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(applicationState, "applicationState");
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        Intrinsics.checkNotNullParameter(userDir, "userDir");
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        File cacheDir = application.getCacheDir();
        cacheDir.mkdirs();
        File file = new File(application.getFilesDir(), "database");
        file.mkdirs();
        if (!userDir.isDirectory()) {
            userDir.mkdirs();
        }
        boolean zIsFirstInstall = applicationState.isFirstInstall();
        if (zIsFirstInstall) {
            applicationState.setFirstInstall(false);
        }
        Application application2 = application;
        boolean z = PreferenceManager.getDefaultSharedPreferences(application2).getBoolean(application.getString(C6079R.string.pref_autosync_enabled_key), true);
        String versionName = CommonUtils.getVersionName(application2);
        Intrinsics.checkNotNull(cacheDir);
        Intrinsics.checkNotNull(versionName);
        return new LibraryRepository(application, new LibraryRepositoryConfig(userDir, cacheDir, file, versionName, ".nebo", zIsFirstInstall, z, 0, false, RendererCapabilities.DECODER_SUPPORT_MASK, null), resourceManager, new UserAgentReader(application), FirebaseCorruptionListener.INSTANCE, logger);
    }
}
