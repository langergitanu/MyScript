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
class DeleteSecondaryEmailsArg {

    @Nonnull
    protected final List<UserSecondaryEmailsArg> emailsToDelete;

    public DeleteSecondaryEmailsArg(@Nonnull List<UserSecondaryEmailsArg> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'emailsToDelete' is null");
        }
        Iterator<UserSecondaryEmailsArg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'emailsToDelete' is null");
            }
        }
        this.emailsToDelete = list;
    }

    @Nonnull
    public List<UserSecondaryEmailsArg> getEmailsToDelete() {
        return this.emailsToDelete;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.emailsToDelete});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<UserSecondaryEmailsArg> list = this.emailsToDelete;
        List<UserSecondaryEmailsArg> list2 = ((DeleteSecondaryEmailsArg) obj).emailsToDelete;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeleteSecondaryEmailsArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeleteSecondaryEmailsArg deleteSecondaryEmailsArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("emails_to_delete");
            StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).serialize(deleteSecondaryEmailsArg.emailsToDelete, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DeleteSecondaryEmailsArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("emails_to_delete".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"emails_to_delete\" missing.");
                }
                DeleteSecondaryEmailsArg deleteSecondaryEmailsArg = new DeleteSecondaryEmailsArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deleteSecondaryEmailsArg, deleteSecondaryEmailsArg.toStringMultiline());
                return deleteSecondaryEmailsArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
