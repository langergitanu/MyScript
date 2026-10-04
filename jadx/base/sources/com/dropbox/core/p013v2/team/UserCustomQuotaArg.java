package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserSelectorArg;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class UserCustomQuotaArg {
    protected final long quotaGb;

    @Nonnull
    protected final UserSelectorArg user;

    public UserCustomQuotaArg(@Nonnull UserSelectorArg userSelectorArg, long j) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (j < 15) {
            throw new IllegalArgumentException("Number 'quotaGb' is smaller than 15L");
        }
        this.quotaGb = j;
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    public long getQuotaGb() {
        return this.quotaGb;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, Long.valueOf(this.quotaGb)});
    }

    public boolean equals(Object obj) {
        UserCustomQuotaArg userCustomQuotaArg;
        UserSelectorArg userSelectorArg;
        UserSelectorArg userSelectorArg2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((userSelectorArg = this.user) == (userSelectorArg2 = (userCustomQuotaArg = (UserCustomQuotaArg) obj).user) || userSelectorArg.equals(userSelectorArg2)) && this.quotaGb == userCustomQuotaArg.quotaGb;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserCustomQuotaArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserCustomQuotaArg userCustomQuotaArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(userCustomQuotaArg.user, jsonGenerator);
            jsonGenerator.writeFieldName("quota_gb");
            StoneSerializers.uInt32().serialize(Long.valueOf(userCustomQuotaArg.quotaGb), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserCustomQuotaArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("quota_gb".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"quota_gb\" missing.");
                }
                UserCustomQuotaArg userCustomQuotaArg = new UserCustomQuotaArg(userSelectorArgDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userCustomQuotaArg, userCustomQuotaArg.toStringMultiline());
                return userCustomQuotaArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
