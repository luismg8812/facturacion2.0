function controlTeclasPuntoVentaDia(evento,element){
    var elec = element.getAttribute('id').toString();
    console.log(elec);
    if( evento.keyCode==39){ //cuando se presiona la tacla abajo 				
        if(elec=='siguientePV'){//cuendo esta seleccionando el tipo documento
            console.log(document.getElementById('anteriorPV'));
            //document.getElementById('anteriorPv').click();
            document.getElementById('anteriorPV').focus();
            //document.getElementById('informes').select();
            return "";
            
        }
    }
  }

  function mi_funcion(){
      alert("carga");
  }