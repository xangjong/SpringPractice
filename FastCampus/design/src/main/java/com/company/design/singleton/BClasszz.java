package com.company.design.singleton;

public class BClasszz {

    private SocketClient socketClient;

    public BClasszz(){
         this.socketClient = SocketClient.getInstance();
        // this.socketClient = new SocketClient();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }

}
