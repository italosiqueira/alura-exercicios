class NegociacaoController {
    constructor() {
        let $ = document.querySelector.bind(document);

        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
    }

    adiciona(event) {
        event.preventDefault();

        let negociacao = this.criaNegociacao(this._inputData.value, this._inputQuantidade.value, this._inputValor.value);

        console.log(negociacao);

        this.limpaFormulario();
    }

    criaNegociacao(dataStr, quantidade, valor) {
        return new Negociacao(
            DateHelper.textoParaData(dataStr)
            , quantidade
            , valor);
    }

    limpaFormulario() {
        this._inputData.value = '';
        this._inputQuantidade.value = '1';
        this._inputValor.value = '0.0';

        this._inputData.focus();
    }
}