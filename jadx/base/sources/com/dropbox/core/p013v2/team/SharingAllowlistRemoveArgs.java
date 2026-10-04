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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class SharingAllowlistRemoveArgs {

    @Nullable
    protected final List<String> domains;

    @Nullable
    protected final List<String> emails;

    public SharingAllowlistRemoveArgs(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'domains' is null");
                }
            }
        }
        this.domains = list;
        if (list2 != null) {
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    throw new IllegalArgumentException("An item in list 'emails' is null");
                }
            }
        }
        this.emails = list2;
    }

    public SharingAllowlistRemoveArgs() {
        this(null, null);
    }

    @Nullable
    public List<String> getDomains() {
        return this.domains;
    }

    @Nullable
    public List<String> getEmails() {
        return this.emails;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected List<String> domains = null;
        protected List<String> emails = null;

        protected Builder() {
        }

        public Builder withDomains(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'domains' is null");
                    }
                }
            }
            this.domains = list;
            return this;
        }

        public Builder withEmails(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'emails' is null");
                    }
                }
            }
            this.emails = list;
            return this;
        }

        public SharingAllowlistRemoveArgs build() {
            return new SharingAllowlistRemoveArgs(this.domains, this.emails);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.domains, this.emails});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharingAllowlistRemoveArgs sharingAllowlistRemoveArgs = (SharingAllowlistRemoveArgs) obj;
        List<String> list3 = this.domains;
        List<String> list4 = sharingAllowlistRemoveArgs.domains;
        return (list3 == list4 || (list3 != null && list3.equals(list4))) && ((list = this.emails) == (list2 = sharingAllowlistRemoveArgs.emails) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingAllowlistRemoveArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingAllowlistRemoveArgs sharingAllowlistRemoveArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharingAllowlistRemoveArgs.domains != null) {
                jsonGenerator.writeFieldName("domains");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(sharingAllowlistRemoveArgs.domains, jsonGenerator);
            }
            if (sharingAllowlistRemoveArgs.emails != null) {
                jsonGenerator.writeFieldName("emails");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(sharingAllowlistRemoveArgs.emails, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingAllowlistRemoveArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("domains".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else if ("emails".equals(currentName)) {
                        list2 = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharingAllowlistRemoveArgs sharingAllowlistRemoveArgs = new SharingAllowlistRemoveArgs(list, list2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingAllowlistRemoveArgs, sharingAllowlistRemoveArgs.toStringMultiline());
                return sharingAllowlistRemoveArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
