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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class UserCustomQuotaResult {

    @Nullable
    protected final Long quotaGb;

    @Nonnull
    protected final UserSelectorArg user;

    public UserCustomQuotaResult(@Nonnull UserSelectorArg userSelectorArg, @Nullable Long l) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (l != null && l.longValue() < 15) {
            throw new IllegalArgumentException("Number 'quotaGb' is smaller than 15L");
        }
        this.quotaGb = l;
    }

    public UserCustomQuotaResult(@Nonnull UserSelectorArg userSelectorArg) {
        this(userSelectorArg, null);
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nullable
    public Long getQuotaGb() {
        return this.quotaGb;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.quotaGb});
    }

    public boolean equals(Object obj) {
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserCustomQuotaResult userCustomQuotaResult = (UserCustomQuotaResult) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = userCustomQuotaResult.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((l = this.quotaGb) == (l2 = userCustomQuotaResult.quotaGb) || (l != null && l.equals(l2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserCustomQuotaResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserCustomQuotaResult userCustomQuotaResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(userCustomQuotaResult.user, jsonGenerator);
            if (userCustomQuotaResult.quotaGb != null) {
                jsonGenerator.writeFieldName("quota_gb");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(userCustomQuotaResult.quotaGb, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserCustomQuotaResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long l = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("quota_gb".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt32()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                UserCustomQuotaResult userCustomQuotaResult = new UserCustomQuotaResult(userSelectorArgDeserialize, l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userCustomQuotaResult, userCustomQuotaResult.toStringMultiline());
                return userCustomQuotaResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
