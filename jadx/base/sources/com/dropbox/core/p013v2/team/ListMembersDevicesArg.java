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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class ListMembersDevicesArg {

    @Nullable
    protected final String cursor;
    protected final boolean includeDesktopClients;
    protected final boolean includeMobileClients;
    protected final boolean includeWebSessions;

    public ListMembersDevicesArg(@Nullable String str, boolean z, boolean z2, boolean z3) {
        this.cursor = str;
        this.includeWebSessions = z;
        this.includeDesktopClients = z2;
        this.includeMobileClients = z3;
    }

    public ListMembersDevicesArg() {
        this(null, true, true, true);
    }

    @Nullable
    public String getCursor() {
        return this.cursor;
    }

    public boolean getIncludeWebSessions() {
        return this.includeWebSessions;
    }

    public boolean getIncludeDesktopClients() {
        return this.includeDesktopClients;
    }

    public boolean getIncludeMobileClients() {
        return this.includeMobileClients;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String cursor = null;
        protected boolean includeWebSessions = true;
        protected boolean includeDesktopClients = true;
        protected boolean includeMobileClients = true;

        protected Builder() {
        }

        public Builder withCursor(String str) {
            this.cursor = str;
            return this;
        }

        public Builder withIncludeWebSessions(Boolean bool) {
            if (bool != null) {
                this.includeWebSessions = bool.booleanValue();
                return this;
            }
            this.includeWebSessions = true;
            return this;
        }

        public Builder withIncludeDesktopClients(Boolean bool) {
            if (bool != null) {
                this.includeDesktopClients = bool.booleanValue();
                return this;
            }
            this.includeDesktopClients = true;
            return this;
        }

        public Builder withIncludeMobileClients(Boolean bool) {
            if (bool != null) {
                this.includeMobileClients = bool.booleanValue();
                return this;
            }
            this.includeMobileClients = true;
            return this;
        }

        public ListMembersDevicesArg build() {
            return new ListMembersDevicesArg(this.cursor, this.includeWebSessions, this.includeDesktopClients, this.includeMobileClients);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.cursor, Boolean.valueOf(this.includeWebSessions), Boolean.valueOf(this.includeDesktopClients), Boolean.valueOf(this.includeMobileClients)});
    }

    public boolean equals(Object obj) {
        ListMembersDevicesArg listMembersDevicesArg;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.cursor) == (str2 = (listMembersDevicesArg = (ListMembersDevicesArg) obj).cursor) || (str != null && str.equals(str2))) && this.includeWebSessions == listMembersDevicesArg.includeWebSessions && this.includeDesktopClients == listMembersDevicesArg.includeDesktopClients && this.includeMobileClients == listMembersDevicesArg.includeMobileClients;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListMembersDevicesArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListMembersDevicesArg listMembersDevicesArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (listMembersDevicesArg.cursor != null) {
                jsonGenerator.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(listMembersDevicesArg.cursor, jsonGenerator);
            }
            jsonGenerator.writeFieldName("include_web_sessions");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listMembersDevicesArg.includeWebSessions), jsonGenerator);
            jsonGenerator.writeFieldName("include_desktop_clients");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listMembersDevicesArg.includeDesktopClients), jsonGenerator);
            jsonGenerator.writeFieldName("include_mobile_clients");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listMembersDevicesArg.includeMobileClients), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListMembersDevicesArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                Boolean boolDeserialize2 = true;
                Boolean boolDeserialize3 = true;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("cursor".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("include_web_sessions".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_desktop_clients".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_mobile_clients".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                ListMembersDevicesArg listMembersDevicesArg = new ListMembersDevicesArg(str, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listMembersDevicesArg, listMembersDevicesArg.toStringMultiline());
                return listMembersDevicesArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
