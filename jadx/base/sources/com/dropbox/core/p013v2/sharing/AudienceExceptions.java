package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AudienceExceptionContentInfo;
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

/* JADX INFO: loaded from: classes4.dex */
public class AudienceExceptions {
    protected final long count;

    @Nonnull
    protected final List<AudienceExceptionContentInfo> exceptions;

    public AudienceExceptions(long j, @Nonnull List<AudienceExceptionContentInfo> list) {
        this.count = j;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'exceptions' is null");
        }
        Iterator<AudienceExceptionContentInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'exceptions' is null");
            }
        }
        this.exceptions = list;
    }

    public long getCount() {
        return this.count;
    }

    @Nonnull
    public List<AudienceExceptionContentInfo> getExceptions() {
        return this.exceptions;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.count), this.exceptions});
    }

    public boolean equals(Object obj) {
        List<AudienceExceptionContentInfo> list;
        List<AudienceExceptionContentInfo> list2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            AudienceExceptions audienceExceptions = (AudienceExceptions) obj;
            if (this.count == audienceExceptions.count && ((list = this.exceptions) == (list2 = audienceExceptions.exceptions) || list.equals(list2))) {
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

    static class Serializer extends StructSerializer<AudienceExceptions> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AudienceExceptions audienceExceptions, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("count");
            StoneSerializers.uInt32().serialize(Long.valueOf(audienceExceptions.count), jsonGenerator);
            jsonGenerator.writeFieldName("exceptions");
            StoneSerializers.list(AudienceExceptionContentInfo.Serializer.INSTANCE).serialize(audienceExceptions.exceptions, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AudienceExceptions deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
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
                    if ("count".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else if ("exceptions".equals(currentName)) {
                        list = (List) StoneSerializers.list(AudienceExceptionContentInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"count\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"exceptions\" missing.");
                }
                AudienceExceptions audienceExceptions = new AudienceExceptions(lDeserialize.longValue(), list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(audienceExceptions, audienceExceptions.toStringMultiline());
                return audienceExceptions;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
