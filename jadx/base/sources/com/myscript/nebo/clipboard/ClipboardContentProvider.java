package com.myscript.nebo.clipboard;

import android.content.ClipDescription;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.clipboard.ClipboardContentContract;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ClipboardContentProvider extends ContentProvider {
    public static final String ALL_FILTER = "*/*";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final int COPIED_FILE_URI = 100;
    public static final String HTML_EXTENSION = ".html";
    public static final String HTML_MIMETYPE = "text/html";
    public static final String IMG_MIMETYPE = "image/png";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    public static final String PNG_EXTENSION = ".png";
    private static final String TAG = "ClipboardProvider";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static final String TEMP_APP_DIR = "tempAppDir";
    public static final String TEXT_MIMETYPE = "text/plain";
    public static final String TXT_EXTENSION = ".txt";
    protected PathStrategy mStrategy;
    private UriMatcher mUriMatcher;
    private static final File DEVICE_ROOT = new File(DomExceptionUtils.SEPARATOR);
    private static HashMap<String, PathStrategy> sCache = new HashMap<>();

    public interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI(ContentProviderUtils.ContentProviderClipboard, TEMP_APP_DIR, 100);
        return uriMatcher;
    }

    public static Uri getUriForFile(Context context, File file) {
        return getPathStrategy(context).getUriForFile(file);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        this.mStrategy = getPathStrategy(context);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        if (this.mUriMatcher == null) {
            this.mUriMatcher = buildUriMatcher();
        }
        if (this.mUriMatcher.match(new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).appendPath(uri.getPathSegments().size() > 0 ? uri.getPathSegments().get(0) : "").build()) != 100) {
            return null;
        }
        File fileForUri = this.mStrategy.getFileForUri(uri);
        if (strArr == null) {
            strArr = ClipboardContentContract.FileEntry.FILE_COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileForUri.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(fileForUri.length());
            } else if (ClipboardContentContract.FileEntry.PATH.equals(str3)) {
                strArr3[i2] = ClipboardContentContract.FileEntry.PATH;
                i = i2 + 1;
                objArr[i2] = fileForUri.getPath();
            }
            i2 = i;
        }
        String[] strArrCopyOf = copyOf(strArr3, i2);
        Object[] objArrCopyOf = copyOf(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArrCopyOf, 1);
        matrixCursor.addRow(objArrCopyOf);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileForUri = this.mStrategy.getFileForUri(uri);
        int iLastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (iLastIndexOf != -1) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(iLastIndexOf).substring(1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.mStrategy.getFileForUri(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return getParcelFileDescriptor(uri, str);
    }

    private ParcelFileDescriptor getParcelFileDescriptor(Uri uri, String str) {
        File fileForUri = this.mStrategy.getFileForUri(uri);
        try {
            return ParcelFileDescriptor.open(fileForUri, modeToMode(str));
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File " + fileForUri.getName() + " not found", e);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        return new AssetFileDescriptor(getParcelFileDescriptor(uri, "r"), 0, -1L);
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return openAssetFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        if (getStreamTypes(uri, str) != null) {
            return openAssetFile(uri, "r");
        }
        return super.openTypedAssetFile(uri, str, bundle);
    }

    @Override // android.content.ContentProvider
    public String[] getStreamTypes(Uri uri, String str) {
        ClipDescription clipDescription;
        if (ALL_FILTER.equals(str)) {
            clipDescription = new ClipDescription(null, new String[]{"text/plain", HTML_MIMETYPE, "image/png"});
        } else if (uri.toString().contains(TXT_EXTENSION)) {
            clipDescription = new ClipDescription(null, new String[]{"text/plain"});
        } else if (uri.toString().contains(HTML_EXTENSION)) {
            clipDescription = new ClipDescription(null, new String[]{HTML_MIMETYPE});
        } else if (uri.toString().contains(PNG_EXTENSION)) {
            clipDescription = new ClipDescription(null, new String[]{"image/png"});
        } else {
            return new String[0];
        }
        return clipDescription.filterMimeTypes(str);
    }

    public static PathStrategy getPathStrategy(Context context) {
        PathStrategy pathStrategy;
        synchronized (sCache) {
            pathStrategy = sCache.get(ContentProviderUtils.ContentProviderClipboard);
            if (pathStrategy == null) {
                try {
                    pathStrategy = parsePathStrategy(context, ContentProviderUtils.ContentProviderClipboard);
                    sCache.put(ContentProviderUtils.ContentProviderClipboard, pathStrategy);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return pathStrategy;
    }

    private static PathStrategy parsePathStrategy(Context context, String str) throws XmlPullParserException, IOException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        XmlResourceParser xmlResourceParserLoadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return simplePathStrategy;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File fileBuildPath = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if (TAG_ROOT_PATH.equals(name)) {
                    fileBuildPath = buildPath(DEVICE_ROOT, attributeValue2);
                } else if (TAG_FILES_PATH.equals(name)) {
                    fileBuildPath = buildPath(context.getFilesDir(), attributeValue2);
                } else if (TAG_CACHE_PATH.equals(name)) {
                    fileBuildPath = buildPath(context.getCacheDir(), attributeValue2);
                } else if (TAG_EXTERNAL.equals(name)) {
                    fileBuildPath = buildPath(Environment.getExternalStorageDirectory(), attributeValue2);
                }
                if (fileBuildPath != null) {
                    simplePathStrategy.addRoot(attributeValue, fileBuildPath);
                }
            }
        }
    }

    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots = new HashMap<>();

        public SimplePathStrategy(String str) {
            this.mAuthority = str;
        }

        public void addRoot(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.mRoots.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
            }
        }

        @Override // com.myscript.nebo.clipboard.ClipboardContentProvider.PathStrategy
        public Uri getUriForFile(File file) {
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.mRoots.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith(DomExceptionUtils.SEPARATOR)) {
                    strSubstring = canonicalPath.substring(path2.length());
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(this.mAuthority).encodedPath(Uri.encode(entry.getKey()) + JsonPointer.SEPARATOR + Uri.encode(strSubstring, DomExceptionUtils.SEPARATOR)).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // com.myscript.nebo.clipboard.ClipboardContentProvider.PathStrategy
        public File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.mRoots.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }

    private static int modeToMode(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] copyOf(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static Object[] copyOf(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
