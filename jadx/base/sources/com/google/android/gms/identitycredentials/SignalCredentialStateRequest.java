package com.google.android.gms.identitycredentials;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-identity-credentials@@16.0.0-alpha08 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, m1599d2 = {"Lcom/google/android/gms/identitycredentials/SignalCredentialStateRequest;", "Lcom/google/android/gms/common/internal/safeparcel/AbstractSafeParcelable;", "type", "", "origin", "requestData", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "getType", "()Ljava/lang/String;", "getOrigin", "getRequestData", "()Landroid/os/Bundle;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@SafeParcelable.Class(creator = "SignalCredentialStateRequestCreator")
public final class SignalCredentialStateRequest extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getOrigin", m598id = 2)
    private final String origin;

    @SafeParcelable.Field(getter = "getRequestData", m598id = 3)
    private final Bundle requestData;

    @SafeParcelable.Field(getter = "getType", m598id = 1)
    private final String type;
    public static final Parcelable.Creator<SignalCredentialStateRequest> CREATOR = new SignalCredentialStateRequestCreator();

    @SafeParcelable.Constructor
    public SignalCredentialStateRequest(@SafeParcelable.Param(m599id = 1) String type, @SafeParcelable.Param(m599id = 2) String str, @SafeParcelable.Param(m599id = 3) Bundle requestData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        this.type = type;
        this.origin = str;
        this.requestData = requestData;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final Bundle getRequestData() {
        return this.requestData;
    }

    public final String getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        SignalCredentialStateRequestCreator.writeToParcel(this, dest, flags);
    }
}
