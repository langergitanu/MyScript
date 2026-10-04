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
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class LegalHoldsPolicyUpdateArg {

    @Nullable
    protected final String description;

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f757id;

    @Nullable
    protected final List<String> members;

    @Nullable
    protected final String name;

    public LegalHoldsPolicyUpdateArg(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable List<String> list) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (!Pattern.matches("^pid_dbhid:.+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f757id = str;
        if (str2 != null && str2.length() > 140) {
            throw new IllegalArgumentException("String 'name' is longer than 140");
        }
        this.name = str2;
        if (str3 != null && str3.length() > 501) {
            throw new IllegalArgumentException("String 'description' is longer than 501");
        }
        this.description = str3;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
        }
        this.members = list;
    }

    public LegalHoldsPolicyUpdateArg(@Nonnull String str) {
        this(str, null, null, null);
    }

    @Nonnull
    public String getId() {
        return this.f757id;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Nullable
    public List<String> getMembers() {
        return this.members;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected String description;

        /* JADX INFO: renamed from: id */
        protected final String f758id;
        protected List<String> members;
        protected String name;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (!Pattern.matches("^pid_dbhid:.+", str)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.f758id = str;
            this.name = null;
            this.description = null;
            this.members = null;
        }

        public Builder withName(String str) {
            if (str != null && str.length() > 140) {
                throw new IllegalArgumentException("String 'name' is longer than 140");
            }
            this.name = str;
            return this;
        }

        public Builder withDescription(String str) {
            if (str != null && str.length() > 501) {
                throw new IllegalArgumentException("String 'description' is longer than 501");
            }
            this.description = str;
            return this;
        }

        public Builder withMembers(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'members' is null");
                    }
                }
            }
            this.members = list;
            return this;
        }

        public LegalHoldsPolicyUpdateArg build() {
            return new LegalHoldsPolicyUpdateArg(this.f758id, this.name, this.description, this.members);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f757id, this.name, this.description, this.members});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldsPolicyUpdateArg legalHoldsPolicyUpdateArg = (LegalHoldsPolicyUpdateArg) obj;
        String str5 = this.f757id;
        String str6 = legalHoldsPolicyUpdateArg.f757id;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = legalHoldsPolicyUpdateArg.name) || (str != null && str.equals(str2))) && (((str3 = this.description) == (str4 = legalHoldsPolicyUpdateArg.description) || (str3 != null && str3.equals(str4))) && ((list = this.members) == (list2 = legalHoldsPolicyUpdateArg.members) || (list != null && list.equals(list2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsPolicyUpdateArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsPolicyUpdateArg legalHoldsPolicyUpdateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(legalHoldsPolicyUpdateArg.f757id, jsonGenerator);
            if (legalHoldsPolicyUpdateArg.name != null) {
                jsonGenerator.writeFieldName("name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legalHoldsPolicyUpdateArg.name, jsonGenerator);
            }
            if (legalHoldsPolicyUpdateArg.description != null) {
                jsonGenerator.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legalHoldsPolicyUpdateArg.description, jsonGenerator);
            }
            if (legalHoldsPolicyUpdateArg.members != null) {
                jsonGenerator.writeFieldName("members");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(legalHoldsPolicyUpdateArg.members, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsPolicyUpdateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("members".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                LegalHoldsPolicyUpdateArg legalHoldsPolicyUpdateArg = new LegalHoldsPolicyUpdateArg(strDeserialize, str, str2, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsPolicyUpdateArg, legalHoldsPolicyUpdateArg.toStringMultiline());
                return legalHoldsPolicyUpdateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
