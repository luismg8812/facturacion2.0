export class DocumentoModel {
    public documentoId:string="";
    public tipoDocumentoId:string;
    public proveedorId:string;
    public usuarioId:string;
    public clienteId:string;
    public empleadoId:string;
    public tipoPagoId:string;
    public fechaRegistro:Date;
    public fechaActualiza:Date;
    public consecutivoDian:string;
    public impreso:string;
    public total:string;
    public excento:string;
    public gravado:string;
    public iva:string;
    public cierreDiario:string;
    public detalleEntrada:string;
    public saldo:string;
    public reduccion:string;
    public pesoTotal:string;
    public descuento:string;
    public valorTarjeta:string;
    public efectivo:string;
    public cambio:string;
    public entregado:string;
    public retenido:string;
    public mac:string;
    public iva19:string;
    public iva5:string;
    public base19:string;
    public base5:string;

    constructor(){
        this. documentoId="";
        this. tipoDocumentoId="";
        this. proveedorId="";
        this. usuarioId="";
        this. clienteId="";
        this. empleadoId="";
        this. tipoPagoId="";
        this. fechaRegistro=new Date;
        this. fechaActualiza=null;
        this. consecutivoDian="";
        this. impreso="";
        this. total="";
        this. excento="";
        this. gravado="";
        this. iva="";
        this. cierreDiario="";
        this. detalleEntrada="";
        this. saldo="";
        this. reduccion="";
        this. pesoTotal="";
        this. descuento="";
        this. valorTarjeta="";
        this. efectivo="";
        this. cambio="";
        this. entregado="";
        this. retenido="";
        this. mac="";
        this. iva19="";
        this. iva5="";
        this. base19="";
        this. base5="";
    };
}
