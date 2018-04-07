class NegociacaoService {
    obterNegociacoesDaSemana(cb) {
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
                    cb(null, 
                        JSON.parse(xhr.responseText)
                            .map(item => new Negociacao(new Date(item.data), item.quantidade, item.valor)));
                } else {
                    cb('Não foi possível acessar o servidor: ' + xhr.responseText, null);
                }
            }
        }

        xhr.send();
    }
}