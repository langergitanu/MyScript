package com.dropbox.core.p013v2.filerequests;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.p013v2.filerequests.UpdateFileRequestDeadline;
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
class UpdateFileRequestArgs {

    @Nonnull
    protected final UpdateFileRequestDeadline deadline;

    @Nullable
    protected final String description;

    @Nullable
    protected final String destination;

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f687id;

    @Nullable
    protected final Boolean open;

    @Nullable
    protected final String title;

    public UpdateFileRequestArgs(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nonnull UpdateFileRequestDeadline updateFileRequestDeadline, @Nullable Boolean bool, @Nullable String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.f687id = str;
        if (str2 != null && str2.length() < 1) {
            throw new IllegalArgumentException("String 'title' is shorter than 1");
        }
        this.title = str2;
        if (str3 != null && !Pattern.matches("/(.|[\\r\\n])*", str3)) {
            throw new IllegalArgumentException("String 'destination' does not match pattern");
        }
        this.destination = str3;
        if (updateFileRequestDeadline == null) {
            throw new IllegalArgumentException("Required value for 'deadline' is null");
        }
        this.deadline = updateFileRequestDeadline;
        this.open = bool;
        this.description = str4;
    }

    public UpdateFileRequestArgs(@Nonnull String str) {
        this(str, null, null, UpdateFileRequestDeadline.NO_UPDATE, null, null);
    }

    @Nonnull
    public String getId() {
        return this.f687id;
    }

    @Nullable
    public String getTitle() {
        return this.title;
    }

    @Nullable
    public String getDestination() {
        return this.destination;
    }

    @Nonnull
    public UpdateFileRequestDeadline getDeadline() {
        return this.deadline;
    }

    @Nullable
    public Boolean getOpen() {
        return this.open;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected UpdateFileRequestDeadline deadline;
        protected String description;
        protected String destination;

        /* JADX INFO: renamed from: id */
        protected final String f688id;
        protected Boolean open;
        protected String title;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (str.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z]+", str)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.f688id = str;
            this.title = null;
            this.destination = null;
            this.deadline = UpdateFileRequestDeadline.NO_UPDATE;
            this.open = null;
            this.description = null;
        }

        public Builder withTitle(String str) {
            if (str != null && str.length() < 1) {
                throw new IllegalArgumentException("String 'title' is shorter than 1");
            }
            this.title = str;
            return this;
        }

        public Builder withDestination(String str) {
            if (str != null && !Pattern.matches("/(.|[\\r\\n])*", str)) {
                throw new IllegalArgumentException("String 'destination' does not match pattern");
            }
            this.destination = str;
            return this;
        }

        public Builder withDeadline(UpdateFileRequestDeadline updateFileRequestDeadline) {
            if (updateFileRequestDeadline != null) {
                this.deadline = updateFileRequestDeadline;
                return this;
            }
            this.deadline = UpdateFileRequestDeadline.NO_UPDATE;
            return this;
        }

        public Builder withOpen(Boolean bool) {
            this.open = bool;
            return this;
        }

        public Builder withDescription(String str) {
            this.description = str;
            return this;
        }

        public UpdateFileRequestArgs build() {
            return new UpdateFileRequestArgs(this.f688id, this.title, this.destination, this.deadline, this.open, this.description);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f687id, this.title, this.destination, this.deadline, this.open, this.description});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        UpdateFileRequestDeadline updateFileRequestDeadline;
        UpdateFileRequestDeadline updateFileRequestDeadline2;
        Boolean bool;
        Boolean bool2;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UpdateFileRequestArgs updateFileRequestArgs = (UpdateFileRequestArgs) obj;
        String str7 = this.f687id;
        String str8 = updateFileRequestArgs.f687id;
        return (str7 == str8 || str7.equals(str8)) && ((str = this.title) == (str2 = updateFileRequestArgs.title) || (str != null && str.equals(str2))) && (((str3 = this.destination) == (str4 = updateFileRequestArgs.destination) || (str3 != null && str3.equals(str4))) && (((updateFileRequestDeadline = this.deadline) == (updateFileRequestDeadline2 = updateFileRequestArgs.deadline) || updateFileRequestDeadline.equals(updateFileRequestDeadline2)) && (((bool = this.open) == (bool2 = updateFileRequestArgs.open) || (bool != null && bool.equals(bool2))) && ((str5 = this.description) == (str6 = updateFileRequestArgs.description) || (str5 != null && str5.equals(str6))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UpdateFileRequestArgs> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UpdateFileRequestArgs updateFileRequestArgs, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(updateFileRequestArgs.f687id, jsonGenerator);
            if (updateFileRequestArgs.title != null) {
                jsonGenerator.writeFieldName("title");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(updateFileRequestArgs.title, jsonGenerator);
            }
            if (updateFileRequestArgs.destination != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.DESTINATION);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(updateFileRequestArgs.destination, jsonGenerator);
            }
            jsonGenerator.writeFieldName("deadline");
            UpdateFileRequestDeadline.Serializer.INSTANCE.serialize(updateFileRequestArgs.deadline, jsonGenerator);
            if (updateFileRequestArgs.open != null) {
                jsonGenerator.writeFieldName(TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(updateFileRequestArgs.open, jsonGenerator);
            }
            if (updateFileRequestArgs.description != null) {
                jsonGenerator.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(updateFileRequestArgs.description, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UpdateFileRequestArgs deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String str = null;
                String str2 = null;
                Boolean bool = null;
                String str3 = null;
                UpdateFileRequestDeadline updateFileRequestDeadlineDeserialize = UpdateFileRequestDeadline.NO_UPDATE;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("title".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.DESTINATION.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("deadline".equals(currentName)) {
                        updateFileRequestDeadlineDeserialize = UpdateFileRequestDeadline.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (TtmlNode.TEXT_EMPHASIS_MARK_OPEN.equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("description".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                UpdateFileRequestArgs updateFileRequestArgs = new UpdateFileRequestArgs(strDeserialize, str, str2, updateFileRequestDeadlineDeserialize, bool, str3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(updateFileRequestArgs, updateFileRequestArgs.toStringMultiline());
                return updateFileRequestArgs;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
