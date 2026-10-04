package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.RevokeLinkedApiAppArg;
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
class RevokeLinkedApiAppBatchArg {

    @Nonnull
    protected final List<RevokeLinkedApiAppArg> revokeLinkedApp;

    public RevokeLinkedApiAppBatchArg(@Nonnull List<RevokeLinkedApiAppArg> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'revokeLinkedApp' is null");
        }
        Iterator<RevokeLinkedApiAppArg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'revokeLinkedApp' is null");
            }
        }
        this.revokeLinkedApp = list;
    }

    @Nonnull
    public List<RevokeLinkedApiAppArg> getRevokeLinkedApp() {
        return this.revokeLinkedApp;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.revokeLinkedApp});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<RevokeLinkedApiAppArg> list = this.revokeLinkedApp;
        List<RevokeLinkedApiAppArg> list2 = ((RevokeLinkedApiAppBatchArg) obj).revokeLinkedApp;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RevokeLinkedApiAppBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RevokeLinkedApiAppBatchArg revokeLinkedApiAppBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("revoke_linked_app");
            StoneSerializers.list(RevokeLinkedApiAppArg.Serializer.INSTANCE).serialize(revokeLinkedApiAppBatchArg.revokeLinkedApp, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RevokeLinkedApiAppBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("revoke_linked_app".equals(currentName)) {
                        list = (List) StoneSerializers.list(RevokeLinkedApiAppArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"revoke_linked_app\" missing.");
                }
                RevokeLinkedApiAppBatchArg revokeLinkedApiAppBatchArg = new RevokeLinkedApiAppBatchArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(revokeLinkedApiAppBatchArg, revokeLinkedApiAppBatchArg.toStringMultiline());
                return revokeLinkedApiAppBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
