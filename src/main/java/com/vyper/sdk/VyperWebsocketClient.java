package com.vyper.sdk;

import com.vyper.sdk.exceptions.VyperWebsocketException;
import com.vyper.sdk.models.ChainAction;
import com.vyper.sdk.models.TokenPair;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.List;
import java.util.function.Consumer;

public class VyperWebsocketClient {
    private final String baseUrl;
    private final String apiKey;
    private WebSocketClient client;
    private Consumer<Object> messageHandler;
    private FeedType currentFeedType;
    private final ObjectMapper objectMapper;
    private boolean isConnected = false;

    public VyperWebsocketClient(String apiKey) {
        this.baseUrl = "wss://api.vyper.trade/api/v1/ws";
        this.apiKey = apiKey;
        this.objectMapper = new ObjectMapper();
    }

    public enum FeedType {
        TOKEN_EVENTS("token-events"),
        MIGRATION_EVENTS("migration-events"),
        WALLET_EVENTS("wallet-events");

        private final String value;

        FeedType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum SubscriptionMessageType {
        SUBSCRIBE("subscribe"),
        UNSUBSCRIBE("unsubscribe");

        private final String value;

        SubscriptionMessageType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum SubscriptionType {
        PUMPFUN_TOKENS("PumpfunTokens"),
        RAYDIUM_AMM_TOKENS("RaydiumAmmTokens"),
        RAYDIUM_CPMM_TOKENS("RaydiumCpmmTokens"),
        RAYDIUM_CLMM_TOKENS("RaydiumClmmTokens");

        private final String value;

        SubscriptionType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static class TokenSubscriptionMessage {
        public String action;
        public List<String> types;

        public TokenSubscriptionMessage(SubscriptionMessageType action, List<SubscriptionType> types) {
            this.action = action.getValue();
            this.types = types.stream()
                            .map(SubscriptionType::getValue)
                            .collect(java.util.stream.Collectors.toList());
        }
    }

    public void connect(FeedType feedType) throws VyperWebsocketException {
        if (feedType == null) {
            throw new IllegalArgumentException("FeedType cannot be null");
        }
        String url = baseUrl + "/" + feedType.getValue() + "?apiKey=" + apiKey;
        currentFeedType = feedType;

        try {
            client = new WebSocketClient(new URI(url)) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    System.out.println("Vyper Websocket | WebSocket connection is open and ready to receive messages");
                    isConnected = true;
                }

                @Override
                public void onMessage(String message) {
                    handleMessage(message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("Vyper Websocket | Connection closed: " + reason);
                    isConnected = false;
                }

                @Override
                public void onError(Exception ex) {
                    System.err.println("Vyper Websocket | Error occurred: " + ex.getMessage());
                }
            };
            client.connect();
            int timeout = 5000; 
            long startTime = System.currentTimeMillis();
            while (!isConnected && (System.currentTimeMillis() - startTime) < timeout) {
                Thread.sleep(100);
            }
            if (!isConnected) {
                throw new VyperWebsocketException("Connection timeout");
            }
        } catch (Exception e) {
            throw new VyperWebsocketException("Failed to connect: " + e.getMessage());
        }
    }

    private void ensureConnected() throws VyperWebsocketException {
        if (client == null || !client.isOpen()) {
            throw new VyperWebsocketException("Not connected to WebSocket");
        }
    }    

    public void subscribe(FeedType feedType, SubscriptionMessageType action, List<SubscriptionType> types) throws VyperWebsocketException {
        ensureConnected();

        if (feedType == FeedType.TOKEN_EVENTS) {
            try {
                TokenSubscriptionMessage message = new TokenSubscriptionMessage(action, types);
                String jsonMessage = objectMapper.writeValueAsString(message);
                System.out.println("Sending subscription message: " + jsonMessage);
                client.send(jsonMessage);
            } catch (Exception e) {
                throw new VyperWebsocketException("Failed to subscribe: " + e.getMessage());
            }
        }
    }

    public void unsubscribe(FeedType feedType, Object subscriptionMessage) throws VyperWebsocketException {
        if (client == null || !client.isOpen()) {
            throw new VyperWebsocketException("Not connected to WebSocket");
        }
        if (feedType == FeedType.TOKEN_EVENTS || feedType == FeedType.WALLET_EVENTS) {
            try {
                client.send(objectMapper.writeValueAsString(subscriptionMessage));
            } catch (Exception e) {
                throw new VyperWebsocketException("Failed to unsubscribe: " + e.getMessage());
            }
        }
    }

    private void handleMessage(String message) {
        if (messageHandler != null) {
            try {
                JsonNode jsonNode = objectMapper.readTree(message);
                
                if (jsonNode.has("action")) {
                    System.out.println("Subscription response: " + message);
                    messageHandler.accept(message);
                    return;
                }

                try {
                    Object convertedData = convertMessage(jsonNode);
                    messageHandler.accept(convertedData);
                } catch (Exception e) {
                    System.out.println("Conversion failed, sending raw message: " + e.getMessage());
                    messageHandler.accept(message);
                }
            } catch (Exception e) {
                System.err.println("Vyper Websocket | Error parsing message: " + e.getMessage());
                System.err.println("Raw message was: " + message);
                e.printStackTrace();
            }
        }
    }

    private Object convertMessage(Object data) throws Exception {
        switch (currentFeedType) {
            case WALLET_EVENTS:
                return objectMapper.convertValue(data, ChainAction.class);
            case MIGRATION_EVENTS:
            case TOKEN_EVENTS:
                return objectMapper.convertValue(data, TokenPair.class);
            default:
                throw new Exception("Unknown feed type: " + currentFeedType);
        }
    }

    public void disconnect() throws VyperWebsocketException {
        if (client != null && client.isOpen()) {
            try {
                client.close();
            } catch (Exception e) {
                throw new VyperWebsocketException("Failed to disconnect: " + e.getMessage());
            }
        }
    }

    public void cleanup() throws VyperWebsocketException {
        disconnect();
    }

    public void ping() throws VyperWebsocketException {
        if (client == null || !client.isOpen()) {
            throw new VyperWebsocketException("Not connected to WebSocket");
        }
        try {
            client.sendPing();
        } catch (Exception e) {
            throw new VyperWebsocketException("Failed to send ping: " + e.getMessage());
        }
    }

    public void setMessageHandler(Consumer<Object> handler) {
        this.messageHandler = handler;
    }
}