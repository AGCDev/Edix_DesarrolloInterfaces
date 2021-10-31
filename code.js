var nomArticulo;
var spanArticulo;
var spanPrecio;
var precioArticulo;
var numUnidades;
var addCarrito;
var nomArticulosCarrito;
var precioTotal;
var opcionesPago;
var opcionTarjeta;
var divTitularTarjeta;
var titularTarjeta;
var divNumeroTarjeta
var numeroTarjeta;
var divCodigoSeguridadTarjeta;
var codigoSeguridadTarjeta;
var opcionEfectivo;
var importeEfectivo;
var normasCompra;
var botonImprimir;
var botonRestablecer;




window.addEventListener("load", function() {

    inicializarVariables();
    enviarCarrito();
    setManejoEventos();
    checkBoxActivacion();
    restablecer();
    imprimirAlertas();

});




function inicializarVariables() {

    nomArticulo = document.getElementById("nombreArticulo");
    precioArticulo = document.getElementById("precioArticulo");
    spanArticulo = document.getElementById("spanArticulo");
    spanPrecio = document.getElementById("spanPrecio");
    numUnidades = document.getElementById("unidades");
    addCarrito = document.getElementById("botonAddCarrito");
    nomArticulosCarrito = document.getElementById("articulosCarrito");
    precioTotal = document.getElementById("precioTotalCarrito");
    opcionesPago = document.getElementById("seleccionarFormaPago");
    opcionTarjeta = document.getElementById("opcionTarjeta");
    //divTitularTarjeta = document.getElementById("divTitularTarjeta");
    titularTarjeta = document.getElementById("titularTarjeta");
    //divNumeroTarjeta = document.getElementById("divNumeroTarjeta");
    numeroTarjeta = document.getElementById("numeroTarjeta").value;
    //divCodigoSeguridadTarjeta = document.getElementById("divCodigoSeguridadTarjeta");
    codigoSeguridadTarjeta = document.getElementById("codigoSeguridadTarjeta");
    opcionEfectivo = document.getElementById("opcionEfectivo");
    importeEfectivo = document.getElementById("importeEfectivo");
    normasCompra = document.getElementById("condicionesCompra");
    botonImprimir = document.getElementById("botonImprimir");
    botonRestablecer = document.getElementById("botonRestablecer");


    opcionTarjeta.style.display = "none";
    opcionEfectivo.style.display = "none";

    spanArticulo.style.display = "none";
    spanPrecio.style.display = "none";


}

function comprobacionCampos() {

    var precioT = parseFloat(precioArticulo.value) * numUnidades.value;

    if (nomArticulo.value.length > 0) {
        nomArticulosCarrito.value += "[" + "(" + numUnidades.value + "x)" + " " + nomArticulo.value + "]" + " ";
        spanArticulo.style.display = "none";
        if (precioArticulo.value != "" || !isNaN(precioT)) {

            if (precioTotal.value) {
                precioTotal.value = parseFloat(precioTotal.value) + parseFloat(precioT);
                spanPrecio.style.display = "none";
            } else {
                precioTotal.value = precioT;
                spanPrecio.style.display = "none";
            }

        } else if (precioArticulo.value == " " || isNaN(precioT)) {
            faltaPrecioArticulo();
            precioTotal.value = "";
        }
    } else {
        faltaNombreArticulo();
    }

    nomArticulo.value = "";
    precioArticulo.value = "";
    nomArticulo.focus();
    numUnidades.value = 1;

}

function faltaNombreArticulo() {
    spanArticulo.style.display = "inline";
    nomArticulo.focus();
}

function faltaPrecioArticulo() {
    nomArticulosCarrito.value = "";
    spanPrecio.style.display = "inline";
    nomArticulo.focus();
}

function enviarCarrito() {
    addCarrito.addEventListener("click", comprobacionCampos);
    nomArticulo.focus();

}

function cargarPago() {
    if (opcionesPago.value == "seleccione") {
        opcionTarjeta.style.display = "none";
        opcionEfectivo.style.display = "none";
    } else if (opcionesPago.value == "tarjeta") {
        opcionTarjeta.style.display = "block";
        opcionEfectivo.style.display = "none";
    } else {
        opcionTarjeta.style.display = "none";
        opcionEfectivo.style.display = "block";
        rellenarPagoEfectivo();
    }
}

function setManejoEventos() {
    opcionesPago.addEventListener("change", cargarPago);
    restablecer();
}

function reset() {
    nomArticulo.focus();
    spanArticulo.style.display = "none";
    spanPrecio.style.display = "none";
    nomArticulosCarrito.value = "";
    precioTotal.value = "";
}

function restablecer() {
    botonRestablecer.addEventListener("click", reset);
}

//To-Do funcion para boton imprimir
function btnImprimir() {
    if (seleccionarFormaPago.value == "seleccione") {
        alert("Seleccione una forma de pago.");
    } else {
        alert("Los articulos de mi carrito son: " + nomArticulosCarrito.value + " y el precio total es: " + precioTotal.value + " €" + "\nForma de pago: " + seleccionarFormaPago.value);
    }

}

function imprimirAlertas() {
    botonImprimir.addEventListener("click", btnImprimir);
}

function checkBoxActivacion() {
    normasCompra.addEventListener("click", imprimirHabilitado);

}

function imprimirHabilitado() {

    if (normasCompra.checked) {
        botonImprimir.disabled = false;
    } else {
        botonImprimir.disabled = true;
    }

}

function rellenarPagoEfectivo() {
    importeEfectivo.value = precioTotal.value;
}