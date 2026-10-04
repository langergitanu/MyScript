package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.ExternalUserLogInfo;
import com.dropbox.core.p013v2.teamlog.UserLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SharedLinkShareDetails {

    @Nullable
    protected final List<ExternalUserLogInfo> externalUsers;

    @Nullable
    protected final UserLogInfo sharedLinkOwner;

    public SharedLinkShareDetails(@Nullable UserLogInfo userLogInfo, @Nullable List<ExternalUserLogInfo> list) {
        this.sharedLinkOwner = userLogInfo;
        if (list != null) {
            Iterator<ExternalUserLogInfo> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'externalUsers' is null");
                }
            }
        }
        this.externalUsers = list;
    }

    public SharedLinkShareDetails() {
        this(null, null);
    }

    @Nullable
    public UserLogInfo getSharedLinkOwner() {
        return this.sharedLinkOwner;
    }

    @Nullable
    public List<ExternalUserLogInfo> getExternalUsers() {
        return this.externalUsers;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected UserLogInfo sharedLinkOwner = null;
        protected List<ExternalUserLogInfo> externalUsers = null;

        protected Builder() {
        }

        public Builder withSharedLinkOwner(UserLogInfo userLogInfo) {
            this.sharedLinkOwner = userLogInfo;
            return this;
        }

        public Builder withExternalUsers(List<ExternalUserLogInfo> list) {
            if (list != null) {
                Iterator<ExternalUserLogInfo> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'externalUsers' is null");
                    }
                }
            }
            this.externalUsers = list;
            return this;
        }

        public SharedLinkShareDetails build() {
            return new SharedLinkShareDetails(this.sharedLinkOwner, this.externalUsers);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedLinkOwner, this.externalUsers});
    }

    public boolean equals(Object obj) {
        List<ExternalUserLogInfo> list;
        List<ExternalUserLogInfo> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedLinkShareDetails sharedLinkShareDetails = (SharedLinkShareDetails) obj;
        UserLogInfo userLogInfo = this.sharedLinkOwner;
        UserLogInfo userLogInfo2 = sharedLinkShareDetails.sharedLinkOwner;
        return (userLogInfo == userLogInfo2 || (userLogInfo != null && userLogInfo.equals(userLogInfo2))) && ((list = this.externalUsers) == (list2 = sharedLinkShareDetails.externalUsers) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkShareDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkShareDetails sharedLinkShareDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedLinkShareDetails.sharedLinkOwner != null) {
                jsonGenerator.writeFieldName("shared_link_owner");
                StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).serialize(sharedLinkShareDetails.sharedLinkOwner, jsonGenerator);
            }
            if (sharedLinkShareDetails.externalUsers != null) {
                jsonGenerator.writeFieldName("external_users");
                StoneSerializers.nullable(StoneSerializers.list(ExternalUserLogInfo.Serializer.INSTANCE)).serialize(sharedLinkShareDetails.externalUsers, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkShareDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserLogInfo userLogInfo = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_link_owner".equals(currentName)) {
                        userLogInfo = (UserLogInfo) StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("external_users".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(ExternalUserLogInfo.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedLinkShareDetails sharedLinkShareDetails = new SharedLinkShareDetails(userLogInfo, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkShareDetails, sharedLinkShareDetails.toStringMultiline());
                return sharedLinkShareDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
