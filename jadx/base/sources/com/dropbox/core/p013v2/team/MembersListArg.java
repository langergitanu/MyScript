package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class MembersListArg {
    protected final boolean includeRemoved;
    protected final long limit;

    public MembersListArg(long j, boolean z) {
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = j;
        this.includeRemoved = z;
    }

    public MembersListArg() {
        this(1000L, false);
    }

    public long getLimit() {
        return this.limit;
    }

    public boolean getIncludeRemoved() {
        return this.includeRemoved;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected long limit = 1000;
        protected boolean includeRemoved = false;

        protected Builder() {
        }

        public Builder withLimit(Long l) {
            if (l.longValue() < 1) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (l.longValue() > 1000) {
                throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
            }
            if (l != null) {
                this.limit = l.longValue();
                return this;
            }
            this.limit = 1000L;
            return this;
        }

        public Builder withIncludeRemoved(Boolean bool) {
            if (bool != null) {
                this.includeRemoved = bool.booleanValue();
                return this;
            }
            this.includeRemoved = false;
            return this;
        }

        public MembersListArg build() {
            return new MembersListArg(this.limit, this.includeRemoved);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.limit), Boolean.valueOf(this.includeRemoved)});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            MembersListArg membersListArg = (MembersListArg) obj;
            if (this.limit == membersListArg.limit && this.includeRemoved == membersListArg.includeRemoved) {
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

    static class Serializer extends StructSerializer<MembersListArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersListArg membersListArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(Long.valueOf(membersListArg.limit), jsonGenerator);
            jsonGenerator.writeFieldName("include_removed");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(membersListArg.includeRemoved), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersListArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = 1000L;
                Boolean boolDeserialize = false;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("limit".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else if ("include_removed".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                MembersListArg membersListArg = new MembersListArg(lDeserialize.longValue(), boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersListArg, membersListArg.toStringMultiline());
                return membersListArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
