package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.GetThumbnailBatchResultData;
import com.dropbox.core.p013v2.files.ThumbnailError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class GetThumbnailBatchResultEntry {
    public static final GetThumbnailBatchResultEntry OTHER = new GetThumbnailBatchResultEntry().withTag(Tag.OTHER);
    private Tag _tag;
    private ThumbnailError failureValue;
    private GetThumbnailBatchResultData successValue;

    public enum Tag {
        SUCCESS,
        FAILURE,
        OTHER
    }

    private GetThumbnailBatchResultEntry() {
    }

    private GetThumbnailBatchResultEntry withTag(Tag tag) {
        GetThumbnailBatchResultEntry getThumbnailBatchResultEntry = new GetThumbnailBatchResultEntry();
        getThumbnailBatchResultEntry._tag = tag;
        return getThumbnailBatchResultEntry;
    }

    private GetThumbnailBatchResultEntry withTagAndSuccess(Tag tag, GetThumbnailBatchResultData getThumbnailBatchResultData) {
        GetThumbnailBatchResultEntry getThumbnailBatchResultEntry = new GetThumbnailBatchResultEntry();
        getThumbnailBatchResultEntry._tag = tag;
        getThumbnailBatchResultEntry.successValue = getThumbnailBatchResultData;
        return getThumbnailBatchResultEntry;
    }

    private GetThumbnailBatchResultEntry withTagAndFailure(Tag tag, ThumbnailError thumbnailError) {
        GetThumbnailBatchResultEntry getThumbnailBatchResultEntry = new GetThumbnailBatchResultEntry();
        getThumbnailBatchResultEntry._tag = tag;
        getThumbnailBatchResultEntry.failureValue = thumbnailError;
        return getThumbnailBatchResultEntry;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSuccess() {
        return this._tag == Tag.SUCCESS;
    }

    public static GetThumbnailBatchResultEntry success(GetThumbnailBatchResultData getThumbnailBatchResultData) {
        if (getThumbnailBatchResultData == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetThumbnailBatchResultEntry().withTagAndSuccess(Tag.SUCCESS, getThumbnailBatchResultData);
    }

    public GetThumbnailBatchResultData getSuccessValue() {
        if (this._tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + this._tag.name());
        }
        return this.successValue;
    }

    public boolean isFailure() {
        return this._tag == Tag.FAILURE;
    }

    public static GetThumbnailBatchResultEntry failure(ThumbnailError thumbnailError) {
        if (thumbnailError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetThumbnailBatchResultEntry().withTagAndFailure(Tag.FAILURE, thumbnailError);
    }

    public ThumbnailError getFailureValue() {
        if (this._tag != Tag.FAILURE) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILURE, but was Tag." + this._tag.name());
        }
        return this.failureValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.successValue, this.failureValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GetThumbnailBatchResultEntry)) {
            return false;
        }
        GetThumbnailBatchResultEntry getThumbnailBatchResultEntry = (GetThumbnailBatchResultEntry) obj;
        if (this._tag != getThumbnailBatchResultEntry._tag) {
            return false;
        }
        int i = C41651.f699x1bd99d02[this._tag.ordinal()];
        if (i == 1) {
            GetThumbnailBatchResultData getThumbnailBatchResultData = this.successValue;
            GetThumbnailBatchResultData getThumbnailBatchResultData2 = getThumbnailBatchResultEntry.successValue;
            return getThumbnailBatchResultData == getThumbnailBatchResultData2 || getThumbnailBatchResultData.equals(getThumbnailBatchResultData2);
        }
        if (i != 2) {
            return i == 3;
        }
        ThumbnailError thumbnailError = this.failureValue;
        ThumbnailError thumbnailError2 = getThumbnailBatchResultEntry.failureValue;
        return thumbnailError == thumbnailError2 || thumbnailError.equals(thumbnailError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.GetThumbnailBatchResultEntry$1 */
    static /* synthetic */ class C41651 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$files$GetThumbnailBatchResultEntry$Tag */
        static final /* synthetic */ int[] f699x1bd99d02;

        static {
            int[] iArr = new int[Tag.values().length];
            f699x1bd99d02 = iArr;
            try {
                iArr[Tag.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f699x1bd99d02[Tag.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f699x1bd99d02[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<GetThumbnailBatchResultEntry> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetThumbnailBatchResultEntry getThumbnailBatchResultEntry, JsonGenerator jsonGenerator) throws IOException {
            int i = C41651.f699x1bd99d02[getThumbnailBatchResultEntry.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(FirebaseAnalytics.Param.SUCCESS, jsonGenerator);
                GetThumbnailBatchResultData.Serializer.INSTANCE.serialize(getThumbnailBatchResultEntry.successValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("failure", jsonGenerator);
                jsonGenerator.writeFieldName("failure");
                ThumbnailError.Serializer.INSTANCE.serialize(getThumbnailBatchResultEntry.failureValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetThumbnailBatchResultEntry deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetThumbnailBatchResultEntry getThumbnailBatchResultEntryFailure;
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
            if (FirebaseAnalytics.Param.SUCCESS.equals(tag)) {
                getThumbnailBatchResultEntryFailure = GetThumbnailBatchResultEntry.success(GetThumbnailBatchResultData.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("failure".equals(tag)) {
                expectField("failure", jsonParser);
                getThumbnailBatchResultEntryFailure = GetThumbnailBatchResultEntry.failure(ThumbnailError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                getThumbnailBatchResultEntryFailure = GetThumbnailBatchResultEntry.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getThumbnailBatchResultEntryFailure;
        }
    }
}
