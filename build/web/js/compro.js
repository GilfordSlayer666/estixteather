var main = document.querySelector("main");
// hide body to prevent FOUC
document.body.style.opacity = 0;
if (navigator.serviceWorker) {
  navigator.serviceWorker.register('sw.js');
}
window.addEventListener("WebComponentsReady", function () {
  // show body now that everything is ready
  document.body.style.opacity = 1;
  window.addEventListener("hashchange", cambioDeHash);
  cambioDeHash();
});
function cambioDeHash() {
  borraTodosLosElementos(main);
  var hash = location.hash;
  switch (hash) {
    case "":
    case "#":
      main.appendChild(document.createElement("compro-inicio"));
      break;
    default :
      var componente = hash.substring(1);
      if (componente.startsWith("form")) {
        main.appendChild(document.createElement("form", hash.substring(1)));
      } else {
        main.appendChild(document.createElement(hash.substring(1)));
      }
  }
}