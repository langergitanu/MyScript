package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AppLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class UserOrTeamLinkedAppLogInfo extends AppLogInfo {
    public UserOrTeamLinkedAppLogInfo(@Nullable String str, @Nullable String str2) {
        super(str, str2);
    }

    public UserOrTeamLinkedAppLogInfo() {
        this(null, null);
    }

    @Override // com.dropbox.core.p013v2.teamlog.AppLogInfo
    @Nullable
    public String getAppId() {
        return this.appId;
    }

    @Override // com.dropbox.core.p013v2.teamlog.AppLogInfo
    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder extends AppLogInfo.Builder {
        protected Builder() {
        }

        @Override // com.dropbox.core.v2.teamlog.AppLogInfo.Builder
        public Builder withAppId(String str) {
            super.withAppId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.AppLogInfo.Builder
        public Builder withDisplayName(String str) {
            super.withDisplayName(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.AppLogInfo.Builder
        public UserOrTeamLinkedAppLogInfo build() {
            return new UserOrTeamLinkedAppLogInfo(this.appId, this.displayName);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.AppLogInfo
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.teamlog.AppLogInfo
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserOrTeamLinkedAppLogInfo userOrTeamLinkedAppLogInfo = (UserOrTeamLinkedAppLogInfo) obj;
        return (this.appId == userOrTeamLinkedAppLogInfo.appId || (this.appId != null && this.appId.equals(userOrTeamLinkedAppLogInfo.appId))) && (this.displayName == userOrTeamLinkedAppLogInfo.displayName || (this.displayName != null && this.displayName.equals(userOrTeamLinkedAppLogInfo.displayName)));
    }

    @Override // com.dropbox.core.p013v2.teamlog.AppLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.AppLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserOrTeamLinkedAppLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserOrTeamLinkedAppLogInfo userOrTeamLinkedAppLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("user_or_team_linked_app", jsonGenerator);
            if (userOrTeamLinkedAppLogInfo.appId != null) {
                jsonGenerator.writeFieldName("app_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userOrTeamLinkedAppLogInfo.appId, jsonGenerator);
            }
            if (userOrTeamLinkedAppLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userOrTeamLinkedAppLogInfo.displayName, jsonGenerator);
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
        public UserOrTeamLinkedAppLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("user_or_team_linked_app".equals(tag)) {
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
                UserOrTeamLinkedAppLogInfo userOrTeamLinkedAppLogInfo = new UserOrTeamLinkedAppLogInfo(str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userOrTeamLinkedAppLogInfo, userOrTeamLinkedAppLogInfo.toStringMultiline());
                return userOrTeamLinkedAppLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
