package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ListFolderLongpollResult {

    @Nullable
    protected final Long backoff;
    protected final boolean changes;

    public ListFolderLongpollResult(boolean z, @Nullable Long l) {
        this.changes = z;
        this.backoff = l;
    }

    public ListFolderLongpollResult(boolean z) {
        this(z, null);
    }

    public boolean getChanges() {
        return this.changes;
    }

    @Nullable
    public Long getBackoff() {
        return this.backoff;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.changes), this.backoff});
    }

    public boolean equals(Object obj) {
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            ListFolderLongpollResult listFolderLongpollResult = (ListFolderLongpollResult) obj;
            if (this.changes == listFolderLongpollResult.changes && ((l = this.backoff) == (l2 = listFolderLongpollResult.backoff) || (l != null && l.equals(l2)))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFolderLongpollResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFolderLongpollResult listFolderLongpollResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("changes");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listFolderLongpollResult.changes), jsonGenerator);
            if (listFolderLongpollResult.backoff != null) {
                jsonGenerator.writeFieldName("backoff");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(listFolderLongpollResult.backoff, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFolderLongpollResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long l = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("changes".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("backoff".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"changes\" missing.");
                }
                ListFolderLongpollResult listFolderLongpollResult = new ListFolderLongpollResult(boolDeserialize.booleanValue(), l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFolderLongpollResult, listFolderLongpollResult.toStringMultiline());
                return listFolderLongpollResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
