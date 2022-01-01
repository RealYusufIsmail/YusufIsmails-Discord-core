[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda4/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda4)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda5/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda5)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda.basic/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/jda.basic)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/javacord.basic/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/javacord.basic)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/annotations/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/annotations)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/config/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.yusufsdiscordbot/config)


# YusufIsmail's-Discord-core
All the core JDA classes for my bots and for others.

To use my core all you need to do is import it.

There is 4 versions of my core:
1. [Core which uses JDA 4](#jda-4)
2. [Core which uses JDA 5](#jda-5)
3. [Basic core which uses JDA 4](#basic-core-which-uses-jda-4)
4. [Basic core which uses JavaCord](#basic-core-which-uses-javacord)

## JDA 4

```gradle
repositories {
    mavenCentral()
    maven {
        name 'm2-dv8tion'
        url 'https://m2.dv8tion.net/releases'
    }
}
dependencies {
    //Yusuf Ismail's Discord Core
    implementation group: 'net.dv8tion', name: 'JDA', version: '4.4.0_352'
    implementation group: 'io.github.yusufsdiscordbot', name: 'jda4', version: '1.0.45'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.8'
    implementation group: 'io.github.yusufsdiscordbot', name: 'config', version: '1.0.2'
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
    //In alpha stage
    implementation group: 'net.dv8tion', name: 'JDA', version: '5.0.0-alpha.3'
    implementation group: 'io.github.yusufsdiscordbot', name: 'jda5', version: '2.0.0-alpha.6'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.8'
    implementation group: 'io.github.yusufsdiscordbot', name: 'config', version: '1.0.2'
}
```

## Basic core which uses JDA 4

```gradle
repositories {
    mavenCentral()
    maven {
        name 'm2-dv8tion'
        url 'https://m2.dv8tion.net/releases'
    }
}
dependencies {
    //Yusuf Ismail's Discord Core
    //Basic version
    implementation group: 'net.dv8tion', name: 'JDA', version: '4.4.0_352'
    implementation group: 'io.github.yusufsdiscordbot', name: 'jda.basic', version: '1.0.8'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.6'
    implementation group: 'io.github.yusufsdiscordbot', name: 'config', version: '1.0.1'
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
    implementation group: 'org.javacord', name: 'javacord', version: '3.3.2'
    implementation group: 'io.github.yusufsdiscordbot', name: 'javacord.basic', version: '1.0.5'
    implementation group: 'io.github.yusufsdiscordbot', name: 'annotations', version: '1.0.8'
    implementation group: 'io.github.yusufsdiscordbot', name: 'config', version: '1.0.2'
}
```
