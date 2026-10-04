package com.dropbox.core.p012v1;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.dropbox.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxDelta<MD extends Dumpable> extends Dumpable {
    public final String cursor;
    public final List<Entry<MD>> entries;
    public final boolean hasMore;
    public final boolean reset;

    public DbxDelta(boolean z, List<Entry<MD>> list, String str, boolean z2) {
        this.reset = z;
        this.entries = list;
        this.cursor = str;
        this.hasMore = z2;
    }

    @Override // com.dropbox.core.util.Dumpable
    protected void dumpFields(DumpWriter dumpWriter) {
        dumpWriter.mo519f("reset").m529v(this.reset);
        dumpWriter.mo519f("hasMore").m529v(this.hasMore);
        dumpWriter.mo519f("cursor").m527v(this.cursor);
        dumpWriter.mo519f(RemoteConfigConstants.ResponseFieldKey.ENTRIES).m525v(this.entries);
    }

    public static final class Reader<MD extends Dumpable> extends JsonReader<DbxDelta<MD>> {

        /* JADX INFO: renamed from: FM */
        private static final JsonReader.FieldMapping f663FM;
        private static final int FM_cursor = 2;
        private static final int FM_entries = 1;
        private static final int FM_has_more = 3;
        private static final int FM_reset = 0;
        public final JsonReader<MD> metadataReader;

        public Reader(JsonReader<MD> jsonReader) {
            this.metadataReader = jsonReader;
        }

        @Override // com.dropbox.core.json.JsonReader
        public DbxDelta<MD> read(JsonParser jsonParser) throws JsonReadException, IOException {
            return read(jsonParser, this.metadataReader);
        }

        public static <MD extends Dumpable> DbxDelta<MD> read(JsonParser jsonParser, JsonReader<MD> jsonReader) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            Boolean field = null;
            List list = null;
            String field2 = null;
            Boolean field3 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                JsonReader.nextToken(jsonParser);
                int i = f663FM.get(currentName);
                if (i == -1) {
                    try {
                        JsonReader.skipValue(jsonParser);
                    } catch (JsonReadException e) {
                        throw e.addFieldContext(currentName);
                    }
                } else if (i == 0) {
                    field = JsonReader.BooleanReader.readField(jsonParser, currentName, field);
                } else if (i == 1) {
                    list = (List) JsonArrayReader.m516mk(new Entry.Reader(jsonReader)).readField(jsonParser, currentName, list);
                } else if (i == 2) {
                    field2 = JsonReader.StringReader.readField(jsonParser, currentName, field2);
                } else if (i == 3) {
                    field3 = JsonReader.BooleanReader.readField(jsonParser, currentName, field3);
                } else {
                    throw new AssertionError("bad index: " + i + ", field = \"" + currentName + "\"");
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field == null) {
                throw new JsonReadException("missing field \"path\"", jsonLocationExpectObjectStart);
            }
            if (list == null) {
                throw new JsonReadException("missing field \"entries\"", jsonLocationExpectObjectStart);
            }
            if (field2 == null) {
                throw new JsonReadException("missing field \"cursor\"", jsonLocationExpectObjectStart);
            }
            if (field3 == null) {
                throw new JsonReadException("missing field \"has_more\"", jsonLocationExpectObjectStart);
            }
            return new DbxDelta<>(field.booleanValue(), list, field2, field3.booleanValue());
        }

        static {
            JsonReader.FieldMapping.Builder builder = new JsonReader.FieldMapping.Builder();
            builder.add("reset", 0);
            builder.add(RemoteConfigConstants.ResponseFieldKey.ENTRIES, 1);
            builder.add("cursor", 2);
            builder.add("has_more", 3);
            f663FM = builder.build();
        }
    }

    public static final class Entry<MD extends Dumpable> extends Dumpable {
        public final String lcPath;
        public final MD metadata;

        public Entry(String str, MD md) {
            this.lcPath = str;
            this.metadata = md;
        }

        @Override // com.dropbox.core.util.Dumpable
        protected void dumpFields(DumpWriter dumpWriter) {
            dumpWriter.mo519f("lcPath").m527v(this.lcPath);
            dumpWriter.mo519f(TtmlNode.TAG_METADATA).m524v(this.metadata);
        }

        public static final class Reader<MD extends Dumpable> extends JsonReader<Entry<MD>> {
            public final JsonReader<MD> metadataReader;

            public Reader(JsonReader<MD> jsonReader) {
                this.metadataReader = jsonReader;
            }

            @Override // com.dropbox.core.json.JsonReader
            public Entry<MD> read(JsonParser jsonParser) throws JsonReadException, IOException {
                return read(jsonParser, this.metadataReader);
            }

            public static <MD extends Dumpable> Entry<MD> read(JsonParser jsonParser, JsonReader<MD> jsonReader) throws JsonReadException, IOException {
                JsonLocation jsonLocationExpectArrayStart = JsonReader.expectArrayStart(jsonParser);
                if (JsonReader.isArrayEnd(jsonParser)) {
                    throw new JsonReadException("expecting a two-element array of [path, metadata], found a zero-element array", jsonLocationExpectArrayStart);
                }
                try {
                    String str = JsonReader.StringReader.read(jsonParser);
                    if (JsonReader.isArrayEnd(jsonParser)) {
                        throw new JsonReadException("expecting a two-element array of [path, metadata], found a one-element array: " + StringUtil.m531jq(str), jsonLocationExpectArrayStart);
                    }
                    try {
                        MD optional = jsonReader.readOptional(jsonParser);
                        if (!JsonReader.isArrayEnd(jsonParser)) {
                            throw new JsonReadException("expecting a two-element array of [path, metadata], found non \"]\" token after the two elements: " + jsonParser.getCurrentToken(), jsonLocationExpectArrayStart);
                        }
                        jsonParser.nextToken();
                        return new Entry<>(str, optional);
                    } catch (JsonReadException e) {
                        throw e.addArrayContext(1);
                    }
                } catch (JsonReadException e2) {
                    throw e2.addArrayContext(0);
                }
            }
        }
    }
}
