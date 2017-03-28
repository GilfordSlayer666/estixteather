package net.ramptors.servlets.compro;

import com.fasterxml.jackson.jr.ob.JSON;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import net.ramptors.jee.compro.entidad.Aviso;


public class DecoderAvisos implements Decoder.TextStream<List<Aviso>> {
  @Override
  public List<Aviso> decode(Reader r) throws DecodeException, IOException {
    return JSON.std.listOfFrom(Aviso.class, r);
  }
  @Override public void init(EndpointConfig config) {
  }
  @Override public void destroy() {
  }
}
