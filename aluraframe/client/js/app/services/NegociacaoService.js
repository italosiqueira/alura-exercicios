class NegociacaoService {

    constructor() {
        this._http = new HttpService();
    }

    obterNegociacoesDaSemana() {

        return this._http
            .get('negociacoes/semana')
            .then(objects => {
                return objects.map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor));
            })
            .catch(error => {
                throw new Error('Não foi possível obter as negociações desta semana.');
            });
    }
    
    obterNegociacoesDaSemanaAnterior() {
        
        return this._http
            .get('negociacoes/anterior')
            .then(objects => {
                return objects.map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor));
            })
            .catch(error => {
                throw new Error('Não foi possível obter as negociações da semana anterior.');
            });
    }
    
    obterNegociacoesDaSemanaRetrasada() {
        
        return this._http
            .get('negociacoes/retrasada')
            .then(objects => {
                return objects.map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor));
            })
            .catch(error => {
                throw new Error('Não foi possível obter as negociações da semana retrasada.');
            });

    }

    obterNegociacoes() {
        
        return Promise.all([
            this.obterNegociacoesDaSemana(),
            this.obterNegociacoesDaSemanaAnterior(),
            this.obterNegociacoesDaSemanaRetrasada()
        ])
            .then(
                negociacoes => negociacoes.reduce((flatArray, array) => flatArray.concat(array), [])
            )
            .catch(error => { throw new Error(error); });
    }

}