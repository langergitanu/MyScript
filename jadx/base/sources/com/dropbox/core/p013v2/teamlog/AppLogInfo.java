package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamLinkedAppLogInfo;
import com.dropbox.core.p013v2.teamlog.UserLinkedAppLogInfo;
import com.dropbox.core.p013v2.teamlog.UserOrTeamLinkedAppLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class AppLogInfo {

    @Nullable
    protected final String appId;

    @Nullable
    protected final String displayName;

    public AppLogInfo(@Nullable String str, @Nullable String str2) {
        this.appId = str;
        this.displayName = str2;
    }

    public AppLogInfo() {
        this(null, null);
    }

    @Nullable
    public String getAppId() {
        return this.appId;
    }

    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String appId = null;
        protected String displayName = null;

        protected Builder() {
        }

        public Builder withAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder withDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public AppLogInfo build() {
            return new AppLogInfo(this.appId, this.displayName);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.appId, this.displayName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AppLogInfo appLogInfo = (AppLogInfo) obj;
        String str3 = this.appId;
        String str4 = appLogInfo.appId;
        return (str3 == str4 || (str3 != null && str3.equals(str4))) && ((str = this.displayName) == (str2 = appLogInfo.displayName) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AppLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AppLogInfo appLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (appLogInfo instanceof UserOrTeamLinkedAppLogInfo) {
                UserOrTeamLinkedAppLogInfo.Serializer.INSTANCE.serialize((UserOrTeamLinkedAppLogInfo) appLogInfo, jsonGenerator, z);
                return;
            }
            if (appLogInfo instanceof UserLinkedAppLogInfo) {
                UserLinkedAppLogInfo.Serializer.INSTANCE.serialize((UserLinkedAppLogInfo) appLogInfo, jsonGenerator, z);
                return;
            }
            if (appLogInfo instanceof TeamLinkedAppLogInfo) {
                TeamLinkedAppLogInfo.Serializer.INSTANCE.serialize((TeamLinkedAppLogInfo) appLogInfo, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (appLogInfo.appId != null) {
                jsonGenerator.writeFieldName("app_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(appLogInfo.appId, jsonGenerator);
            }
            if (appLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(appLogInfo.displayName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AppLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AppLogInfo appLogInfoDeserialize;
            String str = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("app_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                appLogInfoDeserialize = new AppLogInfo(str, str2);
            } else if ("".equals(tag)) {
                appLogInfoDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if ("user_or_team_linked_app".equals(tag)) {
                appLogInfoDeserialize = UserOrTeamLinkedAppLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("user_linked_app".equals(tag)) {
                appLogInfoDeserialize = UserLinkedAppLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("team_linked_app".equals(tag)) {
                appLogInfoDeserialize = TeamLinkedAppLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(appLogInfoDeserialize, appLogInfoDeserialize.toStringMultiline());
            return appLogInfoDeserialize;
        }
    }
}
