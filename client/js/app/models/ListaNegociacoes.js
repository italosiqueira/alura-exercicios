class ListaNegociacoes {
    
    constructor() {
        this._negociacoes = [];

        Object.freeze(this);
    }

    get negociacoes() { return [].concat(this._negociacoes); }

    adiciona(negociacao) {
        this._negociacoes.push(negociacao);
    }
}