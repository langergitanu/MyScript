package com.dropbox.core.p013v2.filerequests;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.filerequests.FileRequestDeadline;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class CreateFileRequestArgs {

    @Nullable
    protected final FileRequestDeadline deadline;

    @Nullable
    protected final String description;

    @Nonnull
    protected final String destination;
    protected final boolean open;

    @Nonnull
    protected final String title;

    public CreateFileRequestArgs(@Nonnull String str, @Nonnull String str2, @Nullable FileRequestDeadline fileRequestDeadline, boolean z, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'title' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'title' is shorter than 1");
        }
        this.title = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'destination' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*", str2)) {
            throw new IllegalArgumentException("String 'destination' does not match pattern");
        }
        this.destination = str2;
        this.deadline = fileRequestDeadline;
        this.open = z;
        this.description = str3;
    }

    public CreateFileRequestArgs(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null, true, null);
    }

    @Nonnull
    public String getTitle() {
        return this.title;
    }

    @Nonnull
    public String getDestination() {
        return this.destination;
    }

    @Nullable
    public FileRequestDeadline getDeadline() {
        return this.deadline;
    }

    public boolean getOpen() {
        return this.open;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    public static Builder newBuilder(String str, String str2) {
        return new Builder(str, str2);
    }

    public static class Builder {
        protected FileRequestDeadline deadline;
        protected String description;
        protected final String destination;
        protected boolean open;
        protected final String title;

        protected Builder(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'title' is null");
            }
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'title' is shorter than 1");
            }
            this.title = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'destination' is null");
            }
            if (!Pattern.matches("/(.|[\\r\\n])*", str2)) {
                throw new IllegalArgumentException("String 'destination' does not match pattern");
            }
            this.destination = str2;
            this.deadline = null;
            this.open = true;
            this.description = null;
        }

        public Builder withDeadline(FileRequestDeadline fileRequestDeadline) {
            this.deadline = fileRequestDeadline;
            return this;
        }

        public Builder withOpen(Boolean bool) {
            if (bool != null) {
                this.open = bool.booleanValue();
                return this;
            }
            this.open = true;
            return this;
        }

        public Builder withDescription(String str) {
            this.description = str;
            return this;
        }

        public CreateFileRequestArgs build() {
            return new CreateFileRequestArgs(this.title, this.destination, this.deadline, this.open, this.description);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.title, this.destination, this.deadline, Boolean.valueOf(this.open), this.description});
    }

    public boolean equals(Object obj) {
        CreateFileRequestArgs createFileRequestArgs;
        String str;
        String str2;
        String str3;
        String str4;
        FileRequestDeadline fileRequestDeadline;
        FileRequestDeadline fileRequestDeadline2;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.title) == (str2 = (createFileRequestArgs = (CreateFileRequestArgs) obj).title) || str.equals(str2)) && (((str3 = this.destination) == (str4 = createFileRequestArgs.destination) || str3.equals(str4)) && (((fileRequestDeadline = this.deadline) == (fileRequestDeadline2 = createFileRequestArgs.deadline) || (fileRequestDeadline != null && fileRequestDeadline.equals(fileRequestDeadline2))) && this.open == createFileRequestArgs.open && ((str5 = this.description) == (str6 = createFileRequestArgs.description) || (str5 != null && str5.equals(str6)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CreateFileRequestArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CreateFileRequestArgs createFileRequestArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("title");
            StoneSerializers.string().serialize(createFileRequestArgs.title, jsonGenerator);
            jsonGenerator.writeFieldName(FirebaseAnalytics.Param.DESTINATION);
            StoneSerializers.string().serialize(createFileRequestArgs.destination, jsonGenerator);
            if (createFileRequestArgs.deadline != null) {
                jsonGenerator.writeFieldName("deadline");
                StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).serialize(createFileRequestArgs.deadline, jsonGenerator);
            }
            jsonGenerator.writeFieldName(TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
            StoneSerializers.boolean_().serialize(Boolean.valueOf(createFileRequestArgs.open), jsonGenerator);
            if (createFileRequestArgs.description != null) {
                jsonGenerator.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(createFileRequestArgs.description, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CreateFileRequestArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                String strDeserialize = null;
                String strDeserialize2 = null;
                FileRequestDeadline fileRequestDeadline = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("title".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.DESTINATION.equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("deadline".equals(currentName)) {
                        fileRequestDeadline = (FileRequestDeadline) StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"title\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"destination\" missing.");
                }
                CreateFileRequestArgs createFileRequestArgs = new CreateFileRequestArgs(strDeserialize, strDeserialize2, fileRequestDeadline, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(createFileRequestArgs, createFileRequestArgs.toStringMultiline());
                return createFileRequestArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
