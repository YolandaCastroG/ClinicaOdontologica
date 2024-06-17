const form = document.getElementById("agregarForm");
const apiURL = "http://localhost:8080";

form.addEventListener("submit", function (event) {
  event.preventDefault();

  // Recopila los datos del formulario
  const nombre = document.getElementById("nombre").value;
  const apellido = document.getElementById("apellido").value;
  const dni = document.getElementById("dni").value;
  const fechaIngreso = document.getElementById("fechaIngreso").value;
  const calle = document.getElementById("calle").value;
  const numero = document.getElementById("numero").value;
  const localidad = document.getElementById("localidad").value;
  const provincia = document.getElementById("provincia").value;

  // Crea el objeto JSON
  const pacienteData = {
    nombre,
    apellido,
    dni,
    fechaIngreso,
    domicilio: {
      calle,
      numero,
      localidad,
      provincia,
    },
  };
  console.log(pacienteData);

  fetch(`${apiURL}/paciente`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },

    body: JSON.stringify(pacienteData),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert("Paciente agregado con éxito");
      form.reset(); // Resetear el formulario
    })
    .catch((error) => {
      console.error("Error agregando paciente:", error);
    });
});
