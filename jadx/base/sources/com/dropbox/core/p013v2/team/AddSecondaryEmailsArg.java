package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserSecondaryEmailsArg;
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
class AddSecondaryEmailsArg {

    @Nonnull
    protected final List<UserSecondaryEmailsArg> newSecondaryEmails;

    public AddSecondaryEmailsArg(@Nonnull List<UserSecondaryEmailsArg> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'newSecondaryEmails' is null");
        }
        Iterator<UserSecondaryEmailsArg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'newSecondaryEmails' is null");
            }
        }
        this.newSecondaryEmails = list;
    }

    @Nonnull
    public List<UserSecondaryEmailsArg> getNewSecondaryEmails() {
        return this.newSecondaryEmails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newSecondaryEmails});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<UserSecondaryEmailsArg> list = this.newSecondaryEmails;
        List<UserSecondaryEmailsArg> list2 = ((AddSecondaryEmailsArg) obj).newSecondaryEmails;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AddSecondaryEmailsArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AddSecondaryEmailsArg addSecondaryEmailsArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_secondary_emails");
            StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).serialize(addSecondaryEmailsArg.newSecondaryEmails, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AddSecondaryEmailsArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_secondary_emails".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_secondary_emails\" missing.");
                }
                AddSecondaryEmailsArg addSecondaryEmailsArg = new AddSecondaryEmailsArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(addSecondaryEmailsArg, addSecondaryEmailsArg.toStringMultiline());
                return addSecondaryEmailsArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
