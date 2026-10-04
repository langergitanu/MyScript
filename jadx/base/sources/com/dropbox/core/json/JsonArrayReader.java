package com.dropbox.core.json;

import com.dropbox.core.util.Collector;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class JsonArrayReader<T, L> extends JsonReader<L> {
    public final Collector<T, ? extends L> collector;
    public final JsonReader<? extends T> elementReader;

    public JsonArrayReader(JsonReader<? extends T> jsonReader, Collector<T, ? extends L> collector) {
        this.elementReader = jsonReader;
        this.collector = collector;
    }

    /* JADX INFO: renamed from: mk */
    public static <T> JsonArrayReader<T, List<T>> m516mk(JsonReader<? extends T> jsonReader) {
        return new JsonArrayReader<>(jsonReader, new Collector.ArrayListCollector());
    }

    /* JADX INFO: renamed from: mk */
    public static <T, L> JsonArrayReader<T, L> m517mk(JsonReader<? extends T> jsonReader, Collector<T, ? extends L> collector) {
        return new JsonArrayReader<>(jsonReader, collector);
    }

    @Override // com.dropbox.core.json.JsonReader
    public L read(JsonParser jsonParser) throws JsonReadException, IOException {
        return (L) read(this.elementReader, this.collector, jsonParser);
    }

    public static <T, L> L read(JsonReader<? extends T> jsonReader, Collector<T, ? extends L> collector, JsonParser jsonParser) throws JsonReadException, IOException {
        expectArrayStart(jsonParser);
        int i = 0;
        while (!isArrayEnd(jsonParser)) {
            try {
                collector.add(jsonReader.read(jsonParser));
                i++;
            } catch (JsonReadException e) {
                throw e.addArrayContext(i);
            }
        }
        jsonParser.nextToken();
        return collector.finish();
    }
}
