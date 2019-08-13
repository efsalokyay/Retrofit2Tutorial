package com.efsalokyay.retrofit2calismasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private KisilerDaoInterface kisilerDIF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kisilerDIF = ApiUtils.getKisilerDaoInterface();

        tumKisiler();
        //kisiAra();
        //kisiSil();
        //kisiEkle();
        //kisiGuncelle();
    }

    public void tumKisiler() {
        kisilerDIF.tumKisiler().enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {

                List<Kisiler> kisilerListe = response.body().getKisiler();

                for (Kisiler k : kisilerListe) {
                    Log.e("**********", "**********");
                    Log.e("kisi_id", k.getKisiId());
                    Log.e("kisi_ad", k.getKisiAd());
                    Log.e("kisi_tel", k.getKisiTel());
                    Log.e("**********", "**********");
                }
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }

    public void kisiAra() {
        kisilerDIF.kisiAra("a").enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> kisilerListe = response.body().getKisiler();

                for (Kisiler k : kisilerListe) {
                    Log.e("**********", "**********");
                    Log.e("kisi_id", k.getKisiId());
                    Log.e("kisi_ad", k.getKisiAd());
                    Log.e("kisi_tel", k.getKisiTel());
                    Log.e("**********", "**********");
                }
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }

    public void kisiSil() {
        kisilerDIF.kisiSil(36).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Başarı", response.body().getSuccess().toString());
                Log.e("Mesaj", response.body().getMessage());
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void kisiEkle() {
        kisilerDIF.kisiEkle("Ahmed", "05050554565").enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Başarı", response.body().getSuccess().toString());
                Log.e("Mesaj", response.body().getMessage());
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void kisiGuncelle() {

        kisilerDIF.kisiGuncelle(35, "Nedim", "05659568978").enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Başarı", response.body().getSuccess().toString());
                Log.e("Mesaj", response.body().getMessage());
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

}
