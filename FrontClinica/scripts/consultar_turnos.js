window.addEventListener('load', function () {
    listar();
    function listar() {

        const url = '/turno';
        const settings = {
            method: 'GET'
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                for (turno of data) {

                    var table = document.getElementById("turnoTable");
                    var turnoRow = table.insertRow();
                    let tr_id = 'tr_' + turno.id;
                    turnoRow.id = tr_id;



                    let deleteButton = '<button' +
                        ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                        ' type="button" onclick="deleteBy(' + turno.id + ')" class="btn btn-danger btn_delete">' +
                        '&times' +
                        '</button>';


                    let updateButton = '<button' +
                        ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                        ' type="button" onclick="findBy(' + turno.id + ')" class="btn btn-info btn_id">' +
                        turno.id +
                        '</button>';


                    turnoRow.innerHTML =
                        '<td class=\"td_id\">' + turno.id + '</td>' +
                    '<td class=\"td_paciente\">' + turno.paciente_id + '</td>' +
                    '<td class=\"td_odontologo\">' + turno.odontologo_id + '</td>' +
                    '<td class=\"td_fecha\">' + turno.fecha + '</td>' +
                    '<td class=\"td_pacientenombre\">' + turno.nombre_paciente.toUpperCase() + '</td>' +
                    '<td class=\"td_odontologonombre\">' + turno.nombre_odontologo.toUpperCase() + '</td>' +
                        '<td>' + updateButton + '</td>' +
                        '<td>' + deleteButton + '</td>';

                };

            })
    }

    (function () {
        let pathname = window.location.pathname;
        if (pathname == "./consultar_turnos.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })
})