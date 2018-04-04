class NegociacaoController {
    constructor() {
        let $ = document.querySelector.bind(document);

        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');

        let self = this;
        this._listaNegociacoes = new Proxy(
            new ListaNegociacoes(), {
                get(target, prop, receiver) {
                    if (['adiciona', 'esvazia'].includes(prop) && typeof (target[prop]) == typeof (Function)) {
                        return function() {
                            console.log('Proxy property listener: ' + prop);
                            Reflect.apply(target[prop], target, arguments);
                            self._negociacoesView.update(target);
                        }
                    }
                    
                    return Reflect.get(target, prop, receiver);
                }
            });

        this._negociacoesView = new NegociacoesView($('#negociacoesView'));
        
        this._mensagem = new Proxy(
            new Mensagem(), {
                set(target, prop, value, receiver) {
                    console.log('Proxy property listener: ' + prop);
                    if (['texto'].includes(prop)) {
                        target[prop] = value;
                        self._mensagemView.update(target);
                    }

                    return Reflect.set(target, prop, value, receiver);
                }
            });
        
        this._mensagemView = new MensagemView($('#mensagemView'));
        
        this._mensagem.texto = '';
    }

    adiciona(event) {
        event.preventDefault();

        this._listaNegociacoes.adiciona(this._criaNegociacao());

        this._limpaFormulario();

        this._mensagem.texto = 'Negociação cadastrada com sucesso!';

        console.log(this._listaNegociacoes.negociacoes);
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