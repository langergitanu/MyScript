package com.myscript.nebo.dms.core;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.preference.PreferenceManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.ColorExt;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.android.utils.StringSharedPreferencesProperty;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.BackgroundPatternExt;
import com.myscript.atk.core.CustomResource;
import com.myscript.atk.core.ICancelableTaskProgressCallback;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.IdentityColorInversionPolicy;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.SWIGVectorString;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.TypesetListener;
import com.myscript.atk.resourcemanager.ResourceManager;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.utils.NameUtils;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.CollectionPropertiesValidator;
import com.myscript.nebo.dms.core.FolderPropertiesValidator;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.event.OnDMSSyncStateChangedEvent;
import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.nebo.dms.util.UserAgent;
import com.myscript.nebo.languagemanager.util.LanguageListUtil;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.DisplayContext;
import com.myscript.snt.core.DocumentController;
import com.myscript.snt.core.ExportController;
import com.myscript.snt.core.IDocumentConfRequester;
import com.myscript.snt.core.IRendererListener;
import com.myscript.snt.core.IThumbnailerImageRequester;
import com.myscript.snt.core.IThumbnailerNotificationListener;
import com.myscript.snt.core.NeboSanitizer;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageControllerSanitized;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.PaperSize;
import com.myscript.snt.core.RecoContext;
import com.myscript.snt.core.SWIGOptionContext;
import com.myscript.snt.core.SearchController;
import com.myscript.snt.core.Thumbnailer;
import com.myscript.snt.dms.CloudOperationLogger;
import com.myscript.snt.dms.Collection;
import com.myscript.snt.dms.DMS;
import com.myscript.snt.dms.DMSConfiguration;
import com.myscript.snt.dms.DMSFilter;
import com.myscript.snt.dms.DMSSyncState;
import com.myscript.snt.dms.DegradedCloudDriveWrapper;
import com.myscript.snt.dms.ICloudDriveInterface;
import com.myscript.snt.dms.IDMSListener;
import com.myscript.snt.dms.IDMSMigrationToV2LogListener;
import com.myscript.snt.dms.IPageCorruptionListener;
import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.NeboBackupController;
import com.myscript.snt.dms.Notebook;
import com.myscript.snt.dms.NotebookManager;
import com.myscript.snt.dms.Page;
import com.myscript.snt.dms.PageType;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.p039io.FilesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: LibraryRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000þ\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 û\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0012ó\u0002ô\u0002õ\u0002ö\u0002÷\u0002ø\u0002ù\u0002ú\u0002û\u0002B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010_\u001a\u00020`J\u000e\u0010e\u001a\u00020`2\u0006\u0010f\u001a\u00020bJ\u000e\u0010g\u001a\u00020`2\u0006\u0010f\u001a\u00020bJ\u0006\u0010h\u001a\u00020`J\u0006\u0010i\u001a\u00020`J\u0018\u0010j\u001a\u00020`2\u0006\u0010k\u001a\u00020E2\u0006\u0010l\u001a\u00020FH\u0016J\u0018\u0010m\u001a\u00020`2\u0006\u0010k\u001a\u00020E2\u0006\u0010l\u001a\u00020FH\u0016J\u0010\u0010n\u001a\u00020`2\u0006\u0010k\u001a\u00020EH\u0002J\u0010\u0010o\u001a\u00020`2\u0006\u0010k\u001a\u00020EH\u0002J\u0018\u0010p\u001a\u00020`2\u0006\u0010q\u001a\u00020E2\u0006\u0010r\u001a\u00020EH\u0002J\u0018\u0010s\u001a\u00020`2\u0006\u0010t\u001a\u00020B2\u0006\u0010u\u001a\u00020CH\u0016J\u0018\u0010v\u001a\u00020`2\u0006\u0010t\u001a\u00020B2\u0006\u0010u\u001a\u00020CH\u0016J\u0010\u0010w\u001a\u00020`2\u0006\u0010t\u001a\u00020BH\u0002J\u0010\u0010x\u001a\u00020`2\u0006\u0010t\u001a\u00020BH\u0002J \u0010y\u001a\u00020`2\u0006\u0010z\u001a\u00020X2\u0006\u0010{\u001a\u00020J2\u0006\u0010|\u001a\u00020LH\u0002J\u0010\u0010}\u001a\u00020`2\u0006\u0010~\u001a\u00020HH\u0016J\u0010\u0010\u007f\u001a\u00020`2\u0006\u0010~\u001a\u00020HH\u0016J%\u0010\u0080\u0001\u001a\u00020`2\u001a\u0010\u0081\u0001\u001a\u0015\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020`0\u0082\u0001¢\u0006\u0003\b\u0083\u0001H\u0002J\t\u0010\u0086\u0001\u001a\u00020`H\u0002J\u001e\u0010\u0089\u0001\u001a\u00020`2\u0007\u0010\u008a\u0001\u001a\u00020R2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0002J\u001c\u0010\u0089\u0001\u001a\u00020`2\u0007\u0010\u008a\u0001\u001a\u00020R2\b\u0010t\u001a\u0004\u0018\u00010BH\u0002J\u001c\u0010\u0089\u0001\u001a\u00020`2\u0007\u0010\u008a\u0001\u001a\u00020R2\b\u0010k\u001a\u0004\u0018\u00010EH\u0002J\u0012\u0010\u0089\u0001\u001a\u00020`2\u0007\u0010\u008a\u0001\u001a\u00020RH\u0002J\u0013\u0010\u0093\u0001\u001a\u00020`2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001J\u001a\u0010\u0096\u0001\u001a\u00020`2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020LJ\u0011\u0010\u009a\u0001\u001a\u00020`2\u0006\u0010k\u001a\u00020EH\u0016J\u001b\u0010\u009b\u0001\u001a\u00020R2\u0006\u0010k\u001a\u00020E2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\u0013\u0010\u009e\u0001\u001a\u00020`2\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0016J\u0013\u0010¡\u0001\u001a\u00020`2\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0016J\u0011\u0010¢\u0001\u001a\u00020L2\u0006\u0010k\u001a\u00020EH\u0016J\u0010\u0010£\u0001\u001a\u00020`2\u0007\u0010¤\u0001\u001a\u00020RJ\u0010\u0010¥\u0001\u001a\u00020`2\u0007\u0010¦\u0001\u001a\u00020=J\u0010\u0010§\u0001\u001a\u00020`2\u0007\u0010¦\u0001\u001a\u00020=J\u0010\u0010¨\u0001\u001a\u00020`2\u0007\u0010©\u0001\u001a\u00020?J\u0010\u0010ª\u0001\u001a\u00020`2\u0007\u0010©\u0001\u001a\u00020?J\u001b\u0010«\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ad\u00010¬\u00012\b\u0010®\u0001\u001a\u00030¯\u0001H\u0016J\t\u0010±\u0001\u001a\u00020`H\u0007J\u0011\u0010²\u0001\u001a\u00030³\u00012\u0007\u0010´\u0001\u001a\u00020RJ\u001d\u0010µ\u0001\u001a\u00030¶\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0007\u0010·\u0001\u001a\u00020RJ\u000f\u0010¸\u0001\u001a\u00020`2\u0006\u0010k\u001a\u00020EJ)\u0010¹\u0001\u001a\u0004\u0018\u00010B2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010·\u0001\u001a\u00020R2\t\b\u0001\u0010º\u0001\u001a\u00020JH\u0016J\u001b\u0010»\u0001\u001a\n\u0012\u0005\u0012\u00030¼\u00010¬\u00012\b\u0010½\u0001\u001a\u00030\u008c\u0001H\u0002J%\u0010»\u0001\u001a\n\u0012\u0005\u0012\u00030¼\u00010¬\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010®\u0001\u001a\u00030¯\u0001H\u0002J\u0016\u0010¾\u0001\u001a\t\u0012\u0004\u0012\u00020E0¬\u00012\u0006\u0010t\u001a\u00020BJ\u001a\u0010¿\u0001\u001a\u00020L2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010·\u0001\u001a\u00020RJ\u0012\u0010À\u0001\u001a\u00020L2\u0007\u0010´\u0001\u001a\u00020RH\u0007J\u0015\u0010Á\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0007\u0010´\u0001\u001a\u00020RH\u0016J\u0016\u0010Â\u0001\u001a\u0005\u0018\u00010\u00ad\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001J\u0015\u0010Ã\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0007\u0010Ä\u0001\u001a\u00020RH\u0016J\u0011\u0010Å\u0001\u001a\u00020`2\b\u0010Æ\u0001\u001a\u00030\u008c\u0001J\u001a\u0010Ç\u0001\u001a\u00020L2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010È\u0001\u001a\u00020RJ\u0010\u0010É\u0001\u001a\u00020`2\u0007\u0010Ê\u0001\u001a\u00020BJ\u0019\u0010Ë\u0001\u001a\u00020`2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010B0¬\u0001J.\u0010Í\u0001\u001a\u00020`2\u0007\u0010Î\u0001\u001a\u00020B2\u0007\u0010Ï\u0001\u001a\u00020R2\b\u0010Ð\u0001\u001a\u00030\u008c\u00012\t\b\u0001\u0010Ñ\u0001\u001a\u00020JJ!\u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020E0¬\u00012\u0007\u0010Ó\u0001\u001a\u00020\u001a2\u0006\u0010t\u001a\u00020BH\u0016J1\u0010Ô\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010t\u001a\u00020B2\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0007\u0010×\u0001\u001a\u00020R2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u001aH\u0002J%\u0010Ù\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010t\u001a\u00020B2\u0007\u0010Ú\u0001\u001a\u00020\u001a2\u0007\u0010×\u0001\u001a\u00020RH\u0016J\u001a\u0010Û\u0001\u001a\u00030Ü\u00012\u0006\u0010k\u001a\u00020E2\b\u0010Ý\u0001\u001a\u00030Þ\u0001J0\u0010ß\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010t\u001a\u00020B2\u0007\u0010Ï\u0001\u001a\u00020R2\u0007\u0010×\u0001\u001a\u00020R2\t\b\u0001\u0010à\u0001\u001a\u00020JH\u0016J:\u0010á\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010t\u001a\u00020B2\u0007\u0010Ï\u0001\u001a\u00020R2\u0007\u0010×\u0001\u001a\u00020R2\t\b\u0001\u0010à\u0001\u001a\u00020J2\b\u0010â\u0001\u001a\u00030ã\u0001H\u0016JV\u0010ä\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010t\u001a\u00020B2\u0007\u0010Ï\u0001\u001a\u00020R2\u0007\u0010×\u0001\u001a\u00020R2\u0010\b\u0001\u0010å\u0001\u001a\t\u0012\u0004\u0012\u00020J0¬\u00012\b\u0010æ\u0001\u001a\u00030ç\u00012\t\b\u0001\u0010à\u0001\u001a\u00020J2\b\u0010â\u0001\u001a\u00030ã\u0001H\u0016J\u0014\u0010è\u0001\u001a\u0005\u0018\u00010é\u00012\u0006\u0010k\u001a\u00020EH\u0016J\u0017\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030é\u00010¬\u00012\u0006\u0010t\u001a\u00020BJ\u0018\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030é\u00010¬\u00012\u0007\u0010ë\u0001\u001a\u00020EJ$\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030é\u00010¬\u00012\u0007\u0010ì\u0001\u001a\u00020B2\b\u0010®\u0001\u001a\u00030¯\u0001H\u0016J$\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030é\u00010¬\u00012\u0007\u0010ë\u0001\u001a\u00020E2\b\u0010®\u0001\u001a\u00030¯\u0001H\u0016J\u001a\u0010í\u0001\u001a\u00020`2\u0006\u0010k\u001a\u00020E2\u0007\u0010È\u0001\u001a\u00020RH\u0016J\u0013\u0010î\u0001\u001a\u0004\u0018\u00010R2\b\u0010k\u001a\u0004\u0018\u00010EJ.\u0010ï\u0001\u001a\u00030ð\u00012\u0006\u0010k\u001a\u00020E2\b\u0010ñ\u0001\u001a\u00030ò\u00012\b\u0010ó\u0001\u001a\u00030ô\u00012\b\u0010õ\u0001\u001a\u00030ö\u0001J$\u0010÷\u0001\u001a\u00020`2\b\u0010k\u001a\u0004\u0018\u00010E2\b\u0010ø\u0001\u001a\u00030ù\u00012\u0007\u0010ú\u0001\u001a\u00020LJ\u000f\u0010û\u0001\u001a\u00020`2\u0006\u0010t\u001a\u00020BJ\u000f\u0010\u0086\u0002\u001a\u00020`2\u0006\u0010k\u001a\u00020EJ\u0019\u0010\u0087\u0002\u001a\u00020`2\u000e\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020E0¬\u0001H\u0016J\u0007\u0010\u0089\u0002\u001a\u00020`J\u0007\u0010\u008a\u0002\u001a\u00020`J\u0014\u0010\u008b\u0002\u001a\u0005\u0018\u00010Ö\u00012\b\u0010k\u001a\u0004\u0018\u00010EJ\u0011\u0010\u008c\u0002\u001a\u00020L2\b\u0010k\u001a\u0004\u0018\u00010EJ!\u0010\u008d\u0002\u001a\u00020L2\u0006\u0010k\u001a\u00020E2\u0007\u0010\u008e\u0002\u001a\u00020R2\u0007\u0010\u008a\u0001\u001a\u00020RJ!\u0010\u008f\u0002\u001a\u00020L2\u0006\u0010k\u001a\u00020E2\u0007\u0010\u008e\u0002\u001a\u00020R2\u0007\u0010\u008a\u0001\u001a\u00020RJ\u000f\u0010\u0090\u0002\u001a\u00020L2\u0006\u0010k\u001a\u00020EJ\u0014\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u008c\u00012\b\u0010t\u001a\u0004\u0018\u00010BJ\u0011\u0010\u0092\u0002\u001a\u0004\u0018\u00010B2\u0006\u0010k\u001a\u00020EJ\u0011\u0010\u0093\u0002\u001a\u0004\u0018\u00010E2\u0006\u0010k\u001a\u00020EJ\u0012\u0010\u0094\u0002\u001a\u0005\u0018\u00010é\u00012\u0006\u0010k\u001a\u00020EJ\u000e\u0010\u0095\u0002\u001a\t\u0012\u0004\u0012\u00020R0¬\u0001J\u0010\u0010\u0096\u0002\u001a\u00020L2\u0007\u0010\u0097\u0002\u001a\u00020RJ\u0011\u0010\u0096\u0002\u001a\u00020L2\u0006\u0010k\u001a\u00020EH\u0016J\u0019\u0010£\u0002\u001a\u00020L2\u000e\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020E0¬\u0001H\u0016J\u000f\u0010¤\u0002\u001a\u00020L2\u0006\u0010t\u001a\u00020BJ\u001b\u0010¥\u0002\u001a\u00020L2\u0006\u0010k\u001a\u00020E2\b\u0010¦\u0002\u001a\u00030§\u0002H\u0016JG\u0010¨\u0002\u001a\u00030©\u00022\u000e\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020E0¬\u00012\b\u0010ª\u0002\u001a\u00030«\u00022\b\u0010¬\u0002\u001a\u00030\u00ad\u00022\b\u0010®\u0002\u001a\u00030¯\u00022\u000f\u0010°\u0002\u001a\n\u0012\u0005\u0012\u00030±\u00020¬\u0001J\u001a\u0010²\u0002\u001a\u0004\u0018\u00010\u001a2\u0006\u0010k\u001a\u00020E2\u0007\u0010³\u0002\u001a\u00020\u001aJ\u0014\u0010´\u0002\u001a\u0005\u0018\u00010¼\u00012\u0006\u0010t\u001a\u00020BH\u0016J\u001a\u0010µ\u0002\u001a\u00020E2\u0006\u0010k\u001a\u00020E2\u0007\u0010¶\u0002\u001a\u00020JH\u0016J\u0013\u0010·\u0002\u001a\u0004\u0018\u00010E2\u0006\u0010k\u001a\u00020EH\u0016J\u001a\u0010¸\u0002\u001a\u00020E2\u0006\u0010k\u001a\u00020E2\u0007\u0010¶\u0002\u001a\u00020JH\u0016J\u0019\u0010¸\u0002\u001a\u00020E2\u0006\u0010k\u001a\u00020E2\u0006\u0010t\u001a\u00020BH\u0016J!\u0010¹\u0002\u001a\u00020`2\u000e\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020E0¬\u00012\u0006\u0010t\u001a\u00020BH\u0016J\u0011\u0010º\u0002\u001a\u00020`2\u0006\u0010k\u001a\u00020EH\u0016J\t\u0010»\u0002\u001a\u00020`H\u0016J\u0014\u0010¼\u0002\u001a\u0004\u0018\u00010E2\u0007\u0010½\u0002\u001a\u00020EH\u0016J\u0011\u0010¾\u0002\u001a\u00020`2\u0006\u0010k\u001a\u00020EH\u0016J\u0012\u0010¿\u0002\u001a\u00020`2\u0007\u0010½\u0002\u001a\u00020EH\u0016J,\u0010À\u0002\u001a\u0003HÁ\u0002\"\u0005\b\u0000\u0010Á\u00022\u0015\u0010Â\u0002\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0005\u0012\u0003HÁ\u00020\u0082\u0001¢\u0006\u0003\u0010Ã\u0002J\u0013\u0010Ê\u0002\u001a\u00020`2\n\u0010Ë\u0002\u001a\u0005\u0018\u00010Ì\u0002J\u0019\u0010Í\u0002\u001a\u00020`2\u0007\u0010Î\u0002\u001a\u00020J2\u0007\u0010Ï\u0002\u001a\u00020JJ\u0007\u0010Ð\u0002\u001a\u00020`J\u0007\u0010Ñ\u0002\u001a\u00020`J\t\u0010Ò\u0002\u001a\u00020`H\u0007J\t\u0010Ó\u0002\u001a\u00020`H\u0016J\u001a\u0010Ô\u0002\u001a\u00020`2\u0006\u0010k\u001a\u00020E2\t\b\u0001\u0010º\u0001\u001a\u00020JJ\u0018\u0010Õ\u0002\u001a\u00020`2\u0006\u0010k\u001a\u00020E2\u0007\u0010Ö\u0002\u001a\u00020RJ\u0010\u0010×\u0002\u001a\u00020R2\u0007\u0010Ø\u0002\u001a\u00020RJ\u0012\u0010Ù\u0002\u001a\u00020R2\t\u0010Ú\u0002\u001a\u0004\u0018\u00010RJ\n\u0010Û\u0002\u001a\u00030\u009d\u0001H\u0016J\u001d\u0010Ü\u0002\u001a\u00020L2\b\u0010Ý\u0002\u001a\u00030Þ\u00022\b\u0010ß\u0002\u001a\u00030à\u0002H\u0016J\u0007\u0010á\u0002\u001a\u00020`J\u0007\u0010â\u0002\u001a\u00020`J\u0011\u0010ã\u0002\u001a\u00020`2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001J\u0011\u0010ä\u0002\u001a\u00020`2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001J\u0017\u0010å\u0002\u001a\u00020`2\u000e\u0010æ\u0002\u001a\t\u0012\u0004\u0012\u00020B0¬\u0001J\u0017\u0010ç\u0002\u001a\u00020`2\u000e\u0010æ\u0002\u001a\t\u0012\u0004\u0012\u00020B0¬\u0001J\u0017\u0010è\u0002\u001a\u00020`2\u000e\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020E0¬\u0001J\u0017\u0010é\u0002\u001a\u00020`2\u000e\u0010\u0088\u0002\u001a\t\u0012\u0004\u0012\u00020E0¬\u0001J\u0012\u0010ê\u0002\u001a\u0005\u0018\u00010ë\u00022\u0006\u0010k\u001a\u00020EJ*\u0010ì\u0002\u001a\u00020`2\u0006\u0010k\u001a\u00020E2\u0007\u0010í\u0002\u001a\u00020R2\u0010\b\u0001\u0010î\u0002\u001a\t\u0012\u0004\u0012\u00020J0¬\u0001J\u0017\u0010ï\u0002\u001a\u00020`2\u000e\u0010ð\u0002\u001a\t\u0012\u0004\u0012\u00020R0¬\u0001J\u0012\u0010ñ\u0002\u001a\u00020J2\t\b\u0002\u0010ò\u0002\u001a\u00020LR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0<X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010@\u001a\u0014\u0012\u0004\u0012\u00020B\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0<0AX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010D\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0<0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020H0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u00020L@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Y\u001a\u00020Z¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020b0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010\u001eR\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u008f\u0001\u001a\u00030\u0090\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0013\u0010°\u0001\u001a\u00020L8F¢\u0006\u0007\u001a\u0005\b°\u0001\u0010NR\u0014\u0010ü\u0001\u001a\u00020X8F¢\u0006\b\u001a\u0006\bý\u0001\u0010þ\u0001R\u0013\u0010ÿ\u0001\u001a\u00020L8F¢\u0006\u0007\u001a\u0005\bÿ\u0001\u0010NR\u0013\u0010\u0080\u0002\u001a\u00020L8F¢\u0006\u0007\u001a\u0005\b\u0080\u0002\u0010NR(\u0010\u0082\u0002\u001a\u00020L2\u0007\u0010\u0081\u0002\u001a\u00020L@GX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0002\u0010N\"\u0005\b\u0083\u0002\u0010PR\u0016\u0010\u0084\u0002\u001a\u00020LX\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0002\u0010NR.\u0010\u0099\u0002\u001a\u0004\u0018\u00010B2\t\u0010\u0098\u0002\u001a\u0004\u0018\u00010B8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R.\u0010\u009e\u0002\u001a\u0004\u0018\u00010E2\t\u0010\u0098\u0002\u001a\u0004\u0018\u00010E8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u009f\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R1\u0010Å\u0002\u001a\u00020R2\u0007\u0010Ä\u0002\u001a\u00020R8V@VX\u0096\u008e\u0002¢\u0006\u0016\n\u0006\bÈ\u0002\u0010É\u0002\u001a\u0005\bÆ\u0002\u0010T\"\u0005\bÇ\u0002\u0010V¨\u0006ü\u0002"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository;", "Lcom/myscript/nebo/dms/core/PageManager;", "Lcom/myscript/nebo/dms/core/LibraryMigrator;", "Lcom/myscript/nebo/dms/core/CollectionsManager;", "Lcom/myscript/nebo/dms/core/ContentInitializer;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "config", "Lcom/myscript/nebo/dms/core/LibraryRepositoryConfig;", "resourceManager", "Lcom/myscript/atk/resourcemanager/ResourceManager;", "userAgent", "Lcom/myscript/nebo/dms/util/UserAgent;", "corruptionListener", "Lcom/myscript/snt/dms/IPageCorruptionListener;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/dms/core/LibraryRepositoryConfig;Lcom/myscript/atk/resourcemanager/ResourceManager;Lcom/myscript/nebo/dms/util/UserAgent;Lcom/myscript/snt/dms/IPageCorruptionListener;Lcom/myscript/nebo/log/TechnicalLogger;)V", "syncHelper", "Lcom/myscript/nebo/dms/core/SyncHelper;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutinesScope", "Lkotlinx/coroutines/CoroutineScope;", "filesDirectory", "Ljava/io/File;", "cacheDirectory", "rootDir", "getRootDir", "()Ljava/io/File;", "databaseDir", "getDatabaseDir", "workingDirectory", "getWorkingDirectory", "sharedPreferences", "Landroid/content/SharedPreferences;", "confPath", "Lcom/myscript/atk/core/SWIGVectorString;", "confRequester", "Lcom/myscript/snt/core/IDocumentConfRequester;", "dms", "Lcom/myscript/snt/dms/DMS;", "backupController", "Lcom/myscript/snt/dms/NeboBackupController;", "getBackupController", "()Lcom/myscript/snt/dms/NeboBackupController;", "documentController", "Lcom/myscript/snt/core/DocumentController;", "folderValidator", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator;", "collectionValidator", "Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator;", "displayMetrics", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "()Landroid/util/DisplayMetrics;", "setDisplayMetrics", "(Landroid/util/DisplayMetrics;)V", "modelChangedListeners", "", "Lcom/myscript/nebo/dms/core/LibraryRepository$ModelChangedListener;", "syncListeners", "Lcom/myscript/nebo/dms/core/LibraryRepository$SyncListener;", "folderListeners", "", "Lcom/myscript/snt/core/NotebookKey;", "Lcom/myscript/nebo/dms/core/LibraryRepository$FolderListener;", "pageListeners", "Lcom/myscript/snt/core/PageKey;", "Lcom/myscript/nebo/dms/core/LibraryRepository$PageListener;", "trashListeners", "Lcom/myscript/nebo/dms/core/LibraryRepository$TrashListener;", "lastNumberOfNotebookToSynchronize", "", "hasCloudProvider", "", "getHasCloudProvider", "()Z", "setHasCloudProvider", "(Z)V", "cloudProviderName", "", "getCloudProviderName", "()Ljava/lang/String;", "setCloudProviderName", "(Ljava/lang/String;)V", "previousSyncState", "Lcom/myscript/snt/dms/DMSSyncState;", "cloudOperationLogger", "Lcom/myscript/snt/dms/CloudOperationLogger;", "getCloudOperationLogger", "()Lcom/myscript/snt/dms/CloudOperationLogger;", "pendingSyncFailureReason", "Lcom/myscript/nebo/dms/core/LibraryRepository$SyncFailureReason;", "notifyCloudStorageFull", "", "cloudTokenExpirationListeners", "Lcom/myscript/nebo/dms/core/LibraryRepository$CloudTokenExpirationListener;", "degradedCloudDriveWrapper", "Lcom/myscript/snt/dms/DegradedCloudDriveWrapper;", "addCloudTokenExpirationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeCloudTokenExpirationListener", "notifyCloudTokenExpired", "notifyValidCloudToken", "addPageListener", "pageKey", "pageListener", "removePageListener", "notifyPageUpdated", "notifyPageRemoved", "notifyPageUUIDReset", "previousKey", "newKey", "addFolderListener", "notebookKey", "folderListener", "removeFolderListener", "notifyFolderUpdated", "notifyFolderRemoved", "notifySyncState", "syncState", "notebooksToSync", "userAction", "addTrashListener", "trashListener", "removeTrashListener", "notifyTrash", "notification", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "onDmsUpdate", "Lcom/myscript/snt/dms/IDMSListener;", "notifyUpdate", "cloudOperations", "getCloudOperations", "logTrace", "message", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "thumbnailer", "Lcom/myscript/snt/core/Thumbnailer;", "searchController", "Lcom/myscript/nebo/dms/search/DMSSearchController;", "getSearchController", "()Lcom/myscript/nebo/dms/search/DMSSearchController;", "setThumbnailImageRequester", "thumbnailImageProvider", "Lcom/myscript/snt/core/IThumbnailerImageRequester;", "updateColorPolicy", "colorPolicy", "Lcom/myscript/atk/core/IColorInversionPolicy;", "isDarkMode", "createThumbnail", "getThumbnailPath", "lastModificationDate", "", "addThumbnailListener", "thumbnailListener", "Lcom/myscript/snt/core/IThumbnailerNotificationListener;", "removeThumbnailListener", "isSamplePage", "setPublicAuthorId", "publicAuthorId", "addModelChangedListener", "modelChangedListener", "removeModelChangedListener", "addSyncListener", "syncListener", "removeSyncListener", "getCollectionModels", "", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "filter", "Lcom/myscript/snt/dms/DMSFilter;", "isEmpty", "waitForIdle", "validateCollection", "Lcom/myscript/nebo/dms/core/CollectionPropertiesValidator$Status;", "collectionName", "validateFolder", "Lcom/myscript/nebo/dms/core/FolderPropertiesValidator$Status;", "folderName", "resetPageUUID", "createFolder", "color", "getFolders", "Lcom/myscript/nebo/dms/core/model/FolderModel;", SubscriberAttributeKt.JSON_NAME_KEY, "getPageKeys", "doesFolderExist", "hasCollection", "findCollectionByName", "getCollection", "createCollection", "newCollectionName", "moveCollectionToTrash", "toDeleteCollectionKey", "renameCollection", "newName", "moveToTrash", "notebookToDelete", "moveFoldersToTrash", "notebooksToDeleteKeys", "editFolder", "folderKey", "name", "newCollectionKey", "newColor", "importNeboFile", "neboFile", "addPageAtTheEnd", "pageType", "Lcom/myscript/snt/dms/PageType;", "lang", "externalFile", "importAsPdf", "attachment", "optimizePdf", "Lcom/myscript/nebo/dms/core/PdfOptimizationResult;", FirebaseAnalytics.Param.LEVEL, "Lcom/myscript/nebo/dms/core/PdfOptimizationLevel;", "addDocument", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "addBoard", "backgroundPattern", "Lcom/myscript/atk/core/BackgroundPattern;", "addPaginatedContainer", "coverColors", "paperSize", "Lcom/myscript/snt/core/PaperSize;", "getPage", "Lcom/myscript/nebo/dms/core/model/PageModel;", "getPages", "parentPageKey", "parentNotebookKey", "updateNoteName", "getPageTitle", "getPageController", "Lcom/myscript/snt/core/PageControllerSanitized;", "displayContext", "Lcom/myscript/snt/core/DisplayContext;", "recoContext", "Lcom/myscript/snt/core/RecoContext;", "optionContext", "Lcom/myscript/snt/core/SWIGOptionContext;", "save", "pageController", "Lcom/myscript/snt/core/PageController;", "temporary", "syncFolder", "dmsSyncState", "getDmsSyncState", "()Lcom/myscript/snt/dms/DMSSyncState;", "isLastSyncActionAUserAction", "isCloudSyncOngoing", "enabled", "isAutoSyncEnabled", "setAutoSyncEnabled", "hasForwardCompatibilityIssue", "getHasForwardCompatibilityIssue", "movePageToTrash", "movePagesToTrash", "pageKeys", "stopThumbnailer", "restartThumbnailer", "getPageType", "isPageCorrupted", "tagCorruptionInfoPage", "reason", "tagCorruptionWarningInfoPage", "untagCorruptedPage", "getCollectionKeyFromNotebookKey", "getNotebookKeyFromPageKey", "getPaginatedContainerKeyFromPageKey", "getPaginatedContainerFromPageKey", "quicklyGetAvailableLanguages", "isLanguageAvailable", "languageTag", "value", "lastOpenedFolderKey", "getLastOpenedFolderKey", "()Lcom/myscript/snt/core/NotebookKey;", "setLastOpenedFolderKey", "(Lcom/myscript/snt/core/NotebookKey;)V", "lastOpenedNoteKey", "getLastOpenedNoteKey", "()Lcom/myscript/snt/core/PageKey;", "setLastOpenedNoteKey", "(Lcom/myscript/snt/core/PageKey;)V", "canExport", "hasContent", "supportsExportMimeType", "mimeType", "Lcom/myscript/atk/core/MimeType;", "createExportController", "Lcom/myscript/snt/core/ExportController;", "rendererListener", "Lcom/myscript/snt/core/IRendererListener;", "typesetListener", "Lcom/myscript/atk/core/ITypesetListener;", "viewTransform", "Lcom/myscript/atk/core/ViewTransform;", "customResources", "Lcom/myscript/atk/core/CustomResource;", "exportPageAsNebo", "workDir", "getFolder", "duplicatePage", "newPosition", "createSiblingPage", "movePage", "movePages", "saveOpenedNote", "clearOpenedNote", "lastOpenedPage", "containerKey", "saveOpenedPage", "clearOpenedPage", "withDMS", "R", "action", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "<set-?>", "lastChosenLanguage", "getLastChosenLanguage", "setLastChosenLanguage", "lastChosenLanguage$delegate", "Lcom/myscript/android/utils/StringSharedPreferencesProperty;", "setCloudDriveInterface", "cloudProvider", "Lcom/myscript/snt/dms/ICloudDriveInterface;", "setSyncDegradedMode", "uploadFailureRate", "downloadFailureRate", "disableSyncDegradedMode", "clearCache", "deleteAll", "clearAllContent", "setBackgroundColor", "setBackgroundPattern", "pattern", "exportDatalog", "exportPath", "dumpV1Cloud", "outputDirPath", "requiredDiskSpaceForMigrationToV2", "migrateToV2", "migrationListener", "Lcom/myscript/snt/dms/IDMSMigrationToV2LogListener;", "progressCallback", "Lcom/myscript/atk/core/ICancelableTaskProgressCallback;", "emptyTrash", "restoreAll", "deleteCollectionPermanently", "restoreCollection", "deleteFoldersPermanently", "notebookKeys", "restoreFolders", "deletePagesPermanently", "restorePages", "buildNotebookManager", "Lcom/myscript/snt/dms/IPaginatedContainer;", "editPaginatedContainer", "currentTitle", "colors", "checkLastChosenLanguage", "installedLanguageKeys", "getPageCount", "countLegacyPages", "Provider", "CloudTokenExpirationListener", "SyncFailureReason", "SyncListener", "ModelChangedListener", "PageListener", "FolderListener", "TrashListener", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LibraryRepository implements PageManager, LibraryMigrator, CollectionsManager, ContentInitializer {
    private static final String CLOUD_OPERATIONS_FILE = "cloud_ops.log";
    private static final String LAST_CHOSEN_LANGUAGE_KEY = "pref_default_notebook_language_key";
    private static final String LAST_OPENED_FOLDER_KEY = "last_opened_notebook_new_tag";
    private static final String LAST_OPENED_NOTE_KEY = "last_opened_page_new_tag";
    private static final String LAST_OPENED_PAGE_KEY = "last_opened_child_page_new_tag";
    private static final String SEARCH_HISTORY_NAME_PREF_KEY = "search_history_name";
    private static final String TAG = "LibraryRepository";
    private static final String THUMBNAIL_DARK_EXTENSION = "-dark.png";
    private static final String THUMBNAIL_EXTENSION = ".png";
    private static final int THUMBNAIL_HEIGHT_MM = 297;
    private static final int THUMBNAIL_WIDTH_MM = 210;
    private final NeboBackupController backupController;
    private final File cacheDirectory;
    private final CloudOperationLogger cloudOperationLogger;
    private String cloudProviderName;
    private final Set<CloudTokenExpirationListener> cloudTokenExpirationListeners;
    private final CollectionPropertiesValidator collectionValidator;
    private final SWIGVectorString confPath;
    private final IDocumentConfRequester confRequester;
    private final CoroutineScope coroutinesScope;
    private final File databaseDir;
    private DegradedCloudDriveWrapper degradedCloudDriveWrapper;
    private DisplayMetrics displayMetrics;
    private final DMS dms;
    private final DocumentController documentController;
    private final File filesDirectory;
    private final Map<NotebookKey, Set<FolderListener>> folderListeners;
    private final FolderPropertiesValidator folderValidator;
    private boolean hasCloudProvider;
    private final boolean hasForwardCompatibilityIssue;
    private boolean isAutoSyncEnabled;
    private final CompletableJob job;

    /* JADX INFO: renamed from: lastChosenLanguage$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty lastChosenLanguage;
    private int lastNumberOfNotebookToSynchronize;
    private final TechnicalLogger logger;
    private final Set<ModelChangedListener> modelChangedListeners;
    private final IDMSListener onDmsUpdate;
    private final Map<PageKey, Set<PageListener>> pageListeners;
    private SyncFailureReason pendingSyncFailureReason;
    private DMSSyncState previousSyncState;
    private final File rootDir;
    private final DMSSearchController searchController;
    private final SharedPreferences sharedPreferences;
    private final Set<SyncListener> syncListeners;
    private final Thumbnailer thumbnailer;
    private final Set<TrashListener> trashListeners;
    private final File workingDirectory;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(LibraryRepository.class, "lastChosenLanguage", "getLastChosenLanguage()Ljava/lang/String;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final ViewTransform DefaultViewTransform = new ViewTransform(96.0f, 96.0f);

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$CloudTokenExpirationListener;", "", "onCloudTokenExpired", "", "onValidCloudToken", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface CloudTokenExpirationListener {
        void onCloudTokenExpired();

        void onValidCloudToken();
    }

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$FolderListener;", "", "onFolderUpdated", "", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "onFolderDeleted", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface FolderListener {
        void onFolderDeleted(NotebookKey notebookKey);

        void onFolderUpdated(NotebookKey notebookKey);
    }

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$ModelChangedListener;", "", "onCollectionsLoaded", "", "onFolderUpdated", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ModelChangedListener {
        void onCollectionsLoaded();

        void onFolderUpdated(NotebookKey notebookKey);
    }

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$PageListener;", "", "onPageUpdated", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "onPageDeleted", "onPageUUIDReset", "previousKey", "newKey", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface PageListener {
        void onPageDeleted(PageKey pageKey);

        void onPageUUIDReset(PageKey previousKey, PageKey newKey);

        void onPageUpdated(PageKey pageKey);
    }

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$Provider;", "", "provideLibraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        LibraryRepository provideLibraryRepository();
    }

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J&\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH&J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&J2\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&J2\u0010\"\u001a\u00020\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&¨\u0006$À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$TrashListener;", "", "collectionDeleted", "", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "notebooksDeleted", "", "Lcom/myscript/snt/core/NotebookKey;", "pagesDeleted", "Lcom/myscript/snt/core/PageKey;", "collectionsRenamed", "collectionKeys", "collectionsUpdated", "folderDeleted", "notebookKey", "foldersRenamed", "notebookKeys", "foldersUpdated", "folderMoved", "previousCollectionKey", "pageDeleted", "pageKey", "parentNotebookKey", "parentPageKey", "pageMoved", "previousParentNotebookKey", "previousParentPageKey", "pagesUpdated", "pageKeys", "trashed", "trashedCollectionKeys", "trashedNotebookKeys", "trashedPageKeys", "restored", "restoredCollectionKeys", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface TrashListener {
        void collectionDeleted(CollectionKey collectionKey, List<? extends NotebookKey> notebooksDeleted, List<? extends PageKey> pagesDeleted);

        void collectionsRenamed(List<? extends CollectionKey> collectionKeys);

        void collectionsUpdated(List<? extends CollectionKey> collectionKeys);

        void folderDeleted(NotebookKey notebookKey, CollectionKey collectionKey, List<? extends PageKey> pagesDeleted);

        void folderMoved(CollectionKey previousCollectionKey, NotebookKey notebookKey);

        void foldersRenamed(List<? extends NotebookKey> notebookKeys);

        void foldersUpdated(List<? extends NotebookKey> notebookKeys);

        void pageDeleted(PageKey pageKey, NotebookKey parentNotebookKey);

        void pageDeleted(PageKey pageKey, PageKey parentPageKey);

        void pageMoved(NotebookKey previousParentNotebookKey, PageKey pageKey);

        void pageMoved(PageKey previousParentPageKey, PageKey pageKey);

        void pagesUpdated(List<? extends PageKey> pageKeys);

        void restored(List<? extends CollectionKey> restoredCollectionKeys, List<? extends NotebookKey> trashedNotebookKeys, List<? extends PageKey> trashedPageKeys);

        void trashed(List<? extends CollectionKey> trashedCollectionKeys, List<? extends NotebookKey> trashedNotebookKeys, List<? extends PageKey> trashedPageKeys);
    }

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PdfOptimizationLevel.values().length];
            try {
                iArr[PdfOptimizationLevel.BEST_QUALITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PdfOptimizationLevel.BALANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PdfOptimizationLevel.BEST_PERFORMANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[com.myscript.snt.dms.PdfOptimizationResult.values().length];
            try {
                iArr2[com.myscript.snt.dms.PdfOptimizationResult.OPTIMIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[com.myscript.snt.dms.PdfOptimizationResult.ALREADY_OPTIMIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public LibraryRepository(Application application, LibraryRepositoryConfig config, ResourceManager resourceManager, UserAgent userAgent, IPageCorruptionListener corruptionListener, TechnicalLogger logger) {
        String description;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(corruptionListener, "corruptionListener");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        this.coroutinesScope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus(Dispatchers.getMain()));
        File filesDir = application.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        this.filesDirectory = filesDir;
        File cacheDir = application.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
        this.cacheDirectory = cacheDir;
        this.rootDir = config.getRootDirectory();
        this.databaseDir = config.getDatabaseDirectory();
        this.workingDirectory = config.getWorkingDirectory();
        Application application2 = application;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application2);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.sharedPreferences = defaultSharedPreferences;
        this.confPath = new SWIGVectorString();
        this.confRequester = new IDocumentConfRequester() { // from class: com.myscript.nebo.dms.core.LibraryRepository$$ExternalSyntheticLambda0
            @Override // com.myscript.snt.core.IDocumentConfRequester
            public final List confsDir() {
                return LibraryRepository.confRequester$lambda$0(this.f$0);
            }
        };
        this.folderValidator = new FolderPropertiesValidator(new Function2() { // from class: com.myscript.nebo.dms.core.LibraryRepository$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(LibraryRepository.folderValidator$lambda$0(this.f$0, (CollectionKey) obj, (String) obj2));
            }
        });
        this.collectionValidator = new CollectionPropertiesValidator();
        this.modelChangedListeners = new LinkedHashSet();
        this.syncListeners = new LinkedHashSet();
        this.folderListeners = new LinkedHashMap();
        this.pageListeners = new LinkedHashMap();
        this.trashListeners = new LinkedHashSet();
        this.previousSyncState = DMSSyncState.NONE;
        this.cloudOperationLogger = new CloudOperationLogger();
        this.pendingSyncFailureReason = SyncFailureReason.UNKNOWN;
        this.cloudTokenExpirationListeners = new LinkedHashSet();
        this.onDmsUpdate = new LibraryRepository$onDmsUpdate$1(this);
        this.isAutoSyncEnabled = config.getIsAutoSyncEnabled();
        try {
            description = userAgent.getDescription();
        } catch (Exception e) {
            this.logger.logError(e);
            description = "Unknown Android version";
        }
        DMSConfiguration dMSConfiguration = new DMSConfiguration(this.rootDir.getAbsolutePath(), this.databaseDir.getAbsolutePath(), description, this.workingDirectory.getAbsolutePath());
        dMSConfiguration.setEnableRecent(false);
        dMSConfiguration.setEnableTrash(true);
        dMSConfiguration.setEnableAutoSync(config.getIsAutoSyncEnabled());
        String strCheckDatabaseSchema = DMS.checkDatabaseSchema(dMSConfiguration);
        String str = strCheckDatabaseSchema;
        if (str != null && str.length() != 0) {
            logTrace("checkDatabaseSchema mismatch: " + strCheckDatabaseSchema);
            this.logger.logError(new RuntimeException("Db schema is wrong"));
            try {
                FilesKt.copyTo(new File(this.databaseDir, "dms.db"), new File(application.getExternalCacheDir(), "database_recovery.db"), true, 8192);
            } catch (Exception e2) {
                this.logger.logError(e2);
            }
        }
        DMS dmsCreate = DMS.create(dMSConfiguration);
        if (dmsCreate == null) {
            throw new IllegalArgumentException("DMS.create shouldn't return null".toString());
        }
        this.dms = dmsCreate;
        dmsCreate.addDMSListener(this.onDmsUpdate);
        dmsCreate.setPageCorruptionListener(corruptionListener);
        dmsCreate.setConflictRenamePattern(application.getString(C6208R.string.conflicted_page_auto_rename_pattern));
        dmsCreate.recoverLostTemporarySaves();
        dmsCreate.recoverOrphanNotebooks();
        NeboBackupController neboBackupControllerCreateBackupController = dmsCreate.createBackupController();
        Intrinsics.checkNotNullExpressionValue(neboBackupControllerCreateBackupController, "createBackupController(...)");
        this.backupController = neboBackupControllerCreateBackupController;
        neboBackupControllerCreateBackupController.setZipArchiver(new AndroidZipArchiver());
        SearchController searchController = dmsCreate.searchController();
        SharedPreferences sharedPreferences = application.getSharedPreferences(SEARCH_HISTORY_NAME_PREF_KEY, 0);
        Intrinsics.checkNotNull(searchController);
        Intrinsics.checkNotNull(sharedPreferences);
        this.searchController = new DMSSearchController(this, searchController, sharedPreferences);
        dmsCreate.setTypesetListener(new TypesetListener(ScreenUtils.getFixedDisplayMetrics(application2)));
        this.confPath.push_back("zip://" + application.getPackageCodePath() + "!/assets/conf");
        DocumentController documentController = dmsCreate.documentController();
        Intrinsics.checkNotNullExpressionValue(documentController, "documentController(...)");
        this.documentController = documentController;
        documentController.setDocumentConfRequester(this.confRequester);
        Iterator<String> it = resourceManager.getConfPaths().iterator();
        while (it.hasNext()) {
            this.confPath.push_back(it.next());
        }
        this.dms.setConfsDir(this.confPath);
        this.dms.setThumbnailConfiguration(210.0f, 297.0f, ".png", new IdentityColorInversionPolicy());
        Thumbnailer thumbnailer = this.dms.thumbnailer();
        Intrinsics.checkNotNullExpressionValue(thumbnailer, "thumbnailer(...)");
        this.thumbnailer = thumbnailer;
        this.lastChosenLanguage = SharedPreferencesExtKt.stringPref(this.sharedPreferences, LAST_CHOSEN_LANGUAGE_KEY, "en_US");
    }

    public final SyncHelper syncHelper() {
        return new SyncHelper() { // from class: com.myscript.nebo.dms.core.LibraryRepository.syncHelper.1
            @Override // com.myscript.nebo.dms.core.SyncHelper
            public void triggerRefresh() {
                if (LibraryRepository.this.dms.isCloudEnabled()) {
                    LibraryRepository.this.dms.refreshSyncState();
                }
            }

            @Override // com.myscript.nebo.dms.core.SyncHelper
            public void triggerSync(boolean userAction) {
                if (LibraryRepository.this.dms.isCloudEnabled()) {
                    LibraryRepository.this.dms.syncAllNotebooks(userAction);
                }
            }

            @Override // com.myscript.nebo.dms.core.SyncHelper
            public boolean hasLocalSyncUpdate() {
                return LibraryRepository.this.dms.hasLocalSyncUpdate();
            }

            @Override // com.myscript.nebo.dms.core.SyncHelper
            public boolean hasMultiEditor(long delayMicroseconds) {
                return LibraryRepository.this.dms.hasMultiEditor(delayMicroseconds);
            }

            @Override // com.myscript.nebo.dms.core.SyncHelper
            public boolean isAutoSyncEnabled() {
                return LibraryRepository.this.getIsAutoSyncEnabled();
            }

            @Override // com.myscript.nebo.dms.core.SyncHelper
            public void cancelSync() {
                LibraryRepository.this.dms.cancelSync();
            }

            @Override // com.myscript.nebo.dms.core.SyncHelper
            public void cancelSync(NotebookKey notebookKey) {
                Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
                LibraryRepository.this.dms.cancelNotebookSync(notebookKey);
            }

            @Override // com.myscript.nebo.dms.core.SyncHelper
            public void resumeSync() {
                LibraryRepository.this.dms.resumeSync();
            }
        };
    }

    public final File getRootDir() {
        return this.rootDir;
    }

    public final File getDatabaseDir() {
        return this.databaseDir;
    }

    public final File getWorkingDirectory() {
        return this.workingDirectory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List confRequester$lambda$0(LibraryRepository libraryRepository) {
        return libraryRepository.confPath;
    }

    public final NeboBackupController getBackupController() {
        return this.backupController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean folderValidator$lambda$0(LibraryRepository libraryRepository, CollectionKey collectionKey, String folderName) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        return libraryRepository.doesFolderExist(collectionKey, folderName);
    }

    public final DisplayMetrics getDisplayMetrics() {
        return this.displayMetrics;
    }

    public final void setDisplayMetrics(DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
    }

    public final boolean getHasCloudProvider() {
        return this.hasCloudProvider;
    }

    public final void setHasCloudProvider(boolean z) {
        this.hasCloudProvider = z;
    }

    public final String getCloudProviderName() {
        return this.cloudProviderName;
    }

    public final void setCloudProviderName(String str) {
        this.cloudProviderName = str;
    }

    public final CloudOperationLogger getCloudOperationLogger() {
        return this.cloudOperationLogger;
    }

    public final void notifyCloudStorageFull() {
        this.pendingSyncFailureReason = SyncFailureReason.INSUFFICIENT_STORAGE;
    }

    public final void addCloudTokenExpirationListener(CloudTokenExpirationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cloudTokenExpirationListeners.add(listener);
    }

    public final void removeCloudTokenExpirationListener(CloudTokenExpirationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.cloudTokenExpirationListeners.remove(listener);
    }

    public final void notifyCloudTokenExpired() {
        Iterator<T> it = this.cloudTokenExpirationListeners.iterator();
        while (it.hasNext()) {
            ((CloudTokenExpirationListener) it.next()).onCloudTokenExpired();
        }
    }

    public final void notifyValidCloudToken() {
        Iterator<T> it = this.cloudTokenExpirationListeners.iterator();
        while (it.hasNext()) {
            ((CloudTokenExpirationListener) it.next()).onValidCloudToken();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$SyncFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "INSUFFICIENT_STORAGE", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SyncFailureReason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SyncFailureReason[] $VALUES;
        public static final SyncFailureReason UNKNOWN = new SyncFailureReason("UNKNOWN", 0);
        public static final SyncFailureReason INSUFFICIENT_STORAGE = new SyncFailureReason("INSUFFICIENT_STORAGE", 1);

        private static final /* synthetic */ SyncFailureReason[] $values() {
            return new SyncFailureReason[]{UNKNOWN, INSUFFICIENT_STORAGE};
        }

        public static EnumEntries<SyncFailureReason> getEntries() {
            return $ENTRIES;
        }

        public static SyncFailureReason valueOf(String str) {
            return (SyncFailureReason) Enum.valueOf(SyncFailureReason.class, str);
        }

        public static SyncFailureReason[] values() {
            return (SyncFailureReason[]) $VALUES.clone();
        }

        private SyncFailureReason(String str, int i) {
        }

        static {
            SyncFailureReason[] syncFailureReasonArr$values = $values();
            $VALUES = syncFailureReasonArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(syncFailureReasonArr$values);
        }
    }

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH&J\"\u0010\u000f\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\u0003H&¨\u0006\u0017À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$SyncListener;", "", "conflictedPageCopies", "", "duplicatedPageKeys", "", "Lcom/myscript/snt/core/PageKey;", "duplicatedPageKeys2s", "syncStateChanged", "state", "Lcom/myscript/snt/dms/DMSSyncState;", "impactedFolderCount", "", "failureReason", "Lcom/myscript/nebo/dms/core/LibraryRepository$SyncFailureReason;", "syncProgress", "amountDone", "totalAmount", "syncPrepareProgress", "folderSyncing", "Lcom/myscript/snt/core/NotebookKey;", "refreshProgress", "autoSyncSettingChanged", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface SyncListener {
        void autoSyncSettingChanged();

        void conflictedPageCopies(List<? extends PageKey> duplicatedPageKeys, List<? extends PageKey> duplicatedPageKeys2s);

        void refreshProgress(int amountDone, int totalAmount);

        void syncPrepareProgress(int amountDone, int totalAmount);

        void syncProgress(int amountDone, int totalAmount);

        void syncProgress(NotebookKey folderSyncing, int amountDone, int totalAmount);

        void syncStateChanged(DMSSyncState state, int impactedFolderCount, SyncFailureReason failureReason);

        /* JADX INFO: compiled from: LibraryRepository.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class DefaultImpls {
        }

        static /* synthetic */ void syncStateChanged$default(SyncListener syncListener, DMSSyncState dMSSyncState, int i, SyncFailureReason syncFailureReason, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncStateChanged");
            }
            if ((i2 & 4) != 0) {
                syncFailureReason = SyncFailureReason.UNKNOWN;
            }
            syncListener.syncStateChanged(dMSSyncState, i, syncFailureReason);
        }
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void addPageListener(PageKey pageKey, PageListener pageListener) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(pageListener, "pageListener");
        synchronized (this.pageListeners) {
            LinkedHashSet linkedHashSetRemove = this.pageListeners.remove(pageKey);
            if (linkedHashSetRemove == null) {
                linkedHashSetRemove = new LinkedHashSet();
            }
            linkedHashSetRemove.add(pageListener);
            this.pageListeners.put(pageKey, linkedHashSetRemove);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void removePageListener(PageKey pageKey, PageListener pageListener) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(pageListener, "pageListener");
        synchronized (this.pageListeners) {
            Set<PageListener> setRemove = this.pageListeners.remove(pageKey);
            if (setRemove != null && setRemove.remove(pageListener)) {
                this.pageListeners.put(pageKey, setRemove);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPageUpdated(PageKey pageKey) {
        synchronized (this.pageListeners) {
            Set<PageListener> set = this.pageListeners.get(pageKey);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((PageListener) it.next()).onPageUpdated(pageKey);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPageRemoved(PageKey pageKey) {
        synchronized (this.pageListeners) {
            Set<PageListener> set = this.pageListeners.get(pageKey);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((PageListener) it.next()).onPageDeleted(pageKey);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPageUUIDReset(PageKey previousKey, PageKey newKey) {
        synchronized (this.pageListeners) {
            Set<PageListener> set = this.pageListeners.get(previousKey);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((PageListener) it.next()).onPageUUIDReset(previousKey, newKey);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void addFolderListener(NotebookKey notebookKey, FolderListener folderListener) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(folderListener, "folderListener");
        synchronized (this.folderListeners) {
            LinkedHashSet linkedHashSetRemove = this.folderListeners.remove(notebookKey);
            if (linkedHashSetRemove == null) {
                linkedHashSetRemove = new LinkedHashSet();
            }
            linkedHashSetRemove.add(folderListener);
            this.folderListeners.put(notebookKey, linkedHashSetRemove);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void removeFolderListener(NotebookKey notebookKey, FolderListener folderListener) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(folderListener, "folderListener");
        synchronized (this.folderListeners) {
            Set<FolderListener> setRemove = this.folderListeners.remove(notebookKey);
            if (setRemove != null && setRemove.remove(folderListener)) {
                this.folderListeners.put(notebookKey, setRemove);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyFolderUpdated(NotebookKey notebookKey) {
        synchronized (this.folderListeners) {
            Set<FolderListener> set = this.folderListeners.get(notebookKey);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((FolderListener) it.next()).onFolderUpdated(notebookKey);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        synchronized (this.modelChangedListeners) {
            Iterator<T> it2 = this.modelChangedListeners.iterator();
            while (it2.hasNext()) {
                ((ModelChangedListener) it2.next()).onFolderUpdated(notebookKey);
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyFolderRemoved(NotebookKey notebookKey) {
        synchronized (this.folderListeners) {
            Set<FolderListener> set = this.folderListeners.get(notebookKey);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((FolderListener) it.next()).onFolderDeleted(notebookKey);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySyncState(DMSSyncState syncState, int notebooksToSync, boolean userAction) {
        SyncFailureReason syncFailureReason;
        if (syncState == DMSSyncState.SYNC_FAILED) {
            syncFailureReason = this.pendingSyncFailureReason;
        } else {
            syncFailureReason = SyncFailureReason.UNKNOWN;
        }
        if (syncState == DMSSyncState.SYNCING || syncState == DMSSyncState.REFRESHING) {
            this.pendingSyncFailureReason = SyncFailureReason.UNKNOWN;
        }
        synchronized (this.syncListeners) {
            Iterator<T> it = this.syncListeners.iterator();
            while (it.hasNext()) {
                ((SyncListener) it.next()).syncStateChanged(syncState, notebooksToSync, syncFailureReason);
            }
            Unit unit = Unit.INSTANCE;
        }
        MainThreadBus.eventBus.post(new OnDMSSyncStateChangedEvent(syncState, notebooksToSync, userAction));
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void addTrashListener(TrashListener trashListener) {
        Intrinsics.checkNotNullParameter(trashListener, "trashListener");
        synchronized (this.trashListeners) {
            this.trashListeners.add(trashListener);
        }
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void removeTrashListener(TrashListener trashListener) {
        Intrinsics.checkNotNullParameter(trashListener, "trashListener");
        synchronized (this.trashListeners) {
            this.trashListeners.remove(trashListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyTrash(Function1<? super TrashListener, Unit> notification) {
        synchronized (this.trashListeners) {
            Iterator<T> it = this.trashListeners.iterator();
            while (it.hasNext()) {
                notification.invoke((TrashListener) it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyUpdate() {
        synchronized (this.modelChangedListeners) {
            Iterator<T> it = this.modelChangedListeners.iterator();
            while (it.hasNext()) {
                ((ModelChangedListener) it.next()).onCollectionsLoaded();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final File getCloudOperations() {
        File file = new File(this.filesDirectory, CLOUD_OPERATIONS_FILE);
        File file2 = new File(this.cacheDirectory, CLOUD_OPERATIONS_FILE);
        if (file.exists()) {
            try {
                Files.move(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
                return file2;
            } catch (IOException unused) {
                return null;
            }
        }
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private final void logTrace(String message, CollectionKey collectionKey) {
        logTrace(message + " " + (collectionKey != null ? collectionKey.uuid() : null));
    }

    private final void logTrace(String message, NotebookKey notebookKey) {
        logTrace(message + " " + (notebookKey != null ? notebookKey.uuid() : null));
    }

    private final void logTrace(String message, PageKey pageKey) {
        logTrace(message + " " + (pageKey != null ? pageKey.uuid() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logTrace(String message) {
        this.logger.logTrace("[LibraryRepository] " + message);
    }

    public final DMSSearchController getSearchController() {
        return this.searchController;
    }

    public final void setThumbnailImageRequester(IThumbnailerImageRequester thumbnailImageProvider) {
        this.thumbnailer.setThumbnailImageResquester(thumbnailImageProvider);
    }

    public final void updateColorPolicy(IColorInversionPolicy colorPolicy, boolean isDarkMode) {
        Intrinsics.checkNotNullParameter(colorPolicy, "colorPolicy");
        this.dms.setThumbnailConfiguration(210.0f, 297.0f, isDarkMode ? THUMBNAIL_DARK_EXTENSION : ".png", colorPolicy);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void createThumbnail(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        DisplayMetrics displayMetrics = this.displayMetrics;
        if (displayMetrics != null) {
            logTrace("requestThumbnail", pageKey);
            this.dms.createThumbnail(pageKey, displayMetrics.xdpi, displayMetrics.ydpi);
        }
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public String getThumbnailPath(PageKey pageKey, long lastModificationDate) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        String strThumbnailPath = this.dms.thumbnailPath(pageKey, lastModificationDate);
        Intrinsics.checkNotNullExpressionValue(strThumbnailPath, "thumbnailPath(...)");
        return strThumbnailPath;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void addThumbnailListener(IThumbnailerNotificationListener thumbnailListener) {
        Intrinsics.checkNotNullParameter(thumbnailListener, "thumbnailListener");
        this.dms.addThumbnailNotificationListener(thumbnailListener);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void removeThumbnailListener(IThumbnailerNotificationListener thumbnailListener) {
        Intrinsics.checkNotNullParameter(thumbnailListener, "thumbnailListener");
        this.dms.removeThumbnailNotificationListener(thumbnailListener);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public boolean isSamplePage(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        return this.dms.isSamplePage(pageKey);
    }

    public final void setPublicAuthorId(String publicAuthorId) {
        Intrinsics.checkNotNullParameter(publicAuthorId, "publicAuthorId");
        this.documentController.setPublicAuthorId(publicAuthorId);
    }

    public final void addModelChangedListener(ModelChangedListener modelChangedListener) {
        Intrinsics.checkNotNullParameter(modelChangedListener, "modelChangedListener");
        synchronized (this.modelChangedListeners) {
            this.modelChangedListeners.add(modelChangedListener);
        }
    }

    public final void removeModelChangedListener(ModelChangedListener modelChangedListener) {
        Intrinsics.checkNotNullParameter(modelChangedListener, "modelChangedListener");
        synchronized (this.modelChangedListeners) {
            this.modelChangedListeners.remove(modelChangedListener);
        }
    }

    public final void addSyncListener(SyncListener syncListener) {
        Intrinsics.checkNotNullParameter(syncListener, "syncListener");
        synchronized (this.syncListeners) {
            this.syncListeners.add(syncListener);
        }
    }

    public final void removeSyncListener(SyncListener syncListener) {
        Intrinsics.checkNotNullParameter(syncListener, "syncListener");
        synchronized (this.syncListeners) {
            this.syncListeners.remove(syncListener);
        }
    }

    @Override // com.myscript.nebo.dms.core.CollectionsManager
    public List<CollectionModel> getCollectionModels(DMSFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        boolean z = filter == DMSFilter.TRASH;
        List<Collection> listCollections = this.dms.collections(filter);
        Intrinsics.checkNotNullExpressionValue(listCollections, "collections(...)");
        List<Collection> list = listCollections;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Collection collection : list) {
            Intrinsics.checkNotNull(collection);
            CollectionKey key = collection.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "getKey(...)");
            arrayList.add(new CollectionModel(collection, getFolders(key, filter), z));
        }
        return CollectionsKt.sorted(arrayList);
    }

    public final boolean isEmpty() {
        return this.dms.collections().isEmpty();
    }

    public final void waitForIdle() {
        this.thumbnailer.stop();
        this.dms.waitForPendingSaves();
        this.dms.waitForOngoingSync();
        this.thumbnailer.restart();
    }

    public final CollectionPropertiesValidator.Status validateCollection(String collectionName) {
        Intrinsics.checkNotNullParameter(collectionName, "collectionName");
        return this.collectionValidator.validate(collectionName);
    }

    public final FolderPropertiesValidator.Status validateFolder(CollectionKey collectionKey, String folderName) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        return this.folderValidator.validate(collectionKey, folderName);
    }

    public final void resetPageUUID(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        this.dms.resetPageUUID(pageKey);
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public NotebookKey createFolder(CollectionKey collectionKey, String folderName, int color) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        FolderPropertiesValidator.Status statusValidateFolder = validateFolder(collectionKey, folderName);
        NotebookKey notebookKeyCreateFolder = statusValidateFolder instanceof FolderPropertiesValidator.Status.Valid ? this.dms.createFolder(collectionKey, ((FolderPropertiesValidator.Status.Valid) statusValidateFolder).getFolderName(), color) : null;
        logTrace("createFolder", notebookKeyCreateFolder);
        if (notebookKeyCreateFolder == null || !notebookKeyCreateFolder.isValid()) {
            return null;
        }
        return notebookKeyCreateFolder;
    }

    private final List<FolderModel> getFolders(CollectionKey key) {
        return getFolders(key, DMSFilter.ACTIVE);
    }

    private final List<FolderModel> getFolders(CollectionKey collectionKey, DMSFilter filter) {
        int i;
        boolean z = filter == DMSFilter.TRASH;
        List<Notebook> listNotebooks = this.dms.notebooks(collectionKey, filter);
        Intrinsics.checkNotNullExpressionValue(listNotebooks, "notebooks(...)");
        List<Notebook> list = listNotebooks;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Notebook notebook : list) {
            List<Page> listPages = this.dms.pages(notebook.getKey(), DMSFilter.ALL);
            Intrinsics.checkNotNull(listPages);
            List<Page> list2 = listPages;
            if ((list2 instanceof java.util.Collection) && list2.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = list2.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((Page) it.next()).isTrashed() && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i = i2;
            }
            int size = listPages.size() - i;
            FolderModel.Companion companion = FolderModel.INSTANCE;
            Intrinsics.checkNotNull(notebook);
            arrayList.add(companion.fromNotebook(notebook, this.isAutoSyncEnabled, z, i, size));
        }
        return arrayList;
    }

    public final List<PageKey> getPageKeys(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        List<Page> listPages = this.dms.pages(notebookKey);
        Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
        List<Page> list = listPages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Page) it.next()).getKey());
        }
        return arrayList;
    }

    public final boolean doesFolderExist(CollectionKey collectionKey, String folderName) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        return this.dms.lookupNotebookByName(collectionKey, folderName) != null;
    }

    public final boolean hasCollection(String collectionName) {
        Intrinsics.checkNotNullParameter(collectionName, "collectionName");
        return findCollectionByName(collectionName) != null;
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public CollectionKey findCollectionByName(String collectionName) {
        Intrinsics.checkNotNullParameter(collectionName, "collectionName");
        Collection collectionLookupCollectionByName = this.dms.lookupCollectionByName(collectionName);
        if (collectionLookupCollectionByName != null) {
            return collectionLookupCollectionByName.getKey();
        }
        return null;
    }

    public final CollectionModel getCollection(CollectionKey collectionKey) {
        Collection collectionCollectionForCollectionKey;
        if (collectionKey == null || (collectionCollectionForCollectionKey = this.dms.collectionForCollectionKey(collectionKey)) == null) {
            return null;
        }
        CollectionKey key = collectionCollectionForCollectionKey.getKey();
        Intrinsics.checkNotNullExpressionValue(key, "getKey(...)");
        return new CollectionModel(collectionCollectionForCollectionKey, getFolders(key), false, 4, null);
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public CollectionKey createCollection(String newCollectionName) {
        Intrinsics.checkNotNullParameter(newCollectionName, "newCollectionName");
        CollectionPropertiesValidator.Status statusValidateCollection = validateCollection(newCollectionName);
        if (statusValidateCollection instanceof CollectionPropertiesValidator.Status.Valid) {
            CollectionKey collectionKeyCreateCollection = this.dms.createCollection(((CollectionPropertiesValidator.Status.Valid) statusValidateCollection).getCollectionName());
            logTrace("createCollection", collectionKeyCreateCollection);
            if (collectionKeyCreateCollection != null && collectionKeyCreateCollection.isValid()) {
                return collectionKeyCreateCollection;
            }
        }
        return null;
    }

    public final void moveCollectionToTrash(CollectionKey toDeleteCollectionKey) {
        Intrinsics.checkNotNullParameter(toDeleteCollectionKey, "toDeleteCollectionKey");
        logTrace("moveCollectionToTrash", toDeleteCollectionKey);
        this.dms.moveCollectionsToTrash(CollectionsKt.listOf(toDeleteCollectionKey));
    }

    public final boolean renameCollection(CollectionKey collectionKey, String newName) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        Intrinsics.checkNotNullParameter(newName, "newName");
        CollectionPropertiesValidator.Status statusValidateCollection = validateCollection(newName);
        if (!(statusValidateCollection instanceof CollectionPropertiesValidator.Status.Valid)) {
            return false;
        }
        return this.dms.renameCollection(collectionKey, ((CollectionPropertiesValidator.Status.Valid) statusValidateCollection).getCollectionName());
    }

    public final void moveToTrash(NotebookKey notebookToDelete) {
        Intrinsics.checkNotNullParameter(notebookToDelete, "notebookToDelete");
        moveFoldersToTrash(CollectionsKt.listOf(notebookToDelete));
    }

    public final void moveFoldersToTrash(List<? extends NotebookKey> notebooksToDeleteKeys) {
        Intrinsics.checkNotNullParameter(notebooksToDeleteKeys, "notebooksToDeleteKeys");
        String string = Arrays.toString(notebooksToDeleteKeys.toArray(new NotebookKey[0]));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        logTrace("deleteFolders " + string);
        this.dms.moveNotebooksToTrash(notebooksToDeleteKeys);
    }

    public final void editFolder(NotebookKey folderKey, String name, CollectionKey newCollectionKey, int newColor) {
        FolderPropertiesValidator.Status.Valid validValidateFolder;
        Intrinsics.checkNotNullParameter(folderKey, "folderKey");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(newCollectionKey, "newCollectionKey");
        Notebook notebookNotebookFromKey = this.dms.notebookFromKey(folderKey);
        if (notebookNotebookFromKey != null) {
            boolean zAreEqual = Intrinsics.areEqual(newCollectionKey, getCollectionKeyFromNotebookKey(folderKey));
            boolean zAreEqual2 = Intrinsics.areEqual(name, notebookNotebookFromKey.getName());
            if (!zAreEqual || !zAreEqual2) {
                validValidateFolder = validateFolder(newCollectionKey, name);
            } else {
                validValidateFolder = new FolderPropertiesValidator.Status.Valid(name);
            }
            if (validValidateFolder instanceof FolderPropertiesValidator.Status.Valid) {
                logTrace("editFolder", folderKey);
                String folderName = ((FolderPropertiesValidator.Status.Valid) validValidateFolder).getFolderName();
                if (notebookNotebookFromKey.getCoverColor2() != newColor) {
                    this.dms.updateFolderCoverColor(folderKey, newColor);
                }
                if (!zAreEqual) {
                    this.dms.moveNotebook(folderKey, newCollectionKey);
                }
                if (zAreEqual2) {
                    return;
                }
                this.dms.renameNotebook(folderKey, folderName);
            }
        }
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public List<PageKey> importNeboFile(File neboFile, NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(neboFile, "neboFile");
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        logTrace("importNeboFile '" + neboFile + "'", notebookKey);
        List<PageKey> listImportPages = this.dms.importPages(neboFile.getAbsolutePath(), notebookKey);
        Intrinsics.checkNotNullExpressionValue(listImportPages, "importPages(...)");
        return listImportPages;
    }

    private final PageKey addPageAtTheEnd(NotebookKey notebookKey, PageType pageType, String lang, File externalFile) {
        String absolutePath;
        String extension;
        if (externalFile == null || (absolutePath = externalFile.getAbsolutePath()) == null) {
            absolutePath = "";
        }
        PageKey pageKeyCreatePage = this.dms.createPage(notebookKey, lang, -1, pageType, absolutePath);
        if (externalFile == null || (extension = FilesKt.getExtension(externalFile)) == null) {
            extension = "∅";
        }
        logTrace("createPage(" + pageType + ") with attachment? " + extension, pageKeyCreatePage);
        if (pageKeyCreatePage != null) {
            if (!pageKeyCreatePage.isValid()) {
                pageKeyCreatePage = null;
            }
            if (pageKeyCreatePage != null) {
                setLastChosenLanguage(lang);
                return pageKeyCreatePage;
            }
        }
        return null;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageKey importAsPdf(NotebookKey notebookKey, File attachment, String lang) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        Intrinsics.checkNotNullParameter(lang, "lang");
        return addPageAtTheEnd(notebookKey, PageType.PDF, lang, attachment);
    }

    public final PdfOptimizationResult optimizePdf(PageKey pageKey, PdfOptimizationLevel level) {
        com.myscript.snt.dms.PdfOptimizationLevel pdfOptimizationLevel;
        com.myscript.snt.dms.PdfOptimizationResult pdfOptimizationResultOptimizePageAttachment;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(level, "level");
        logTrace("optimizePdf(level=" + level + ")", pageKey);
        int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i == 1) {
            pdfOptimizationLevel = com.myscript.snt.dms.PdfOptimizationLevel.BEST_QUALITY;
        } else if (i == 2) {
            pdfOptimizationLevel = com.myscript.snt.dms.PdfOptimizationLevel.BALANCED;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            pdfOptimizationLevel = com.myscript.snt.dms.PdfOptimizationLevel.BEST_PERFORMANCE;
        }
        try {
            pdfOptimizationResultOptimizePageAttachment = this.dms.optimizePageAttachment(pageKey, pdfOptimizationLevel);
        } catch (Exception e) {
            this.logger.logError(e);
            pdfOptimizationResultOptimizePageAttachment = null;
        }
        int i2 = pdfOptimizationResultOptimizePageAttachment == null ? -1 : WhenMappings.$EnumSwitchMapping$1[pdfOptimizationResultOptimizePageAttachment.ordinal()];
        if (i2 == 1) {
            return PdfOptimizationResult.OPTIMIZED;
        }
        if (i2 == 2) {
            return PdfOptimizationResult.ALREADY_OPTIMIZED;
        }
        return PdfOptimizationResult.FAILED;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageKey addDocument(NotebookKey notebookKey, String name, String lang, int backgroundColor) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lang, "lang");
        PageKey pageKeyAddPageAtTheEnd = addPageAtTheEnd(notebookKey, PageType.TextDocument, lang, null);
        if (pageKeyAddPageAtTheEnd == null) {
            return null;
        }
        String str = name;
        if (!StringsKt.isBlank(str)) {
            this.dms.updatePageTitle(pageKeyAddPageAtTheEnd, NameUtils.normalizeSpaces(str));
        }
        this.dms.setBackgroundColor(pageKeyAddPageAtTheEnd, ColorExt.getOpaque(backgroundColor));
        return pageKeyAddPageAtTheEnd;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageKey addBoard(NotebookKey notebookKey, String name, String lang, int backgroundColor, BackgroundPattern backgroundPattern) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(backgroundPattern, "backgroundPattern");
        PageKey pageKeyAddPageAtTheEnd = addPageAtTheEnd(notebookKey, PageType.RawContent, lang, null);
        if (pageKeyAddPageAtTheEnd == null) {
            return null;
        }
        String str = name;
        if (!StringsKt.isBlank(str)) {
            this.dms.updatePageTitle(pageKeyAddPageAtTheEnd, NameUtils.normalizeSpaces(str));
        }
        this.dms.setBackgroundColor(pageKeyAddPageAtTheEnd, ColorExt.getOpaque(backgroundColor));
        this.dms.setBackgroundPattern(pageKeyAddPageAtTheEnd, BackgroundPatternExt.toString(backgroundPattern));
        return pageKeyAddPageAtTheEnd;
    }

    @Override // com.myscript.nebo.dms.core.PageManager, com.myscript.nebo.dms.core.ContentInitializer
    public PageKey addPaginatedContainer(NotebookKey notebookKey, String name, String lang, List<Integer> coverColors, PaperSize paperSize, int backgroundColor, BackgroundPattern backgroundPattern) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(coverColors, "coverColors");
        Intrinsics.checkNotNullParameter(paperSize, "paperSize");
        Intrinsics.checkNotNullParameter(backgroundPattern, "backgroundPattern");
        logTrace("addPaginatedContainer", notebookKey);
        PageKey pageKeyCreateFixedPageSizeContainer2 = this.dms.createFixedPageSizeContainer2(notebookKey, lang, NameUtils.normalizeSpaces(name), coverColors, paperSize.getWidth(), paperSize.getHeight(), ColorExt.getOpaque(backgroundColor), BackgroundPatternExt.toString(backgroundPattern));
        if (pageKeyCreateFixedPageSizeContainer2 != null) {
            if (!pageKeyCreateFixedPageSizeContainer2.isValid()) {
                pageKeyCreateFixedPageSizeContainer2 = null;
            }
            if (pageKeyCreateFixedPageSizeContainer2 != null) {
                setLastChosenLanguage(lang);
                return pageKeyCreateFixedPageSizeContainer2;
            }
        }
        return null;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageModel getPage(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Page pagePageFromKey = this.dms.pageFromKey(pageKey);
        if (pagePageFromKey != null) {
            return PageModel.INSTANCE.fromPage(pagePageFromKey);
        }
        return null;
    }

    public final List<PageModel> getPages(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        return getPages(notebookKey, DMSFilter.ACTIVE);
    }

    public final List<PageModel> getPages(PageKey parentPageKey) {
        Intrinsics.checkNotNullParameter(parentPageKey, "parentPageKey");
        return getPages(parentPageKey, DMSFilter.ALL);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public List<PageModel> getPages(NotebookKey parentNotebookKey, DMSFilter filter) {
        Intrinsics.checkNotNullParameter(parentNotebookKey, "parentNotebookKey");
        Intrinsics.checkNotNullParameter(filter, "filter");
        List<Page> listPages = this.dms.pages(parentNotebookKey, filter);
        Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
        List<Page> list = listPages;
        PageModel.Companion companion = PageModel.INSTANCE;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(companion.fromPage((Page) it.next()));
        }
        return arrayList;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public List<PageModel> getPages(PageKey parentPageKey, DMSFilter filter) {
        Intrinsics.checkNotNullParameter(parentPageKey, "parentPageKey");
        Intrinsics.checkNotNullParameter(filter, "filter");
        List<Page> listPages = this.dms.pages(parentPageKey, filter);
        Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
        List<Page> list = listPages;
        PageModel.Companion companion = PageModel.INSTANCE;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(companion.fromPage((Page) it.next()));
        }
        return arrayList;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void updateNoteName(PageKey pageKey, String newName) {
        PageKey key;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(newName, "newName");
        logTrace("updateNoteName", pageKey);
        Page pageContainerFromPageKey = this.dms.containerFromPageKey(pageKey);
        if (pageContainerFromPageKey != null && (key = pageContainerFromPageKey.getKey()) != null) {
            pageKey = key;
        }
        this.dms.updatePageTitle(pageKey, newName);
    }

    public final String getPageTitle(PageKey pageKey) {
        Page pagePageFromKey = this.dms.pageFromKey(pageKey);
        if (pagePageFromKey != null) {
            return pagePageFromKey.getTitle();
        }
        return null;
    }

    public final PageControllerSanitized getPageController(PageKey pageKey, DisplayContext displayContext, RecoContext recoContext, SWIGOptionContext optionContext) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(displayContext, "displayContext");
        Intrinsics.checkNotNullParameter(recoContext, "recoContext");
        Intrinsics.checkNotNullParameter(optionContext, "optionContext");
        PageControllerSanitized pageControllerSanitizedOpen2 = this.dms.open2(pageKey, displayContext, recoContext, optionContext);
        Intrinsics.checkNotNullExpressionValue(pageControllerSanitizedOpen2, "open2(...)");
        return pageControllerSanitizedOpen2;
    }

    public final void save(PageKey pageKey, PageController pageController, boolean temporary) {
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.dms.save(pageController, temporary);
        logTrace("saved (temporary? " + temporary + "), took " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms", pageKey);
    }

    public final void syncFolder(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        logTrace("syncFolder", notebookKey);
        this.dms.syncNotebook(notebookKey);
    }

    public final DMSSyncState getDmsSyncState() {
        DMSSyncState dMSSyncStateSyncState = this.dms.syncState();
        Intrinsics.checkNotNullExpressionValue(dMSSyncStateSyncState, "syncState(...)");
        return dMSSyncStateSyncState;
    }

    public final boolean isLastSyncActionAUserAction() {
        return this.dms.isLastSyncActionAUserAction();
    }

    public final boolean isCloudSyncOngoing() {
        return getDmsSyncState() == DMSSyncState.SYNCING;
    }

    /* JADX INFO: renamed from: isAutoSyncEnabled, reason: from getter */
    public final boolean getIsAutoSyncEnabled() {
        return this.isAutoSyncEnabled;
    }

    public final void setAutoSyncEnabled(boolean z) {
        if (this.isAutoSyncEnabled != z) {
            this.isAutoSyncEnabled = z;
            synchronized (this.syncListeners) {
                Iterator<T> it = this.syncListeners.iterator();
                while (it.hasNext()) {
                    ((SyncListener) it.next()).autoSyncSettingChanged();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean getHasForwardCompatibilityIssue() {
        return this.hasForwardCompatibilityIssue;
    }

    public final void movePageToTrash(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        movePagesToTrash(CollectionsKt.listOf(pageKey));
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void movePagesToTrash(List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        ArrayList arrayList = new ArrayList(pageKeys.size());
        arrayList.addAll(pageKeys);
        logTrace("movePagesToTrash " + arrayList.size());
        this.dms.movePagesToTrash(arrayList);
    }

    public final void stopThumbnailer() {
        this.thumbnailer.stop();
    }

    public final void restartThumbnailer() {
        this.thumbnailer.restart();
    }

    public final PageType getPageType(PageKey pageKey) {
        Page pagePageFromKey;
        if (pageKey == null || (pagePageFromKey = this.dms.pageFromKey(pageKey)) == null) {
            return null;
        }
        return pagePageFromKey.getType();
    }

    public final boolean isPageCorrupted(PageKey pageKey) {
        if (pageKey == null) {
            return false;
        }
        Page pagePageFromKey = this.dms.pageFromKey(pageKey);
        Boolean boolValueOf = pagePageFromKey != null ? Boolean.valueOf(pagePageFromKey.isCorrupted()) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    public final boolean tagCorruptionInfoPage(PageKey pageKey, String reason, String message) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(message, "message");
        DMS dms = this.dms;
        NeboSanitizer.SanitizerResult sanitizerResult = new NeboSanitizer.SanitizerResult();
        sanitizerResult.setStatus(NeboSanitizer.SanitizerStatus.Corrupted);
        sanitizerResult.setSource(DMS.getATTR_CORRUPTION_SOURCE_APP());
        sanitizerResult.setReason(reason);
        sanitizerResult.setMessage(message);
        Unit unit = Unit.INSTANCE;
        return dms.tagCorruptionInfoPage(pageKey, sanitizerResult);
    }

    public final boolean tagCorruptionWarningInfoPage(PageKey pageKey, String reason, String message) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(message, "message");
        return this.dms.tagCorruptionWarningInfoPage(pageKey, DMS.getATTR_CORRUPTION_SOURCE_APP(), reason, message);
    }

    public final boolean untagCorruptedPage(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        return this.dms.untagCorruptedPage(pageKey);
    }

    public final CollectionKey getCollectionKeyFromNotebookKey(NotebookKey notebookKey) {
        Collection collectionCollectionFromNotebookKey;
        if (notebookKey == null || (collectionCollectionFromNotebookKey = this.dms.collectionFromNotebookKey(notebookKey)) == null) {
            return null;
        }
        return collectionCollectionFromNotebookKey.getKey();
    }

    public final NotebookKey getNotebookKeyFromPageKey(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Notebook notebookNotebookFromPageKey = this.dms.notebookFromPageKey(pageKey);
        if (notebookNotebookFromPageKey != null) {
            return notebookNotebookFromPageKey.getKey();
        }
        return null;
    }

    public final PageKey getPaginatedContainerKeyFromPageKey(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Page pageContainerFromPageKey = this.dms.containerFromPageKey(pageKey);
        if (pageContainerFromPageKey != null) {
            if (!pageContainerFromPageKey.isContainer()) {
                pageContainerFromPageKey = null;
            }
            if (pageContainerFromPageKey != null) {
                return pageContainerFromPageKey.getKey();
            }
        }
        return null;
    }

    public final PageModel getPaginatedContainerFromPageKey(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Page pageContainerFromPageKey = this.dms.containerFromPageKey(pageKey);
        if (pageContainerFromPageKey != null) {
            return PageModel.INSTANCE.fromPage(pageContainerFromPageKey);
        }
        return null;
    }

    public final List<String> quicklyGetAvailableLanguages() {
        return LanguageListUtil.INSTANCE.buildInstalledLanguages(this.confPath);
    }

    public final boolean isLanguageAvailable(String languageTag) {
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        if (this.confPath.size() < 2) {
            return true;
        }
        return LanguageListUtil.INSTANCE.isLanguageAvailable(languageTag, this.confPath);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public boolean isLanguageAvailable(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        PageModel page = getPage(pageKey);
        if (page != null) {
            return isLanguageAvailable(page.getLanguageTag());
        }
        return false;
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public NotebookKey getLastOpenedFolderKey() {
        String string = this.sharedPreferences.getString(LAST_OPENED_FOLDER_KEY, null);
        if (string != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return NotebookKey.deserialize(string);
            }
        }
        return null;
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public void setLastOpenedFolderKey(NotebookKey notebookKey) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (notebookKey != null && notebookKey.isValid()) {
            editorEdit.putString(LAST_OPENED_FOLDER_KEY, notebookKey.serialize());
        } else {
            editorEdit.remove(LAST_OPENED_FOLDER_KEY);
        }
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public PageKey getLastOpenedNoteKey() {
        String string = this.sharedPreferences.getString(LAST_OPENED_NOTE_KEY, null);
        if (string != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return PageKey.deserialize(string);
            }
        }
        return null;
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public void setLastOpenedNoteKey(PageKey pageKey) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (pageKey != null && pageKey.isValid() && isLanguageAvailable(pageKey)) {
            editorEdit.putString(LAST_OPENED_NOTE_KEY, pageKey.serialize());
        } else {
            editorEdit.remove(LAST_OPENED_NOTE_KEY);
        }
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public boolean canExport(List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        return this.dms.canExport(pageKeys);
    }

    public final boolean hasContent(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        List<Page> listPages = this.dms.pages(notebookKey);
        Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
        List<Page> list = listPages;
        if ((list instanceof java.util.Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Page) it.next()).hasContent()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public boolean supportsExportMimeType(PageKey pageKey, MimeType mimeType) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        List<MimeType> listSupportedExportMimeTypes = this.dms.supportedExportMimeTypes(pageKey);
        Intrinsics.checkNotNullExpressionValue(listSupportedExportMimeTypes, "supportedExportMimeTypes(...)");
        List<MimeType> list = listSupportedExportMimeTypes;
        if ((list instanceof java.util.Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((MimeType) it.next()) == mimeType) {
                return true;
            }
        }
        return false;
    }

    public final ExportController createExportController(List<? extends PageKey> pageKeys, IRendererListener rendererListener, ITypesetListener typesetListener, ViewTransform viewTransform, List<? extends CustomResource> customResources) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        Intrinsics.checkNotNullParameter(rendererListener, "rendererListener");
        Intrinsics.checkNotNullParameter(typesetListener, "typesetListener");
        Intrinsics.checkNotNullParameter(viewTransform, "viewTransform");
        Intrinsics.checkNotNullParameter(customResources, "customResources");
        ExportController exportControllerCreateExportController = this.dms.createExportController(pageKeys, rendererListener, typesetListener, viewTransform, this.documentController.confsDir(), customResources);
        Intrinsics.checkNotNullExpressionValue(exportControllerCreateExportController, "createExportController(...)");
        return exportControllerCreateExportController;
    }

    public final File exportPageAsNebo(PageKey pageKey, File workDir) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(workDir, "workDir");
        ExportController exportControllerCreateExportController = this.dms.createExportController(CollectionsKt.listOf(pageKey), null, null, null, this.documentController.confsDir(), CollectionsKt.emptyList());
        if (exportControllerCreateExportController == null || !exportControllerCreateExportController.exportOptions().getAvailableMimeTypes().contains(MimeType.NEBO)) {
            return null;
        }
        exportControllerCreateExportController.setExportMimeType(MimeType.NEBO);
        List<String> listMakeExport2 = exportControllerCreateExportController.makeExport2(workDir.getAbsolutePath());
        Intrinsics.checkNotNullExpressionValue(listMakeExport2, "makeExport2(...)");
        String str = (String) CollectionsKt.firstOrNull((List) listMakeExport2);
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public FolderModel getFolder(NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        Notebook notebookNotebookFromKey = this.dms.notebookFromKey(notebookKey);
        if (notebookNotebookFromKey != null) {
            return FolderModel.Companion.fromNotebook$default(FolderModel.INSTANCE, notebookNotebookFromKey, this.isAutoSyncEnabled, false, 0, 0, 28, null);
        }
        return null;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageKey duplicatePage(PageKey pageKey, int newPosition) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        PageKey pageKeyDuplicatePage = this.dms.duplicatePage(pageKey, newPosition);
        Intrinsics.checkNotNullExpressionValue(pageKeyDuplicatePage, "duplicatePage(...)");
        return pageKeyDuplicatePage;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageKey createSiblingPage(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        return this.dms.createSiblingPage(pageKey);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageKey movePage(PageKey pageKey, int newPosition) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        logTrace("movePage", pageKey);
        PageKey pageKeyMovePage = this.dms.movePage(pageKey, getNotebookKeyFromPageKey(pageKey), newPosition);
        if (!pageKeyMovePage.isValid()) {
            pageKeyMovePage = null;
        }
        if (pageKeyMovePage != null) {
            return pageKeyMovePage;
        }
        throw new RuntimeException("Error while moving");
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageKey movePage(PageKey pageKey, NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        logTrace("movePageToAnotherNotebook", pageKey);
        PageKey pageKeyMovePage = this.dms.movePage(pageKey, notebookKey);
        if (!pageKeyMovePage.isValid()) {
            pageKeyMovePage = null;
        }
        if (pageKeyMovePage != null) {
            return pageKeyMovePage;
        }
        throw new RuntimeException("Error while moving to an other notebook");
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void movePages(List<? extends PageKey> pageKeys, NotebookKey notebookKey) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
        logTrace("movePagesToAnotherNotebook (" + pageKeys.size() + ")", notebookKey);
        this.dms.movePages((List<PageKey>) pageKeys, notebookKey);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void saveOpenedNote(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        setLastOpenedNoteKey(pageKey);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void clearOpenedNote() {
        setLastOpenedNoteKey(null);
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public PageKey lastOpenedPage(PageKey containerKey) {
        PageKey pageKeyDeserialize;
        Intrinsics.checkNotNullParameter(containerKey, "containerKey");
        String string = this.sharedPreferences.getString(INSTANCE.lastOpenPagePreferenceKey(containerKey), null);
        if (string != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null && (pageKeyDeserialize = PageKey.deserialize(string)) != null) {
                Page pageContainerFromPageKey = this.dms.containerFromPageKey(pageKeyDeserialize);
                if ((pageContainerFromPageKey != null ? pageContainerFromPageKey.getKey() : null) != null) {
                    return pageKeyDeserialize;
                }
            }
        }
        return null;
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void saveOpenedPage(PageKey pageKey) {
        PageKey key;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Page pageContainerFromPageKey = this.dms.containerFromPageKey(pageKey);
        if (pageContainerFromPageKey == null || (key = pageContainerFromPageKey.getKey()) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        String strLastOpenPagePreferenceKey = INSTANCE.lastOpenPagePreferenceKey(key);
        if (pageKey.isValid()) {
            editorEdit.putString(strLastOpenPagePreferenceKey, pageKey.serialize());
        } else {
            editorEdit.remove(strLastOpenPagePreferenceKey);
        }
        editorEdit.apply();
    }

    @Override // com.myscript.nebo.dms.core.PageManager
    public void clearOpenedPage(PageKey containerKey) {
        Intrinsics.checkNotNullParameter(containerKey, "containerKey");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(INSTANCE.lastOpenPagePreferenceKey(containerKey));
        editorEdit.apply();
    }

    public final <R> R withDMS(Function1<? super DMS, ? extends R> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(this.dms);
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public String getLastChosenLanguage() {
        return this.lastChosenLanguage.getValue((Object) this, $$delegatedProperties[0]);
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public void setLastChosenLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastChosenLanguage.setValue2((Object) this, $$delegatedProperties[0], str);
    }

    public final void setCloudDriveInterface(ICloudDriveInterface cloudProvider) {
        this.logger.setKeyValue("dms_cloud_sync_provider", cloudProvider != null ? cloudProvider.getClass().getSimpleName() : "n/a");
        this.hasCloudProvider = cloudProvider != null;
        if (cloudProvider != null) {
            this.degradedCloudDriveWrapper = new DegradedCloudDriveWrapper(cloudProvider);
            disableSyncDegradedMode();
            this.dms.setCloudDriveInterface(this.degradedCloudDriveWrapper);
        } else {
            this.dms.setCloudDriveInterface((ICloudDriveInterface) null);
            DegradedCloudDriveWrapper degradedCloudDriveWrapper = this.degradedCloudDriveWrapper;
            if (degradedCloudDriveWrapper != null) {
                degradedCloudDriveWrapper.delete();
            }
            this.degradedCloudDriveWrapper = null;
        }
        DMSSyncState dMSSyncStateSyncState = this.dms.syncState();
        Intrinsics.checkNotNullExpressionValue(dMSSyncStateSyncState, "syncState(...)");
        this.previousSyncState = dMSSyncStateSyncState;
        int iNumberOfnotebookToSync = (int) this.dms.numberOfnotebookToSync();
        this.lastNumberOfNotebookToSynchronize = iNumberOfnotebookToSync;
        notifySyncState(this.previousSyncState, iNumberOfnotebookToSync, false);
    }

    public final void setSyncDegradedMode(int uploadFailureRate, int downloadFailureRate) {
        DegradedCloudDriveWrapper degradedCloudDriveWrapper = this.degradedCloudDriveWrapper;
        if (degradedCloudDriveWrapper != null) {
            degradedCloudDriveWrapper.setDegradedUpload(uploadFailureRate);
            degradedCloudDriveWrapper.setDegradedDownload(downloadFailureRate);
        }
    }

    public final void disableSyncDegradedMode() {
        setSyncDegradedMode(0, 0);
    }

    public final void clearCache() {
        this.dms.clearCache();
    }

    public final void deleteAll() {
        List<Collection> listCollections = this.dms.collections();
        Intrinsics.checkNotNullExpressionValue(listCollections, "collections(...)");
        List<Collection> list = listCollections;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Collection) it.next()).getKey());
        }
        this.dms.moveCollectionsToTrash(arrayList);
        emptyTrash();
    }

    @Override // com.myscript.nebo.dms.core.ContentInitializer
    public void clearAllContent() {
        clearCache();
        deleteAll();
        waitForIdle();
    }

    public final void setBackgroundColor(PageKey pageKey, int color) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        this.dms.setBackgroundColor(pageKey, ColorExt.getOpaque(color));
    }

    public final void setBackgroundPattern(PageKey pageKey, String pattern) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.dms.setBackgroundPattern(pageKey, pattern);
    }

    public final String exportDatalog(String exportPath) {
        Intrinsics.checkNotNullParameter(exportPath, "exportPath");
        String strBackupDataStructure = this.dms.backupDataStructure(exportPath, "Android " + Build.VERSION.RELEASE);
        Intrinsics.checkNotNullExpressionValue(strBackupDataStructure, "backupDataStructure(...)");
        return strBackupDataStructure;
    }

    public final String dumpV1Cloud(String outputDirPath) {
        String strDumpCloudV1 = this.dms.dumpCloudV1(outputDirPath);
        Intrinsics.checkNotNullExpressionValue(strDumpCloudV1, "dumpCloudV1(...)");
        return strDumpCloudV1;
    }

    @Override // com.myscript.nebo.dms.core.LibraryMigrator
    public long requiredDiskSpaceForMigrationToV2() {
        return this.dms.requiredDiskSpaceForMigrationToV2();
    }

    @Override // com.myscript.nebo.dms.core.LibraryMigrator
    public boolean migrateToV2(IDMSMigrationToV2LogListener migrationListener, ICancelableTaskProgressCallback progressCallback) {
        Intrinsics.checkNotNullParameter(migrationListener, "migrationListener");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        return this.dms.migrateToV2(migrationListener, progressCallback);
    }

    public final void emptyTrash() {
        this.dms.emptyTrash();
    }

    public final void restoreAll() {
        this.dms.restoreAll();
    }

    public final void deleteCollectionPermanently(CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        this.dms.deletePermanentlyCollections(CollectionsKt.listOf(collectionKey));
    }

    public final void restoreCollection(CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        this.dms.restoreCollection(collectionKey);
    }

    public final void deleteFoldersPermanently(List<? extends NotebookKey> notebookKeys) {
        Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
        this.dms.deletePermanentlyNotebooks(notebookKeys);
    }

    public final void restoreFolders(List<? extends NotebookKey> notebookKeys) {
        Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
        this.dms.restoreNotebooks(notebookKeys);
    }

    public final void deletePagesPermanently(List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        this.dms.deletePermanentlyPages(pageKeys);
    }

    public final void restorePages(List<? extends PageKey> pageKeys) {
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        this.dms.restorePages(pageKeys);
    }

    public final IPaginatedContainer buildNotebookManager(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        PageModel page = getPage(pageKey);
        if (page == null || !page.isContainer()) {
            return null;
        }
        return NotebookManager.create(this.dms, pageKey);
    }

    public final void editPaginatedContainer(PageKey pageKey, String currentTitle, List<Integer> colors) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(currentTitle, "currentTitle");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.dms.setCoverColors2(pageKey, colors);
        this.dms.updatePageTitle(pageKey, currentTitle);
    }

    public final void checkLastChosenLanguage(List<String> installedLanguageKeys) {
        Intrinsics.checkNotNullParameter(installedLanguageKeys, "installedLanguageKeys");
        if (installedLanguageKeys.isEmpty() || installedLanguageKeys.contains(getLastChosenLanguage())) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(LAST_CHOSEN_LANGUAGE_KEY);
        editorEdit.apply();
    }

    public static /* synthetic */ int getPageCount$default(LibraryRepository libraryRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return libraryRepository.getPageCount(z);
    }

    public final int getPageCount(boolean countLegacyPages) {
        return (int) this.dms.pageCount(countLegacyPages);
    }

    /* JADX INFO: compiled from: LibraryRepository.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryRepository$Companion;", "", "<init>", "()V", "TAG", "", "THUMBNAIL_WIDTH_MM", "", "THUMBNAIL_HEIGHT_MM", "THUMBNAIL_EXTENSION", "THUMBNAIL_DARK_EXTENSION", "SEARCH_HISTORY_NAME_PREF_KEY", "CLOUD_OPERATIONS_FILE", "LAST_OPENED_FOLDER_KEY", "LAST_OPENED_NOTE_KEY", "LAST_OPENED_PAGE_KEY", "LAST_CHOSEN_LANGUAGE_KEY", "DefaultViewTransform", "Lcom/myscript/atk/core/ViewTransform;", "lastOpenPagePreferenceKey", "pageKey", "Lcom/myscript/snt/core/PageKey;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String lastOpenPagePreferenceKey(PageKey pageKey) {
            return "last_opened_child_page_new_tag_" + pageKey.uuid();
        }
    }
}
