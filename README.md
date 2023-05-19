# PacketWrapper

[![Build](https://github.com/lukalt/PacketWrapper/actions/workflows/build.yml/badge.svg)](https://github.com/lukalt/PacketWrapper/actions/workflows/build.yml)
[![Javadoc](https://img.shields.io/badge/JavaDoc-Online-green)](https://lukalt.github.io/PacketWrapper/javadocs/apidocs)
![GitHub](https://img.shields.io/github/license/lukalt/PacketWrapper)
[![ProtocolLib](https://img.shields.io/badge/ProtocolLib-%3E%3D%205.1.0--SNAPSHOT-blue)](https://ci.dmulloy2.net/job/ProtocolLib/645/)
[![ProtocolLib](https://img.shields.io/badge/Minecraft-1.19.4-green)](https://papermc.io/downloads/paper)

This is an unofficial continuation of PacketWrapper by dmulloy2 and aadnk. The original versions can be found [here](https://github.com/dmulloy2/PacketWrapper) and [here](https://github.com/aadnk/PacketWrapper).

When reading and writing packets in [ProtocolLib](http://www.spigotmc.org/resources/protocollib.1997/), it is necessary to know the order in which the fields are stored in memory. This requires you to decompile the Minecraft source code with [JD-GUI](http://jd.benow.ca/) or find it in the Spigot work directory (/work/decompile/), while decoding the meaning of a field by looking up an online [wiki](http://www.wiki.vg/Protocol) resource ([tutorial](http://forums.bukkit.org/threads/lib-1-4-6-protocollib-2-0-0-safely-and-easily-modify-sent-and-recieved-packets.101035/page-2#post-1366140)). It would be much easier if these packets could be accessed as any other normal Java bean. 

Enter PacketWrapper. It contains wrapper classes for all known packets in 1.19.4, providing you with access to the fields by name, along with automatic conversion to existing Bukkit enumerations and classes. It also includes a number of custom enumerations when appropriate.

### How to use

#### Maven:

First, add this repository

```
<repositories>
    <repository>
        <id>lukasalt-repo</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then, include the actual dependency

```
<dependencies>
    <dependency>
        <groupId>com.comphenix.packetwrapper</groupId>
        <artifactId>PacketWrapper</artifactId>
        <version>1.19.4-2.1.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Either install PacketWrapper as a plugin or shade it into your plugin. Alternatively, you can copy just the required classes (AbstractPacket and the Wrappers you are using) directly to your project.


#### Gradle (build.gradle):

First register the jitpack repository in your build.gradle:


```
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```

Then add the actual dependency:

```
dependencies {
    ...
    compile 'com.comphenix.packetwrapper:PacketWrapper:1.19.4-2.1.0'
}
```

Either install PacketWrapper as a plugin on the server or shadow it into your plugin. Alternatively, you can copy just the required classes (AbstractPacket and the Wrappers you are using) directly to your project.

### Dependencies
* [ProtocolLib 5.1.0-SNAPSHOT or later](https://hangar.papermc.io/dmulloy2/ProtocolLib)

### Resources
* [Downloads](https://github.com/lukalt/PacketWrapper/releases)

### Building
You can compile this project yourself by using the latest version of Maven using `mvn clean install`.

### Remarks
This project was mostly generated by a [script](https://github.com/lukalt/packetwrapper-generator). 
