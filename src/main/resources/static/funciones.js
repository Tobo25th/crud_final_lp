function eliminar(id) {
  // const token = document.querySelector('meta[name="_csrf"]').getAttribute('content');
  // const header = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
  swal({
    title: "Esta seguro de Eliminar?",
    text: "",
    icon: "warning",
    buttons: true,
    dangerMode: true,
  }).then((OK) => {
    if (OK) {
    
      $.ajax({
        url: "/viviendas/" + id,
        success: function (res) {
          console.log(res);
          location.href = "/viviendas";
          swal({
            title: "¡Eliminado!",
            text: "La vivienda ha sido eliminada satisfactoriamente.",
            icon: "success",
            buttons:{
              confirm: {
              text: "Aceptar",
              value: true,
              visible: true,
              className: "",
              closeModal: true,
            }, 
          }
        }).then((confirm) => {
          if(confirm){
            location.href = "/viviendas";
          }
          
          });
        },
      });
    }
  });
}

