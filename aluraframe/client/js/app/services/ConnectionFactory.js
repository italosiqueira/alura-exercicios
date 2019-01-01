var ConnectionFactory = (function(){
    
    const stores = ['negociacoes'];
    const version = 4;
    const dbName = 'aluraframe';
    var connection = null;
    var close = null;
    
    return class ConnectionFactory {
    
        constructor() {
            throw new Error('Não é possível instanciar ConnectionFactory');
        }
    
        static getConnection() {
            return new Promise((resolve, reject) => {
                
                let openRequest = window.indexedDB.open(dbName, version);
    
                openRequest.onupgradeneeded = e => {
                    console.log('Cria ou altera um banco já existente');
    
                    ConnectionFactory._createStores(e.target.result);
                };
    
                openRequest.onsuccess = e => {
                    if (!connection) {
                        connection = e.target.result;
                        close = connection.close.bind(connection);
                        connection.close = function() {
                            throw new Error('Você não pode fechar diretamente a conexão!');
                        };
                    }

                    resolve(connection);
                };
    
                openRequest.onerror = e => {
                    console.log(e.target.error);
                    reject(e.target.error.name);
                };
            });
        }
    
        static closeConnection() {
            if (connection) {
                close();
                connection = null;
            }
        }
    
        static _createStores(connection) {
            stores.forEach(objectStoreName => {
                if(connection.objectStoreNames.contains(objectStoreName)) {
                    connection.deleteObjectStore(objectStoreName);
                }
                connection.createObjectStore(objectStoreName, { autoIncrement: true});
            });
        }
    }

})();