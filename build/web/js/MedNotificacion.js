"use strict";
function MedNotificacion() {
  Object.defineProperty(this, "url", {
    enumerable: true,
    value: "ws://" + location.hostname + ":" + location.port
        + "/ctrlNotificacion"
  });
}
MedNotificacion.prototype = {
  inicia: function () {
    this.webSocket = new WebSocket(this.url);
    this.webSocket.onopen = this.webSocketAbierto.bind(this);
    this.webSocket.onmessage = this.mensajeRecibido.bind(this);
    this.webSocket.onerror = this.muestraError.bind(this);
    this.webSocket.onclose = this.webSocketCerrado.bind(this);
  },
  webSocketAbierto: function () {
    window.console.log("Web socket notiicación abierto.");
  },
  mensajeRecibido: function (evento) {
    muestraMensaje(evento.data, "img/ic_launcher_72px.png");
  },
  webSocketCerrado: function () {
    window.console.log("Web socket cerrado.");
  },
  muestraError: function (evento) {
    muestraAlerta(evento.type);
  }
};