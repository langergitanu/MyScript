package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class CreateFolderBatchArg {
    protected final boolean autorename;
    protected final boolean forceAsync;

    @Nonnull
    protected final List<String> paths;

    public CreateFolderBatchArg(@Nonnull List<String> list, boolean z, boolean z2) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'paths' is null");
        }
        if (list.size() > 10000) {
            throw new IllegalArgumentException("List 'paths' has more than 10000 items");
        }
        for (String str : list) {
            if (str == null) {
                throw new IllegalArgumentException("An item in list 'paths' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)", str)) {
                throw new IllegalArgumentException("Stringan item in list 'paths' does not match pattern");
            }
        }
        this.paths = list;
        this.autorename = z;
        this.forceAsync = z2;
    }

    public CreateFolderBatchArg(@Nonnull List<String> list) {
        this(list, false, false);
    }

    @Nonnull
    public List<String> getPaths() {
        return this.paths;
    }

    public boolean getAutorename() {
        return this.autorename;
    }

    public boolean getForceAsync() {
        return this.forceAsync;
    }

    public static Builder newBuilder(List<String> list) {
        return new Builder(list);
    }

    public static class Builder {
        protected boolean autorename;
        protected boolean forceAsync;
        protected final List<String> paths;

        protected Builder(List<String> list) {
            if (list == null) {
                throw new IllegalArgumentException("Required value for 'paths' is null");
            }
            if (list.size() > 10000) {
                throw new IllegalArgumentException("List 'paths' has more than 10000 items");
            }
            for (String str : list) {
                if (str == null) {
                    throw new IllegalArgumentException("An item in list 'paths' is null");
                }
                if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)", str)) {
                    throw new IllegalArgumentException("Stringan item in list 'paths' does not match pattern");
                }
            }
            this.paths = list;
            this.autorename = false;
            this.forceAsync = false;
        }

        public Builder withAutorename(Boolean bool) {
            if (bool != null) {
                this.autorename = bool.booleanValue();
                return this;
            }
            this.autorename = false;
            return this;
        }

        public Builder withForceAsync(Boolean bool) {
            if (bool != null) {
                this.forceAsync = bool.booleanValue();
                return this;
            }
            this.forceAsync = false;
            return this;
        }

        public CreateFolderBatchArg build() {
            return new CreateFolderBatchArg(this.paths, this.autorename, this.forceAsync);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.paths, Boolean.valueOf(this.autorename), Boolean.valueOf(this.forceAsync)});
    }

    public boolean equals(Object obj) {
        CreateFolderBatchArg createFolderBatchArg;
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((list = this.paths) == (list2 = (createFolderBatchArg = (CreateFolderBatchArg) obj).paths) || list.equals(list2)) && this.autorename == createFolderBatchArg.autorename && this.forceAsync == createFolderBatchArg.forceAsync;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CreateFolderBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CreateFolderBatchArg createFolderBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("paths");
            StoneSerializers.list(StoneSerializers.string()).serialize(createFolderBatchArg.paths, jsonGenerator);
            jsonGenerator.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(createFolderBatchArg.autorename), jsonGenerator);
            jsonGenerator.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(createFolderBatchArg.forceAsync), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CreateFolderBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                Boolean boolDeserialize2 = false;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("paths".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("autorename".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("force_async".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"paths\" missing.");
                }
                CreateFolderBatchArg createFolderBatchArg = new CreateFolderBatchArg(list, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(createFolderBatchArg, createFolderBatchArg.toStringMultiline());
                return createFolderBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
