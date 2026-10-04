package com.revenuecat.purchases.paywalls;

import android.content.Context;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfo;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfoKt;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.Result;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import com.revenuecat.purchases.utils.UrlConnectionFactoryKt;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p039io.FilesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: FontLoader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020$JC\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0015H\u0002R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/FontLoader;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "providedCacheDir", "Ljava/io/File;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "urlConnectionFactory", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "(Landroid/content/Context;Ljava/io/File;Lkotlinx/coroutines/CoroutineScope;Lcom/revenuecat/purchases/utils/UrlConnectionFactory;)V", "cacheDirectory", "getCacheDirectory", "()Ljava/io/File;", "cacheDirectory$delegate", "Lkotlin/Lazy;", "cachedFontFamilyByFamilyName", "", "", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "cachedFontFamilyByFontInfo", "Lcom/revenuecat/purchases/paywalls/fonts/DownloadableFontInfo;", "fontInfosForHash", "", "hasCheckedFoldersExist", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "addFileToCache", "", "urlHash", "file", "ensureFoldersExist", "", "cacheDir", "getCachedFontFamilyOrStartDownload", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "performDownloadAndCache", "Lkotlin/Result;", ImagesContract.URL, "expectedMd5", "extension", "performDownloadAndCache-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/lang/Object;", "startFontDownload", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class FontLoader {

    /* JADX INFO: renamed from: cacheDirectory$delegate, reason: from kotlin metadata */
    private final Lazy cacheDirectory;
    private final Map<String, DownloadedFontFamily> cachedFontFamilyByFamilyName;
    private final Map<DownloadableFontInfo, String> cachedFontFamilyByFontInfo;
    private final Context context;
    private final Map<String, Set<DownloadableFontInfo>> fontInfosForHash;
    private AtomicBoolean hasCheckedFoldersExist;
    private final CoroutineScope ioScope;
    private final Object lock;
    private final File providedCacheDir;
    private final UrlConnectionFactory urlConnectionFactory;

    public FontLoader(Context context, File file, CoroutineScope ioScope, UrlConnectionFactory urlConnectionFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(urlConnectionFactory, "urlConnectionFactory");
        this.context = context;
        this.providedCacheDir = file;
        this.ioScope = ioScope;
        this.urlConnectionFactory = urlConnectionFactory;
        this.hasCheckedFoldersExist = new AtomicBoolean(false);
        this.cacheDirectory = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<File>() { // from class: com.revenuecat.purchases.paywalls.FontLoader$cacheDirectory$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File file2 = this.this$0.providedCacheDir;
                if (file2 != null) {
                    return file2;
                }
                File cacheDir = this.this$0.context.getCacheDir();
                if (cacheDir != null) {
                    return new File(cacheDir, "rc_paywall_fonts");
                }
                return null;
            }
        });
        this.fontInfosForHash = new LinkedHashMap();
        this.lock = new Object();
        this.cachedFontFamilyByFontInfo = new LinkedHashMap();
        this.cachedFontFamilyByFamilyName = new LinkedHashMap();
    }

    public /* synthetic */ FontLoader(Context context, File file, CoroutineScope coroutineScope, DefaultUrlConnectionFactory defaultUrlConnectionFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : file, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope, (i & 8) != 0 ? new DefaultUrlConnectionFactory() : defaultUrlConnectionFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return (File) this.cacheDirectory.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object] */
    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        Result downloadableFontInfo = DownloadableFontInfoKt.toDownloadableFontInfo(fontInfo);
        if (!(downloadableFontInfo instanceof Result.Success)) {
            if (!(downloadableFontInfo instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", (String) ((Result.Error) downloadableFontInfo).getValue(), null);
            return null;
        }
        DownloadableFontInfo downloadableFontInfo2 = (DownloadableFontInfo) ((Result.Success) downloadableFontInfo).getValue();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            objectRef.element = this.cachedFontFamilyByFamilyName.get(this.cachedFontFamilyByFontInfo.get(downloadableFontInfo2));
            Unit unit = Unit.INSTANCE;
        }
        if (objectRef.element != 0) {
            List fonts = ((DownloadedFontFamily) objectRef.element).getFonts();
            if (!(fonts instanceof Collection) || !fonts.isEmpty()) {
                Iterator it = fonts.iterator();
                while (it.hasNext()) {
                    if (!((DownloadedFont) it.next()).getFile().exists()) {
                        LogLevel logLevel = LogLevel.WARN;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.mo1545w("[Purchases] - " + logLevel.name(), "Cached font files missing for " + ((DownloadedFontFamily) objectRef.element).getFamily() + ", re-downloading");
                        }
                        synchronized (this.lock) {
                            if (this.cachedFontFamilyByFamilyName.get(((DownloadedFontFamily) objectRef.element).getFamily()) == objectRef.element) {
                                this.cachedFontFamilyByFamilyName.remove(((DownloadedFontFamily) objectRef.element).getFamily());
                                CollectionsKt.removeAll(this.cachedFontFamilyByFontInfo.entrySet(), new Function1<Map.Entry<DownloadableFontInfo, String>, Boolean>() { // from class: com.revenuecat.purchases.paywalls.FontLoader$getCachedFontFamilyOrStartDownload$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(Map.Entry<DownloadableFontInfo, String> it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        return Boolean.valueOf(Intrinsics.areEqual(it2.getValue(), objectRef.element.getFamily()));
                                    }
                                });
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }
            }
            return (DownloadedFontFamily) objectRef.element;
        }
        startFontDownload(downloadableFontInfo2);
        return null;
    }

    private final void startFontDownload(DownloadableFontInfo fontInfo) {
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C73561(fontInfo.getUrl(), fontInfo.getExpectedMd5(), fontInfo, null), 3, null);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1 */
    /* JADX INFO: compiled from: FontLoader.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1", m1609f = "FontLoader.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C73561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $expectedMd5;
        final /* synthetic */ DownloadableFontInfo $fontInfo;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C73561(String str, String str2, DownloadableFontInfo downloadableFontInfo, Continuation<? super C73561> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$expectedMd5 = str2;
            this.$fontInfo = downloadableFontInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FontLoader.this.new C73561(this.$url, this.$expectedMd5, this.$fontInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C73561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            FontLoader fontLoader;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File cacheDirectory = FontLoader.this.getCacheDirectory();
            if (cacheDirectory == null) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Cannot download font: cache directory is not available", null);
                return Unit.INSTANCE;
            }
            if (!FontLoader.this.ensureFoldersExist(cacheDirectory)) {
                return Unit.INSTANCE;
            }
            byte[] bytes = this.$url.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String strMd5Hex = UtilsKt.md5Hex(bytes);
            String strSubstringAfterLast = StringsKt.substringAfterLast(this.$url, '.', "");
            File file = new File(cacheDirectory, strMd5Hex + '.' + strSubstringAfterLast);
            Object obj3 = FontLoader.this.lock;
            FontLoader fontLoader2 = FontLoader.this;
            DownloadableFontInfo downloadableFontInfo = this.$fontInfo;
            String str = this.$url;
            synchronized (obj3) {
                Set set = (Set) fontLoader2.fontInfosForHash.get(strMd5Hex);
                if (set != null) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Font download already in progress for " + str);
                    }
                    set.add(downloadableFontInfo);
                    return Unit.INSTANCE;
                }
                fontLoader2.fontInfosForHash.put(strMd5Hex, SetsKt.mutableSetOf(downloadableFontInfo));
                Unit unit = Unit.INSTANCE;
                if (file.exists()) {
                    FontLoader.this.addFileToCache(strMd5Hex, file);
                    return Unit.INSTANCE;
                }
                try {
                    Object objM13758performDownloadAndCacheyxL6bBk = FontLoader.this.m13758performDownloadAndCacheyxL6bBk(this.$url, this.$expectedMd5, strMd5Hex, strSubstringAfterLast, cacheDirectory);
                    FontLoader fontLoader3 = FontLoader.this;
                    if (kotlin.Result.m14506isSuccessimpl(objM13758performDownloadAndCacheyxL6bBk)) {
                        fontLoader3.addFileToCache(strMd5Hex, (File) objM13758performDownloadAndCacheyxL6bBk);
                    }
                    DownloadableFontInfo downloadableFontInfo2 = this.$fontInfo;
                    if (kotlin.Result.m14502exceptionOrNullimpl(objM13758performDownloadAndCacheyxL6bBk) != null) {
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Failed to download font for " + downloadableFontInfo2.getFamily(), null);
                    }
                    obj2 = FontLoader.this.lock;
                    fontLoader = FontLoader.this;
                } catch (Throwable th) {
                    try {
                        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Error downloading remote font from " + this.$url, th);
                        obj2 = FontLoader.this.lock;
                        FontLoader fontLoader4 = FontLoader.this;
                        synchronized (obj2) {
                        }
                    } catch (Throwable th2) {
                        Object obj4 = FontLoader.this.lock;
                        FontLoader fontLoader5 = FontLoader.this;
                        synchronized (obj4) {
                            throw th2;
                        }
                    }
                }
                synchronized (obj2) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFileToCache(String urlHash, File file) {
        synchronized (this.lock) {
            Set<DownloadableFontInfo> setEmptySet = this.fontInfosForHash.get(urlHash);
            if (setEmptySet == null) {
                setEmptySet = SetsKt.emptySet();
            }
            for (DownloadableFontInfo downloadableFontInfo : setEmptySet) {
                String family = downloadableFontInfo.getFamily();
                if (this.cachedFontFamilyByFontInfo.get(downloadableFontInfo) == null) {
                    DownloadedFontFamily downloadedFontFamily = this.cachedFontFamilyByFamilyName.get(family);
                    if (downloadedFontFamily != null) {
                        this.cachedFontFamilyByFamilyName.put(family, new DownloadedFontFamily(downloadedFontFamily.getFamily(), CollectionsKt.plus((Collection<? extends DownloadedFont>) downloadedFontFamily.getFonts(), new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file))));
                        this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                    } else {
                        DownloadedFontFamily downloadedFontFamily2 = new DownloadedFontFamily(family, CollectionsKt.listOf(new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file)));
                        this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                        this.cachedFontFamilyByFamilyName.put(family, downloadedFontFamily2);
                    }
                } else {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "Font already cached for " + family + ". Skipping download.");
                    }
                }
            }
            this.fontInfosForHash.remove(urlHash);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ensureFoldersExist(File cacheDir) {
        boolean z = true;
        if (this.hasCheckedFoldersExist.get()) {
            return true;
        }
        if (cacheDir.exists() || cacheDir.mkdirs()) {
            if (!cacheDir.isDirectory()) {
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Remote fonts cache path exists but is not a directory: " + cacheDir.getAbsolutePath(), null);
            }
            this.hasCheckedFoldersExist.set(z);
            return z;
        }
        LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Unable to create cache directory for remote fonts: " + cacheDir.getAbsolutePath(), null);
        z = false;
        this.hasCheckedFoldersExist.set(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performDownloadAndCache-yxL6bBk, reason: not valid java name */
    public final Object m13758performDownloadAndCacheyxL6bBk(String url, String expectedMd5, String urlHash, String extension, File cacheDir) throws Throwable {
        File file = new File(cacheDir, urlHash + '.' + extension);
        File tempFile = File.createTempFile("rc_paywall_font_download_", "." + extension, cacheDir);
        try {
            UrlConnectionFactory urlConnectionFactory = this.urlConnectionFactory;
            Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
            UrlConnectionFactoryKt.downloadToFile(urlConnectionFactory, url, tempFile, "paywall font");
            String strMd5Hex = UtilsKt.md5Hex(FilesKt.readBytes(tempFile));
            if (!StringsKt.equals(strMd5Hex, expectedMd5, true)) {
                tempFile.delete();
                LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Downloaded font file is corrupt for " + url + ". expected=" + expectedMd5 + ", actual=" + strMd5Hex, null);
                Result.Companion companion = kotlin.Result.INSTANCE;
                return kotlin.Result.m14499constructorimpl(ResultKt.createFailure(new IOException("Downloaded font file is corrupt for " + url)));
            }
            if (!tempFile.renameTo(file)) {
                FilesKt.copyTo$default(tempFile, file, true, 0, 4, null);
                tempFile.delete();
            }
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1541d("[Purchases] - " + logLevel.name(), "Font downloaded successfully from " + url);
            }
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            return kotlin.Result.m14499constructorimpl(file);
        } catch (IOException e) {
            if (tempFile.exists()) {
                tempFile.delete();
            }
            LogWrapperKt.getCurrentLogHandler().mo1542e("[Purchases] - ERROR", "Error downloading font from " + url + ": " + e.getMessage(), null);
            Result.Companion companion3 = kotlin.Result.INSTANCE;
            return kotlin.Result.m14499constructorimpl(ResultKt.createFailure(e));
        }
    }
}
