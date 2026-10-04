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
class SharingAllowlistAddArgs {

    @Nullable
    protected final List<String> domains;

    @Nullable
    protected final List<String> emails;

    public SharingAllowlistAddArgs(@Nullable List<String> list, @Nullable List<String> list2) {
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

    public SharingAllowlistAddArgs() {
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

        public SharingAllowlistAddArgs build() {
            return new SharingAllowlistAddArgs(this.domains, this.emails);
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
        SharingAllowlistAddArgs sharingAllowlistAddArgs = (SharingAllowlistAddArgs) obj;
        List<String> list3 = this.domains;
        List<String> list4 = sharingAllowlistAddArgs.domains;
        return (list3 == list4 || (list3 != null && list3.equals(list4))) && ((list = this.emails) == (list2 = sharingAllowlistAddArgs.emails) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharingAllowlistAddArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharingAllowlistAddArgs sharingAllowlistAddArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharingAllowlistAddArgs.domains != null) {
                jsonGenerator.writeFieldName("domains");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(sharingAllowlistAddArgs.domains, jsonGenerator);
            }
            if (sharingAllowlistAddArgs.emails != null) {
                jsonGenerator.writeFieldName("emails");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(sharingAllowlistAddArgs.emails, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharingAllowlistAddArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                SharingAllowlistAddArgs sharingAllowlistAddArgs = new SharingAllowlistAddArgs(list, list2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharingAllowlistAddArgs, sharingAllowlistAddArgs.toStringMultiline());
                return sharingAllowlistAddArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
