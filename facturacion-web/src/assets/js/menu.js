function teclasMenu(evento,element){	
    var elec = element.getAttribute('id').toString();
   
    if( evento.keyCode==39){ //cuando se presiona la tacla abajo 				
        if(elec=='facturacion'){//cuendo esta seleccionando el tipo documento
            console.log(document.getElementById('informes'));
            document.getElementById('informes').click();
            //document.getElementById('informes').focus();
            //document.getElementById('informes').select();
            return "";
            
        }
    }
}