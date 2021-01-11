# SessionTime

# Fique por dentro dos filmes mais populares, recentes e bem avaliados do mundo do cinema, avalie e favorite  

<p float="left">
  <img src="https://github.com/AndreAgel94/SessionTime/blob/dev/app/src/main/res/drawable/c.gif"/>
  <img src="https://github.com/AndreAgel94/SessionTime/blob/dev/app/src/main/res/drawable/b.gif"/> 
</p>

## Versão2
* Usando Room database para salvar os filmes preferidos do usuário
* Tela de favoritos com Grid Layout\
* Floating BottomNavBar

<p float="left">
  <img src="https://github.com/AndreAgel94/SessionTime/blob/dev/app/src/main/res/drawable/v2.gif"/>
  <img src="https://github.com/AndreAgel94/SessionTime/blob/dev/app/src/main/res/drawable/favoritescreen.png" width="300px" height="605px"/> 
</p>

### Features
* Descobrir os filmes mais populares e bem avaliados do cinema
* Ver detalhes do filme como sinopse, elenco e avaliação
* Favoritar filmes e tela de favoritos

### Dependências 
* [The Movie Database](https://developer.marvel.com/)
* [Retrofit](https://square.github.io/retrofit/)
A type-safe HTTP client for Android and Java
* [Koin](https://insert-koin.io/)
A pragmatic lightweight dependency injection framework for Kotlin developers.
* [Gson](https://github.com/google/gson)
Gson is a Java library that can be used to convert Java Objects into their JSON representation. 
It can also be used to convert a JSON string to an equivalent Java object.
* [Glide](https://github.com/bumptech/glide)
Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding,
memory and disk caching, and resource pooling into a simple and easy to use interface.
* [Recycler View](https://developer.android.com/guide/topics/ui/layout/recyclerview)
Create a List with RecyclerView
* [LikeButton](https://github.com/jd-alexander/LikeButton)
Cute Heart Like Button 
* [Room](https://developer.android.com/jetpack/androidx/releases/room)
The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.

### Architecture
  * [MVVM with Android Architecture Components](https://developer.android.com/jetpack/docs/guide#recommended-app-arch)    
  

<img src="https://user-images.githubusercontent.com/25203907/73149177-d0c80000-409e-11ea-8899-4d99f7afea95.png" width="500"/>


### Como executar?
* Clone o repositório <br />
```
$ git clone https://github.com/AndreAgel94/SessionTime.git
```
* instale o [Android Studio](https://developer.android.com/studio/?gclid=Cj0KCQjwqfz6BRD8ARIsAIXQCf1TDuk2Rpr7UFi3W57PvX4WS4dVyMI8QK0uaK-zYwq1T-TweWTCuvYaAhm8EALw_wcB&gclsrc=aw.ds)
* Abra o projeto pelo Android Studio
* dê permissão de acesso a internet ao projeto, no seu manifest adcione: <br />

```
<uses-permission android:name="android.permission.INTERNET" />
```

* Substitua a constante do arquivo Constants.kt para a sua Chave de API

```
const val API_KEY = "Sua chave de API"
```

* Em seu gradle(Module: app) implemente as depêndencias e sincronize(Sync Now)
* Execute em um emulador <br /> 
ou [no seu aparelho](https://developer.android.com/training/basics/firstapp/running-app?hl=pt-br)
