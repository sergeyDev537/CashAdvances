package com.most4dev.cashadvances.background;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;

import androidx.lifecycle.MutableLiveData;

import com.most4dev.cashadvances.Config;
import com.most4dev.cashadvances.managers.LocaleLoansManager;
import com.most4dev.cashadvances.model.ThemeModelLoans;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetAboutTheme extends AsyncTask<Map<String, String>, Void, String> {

    @SuppressLint("StaticFieldLeak")
    private final Context contextAboutTheme;
    private final MutableLiveData<List<ThemeModelLoans>> liveDataAboutTheme;

    public GetAboutTheme(Context contextAboutTheme,
                         MutableLiveData<List<ThemeModelLoans>> liveDataAboutTheme) {
        this.contextAboutTheme = contextAboutTheme;
        this.liveDataAboutTheme = liveDataAboutTheme;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @SafeVarargs
    @Override
    protected final String doInBackground(Map<String, String>... postDataAboutTheme) {
        String responseCodeAboutTheme = null;
        try {
            RequestListTheme clientForecastAboutTheme = new RequestListTheme();
            responseCodeAboutTheme = clientForecastAboutTheme.run(
            );
        } catch (IOException eAboutTheme) {
            eAboutTheme.printStackTrace();
        }
        return responseCodeAboutTheme;
    }


    @Override
    protected void onPostExecute(String strPostExecuteAboutTheme) {
        try {
            convertToListAboutTheme(strPostExecuteAboutTheme);
        } catch (Exception e) {
            e.printStackTrace();
            liveDataAboutTheme.postValue(new ArrayList<>());
        }

        super.onPostExecute(strPostExecuteAboutTheme);
    }

    private void convertToListAboutTheme(String strToConvertAboutTheme) {
        Gson gsonAboutTheme = new Gson();
        Type typeAboutTheme = new TypeToken<ArrayList<ThemeModelLoans>>() {
        }.getType();
        liveDataAboutTheme.postValue(gsonAboutTheme.fromJson(strToConvertAboutTheme, typeAboutTheme));
    }


    public class RequestListTheme {
        OkHttpClient okHttpClientAboutTheme = new OkHttpClient();

        String run() throws IOException {
            Request requestAboutTheme = new Request.Builder()
                    .url(Config.URL_ABOUT_THEME)
                    .post(postDataAboutTheme())
                    .build();
            try (Response response = okHttpClientAboutTheme.newCall(requestAboutTheme).execute()) {
                return Objects.requireNonNull(response.body()).string();
            }
        }

        @SuppressLint("HardwareIds")
        public RequestBody postDataAboutTheme() {
            MultipartBody.Builder builderAboutTheme = new MultipartBody.Builder();
            builderAboutTheme.setType(MultipartBody.FORM);
            builderAboutTheme.addFormDataPart(
                    "aid",
                    Settings.Secure.getString(contextAboutTheme.getContentResolver(),
                            Settings.Secure.ANDROID_ID)
            );
            builderAboutTheme.addFormDataPart("model", Build.MODEL);
            builderAboutTheme.addFormDataPart("device", Build.BRAND);
            builderAboutTheme.addFormDataPart("pac", contextAboutTheme.getPackageName());
            builderAboutTheme.addFormDataPart(
                    "referrer",
                    PreferenceManager.getDefaultSharedPreferences(contextAboutTheme)
                            .getString(contextAboutTheme.getPackageName() +
                                    "/referrerValue", ""));
            builderAboutTheme.addFormDataPart(
                    "advertisingID",
                    PreferenceManager.getDefaultSharedPreferences(contextAboutTheme)
                            .getString(contextAboutTheme.getPackageName() +
                                    "/adsKeyApplication", "null"));
            builderAboutTheme.addFormDataPart("simcode",
                    LocaleLoansManager.Companion.getSimCodeLocale(contextAboutTheme));
            builderAboutTheme.addFormDataPart("lang",
                    LocaleLoansManager.Companion.getLangKeyboardLocale());
            builderAboutTheme.addFormDataPart("country",
                    LocaleLoansManager.Companion.getCountryLocale());
            builderAboutTheme.build();
            return builderAboutTheme.build();
        }
    }
}
