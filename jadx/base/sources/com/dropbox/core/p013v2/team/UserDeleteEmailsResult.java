package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.DeleteSecondaryEmailResult;
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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class UserDeleteEmailsResult {

    @Nonnull
    protected final List<DeleteSecondaryEmailResult> results;

    @Nonnull
    protected final UserSelectorArg user;

    public UserDeleteEmailsResult(@Nonnull UserSelectorArg userSelectorArg, @Nonnull List<DeleteSecondaryEmailResult> list) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'results' is null");
        }
        Iterator<DeleteSecondaryEmailResult> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'results' is null");
            }
        }
        this.results = list;
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nonnull
    public List<DeleteSecondaryEmailResult> getResults() {
        return this.results;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.results});
    }

    public boolean equals(Object obj) {
        List<DeleteSecondaryEmailResult> list;
        List<DeleteSecondaryEmailResult> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserDeleteEmailsResult userDeleteEmailsResult = (UserDeleteEmailsResult) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = userDeleteEmailsResult.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((list = this.results) == (list2 = userDeleteEmailsResult.results) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserDeleteEmailsResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserDeleteEmailsResult userDeleteEmailsResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(userDeleteEmailsResult.user, jsonGenerator);
            jsonGenerator.writeFieldName("results");
            StoneSerializers.list(DeleteSecondaryEmailResult.Serializer.INSTANCE).serialize(userDeleteEmailsResult.results, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserDeleteEmailsResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
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
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("results".equals(currentName)) {
                        list = (List) StoneSerializers.list(DeleteSecondaryEmailResult.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"results\" missing.");
                }
                UserDeleteEmailsResult userDeleteEmailsResult = new UserDeleteEmailsResult(userSelectorArgDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userDeleteEmailsResult, userDeleteEmailsResult.toStringMultiline());
                return userDeleteEmailsResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
