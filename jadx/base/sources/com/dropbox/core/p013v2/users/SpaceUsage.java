package com.dropbox.core.p013v2.users;

import com.dropbox.core.p013v2.users.SpaceAllocation;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class SpaceUsage {

    @Nonnull
    protected final SpaceAllocation allocation;
    protected final long used;

    public SpaceUsage(long j, @Nonnull SpaceAllocation spaceAllocation) {
        this.used = j;
        if (spaceAllocation == null) {
            throw new IllegalArgumentException("Required value for 'allocation' is null");
        }
        this.allocation = spaceAllocation;
    }

    public long getUsed() {
        return this.used;
    }

    @Nonnull
    public SpaceAllocation getAllocation() {
        return this.allocation;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.used), this.allocation});
    }

    public boolean equals(Object obj) {
        SpaceAllocation spaceAllocation;
        SpaceAllocation spaceAllocation2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            SpaceUsage spaceUsage = (SpaceUsage) obj;
            if (this.used == spaceUsage.used && ((spaceAllocation = this.allocation) == (spaceAllocation2 = spaceUsage.allocation) || spaceAllocation.equals(spaceAllocation2))) {
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

    static class Serializer extends StructSerializer<SpaceUsage> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SpaceUsage spaceUsage, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("used");
            StoneSerializers.uInt64().serialize(Long.valueOf(spaceUsage.used), jsonGenerator);
            jsonGenerator.writeFieldName("allocation");
            SpaceAllocation.Serializer.INSTANCE.serialize(spaceUsage.allocation, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SpaceUsage deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SpaceAllocation spaceAllocationDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("used".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("allocation".equals(currentName)) {
                        spaceAllocationDeserialize = SpaceAllocation.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"used\" missing.");
                }
                if (spaceAllocationDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allocation\" missing.");
                }
                SpaceUsage spaceUsage = new SpaceUsage(lDeserialize.longValue(), spaceAllocationDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(spaceUsage, spaceUsage.toStringMultiline());
                return spaceUsage;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
