package com.dropbox.core.p013v2.teamlog;

import aws.sdk.kotlin.runtime.auth.credentials.profile.ProfileChainKt;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GroupLogInfo {

    @Nonnull
    protected final String displayName;

    @Nullable
    protected final String externalId;

    @Nullable
    protected final String groupId;

    public GroupLogInfo(@Nonnull String str, @Nullable String str2, @Nullable String str3) {
        this.groupId = str2;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = str;
        this.externalId = str3;
    }

    public GroupLogInfo(@Nonnull String str) {
        this(str, null, null);
    }

    @Nonnull
    public String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public String getExternalId() {
        return this.externalId;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected final String displayName;
        protected String externalId;
        protected String groupId;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'displayName' is null");
            }
            this.displayName = str;
            this.groupId = null;
            this.externalId = null;
        }

        public Builder withGroupId(String str) {
            this.groupId = str;
            return this;
        }

        public Builder withExternalId(String str) {
            this.externalId = str;
            return this;
        }

        public GroupLogInfo build() {
            return new GroupLogInfo(this.displayName, this.groupId, this.externalId);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.groupId, this.displayName, this.externalId});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GroupLogInfo groupLogInfo = (GroupLogInfo) obj;
        String str5 = this.displayName;
        String str6 = groupLogInfo.displayName;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.groupId) == (str2 = groupLogInfo.groupId) || (str != null && str.equals(str2))) && ((str3 = this.externalId) == (str4 = groupLogInfo.externalId) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupLogInfo groupLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
            StoneSerializers.string().serialize(groupLogInfo.displayName, jsonGenerator);
            if (groupLogInfo.groupId != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.GROUP_ID);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupLogInfo.groupId, jsonGenerator);
            }
            if (groupLogInfo.externalId != null) {
                jsonGenerator.writeFieldName(ProfileChainKt.EXTERNAL_ID);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(groupLogInfo.externalId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (Keys.DISPLAY_NAME.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.GROUP_ID.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (ProfileChainKt.EXTERNAL_ID.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"display_name\" missing.");
                }
                GroupLogInfo groupLogInfo = new GroupLogInfo(strDeserialize, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupLogInfo, groupLogInfo.toStringMultiline());
                return groupLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
