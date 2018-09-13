export class DocumentoDetalleVoModel {
    public documentoId: string;
    public productoId: string;
    public fechaRegistro: Date;
    public parcial: string;
    public cantidad: string;
    public unitario: string;
    public costoUnitario: string;
    public cantidadDevolucion: string;
    public cambioPrecio: string;
    public borrar: string;
    public cantidad1: string;
    public cantidad2: string;
    public iva: string;
    public nombreProducto: string;

    constructor(){
        this. documentoId="";
        this. productoId="";
        this. fechaRegistro=new Date;
        this. parcial="";
        this. cantidad="";
        this. unitario="";
        this. costoUnitario="";
        this. cantidadDevolucion="";
        this. cambioPrecio="";
        this. borrar="";
        this. cantidad1="";
        this. cantidad2="";
        this.iva="";
        this.nombreProducto="";
    }
}
