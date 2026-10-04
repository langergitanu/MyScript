package com.myscript.shared.datacollect;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3UploadParameters.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/shared/datacollect/NotesCollectResponseModel;", "", "s3UploadParameters", "Lcom/myscript/shared/datacollect/S3UploadParameters;", "<init>", "(Lcom/myscript/shared/datacollect/S3UploadParameters;)V", "getS3UploadParameters", "()Lcom/myscript/shared/datacollect/S3UploadParameters;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class NotesCollectResponseModel {

    @SerializedName("s3UploadParameters")
    private final S3UploadParameters s3UploadParameters;

    public static /* synthetic */ NotesCollectResponseModel copy$default(NotesCollectResponseModel notesCollectResponseModel, S3UploadParameters s3UploadParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            s3UploadParameters = notesCollectResponseModel.s3UploadParameters;
        }
        return notesCollectResponseModel.copy(s3UploadParameters);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final S3UploadParameters getS3UploadParameters() {
        return this.s3UploadParameters;
    }

    public final NotesCollectResponseModel copy(S3UploadParameters s3UploadParameters) {
        Intrinsics.checkNotNullParameter(s3UploadParameters, "s3UploadParameters");
        return new NotesCollectResponseModel(s3UploadParameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NotesCollectResponseModel) && Intrinsics.areEqual(this.s3UploadParameters, ((NotesCollectResponseModel) other).s3UploadParameters);
    }

    public int hashCode() {
        return this.s3UploadParameters.hashCode();
    }

    public String toString() {
        return "NotesCollectResponseModel(s3UploadParameters=" + this.s3UploadParameters + ")";
    }

    public NotesCollectResponseModel(S3UploadParameters s3UploadParameters) {
        Intrinsics.checkNotNullParameter(s3UploadParameters, "s3UploadParameters");
        this.s3UploadParameters = s3UploadParameters;
    }

    public final S3UploadParameters getS3UploadParameters() {
        return this.s3UploadParameters;
    }
}
