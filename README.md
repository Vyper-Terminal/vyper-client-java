# Vyper API Java SDK

![Vyper](https://images.vyper.trade/0000/vyper-header)

A Java SDK for interacting with the [Vyper API](https://build.vyper.trade/). This library allows developers to integrate Vyper's http and websocket api into their Java applications with ease.

## Table of Contents

-   [Vyper API Java SDK](#vyper-api-java-sdk)
    -   [Table of Contents](#table-of-contents)
    -   [Installation](#installation)
        -   [Using npm:](#using-npm)
    -   [Quick Start](#quick-start)
    -   [Usage](#usage)
        -   [Client Initialization](#client-initialization)
        -   [REST API Example](#rest-api-example)
        -   [WebSocket API Example](#websocket-api-example)
    -   [API Documentation](#api-documentation)

## Installation

To use the Vyper API Java SDK in your project, you can include it in your Maven project. Add the following dependency to your `pom.xml:`

### Using npm:

```xml
<dependency>
    <groupId>com.vyper</groupId>
    <artifactId>vyper-client-java</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Quick Start

Here's a simple example to get you started:

```java
import com.vyper.sdk.VyperClient;
import com.vyper.sdk.exceptions.VyperApiException;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the client with your API key
            VyperClient client = new VyperClient("your_api_key_here");

            // Get the list of chain IDs supported by Vyper
            var chainIds = client.getChainIds();
            System.out.println("Supported chain IDs: " + chainIds);
        } catch (VyperApiException e) {
            e.printStackTrace();
        }
    }
}
```

## Usage

### Client Initialization

The `VyperClient` class provides access to the RESTful API endpoints:

```java
import com.vyper.sdk.VyperClient;

// Create a client instance
VyperClient client = new VyperClient("your_api_key_here");
```

### REST API Example

Retrieve the market data for a specific token:

```java
import com.vyper.sdk.VyperClient;
import com.vyper.sdk.exceptions.VyperApiException;
import com.vyper.sdk.models.TokenATH;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the client with your API key
            VyperClient client = new VyperClient("your_api_key_here");

            // Fetch the All-Time High (ATH) data for a token
            TokenATH tokenAth = client.getTokenAth(1, "AVs9TA4nWDzfPJE9gGVNJMVhcQy3V9PGazuz33BfG2RA");
            System.out.println("Market Cap USD: " + tokenAth.getMarketCapUsd());
            System.out.println("Timestamp: " + tokenAth.getTimestamp());
        } catch (VyperApiException e) {
            e.printStackTrace();
        }
    }
}
```

### WebSocket API Example

```java
import com.vyper.sdk.VyperWebsocketClient;
import com.vyper.sdk.VyperWebsocketClient.FeedType;
import com.vyper.sdk.VyperWebsocketClient.SubscriptionMessageType;
import com.vyper.sdk.VyperWebsocketClient.SubscriptionType;
import com.vyper.sdk.exceptions.VyperWebsocketException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the WebSocket client with your API key
            VyperWebsocketClient wsClient = new VyperWebsocketClient("your_api_key_here");

            // Define a message handler
            wsClient.setMessageHandler(message -> {
                System.out.println("Received message: " + message);
            });

            // Connect to the WebSocket and subscribe to token events
            wsClient.connect(FeedType.TOKEN_EVENTS);
            wsClient.subscribe(
                FeedType.TOKEN_EVENTS,
                SubscriptionMessageType.SUBSCRIBE,
                Arrays.asList(SubscriptionType.PUMPFUN_TOKENS)
            );

            System.out.println("Subscribed to token events");

        } catch (VyperWebsocketException e) {
            e.printStackTrace();
        }
    }
}
```

## API Documentation

For detailed information on the Vyper API, refer to the official documentation:

-   API Dashboard: [Vyper Dashboard](https://build.vyper.trade/)
-   API Documentation: [Vyper API Docs](https://docs.vyper.trade/)
