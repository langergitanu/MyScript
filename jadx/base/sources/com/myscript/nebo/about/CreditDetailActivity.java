package com.myscript.nebo.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.about.CreditsActivity;

/* JADX INFO: loaded from: classes5.dex */
public class CreditDetailActivity extends AppCompatActivity {
    public static Intent newIntent(Context context, CreditsActivity.CreditData creditData) {
        Intent intent = new Intent(context, (Class<?>) CreditDetailActivity.class);
        intent.putExtra("CreditDetailActivity#Title", creditData.title);
        intent.putExtra("CreditDetailActivity#Description", creditData.content);
        return intent;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C6079R.layout.credit_detail_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (bundle == null) {
            Intent intent = getIntent();
            getSupportFragmentManager().beginTransaction().add(C6079R.id.credit_detail_container, CreditDetailFragment.newInstance(intent.getIntExtra("CreditDetailActivity#Title", -1), intent.getIntExtra("CreditDetailActivity#Description", -1))).commit();
        }
    }
}
