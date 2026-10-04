package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AppLogInfo;
import com.dropbox.core.p013v2.teamlog.ResellerLogInfo;
import com.dropbox.core.p013v2.teamlog.UserLogInfo;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.myscript.nebo.LaunchActivity;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class ActorLogInfo {
    public static final ActorLogInfo ANONYMOUS = new ActorLogInfo().withTag(Tag.ANONYMOUS);
    public static final ActorLogInfo DROPBOX = new ActorLogInfo().withTag(Tag.DROPBOX);
    public static final ActorLogInfo OTHER = new ActorLogInfo().withTag(Tag.OTHER);
    private Tag _tag;
    private UserLogInfo adminValue;
    private AppLogInfo appValue;
    private ResellerLogInfo resellerValue;
    private UserLogInfo userValue;

    public enum Tag {
        ADMIN,
        ANONYMOUS,
        APP,
        DROPBOX,
        RESELLER,
        USER,
        OTHER
    }

    private ActorLogInfo() {
    }

    private ActorLogInfo withTag(Tag tag) {
        ActorLogInfo actorLogInfo = new ActorLogInfo();
        actorLogInfo._tag = tag;
        return actorLogInfo;
    }

    private ActorLogInfo withTagAndAdmin(Tag tag, UserLogInfo userLogInfo) {
        ActorLogInfo actorLogInfo = new ActorLogInfo();
        actorLogInfo._tag = tag;
        actorLogInfo.adminValue = userLogInfo;
        return actorLogInfo;
    }

    private ActorLogInfo withTagAndApp(Tag tag, AppLogInfo appLogInfo) {
        ActorLogInfo actorLogInfo = new ActorLogInfo();
        actorLogInfo._tag = tag;
        actorLogInfo.appValue = appLogInfo;
        return actorLogInfo;
    }

    private ActorLogInfo withTagAndReseller(Tag tag, ResellerLogInfo resellerLogInfo) {
        ActorLogInfo actorLogInfo = new ActorLogInfo();
        actorLogInfo._tag = tag;
        actorLogInfo.resellerValue = resellerLogInfo;
        return actorLogInfo;
    }

    private ActorLogInfo withTagAndUser(Tag tag, UserLogInfo userLogInfo) {
        ActorLogInfo actorLogInfo = new ActorLogInfo();
        actorLogInfo._tag = tag;
        actorLogInfo.userValue = userLogInfo;
        return actorLogInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAdmin() {
        return this._tag == Tag.ADMIN;
    }

    public static ActorLogInfo admin(UserLogInfo userLogInfo) {
        if (userLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActorLogInfo().withTagAndAdmin(Tag.ADMIN, userLogInfo);
    }

    public UserLogInfo getAdminValue() {
        if (this._tag != Tag.ADMIN) {
            throw new IllegalStateException("Invalid tag: required Tag.ADMIN, but was Tag." + this._tag.name());
        }
        return this.adminValue;
    }

    public boolean isAnonymous() {
        return this._tag == Tag.ANONYMOUS;
    }

    public boolean isApp() {
        return this._tag == Tag.APP;
    }

    public static ActorLogInfo app(AppLogInfo appLogInfo) {
        if (appLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActorLogInfo().withTagAndApp(Tag.APP, appLogInfo);
    }

    public AppLogInfo getAppValue() {
        if (this._tag != Tag.APP) {
            throw new IllegalStateException("Invalid tag: required Tag.APP, but was Tag." + this._tag.name());
        }
        return this.appValue;
    }

    public boolean isDropbox() {
        return this._tag == Tag.DROPBOX;
    }

    public boolean isReseller() {
        return this._tag == Tag.RESELLER;
    }

    public static ActorLogInfo reseller(ResellerLogInfo resellerLogInfo) {
        if (resellerLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActorLogInfo().withTagAndReseller(Tag.RESELLER, resellerLogInfo);
    }

    public ResellerLogInfo getResellerValue() {
        if (this._tag != Tag.RESELLER) {
            throw new IllegalStateException("Invalid tag: required Tag.RESELLER, but was Tag." + this._tag.name());
        }
        return this.resellerValue;
    }

    public boolean isUser() {
        return this._tag == Tag.USER;
    }

    public static ActorLogInfo user(UserLogInfo userLogInfo) {
        if (userLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActorLogInfo().withTagAndUser(Tag.USER, userLogInfo);
    }

    public UserLogInfo getUserValue() {
        if (this._tag != Tag.USER) {
            throw new IllegalStateException("Invalid tag: required Tag.USER, but was Tag." + this._tag.name());
        }
        return this.userValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.adminValue, this.appValue, this.resellerValue, this.userValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ActorLogInfo)) {
            return false;
        }
        ActorLogInfo actorLogInfo = (ActorLogInfo) obj;
        if (this._tag != actorLogInfo._tag) {
            return false;
        }
        switch (C44341.$SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag[this._tag.ordinal()]) {
            case 1:
                UserLogInfo userLogInfo = this.adminValue;
                UserLogInfo userLogInfo2 = actorLogInfo.adminValue;
                return userLogInfo == userLogInfo2 || userLogInfo.equals(userLogInfo2);
            case 3:
                AppLogInfo appLogInfo = this.appValue;
                AppLogInfo appLogInfo2 = actorLogInfo.appValue;
                if (appLogInfo != appLogInfo2 && !appLogInfo.equals(appLogInfo2)) {
                    return false;
                }
            case 2:
                return true;
            case 5:
                ResellerLogInfo resellerLogInfo = this.resellerValue;
                ResellerLogInfo resellerLogInfo2 = actorLogInfo.resellerValue;
                if (resellerLogInfo != resellerLogInfo2 && !resellerLogInfo.equals(resellerLogInfo2)) {
                    return false;
                }
            case 4:
                return true;
            case 6:
                UserLogInfo userLogInfo3 = this.userValue;
                UserLogInfo userLogInfo4 = actorLogInfo.userValue;
                return userLogInfo3 == userLogInfo4 || userLogInfo3.equals(userLogInfo4);
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.ActorLogInfo$1 */
    static /* synthetic */ class C44341 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag = iArr;
            try {
                iArr[Tag.ADMIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag[Tag.ANONYMOUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag[Tag.APP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag[Tag.DROPBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag[Tag.RESELLER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag[Tag.USER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag[Tag.OTHER.ordinal()] = 7;
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

    static class Serializer extends UnionSerializer<ActorLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ActorLogInfo actorLogInfo, JsonGenerator jsonGenerator) throws IOException {
            switch (C44341.$SwitchMap$com$dropbox$core$v2$teamlog$ActorLogInfo$Tag[actorLogInfo.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("admin", jsonGenerator);
                    jsonGenerator.writeFieldName("admin");
                    UserLogInfo.Serializer.INSTANCE.serialize(actorLogInfo.adminValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("anonymous");
                    break;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag(LaunchActivity.LaunchRoute.App, jsonGenerator);
                    jsonGenerator.writeFieldName(LaunchActivity.LaunchRoute.App);
                    AppLogInfo.Serializer.INSTANCE.serialize(actorLogInfo.appValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 4:
                    jsonGenerator.writeString("dropbox");
                    break;
                case 5:
                    jsonGenerator.writeStartObject();
                    writeTag("reseller", jsonGenerator);
                    ResellerLogInfo.Serializer.INSTANCE.serialize(actorLogInfo.resellerValue, jsonGenerator, true);
                    jsonGenerator.writeEndObject();
                    break;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("user", jsonGenerator);
                    jsonGenerator.writeFieldName("user");
                    UserLogInfo.Serializer.INSTANCE.serialize(actorLogInfo.userValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ActorLogInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ActorLogInfo actorLogInfoUser;
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
            if ("admin".equals(tag)) {
                expectField("admin", jsonParser);
                actorLogInfoUser = ActorLogInfo.admin(UserLogInfo.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("anonymous".equals(tag)) {
                actorLogInfoUser = ActorLogInfo.ANONYMOUS;
            } else if (LaunchActivity.LaunchRoute.App.equals(tag)) {
                expectField(LaunchActivity.LaunchRoute.App, jsonParser);
                actorLogInfoUser = ActorLogInfo.app(AppLogInfo.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("dropbox".equals(tag)) {
                actorLogInfoUser = ActorLogInfo.DROPBOX;
            } else if ("reseller".equals(tag)) {
                actorLogInfoUser = ActorLogInfo.reseller(ResellerLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("user".equals(tag)) {
                expectField("user", jsonParser);
                actorLogInfoUser = ActorLogInfo.user(UserLogInfo.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                actorLogInfoUser = ActorLogInfo.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return actorLogInfoUser;
        }
    }
}
