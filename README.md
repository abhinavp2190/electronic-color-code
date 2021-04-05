# React with Spring Boot for Electronic Color Code Calculator demo

## Working with Electronic Color Code Calculator in Eclipse/STS

### prerequisites
The following items should be installed in your system:
* Maven (https://maven.apache.org/install.html)
* git command line tool 
* Eclipse with the STS plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

### Steps:

1) In the command line
```
git clone https://github.com/abhinavp2190/electronic-color-code.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```

## Install and run

Note: Spring Boot Server App must be running before starting the client!

To start the server, launch a Terminal and run from the project's root folder (`electronic-color-code`):
```
./mvn spring-boot:run
```

When the server is running you can try to access the API for example to query all known multipliers:
```
curl http://localhost:8080/ecc/multiplier
```

After starting the server you can install and run the UI from the `ui` folder:

1. `npm install` (installs the node modules)
2. `npm start` 
3. Open `http://localhost:3000`

## Running Electronic Color Code Calculator locally
```
	git clone https://github.com/abhinavp2190/electronic-color-code.git
	cd electronic-color-code
	mvn spring-boot:run
```

You can then access Electronic Color Code Calculator here: http://localhost:8080/ecc

```
	cd ui
	npm start
```

You can then access frontend here: http://localhost:3000/

## Database configuration

In its default configuration, Electronic Color Code Calculator uses an in-memory database (H2) which
gets populated at startup with data. 
