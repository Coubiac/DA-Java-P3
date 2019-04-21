# DA-Java-P3

Project 3 of the Openclassrooms diploma course for JAVA application developers.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To build the project, you need to install [Apache Maven](https://maven.apache.org/) and [JAVA JDK 8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

### Buildin JAR

When maven is installed, you can use it to generate a jar file:

```
mvn package
```

### Using the program

You can launch the program with a double click on the jar file. 
You need to have a config.properties file in the same directory of the program for customizing settings.
this is an exemple of the config.properties file:
```
#Tous les jeux
debugMode=false
#Mastermind
MMnbCoul=6
MMnbTrous=5
MMnbEssais=10
#Recherche
RechercheNbCases=5
RechercheNbEssais=10
```

debug mode can be activated by a parameter passed from the command line or by modifying the config.properties file. Here is the parameter to pass on the command line:
```
java -jar DA-Java-P3-1.0-SNAPSHOT.jar debug
```

## code documentation

You can see the [javadoc here](https://coubiac.github.io/DA-Java-P3)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Benoît GRISOT** - *Initial work* - [Coubiac](https://github.com/Coubiac)


## License

This project is licensed under the GPLv3 License - see the [GNU GPLv3](https://www.gnu.org/licenses/gpl.html) site for details
