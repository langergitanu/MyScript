package com.myscript.nebo.editing;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.media3.common.MimeTypes;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.SWIGVectorMimeType;
import com.myscript.atk.text.SWIGClipboard;
import com.myscript.nebo.clipboard.ClipboardContentContract;
import com.myscript.nebo.clipboard.ClipboardContentProvider;
import com.myscript.nebo.clipboard.ContentProviderUtils;
import com.myscript.nebo.clipboard.NeboClipboardContentProvider;
import com.myscript.nebo.log.TechnicalLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.ByteStreamsKt;
import kotlin.p039io.CloseableKt;
import kotlin.p039io.FilesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidNativeClipboard.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/editing/AndroidNativeClipboard;", "Lcom/myscript/nebo/editing/INativeClipboardExtended;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "imageImporter", "Lcom/myscript/nebo/editing/ImageImporter;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/log/TechnicalLogger;Lcom/myscript/nebo/editing/ImageImporter;)V", "updateNativeClipboard", "", AndroidNativeClipboard.CLIPBOARD_SUB_DIRECTORY, "Lcom/myscript/atk/text/SWIGClipboard;", "getNativeClipboard", "getClipboardMetadata", "Lcom/myscript/atk/core/SWIGVectorMimeType;", "canPaste", "", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AndroidNativeClipboard implements INativeClipboardExtended {
    private static final String CLIPBOARD_SUB_DIRECTORY = "clipboard";
    private static final long HTML_BYTE_SIZE_LIMIT = 300000;
    public static final String TAG = "AndroidNativeClipboard";
    private static final int TEXT_LIMIT = 20;
    private final Application application;
    private final ImageImporter imageImporter;
    private final TechnicalLogger logger;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public AndroidNativeClipboard(Application application, TechnicalLogger logger, ImageImporter imageImporter) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(imageImporter, "imageImporter");
        this.application = application;
        this.logger = logger;
        this.imageImporter = imageImporter;
    }

    public /* synthetic */ AndroidNativeClipboard(Application application, TechnicalLogger technicalLogger, ImageImporterImpl imageImporterImpl, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, technicalLogger, (i & 4) != 0 ? new ImageImporterImpl(application) : imageImporterImpl);
    }

    @Override // com.myscript.atk.text.INativeClipboard
    public void updateNativeClipboard(SWIGClipboard clipboard) {
        Intrinsics.checkNotNullParameter(clipboard, "clipboard");
        String orNull = AndroidNativeClipboardKt.getOrNull(clipboard, MimeType.TEXT);
        if (orNull == null) {
            orNull = "";
        }
        String str = orNull;
        String str2 = str.length() < 20 ? str : null;
        if (str2 == null) {
            str2 = StringsKt.take(str, 20) + "…";
        }
        String str3 = str2;
        String orNull2 = AndroidNativeClipboardKt.getOrNull(clipboard, MimeType.HTML);
        String str4 = (orNull2 == null || ((long) orNull2.length()) > 300000) ? null : orNull2;
        AndroidNativeClipboardKt.getOrNull(clipboard, MimeType.PNG);
        String orNull3 = AndroidNativeClipboardKt.getOrNull(clipboard, MimeType.NEBO);
        ((ClipboardManager) this.application.getSystemService(ClipboardManager.class)).setPrimaryClip(INSTANCE.createClipData(this.application, str3, str, str4, orNull3 != null ? StringsKt.substringBeforeLast$default(orNull3, Literals.COMMENT_2, (String) null, 2, (Object) null) : null));
    }

    @Override // com.myscript.atk.text.INativeClipboard
    public SWIGClipboard getNativeClipboard() {
        String type;
        ClipData clipData;
        int i;
        int i2;
        boolean z;
        File file;
        String mimeType;
        File file2;
        File file3;
        FileOutputStream fileOutputStreamOpenFileDescriptor;
        SWIGClipboard sWIGClipboard = new SWIGClipboard();
        try {
            ClipData primaryClip = ((ClipboardManager) this.application.getSystemService(ClipboardManager.class)).getPrimaryClip();
            if (primaryClip != null) {
                int i3 = 0;
                for (int itemCount = primaryClip.getItemCount(); i3 < itemCount; itemCount = i) {
                    ClipData.Item itemAt = primaryClip.getItemAt(i3);
                    ContentResolver contentResolver = this.application.getContentResolver();
                    Uri uri = itemAt.getUri();
                    if (uri != null) {
                        Intrinsics.checkNotNull(contentResolver);
                        type = contentResolver.getType(uri);
                    } else {
                        type = null;
                    }
                    if (type == null) {
                        sWIGClipboard.put(MimeType.TEXT, itemAt.coerceToText(this.application).toString());
                        clipData = primaryClip;
                        i = itemCount;
                        i2 = i3;
                    } else if (Intrinsics.areEqual(type, ClipboardContentProvider.HTML_MIMETYPE) || Intrinsics.areEqual(type, "text/plain")) {
                        clipData = primaryClip;
                        i = itemCount;
                        i2 = i3;
                        sWIGClipboard.put(MimeType.TEXT, itemAt.coerceToText(this.application).toString());
                    } else {
                        if (ArraysKt.contains(ImageImporter.INSTANCE.getSUPPORTED_IMAGE_MIMETYPES(), type)) {
                            try {
                                ImageHolder imageHolderImportImage = this.imageImporter.importImage(uri);
                                file = imageHolderImportImage.getFile();
                                mimeType = imageHolderImportImage.getMimeType();
                                file2 = new File(this.application.getCacheDir(), CLIPBOARD_SUB_DIRECTORY);
                                file2.mkdirs();
                                z = false;
                                try {
                                    clipData = primaryClip;
                                } catch (Exception e) {
                                    e = e;
                                    clipData = primaryClip;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                clipData = primaryClip;
                                z = false;
                            }
                            try {
                                File file4 = new File(file2, "clip." + FilesKt.getExtension(file));
                                if (file4.exists()) {
                                    file4.delete();
                                }
                                if (file.renameTo(file4)) {
                                    sWIGClipboard.put(mimeType, file4.getAbsolutePath());
                                } else {
                                    this.logger.logError(new IllegalArgumentException("Clipboard file can't be imported (" + file + " rename to " + file4 + " failed)"));
                                    file.delete();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                this.logger.logError(new IllegalStateException("Clipboard file can't be imported " + uri + " (" + type + ")", e));
                            }
                        } else {
                            clipData = primaryClip;
                            z = false;
                            if (Intrinsics.areEqual(type, NeboClipboardContentProvider.NEBO_CLIPBOARD_MIMETYPE)) {
                                Cursor cursorQuery = contentResolver.query(uri, new String[]{ClipboardContentContract.FileEntry.PATH}, null, null, null, null);
                                try {
                                    Cursor cursor = cursorQuery;
                                    if (cursor == null || !cursor.moveToFirst()) {
                                        i = itemCount;
                                        i2 = i3;
                                    } else {
                                        String string = cursor.getString(cursor.getColumnIndex(ClipboardContentContract.FileEntry.PATH));
                                        if (!Intrinsics.areEqual(uri.getHost(), ContentProviderUtils.ContentProviderClipboard)) {
                                            File file5 = new File(this.application.getCacheDir(), CLIPBOARD_SUB_DIRECTORY);
                                            file5.mkdirs();
                                            File file6 = new File(file5, UUID.randomUUID() + ".nebo");
                                            if (file6.isFile()) {
                                                file6.delete();
                                            }
                                            try {
                                                fileOutputStreamOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                                                try {
                                                    ParcelFileDescriptor parcelFileDescriptor = fileOutputStreamOpenFileDescriptor;
                                                    if (parcelFileDescriptor != null) {
                                                        fileOutputStreamOpenFileDescriptor = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
                                                        try {
                                                            FileInputStream fileInputStream = fileOutputStreamOpenFileDescriptor;
                                                            if (fileInputStream.getChannel().size() > 0) {
                                                                fileOutputStreamOpenFileDescriptor = new FileOutputStream(file6);
                                                                try {
                                                                    i = itemCount;
                                                                    i2 = i3;
                                                                    file3 = file6;
                                                                    try {
                                                                        ByteStreamsKt.copyTo$default(fileInputStream, fileOutputStreamOpenFileDescriptor, 0, 2, null);
                                                                        try {
                                                                            CloseableKt.closeFinally(fileOutputStreamOpenFileDescriptor, null);
                                                                            sWIGClipboard.put(MimeType.NEBO, file3.getAbsolutePath());
                                                                        } catch (Throwable th) {
                                                                            th = th;
                                                                            Throwable th2 = th;
                                                                            try {
                                                                                throw th2;
                                                                            } finally {
                                                                                CloseableKt.closeFinally(fileOutputStreamOpenFileDescriptor, th2);
                                                                            }
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        try {
                                                                            throw th;
                                                                        } catch (Throwable th4) {
                                                                            throw th4;
                                                                        }
                                                                    }
                                                                } catch (Throwable th5) {
                                                                    th = th5;
                                                                    i = itemCount;
                                                                    i2 = i3;
                                                                    file3 = file6;
                                                                }
                                                            } else {
                                                                i = itemCount;
                                                                i2 = i3;
                                                                file3 = file6;
                                                                this.logger.logError(new IllegalStateException("Try to paste empty content"));
                                                            }
                                                            Unit unit = Unit.INSTANCE;
                                                            try {
                                                                CloseableKt.closeFinally(fileOutputStreamOpenFileDescriptor, null);
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                try {
                                                                    throw th;
                                                                } catch (Throwable th7) {
                                                                    throw th7;
                                                                }
                                                            }
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            i = itemCount;
                                                            i2 = i3;
                                                            file3 = file6;
                                                        }
                                                    } else {
                                                        i = itemCount;
                                                        i2 = i3;
                                                        file3 = file6;
                                                    }
                                                    Unit unit2 = Unit.INSTANCE;
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    i = itemCount;
                                                    i2 = i3;
                                                    file3 = file6;
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                i = itemCount;
                                                i2 = i3;
                                                file3 = file6;
                                            }
                                            try {
                                                CloseableKt.closeFinally(fileOutputStreamOpenFileDescriptor, null);
                                            } catch (Exception e5) {
                                                e = e5;
                                                this.logger.logError(new IllegalStateException("Clipboard file can't be imported " + uri + " (" + type + ")", e));
                                                if (file3.exists()) {
                                                    file3.delete();
                                                }
                                                sWIGClipboard.put(MimeType.NEBO, string + ";0");
                                            }
                                        } else {
                                            i = itemCount;
                                            i2 = i3;
                                            sWIGClipboard.put(MimeType.NEBO, string + ";0");
                                        }
                                    }
                                    Unit unit3 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(cursorQuery, null);
                                } finally {
                                }
                            }
                        }
                        i = itemCount;
                        i2 = i3;
                    }
                    i3 = i2 + 1;
                    primaryClip = clipData;
                }
            }
        } catch (Exception unused) {
        }
        return sWIGClipboard;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.myscript.atk.text.INativeClipboard
    public SWIGVectorMimeType getClipboardMetadata() {
        String type;
        MimeType mimeType;
        SWIGVectorMimeType sWIGVectorMimeType = new SWIGVectorMimeType();
        try {
            ClipData primaryClip = ((ClipboardManager) this.application.getSystemService(ClipboardManager.class)).getPrimaryClip();
            if (primaryClip != null) {
                int itemCount = primaryClip.getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    ClipData.Item itemAt = primaryClip.getItemAt(i);
                    ContentResolver contentResolver = this.application.getContentResolver();
                    Uri uri = itemAt.getUri();
                    if (uri != null) {
                        Intrinsics.checkNotNull(contentResolver);
                        type = contentResolver.getType(uri);
                    } else {
                        type = null;
                    }
                    if (type != null) {
                        switch (type.hashCode()) {
                            case -1487394660:
                                if (type.equals("image/jpeg")) {
                                    mimeType = MimeType.JPEG;
                                }
                                break;
                            case -1082243251:
                                if (!type.equals(ClipboardContentProvider.HTML_MIMETYPE)) {
                                }
                                mimeType = MimeType.TEXT;
                                break;
                            case -879258763:
                                if (type.equals("image/png")) {
                                    mimeType = MimeType.PNG;
                                }
                                break;
                            case 471978073:
                                if (type.equals(NeboClipboardContentProvider.NEBO_CLIPBOARD_MIMETYPE)) {
                                    mimeType = MimeType.NEBO;
                                }
                                break;
                            case 817335912:
                                if (!type.equals("text/plain")) {
                                }
                                mimeType = MimeType.TEXT;
                                break;
                        }
                    } else {
                        mimeType = MimeType.TEXT;
                    }
                    sWIGVectorMimeType.push_back(mimeType);
                }
            }
        } catch (Exception unused) {
        }
        return sWIGVectorMimeType;
    }

    @Override // com.myscript.nebo.editing.INativeClipboardExtended
    public boolean canPaste() {
        ClipboardManager clipboardManager = (ClipboardManager) this.application.getSystemService(ClipboardManager.class);
        return clipboardManager != null && clipboardManager.hasPrimaryClip();
    }

    /* JADX INFO: compiled from: AndroidNativeClipboard.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/editing/AndroidNativeClipboard$Companion;", "", "<init>", "()V", "TAG", "", "CLIPBOARD_SUB_DIRECTORY", "TEXT_LIMIT", "", "HTML_BYTE_SIZE_LIMIT", "", "createClipData", "Landroid/content/ClipData;", "Landroid/content/Context;", "description", "text", "html", "filepath", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ClipData createClipData(Context context, String str, String str2, String str3, String str4) {
            Uri uriForFile = str4 != null ? ClipboardContentProvider.getUriForFile(context, new File(str4)) : null;
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add("text/plain");
            if (str3 != null) {
                listCreateListBuilder.add(ClipboardContentProvider.HTML_MIMETYPE);
            }
            if (uriForFile != null) {
                listCreateListBuilder.add("text/uri-list");
            }
            return new ClipData(new ClipDescription(str, (String[]) CollectionsKt.build(listCreateListBuilder).toArray(new String[0])), new ClipData.Item(str2, str3, null, uriForFile));
        }
    }
}
