package com.dropbox.core.p012v1;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.Collector;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class DbxDeltaC<C> extends Dumpable {
    public final String cursor;
    public final C entries;
    public final boolean hasMore;
    public final boolean reset;

    public DbxDeltaC(boolean z, C c, String str, boolean z2) {
        this.reset = z;
        this.entries = c;
        this.cursor = str;
        this.hasMore = z2;
    }

    @Override // com.dropbox.core.util.Dumpable
    protected void dumpFields(DumpWriter dumpWriter) {
        dumpWriter.mo519f("reset").m529v(this.reset);
        dumpWriter.mo519f("cursor").m527v(this.cursor);
        dumpWriter.mo519f(RemoteConfigConstants.ResponseFieldKey.ENTRIES).m529v(this.hasMore);
    }

    public static final class Reader<C, MD extends Dumpable> extends JsonReader<DbxDeltaC<C>> {

        /* JADX INFO: renamed from: FM */
        private static final JsonReader.FieldMapping f664FM;
        private static final int FM_cursor = 2;
        private static final int FM_entries = 1;
        private static final int FM_has_more = 3;
        private static final int FM_reset = 0;
        public final Collector<Entry<MD>, C> entryCollector;
        public final JsonReader<MD> metadataReader;

        public Reader(JsonReader<MD> jsonReader, Collector<Entry<MD>, C> collector) {
            this.metadataReader = jsonReader;
            this.entryCollector = collector;
        }

        @Override // com.dropbox.core.json.JsonReader
        public DbxDeltaC<C> read(JsonParser jsonParser) throws JsonReadException, IOException {
            return read(jsonParser, this.metadataReader, this.entryCollector);
        }

        public static <C, MD extends Dumpable> DbxDeltaC<C> read(JsonParser jsonParser, JsonReader<MD> jsonReader, Collector<Entry<MD>, C> collector) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            Boolean field = null;
            Object field2 = null;
            String field3 = null;
            Boolean field4 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                JsonReader.nextToken(jsonParser);
                int i = f664FM.get(currentName);
                if (i == -1) {
                    try {
                        JsonReader.skipValue(jsonParser);
                    } catch (JsonReadException e) {
                        throw e.addFieldContext(currentName);
                    }
                } else if (i == 0) {
                    field = JsonReader.BooleanReader.readField(jsonParser, currentName, field);
                } else if (i == 1) {
                    field2 = JsonArrayReader.m517mk(new Entry.Reader(jsonReader), collector).readField(jsonParser, currentName, field2);
                } else if (i == 2) {
                    field3 = JsonReader.StringReader.readField(jsonParser, currentName, field3);
                } else if (i == 3) {
                    field4 = JsonReader.BooleanReader.readField(jsonParser, currentName, field4);
                } else {
                    throw new AssertionError("bad index: " + i + ", field = \"" + currentName + "\"");
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field == null) {
                throw new JsonReadException("missing field \"path\"", jsonLocationExpectObjectStart);
            }
            if (field2 == null) {
                throw new JsonReadException("missing field \"entries\"", jsonLocationExpectObjectStart);
            }
            if (field3 == null) {
                throw new JsonReadException("missing field \"cursor\"", jsonLocationExpectObjectStart);
            }
            if (field4 == null) {
                throw new JsonReadException("missing field \"has_more\"", jsonLocationExpectObjectStart);
            }
            return new DbxDeltaC<>(field.booleanValue(), field2, field3, field4.booleanValue());
        }

        static {
            JsonReader.FieldMapping.Builder builder = new JsonReader.FieldMapping.Builder();
            builder.add("reset", 0);
            builder.add(RemoteConfigConstants.ResponseFieldKey.ENTRIES, 1);
            builder.add("cursor", 2);
            builder.add("has_more", 3);
            f664FM = builder.build();
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
                        throw new JsonReadException("expecting a two-element array of [path, metadata], found a one-element array", jsonLocationExpectArrayStart);
                    }
                    try {
                        MD optional = jsonReader.readOptional(jsonParser);
                        if (!JsonReader.isArrayEnd(jsonParser)) {
                            throw new JsonReadException("expecting a two-element array of [path, metadata], found more than two elements", jsonLocationExpectArrayStart);
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
