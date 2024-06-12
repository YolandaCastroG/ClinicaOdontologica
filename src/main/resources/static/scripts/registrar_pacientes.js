const form = document.getElementById("agregarForm");

form.addEventListener("submit", function (event) {
  event.preventDefault();

  const nombre = document.getElementById("nombre").value;
  const apellido = document.getElementById("apellido").value;
  const matricula = document.getElementById("dni").value;
  const fechaIngreso = document.getElementById("domicilio").value;

  // llamando al endpoint de agregar

  fetch(`/paciente`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ nombre, apellido, dni, fechaIngreso, domicilio}),
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
