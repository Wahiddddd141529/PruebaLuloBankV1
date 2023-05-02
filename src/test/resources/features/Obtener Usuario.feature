Feature: Obtener Usuario

  @GetUsers
  Scenario: Obtener los usuarios asociados a la API dummyapi
    Given deseo obtener los usuarios registrados en la API
    When ejecute la peticion y visualice los usuarios registrados
    Then se obtiene el codigo de respuesta 200