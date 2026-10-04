package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.RevokeDeviceSessionStatus;
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
public class RevokeDeviceSessionBatchResult {

    @Nonnull
    protected final List<RevokeDeviceSessionStatus> revokeDevicesStatus;

    public RevokeDeviceSessionBatchResult(@Nonnull List<RevokeDeviceSessionStatus> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'revokeDevicesStatus' is null");
        }
        Iterator<RevokeDeviceSessionStatus> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'revokeDevicesStatus' is null");
            }
        }
        this.revokeDevicesStatus = list;
    }

    @Nonnull
    public List<RevokeDeviceSessionStatus> getRevokeDevicesStatus() {
        return this.revokeDevicesStatus;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.revokeDevicesStatus});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<RevokeDeviceSessionStatus> list = this.revokeDevicesStatus;
        List<RevokeDeviceSessionStatus> list2 = ((RevokeDeviceSessionBatchResult) obj).revokeDevicesStatus;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RevokeDeviceSessionBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RevokeDeviceSessionBatchResult revokeDeviceSessionBatchResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("revoke_devices_status");
            StoneSerializers.list(RevokeDeviceSessionStatus.Serializer.INSTANCE).serialize(revokeDeviceSessionBatchResult.revokeDevicesStatus, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RevokeDeviceSessionBatchResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("revoke_devices_status".equals(currentName)) {
                        list = (List) StoneSerializers.list(RevokeDeviceSessionStatus.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"revoke_devices_status\" missing.");
                }
                RevokeDeviceSessionBatchResult revokeDeviceSessionBatchResult = new RevokeDeviceSessionBatchResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(revokeDeviceSessionBatchResult, revokeDeviceSessionBatchResult.toStringMultiline());
                return revokeDeviceSessionBatchResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
