package com.myscript.nebo.export;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import androidx.core.content.FileProvider;
import androidx.preference.PreferenceManager;
import com.myscript.atk.core.MimeType;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.clipboard.ContentProviderUtils;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.utils.DialogUtils;
import com.myscript.nebo.common.utils.FileUtils;
import com.myscript.snt.dms.NeboBackupController;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExportHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0018H\u0007J\b\u0010\u001a\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000fH\u0007J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/export/ExportHelper;", "", "<init>", "()V", "ExportLock", "wasExportDisplayed", "", "getExportIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "exportType", "Lcom/myscript/atk/core/MimeType;", "outputFiles", "", "", "getChooserIntent", "openIntent", "title", "getIndividualIntents", "", "intent", "(Landroid/content/Intent;Landroid/content/Context;)[Landroid/content/Intent;", "onExportDisplayed", "", "resetExportDisplayed", "isExportDisplayed", "setProbablyGoneExporting", "resetProbablyGoneExporting", "setProbablyGoneExportingInternal", "isProbablyGoneExporting", "wasProbablyGoneExporting", "exportBackup", "backupPath", "getExportBackupIntent", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExportHelper {
    private static boolean wasExportDisplayed;
    public static final ExportHelper INSTANCE = new ExportHelper();
    private static final Object ExportLock = new Object();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ExportHelper.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MimeType.values().length];
            try {
                iArr[MimeType.DOCX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MimeType.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MimeType.PDF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MimeType.PNG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MimeType.SVG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MimeType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MimeType.PPTX.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MimeType.NEBO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ExportHelper() {
    }

    @JvmStatic
    public static final Intent getExportIntent(Context context, MimeType exportType, Collection<String> outputFiles) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exportType, "exportType");
        Intrinsics.checkNotNullParameter(outputFiles, "outputFiles");
        if (outputFiles.isEmpty()) {
            throw new IllegalStateException("Can't generate an export intent if there is no file to share".toString());
        }
        Collection<String> collection = outputFiles;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(FileProvider.getUriForFile(context, ContentProviderUtils.ContentProviderFileGeneric, new File((String) it.next())));
        }
        ArrayList<? extends Parcelable> arrayList2 = arrayList;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435457);
        if (exportType == MimeType.TEXT && outputFiles.size() == 1) {
            intent.putExtra("android.intent.extra.TEXT", FileUtils.readFile(new File((String) CollectionsKt.first(collection))));
        }
        intent.setDataAndType((Uri) CollectionsKt.first((List) arrayList2), ExportHelperKt.getContentType(exportType));
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
        switch (WhenMappings.$EnumSwitchMapping$0[exportType.ordinal()]) {
            case 1:
                i = C6183R.string.export_to_word;
                break;
            case 2:
                i = C6183R.string.view_in_browser;
                break;
            case 3:
                i = C6183R.string.export_to_pdf;
                break;
            case 4:
                i = C6183R.string.export_to_png;
                break;
            case 5:
                i = C6183R.string.export_to_svg;
                break;
            case 6:
                i = C6183R.string.share_as_text;
                break;
            case 7:
                i = C6079R.string.export_to_powerpoint;
                break;
            case 8:
                i = C6183R.string.export_to_nebo;
                break;
            default:
                i = 0;
                break;
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return getChooserIntent(context, intent, string, exportType);
    }

    @JvmStatic
    public static final Intent getChooserIntent(Context context, Intent openIntent, String title, MimeType exportType) {
        Intent intent;
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(openIntent, "openIntent");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(exportType, "exportType");
        if (exportType == MimeType.HTML) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setDataAndType(openIntent.getData(), openIntent.getType());
            intent2.setClassName(context.getString(C6183R.string.chrome_package_name), context.getString(C6183R.string.chrome_class_name));
            intent2.addFlags(openIntent.getFlags());
            Intent intentCreateCustomChooser = DialogUtils.createCustomChooser(openIntent, title, new Intent[]{intent2}, context.getPackageManager());
            Intrinsics.checkNotNullExpressionValue(intentCreateCustomChooser, "createCustomChooser(...)");
            return intentCreateCustomChooser;
        }
        String stringExtra = openIntent.getStringExtra("android.intent.extra.TEXT");
        String str = stringExtra;
        if (str != null && !StringsKt.isBlank(str)) {
            intent = new Intent("android.intent.action.SEND");
            intent.setType(ExportHelperKt.getContentType(exportType));
            intent.setFlags(openIntent.getFlags());
            intent.putExtra("android.intent.extra.TEXT", stringExtra);
        } else {
            intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.setType(ExportHelperKt.getContentType(exportType));
            intent.setFlags(openIntent.getFlags());
            intent.putExtra("android.intent.extra.STREAM", openIntent.getParcelableArrayListExtra("android.intent.extra.STREAM"));
        }
        Intent intentCreateChooser = Intent.createChooser(intent, title);
        Intrinsics.checkNotNullExpressionValue(intentCreateChooser, "createChooser(...)");
        List mutableList = ArraysKt.toMutableList(INSTANCE.getIndividualIntents(openIntent, context));
        int i = WhenMappings.$EnumSwitchMapping$0[exportType.ordinal()];
        if (i == 1) {
            Iterator it = mutableList.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                String str2 = ((Intent) it.next()).getPackage();
                if (str2 != null && StringsKt.contains$default((CharSequence) str2, (CharSequence) "com.andropenoffice", false, 2, (Object) null)) {
                    break;
                }
                i2++;
            }
            Integer numValueOf = Integer.valueOf(i2);
            if (numValueOf.intValue() == -1) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                mutableList.add(0, mutableList.remove(numValueOf.intValue()));
            }
            Iterator it2 = mutableList.iterator();
            int i3 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i3 = -1;
                    break;
                }
                String str3 = ((Intent) it2.next()).getPackage();
                if (str3 != null && StringsKt.contains$default((CharSequence) str3, (CharSequence) "com.microsoft.office.word", false, 2, (Object) null)) {
                    break;
                }
                i3++;
            }
            Integer numValueOf2 = Integer.valueOf(i3);
            num = numValueOf2.intValue() != -1 ? numValueOf2 : null;
            if (num != null) {
                mutableList.add(0, mutableList.remove(num.intValue()));
            }
        } else if (i == 3) {
            Iterator it3 = mutableList.iterator();
            int i4 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i4 = -1;
                    break;
                }
                String str4 = ((Intent) it3.next()).getPackage();
                if (str4 != null && StringsKt.contains$default((CharSequence) str4, (CharSequence) "com.microsoft.office.word", false, 2, (Object) null)) {
                    break;
                }
                i4++;
            }
            Integer numValueOf3 = Integer.valueOf(i4);
            if (numValueOf3.intValue() == -1) {
                numValueOf3 = null;
            }
            if (numValueOf3 != null) {
                mutableList.add(0, mutableList.remove(numValueOf3.intValue()));
            }
            Iterator it4 = mutableList.iterator();
            int i5 = 0;
            while (true) {
                if (!it4.hasNext()) {
                    i5 = -1;
                    break;
                }
                String str5 = ((Intent) it4.next()).getPackage();
                if (str5 != null && StringsKt.contains$default((CharSequence) str5, (CharSequence) "com.adobe.reader", false, 2, (Object) null)) {
                    break;
                }
                i5++;
            }
            Integer numValueOf4 = Integer.valueOf(i5);
            num = numValueOf4.intValue() != -1 ? numValueOf4 : null;
            if (num != null) {
                mutableList.add(0, mutableList.remove(num.intValue()));
            }
        } else if (i == 7) {
            Iterator it5 = mutableList.iterator();
            int i6 = 0;
            while (true) {
                if (!it5.hasNext()) {
                    i6 = -1;
                    break;
                }
                String str6 = ((Intent) it5.next()).getPackage();
                if (str6 != null && StringsKt.contains$default((CharSequence) str6, (CharSequence) "com.andropenoffice", false, 2, (Object) null)) {
                    break;
                }
                i6++;
            }
            Integer numValueOf5 = Integer.valueOf(i6);
            if (numValueOf5.intValue() == -1) {
                numValueOf5 = null;
            }
            if (numValueOf5 != null) {
                mutableList.add(0, mutableList.remove(numValueOf5.intValue()));
            }
            Iterator it6 = mutableList.iterator();
            int i7 = 0;
            while (true) {
                if (!it6.hasNext()) {
                    i7 = -1;
                    break;
                }
                String str7 = ((Intent) it6.next()).getPackage();
                if (str7 != null && StringsKt.contains$default((CharSequence) str7, (CharSequence) "com.microsoft.office.powerpoint", false, 2, (Object) null)) {
                    break;
                }
                i7++;
            }
            Integer numValueOf6 = Integer.valueOf(i7);
            num = numValueOf6.intValue() != -1 ? numValueOf6 : null;
            if (num != null) {
                mutableList.add(0, mutableList.remove(num.intValue()));
            }
        }
        Intrinsics.checkNotNull(intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) mutableList.toArray(new Intent[0])));
        return intentCreateChooser;
    }

    private final Intent[] getIndividualIntents(Intent intent, Context context) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        String packageName = context.getPackageName();
        Iterator<T> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            String str = ((ResolveInfo) it.next()).activityInfo.packageName;
            if (!Intrinsics.areEqual(str, packageName)) {
                Intent intent2 = new Intent(intent);
                Intrinsics.checkNotNull(str);
                String lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                intent2.setPackage(lowerCase);
                arrayList.add(intent2);
            }
        }
        return (Intent[]) arrayList.toArray(new Intent[0]);
    }

    @JvmStatic
    public static final void onExportDisplayed() {
        synchronized (ExportLock) {
            wasExportDisplayed = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void resetExportDisplayed() {
        synchronized (ExportLock) {
            wasExportDisplayed = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final boolean isExportDisplayed() {
        boolean z;
        synchronized (ExportLock) {
            z = wasExportDisplayed;
            Unit unit = Unit.INSTANCE;
        }
        return z;
    }

    @JvmStatic
    public static final void setProbablyGoneExporting(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.setProbablyGoneExportingInternal(context, true);
    }

    @JvmStatic
    public static final void resetProbablyGoneExporting(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.setProbablyGoneExportingInternal(context, false);
    }

    private final void setProbablyGoneExportingInternal(Context context, boolean isProbablyGoneExporting) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putBoolean(context.getString(C6079R.string.pref_export_probably_exporting), isProbablyGoneExporting);
        editorEdit.apply();
    }

    @JvmStatic
    public static final boolean wasProbablyGoneExporting(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(C6079R.string.pref_export_probably_exporting), false);
    }

    @JvmStatic
    public static final void exportBackup(Context context, String backupPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backupPath, "backupPath");
        Intent exportBackupIntent = getExportBackupIntent(context, backupPath);
        Intent intentCreateChooser = Intent.createChooser(exportBackupIntent, NeboBackupController.neboBackupFileName(new File(backupPath).getName()) + " (" + NeboBackupController.archiveExtension() + ")");
        Intent intent = new Intent(exportBackupIntent);
        intent.setType("application/binary");
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", INSTANCE.getIndividualIntents(intent, context));
        context.startActivity(intentCreateChooser);
        onExportDisplayed();
    }

    @JvmStatic
    public static final Intent getExportBackupIntent(Context context, String backupPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backupPath, "backupPath");
        Uri uriForFile = FileProvider.getUriForFile(context, ContentProviderUtils.ContentProviderFileGeneric, new File(backupPath));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/*");
        intent.setFlags(268435457);
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        return intent;
    }
}
