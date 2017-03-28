package net.ramptors.servlets.compro;

import com.fasterxml.jackson.jr.ob.JSON;
import java.io.IOException;
import java.io.Writer;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;


public class EncoderSincronizacion implements Encoder.TextStream<Sincronizacion> {
  @Override public void encode(Sincronizacion modelo, Writer writer) throws
      EncodeException, IOException {
    JSON.std.write(modelo, writer);
  }
  @Override public void init(EndpointConfig config) {
  }
  @Override public void destroy() {
  }
}
