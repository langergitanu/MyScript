package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserCustomQuotaArg;
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
class SetCustomQuotaArg {

    @Nonnull
    protected final List<UserCustomQuotaArg> usersAndQuotas;

    public SetCustomQuotaArg(@Nonnull List<UserCustomQuotaArg> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'usersAndQuotas' is null");
        }
        Iterator<UserCustomQuotaArg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'usersAndQuotas' is null");
            }
        }
        this.usersAndQuotas = list;
    }

    @Nonnull
    public List<UserCustomQuotaArg> getUsersAndQuotas() {
        return this.usersAndQuotas;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.usersAndQuotas});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<UserCustomQuotaArg> list = this.usersAndQuotas;
        List<UserCustomQuotaArg> list2 = ((SetCustomQuotaArg) obj).usersAndQuotas;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SetCustomQuotaArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SetCustomQuotaArg setCustomQuotaArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("users_and_quotas");
            StoneSerializers.list(UserCustomQuotaArg.Serializer.INSTANCE).serialize(setCustomQuotaArg.usersAndQuotas, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SetCustomQuotaArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("users_and_quotas".equals(currentName)) {
                        list = (List) StoneSerializers.list(UserCustomQuotaArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"users_and_quotas\" missing.");
                }
                SetCustomQuotaArg setCustomQuotaArg = new SetCustomQuotaArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(setCustomQuotaArg, setCustomQuotaArg.toStringMultiline());
                return setCustomQuotaArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
