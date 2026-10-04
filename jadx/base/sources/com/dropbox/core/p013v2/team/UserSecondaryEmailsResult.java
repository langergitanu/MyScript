package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.AddSecondaryEmailResult;
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
public class UserSecondaryEmailsResult {

    @Nonnull
    protected final List<AddSecondaryEmailResult> results;

    @Nonnull
    protected final UserSelectorArg user;

    public UserSecondaryEmailsResult(@Nonnull UserSelectorArg userSelectorArg, @Nonnull List<AddSecondaryEmailResult> list) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'results' is null");
        }
        Iterator<AddSecondaryEmailResult> it = list.iterator();
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
    public List<AddSecondaryEmailResult> getResults() {
        return this.results;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.results});
    }

    public boolean equals(Object obj) {
        List<AddSecondaryEmailResult> list;
        List<AddSecondaryEmailResult> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserSecondaryEmailsResult userSecondaryEmailsResult = (UserSecondaryEmailsResult) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = userSecondaryEmailsResult.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((list = this.results) == (list2 = userSecondaryEmailsResult.results) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserSecondaryEmailsResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserSecondaryEmailsResult userSecondaryEmailsResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(userSecondaryEmailsResult.user, jsonGenerator);
            jsonGenerator.writeFieldName("results");
            StoneSerializers.list(AddSecondaryEmailResult.Serializer.INSTANCE).serialize(userSecondaryEmailsResult.results, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserSecondaryEmailsResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                        list = (List) StoneSerializers.list(AddSecondaryEmailResult.Serializer.INSTANCE).deserialize(jsonParser);
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
                UserSecondaryEmailsResult userSecondaryEmailsResult = new UserSecondaryEmailsResult(userSelectorArgDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userSecondaryEmailsResult, userSecondaryEmailsResult.toStringMultiline());
                return userSecondaryEmailsResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
