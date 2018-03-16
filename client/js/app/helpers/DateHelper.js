class DateHelper {

    constructor() {
        throw new Error("Not a instatiable class!");
    }

    static textoParaData(dateString) {
        if(/^\d{4}-\d{2}-\d{2}$/.test(dateString)) {
            return new Date(...dateString.split('-').map((item, index) => item - (index % 2)));
        } else {
            throw new Error("Not a valid Date String format!");
        }
    }
    
    static dataParaTexto(dateObject) {
        return `${dateObject.getDate()}/${dateObject.getMonth() + 1}/${dateObject.getFullYear()}`;
    }
}