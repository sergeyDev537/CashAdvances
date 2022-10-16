package com.most4dev.cashadvances.background;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;

import androidx.lifecycle.MutableLiveData;

import com.most4dev.cashadvances.Config;
import com.most4dev.cashadvances.managers.JSONManager;
import com.most4dev.cashadvances.managers.LocaleLoansManager;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetStartKey extends AsyncTask<Map<String, String>, Void, String> {

    private final Context contextStartKey;
    private final MutableLiveData<String> liveDataForecastStartKey;

    public GetStartKey(Context contextStartKey,
                       MutableLiveData<String> liveDataStartKey) {
        this.contextStartKey = contextStartKey;
        this.liveDataForecastStartKey = liveDataStartKey;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @SafeVarargs
    @Override
    protected final String doInBackground(Map<String, String>... postDataStartKey) {
        String responseCodeStartKey = null;
        try {
            RequestListForecast clientForecastStartKey = new RequestListForecast();
            responseCodeStartKey = clientForecastStartKey.run(
            );
        } catch (IOException eStartKey) {
            eStartKey.printStackTrace();
        }
        return responseCodeStartKey;
    }


    @Override
    protected void onPostExecute(String strPostExecuteStartKey) {
        if (strPostExecuteStartKey == null || strPostExecuteStartKey.contains("1ok")){
            liveDataForecastStartKey.postValue("1ok");
            Config.Companion.setURL_PAYDAY_LOANS(
                    JSONManager.Companion.parseJsonFormatPayDayLink(strPostExecuteStartKey));
            Config.Companion.setURL_INSTALLMENT_LOANS(
                    JSONManager.Companion.parseJsonFormatInstallmentLink(strPostExecuteStartKey));
        }
        else{
            liveDataForecastStartKey.postValue("2no");
        }
        super.onPostExecute(strPostExecuteStartKey);
    }

    public class RequestListForecast {
        OkHttpClient okHttpClientStartKey = new OkHttpClient();

        String run() throws IOException {
            Request requestStartKey = new Request.Builder()
                    .url(Config.URL_START)
                    .post(postDataStartKey())
                    .build();
            try (Response response = okHttpClientStartKey.newCall(requestStartKey).execute()) {
                return Objects.requireNonNull(response.body()).string();
            }
        }

        @SuppressLint("HardwareIds")
        public RequestBody postDataStartKey() {
            MultipartBody.Builder builderStartKey = new MultipartBody.Builder();
            builderStartKey.setType(MultipartBody.FORM);
            builderStartKey.addFormDataPart(
                    "aid",
                    Settings.Secure.getString(contextStartKey.getContentResolver(),
                            Settings.Secure.ANDROID_ID)
            );
            builderStartKey.addFormDataPart("model", Build.MODEL);
            builderStartKey.addFormDataPart("device", Build.BRAND);
            builderStartKey.addFormDataPart("pac", contextStartKey.getPackageName());
            builderStartKey.addFormDataPart(
                    "referrer",
                    PreferenceManager.getDefaultSharedPreferences(contextStartKey)
                            .getString(contextStartKey.getPackageName() +
                                    "/referrerValue", ""));
            builderStartKey.addFormDataPart(
                    "advertisingID",
                    PreferenceManager.getDefaultSharedPreferences(contextStartKey)
                            .getString(contextStartKey.getPackageName() +
                                    "/adsKeyApplication", "null"));
            builderStartKey.addFormDataPart("simcode",
                    LocaleLoansManager.Companion.getSimCodeLocale(contextStartKey));
            builderStartKey.addFormDataPart("lang",
                    LocaleLoansManager.Companion.getLangKeyboardLocale());
            builderStartKey.addFormDataPart("country",
                    LocaleLoansManager.Companion.getCountryLocale());
            builderStartKey.build();
            return builderStartKey.build();
        }
    }
}
