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
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class UserSecondaryEmailsArg {

    @Nonnull
    protected final List<String> secondaryEmails;

    @Nonnull
    protected final UserSelectorArg user;

    public UserSecondaryEmailsArg(@Nonnull UserSelectorArg userSelectorArg, @Nonnull List<String> list) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'secondaryEmails' is null");
        }
        for (String str : list) {
            if (str == null) {
                throw new IllegalArgumentException("An item in list 'secondaryEmails' is null");
            }
            if (str.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list 'secondaryEmails' is longer than 255");
            }
            if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
                throw new IllegalArgumentException("Stringan item in list 'secondaryEmails' does not match pattern");
            }
        }
        this.secondaryEmails = list;
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nonnull
    public List<String> getSecondaryEmails() {
        return this.secondaryEmails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.secondaryEmails});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserSecondaryEmailsArg userSecondaryEmailsArg = (UserSecondaryEmailsArg) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = userSecondaryEmailsArg.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((list = this.secondaryEmails) == (list2 = userSecondaryEmailsArg.secondaryEmails) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserSecondaryEmailsArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserSecondaryEmailsArg userSecondaryEmailsArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(userSecondaryEmailsArg.user, jsonGenerator);
            jsonGenerator.writeFieldName("secondary_emails");
            StoneSerializers.list(StoneSerializers.string()).serialize(userSecondaryEmailsArg.secondaryEmails, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserSecondaryEmailsArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("secondary_emails".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"secondary_emails\" missing.");
                }
                UserSecondaryEmailsArg userSecondaryEmailsArg = new UserSecondaryEmailsArg(userSelectorArgDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userSecondaryEmailsArg, userSecondaryEmailsArg.toStringMultiline());
                return userSecondaryEmailsArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
