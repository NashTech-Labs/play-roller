package com.knoldus.controllers.websockets;

import play.mvc.Controller;
import play.mvc.LegacyWebSocket;
import play.mvc.WebSocket;

public class CallbackWebSocketsController extends Controller {

    public LegacyWebSocket<String> socket() {
        return WebSocket.whenReady((WebSocket.In<String> in, WebSocket.Out<String> out) -> {
            // For each event received on the socket,
            in.onMessage(msj -> out.write(processMessage(msj)));

            // When the socket is closed by client, messsage written on server.
            in.onClose(() -> printMessage("Websocket Disconnected"));

            // Response from server
            out.write("Hello your connection is now established");
        });
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private String processMessage(String message) {
        return "processed "+message;
    }

}
