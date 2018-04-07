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

        let xhr = new XMLHttpRequest();

        xhr.open("GET", 'negociacoes/semana');

        xhr.onreadystatechange = () => {
            /*
            0: requisição não iniciada
            1: conexão com o servidor estabelecida
            2: rqeuisição recebida
            3: processando requisição
            4: requisição concluída e a resposta está pronta
            */
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    JSON.parse(xhr.responseText)
                        .map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor))
                        .forEach(element =>
                            this._listaNegociacoes.adiciona(element)
                        );
                    console.log('Negociações importadas com sucesso!');
                } else {
                    console.log('Não foi possível se conectar ao servidor: ' + console.log(xhr.responseText));
                }
            }
        }

        xhr.send();
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