package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.RevokeDeviceSessionArg;
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
class RevokeDeviceSessionBatchArg {

    @Nonnull
    protected final List<RevokeDeviceSessionArg> revokeDevices;

    public RevokeDeviceSessionBatchArg(@Nonnull List<RevokeDeviceSessionArg> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'revokeDevices' is null");
        }
        Iterator<RevokeDeviceSessionArg> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'revokeDevices' is null");
            }
        }
        this.revokeDevices = list;
    }

    @Nonnull
    public List<RevokeDeviceSessionArg> getRevokeDevices() {
        return this.revokeDevices;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.revokeDevices});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<RevokeDeviceSessionArg> list = this.revokeDevices;
        List<RevokeDeviceSessionArg> list2 = ((RevokeDeviceSessionBatchArg) obj).revokeDevices;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RevokeDeviceSessionBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RevokeDeviceSessionBatchArg revokeDeviceSessionBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("revoke_devices");
            StoneSerializers.list(RevokeDeviceSessionArg.Serializer.INSTANCE).serialize(revokeDeviceSessionBatchArg.revokeDevices, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RevokeDeviceSessionBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("revoke_devices".equals(currentName)) {
                        list = (List) StoneSerializers.list(RevokeDeviceSessionArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"revoke_devices\" missing.");
                }
                RevokeDeviceSessionBatchArg revokeDeviceSessionBatchArg = new RevokeDeviceSessionBatchArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(revokeDeviceSessionBatchArg, revokeDeviceSessionBatchArg.toStringMultiline());
                return revokeDeviceSessionBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
