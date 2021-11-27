var nomArticulo;
var spanArticulo;
var spanPrecio;
var precioArticulo;
var numUnidades;
var addCarrito;
var nomArticulosCarrito;
var precioTotal;

var sumaCarrito = 0;

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

//Funcion llamada por enviarCarrito(). Esta funcion valida los datos añadidos al formulario.
function comprobacionCampos() {

    if (nomArticulo.value.length > 0) {
        if (precioArticulo.value.length > 0) {
            if (!isNaN(parseFloat(precioArticulo.value))) {

                //Añadimos articulos al carrito

                nomArticulosCarrito.value += "[" + "(" + numUnidades.value + "x)" + " " + nomArticulo.value + "]" + " ";

                /*
                    var artCarrito = nomArticulo.value;
                    nomArticulosCarrito.value = artCarrito  + ", " + nomArticulosCarrito.value ;
                */
                //Hacemos los calculos del carrito                   
                precioT = parseFloat(precioArticulo.value) * parseInt(numUnidades.value);
                sumaCarrito += precioT;
                precioTotal.value = sumaCarrito;

                //Damos los valores a las variables acumuladoras.

                document.getElementById("nombreArticulo").value = "";
                document.getElementById("precioArticulo").value = "";
                document.getElementById("unidades").value = 1;

                document.getElementById("precioTotalCarrito").value = precioTotal.value;
                document.getElementById("articuloCarrito").value = nomArticulosCarrito.value;

            } else {
                faltaPrecioArticulo();
                //Quitamos el mensaje de error al volver a pinchar en la caja.
                precioArticulo.addEventListener("click", () => {
                    faltaPrecioArticulo() = "none";
                })
            }
        } else {
            faltaPrecioArticulo();
            //Quitamos el mensaje de error al volver a pinchar en la caja.
            precioArticulo.addEventListener("click", () => {
                faltaPrecioArticulo() = "none";
            })
        }
    } else {
        faltaNombreArticulo();
        //Quitamos el mensaje de error al volver a pinchar en la caja.
        nomArticulo.addEventListener("click", () => {
            faltaNombreArticulo() = "none";
        })
    }

};


function faltaNombreArticulo() {
    spanArticulo.style.display = "inline";
    nomArticulo.focus();
}

function faltaPrecioArticulo() {
    document.getElementById("precioArticulo").value = "";
    spanPrecio.style.display = "inline";
    //precioArticulo.value = "";
}

//Funcion sobre el boton enviar (llamamos a la funcion comprobacionCampos)
function enviarCarrito() {
    addCarrito.addEventListener("click", comprobacionCampos);

}

//Funcion para la seleccion del metodo de pago. (llamada por setManejoEventos())
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

//Funcion llamada por restablecer(), establece los valores vacios.
function reset() {
    nomArticulo.focus();
    spanArticulo.style.display = "none";
    spanPrecio.style.display = "none";
    nomArticulosCarrito.value = "";
    precioTotal.value = "";
}
//Funcion para restablecer los datos del formulario.
function restablecer() {
    botonRestablecer.addEventListener("click", reset);
}

//To-Do funcion para boton imprimir
function btnImprimir() {
    if (seleccionarFormaPago.value == "seleccione") {
        alert("Seleccione una forma de pago.");
    } else {
        alert("Los articulos de mi carrito son: " + nomArticulosCarrito.value + "\nPrecio total: " + precioTotal.value + "\nForma de pago: " + seleccionarFormaPago.value);
    }

}

function imprimirAlertas() {
    botonImprimir.addEventListener("click", btnImprimir);
}

function checkBoxActivacion() {
    normasCompra.addEventListener("click", imprimirHabilitado);
}

//Funcion que permite hebilitar y deshabilitar el boton imprimir(dependiendo del checkbox)
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