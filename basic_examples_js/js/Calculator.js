class Calculator{

    constructor(number1,number2,operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }
    ejecutarOperacion(){
        switch (this.operation){
            case "sumar":
                this.result = this.number1 + this.number2;
                break;
            case "restar":
                this.result = this.number1 - this.number2;
                break;
            case "multiplicar":
                this.result = this.number1 * this.number2;
                break;
            case "dividir":
                this.result = this.number1 / this.number2;
                break;
            default:

        }
        return this.result;
    }

}