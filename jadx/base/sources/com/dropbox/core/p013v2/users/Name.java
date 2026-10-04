package com.dropbox.core.p013v2.users;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class Name {

    @Nonnull
    protected final String abbreviatedName;

    @Nonnull
    protected final String displayName;

    @Nonnull
    protected final String familiarName;

    @Nonnull
    protected final String givenName;

    @Nonnull
    protected final String surname;

    public Name(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4, @Nonnull String str5) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'givenName' is null");
        }
        this.givenName = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'surname' is null");
        }
        this.surname = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'familiarName' is null");
        }
        this.familiarName = str3;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = str4;
        if (str5 == null) {
            throw new IllegalArgumentException("Required value for 'abbreviatedName' is null");
        }
        this.abbreviatedName = str5;
    }

    @Nonnull
    public String getGivenName() {
        return this.givenName;
    }

    @Nonnull
    public String getSurname() {
        return this.surname;
    }

    @Nonnull
    public String getFamiliarName() {
        return this.familiarName;
    }

    @Nonnull
    public String getDisplayName() {
        return this.displayName;
    }

    @Nonnull
    public String getAbbreviatedName() {
        return this.abbreviatedName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.givenName, this.surname, this.familiarName, this.displayName, this.abbreviatedName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        Name name = (Name) obj;
        String str9 = this.givenName;
        String str10 = name.givenName;
        return (str9 == str10 || str9.equals(str10)) && ((str = this.surname) == (str2 = name.surname) || str.equals(str2)) && (((str3 = this.familiarName) == (str4 = name.familiarName) || str3.equals(str4)) && (((str5 = this.displayName) == (str6 = name.displayName) || str5.equals(str6)) && ((str7 = this.abbreviatedName) == (str8 = name.abbreviatedName) || str7.equals(str8))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<Name> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(Name name, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("given_name");
            StoneSerializers.string().serialize(name.givenName, jsonGenerator);
            jsonGenerator.writeFieldName("surname");
            StoneSerializers.string().serialize(name.surname, jsonGenerator);
            jsonGenerator.writeFieldName("familiar_name");
            StoneSerializers.string().serialize(name.familiarName, jsonGenerator);
            jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
            StoneSerializers.string().serialize(name.displayName, jsonGenerator);
            jsonGenerator.writeFieldName("abbreviated_name");
            StoneSerializers.string().serialize(name.abbreviatedName, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public Name deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                String strDeserialize4 = null;
                String strDeserialize5 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("given_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("surname".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("familiar_name".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("abbreviated_name".equals(currentName)) {
                        strDeserialize5 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"given_name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"surname\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"familiar_name\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"display_name\" missing.");
                }
                if (strDeserialize5 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"abbreviated_name\" missing.");
                }
                Name name = new Name(strDeserialize, strDeserialize2, strDeserialize3, strDeserialize4, strDeserialize5);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(name, name.toStringMultiline());
                return name;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
