class NegociacaoController {
    constructor() {
        let $ = document.querySelector.bind(document);

        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');

        this._listaNegociacoes = new Bind(
            new ListaNegociacoes(), new NegociacoesView($('#negociacoesView')), 'adiciona', 'esvazia'
        );

        this._mensagem = new Bind(
            new Mensagem(), new MensagemView($('#mensagemView')), 'texto'
        );

    }

    adiciona(event) {
        event.preventDefault();

        this._listaNegociacoes.adiciona(this._criaNegociacao());

        this._limpaFormulario();

        this._mensagem.texto = 'Negociação cadastrada com sucesso!';

        console.log(this._listaNegociacoes.negociacoes);
    }

    importaNegociacoes() {

        let service = new NegociacaoService();

        service.obterNegociacoesDaSemana(
            (err, negociacoes) => {
                if (err) {
                    this._mensagem.texto = err;
                    return;
                }
                
                negociacoes.forEach(element =>
                    this._listaNegociacoes.adiciona(element)
                );
                
                this._mensagem.texto = 'Negociações importadas com sucesso!';
            });
    }

    _criaNegociacao() {
        return new Negociacao(
            DateHelper.textoParaData(this._inputData.value)
            , this._inputQuantidade.value
            , this._inputValor.value);
    }

    _limpaFormulario() {
        this._inputData.value = '';
        this._inputQuantidade.value = '1';
        this._inputValor.value = '0.0';

        this._inputData.focus();
    }

    apaga() {
        this._listaNegociacoes.esvazia();
        this._mensagem.texto = 'Negociações apagadas com sucesso!';
    }
}