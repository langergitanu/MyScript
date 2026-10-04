package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ApiSessionLogInfo;
import com.dropbox.core.p013v2.teamlog.SessionLogInfo;
import com.dropbox.core.p013v2.teamlog.WebSessionLogInfo;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class AccessMethodLogInfo {
    public static final AccessMethodLogInfo OTHER = new AccessMethodLogInfo().withTag(Tag.OTHER);
    private Tag _tag;
    private WebSessionLogInfo adminConsoleValue;
    private ApiSessionLogInfo apiValue;
    private WebSessionLogInfo contentManagerValue;
    private SessionLogInfo endUserValue;
    private WebSessionLogInfo enterpriseConsoleValue;
    private WebSessionLogInfo signInAsValue;

    public enum Tag {
        ADMIN_CONSOLE,
        API,
        CONTENT_MANAGER,
        END_USER,
        ENTERPRISE_CONSOLE,
        SIGN_IN_AS,
        OTHER
    }

    private AccessMethodLogInfo() {
    }

    private AccessMethodLogInfo withTag(Tag tag) {
        AccessMethodLogInfo accessMethodLogInfo = new AccessMethodLogInfo();
        accessMethodLogInfo._tag = tag;
        return accessMethodLogInfo;
    }

    private AccessMethodLogInfo withTagAndAdminConsole(Tag tag, WebSessionLogInfo webSessionLogInfo) {
        AccessMethodLogInfo accessMethodLogInfo = new AccessMethodLogInfo();
        accessMethodLogInfo._tag = tag;
        accessMethodLogInfo.adminConsoleValue = webSessionLogInfo;
        return accessMethodLogInfo;
    }

    private AccessMethodLogInfo withTagAndApi(Tag tag, ApiSessionLogInfo apiSessionLogInfo) {
        AccessMethodLogInfo accessMethodLogInfo = new AccessMethodLogInfo();
        accessMethodLogInfo._tag = tag;
        accessMethodLogInfo.apiValue = apiSessionLogInfo;
        return accessMethodLogInfo;
    }

    private AccessMethodLogInfo withTagAndContentManager(Tag tag, WebSessionLogInfo webSessionLogInfo) {
        AccessMethodLogInfo accessMethodLogInfo = new AccessMethodLogInfo();
        accessMethodLogInfo._tag = tag;
        accessMethodLogInfo.contentManagerValue = webSessionLogInfo;
        return accessMethodLogInfo;
    }

    private AccessMethodLogInfo withTagAndEndUser(Tag tag, SessionLogInfo sessionLogInfo) {
        AccessMethodLogInfo accessMethodLogInfo = new AccessMethodLogInfo();
        accessMethodLogInfo._tag = tag;
        accessMethodLogInfo.endUserValue = sessionLogInfo;
        return accessMethodLogInfo;
    }

    private AccessMethodLogInfo withTagAndEnterpriseConsole(Tag tag, WebSessionLogInfo webSessionLogInfo) {
        AccessMethodLogInfo accessMethodLogInfo = new AccessMethodLogInfo();
        accessMethodLogInfo._tag = tag;
        accessMethodLogInfo.enterpriseConsoleValue = webSessionLogInfo;
        return accessMethodLogInfo;
    }

    private AccessMethodLogInfo withTagAndSignInAs(Tag tag, WebSessionLogInfo webSessionLogInfo) {
        AccessMethodLogInfo accessMethodLogInfo = new AccessMethodLogInfo();
        accessMethodLogInfo._tag = tag;
        accessMethodLogInfo.signInAsValue = webSessionLogInfo;
        return accessMethodLogInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAdminConsole() {
        return this._tag == Tag.ADMIN_CONSOLE;
    }

    public static AccessMethodLogInfo adminConsole(WebSessionLogInfo webSessionLogInfo) {
        if (webSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndAdminConsole(Tag.ADMIN_CONSOLE, webSessionLogInfo);
    }

    public WebSessionLogInfo getAdminConsoleValue() {
        if (this._tag != Tag.ADMIN_CONSOLE) {
            throw new IllegalStateException("Invalid tag: required Tag.ADMIN_CONSOLE, but was Tag." + this._tag.name());
        }
        return this.adminConsoleValue;
    }

    public boolean isApi() {
        return this._tag == Tag.API;
    }

    public static AccessMethodLogInfo api(ApiSessionLogInfo apiSessionLogInfo) {
        if (apiSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndApi(Tag.API, apiSessionLogInfo);
    }

    public ApiSessionLogInfo getApiValue() {
        if (this._tag != Tag.API) {
            throw new IllegalStateException("Invalid tag: required Tag.API, but was Tag." + this._tag.name());
        }
        return this.apiValue;
    }

    public boolean isContentManager() {
        return this._tag == Tag.CONTENT_MANAGER;
    }

    public static AccessMethodLogInfo contentManager(WebSessionLogInfo webSessionLogInfo) {
        if (webSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndContentManager(Tag.CONTENT_MANAGER, webSessionLogInfo);
    }

    public WebSessionLogInfo getContentManagerValue() {
        if (this._tag != Tag.CONTENT_MANAGER) {
            throw new IllegalStateException("Invalid tag: required Tag.CONTENT_MANAGER, but was Tag." + this._tag.name());
        }
        return this.contentManagerValue;
    }

    public boolean isEndUser() {
        return this._tag == Tag.END_USER;
    }

    public static AccessMethodLogInfo endUser(SessionLogInfo sessionLogInfo) {
        if (sessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndEndUser(Tag.END_USER, sessionLogInfo);
    }

    public SessionLogInfo getEndUserValue() {
        if (this._tag != Tag.END_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.END_USER, but was Tag." + this._tag.name());
        }
        return this.endUserValue;
    }

    public boolean isEnterpriseConsole() {
        return this._tag == Tag.ENTERPRISE_CONSOLE;
    }

    public static AccessMethodLogInfo enterpriseConsole(WebSessionLogInfo webSessionLogInfo) {
        if (webSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndEnterpriseConsole(Tag.ENTERPRISE_CONSOLE, webSessionLogInfo);
    }

    public WebSessionLogInfo getEnterpriseConsoleValue() {
        if (this._tag != Tag.ENTERPRISE_CONSOLE) {
            throw new IllegalStateException("Invalid tag: required Tag.ENTERPRISE_CONSOLE, but was Tag." + this._tag.name());
        }
        return this.enterpriseConsoleValue;
    }

    public boolean isSignInAs() {
        return this._tag == Tag.SIGN_IN_AS;
    }

    public static AccessMethodLogInfo signInAs(WebSessionLogInfo webSessionLogInfo) {
        if (webSessionLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndSignInAs(Tag.SIGN_IN_AS, webSessionLogInfo);
    }

    public WebSessionLogInfo getSignInAsValue() {
        if (this._tag != Tag.SIGN_IN_AS) {
            throw new IllegalStateException("Invalid tag: required Tag.SIGN_IN_AS, but was Tag." + this._tag.name());
        }
        return this.signInAsValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.adminConsoleValue, this.apiValue, this.contentManagerValue, this.endUserValue, this.enterpriseConsoleValue, this.signInAsValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessMethodLogInfo)) {
            return false;
        }
        AccessMethodLogInfo accessMethodLogInfo = (AccessMethodLogInfo) obj;
        if (this._tag != accessMethodLogInfo._tag) {
            return false;
        }
        switch (C44281.$SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag[this._tag.ordinal()]) {
            case 1:
                WebSessionLogInfo webSessionLogInfo = this.adminConsoleValue;
                WebSessionLogInfo webSessionLogInfo2 = accessMethodLogInfo.adminConsoleValue;
                return webSessionLogInfo == webSessionLogInfo2 || webSessionLogInfo.equals(webSessionLogInfo2);
            case 2:
                ApiSessionLogInfo apiSessionLogInfo = this.apiValue;
                ApiSessionLogInfo apiSessionLogInfo2 = accessMethodLogInfo.apiValue;
                return apiSessionLogInfo == apiSessionLogInfo2 || apiSessionLogInfo.equals(apiSessionLogInfo2);
            case 3:
                WebSessionLogInfo webSessionLogInfo3 = this.contentManagerValue;
                WebSessionLogInfo webSessionLogInfo4 = accessMethodLogInfo.contentManagerValue;
                return webSessionLogInfo3 == webSessionLogInfo4 || webSessionLogInfo3.equals(webSessionLogInfo4);
            case 4:
                SessionLogInfo sessionLogInfo = this.endUserValue;
                SessionLogInfo sessionLogInfo2 = accessMethodLogInfo.endUserValue;
                return sessionLogInfo == sessionLogInfo2 || sessionLogInfo.equals(sessionLogInfo2);
            case 5:
                WebSessionLogInfo webSessionLogInfo5 = this.enterpriseConsoleValue;
                WebSessionLogInfo webSessionLogInfo6 = accessMethodLogInfo.enterpriseConsoleValue;
                return webSessionLogInfo5 == webSessionLogInfo6 || webSessionLogInfo5.equals(webSessionLogInfo6);
            case 6:
                WebSessionLogInfo webSessionLogInfo7 = this.signInAsValue;
                WebSessionLogInfo webSessionLogInfo8 = accessMethodLogInfo.signInAsValue;
                return webSessionLogInfo7 == webSessionLogInfo8 || webSessionLogInfo7.equals(webSessionLogInfo8);
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AccessMethodLogInfo$1 */
    static /* synthetic */ class C44281 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag = iArr;
            try {
                iArr[Tag.ADMIN_CONSOLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag[Tag.API.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag[Tag.CONTENT_MANAGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag[Tag.END_USER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag[Tag.ENTERPRISE_CONSOLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag[Tag.SIGN_IN_AS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag[Tag.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<AccessMethodLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccessMethodLogInfo accessMethodLogInfo, JsonGenerator jsonGenerator) throws IOException {
            switch (C44281.$SwitchMap$com$dropbox$core$v2$teamlog$AccessMethodLogInfo$Tag[accessMethodLogInfo.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("admin_console", jsonGenerator);
                    WebSessionLogInfo.Serializer.INSTANCE.serialize(accessMethodLogInfo.adminConsoleValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("api", jsonGenerator);
                    ApiSessionLogInfo.Serializer.INSTANCE.serialize(accessMethodLogInfo.apiValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("content_manager", jsonGenerator);
                    WebSessionLogInfo.Serializer.INSTANCE.serialize(accessMethodLogInfo.contentManagerValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 4:
                    jsonGenerator.writeStartObject();
                    writeTag("end_user", jsonGenerator);
                    jsonGenerator.writeFieldName("end_user");
                    SessionLogInfo.Serializer.INSTANCE.serialize(accessMethodLogInfo.endUserValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 5:
                    jsonGenerator.writeStartObject();
                    writeTag("enterprise_console", jsonGenerator);
                    WebSessionLogInfo.Serializer.INSTANCE.serialize(accessMethodLogInfo.enterpriseConsoleValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("sign_in_as", jsonGenerator);
                    WebSessionLogInfo.Serializer.INSTANCE.serialize(accessMethodLogInfo.signInAsValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccessMethodLogInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccessMethodLogInfo accessMethodLogInfoSignInAs;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("admin_console".equals(tag)) {
                accessMethodLogInfoSignInAs = AccessMethodLogInfo.adminConsole(WebSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("api".equals(tag)) {
                accessMethodLogInfoSignInAs = AccessMethodLogInfo.api(ApiSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("content_manager".equals(tag)) {
                accessMethodLogInfoSignInAs = AccessMethodLogInfo.contentManager(WebSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("end_user".equals(tag)) {
                expectField("end_user", jsonParser);
                accessMethodLogInfoSignInAs = AccessMethodLogInfo.endUser(SessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("enterprise_console".equals(tag)) {
                accessMethodLogInfoSignInAs = AccessMethodLogInfo.enterpriseConsole(WebSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("sign_in_as".equals(tag)) {
                accessMethodLogInfoSignInAs = AccessMethodLogInfo.signInAs(WebSessionLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                accessMethodLogInfoSignInAs = AccessMethodLogInfo.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accessMethodLogInfoSignInAs;
        }
    }
}
