[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/application/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/application)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/annotations/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/annotations)

# YusufIsmail's-Discord-core
All the core JDA classes for my bots and for others.

To use my core all you need to do is import it.

So for Jda 4 you need this

```gradle
repositories {
    mavenCentral()
}
dependencies {
    //Yusuf Ismail's Discord Core
    implementation group: 'io.github.yusufsdiscordbot', name: 'jda4', version: '1.0.35'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.4'
}
```

For Jda 5 you need this

```gradle
repositories {
    mavenCentral()
}
dependencies {
    //Yusuf Ismail's Discord Core
    //JDA 5
    //To be released
    implementation group: 'io.github.yusufsdiscordbot', name: 'jda5', version: '2.0.0'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.4'
}
```

Finally, for the basic version of my core you need:

So for Jda 4 you need this

```gradle
repositories {
    mavenCentral()
}
dependencies {
    //Yusuf Ismail's Discord Core
    //Basic version
    implementation group: 'io.github.yusufsdiscordbot', name: 'application.basic', version: '1.0.3'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.4'
}
```