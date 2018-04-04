class ProxyFactory {
    static create(object, props, acao) {
        return new Proxy(
            object, {
                get(target, prop, receiver) {
                    if (props.includes(prop) && ProxyFactory._ehFuncao(target[prop])) {
                        return function() {
                            console.log('Proxy property FUNCTION listener: ' + prop);
                            Reflect.apply(target[prop], target, arguments);
                            return acao(target);
                        }
                    }
                    console.log('Proxy property GET listener: ' + prop);
                    return Reflect.get(target, prop, receiver);
                },

                set(target, prop, value, receiver) {
                    console.log('Proxy property SET listener: ' + prop);
                    if (props.includes(prop)) {
                        target[prop] = value;
                        acao(target);
                    }

                    return Reflect.set(target, prop, value, receiver);
                }
            });
    }

    static _ehFuncao(func) {
        return typeof (func) == typeof (Function);
    }
}