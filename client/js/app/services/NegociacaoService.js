class NegociacaoService {

    obterNegociacoesDaSemana() {

        return new Promise((resolve, reject) => {
            
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
                        resolve(JSON.parse(xhr.responseText).map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor)));
                    } else {
                        reject('Não foi possível obter as negociações desta semana.');
                    }
                }
            }
    
            xhr.send();
        });

    }
    
    obterNegociacoesDaSemanaAnterior() {

        return new Promise((resolve, reject) => {
            
            let xhr = new XMLHttpRequest();
    
            xhr.open("GET", 'negociacoes/anterior');
    
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
                        resolve(JSON.parse(xhr.responseText).map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor)));
                    } else {
                        reject('Não foi possível obter as negociações da semana anterior.');
                    }
                }
            }
    
            xhr.send();
        });

    }
    
    obterNegociacoesDaSemanaRetrasada() {

        return new Promise((resolve, reject) => {
            
            let xhr = new XMLHttpRequest();
    
            xhr.open("GET", 'negociacoes/retrasada');
    
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
                        resolve(JSON.parse(xhr.responseText).map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor)));
                    } else {
                        reject('Não foi possível obter as negociações da semana retrasada.');
                    }
                }
            }
    
            xhr.send();
        });

    }

}