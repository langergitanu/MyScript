package com.dropbox.core.p013v2.files;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dropbox.core.p013v2.files.CommitInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class GetTemporaryUploadLinkArg {

    @Nonnull
    protected final CommitInfo commitInfo;
    protected final double duration;

    public GetTemporaryUploadLinkArg(@Nonnull CommitInfo commitInfo, double d) {
        if (commitInfo == null) {
            throw new IllegalArgumentException("Required value for 'commitInfo' is null");
        }
        this.commitInfo = commitInfo;
        if (d < 60.0d) {
            throw new IllegalArgumentException("Number 'duration' is smaller than 60.0");
        }
        if (d > 14400.0d) {
            throw new IllegalArgumentException("Number 'duration' is larger than 14400.0");
        }
        this.duration = d;
    }

    public GetTemporaryUploadLinkArg(@Nonnull CommitInfo commitInfo) {
        this(commitInfo, 14400.0d);
    }

    @Nonnull
    public CommitInfo getCommitInfo() {
        return this.commitInfo;
    }

    public double getDuration() {
        return this.duration;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.commitInfo, Double.valueOf(this.duration)});
    }

    public boolean equals(Object obj) {
        GetTemporaryUploadLinkArg getTemporaryUploadLinkArg;
        CommitInfo commitInfo;
        CommitInfo commitInfo2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((commitInfo = this.commitInfo) == (commitInfo2 = (getTemporaryUploadLinkArg = (GetTemporaryUploadLinkArg) obj).commitInfo) || commitInfo.equals(commitInfo2)) && this.duration == getTemporaryUploadLinkArg.duration;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetTemporaryUploadLinkArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetTemporaryUploadLinkArg getTemporaryUploadLinkArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("commit_info");
            CommitInfo.Serializer.INSTANCE.serialize(getTemporaryUploadLinkArg.commitInfo, jsonGenerator);
            jsonGenerator.writeFieldName(TypedValues.TransitionType.S_DURATION);
            StoneSerializers.float64().serialize(Double.valueOf(getTemporaryUploadLinkArg.duration), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetTemporaryUploadLinkArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            CommitInfo commitInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Double dValueOf = Double.valueOf(14400.0d);
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("commit_info".equals(currentName)) {
                        commitInfoDeserialize = CommitInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (TypedValues.TransitionType.S_DURATION.equals(currentName)) {
                        dValueOf = StoneSerializers.float64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (commitInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"commit_info\" missing.");
                }
                GetTemporaryUploadLinkArg getTemporaryUploadLinkArg = new GetTemporaryUploadLinkArg(commitInfoDeserialize, dValueOf.doubleValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getTemporaryUploadLinkArg, getTemporaryUploadLinkArg.toStringMultiline());
                return getTemporaryUploadLinkArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
