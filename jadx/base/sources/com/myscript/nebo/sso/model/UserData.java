package com.myscript.nebo.sso.model;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.media3.common.MimeTypes;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myscript.android.utils.BooleanSharedPreferencesProperty;
import com.myscript.android.utils.LongSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.android.utils.StringSharedPreferencesProperty;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UserData.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u0001:\u0002abB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0006\u0010[\u001a\u00020$J\u000e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020$J\u0006\u0010_\u001a\u00020$J\u0006\u0010`\u001a\u00020]R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R+\u0010\u0018\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R+\u0010\u001c\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R+\u0010 \u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R+\u0010%\u001a\u00020$2\u0006\u0010\f\u001a\u00020$8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R+\u0010+\u001a\u00020$2\u0006\u0010\f\u001a\u00020$8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010*\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R+\u0010/\u001a\u00020.2\u0006\u0010\f\u001a\u00020.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b0\u00101\"\u0004\b2\u00103R+\u00106\u001a\u00020$2\u0006\u0010\f\u001a\u00020$8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010*\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R+\u00109\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0013\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R+\u0010=\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\u0013\u001a\u0004\b>\u0010\u000f\"\u0004\b?\u0010\u0011R\u001b\u0010A\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0013\u001a\u0004\bB\u0010\u000fR+\u0010D\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010\u0013\u001a\u0004\bE\u0010\u000f\"\u0004\bF\u0010\u0011R+\u0010H\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u0013\u001a\u0004\bI\u0010\u000f\"\u0004\bJ\u0010\u0011R+\u0010L\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010\u0013\u001a\u0004\bM\u0010\u000f\"\u0004\bN\u0010\u0011R+\u0010P\u001a\u00020$2\u0006\u0010\f\u001a\u00020$8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010*\u001a\u0004\bP\u0010&\"\u0004\bQ\u0010(R+\u0010S\u001a\u00020.2\u0006\u0010\f\u001a\u00020.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bV\u00105\u001a\u0004\bT\u00101\"\u0004\bU\u00103R+\u0010W\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010\u0013\u001a\u0004\bX\u0010\u000f\"\u0004\bY\u0010\u0011¨\u0006c"}, m1599d2 = {"Lcom/myscript/nebo/sso/model/UserData;", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "uuidGenerator", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "(Landroid/app/Application;)V", "<set-?>", "login", "getLogin", "()Ljava/lang/String;", "setLogin", "(Ljava/lang/String;)V", "login$delegate", "Lcom/myscript/android/utils/StringSharedPreferencesProperty;", "mail", "getMail", "setMail", "mail$delegate", "firstName", "getFirstName", "setFirstName", "firstName$delegate", "lastName", "getLastName", "setLastName", "lastName$delegate", "appConnectionKey", "getAppConnectionKey", "setAppConnectionKey", "appConnectionKey$delegate", "", "isAccountActivated", "()Z", "setAccountActivated", "(Z)V", "isAccountActivated$delegate", "Lcom/myscript/android/utils/BooleanSharedPreferencesProperty;", "isNotesSharingActivated", "setNotesSharingActivated", "isNotesSharingActivated$delegate", "", "notesSharingRequestDate", "getNotesSharingRequestDate", "()J", "setNotesSharingRequestDate", "(J)V", "notesSharingRequestDate$delegate", "Lcom/myscript/android/utils/LongSharedPreferencesProperty;", "isNewPrivacyAccepted", "setNewPrivacyAccepted", "isNewPrivacyAccepted$delegate", "refreshToken", "getRefreshToken", "setRefreshToken", "refreshToken$delegate", "accessToken", "getAccessToken", "setAccessToken", "accessToken$delegate", "dropboxToken", "getDropboxToken", "dropboxToken$delegate", "dropboxCredential", "getDropboxCredential", "setDropboxCredential", "dropboxCredential$delegate", "gDriveAuthCode", "getGDriveAuthCode", "setGDriveAuthCode", "gDriveAuthCode$delegate", "publicAuthorId", "getPublicAuthorId", "setPublicAuthorId", "publicAuthorId$delegate", "isInstrumentedFeatureActivated", "setInstrumentedFeatureActivated", "isInstrumentedFeatureActivated$delegate", "organizationLastFetch", "getOrganizationLastFetch", "setOrganizationLastFetch", "organizationLastFetch$delegate", RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, "getAppInstanceId", "setAppInstanceId", "appInstanceId$delegate", "hasOrganizationOpenApp", "saveOrganizationOpenApp", "", "openApp", "hasUser", "logout", "Provider", "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserData {
    private static final String APP_CONNECTION_KEY = "app_connection_key";
    private static final String APP_INSTANCE_ID_KEY = "app_instance_id";
    private static final String DROPBOX_CREDENTIAL_KEY = "dropbox_credential";
    private static final String DROPBOX_TOKEN_KEY = "dropbox_token";
    private static final String EMAIL_KEY = "user_email";
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String GDRIVE_AUTH_CODE_KEY = "gdrive_auth_code";
    private static final String HAS_BEEN_ACTIVATED_KEY = "user_has_been_activated";
    private static final String INSTRUMENTED_FEATURE_ACTIVATED_KEY = "instrumented_feature_activated";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LEGACY_DEPRECATED_APP_REQUEST_HEADERS_KEY = "user_agent";
    private static final String LOGIN_KEY = "user_login";
    private static final String NEW_PRIVACY_ACCEPTED_KEY = "new_privacy_accepted_key";
    private static final String ORGANIZATION_LAST_FETCH_KEY = "organization_last_fetch";
    private static final String ORGANIZATION_OPEN_APP_KEY = "organization_open_app";
    private static final String PUBLIC_AUTHOR_ID_KEY = "public_author_id";
    private static final String REFRESH_TOKEN_KEY = "refresh_token";
    private static final String SHARE_NOTES_KEY = "share_notes";
    private static final String SHARE_NOTES_REQUEST_DATE_KEY = "share_notes_request_date";
    private static final String SSO_PREFERENCES_NAME = "sso";
    private static final String TOKEN_KEY = "user_token";

    /* JADX INFO: renamed from: accessToken$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty accessToken;

    /* JADX INFO: renamed from: appConnectionKey$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty appConnectionKey;

    /* JADX INFO: renamed from: appInstanceId$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty appInstanceId;

    /* JADX INFO: renamed from: dropboxCredential$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty dropboxCredential;

    /* JADX INFO: renamed from: dropboxToken$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty dropboxToken;

    /* JADX INFO: renamed from: firstName$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty firstName;

    /* JADX INFO: renamed from: gDriveAuthCode$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty gDriveAuthCode;

    /* JADX INFO: renamed from: isAccountActivated$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty isAccountActivated;

    /* JADX INFO: renamed from: isInstrumentedFeatureActivated$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty isInstrumentedFeatureActivated;

    /* JADX INFO: renamed from: isNewPrivacyAccepted$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty isNewPrivacyAccepted;

    /* JADX INFO: renamed from: isNotesSharingActivated$delegate, reason: from kotlin metadata */
    private final BooleanSharedPreferencesProperty isNotesSharingActivated;

    /* JADX INFO: renamed from: lastName$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty lastName;

    /* JADX INFO: renamed from: login$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty login;

    /* JADX INFO: renamed from: mail$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty mail;

    /* JADX INFO: renamed from: notesSharingRequestDate$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty notesSharingRequestDate;

    /* JADX INFO: renamed from: organizationLastFetch$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty organizationLastFetch;

    /* JADX INFO: renamed from: publicAuthorId$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty publicAuthorId;

    /* JADX INFO: renamed from: refreshToken$delegate, reason: from kotlin metadata */
    private final StringSharedPreferencesProperty refreshToken;
    private final SharedPreferences sharedPreferences;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(UserData.class, "login", "getLogin()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "mail", "getMail()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "firstName", "getFirstName()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "lastName", "getLastName()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "appConnectionKey", "getAppConnectionKey()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "isAccountActivated", "isAccountActivated()Z", 0), new MutablePropertyReference1Impl(UserData.class, "isNotesSharingActivated", "isNotesSharingActivated()Z", 0), new MutablePropertyReference1Impl(UserData.class, "notesSharingRequestDate", "getNotesSharingRequestDate()J", 0), new MutablePropertyReference1Impl(UserData.class, "isNewPrivacyAccepted", "isNewPrivacyAccepted()Z", 0), new MutablePropertyReference1Impl(UserData.class, "refreshToken", "getRefreshToken()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "accessToken", "getAccessToken()Ljava/lang/String;", 0), new PropertyReference1Impl(UserData.class, "dropboxToken", "getDropboxToken()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "dropboxCredential", "getDropboxCredential()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "gDriveAuthCode", "getGDriveAuthCode()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "publicAuthorId", "getPublicAuthorId()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UserData.class, "isInstrumentedFeatureActivated", "isInstrumentedFeatureActivated()Z", 0), new MutablePropertyReference1Impl(UserData.class, "organizationLastFetch", "getOrganizationLastFetch()J", 0), new MutablePropertyReference1Impl(UserData.class, RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, "getAppInstanceId()Ljava/lang/String;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: UserData.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/model/UserData$Provider;", "", "provideUserData", "Lcom/myscript/nebo/sso/model/UserData;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        UserData provideUserData();
    }

    public UserData(SharedPreferences sharedPreferences, Function0<String> uuidGenerator) {
        String strInvoke;
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(uuidGenerator, "uuidGenerator");
        this.sharedPreferences = sharedPreferences;
        this.login = SharedPreferencesExtKt.stringPref(sharedPreferences, LOGIN_KEY, "");
        this.mail = SharedPreferencesExtKt.stringPref(sharedPreferences, EMAIL_KEY, "");
        this.firstName = SharedPreferencesExtKt.stringPref(sharedPreferences, "first_name", "");
        this.lastName = SharedPreferencesExtKt.stringPref(sharedPreferences, "last_name", "");
        this.appConnectionKey = SharedPreferencesExtKt.stringPref(sharedPreferences, APP_CONNECTION_KEY, "");
        this.isAccountActivated = SharedPreferencesExtKt.booleanPref(sharedPreferences, HAS_BEEN_ACTIVATED_KEY, false);
        this.isNotesSharingActivated = SharedPreferencesExtKt.booleanPref(sharedPreferences, SHARE_NOTES_KEY, false);
        this.notesSharingRequestDate = SharedPreferencesExtKt.longPref(sharedPreferences, SHARE_NOTES_REQUEST_DATE_KEY, 0L);
        this.isNewPrivacyAccepted = SharedPreferencesExtKt.booleanPref(sharedPreferences, NEW_PRIVACY_ACCEPTED_KEY, false);
        this.refreshToken = SharedPreferencesExtKt.stringPref(sharedPreferences, REFRESH_TOKEN_KEY, "");
        this.accessToken = SharedPreferencesExtKt.stringPref(sharedPreferences, TOKEN_KEY, "");
        this.dropboxToken = SharedPreferencesExtKt.stringPref(sharedPreferences, DROPBOX_TOKEN_KEY, "");
        this.dropboxCredential = SharedPreferencesExtKt.stringPref(sharedPreferences, DROPBOX_CREDENTIAL_KEY, "");
        this.gDriveAuthCode = SharedPreferencesExtKt.stringPref(sharedPreferences, GDRIVE_AUTH_CODE_KEY, "");
        this.publicAuthorId = SharedPreferencesExtKt.stringPref(sharedPreferences, PUBLIC_AUTHOR_ID_KEY, "");
        this.isInstrumentedFeatureActivated = SharedPreferencesExtKt.booleanPref(sharedPreferences, INSTRUMENTED_FEATURE_ACTIVATED_KEY, false);
        this.organizationLastFetch = SharedPreferencesExtKt.longPref(sharedPreferences, ORGANIZATION_LAST_FETCH_KEY, 0L);
        this.appInstanceId = SharedPreferencesExtKt.stringPref(sharedPreferences, APP_INSTANCE_ID_KEY, "");
        if (StringsKt.isBlank(getAppInstanceId())) {
            String string = sharedPreferences.getString(LEGACY_DEPRECATED_APP_REQUEST_HEADERS_KEY, null);
            String str = string;
            if (str == null || str.length() == 0) {
                strInvoke = uuidGenerator.invoke();
            } else {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.remove(LEGACY_DEPRECATED_APP_REQUEST_HEADERS_KEY);
                editorEdit.apply();
                Object objFromJson = new Gson().fromJson(string, new TypeToken<Map<String, ? extends String>>() { // from class: com.myscript.nebo.sso.model.UserData$headers$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                strInvoke = (String) ((Map) objFromJson).get("Nebo-Instance-Id");
                if (strInvoke == null) {
                    strInvoke = uuidGenerator.invoke();
                }
            }
            setAppInstanceId(strInvoke);
        }
    }

    public /* synthetic */ UserData(SharedPreferences sharedPreferences, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? new Function0() { // from class: com.myscript.nebo.sso.model.UserData$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UserData._init_$lambda$0();
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public UserData(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        SharedPreferences sharedPreferences = application.getSharedPreferences(SSO_PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this(sharedPreferences, null, 2, 0 == true ? 1 : 0);
    }

    public final String getLogin() {
        return this.login.getValue((Object) this, $$delegatedProperties[0]);
    }

    public final void setLogin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.login.setValue2((Object) this, $$delegatedProperties[0], str);
    }

    public final String getMail() {
        return this.mail.getValue((Object) this, $$delegatedProperties[1]);
    }

    public final void setMail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mail.setValue2((Object) this, $$delegatedProperties[1], str);
    }

    public final String getFirstName() {
        return this.firstName.getValue((Object) this, $$delegatedProperties[2]);
    }

    public final void setFirstName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstName.setValue2((Object) this, $$delegatedProperties[2], str);
    }

    public final String getLastName() {
        return this.lastName.getValue((Object) this, $$delegatedProperties[3]);
    }

    public final void setLastName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastName.setValue2((Object) this, $$delegatedProperties[3], str);
    }

    public final String getAppConnectionKey() {
        return this.appConnectionKey.getValue((Object) this, $$delegatedProperties[4]);
    }

    public final void setAppConnectionKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appConnectionKey.setValue2((Object) this, $$delegatedProperties[4], str);
    }

    public final boolean isAccountActivated() {
        return this.isAccountActivated.getValue((Object) this, $$delegatedProperties[5]).booleanValue();
    }

    public final void setAccountActivated(boolean z) {
        this.isAccountActivated.setValue(this, $$delegatedProperties[5], z);
    }

    public final boolean isNotesSharingActivated() {
        return this.isNotesSharingActivated.getValue((Object) this, $$delegatedProperties[6]).booleanValue();
    }

    public final void setNotesSharingActivated(boolean z) {
        this.isNotesSharingActivated.setValue(this, $$delegatedProperties[6], z);
    }

    public final long getNotesSharingRequestDate() {
        return this.notesSharingRequestDate.getValue((Object) this, $$delegatedProperties[7]).longValue();
    }

    public final void setNotesSharingRequestDate(long j) {
        this.notesSharingRequestDate.setValue(this, $$delegatedProperties[7], j);
    }

    public final boolean isNewPrivacyAccepted() {
        return this.isNewPrivacyAccepted.getValue((Object) this, $$delegatedProperties[8]).booleanValue();
    }

    public final void setNewPrivacyAccepted(boolean z) {
        this.isNewPrivacyAccepted.setValue(this, $$delegatedProperties[8], z);
    }

    public final String getRefreshToken() {
        return this.refreshToken.getValue((Object) this, $$delegatedProperties[9]);
    }

    public final void setRefreshToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refreshToken.setValue2((Object) this, $$delegatedProperties[9], str);
    }

    public final String getAccessToken() {
        return this.accessToken.getValue((Object) this, $$delegatedProperties[10]);
    }

    public final void setAccessToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessToken.setValue2((Object) this, $$delegatedProperties[10], str);
    }

    public final String getDropboxToken() {
        return this.dropboxToken.getValue((Object) this, $$delegatedProperties[11]);
    }

    public final String getDropboxCredential() {
        return this.dropboxCredential.getValue((Object) this, $$delegatedProperties[12]);
    }

    public final void setDropboxCredential(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dropboxCredential.setValue2((Object) this, $$delegatedProperties[12], str);
    }

    public final String getGDriveAuthCode() {
        return this.gDriveAuthCode.getValue((Object) this, $$delegatedProperties[13]);
    }

    public final void setGDriveAuthCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gDriveAuthCode.setValue2((Object) this, $$delegatedProperties[13], str);
    }

    public final String getPublicAuthorId() {
        return this.publicAuthorId.getValue((Object) this, $$delegatedProperties[14]);
    }

    public final void setPublicAuthorId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.publicAuthorId.setValue2((Object) this, $$delegatedProperties[14], str);
    }

    public final boolean isInstrumentedFeatureActivated() {
        return this.isInstrumentedFeatureActivated.getValue((Object) this, $$delegatedProperties[15]).booleanValue();
    }

    public final void setInstrumentedFeatureActivated(boolean z) {
        this.isInstrumentedFeatureActivated.setValue(this, $$delegatedProperties[15], z);
    }

    public final long getOrganizationLastFetch() {
        return this.organizationLastFetch.getValue((Object) this, $$delegatedProperties[16]).longValue();
    }

    public final void setOrganizationLastFetch(long j) {
        this.organizationLastFetch.setValue(this, $$delegatedProperties[16], j);
    }

    private final void setAppInstanceId(String str) {
        this.appInstanceId.setValue2((Object) this, $$delegatedProperties[17], str);
    }

    public final String getAppInstanceId() {
        return this.appInstanceId.getValue((Object) this, $$delegatedProperties[17]);
    }

    public final boolean hasOrganizationOpenApp() {
        return this.sharedPreferences.getBoolean(ORGANIZATION_OPEN_APP_KEY, false);
    }

    public final void saveOrganizationOpenApp(boolean openApp) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(ORGANIZATION_OPEN_APP_KEY, openApp);
        editorEdit.apply();
    }

    public final boolean hasUser() {
        return getLogin().length() > 0;
    }

    public final void logout() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    /* JADX INFO: compiled from: UserData.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u00020\u00058\u0002X\u0083T¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0003R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/sso/model/UserData$Companion;", "", "<init>", "()V", "SSO_PREFERENCES_NAME", "", "LOGIN_KEY", "EMAIL_KEY", "FIRST_NAME_KEY", "LAST_NAME_KEY", "APP_CONNECTION_KEY", "HAS_BEEN_ACTIVATED_KEY", "TOKEN_KEY", "DROPBOX_TOKEN_KEY", "DROPBOX_CREDENTIAL_KEY", "GDRIVE_AUTH_CODE_KEY", "PUBLIC_AUTHOR_ID_KEY", "SHARE_NOTES_KEY", "SHARE_NOTES_REQUEST_DATE_KEY", "NEW_PRIVACY_ACCEPTED_KEY", "INSTRUMENTED_FEATURE_ACTIVATED_KEY", "REFRESH_TOKEN_KEY", "ORGANIZATION_LAST_FETCH_KEY", "ORGANIZATION_OPEN_APP_KEY", "LEGACY_DEPRECATED_APP_REQUEST_HEADERS_KEY", "getLEGACY_DEPRECATED_APP_REQUEST_HEADERS_KEY$annotations", "APP_INSTANCE_ID_KEY", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use SSOManager to retrieve the Http headers and APP_INSTANCE_ID_KEY to just retrieve the app instance ID instead")
        private static /* synthetic */ void getLEGACY_DEPRECATED_APP_REQUEST_HEADERS_KEY$annotations() {
        }

        private Companion() {
        }
    }
}
