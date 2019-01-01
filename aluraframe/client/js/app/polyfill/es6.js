/*
 * Just in case the browser does not support the Array.include method (Edge 13 
 * and before), is necessary to add a similar functionality to the Array class, 
 * that is, a polyfill.
 * 
 * A POLYFILL is a script which emulates the behavior of a 
 * feature/functionality not supported to ensure our code 
 * works like the latest language features.
 * 
 * Import this file in the page HEAD section.
 * 
 */
if(!Array.prototype.includes) {

    // Se não existir, adiciona

    console.log('Polyfill para Array.includes aplicado.');

    Array.prototype.includes = function(elemento) {
        return this.indexOf(elemento) != -1;
    };
}