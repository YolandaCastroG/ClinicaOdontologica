/*window.addEventListener('load', function () {


    const formulario = document.querySelector('#add_new_turno');


    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        

        const formData = {
            paciente: {
                id: document.querySelector('#paciente').value
            },
            odontologo: {
                id: document.querySelector('#odontologo').value
            },
            fecha: document.querySelector('#fecha').value
        };

        const url = '/turno';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Turno agregado </div>'

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();

            })
            .catch(error => {

                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";

                resetUploadForm();
            })
    });

    const resetUploadForm = () => {
        document.querySelector('#paciente').value = "";
        document.querySelector('#odontologo').value = "";
        document.querySelector('#fecha').value = "";
    }

    (function () {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "../consultar_turnos.html.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});*/

/*
const form = document.querySelector('#add_new_turno');

form.addEventListener('submit', function (event) {
  event.preventDefault();

  const pacienteId = document.querySelector('#paciente').value;
  const odontologoId = document.querySelector('#odontologo').value;
  const fecha = document.querySelector('#fecha').value;

  // Llamando al endpoint para agregar turno
  fetch(`/turno`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ paciente: { id: pacienteId }, odontologo: { id: odontologoId }, fecha }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      const successAlert = '<div class="alert alert-success alert-dismissible">' +
        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
        '<strong></strong> Turno agregado </div>';
      document.querySelector('#response').innerHTML = successAlert;
      document.querySelector('#response').style.display = 'block';
      resetUploadForm();
    })
    .catch((error) => {
      console.error('Error agregando turno:', error);
      const errorAlert = '<div class="alert alert-danger alert-dismissible">' +
        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
        '<strong> Error intente nuevamente</strong> </div>';
      document.querySelector('#response').innerHTML = errorAlert;
      document.querySelector('#response').style.display = 'block';
      resetUploadForm();
    });
});

const resetUploadForm = () => {
  document.querySelector('#paciente').value = '';
  document.querySelector('#odontologo').value = '';
  document.querySelector('#fecha').value = '';
};

(function () {
  const pathname = window.location.pathname;
  if (pathname === '/') {
    document.querySelector('.nav .nav-item a:first-child').classList.add('active');
  } else if (pathname === 'consultar_turnos.html') {
    document.querySelector('.nav .nav-item a:last-child').classList.add('active');
  }
})();
*/
