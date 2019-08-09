package com.iot.api;

import com.iot.common.connection.TransportConnection;
import reactor.core.Disposable;

import java.util.List;

public interface RsocketChannelManager extends Disposable {

     List<TransportConnection> getConnections();

     TransportConnection       getConnection(String clientId);

     void  addConnection(String clientId,TransportConnection connection);




}
