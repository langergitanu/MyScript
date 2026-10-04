package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaa extends BroadcastReceiver {
    final /* synthetic */ zzab zza;
    private boolean zzb;
    private final boolean zzc;

    zzaa(zzab zzabVar, boolean z) {
        Objects.requireNonNull(zzabVar);
        this.zza = zzabVar;
        this.zzc = z;
    }

    private final void zzd(Bundle bundle, BillingResult billingResult, int i, zzjk zzjkVar, long j, boolean z) {
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
                this.zza.zzf.zzd(zziw.zzc(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD")), j, z);
            } else {
                this.zza.zzf.zzd(zzcy.zzb(zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, i, billingResult, null, zzjkVar), j, z);
            }
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        byte b;
        BillingResult billingResultZzi;
        int iIntValue;
        String action = intent.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -1484087650) {
            if (iHashCode != -337612916) {
                b = (iHashCode == 345207161 && action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) ? (byte) 2 : (byte) -1;
            } else if (action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                b = 1;
            }
        } else if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            b = 0;
        }
        zzjk zzjkVar = b != 0 ? b != 1 ? b != 2 ? zzjk.BROADCAST_ACTION_UNSPECIFIED : zzjk.ALTERNATIVE_BILLING_ACTION : zzjk.LOCAL_PURCHASES_UPDATED_ACTION : zzjk.PURCHASES_UPDATED_ACTION;
        zzjk zzjkVar2 = zzjk.LOCAL_PURCHASES_UPDATED_ACTION;
        int i = (zzjkVar.equals(zzjkVar2) || zzjkVar.equals(zzjk.ALTERNATIVE_BILLING_ACTION)) ? 2 : zzjkVar.equals(zzjk.PURCHASES_UPDATED_ACTION) ? 32 : 1;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "Bundle is null.");
            zzab zzabVar = this.zza;
            zzcz zzczVar = zzabVar.zzf;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_IN_BROADCAST_RECEIVER;
            BillingResult billingResult = zzdc.zzh;
            zzczVar.zza(zzcy.zzb(zzjdVar, i, billingResult, null, zzjkVar));
            if (zzabVar.zzb != null) {
                zzabVar.zzb.onPurchasesUpdated(billingResult, null);
            }
        } else {
            if (i == 2) {
                int i2 = com.google.android.gms.internal.play_billing.zzc.zza;
                if (intent == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingHelper", "Got null intent!");
                    BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                    builderNewBuilder.setResponseCode(6);
                    builderNewBuilder.setOnPurchasesUpdatedSubResponseCode(0);
                    builderNewBuilder.setDebugMessage("An internal error occurred.");
                    billingResultZzi = builderNewBuilder.build();
                } else {
                    BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
                    builderNewBuilder2.setResponseCode(com.google.android.gms.internal.play_billing.zzc.zzb(intent.getExtras(), "BillingBroadcastManager"));
                    Bundle extras2 = intent.getExtras();
                    if (extras2 == null) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "Unexpected null bundle received!");
                    } else {
                        Object obj = extras2.get("SUB_RESPONSE_CODE");
                        if (obj == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "getOnPurchasesUpdatedSubResponseCodeFromBundle() got null response code, assuming OK");
                        } else if (obj instanceof Integer) {
                            iIntValue = ((Integer) obj).intValue();
                            builderNewBuilder2.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                            builderNewBuilder2.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzk(intent.getExtras(), "BillingBroadcastManager"));
                            billingResultZzi = builderNewBuilder2.build();
                        } else {
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "Unexpected type for bundle sub response code: ".concat(String.valueOf(obj.getClass().getName())));
                        }
                    }
                    iIntValue = 0;
                    builderNewBuilder2.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                    builderNewBuilder2.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzk(intent.getExtras(), "BillingBroadcastManager"));
                    billingResultZzi = builderNewBuilder2.build();
                }
            } else {
                billingResultZzi = com.google.android.gms.internal.play_billing.zzc.zzi(intent, "BillingBroadcastManager");
            }
            BillingResult billingResult2 = billingResultZzi;
            long j = extras.getLong("billingClientTransactionId", 0L);
            boolean z = extras.getBoolean("wasServiceAutoReconnected", false);
            if (zzjkVar.equals(zzjk.PURCHASES_UPDATED_ACTION) || zzjkVar.equals(zzjkVar2)) {
                List<Purchase> listZzm = com.google.android.gms.internal.play_billing.zzc.zzm(extras);
                if (billingResult2.getResponseCode() == 0) {
                    this.zza.zzf.zzh(zzcy.zzc(i, zzjkVar), j, z);
                } else {
                    zzd(extras, billingResult2, i, zzjkVar, j, z);
                }
                this.zza.zzb.onPurchasesUpdated(billingResult2, listZzm);
                return;
            }
            if (zzjkVar.equals(zzjk.ALTERNATIVE_BILLING_ACTION)) {
                if (billingResult2.getResponseCode() != 0) {
                    zzd(extras, billingResult2, i, zzjkVar, j, z);
                    this.zza.zzb.onPurchasesUpdated(billingResult2, com.google.android.gms.internal.play_billing.zzbw.zzk());
                    return;
                }
                zzab zzabVar2 = this.zza;
                if (zzabVar2.zzc == null && zzabVar2.zzd == null && zzabVar2.zze == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "No valid alternative billing listener is registered.");
                    zzcz zzczVar2 = zzabVar2.zzf;
                    zzjd zzjdVar2 = zzjd.NULL_DEVELOPER_MANAGED_BILLING_LISTENER;
                    BillingResult billingResult3 = zzdc.zzh;
                    zzczVar2.zzd(zzcy.zzb(zzjdVar2, i, billingResult3, null, zzjkVar), j, z);
                    zzabVar2.zzb.onPurchasesUpdated(billingResult3, com.google.android.gms.internal.play_billing.zzbw.zzk());
                    return;
                }
                String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                    zzcz zzczVar3 = zzabVar2.zzf;
                    zzjd zzjdVar3 = zzjd.MISSING_ALTERNATIVE_BILLING_USER_CHOICE_DATA;
                    BillingResult billingResult4 = zzdc.zzh;
                    zzczVar3.zzd(zzcy.zzb(zzjdVar3, i, billingResult4, null, zzjkVar), j, z);
                    zzabVar2.zzb.onPurchasesUpdated(billingResult4, com.google.android.gms.internal.play_billing.zzbw.zzk());
                    return;
                }
                try {
                    if (zzabVar2.zzd != null) {
                        zzabVar2.zzd.userSelectedAlternativeBilling(new UserChoiceDetails(string));
                    } else if (zzabVar2.zze != null) {
                        zzabVar2.zze.onUserSelectedDeveloperBilling(new DeveloperProvidedBillingDetails(string));
                    } else {
                        JSONArray jSONArrayOptJSONArray = new JSONObject(string).optJSONArray(Keys.PRODUCTS);
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                                if (jSONObjectOptJSONObject != null) {
                                    arrayList.add(new zzc(jSONObjectOptJSONObject, null));
                                }
                            }
                        }
                        zzabVar2.zzc.zza();
                    }
                    this.zza.zzf.zzh(zzcy.zzc(i, zzjkVar), j, z);
                } catch (JSONException unused) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", string));
                    zzab zzabVar3 = this.zza;
                    zzcz zzczVar4 = zzabVar3.zzf;
                    zzjd zzjdVar4 = zzjd.INVALID_ALTERNATIVE_BILLING_USER_CHOICE_DATA;
                    BillingResult billingResult5 = zzdc.zzh;
                    zzczVar4.zzd(zzcy.zzb(zzjdVar4, i, billingResult5, null, zzjkVar), j, z);
                    zzabVar3.zzb.onPurchasesUpdated(billingResult5, com.google.android.gms.internal.play_billing.zzbw.zzk());
                }
            }
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        this.zzb = true;
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter, String str) {
        zzaa zzaaVar;
        try {
            try {
                if (this.zzb) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    zzaaVar = this;
                    context.registerReceiver(zzaaVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.zzc ? 4 : 2);
                } else {
                    zzaaVar = this;
                    context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                zzaaVar.zzb = true;
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final synchronized void zzc(Context context) {
        if (!this.zzb) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.zzb = false;
        }
    }
}
