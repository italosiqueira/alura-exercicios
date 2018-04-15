class Mensagem {
    
    constructor(texto='') {

        /*
         * In case the browser does not support optional parameters (Edge 13 
         * and before), one can use the following hack.
         */
        //this._texto = texto || '';
        this._texto = texto;
    }

    get texto() { return this._texto; }

    set texto(texto) { this._texto = texto; }
}