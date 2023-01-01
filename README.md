# GeoMarkerWithCompose

<p align="left">
Geo Marker App with Compose and Using Google Maps API. 
</p>

# Tech stack and whys 🏗

<ul align="left">
<li><a href="https://kotlinlang.org/">Kotlin</a> Google officially supports Kotlin on Android as a “first-class” language</li>
<li><a href="https://developer.android.com/jetpack/compose">Jetpack Compose</a> Android’s modern toolkit for building native UI </li>
<li><a href="https://developer.android.com/jetpack/guide"> MVVM</a> Modern, maintainable, and Google suggested app architecture</li>
<li><a href="https://kotlinlang.org/docs/coroutines-overview.html">Coroutines and Work Manager</a> Asynchronous or non-blocking programming is better with coroutines</li>
<li><a href="https://square.github.io/retrofit/">Retrofit</a> Pulling data from API </li>
<li><a href="https://developer.android.com/jetpack">Jetpack Components</a> ViewModel, LiveData, DataBinding and more </li>
<li><a href="https://developer.android.com/studio/test">Testing</a> ViewModel, LiveData, DataBinding and more component are testing for best result of app </li>
<li><a href="https://console.cloud.google.com/google/maps-apis/overview/">Google Maps API</a> Create real-world, real-time experiences with the latest Maps, Routes, and Places features from Google Maps Platform. Built by the Google team for developers everywhere. </li>

</ul>

#  Good Points 🟢

<ul align="left">
<li>Not XML anymore </li>
<li>Modern architecture with modern libraries</li>
<li>Readable and scalable codebase</li>
<li>Responsive layout design, vertical and horizontal usage</li>
<li>Good state handling</li>
<li>Easy Test Implementation</li>
<li>Easy Google Maps API Implementation with Google Maps API</li>
</ul>

# Implementation API 

1. Setting up the dependencies:

<ul align="left">
<li>implementation 'com.google.maps.android:maps-compose:2.4.0'</li>
<li>implementation 'com.google.android.gms:play-services-maps:18.1.0'</li>
<li>implementation 'com.google.android.gms:play-services-location:20.0.0'</li>

The first is the Maps Compose library, and the other two are the Play Services maps SDK and location SDKs. Note that these dependencies already exist in the starter project, so there’s no need to re-add them.

2. Secondly, you need a Google Maps API key for you to be able to use any of Google Maps APIs. You can find instructions on how to get your <a href="https://developers.google.com/maps/documentation/android-sdk/get-api-key">key</a> here. Once you have your key, proceed to add it to your local.properties file as follows:

MAPS_API_KEY=YOUR_API_KEY




