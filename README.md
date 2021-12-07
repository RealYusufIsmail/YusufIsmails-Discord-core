[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda4/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda4)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda5/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda5)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda.basic/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda.basic)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/javacord.basic/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/javacord.basic)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/annotations/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/annotations)

# YusufIsmail's-Discord-core
All the core JDA classes for my bots and for others.

To use my core all you need to do is import it.

There is 3 versions of my core:
1. [Core which uses JDA 4](#jda-4)
2. [Core which uses JDA 5](#jda-5)
3. [Basic core which uses JDA 4](#basic-core-which-uses-jda-4)
4. [Basic core which uses JavaCord](#basic-core-which-uses-javacord)

## JDA 4

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

## JDA 5

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

## Basic core which uses JDA 4

```gradle
repositories {
    mavenCentral()
}
dependencies {
    //Yusuf Ismail's Discord Core
    //Basic version
    implementation group: 'io.github.yusufsdiscordbot', name: 'jda.basic', version: '1.0.3'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.4'
}
```

## Basic core which uses JavaCord
```gradle
repositories {
    mavenCentral()
}
dependencies {
    //Yusuf Ismail's Discord Core
    //Basic version
    implementation group: 'io.github.yusufsdiscordbot', name: 'javacord.basic', version: '1.0.3'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.4'
}
```
