class ListaNegociacoes {
    
    constructor(armadilha) {
        this._negociacoes = [];
        this._armadilha = armadilha;

        Object.freeze(this);
    }

    get negociacoes() { return [].concat(this._negociacoes); }

    adiciona(negociacao) {
        this._negociacoes.push(negociacao);
        this._armadilha(this);
    }

    esvazia() {
        while(this._negociacoes.length > 0) {
            this._negociacoes.pop();
        }
    }
}