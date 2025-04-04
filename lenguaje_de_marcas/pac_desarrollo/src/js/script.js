// Script para la validación del formulario y almacenamiento en sessionStorage
// Utilizo el DOM para poder cargar el script.js en el <head> en el documento html, sino da problemas
// Y para que funcione habria que incluirlo en el body, despues del formulario, para asegurar que se ha cargado todo.
document.addEventListener('DOMContentLoaded', function() {
    // Obtenemos el envio del boton del formulario con id formularioEntradas
    // Fuente: https://www.w3schools.com/JSREF/tryit.asp?filename=tryjsref_onsubmit_addeventlistener
    document.getElementById('formularioEntradas').addEventListener('submit', function(event) {
        event.preventDefault(); // Detener el envío del formulario por defecto

        // Creacion de las constantes con valor de cada uno de los elementos del formulario.
        // Para almacenarlo y cargarlo en el documento de confirmacion.html posteriormente.
        const nombre = document.getElementById('nombre').value;
        const fechaConcierto = document.getElementById('fecha').value;
        const lugarConcierto = document.getElementById('lugar').value;
        const cantidadEntradas = document.getElementById('cantidadEntradas').value;
        const categoria = document.getElementById('categoria').value;
        const metodoPago = document.querySelector('input[name="metodoPago"]:checked')?.value;

        // Validacion para que los campos no esten vacios, de lo contrario,
        // mostramos alerta indicando que debe rellenar todos los campos y no continuamos.
        if (!nombre || !fechaConcierto || !lugarConcierto || !cantidadEntradas || !categoria || !metodoPago) {
            alert('Por favor, complete todos los campos antes de enviar.');
            return;
        }

        // Guardar los datos en sessionStorage
        // Fuente: https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_storage_setitem
        sessionStorage.setItem('nombre', nombre);
        sessionStorage.setItem('fecha', fechaConcierto);
        sessionStorage.setItem('lugar', lugarConcierto);
        sessionStorage.setItem('cantidadEntradas', cantidadEntradas);
        sessionStorage.setItem('categoria', categoria);
        sessionStorage.setItem('metodoPago', metodoPago);

        // Redirigir manualmente a confirmacion.html
        window.location.href = 'confirmacion.html';
    });
});

// Script para la recuperarion de los datos de sessionStorage almacenados previamente y mostrarlos en la pagina
// Primero comprobamos que estamos en confirmacion.html para establecer el contenido de los documentos
// Ya que se llaman igual y si no serian reemplazados en index.html tambien
if (window.location.pathname.includes("confirmacion.html")) {
    // Utilizo el DOM para poder cargar el script.js en el <head> en el documento html, sino da problemas
    // Y para que funcione habria que incluirlo en el body, despues del formulario, para asegurar que se ha cargado todo.
    document.addEventListener('DOMContentLoaded', function() {
        // Creamos las constantes de cada elemento recuperado del formulario que estaba almacenado en sessionStorage
        const nombre = sessionStorage.getItem('nombre');
        const fechaConcierto = sessionStorage.getItem('fecha');
        const lugarConcierto = sessionStorage.getItem('lugar');
        const cantidadEntradas = sessionStorage.getItem('cantidadEntradas');
        const categoria = sessionStorage.getItem('categoria');
        const metodoPago = sessionStorage.getItem('metodoPago');

        // Establecemos en los elementos p de confirmacion.html los datos cargados o Nulo en caso de estar vacios.
        // Fuente: https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_node_textcontent_set
        // fuente: https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_storage_getitem_session
        document.getElementById("nombre").textContent = nombre || "Nulo";
        document.getElementById("fecha").textContent = fechaConcierto || "Nulo";
        document.getElementById("lugar").textContent = lugarConcierto || "Nulo";
        document.getElementById("cantidadEntradas").textContent = cantidadEntradas || "Nulo";
        document.getElementById("categoria").textContent = categoria || "Nulo";
        document.getElementById("metodoPago").textContent = metodoPago || "Nulo";
    });
}
