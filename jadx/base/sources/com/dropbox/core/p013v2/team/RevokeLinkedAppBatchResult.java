package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.RevokeLinkedAppStatus;
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
public class RevokeLinkedAppBatchResult {

    @Nonnull
    protected final List<RevokeLinkedAppStatus> revokeLinkedAppStatus;

    public RevokeLinkedAppBatchResult(@Nonnull List<RevokeLinkedAppStatus> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'revokeLinkedAppStatus' is null");
        }
        Iterator<RevokeLinkedAppStatus> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'revokeLinkedAppStatus' is null");
            }
        }
        this.revokeLinkedAppStatus = list;
    }

    @Nonnull
    public List<RevokeLinkedAppStatus> getRevokeLinkedAppStatus() {
        return this.revokeLinkedAppStatus;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.revokeLinkedAppStatus});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<RevokeLinkedAppStatus> list = this.revokeLinkedAppStatus;
        List<RevokeLinkedAppStatus> list2 = ((RevokeLinkedAppBatchResult) obj).revokeLinkedAppStatus;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RevokeLinkedAppBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RevokeLinkedAppBatchResult revokeLinkedAppBatchResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("revoke_linked_app_status");
            StoneSerializers.list(RevokeLinkedAppStatus.Serializer.INSTANCE).serialize(revokeLinkedAppBatchResult.revokeLinkedAppStatus, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RevokeLinkedAppBatchResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("revoke_linked_app_status".equals(currentName)) {
                        list = (List) StoneSerializers.list(RevokeLinkedAppStatus.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"revoke_linked_app_status\" missing.");
                }
                RevokeLinkedAppBatchResult revokeLinkedAppBatchResult = new RevokeLinkedAppBatchResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(revokeLinkedAppBatchResult, revokeLinkedAppBatchResult.toStringMultiline());
                return revokeLinkedAppBatchResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
