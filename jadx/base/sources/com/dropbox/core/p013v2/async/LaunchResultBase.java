package com.dropbox.core.p013v2.async;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class LaunchResultBase {
    private Tag _tag;
    private String asyncJobIdValue;

    public enum Tag {
        ASYNC_JOB_ID
    }

    private LaunchResultBase() {
    }

    private LaunchResultBase withTag(Tag tag) {
        LaunchResultBase launchResultBase = new LaunchResultBase();
        launchResultBase._tag = tag;
        return launchResultBase;
    }

    private LaunchResultBase withTagAndAsyncJobId(Tag tag, String str) {
        LaunchResultBase launchResultBase = new LaunchResultBase();
        launchResultBase._tag = tag;
        launchResultBase.asyncJobIdValue = str;
        return launchResultBase;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAsyncJobId() {
        return this._tag == Tag.ASYNC_JOB_ID;
    }

    public static LaunchResultBase asyncJobId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new LaunchResultBase().withTagAndAsyncJobId(Tag.ASYNC_JOB_ID, str);
    }

    public String getAsyncJobIdValue() {
        if (this._tag != Tag.ASYNC_JOB_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.ASYNC_JOB_ID, but was Tag." + this._tag.name());
        }
        return this.asyncJobIdValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.asyncJobIdValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof LaunchResultBase)) {
            return false;
        }
        LaunchResultBase launchResultBase = (LaunchResultBase) obj;
        if (this._tag != launchResultBase._tag || C41041.$SwitchMap$com$dropbox$core$v2$async$LaunchResultBase$Tag[this._tag.ordinal()] != 1) {
            return false;
        }
        String str = this.asyncJobIdValue;
        String str2 = launchResultBase.asyncJobIdValue;
        return str == str2 || str.equals(str2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.async.LaunchResultBase$1 */
    static /* synthetic */ class C41041 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$async$LaunchResultBase$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$async$LaunchResultBase$Tag = iArr;
            try {
                iArr[Tag.ASYNC_JOB_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<LaunchResultBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LaunchResultBase launchResultBase, JsonGenerator jsonGenerator) throws IOException {
            if (C41041.$SwitchMap$com$dropbox$core$v2$async$LaunchResultBase$Tag[launchResultBase.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("async_job_id", jsonGenerator);
                jsonGenerator.writeFieldName("async_job_id");
                StoneSerializers.string().serialize(launchResultBase.asyncJobIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + launchResultBase.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LaunchResultBase deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("async_job_id".equals(tag)) {
                expectField("async_job_id", jsonParser);
                LaunchResultBase launchResultBaseAsyncJobId = LaunchResultBase.asyncJobId(StoneSerializers.string().deserialize(jsonParser));
                if (!z) {
                    skipFields(jsonParser);
                    expectEndObject(jsonParser);
                }
                return launchResultBaseAsyncJobId;
            }
            throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
        }
    }
}
