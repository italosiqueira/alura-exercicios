class NegociacaoService {

    constructor() {
        this._http = new HttpService();
    }

    obterNegociacoesDaSemana() {

        return new Promise((resolve, reject) => {
            this._http
                .get('negociacoes/semana')
                .then(objects => {
                    resolve(objects.map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor)));
                })
                .catch(error => 
                    reject('Não foi possível obter as negociações desta semana.')
                );
        });
    }
    
    obterNegociacoesDaSemanaAnterior() {
        
        return new Promise((resolve, reject) => {
            this._http
                .get('negociacoes/anterior')
                .then(objects => {
                    resolve(objects.map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor)));
                })
                .catch(error => 
                    reject('Não foi possível obter as negociações da semana anterior.')
                );
        });
    }
    
    obterNegociacoesDaSemanaRetrasada() {
        
        return new Promise((resolve, reject) => {
            this._http
                .get('negociacoes/retrasada')
                .then(objects => {
                    resolve(objects.map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor)));
                })
                .catch(error => 
                    reject('Não foi possível obter as negociações da semana retrasada.')
                );
        });

    }

}