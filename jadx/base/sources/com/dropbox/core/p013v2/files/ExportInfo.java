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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ExportInfo {

    @Nullable
    protected final String exportAs;

    @Nullable
    protected final List<String> exportOptions;

    public ExportInfo(@Nullable String str, @Nullable List<String> list) {
        this.exportAs = str;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'exportOptions' is null");
                }
            }
        }
        this.exportOptions = list;
    }

    public ExportInfo() {
        this(null, null);
    }

    @Nullable
    public String getExportAs() {
        return this.exportAs;
    }

    @Nullable
    public List<String> getExportOptions() {
        return this.exportOptions;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String exportAs = null;
        protected List<String> exportOptions = null;

        protected Builder() {
        }

        public Builder withExportAs(String str) {
            this.exportAs = str;
            return this;
        }

        public Builder withExportOptions(List<String> list) {
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'exportOptions' is null");
                    }
                }
            }
            this.exportOptions = list;
            return this;
        }

        public ExportInfo build() {
            return new ExportInfo(this.exportAs, this.exportOptions);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.exportAs, this.exportOptions});
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
        ExportInfo exportInfo = (ExportInfo) obj;
        String str = this.exportAs;
        String str2 = exportInfo.exportAs;
        return (str == str2 || (str != null && str.equals(str2))) && ((list = this.exportOptions) == (list2 = exportInfo.exportOptions) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExportInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExportInfo exportInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (exportInfo.exportAs != null) {
                jsonGenerator.writeFieldName("export_as");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(exportInfo.exportAs, jsonGenerator);
            }
            if (exportInfo.exportOptions != null) {
                jsonGenerator.writeFieldName("export_options");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(exportInfo.exportOptions, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExportInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("export_as".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("export_options".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                ExportInfo exportInfo = new ExportInfo(str, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(exportInfo, exportInfo.toStringMultiline());
                return exportInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
