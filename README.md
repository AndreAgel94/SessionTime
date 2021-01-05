# SessionTime

## Fique por dentro dos filmes mais populares, recentes e bem avaliados do mundo do cinema, avalie e favorite  

<p float="left">
  <img src="https://github.com/AndreAgel94/SessionTime/blob/dev/app/src/main/res/drawable/5.gif"/>
  <img src="https://github.com/AndreAgel94/SessionTime/blob/dev/app/src/main/res/drawable/4.gif"/> 
</p>

### Projeto
O usuário pode ver uma lista dos filmes mais populares, atuais e bem avaliados do cinema, escolhendo
um filme ele pode saber mais informação sobre, como sua sinopse, avaliação e elenco, podendo favoritar o filme,
Utilizando a [The Movie Database](https://developer.marvel.com/) para a busca de dados.
### Dependências 

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
