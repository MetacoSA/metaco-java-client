# Metaco API Java client [![Build Status](https://travis-ci.org/MetacoSA/metaco-java-client.svg?branch=master)](https://travis-ci.org/MetacoSA/metaco-java-client)

[Metaco](https://metaco.com) REST API provides a set of services to integrate Metaco into third-party applications. It offers trading and payment facilities as well as wallet management features.

Our Java Client implements every single functionality of the API.
You can find a detailed documentation here : [API Documentation](http://docs.metaco.apiary.io/)

Installation
----------------------------------------------

### Using Maven

Add the following dependency to your project's Maven pom.xml:

```xml
<dependency>
	<groupId>com.metaco.api</groupId>
	<artifactId>metaco-java-client</artifactId>
	<version>1.0.0</version>
</dependency>
```

### Manual

To be updated.

Usage
----------------------------------------------

You can use our [Unit tests](https://github.com/MetacoSA/metaco-java-client/tree/master/src/test/java/com/metaco/api) to learn the basics or the links in the summary of this document.

Testing
----------------------------------------------
The tests requires a testnet environnement to work.

Define the following environment variables :
* METACO_ENV_API_ID : Your testnet API ID
* METACO_ENV_API_KEY : Your testnet API Key
* METACO_ENV_API_URL : http://api.testnet.metaco.com/v1/ (Or the endpoint you want to run your tests with)
* METACO_ENV_WALLET_PRIVATE_KEY_HEX : The private key of your testnet wallet (hex-encoded)

Run `mvn clean test`

Contributing
----------------------------------------------
1. Fork this repository and make your changes in your fork
2. Add or Update the tests and run `mvn clean test` to make sure they pass
3. Commit and push your changes to your fork `git push origin master`
4. Submit a pull request and we will handle the rest :)

Known Issues / Gotcha
----------------------------------------------
* The api is still unstable.

License
----------------------------------------------
MIT (See LICENSE).
