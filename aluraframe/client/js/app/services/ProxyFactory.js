class ProxyFactory {
    static create(object, props, acao) {
        return new Proxy(
            object, {
                get(target, prop, receiver) {
                    if (props.includes(prop) && ProxyFactory._ehFuncao(target[prop])) {
                        return function() {
                            console.log('Proxy property FUNCTION listener: ' + prop);
                            let retorno = Reflect.apply(target[prop], target, arguments);
                            acao(target);
                            return retorno;
                        }
                    }
                    console.log('Proxy property GET listener: ' + prop);
                    return Reflect.get(target, prop, receiver);
                },

                set(target, prop, value, receiver) {
                    console.log('Proxy property SET listener: ' + prop);
                    let retorno = Reflect.set(target, prop, value, receiver);
                    if (props.includes(prop)) {
                        acao(target);
                    }

                    return retorno;
                }
            });
    }

    static _ehFuncao(func) {
        return typeof (func) == typeof (Function);
    }
}