class NegociacaoController {
    constructor() {
        let $ = document.querySelector.bind(document);

        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');

        this._listaNegociacoes = new Bind(
            new ListaNegociacoes(), new NegociacoesView($('#negociacoesView')), 'adiciona', 'esvazia', 'ordena', 'inverteOrdem'
        );

        this._mensagem = new Bind(
            new Mensagem(), new MensagemView($('#mensagemView')), 'texto'
        );

        this._colunaAtual = "";

    }

    adiciona(event) {
        event.preventDefault();

        try {
            this._listaNegociacoes.adiciona(this._criaNegociacao());
    
            this._limpaFormulario();
    
            this._mensagem.texto = 'Negociação cadastrada com sucesso!';
        } catch(error) {
            this._mensagem.texto = `Alguma coisa deu errado... ${error.message}`;
        }
    }

    importaNegociacoes() {

        let service = new NegociacaoService();

        service.obterNegociacoes()
            .then(
                negociacoes => {
                    negociacoes
                        .reduce((flatArray, array) => flatArray.concat(array), [])
                        .forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
                    this._mensagem.texto = 'Negociações importadas com sucesso!';
                }
            )
            .catch(error => this._mensagem.texto = error);
    }

    ordena(coluna) {

        // Nome da coluna deve ser igual ao nome da propriedade no modelo (MUITO ACOPLADO!)
        if (this._colunaAtual == coluna)
            this._listaNegociacoes.inverteOrdem();
        else
            this._listaNegociacoes.ordena((a, b) => a[coluna] - b[coluna]);
            
        
        this._colunaAtual = coluna;
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