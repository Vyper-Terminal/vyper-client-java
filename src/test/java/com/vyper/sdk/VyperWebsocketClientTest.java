package com.vyper.sdk;

import org.java_websocket.client.WebSocketClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VyperWebsocketClientTest {

    private VyperWebsocketClient vyperClient;

    @Mock
    private WebSocketClient mockWebSocketClient;

    @BeforeEach
    void setUp() {
        vyperClient = new VyperWebsocketClient("test-api-key");
    }

    @Test
    void testMockConnection() throws Exception {
        Field clientField = VyperWebsocketClient.class.getDeclaredField("client");
        clientField.setAccessible(true);
        clientField.set(vyperClient, mockWebSocketClient);

        when(mockWebSocketClient.isOpen()).thenReturn(true);

        Field isConnectedField = VyperWebsocketClient.class.getDeclaredField("isConnected");
        isConnectedField.setAccessible(true);
        isConnectedField.setBoolean(vyperClient, true);

        assertDoesNotThrow(() -> vyperClient.ping());

        verify(mockWebSocketClient, times(1)).sendPing();
    }

    @Test
    void testMockSendPing() throws Exception {
        Field clientField = VyperWebsocketClient.class.getDeclaredField("client");
        clientField.setAccessible(true);
        clientField.set(vyperClient, mockWebSocketClient);

        when(mockWebSocketClient.isOpen()).thenReturn(true);

        assertDoesNotThrow(() -> vyperClient.ping());

        verify(mockWebSocketClient, times(1)).sendPing();
    }

    @Test
    void testSetMessageHandler() throws NoSuchFieldException, IllegalAccessException {
        Consumer<Object> mockHandler = message -> System.out.println("Received message: " + message);

        vyperClient.setMessageHandler(mockHandler);

        Field messageHandlerField = VyperWebsocketClient.class.getDeclaredField("messageHandler");
        messageHandlerField.setAccessible(true);

        @SuppressWarnings("unchecked")
        Consumer<Object> actualHandler = (Consumer<Object>) messageHandlerField.get(vyperClient);

        assertNotNull(actualHandler);
        assertEquals(mockHandler, actualHandler);
    }
}