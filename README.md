# xAPI Java Client

## Overview

Java client library for interacting with the XTB xAPI service.

API documentation: http://developers.xstore.pro/api

## Java version

This project is designed to compile and run on Java 1.8 and higher.

## xAPI Compliance

This client implements xAPI Protocol version 2.5.0: http://developers.xstore.pro/documentation/

## How to use it?

**⚠️ This project is ongoing work in progress. It shouldn't be used in any real-world cases yet, unless you are willing to
take the risk.**

With the above in mind, the basic idea is as following:

1. Add dependencies to pom or gradle:

```xml
<dependency>
    <groupId>TODO</groupId>
    <artifactId>TODO</artifactId>
    <version>TODO</version>
</dependency>
<dependency>
    <!-- In case you are not using jackson you can omit this and provide your own codec -->
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>YOUR JACKSON VERSION</version>
    </dependency>
<dependency>
    <!-- In case you are not using jackson you can omit this -->
    <!-- Just make sure to provide correct Instant deserialization from UNIX millis. -->
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jsr310</artifactId>
    <version>YOUR JACKSON VERSION</version>
</dependency>
```

2. Instantiate the client

```java
XApiConfig config =
        XApiConfig.builder()
            .host("xapi.xtb.com")
            .port(5124)
            .streamingHost("xapi.xtb.com")
            .streamingPort(5125)
            .build();
XApiClient client = XApi.newClient(config);
client.setCredentials(
        XApiCredentials
            .builder()
            .userId("USERID")
            .password("PASSWORD")
            .build());
```

*You can also provide custom JSON deserializer by implementing `com.olafparfienczyk.xapi.client.Codec` interface and
using `XApi#newClient(Codec, XApiConfig)` function. In such case you can omit adding `jackson-databind` dependency.*

3. Open streaming connection *(optional)*

```java
XApiStream stream=client.openStream();
new Thread(() -> {
    try {
        stream.listen();
    } catch (XApiException e) {
        //Listen failed, connection was not closed cleanly, reconnect perhaps?
    }
}).start();

stream.addGetBalanceListener(balance -> System.out.println("Got balance: " + balance.getData().getBalance()));
stream.addGetCandlesListener(candle -> System.out.println("Got candle" + candle.getData().getOpen()));
stream.getCandles("EURUSD"); //enable candles streaming for EURUSD
stream.getBalance(); //enable balance streaming
```

4. Send commands & enjoy

```java
List<SymbolRecord> symbols = client.getAllSymbols();
//do something with the symbols
```

The client and streams use TCP connections internally, so it's a good idea to close them once they're not needed
anymore.

In case any streams were opened by the client, those will have to be called first: `XApiStream#close()`.
Closing of the parent client will close all the child streams as per xAPI Specification:
http://developers.xstore.pro/documentation/#available-streaming-commands,
however it will be done so from the server-side and it will result in an exception in `XApiStream#listen()` method.
For that reason it's best to close all the streams before closing the client.

```java
stream.close();
client.close();
```

## Contributing

Contributions are welcome, whether it's fixing a typo, adding documentation, implementing features or fixing bugs -
anything that makes sense.
There are no hard rules to it as of now. Unless you want to do some major changes, you are more than welcome to submit a
PR. Otherwise, it would be better to consult beforehand.

### What's done?

- Communication (TCP connection, marshalling and unmarshalling)
- Client backbone for streaming and commands
- Authentication
- Few basic commands and streaming commands

### What needs to be done?

- Support for all commands
- Support for all streaming commands
- CI/CD
- Javadoc & Wiki
- Tests
- Connection pool (pooling library such as `apache-commons-pool` may be used)

## Bugs

If you find a bug or have an idea for a feature/improvement don't hesitate to create an issue.