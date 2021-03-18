class Customer{

    constructor(name,lastName) {
        this.name = name;
        this.lastName = lastName;
        this.id = 0;
    }
    create(){
        this.id = this.id + 100;
    }
    get(){
        return "Customer:"+this.id;
    }
}
class Vendor{

    constructor(name,lastName) {
        this.name = name;
        this.lastName = lastName;
        this.id = 0;
    }
    create(){
        this.id = this.id + 200;
    }
    get(){
        return "Customer:"+this.id;
    }
}