package com.dropbox.core.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import com.dropbox.core.android.internal.DropboxAuthIntent;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: DbxOfficialAppConnector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0004J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0017"}, m1599d2 = {"Lcom/dropbox/core/android/DbxOfficialAppConnector;", "", "uid", "", "(Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "setUid", "addExtrasToIntent", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getPreviewFileIntent", ClientCookie.PATH_ATTR, "lastRev", "getUpgradeAccountIntent", "isSignedIn", "", "launchDropbox", "Companion", "DbxOfficialAppInstallInfo", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final class DbxOfficialAppConnector {
    public static final String ACTION_DBXC_EDIT = "com.dropbox.android.intent.action.DBXC_EDIT";
    public static final String ACTION_DBXC_VIEW = "com.dropbox.android.intent.action.DBXC_VIEW";
    public static final String ACTION_SHOW_DROPBOX_PREVIEW = "com.dropbox.android.intent.action.SHOW_PREVIEW";
    public static final String ACTION_SHOW_UPGRADE = "com.dropbox.android.intent.action.SHOW_UPGRADE";
    private static final int CORRECT_USER = 1;
    public static final String EXTRA_CALLING_PACKAGE = "com.dropbox.android.intent.extra.CALLING_PACKAGE";
    public static final String EXTRA_DROPBOX_PATH = "com.dropbox.android.intent.extra.DROPBOX_PATH";
    public static final String EXTRA_DROPBOX_READ_ONLY = "com.dropbox.android.intent.extra.READ_ONLY";
    public static final String EXTRA_DROPBOX_REV = "com.dropbox.android.intent.extra.DROPBOX_REV";
    public static final String EXTRA_DROPBOX_SESSION_ID = "com.dropbox.android.intent.extra.SESSION_ID";
    public static final String EXTRA_DROPBOX_UID = "com.dropbox.android.intent.extra.DROPBOX_UID";
    private static final int MIN_OPENWITH_VERSION = 240607;
    private static final int NO_USER = 0;
    private static final int WRONG_USER = -1;
    private String uid;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Uri LOGGED_IN_URI = Uri.parse("content://com.dropbox.android.provider.SDK/is_user_logged_in/");
    private static final String[] DROPBOX_APP_SIGNATURES = {"308202223082018b02044bd207bd300d06092a864886f70d01010405003058310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130744726f70626f783112301006035504031309546f6d204d65796572301e170d3130303432333230343930315a170d3430303431353230343930315a3058310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130744726f70626f783112301006035504031309546f6d204d6579657230819f300d06092a864886f70d010101050003818d0030818902818100ac1595d0ab278a9577f0ca5a14144f96eccde75f5616f36172c562fab0e98c48ad7d64f1091c6cc11ce084a4313d522f899378d312e112a748827545146a779defa7c31d8c00c2ed73135802f6952f59798579859e0214d4e9c0554b53b26032a4d2dfc2f62540d776df2ea70e2a6152945fb53fef5bac5344251595b729d4810203010001300d06092a864886f70d01010405000381810055c425d94d036153203dc0bbeb3516f94563b102fff39c3d4ed91278db24fc4424a244c2e59f03bbfea59404512b8bf74662f2a32e37eafa2ac904c31f99cfc21c9ff375c977c432d3b6ec22776f28767d0f292144884538c3d5669b568e4254e4ed75d9054f75229ac9d4ccd0b7c3c74a34f07b7657083b2aa76225c0c56ffc", "308201e53082014ea00302010202044e17e115300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3131303730393035303331375a170d3431303730313035303331375a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d003081890281810096759fe5abea6a0757039b92adc68d672efa84732c3f959408e12efa264545c61f23141026a6d01eceeeaa13ec7087087e5894a3363da8bf5c69ed93657a6890738a80998e4ca22dc94848f30e2d0e1890000ae2cddf543b20c0c3828deca6c7944b5ecd21a9d18c988b2b3e54517dafbc34b48e801bb1321e0fa49e4d575d7f0203010001300d06092a864886f70d0101050500038181002b6d4b65bcfa6ec7bac97ae6d878064d47b3f9f8da654995b8ef4c385bc4fbfbb7a987f60783ef0348760c0708acd4b7e63f0235c35a4fbcd5ec41b3b4cb295feaa7d5c27fa562a02562b7e1f4776b85147be3e295714986c4a9a07183f48ea09ae4d3ea31b88d0016c65b93526b9c45f2967c3d28dee1aff5a5b29b9c2c8639"};

    @JvmStatic
    public static final Intent generateOpenWithIntentFromUtmContent(String str) throws DropboxParseException {
        return INSTANCE.generateOpenWithIntentFromUtmContent(str);
    }

    @JvmStatic
    public static final Intent getDropboxPlayStoreIntent() {
        return INSTANCE.getDropboxPlayStoreIntent();
    }

    @JvmStatic
    public static final boolean isAnySignedIn(Context context) {
        return INSTANCE.isAnySignedIn(context);
    }

    @JvmStatic
    public static final DbxOfficialAppInstallInfo isInstalled(Context context) {
        return INSTANCE.isInstalled(context);
    }

    public DbxOfficialAppConnector(String str) throws DropboxUidNotInitializedException {
        if (str == null || str.length() == 0) {
            throw new DropboxUidNotInitializedException("Must initialize session's uid before constructing DbxOfficialAppConnector");
        }
        this.uid = str;
    }

    protected final String getUid() {
        return this.uid;
    }

    protected final void setUid(String str) {
        this.uid = str;
    }

    /* JADX INFO: compiled from: DbxOfficialAppConnector.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/dropbox/core/android/DbxOfficialAppConnector$DbxOfficialAppInstallInfo;", "", "supportsOpenWith", "", "versionCode", "", "(ZI)V", "toString", "", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
    public static final class DbxOfficialAppInstallInfo {
        public final boolean supportsOpenWith;
        public final int versionCode;

        public DbxOfficialAppInstallInfo(boolean z, int i) {
            this.supportsOpenWith = z;
            this.versionCode = i;
        }

        public String toString() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("DbxOfficialAppInstallInfo(versionCode=%s, supportsOpenWith=%s)", Arrays.copyOf(new Object[]{Integer.valueOf(this.versionCode), Boolean.valueOf(this.supportsOpenWith)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            return str;
        }
    }

    protected final void addExtrasToIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra(EXTRA_DROPBOX_UID, this.uid);
        intent.putExtra(EXTRA_CALLING_PACKAGE, context.getPackageName());
    }

    public final boolean isSignedIn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getLoggedinState(context, this.uid) == 1;
    }

    protected final Intent launchDropbox(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.dropbox.android");
        if (INSTANCE.getDropboxAppPackage$android_release(context, launchIntentForPackage) != null) {
            return launchIntentForPackage;
        }
        return null;
    }

    public final Intent getUpgradeAccountIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(ACTION_SHOW_UPGRADE);
        addExtrasToIntent(context, intent);
        if (INSTANCE.getDropboxAppPackage$android_release(context, intent) != null) {
            return intent;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("https://www.dropbox.com/upgrade?oqa=upeaoq"));
        return intent2;
    }

    public final Intent getPreviewFileIntent(Context context, String path, String lastRev) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(ACTION_SHOW_DROPBOX_PREVIEW);
        addExtrasToIntent(context, intent);
        intent.putExtra(EXTRA_DROPBOX_PATH, path);
        intent.putExtra(EXTRA_DROPBOX_REV, lastRev);
        if (INSTANCE.getDropboxAppPackage$android_release(context, intent) != null) {
            return intent;
        }
        return null;
    }

    /* JADX INFO: compiled from: DbxOfficialAppConnector.kt */
    @Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u001aH\u0007J\u001a\u0010#\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, m1599d2 = {"Lcom/dropbox/core/android/DbxOfficialAppConnector$Companion;", "", "()V", "ACTION_DBXC_EDIT", "", "ACTION_DBXC_VIEW", "ACTION_SHOW_DROPBOX_PREVIEW", "ACTION_SHOW_UPGRADE", "CORRECT_USER", "", "DROPBOX_APP_SIGNATURES", "", "[Ljava/lang/String;", "EXTRA_CALLING_PACKAGE", "EXTRA_DROPBOX_PATH", "EXTRA_DROPBOX_READ_ONLY", "EXTRA_DROPBOX_REV", "EXTRA_DROPBOX_SESSION_ID", "EXTRA_DROPBOX_UID", "LOGGED_IN_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "MIN_OPENWITH_VERSION", "NO_USER", "WRONG_USER", "generateOpenWithIntentFromUtmContent", "Landroid/content/Intent;", "UtmContent", "getDropboxAppPackage", "Landroid/content/pm/PackageInfo;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "intent", "getDropboxAppPackage$android_release", "getDropboxPlayStoreIntent", "getLoggedinState", "uid", "isAnySignedIn", "", "isInstalled", "Lcom/dropbox/core/android/DbxOfficialAppConnector$DbxOfficialAppInstallInfo;", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DbxOfficialAppInstallInfo isInstalled(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            PackageInfo dropboxAppPackage$android_release = getDropboxAppPackage$android_release(context, DropboxAuthIntent.INSTANCE.buildActionAuthenticateIntent());
            if (dropboxAppPackage$android_release == null) {
                return null;
            }
            int i = dropboxAppPackage$android_release.versionCode;
            return new DbxOfficialAppInstallInfo(i >= DbxOfficialAppConnector.MIN_OPENWITH_VERSION, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getLoggedinState(Context context, String uid) {
            Cursor cursorQuery = context.getContentResolver().query(DbxOfficialAppConnector.LOGGED_IN_URI.buildUpon().appendPath(uid).build(), null, null, null, null);
            if (cursorQuery == null) {
                return 0;
            }
            cursorQuery.moveToFirst();
            int columnIndex = cursorQuery.getColumnIndex("logged_in");
            if (columnIndex < 0) {
                return 0;
            }
            return cursorQuery.getInt(columnIndex);
        }

        @JvmStatic
        public final boolean isAnySignedIn(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getLoggedinState(context, "0") != 0;
        }

        @JvmStatic
        public final Intent getDropboxPlayStoreIntent() {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.dropbox.android"));
            return intent;
        }

        public final PackageInfo getDropboxAppPackage$android_release(Context context, Intent intent) {
            ResolveInfo resolveInfoResolveActivity;
            Intrinsics.checkNotNullParameter(context, "context");
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNull(intent);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "manager.queryIntentActivities(intent!!, 0)");
            if (1 != listQueryIntentActivities.size() || (resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfoResolveActivity.activityInfo.packageName, 64);
                Intrinsics.checkNotNullExpressionValue(packageInfo, "{\n                    ma…      )\n                }");
                Signature[] signatureArr = packageInfo.signatures;
                Intrinsics.checkNotNullExpressionValue(signatureArr, "packageInfo.signatures");
                for (Signature signature : signatureArr) {
                    for (String str : DbxOfficialAppConnector.DROPBOX_APP_SIGNATURES) {
                        if (Intrinsics.areEqual(str, signature.toCharsString())) {
                            return packageInfo;
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return null;
        }

        @JvmStatic
        public final Intent generateOpenWithIntentFromUtmContent(String UtmContent) throws DropboxParseException {
            try {
                byte[] bArrDecode = Base64.decode(UtmContent, 0);
                Intrinsics.checkNotNullExpressionValue(bArrDecode, "{\n                Base64…Content, 0)\n            }");
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
                parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
                parcelObtain.setDataPosition(0);
                Bundle bundle = parcelObtain.readBundle();
                parcelObtain.recycle();
                if (bundle == null) {
                    throw new DropboxParseException("Could not extract bundle from UtmContent");
                }
                String string = bundle.getString("_action");
                if (string == null) {
                    throw new DropboxParseException("_action was not present in bundle");
                }
                bundle.remove("_action");
                Uri uri = (Uri) bundle.getParcelable("_uri");
                if (uri == null) {
                    throw new DropboxParseException("_uri was not present in bundle");
                }
                bundle.remove("_uri");
                String string2 = bundle.getString("_type");
                if (string2 == null) {
                    throw new DropboxParseException("_type was not present in bundle");
                }
                bundle.remove("_type");
                Intent intent = new Intent(string);
                intent.setDataAndType(uri, string2);
                intent.putExtras(bundle);
                return intent;
            } catch (IllegalArgumentException e) {
                throw new DropboxParseException("UtmContent was not base64 encoded: " + e.getMessage());
            }
        }
    }
}
