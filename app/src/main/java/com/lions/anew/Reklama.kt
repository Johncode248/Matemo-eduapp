package com.lions.anew

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.MobileAds
class Reklama : AppCompatActivity() {
private var mInterstitialAd: InterstitialAd? = null
private final var TAG = "Reklama"
override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
 setContentView(R.layout.l_rekls)

var adRequest = AdRequest.Builder().build()

    MobileAds.initialize(this) {}

 InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
override fun onAdFailedToLoad(adError: LoadAdError) {
    Log.d(TAG, adError.toString())
   mInterstitialAd = null
}

  override fun onAdLoaded(interstitialAd: InterstitialAd) {
Log.d(TAG, "Ad was loaded.")
mInterstitialAd = interstitialAd
    }
})
val btn = findViewById<Button>(R.id.button_ad)
btn.setOnClickListener {
    if (mInterstitialAd != null) {
       mInterstitialAd?.show(this)
   } else {
       Log.d("TAG", "The interstitial ad wasn't ready yet.")
  }
}
 mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
   override fun onAdClicked() {
 //Called when a click is recorded for an ad.
     Log.d(TAG, "Ad was clicked.")
 }

override fun onAdDismissedFullScreenContent() {
// Called when ad is dismissed.
  Log.d(TAG, "Ad dismissed fullscreen content.")
    mInterstitialAd = null
}

override fun onAdFailedToShowFullScreenContent(adError: AdError) {
   // Called when ad fails to show.
    Log.e(TAG, "Ad failed to show fullscreen content.")
    mInterstitialAd = null
}

override fun onAdImpression() {
 //Called when an impression is recorded for an ad.
   Log.d(TAG, "Ad recorded an impression.")
}

override fun onAdShowedFullScreenContent() {
// Called when ad is shown.
     Log.d(TAG, "Ad showed fullscreen content.")
 }
}
}
}
